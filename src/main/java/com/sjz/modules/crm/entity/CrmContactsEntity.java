package com.sjz.modules.crm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 联系人表
 * 
 * @author yang
 * @email 
 * @date 2020-03-16 19:38:43
 */
@Data
@TableName("crm_contacts")
public class CrmContactsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer contactsId;
	/**
	 * 联系人名称
	 */
	private String name;
	/**
	 * 下次联系时间
	 */
	private Date nextTime;
	/**
	 * 手机
	 */
	private String mobile;
	/**
	 * 电话
	 */
	private String telephone;
	/**
	 * 电子邮箱
	 */
	private String email;
	/**
	 * 职务
	 */
	private String post;
	/**
	 * 客户ID
	 */
	private Integer customerId;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建人ID
	 */
	private Integer createUserId;
	/**
	 * 负责人ID
	 */
	private Integer ownerUserId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 批次
	 */
	private String batchId;

}
