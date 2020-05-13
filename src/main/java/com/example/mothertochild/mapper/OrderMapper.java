package com.example.mothertochild.mapper;

import com.example.mothertochild.entity.Category;
import com.example.mothertochild.entity.Order;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;


@Mapper
public interface OrderMapper {
    //查询所有
    @Select("select * from orders order by orderId desc")
    @Results({
            @Result(id=true,column="orderId",property="orderId"),
            @Result(property = "orderItems",column = "orderId",
            many = @Many(select = "com.example.mothertochild.mapper.OrderItemMapper.findOrderItemByOrderId"))
    })
    Page<Order> orderList();
    //查询结果无误，但是order的orderId属性丢失了,加上@Result(id=true,column="orderId",property="orderId")就可以了

    //查询单条记录
    @Select("select * from orders where orderId = #{orderId}")
    Order getOrder(int orderId);

    //插入一条记录
    @Options(useGeneratedKeys = true,keyProperty = "orderId")
//    @Insert("insert into orders(createDate,describe,receiver,mobile) values (#{createDate},#{describe},#{receiver},#{mobile})")
    @Insert({"insert into orders(createDate,userId,describes,receiver,mobile,address,height, weight,shoulder,bust,waist,hipline)" +
            "values (#{createDate},#{userId},#{describes},#{receiver},#{mobile},#{address},#{height},#{weight},#{shoulder},#{bust},#{waist},#{hipline})"})
    int insertOrder(Order order);
    //int insertOrder(Date createDate, String receiver, String mobile);

    //删除一条记录
    @Delete("delete from orders where orderId = #{orderId}")
    int deleteOrder(int orderId);

    @Select("select * from orders where userId = #{userId} order by orderId desc")
    @Results({
            @Result(id=true,column="orderId",property="orderId"),
            @Result(property = "orderItems",column = "orderId",
                    many = @Many(select = "com.example.mothertochild.mapper.OrderItemMapper.findOrderItemByOrderId"))
    })
    List<Order> getUserOrder(int userId);

    @Select("select * from orders where orderId = #{orderId}")
    @Results({
            @Result(id=true,column="orderId",property="orderId"),
            @Result(property = "orderItems",column = "orderId",
                    many = @Many(select = "com.example.mothertochild.mapper.OrderItemMapper.findOrderItemByOrderId"))
    })
    Order getUserOrderByOrderId(int orderId);

}
