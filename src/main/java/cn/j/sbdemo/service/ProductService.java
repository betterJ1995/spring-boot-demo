package cn.j.sbdemo.service;

import cn.j.sbdemo.common.PageUtils;
import cn.j.sbdemo.dao.ProductDao;
import cn.j.sbdemo.dao.UserBusinessDao;
import cn.j.sbdemo.entity.Product;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * created on 2018/11/19
 *
 * @author J
 **/
@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private UserBusinessDao userBusinessDao;

    @Transactional(rollbackFor = Exception.class)
    public void addProduct(String name) {
        productDao.selectByPrimaryKey(1);

        userBusinessDao.selectByPrimaryKey(1);

        Product product = new Product();
        product.setBusinessId(11).setDetail(name).setNum(5).setPrice(BigDecimal.TEN);
        productDao.insert(product);

        userBusinessDao.selectByPrimaryKey(2);
        userBusinessDao.selectAll();
        productDao.selectAll();
    }


    public void addProductNoT(String name) {
        productDao.selectByPrimaryKey(1);

        userBusinessDao.selectByPrimaryKey(1);

        Product product = new Product();
        product.setBusinessId(11).setDetail(name).setNum(5).setPrice(BigDecimal.TEN);
        productDao.insert(product);

        userBusinessDao.selectByPrimaryKey(2);
        userBusinessDao.selectAll();
        productDao.selectAll();
    }

    public Page pageProduct(int pageNum, int pageSize) {
        PageUtils.page(pageNum, pageSize);
        return (Page) productDao.pageProduct();
    }
}
