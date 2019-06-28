package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Product;
import com.cskaoyan14th.service.ProductService;
import com.cskaoyan14th.util.ToolbarButtons;
import com.cskaoyan14th.vo.ResponseVo;
import com.cskaoyan14th.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @RequestMapping("find")
    public String find(HttpServletRequest request){
        List<String> sysPermissionList = new ToolbarButtons("product").getSysPermissionList();
        request.getSession().setAttribute("sysPermissionList",sysPermissionList);
        return "WEB-INF/jsp/product_list";
    }
    @RequestMapping("list")
    @ResponseBody
    public Vo<Product> getList(int page, int rows){
        Vo<Product> productList = productService.queryProductListPage(page,rows);
        return productList;
    }

    /*
    增加产品的三个请求
     */
    @RequestMapping("add_judge")
    @ResponseBody
    public String addJudge(){
        return "";
    }
    @RequestMapping("add")
    public String add(){
        return "WEB-INF/jsp/product_add";
    }
    @RequestMapping("insert")
    @ResponseBody
    public ResponseVo insert(Product product){
        ResponseVo responseVo = new ResponseVo();
        int insert = productService.addProduct(product);
        if (insert == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else if (insert == 0){
            responseVo.setStatus(0);
            responseVo.setMsg("产品编号已经存在！请更改");
        }else {
            responseVo.setStatus(400);
            responseVo.setMsg("服务器错误，请稍后再试");
        }
        return responseVo;
    }

    /*
    修改产品的3个请求
     */
    @RequestMapping("edit_judge")
    @ResponseBody
    public String editJudge(){
        return "";
    }
    @RequestMapping("edit")
    public String edit(){
        return "WEB-INF/jsp/product_edit";
    }
    @RequestMapping("update_all")
    @ResponseBody
    public ResponseVo updateProduct(Product product){
        ResponseVo responseVo = new ResponseVo();
        int update = productService.updateProduct(product);
        if (update == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else if (update == 0){
            responseVo.setStatus(0);
            responseVo.setMsg("修改失败");
        }else {
            responseVo.setStatus(500);
            responseVo.setMsg("服务器错误，请稍后再试");
        }
        return responseVo;
    }

    /*
    删除产品
     */
    @RequestMapping("delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "";
    }
    @RequestMapping("delete_batch")
    @ResponseBody
    public ResponseVo deleteProducts(String[] ids){
        ResponseVo responseVo = new ResponseVo();
        int delete = productService.deleteProductsByIds(ids);
        if (delete > 0){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("删除失败");
        }
        return responseVo;
    }

    /*
    模糊查询
     */
    @RequestMapping("search_product_by_productId")
    @ResponseBody
    public Vo<Product> searchProductByProductId(String searchValue,int page,int rows){
        Vo<Product> productList = productService.queryProductsByProductId(searchValue,page,rows);
        return productList;
    }
    @RequestMapping("search_product_by_productName")
    @ResponseBody
    public Vo<Product> searchProductByProductName(String searchValue,int page,int rows){
        Vo<Product> productList = productService.queryProductsByProductName(searchValue,page,rows);
        return productList;
    }
    @RequestMapping("search_product_by_productType")
    @ResponseBody
    public Vo<Product> searchProductByProductType(String searchValue,int page,int rows){
        Vo<Product> productList = productService.queryProductsByProductType(searchValue,page,rows);
        return productList;
    }
}
