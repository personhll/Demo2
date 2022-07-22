package com.demo.exportdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {

    @RequestMapping ("/hello")
    public  String hello(){
        return "恭喜你，已经成功的迈出第一步";
    }

    @RequestMapping ("/hello/post")
    public  String helloPost(String name){
        return "恭喜你，又学到了一些新东西："+name;
    }

}
