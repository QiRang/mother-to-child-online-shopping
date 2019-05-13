package com.example.mothertochild.mapper;

import com.example.mothertochild.entity.Category;
import com.example.mothertochild.entity.Order;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;


@Mapper
public interface OrderMapper {
    //查询所有
    @Select("select * from orders")
    @Results({
            @Result(id=true,column="orderId",property="orderId"),
            @Result(property = "orderItems",column = "orderId",
            many = @Many(select = "com.example.mothertochild.mapper.OrderItemMapper.findOrderItemByOrderId"))
    })
    List<Order> orderList();
    //查询结果无误，但是order的orderId属性丢失了,加上@Result(id=true,column="orderId",property="orderId")就可以了

    //查询单条记录
    @Select("select * from orders where orderId = #{orderId}")
    Order getOrder(int orderId);

    //插入一条记录
    @Options(useGeneratedKeys = true,keyProperty = "orderId")
//    @Insert("insert into orders(createDate,describe,receiver,mobile) values (#{createDate},#{describe},#{receiver},#{mobile})")
    @Insert("insert into orders(createDate,receiver,mobile) values (#{createDate},#{receiver},#{mobile})")
    int insertOrder(Order order);
    //int insertOrder(Date createDate, String receiver, String mobile);

    //删除一条记录
    @Delete("delete from orders where orderId = #{orderId}")
    int deleteOrder(int orderId);

}
