package com.demo.exportdemo.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.CellExtra;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.fastjson.JSON;
import com.demo.exportdemo.Utils.ListUtils;
import com.demo.exportdemo.domain.Product;
import com.demo.exportdemo.mapper.ProductMapper;
import com.demo.exportdemo.service.ProductService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Slf4j
public class ProductDataListerner implements ReadListener<Product> {


    private ProductMapper productMapper;

    //private ProductService productService;

    /**
     * 每隔5条存储数据库，清理list，方便内存回收
     */
    private static final int BATCH_COUNT = 100;

    /**
     * 缓存的数据
     */
    private List<Product> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

    //private ProductMapper productMapper;
//    public ProductDataListerner(ProductMapper productMapper){
//        this.productMapper = productMapper;
//    }


    public ProductDataListerner(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public void onException(Exception e, AnalysisContext analysisContext) throws Exception {

    }

    @Override
    public void invokeHead(Map<Integer, CellData> map, AnalysisContext analysisContext) {

    }

    /**
     * 每解析一条，调用
     * @param productData
     * @param analysisContext
     */
    @Override
    public void invoke(Product productData, AnalysisContext analysisContext) {
        log.info("解析到一条数据：{}", JSON.toJSONString(productData));
        cachedDataList.add(productData);

        if(cachedDataList.size() >=  BATCH_COUNT){
            saveData();
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    @Override
    public void extra(CellExtra cellExtra, AnalysisContext analysisContext) {

    }

    /**
     * 所有数据解析完调用
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
        log.info("所有数据解析完成！");
    }

    @Override
    public boolean hasNext(AnalysisContext analysisContext) {
        return false;
    }
    /**
     * 加上存储数据库
     */
    private  void saveData(){
        log.info("{}条数据，开始存储数据库！",cachedDataList.size());
        productMapper.insertBatch(cachedDataList);
        log.info("存储数据成功");
    }


}
