package cn.j.sbdemo;

import cn.j.sbdemo.sys.dao.SysUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * created on 2018/11/20.
 *
 * @author J
 **/
public class SqlSessionTest {
    @Test
    public void testCmt() throws IOException {
        String relativelyPath = System.getProperty("user.dir");
        System.out.println(relativelyPath);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //SqlSessionFactory的构建使用了建造者模式
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession(false);
        try {
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            System.out.println(mapper.listAll());
            mapper.insertTest("ajdjsa");
            session.commit();
            mapper.insertTest("啊撒啊");
        } finally {
            session.close();
        }


    }
}
