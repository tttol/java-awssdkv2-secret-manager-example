package io.github.tttol.javaawssdkv2secretmanagerexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.tttol.javaawssdkv2secretmanagerexample.service.AwsService;

@RestController
public class IndexController {
    @GetMapping("/sample")
    public String sample() {
        return "Hello Secret Manager Example!";
    }

    @GetMapping("/get")
    public String index() {
        return AwsService.getSecret(); 
    }  

}
