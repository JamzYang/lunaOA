package com.sjz.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户表
 *
 * @author yang
 * @email
 * @date 2019-12-04 21:27:42
 */
@Data
@TableName("sys_user")
public class SysUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(type = IdType.AUTO)
	private Integer userId;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 安全符
	 */
	private String salt;
	/**
	 * 头像
	 */
	private String img;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 真实姓名
	 */
	private String realname;
	/**
	 * 员工编号
	 */
	private String num;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 0 未选择 1 男 2 女
	 */
	private Integer sex;
	/**
	 * 部门
	 */
	private Integer deptId;
	/**
	 * 岗位
	 */
	private String position;
	/**
	 * 状态,0禁用,1正常,2未激活
	 */
	private Integer status;
	/**
	 * 直属上级ID
	 */
	private Long parentId;
	/**
	 * 最后登录时间
	 */
	private Date lastLoginTime;
	/**
	 * 最后登录IP 注意兼容IPV6
	 */
	private String lastLoginIp;

}
