package com.example.mothertochild.mapper;

import com.example.mothertochild.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {

    //查询所有
    @Select("select * from category")
    @Results({
            @Result(property = "products", column = "categoryId",
                    many = @Many(select = "com.example.mothertochild.mapper.ProductMapper.findProductByCategoryId"))
    })
    List<Category> categoryList();

    //查询单条记录
    @Select("select * from category where categoryName = #{categoryName}")
    Category getCategory(String categoryName);

    //插入一条记录
    //@Options(useGeneratedKeys = true,keyProperty = "categoryId")//加了这句以后报错
    @Insert("insert into category(categoryName) values (#{categoryName})")
    int insertCategory(String categoryName);

    //删除一条记录
    @Delete("delete from category where categoryId = #{categoryId}")
    int deleteCategory(int categoryId);

    //更改
    @Update("update category set categoryName= #{categoryName} where categoryId = #{categoryId}")
    public int updateCategory(int categoryId,  String categoryName);

}
