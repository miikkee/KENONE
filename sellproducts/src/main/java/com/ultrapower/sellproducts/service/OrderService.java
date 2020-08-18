package com.ultrapower.sellproducts.service;


import com.ultrapower.sellproducts.dao.OrderDao;
import com.ultrapower.sellproducts.model.Order;
import com.ultrapower.sellproducts.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 2020/4/1
 * Time: 23:34
 * Description:
 */
@Service
 class OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductService productService;

    @Transactional
    public void updateOrder(Order order){
        orderDao.update(order);
    }

    @Transactional
    public void deleteOrder(Long id){
        orderDao.deleteOrder(id);
    }

    @Transactional
    public void secKill(Long productId){

      //获取该产品
     Product prodcut = productService.getProductById(productId);

     if (prodcut.getStock() <= 0){
         throw new RuntimeException("商品已售罄");
     }
     //创建订单
        Order order = new Order();
        order.setProductId(productId);
        order.setAmount(prodcut.getPrice());
        saveOrder(order);

        //减库存
        int updateNum = productService.deductProductStock(productId);
        if (updateNum <= 0){
            throw  new RuntimeException("商品已售完");
        }
    }

    private void saveOrder(Order order) {
        orderDao.saveOrder(order);
    }


}
