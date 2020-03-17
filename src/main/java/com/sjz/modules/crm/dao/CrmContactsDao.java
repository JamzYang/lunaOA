package com.sjz.modules.crm.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sjz.modules.crm.entity.CrmContactsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjz.modules.crm.vo.CrmContactsVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 联系人表
 *
 * @author yang
 * @email
 * @date 2020-03-16 19:38:43
 */
@Mapper
public interface CrmContactsDao extends BaseMapper<CrmContactsEntity> {
    IPage<CrmContactsVO> selectPageVo(IPage<?> page);
}
