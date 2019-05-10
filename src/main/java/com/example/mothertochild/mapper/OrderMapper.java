package com.example.mothertochild.mapper;

import com.example.mothertochild.entity.Category;
import com.example.mothertochild.entity.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface OrderMapper {
    //查询所有
    @Select("select * from orders")
    List<Order> orderList();

    //查询单条记录
    @Select("select * from orders where orderId = #{orderId}")
    Order getOrder(int orderId);

    //插入一条记录
    //@Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into orders(createDate,payDate,deliveryDate,confirmDate,status) values (#{createDate},#{payDate},#{deliveryDate},#{confirmDate},#{status})")
    int insertOrder(Order order);

    //删除一条记录
    @Delete("delete from orders where orderId = #{orderId}")
    int deleteOrder(int orderId);

}
