package com.sjz.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjz.common.utils.PageUtils;
import com.sjz.modules.sys.entity.SysDictEntity;

import java.util.Map;

/**
 * 字典表
 *
 * @author yang
 * @email 
 * @date 2020-03-16 19:37:53
 */
public interface SysDictService extends IService<SysDictEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

