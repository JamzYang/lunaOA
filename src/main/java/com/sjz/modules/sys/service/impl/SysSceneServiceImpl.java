package com.sjz.modules.sys.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjz.common.utils.PageUtils;
import com.sjz.common.utils.Query;

import com.sjz.modules.sys.dao.SysSceneDao;
import com.sjz.modules.sys.entity.SysSceneEntity;
import com.sjz.modules.sys.service.SysSceneService;


@Service("sysSceneService")
public class SysSceneServiceImpl extends ServiceImpl<SysSceneDao, SysSceneEntity> implements SysSceneService {
    private final int SCENE_TYPE_CLUE       = 1;
    private final int SCENE_TYPE_CUSTOMER   = 2;
    private final int SCENE_TYPE_LINKMAN    = 3;
    private final int SCENE_TYPE_PRODUCT    = 4;
    private final int SCENE_TYPE_CHANCE     = 5;
    private final int SCENE_TYPE_CONTRACT   = 6;


    @Override
    public List<SysSceneEntity> queryAll(int type) {

        return baseMapper.queryAll(type);
    }

}
