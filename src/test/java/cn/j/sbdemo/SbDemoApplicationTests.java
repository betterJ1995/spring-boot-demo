package cn.j.sbdemo;

import cn.j.sbdemo.dao.ProductDao;
import cn.j.sbdemo.dao.UserBusinessDao;
import cn.j.sbdemo.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        System.out.println(productDao.selectByPrimaryKey(1));

        System.out.println(productDao.selectAll());
        //
        System.out.println(userBusinessDao.selectByPrimaryKey(1));
        productService.addProductNoT("测试不加事务");
    }

}
