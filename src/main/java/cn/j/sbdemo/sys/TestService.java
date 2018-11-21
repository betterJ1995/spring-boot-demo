package cn.j.sbdemo.sys;

import cn.j.sbdemo.sys.dao.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * created on 2018/11/21.
 *
 * @author J
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class TestService {
    @Autowired
    private SysUserMapper userMapper;

    public void testSession(String name) {
        userMapper.listAll();
        userMapper.insertTest(name);
        userMapper.selectAll();
    }
}
