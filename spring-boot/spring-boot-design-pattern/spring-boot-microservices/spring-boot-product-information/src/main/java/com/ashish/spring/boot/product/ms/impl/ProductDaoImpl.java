package com.ashish.spring.boot.product.ms.impl;

import com.ashish.spring.boot.common.reader.JsonFileReader;
import com.ashish.spring.boot.pojo.dto.OrderDetailsDTO;
import com.ashish.spring.boot.product.ms.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private JsonFileReader jsonFileReader;

    @Override
    public OrderDetailsDTO fetchProductInformationByProdId(String productId) {
        String filePath = "product/product_"+productId+"_details.json";
        OrderDetailsDTO orderDetailsDTO =new OrderDetailsDTO();
        jsonFileReader.fileToJObject(filePath, orderDetailsDTO);
        return orderDetailsDTO;
    }
}
