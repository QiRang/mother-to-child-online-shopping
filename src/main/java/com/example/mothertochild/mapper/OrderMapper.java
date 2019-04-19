package com.example.mothertochild.mapper;

import com.example.mothertochild.entity.Category;
import com.example.mothertochild.entity.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface OrderMapper {
//    //查询所有
//    @Select("select * from ordera")
//    List<Order> orderList();
//
//    //查询单条记录
//    @Select("select * from ordera where orderId = #{orderId}")
//    Category getCategory(int orderId);
//
//    //插入一条记录
//    //@Options(useGeneratedKeys = true,keyProperty = "id")
//    @Insert("insert into order(name) values (#{name})")
//    int insertCategory(String name);
//
//    //删除一条记录
//    @Delete("delete from category where id = #{id}")
//    int deleteCategory(int id);
//
//    //更改
//    @Update("update category set name= #{name} where id = #{id}")
//    public int updateCategory(int id,  String name);
}
