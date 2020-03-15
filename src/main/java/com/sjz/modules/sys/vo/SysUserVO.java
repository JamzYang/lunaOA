package com.sjz.modules.sys.vo;

import lombok.Data;

/**
 * @author yang
 * Date 2020/3/14 23:33
 */
@Data
public class SysUserVO {
    private int userId;
    private String username;
    private String realname;

    private int deptId;
    private String deptName;

    private int roleId;
    private String roleName;

    private int parentId;
    private String parentName;

    private int sex;
    private String mobile;
    private String post;
    private String email;
    private String createTime;
    private String img;
    private int status;
}
