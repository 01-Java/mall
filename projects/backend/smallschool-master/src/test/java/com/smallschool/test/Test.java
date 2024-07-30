package com.smallschool.test;

import com.smallschool.mapper.ProductDetailsMapper;
import com.smallschool.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test {
    @Autowired
    private ProductDetailsService productDetailsService;
    @org.junit.Test
    public void test1() {

    }
}
