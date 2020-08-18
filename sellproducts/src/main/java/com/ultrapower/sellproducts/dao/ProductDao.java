package com.ultrapower.sellproducts.dao;

import com.ultrapower.sellproducts.model.Product;
import com.ultrapower.sellproducts.model.Test;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 2020/4/2
 * Time: 10:43
 * Description:
 */
@Mapper
@Repository
public interface ProductDao {

    @Select("select * FROM product")
    List<Product> listProducts();

    @Select("select * from product where id = #{id}")
    Product getProductById(@Param("id") Long productId);

    @Update("update product set stock = stock-1 where id = #{id} and stock > 0")
    int deductProductStock(@Param("id") Long productId);

    @Insert("insert into proudct(id,name,price,stock,pic) values (#{id},#{name},#{price},#{stock},#{pic})")
    void save(Product product);

    @Update("update product set name = #{name},price = #{price},stock = #{stock},pic = #{pic} where id = #{id}")
    void update(Product product);

    @Delete("delete from product where id=#{id}")
    void delete(@Param("id") Long id);
    @Insert("insert into test(val,source) values (#{val},#{source})")
    void add(Test test);
    @Update("update test set val = #{val} ,source = #{source} where id = #{i}")
    void updateTest(int i, int val, int source);
}
