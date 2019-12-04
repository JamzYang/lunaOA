package com.sjz.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjz.common.utils.PageUtils;
import com.sjz.modules.sys.entity.SysMenuEntity;

import java.util.Map;

/**
 * 后台菜单表
 *
 * @author yang
 * @email 
 * @date 2019-12-04 21:27:42
 */
public interface SysMenuService extends IService<SysMenuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

