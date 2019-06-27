package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Product;
import com.cskaoyan14th.bean.ProductExample;
import com.cskaoyan14th.mapper.ProductMapper;
import com.cskaoyan14th.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> queryProductList() {
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andProductIdIsNotNull();
        List<Product> products = productMapper.selectByExample(example);
        return products;
    }
}
