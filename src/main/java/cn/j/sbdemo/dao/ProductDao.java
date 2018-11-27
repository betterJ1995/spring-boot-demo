package cn.j.sbdemo.dao;

import cn.j.sbdemo.entity.Product;
import org.apache.ibatis.annotations.CacheNamespaceRef;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@CacheNamespaceRef(ProductDao.class)
public interface ProductDao extends BaseMapper<Product> {

    Product selectId1();

    List pageProduct();

}