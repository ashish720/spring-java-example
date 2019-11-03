package com.ashish.spring.boot.service.impl.java8;

import com.ashish.spring.boot.service.java8.Java8Features;
import com.ashish.spring.boot.service.java8.LembdaExpression;
import org.springframework.stereotype.Service;

@Service
public class Java8FeaturesImpl implements Java8Features {

    @Override
    public int addInteger(int a, int b) {
        //LembdaExpression add = (int x,int y)->{ return x+y;};
       // return add.addInteger(a,b);
        return 0;
    }

    @Override
    public void sayHello() {
/*        LembdaExpression add = ("hi")->{
            System.out.println("hi");
        };*/
    }
}
