package com.sjz.modules.sys.dao;

import com.sjz.modules.sys.entity.SysSceneEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 场景
 *
 * @author yang
 * @email
 * @date 2020-03-16 17:07:38
 */
@Mapper
public interface SysSceneDao extends BaseMapper<SysSceneEntity> {

    List<SysSceneEntity> queryAll(int type);
}
