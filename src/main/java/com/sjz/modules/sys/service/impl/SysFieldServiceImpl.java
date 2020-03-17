package com.sjz.modules.sys.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjz.common.utils.PageUtils;
import com.sjz.common.utils.Query;

import com.sjz.modules.sys.dao.SysFieldDao;
import com.sjz.modules.sys.entity.SysFieldEntity;
import com.sjz.modules.sys.service.SysFieldService;


@Service("sysFieldService")
public class SysFieldServiceImpl extends ServiceImpl<SysFieldDao, SysFieldEntity> implements SysFieldService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysFieldEntity> page = this.page(
                new Query<SysFieldEntity>().getPage(params),
                new QueryWrapper<SysFieldEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<SysFieldEntity> queryListHead(int label) {
        return baseMapper.queryListHead(label);
    }

}
