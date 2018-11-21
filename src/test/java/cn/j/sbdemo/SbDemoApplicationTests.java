package cn.j.sbdemo;

import cn.j.sbdemo.sys.TestService;
import cn.j.sbdemo.sys.dao.SysUserMapper;
import cn.j.sbdemo.sys.entity.SysUserDo;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbDemoApplicationTests {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private TestService testService;

    @Test
    public void contextLoads() {
        System.out.println("===========");
        sysUserMapper.selectByExampleAndRowBounds(
                new Example(SysUserDo.class),
                new RowBounds(10, 20)
        );
        System.out.println(sysUserMapper.selectAll());
    }

    @Test
    public void testSessionClose() {
        testService.testSession("1121测试");
        System.out.println("ok");
    }

}
