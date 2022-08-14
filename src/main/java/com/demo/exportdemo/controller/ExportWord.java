package com.demo.exportdemo.controller;

import com.demo.exportdemo.domain.Product;
import fr.opensagres.xdocreport.converter.XDocConverterException;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.preprocessor.IXDocPreprocessor;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldMetadata;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController()
@Controller
public class ExportWord {

    @RequestMapping("/eWord")
    public void eWord() throws IOException, XDocReportException {
        generateWord();
    }

    public void generateWord() throws IOException, XDocReportException {

        //模板路径在项目的resources下
        InputStream ins = this.getClass().getResourceAsStream("/template/wordTemplate.docx");

        //注册xdocreport实例并加载FreeMaker模板引擎
        IXDocReport report = XDocReportRegistry.getRegistry().loadReport(ins, TemplateEngineKind.Freemarker);

        //创建xdocreport上下文对象
        IContext context = report.createContext();

        //创建需要替换的文本变量
        context.put("boss","瀚潮");
        context.put("employee", "员工");
        context.put("date", "2020-08-01");
        context.put("address", "上海市");
        context.put("sex", "性别");
        context.put("employeeID", 2874036);
        context.put("nation", "汉");
        context.put("cultureLevel", "本科");
        context.put("workType", "程序员");


        List<Product> productList =  new ArrayList<Product>();
        for (int i = 0; i < 5; i++) {
            Product product = new Product();
            product.setId(Long.valueOf(i));
            product.setProdPrice(i);
            product.setProdCode(String.valueOf(i*2));
            product.setProdName("产品"+String.valueOf(i));
            //product.setCreateTime(new Date());
            //product.setUpdateTime(new Date());
            productList.add(product);
        }
        context.put("Product",productList);

        //创建字段元数据
        FieldsMetadata fm = report.createFieldsMetadata();
        //Word模板中的表格数据对应的集合类型
        fm.load("Product",Product.class,true);

        //输出到本地目录
        FileOutputStream out = new FileOutputStream(new File("D://合同.docx"));
        report.process(context,out);

        //浏览器端下载
//        response.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
//        response.setContentType("application/msword");
//        String fileName = "商品销售报表.docx";
//        response.setHeader("Content-Disposition", "attachment;filename="
//                .concat(String.valueOf(URLEncoder.encode(fileName, "UTF-8"))));
//        report.process(context, response.getOutputStream());




    }


}
