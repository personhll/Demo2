package com.demo.exportdemo.controller;

import com.alibaba.excel.EasyExcel;
import com.demo.exportdemo.domain.Product;
import com.demo.exportdemo.listener.ProductDataListerner;
import com.demo.exportdemo.mapper.ProductMapper;
import com.demo.exportdemo.service.ProductService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.*;
import java.util.List;

@RestController()
public class ProductController {

    @Resource
    private ProductMapper productMapper;

    @Resource
    private ProductService productService;


    @GetMapping("/product/list")
    public List<Product> list(){
        return productService.list();
    }

    @RequestMapping("/product/read")
    public void read(){
        //InputStream filename = this.getClass().getResourceAsStream("/template/excelRead.xlsx");
        String filename = "D:\\WorkSpace\\Demo\\Demo2\\src\\main\\resources\\template\\excelRead.xlsx";
        EasyExcel.read(filename,Product.class, new ProductDataListerner(productMapper)).sheet().doRead();
        //EasyExcel.read(filename,Product.class,new PageReadListener<Product>());
    }

    @RequestMapping("/product/createExcel")
    public String createExcel(){
        Workbook wb = new HSSFWorkbook();
        Sheet sheet1 = wb.createSheet("new sheet");
        Sheet sheet2 = wb.createSheet("second sheet");
        Sheet sheet3 = wb.createSheet("third sheet");
        Sheet sheet4 = wb.createSheet("fourth sheet");
// Freeze just one row
        sheet1.createFreezePane( 0, 1, 0, 1 );
// Freeze just one column
        sheet2.createFreezePane( 1, 0, 1, 0 );
// Freeze the columns and rows (forget about scrolling position of the lower right quadrant).
        sheet3.createFreezePane( 2, 2 );
// Create a split with the lower left side being the active quadrant
        sheet4.createSplitPane( 2000, 2000, 0, 0, Sheet.PANE_LOWER_LEFT );
        try (OutputStream fileOut = new FileOutputStream("D://FoxDownload/workbook.xls")) {
            wb.write(fileOut);
            fileOut.close();
            return "创建文件成功";
        } catch (IOException e) {
            e.printStackTrace();
            return "没有创建文件";
        }
    }


}
