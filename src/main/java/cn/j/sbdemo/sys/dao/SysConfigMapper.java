package cn.j.sbdemo.sys.dao;

import cn.j.sbdemo.sys.entity.SysConfig;

public interface SysConfigMapper {
    int insert(SysConfig record);

    int insertSelective(SysConfig record);
}