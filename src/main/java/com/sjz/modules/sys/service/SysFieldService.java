package com.sjz.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjz.common.utils.PageUtils;
import com.sjz.modules.sys.entity.SysFieldEntity;

import java.util.List;
import java.util.Map;

/**
 * 自定义字段表
 *
 * @author yang
 * @email
 * @date 2020-03-16 19:37:53
 */
public interface SysFieldService extends IService<SysFieldEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<SysFieldEntity> queryListHead(int label);
}

