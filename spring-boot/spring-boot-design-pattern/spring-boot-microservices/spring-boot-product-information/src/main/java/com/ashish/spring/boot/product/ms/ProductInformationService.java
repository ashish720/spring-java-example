package com.ashish.spring.boot.product.ms;

import com.ashish.spring.boot.pojo.dto.OrderDetailsDTO;


public interface ProductInformationService{

    OrderDetailsDTO fetchProductInformations(String productId);

}
