package com.ashish.spring.boot.product.ms.impl;

import com.ashish.spring.boot.pojo.dto.OrderDetailsDTO;
import com.ashish.spring.boot.product.ms.ProductDao;
import com.ashish.spring.boot.product.ms.ProductInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductInformationServiceImpl implements ProductInformationService {

    @Autowired
    private ProductDao productDao;

    @Override
    public OrderDetailsDTO fetchProductInformations(String productId) {
        return productDao.fetchProductInformationByProdId(productId);
    }
}
