package com.demo.exportdemo.domain;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;

public class Product {
    private Long id;

    @ExcelProperty(value = "产品编码" ,index = 0)
    private String prodCode;

    @ExcelProperty(value = "产品名称" , index = 1)
    private String prodName;

    @ExcelProperty(value = "产品价格" ,index = 2)
    private Integer prodPrice;

    @ExcelProperty("生产日期")
    private Date createTime;

    @ExcelProperty("更新时间")
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public Integer getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(Integer prodPrice) {
        this.prodPrice = prodPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", prodCode=").append(prodCode);
        sb.append(", prodName=").append(prodName);
        sb.append(", prodPrice=").append(prodPrice);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}