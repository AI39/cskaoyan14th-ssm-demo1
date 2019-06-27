package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Product;
import com.cskaoyan14th.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("get/{pid}")
    @ResponseBody
    public Product getProduct(@PathVariable("pid") String pid){
        Product product = productService.queryProductById(pid);
        return product;
    }
}
