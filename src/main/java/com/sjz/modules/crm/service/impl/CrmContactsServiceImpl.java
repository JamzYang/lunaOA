package com.sjz.modules.crm.service.impl;

import com.sjz.modules.crm.vo.CrmContactsVO;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjz.common.utils.PageUtils;
import com.sjz.common.utils.Query;

import com.sjz.modules.crm.dao.CrmContactsDao;
import com.sjz.modules.crm.entity.CrmContactsEntity;
import com.sjz.modules.crm.service.CrmContactsService;


@Service("crmContactsService")
public class CrmContactsServiceImpl extends ServiceImpl<CrmContactsDao, CrmContactsEntity> implements CrmContactsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CrmContactsEntity> page = this.page(
                new Query<CrmContactsEntity>().getPage(params),
                new QueryWrapper<CrmContactsEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils selectPageVo(Map<String, Object> params) {
        IPage<CrmContactsVO> pageVo = baseMapper.selectPageVo(new Query<CrmContactsEntity>().getPage(params));
        return new PageUtils(pageVo);
    }

}
