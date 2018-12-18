package cn.j.sbdemo;

import cn.j.sbdemo.common.HttpUtils;
import cn.j.sbdemo.dao.ProductDao;
import cn.j.sbdemo.dao.UserBusinessDao;
import cn.j.sbdemo.entity.Product;
import cn.j.sbdemo.service.ProductService;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbDemoApplicationTests {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private UserBusinessDao userBusinessDao;
    @Autowired
    private ProductService productService;

    @Test
    public void contextLoads() {
        System.out.println("===========");
        System.out.println("===========");
        System.out.println("===========");
        System.out.println("===========");
        System.out.println("===========");
        //Creating a new SqlSession
//        System.out.println(productService.pageProduct(1,20));
        System.out.println(productDao.selectByPrimaryKey(1));
        Product product = new Product();
        product.setBusinessId(123).setDetail("测试二级缓存").setNum(5).setPrice(BigDecimal.TEN);
        productDao.insert(product);
        System.out.println(productDao.selectByPrimaryKey(1));


//        System.out.println(productDao.selectId1());
//        System.out.println(productDao.selectId1());

//        System.out.println(productDao.selectAll());
//        //
//        System.out.println(userBusinessDao.selectByPrimaryKey(1));
//        productService.addProductNoT("测试不加事务");
    }


    @Test
    public void testBuildUrl() {
        String url = "http://www.baidu.com";
        Map<String, String> pa = new HashMap<>();
        setMap(pa);
        System.out.println(HttpUtils.buildUrl(url, pa));
    }

    public static void setMap(Map<String, String> pa) {
        pa.put("pNo", "1");
        pa.put("pSize", "10");
    }


}
