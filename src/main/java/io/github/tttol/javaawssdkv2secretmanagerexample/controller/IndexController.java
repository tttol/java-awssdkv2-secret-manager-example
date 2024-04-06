package io.github.tttol.javaawssdkv2secretmanagerexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.tttol.javaawssdkv2secretmanagerexample.service.AwsService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class IndexController {
    private final AwsService awsService;
    
    @GetMapping("/sample")
    public String sample() {
        return "Hello Secret Manager Example!";
    }

    @GetMapping("/get")
    public String index() {
        return awsService.getSecret(); 
    }  

}
