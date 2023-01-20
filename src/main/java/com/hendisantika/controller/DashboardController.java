package com.hendisantika.controller;

import com.hendisantika.model.FilesReceivedDto;
import com.hendisantika.service.CbaStatusReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class DashboardController {
    private final String appMode;

    @Autowired
    private CbaStatusReportsService cbaStatusReportsService;

    @Autowired
    public DashboardController(Environment environment) {
        appMode = environment.getProperty("app-mode");
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "@integration");
        model.addAttribute("projectname", "WebApp");
        model.addAttribute("mode", appMode);

        Map<String, List<FilesReceivedDto>> files = cbaStatusReportsService.getLatestFiveFilesReceived();
        model.addAttribute("filesReceived", files.get("okList"));
        model.addAttribute("filesFailures", files.get("errorList"));
        model.addAttribute("chart", cbaStatusReportsService.getDashboardChart());
        return "dashboard";
    }

    @ResponseBody
    @GetMapping("/joblog/{filelogId}")
    public String index(@PathVariable String filelogId) {
        return "";
    }
}
