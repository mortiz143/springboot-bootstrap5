package com.hendisantika.controller;

import com.hendisantika.service.CbaStatusReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

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
        model.addAttribute("username", "@mortiz");
        model.addAttribute("projectname", "WebApp");
        model.addAttribute("mode", appMode);
        model.addAttribute("filesReceived", cbaStatusReportsService.getLatestFiveFilesReceived());
        model.addAttribute("filesFailures", cbaStatusReportsService.getLatestFiveFilesReceived());

        return "dashboard";
    }

    @ResponseBody
    @GetMapping("/joblog/{filelogId}")
    public String index(@PathVariable String filelogId) {
        return cbaStatusReportsService.getLatestFiveFilesReceived().get(0).getJobLog();
    }
}
