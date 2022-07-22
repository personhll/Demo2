package com.demo.exportdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {

    @Value("${test.hello:TEST}")
    private String name;

    @RequestMapping ("/hello")
    public  String hello(){
        return "恭喜你，已经成功的迈出第一步";
    }

    @RequestMapping ("/hello/post")
    public  String helloPost(){
        return "恭喜你，又学到了一些新东西："+name;
    }

}
