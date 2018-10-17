package cn.j.sbdemo.sys.dao;

import cn.j.sbdemo.sys.entity.SysUserDo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysUserMapper extends Mapper<SysUserDo> {

    List<SysUserDo> listAll();
}