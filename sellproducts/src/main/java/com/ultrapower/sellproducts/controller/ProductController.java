package com.ultrapower.sellproducts.controller;

import com.alibaba.fastjson.JSONObject;
import com.ultrapower.sellproducts.model.Product;
import com.ultrapower.sellproducts.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 2020/4/1
 * Time: 23:33
 * Description:
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static ConcurrentHashMap<String,Boolean> productSoldOutMap = new ConcurrentHashMap<>();

    private static ConcurrentHashMap<String,Boolean> getProductSoldOutMap(){
        return productSoldOutMap;
    }

    @RequestMapping("/list")
    public List<Product>  productList(){
        List<Product> products = productService.listProducts();
        //String pjson = JSONObject.toJSONString(products);
       // redisTemplate.opsForValue().set("productList",pjson);
        //String s = redisTemplate.opsForValue().get("productList");
       // System.out.println(s);
        return  products;
    }

    @RequestMapping("/{id}")
    public Product  findById(@PathVariable("id") Long id){
        return  productService.getProductById(id);
    }

    @RequestMapping("/insertData")
    public String  insertData(){
        productService.insertData();
        return "{msg:'信息插入完成,100W'}";
    }

    @RequestMapping("/updateData")
    public String  updateData(){
        productService.updateData();
        return "{msg:'信息更新完成,100W'}";
    }


}
