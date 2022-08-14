package com.demo.exportdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController()
@Controller
public class ExportProperty  {

    @RequestMapping("/readTxt")
    public List<String> readTxt(String filePath) throws IOException {
        List<String> list = new ArrayList<>();
        FileInputStream fis  = new FileInputStream(filePath);
         InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
         BufferedReader br  = new BufferedReader(isr);
         String line = "";
         while ((line = br.readLine())  != null ){
             if(list.add(line));
        }
        br.close();
         isr.close();
         fis.close();
         return list;
    }




}
