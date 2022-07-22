package com.demo.exportdemo.service;

import com.demo.exportdemo.domain.Test;
import com.demo.exportdemo.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {

    @Resource
    private TestMapper testMapper;

    public List<Test> list(){
        return testMapper.list();
    }
}
