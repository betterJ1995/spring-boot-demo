package cn.j.sbdemo.sys.dao;

import cn.j.sbdemo.sys.entity.SysCaptcha;

public interface SysCaptchaMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(SysCaptcha record);

    int insertSelective(SysCaptcha record);

    SysCaptcha selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(SysCaptcha record);

    int updateByPrimaryKey(SysCaptcha record);
}