package com.sjz.modules.crm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 合同表
 * 
 * @author yang
 * @email 
 * @date 2020-03-16 19:38:43
 */
@Data
@TableName("crm_contract")
public class CrmContractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer contractId;
	/**
	 * 客户ID
	 */
	private Integer customerId;
	/**
	 * 商机ID
	 */
	private Integer businessId;
	/**
	 * 0待审核、1审核中、2审核通过、3审核未通过 4:已撤回
	 */
	private Integer checkStatus;
	/**
	 * 审核记录ID
	 */
	private Integer examineRecordId;
	/**
	 * 签订日期
	 */
	private Date signDate;
	/**
	 * 下单日期
	 */
	private Date orderDate;
	/**
	 * 续费提醒
	 */
	private Date remindDate;
	/**
	 * 报价金额
	 */
	private BigDecimal price;
	/**
	 * 付款时间
	 */
	private Date payTime;
	/**
	 * 实付金额
	 */
	private BigDecimal payment;
	/**
	 * 收款账户
	 */
	private Integer accountId;
	/**
	 * 创建人ID
	 */
	private Integer createUserId;
	/**
	 * 负责人ID
	 */
	private Integer ownerUserId;
	/**
	 * 财税顾问ID
	 */
	private Integer accountantId;
	/**
	 * 生效日期
	 */
	private Date startDate;
	/**
	 * 终止日期
	 */
	private Date endDate;
	/**
	 * 合同编号
	 */
	private String num;
	/**
	 * 开始时间
	 */
	private Date startTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 合同金额
	 */
	private BigDecimal money;
	/**
	 * 整单折扣
	 */
	private BigDecimal discountRate;
	/**
	 * 产品总金额
	 */
	private BigDecimal totalPrice;
	/**
	 * 合同类型
	 */
	private String types;
	/**
	 * 付款方式
	 */
	private String paymentType;
	/**
	 * 批次 比如附件批次
	 */
	private String batchId;
	/**
	 * 只读权限
	 */
	private String roUserId;
	/**
	 * 读写权限
	 */
	private String rwUserId;
	/**
	 * 客户签约人（联系人id）
	 */
	private Integer contactsId;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 公司签约人
	 */
	private Integer companyUserId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 续费
	 */
	private Integer renewal;

}
