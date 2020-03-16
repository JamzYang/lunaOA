package com.sjz.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjz.common.utils.PageUtils;
import com.sjz.modules.sys.entity.SysSceneEntity;

import java.util.List;
import java.util.Map;

/**
 * 场景
 *
 * @author yang
 * @email
 * @date 2020-03-16 17:07:38
 */
public interface SysSceneService extends IService<SysSceneEntity> {


    List<SysSceneEntity> queryAll(int type);
}

