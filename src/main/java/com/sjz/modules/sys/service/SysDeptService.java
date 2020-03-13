package com.sjz.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjz.common.utils.PageUtils;
import com.sjz.modules.sys.entity.SysDeptEntity;
import com.sjz.modules.sys.vo.SysDeptVO;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 部门表
 *
 * @author yang
 * @email
 * @date 2019-12-04 21:27:42
 */
public interface SysDeptService extends IService<SysDeptEntity> {

    PageUtils queryPage(Map<String, Object> params);
    SysDeptVO queryDeptTree();

}

