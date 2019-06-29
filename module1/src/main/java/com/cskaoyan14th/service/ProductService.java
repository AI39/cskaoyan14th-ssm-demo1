package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Product;
import com.cskaoyan14th.vo.Vo;

import java.util.List;

public interface ProductService {

    List<Product> queryProducts();
    Product queryProductById(String pid);

    Vo<Product> queryProductListPage(int page, int rows);

    int addProduct(Product product);

    int updateProduct(Product product);

    int deleteProductsByIds(String[] ids);

    Vo<Product> queryProductsByProductId(String searchValue, int page, int rows);

    Vo<Product> queryProductsByProductName(String searchValue, int page, int rows);

    Vo<Product> queryProductsByProductType(String searchValue, int page, int rows);
}
