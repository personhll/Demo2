package com.demo.exportdemo.service;

import com.demo.exportdemo.domain.Product;
import com.demo.exportdemo.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductService {

    @Resource
    private ProductMapper productMapper;

    public List<Product> list(){
        return productMapper.selectByExample(null);
    }

    public int save(List<Product> cachedDataList) {
        return productMapper.insertBatch(cachedDataList);

    }
}