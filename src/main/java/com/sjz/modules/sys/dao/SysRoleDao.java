package com.sjz.modules.sys.dao;

import com.sjz.modules.sys.entity.SysRoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 角色表
 *
 * @author yang
 * @email
 * @date 2019-12-04 21:27:42
 */
@Mapper
public interface SysRoleDao extends BaseMapper<SysRoleEntity> {


    @Select("")
    List<SysRoleEntity> queryAll();
}
