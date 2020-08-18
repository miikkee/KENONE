package com.ultrapower.sellproducts.service;

import com.ultrapower.sellproducts.dao.ProductDao;
import com.ultrapower.sellproducts.model.Product;
import com.ultrapower.sellproducts.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 2020/4/1
 * Time: 23:34
 * Description:
 */
@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Product> listProducts(){
        return productDao.listProducts();
    }

    public Product getProductById(Long productId) {
        return productDao.getProductById(productId);
    }
    @Transactional
    public int deductProductStock(Long productId) {
        return productDao.deductProductStock(productId);
    }
    @Transactional
    public void save(Product product) {
         productDao.save(product);
    }
    @Transactional
    public void update(Product product) {
         productDao.update(product);
    }
    @Transactional
    public void delete(Long id) {
         productDao.delete(id);
    }

    public void secKill(Long productId) {
    }

    public void insertData() {
        Test test = new Test();
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            int val = random.nextInt(10);
            test.setVal(val);
           test.setSource(random.nextInt(100));
           productDao.add(test);
        }
    }

    public void updateData() {
        Random random = new Random();
        for (int i = 1; i < 12548; i++) {
            productDao.updateTest(i,random.nextInt(10),random.nextInt(100));
        }
    }
}
