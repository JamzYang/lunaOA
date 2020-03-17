package com.sjz.modules.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjz.common.utils.PageUtils;
import com.sjz.modules.crm.entity.CrmContactsEntity;

import java.util.Map;

/**
 * 联系人表
 *
 * @author yang
 * @email
 * @date 2020-03-16 19:38:43
 */
public interface CrmContactsService extends IService<CrmContactsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    PageUtils selectPageVo(Map<String, Object> params);
}

