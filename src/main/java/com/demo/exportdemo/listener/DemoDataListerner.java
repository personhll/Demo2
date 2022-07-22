package com.demo.exportdemo.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.CellExtra;
import com.alibaba.excel.read.listener.ReadListener;
import com.demo.exportdemo.main.DemoData;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class DemoDataListerner implements ReadListener<DemoData> {


    /**
     * 每隔5条存储数据库，清理list，方便内存回收
     */
    private static final int BATCH_COUNT = 100;

    @Override
    public void onException(Exception e, AnalysisContext analysisContext) throws Exception {

    }

    @Override
    public void invokeHead(Map<Integer, CellData> map, AnalysisContext analysisContext) {

    }

    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {

    }

    @Override
    public void extra(CellExtra cellExtra, AnalysisContext analysisContext) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    @Override
    public boolean hasNext(AnalysisContext analysisContext) {
        return false;
    }
    /**
     * 缓存的数据
     */

}
