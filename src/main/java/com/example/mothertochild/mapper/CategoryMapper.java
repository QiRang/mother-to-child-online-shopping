package com.example.mothertochild.mapper;

import com.example.mothertochild.entity.Category;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {

    //查询所有，不包括产品
    @Select("select * from category")
//    @Results({
//            @Result(id=true,column="categoryId",property="categoryId"),
//            @Result(property = "products", column = "categoryId",
//                    many = @Many(select = "com.example.mothertochild.mapper.ProductMapper.findProductByCategoryId"))
//    })
    List<Category> categoryList();

//    查询所有，包括产品
    @Select("select * from category")
    @Results({
            @Result(id=true,column="categoryId",property="categoryId"),
            @Result(property = "products", column = "categoryId",
                    many = @Many(select = "com.example.mothertochild.mapper.ProductMapper.findProductByCategoryId"))
    })
    List<Category> categoryAndProductList();
    //按页查询
    @Select("select * from category")
    Page<Category> categoryListWithPage();

    //查询单条记录
    @Select("select * from category where categoryName = #{categoryName}")
    Category getCategory(String categoryName);

    //查询单条记录
    @Select("select * from category where categoryId = #{categoryId}")
    Category getCategoryById(String categoryId);

    //插入一条记录
    @Options(useGeneratedKeys = true,keyProperty = "categoryId")
    @Insert("insert into category(categoryName,categoryIcon,createDate) values (#{categoryName},#{categoryIcon},#{createDate})")
    int insertCategory(Category category);

    //删除一条记录
    @Delete("delete from category where categoryId = #{categoryId}")
    int deleteCategory(int categoryId);

    //更改
    @Options(useGeneratedKeys = true,keyProperty = "categoryId")
    @Update("update category set categoryName= #{categoryName},categoryIcon = #{categoryIcon} where categoryId = #{categoryId}")
    public int updateCategory(Category category);

}
