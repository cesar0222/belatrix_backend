package com.belatrix.jobLogger.controller;

import com.belatrix.jobLogger.model.LogEntity;
import com.belatrix.jobLogger.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @Autowired
    LogService service;

    @RequestMapping({"/",""})
    public String showLog(Model model) {
        model.addAttribute("logs",service.getAllLogs());
        return "logViewer";
    }

    @RequestMapping({"/add",""})
    public String addEditLog(Model model) {
        model.addAttribute("log",new LogEntity());
        return "addLog";
    }
}
