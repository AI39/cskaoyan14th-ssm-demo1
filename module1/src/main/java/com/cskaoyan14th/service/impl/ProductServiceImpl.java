package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Product;
import com.cskaoyan14th.bean.ProductExample;
import com.cskaoyan14th.mapper.ProductMapper;
import com.cskaoyan14th.service.ProductService;
import com.cskaoyan14th.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> queryProducts() {
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andProductIdIsNotNull();
        List<Product> products = productMapper.selectByExample(example);
        return products;
    }

    @Override
    public Product queryProductById(String pid) {
        Product product = productMapper.selectByPrimaryKey(pid);
        return product;
    }

    @Override
    public Vo<Product> queryProductListPage(int page, int rows) {
        PageHelper.startPage(page,rows);
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andProductIdIsNotNull();
        List<Product> list = productMapper.selectByExample(example);
        PageInfo<Product> pageInfo = new PageInfo<>(list);
        Vo<Product> productList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return productList;
    }

    @Override
    public int addProduct(Product product) {
        int insert = productMapper.insert(product);
        return insert;
    }

    @Override
    public int updateProduct(Product product) {
        int update = productMapper.updateByPrimaryKey(product);
        return update;
    }

    @Override
    public int deleteProductsByIds(String[] ids) {
        List<String> idList = new ArrayList<>();
        for (String id : ids) {
            idList.add(id);
        }
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andProductIdIn(idList);
        int delete = productMapper.deleteByExample(example);
        return delete;
    }
}
