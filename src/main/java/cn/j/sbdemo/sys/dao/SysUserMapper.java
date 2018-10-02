package cn.j.sbdemo.sys.dao;

import cn.j.sbdemo.sys.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface SysUserMapper extends BaseMapper<SysUser>{

    List<SysUser> listAll();
}