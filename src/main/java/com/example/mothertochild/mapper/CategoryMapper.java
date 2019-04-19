package com.example.mothertochild.mapper;

import com.example.mothertochild.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {

//    //查询所有
//    @Select("select * from category")
//    List<Category> categoryList();
//
//    //查询单条记录
//    @Select("select * from category where name = #{name}")
//    Category getCategory(String name);
//
//    //插入一条记录
//    //@Options(useGeneratedKeys = true,keyProperty = "id")
//    @Insert("insert into category(name) values (#{name})")
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
