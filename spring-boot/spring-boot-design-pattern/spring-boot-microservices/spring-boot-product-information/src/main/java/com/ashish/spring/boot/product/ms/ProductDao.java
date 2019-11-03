package com.ashish.spring.boot.product.ms;

import com.ashish.spring.boot.pojo.dto.OrderDetailsDTO;

public interface ProductDao {

    OrderDetailsDTO fetchProductInformationByProdId(String productId);
}
