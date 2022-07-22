package com.demo.exportdemo.controller;

import com.demo.exportdemo.domain.Test;
import com.demo.exportdemo.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Value("${test.hello:TEST}")
    private String name;

    @Resource
    private TestService testService;

    @RequestMapping ("/hello")
    public  String hello(){
        return "恭喜你，已经成功的迈出第一步";
    }

    @RequestMapping ("/hello/post")
    public  String helloPost(){
        return "恭喜你，又学到了一些新东西："+name;
    }

    @GetMapping("/test/list")
    public List<Test> list(){
        return testService.list();
    }

}
