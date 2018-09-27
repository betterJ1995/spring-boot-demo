package cn.j.sbdemo.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class SysUser {
    @TableId
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