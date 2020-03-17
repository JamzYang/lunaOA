package com.sjz.modules.crm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 客户表
 * 
 * @author yang
 * @email 
 * @date 2020-03-16 19:38:43
 */
@Data
@TableName("crm_customer")
public class CrmCustomerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer customerId;
	/**
	 * 客户名称
	 */
	private String customerName;
	/**
	 * 跟进状态 0未跟进1已跟进
	 */
	private Integer followup;
	/**
	 * 1锁定
	 */
	private Integer isLock;
	/**
	 * 下次联系时间
	 */
	private Date nextTime;
	/**
	 * 成交状态
	 */
	private String dealStatus;
	/**
	 * 手机
	 */
	private String mobile;
	/**
	 * 电话
	 */
	private String telephone;
	/**
	 * 网址
	 */
	private String website;
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
	 * 只读权限
	 */
	private String roUserId;
	/**
	 * 读写权限
	 */
	private String rwUserId;
	/**
	 * 省市区
	 */
	private String address;
	/**
	 * 定位信息
	 */
	private String location;
	/**
	 * 详细地址
	 */
	private String detailAddress;
	/**
	 * 地理位置经度
	 */
	private String lng;
	/**
	 * 地理位置维度
	 */
	private String lat;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 批次 比如附件批次
	 */
	private String batchId;

}
