package com.example.mothertochild.mapper;

import com.example.mothertochild.entity.OrderItem;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderItemMapper {

    @Insert("INSERT INTO orderItem(productId,orderId,userId,number) values (#{productId},#{orderId},#{userId},#{number})")
    int insetOrderItem(OrderItem orderItem);

    @Select("select orderItemId,userId,number,productId from orderItem where orderId = #{orderId}")
    @Results({
            @Result(property = "product",column = "productId",
            one=@One(select = "com.example.mothertochild.mapper.ProductMapper.findProductById"))
    })
    List<OrderItem> findOrderItemByOrderId(int orderId);
}
