package com.demo.exportdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping ("/hello")
    public  String hello(){
        return "恭喜你，已经成功的迈出第一步";
    }

}
