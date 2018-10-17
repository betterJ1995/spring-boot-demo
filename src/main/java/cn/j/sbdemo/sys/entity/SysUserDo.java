package cn.j.sbdemo.sys.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@ToString
@Table(name = "sys_user")
public class SysUserDo {
    @Id
    private Long userId;

    private String username;

    private String password;

    private String salt;

    private String email;

    private String mobile;

    private Byte status;

    private Long createUserId;

    private Date createTime;
}