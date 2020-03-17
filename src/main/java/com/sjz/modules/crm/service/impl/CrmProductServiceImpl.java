package com.sjz.modules.crm.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjz.common.utils.PageUtils;
import com.sjz.common.utils.Query;

import com.sjz.modules.crm.dao.CrmProductDao;
import com.sjz.modules.crm.entity.CrmProductEntity;
import com.sjz.modules.crm.service.CrmProductService;


@Service("crmProductService")
public class CrmProductServiceImpl extends ServiceImpl<CrmProductDao, CrmProductEntity> implements CrmProductService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CrmProductEntity> page = this.page(
                new Query<CrmProductEntity>().getPage(params),
                new QueryWrapper<CrmProductEntity>()
        );

        return new PageUtils(page);
    }

}
