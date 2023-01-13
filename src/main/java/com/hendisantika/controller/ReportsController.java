package com.hendisantika.controller;

import com.hendisantika.service.CbaStatusReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

@Controller
public class ReportsController {
    private final String appMode;

    @Autowired
    private CbaStatusReportsService cbaStatusReportsService;

    @Autowired
    public ReportsController(Environment environment) {
        appMode = environment.getProperty("app-mode");
    }

    @GetMapping("/reports")
    public String index(Model model) {
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "@mortiz");
        model.addAttribute("projectname", "WebApp");
        model.addAttribute("mode", appMode);
        model.addAttribute("reports", cbaStatusReportsService.getCbaStatusReportDTOS());

        return "reports";
    }

    @GetMapping("/reports/{sourceFilename}")
    public String reports(Model model, @PathVariable String sourceFilename) {
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "@mortiz");
        model.addAttribute("projectname", "WebApp");
        model.addAttribute("mode", appMode);
        model.addAttribute("sourceFilename", sourceFilename);
        model.addAttribute("reports", cbaStatusReportsService.getReportFilesBySourceFilename(sourceFilename));

        return "report-details";
    }
}
