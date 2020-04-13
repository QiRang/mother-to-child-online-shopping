package com.example.mothertochild.mapper;

import com.example.mothertochild.entity.Product;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    /**
     * 根据类别id查询所有商品
     */
    @Select("SELECT * FROM product WHERE categoryId = #{categoryId}")
    List<Product> findProductByCategoryId(int categoryId);

    //按名单条查询
    @Select("select * from product where productName = #{productName}")
    Product findProductByName(String productName);

    //查询所有,并查出每个商品所属的类别
    @Select("select * from product")
    @Results({
            @Result(property = "category",column = "categoryId",
                    one = @One(select = "com.example.mothertochild.mapper.CategoryMapper.getCategoryById"))
    })
    Page<Product> productList();
    //按id单条查询
    @Select("select * from product where productId = #{productId}")
    Product findProductById(int productId);
    //插入一条记录
    @Options(useGeneratedKeys = true,keyProperty = "productId")
    @Insert("insert into product(categoryId,productName,price,stock,describes,productImages,createDate) values (#{categoryId},#{productName},#{price},#{stock},#{describes},#{productImages},#{createDate})")
    int addProduct(Product product);
    //删除一条记录
    @Delete("delete from product where productId = #{productId}")
    int deleteProduct(int productId);
    //更改库存
    @Update("update product set stock = #{stock} where productId = #{productId}")
    public int updateStock(int productId,int stock);
    //更改图片
    @Update("update product set productImages=#{productImages} where productId = #{productId}")
    public int updataProductImages(int productId,String productImages);

//    更新产品
    @Update("update product set productName=#{productName},price= #{price},stock = #{stock},describes = #{describes} where productId = #{productId}")
    public int updateProduct(Product product);
}
