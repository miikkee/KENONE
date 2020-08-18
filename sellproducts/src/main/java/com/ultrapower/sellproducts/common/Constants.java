package com.ultrapower.sellproducts.common;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 2020/4/2
 * Time: 14:51
 * Description:
 */
public class Constants {

    public static final  String REDIS_PRODUCT_PREFIX = "product_";

    public static final  String REDIS_PRODUCT_STOCK_PREFIX = "product_stock_";

    public static final  String ZK_PRODUCT_SOLD_OUT_FLAG = "/product_sold_out_flag";

    public static final  String change = "OK";

    public static   String  getZkSoldOutProductFlag(Long productId){
        return ZK_PRODUCT_SOLD_OUT_FLAG+"/"+productId;
    }


}
