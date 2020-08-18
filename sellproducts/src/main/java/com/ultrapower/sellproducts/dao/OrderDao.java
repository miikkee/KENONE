package com.ultrapower.sellproducts.dao;


import com.sun.org.apache.xpath.internal.operations.Or;
import com.ultrapower.sellproducts.model.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 2020/4/2
 * Time: 10:10
 * Description:
 */
@Mapper
@Repository
public interface OrderDao {
    @Select("SELECT * FROM SECKILLORDER")
    List<Order>  listOrders();

    @Select("SELECT * FROM SECKILLORDER WHERE ID = #{id}")
    Order getOrderById(@Param("id") Long id);

    @Update("update SECKILLORDER set productId = #{productId},amount = #{amount} where id = #{id}")
    void update(Order order);

    @Delete("delete from SECKILLORDER where id = #{id}")
    void deleteOrder(@Param("id") Long id);

    @Insert("Insert into SECKILLORDER(id,productId,amount) values (#{id},#{productId},#{amount})")
    void saveOrder(Order order);
}
