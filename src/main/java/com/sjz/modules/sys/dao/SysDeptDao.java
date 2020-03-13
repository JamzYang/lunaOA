package com.sjz.modules.sys.dao;

import com.sjz.modules.sys.entity.SysDeptEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

/**
 * 部门表
 *
 * @author yang
 * @email
 * @date 2019-12-04 21:27:42
 */
@Mapper
public interface SysDeptDao extends BaseMapper<SysDeptEntity> {

    @Select("select dept_id as deptId, pid, name  from sys_dept")
    List<SysDeptEntity> queryAll();
}
