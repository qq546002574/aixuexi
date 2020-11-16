package com.example.demo.controller;


import com.example.demo.common.utils.DataResult;
import com.example.demo.service.JenkinsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jenkins")
public class JenkinsController {

    @Autowired
    private JenkinsService jenkinsService;

    @RequestMapping(value = "/getAll", method = RequestMethod.POST)
    public DataResult getAll() {
        return DataResult.success(jenkinsService.getAll());
    }
}
