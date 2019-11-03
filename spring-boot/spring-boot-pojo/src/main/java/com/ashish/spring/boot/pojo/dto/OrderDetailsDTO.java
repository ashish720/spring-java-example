package com.ashish.spring.boot.pojo.dto;

public class OrderDetailsDTO {

    private OrderDTO order;
    private String productId;
    private String productName;
    private String producModel;
    private String productPrice;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProducModel() {
        return producModel;
    }

    public void setProducModel(String producModel) {
        this.producModel = producModel;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
