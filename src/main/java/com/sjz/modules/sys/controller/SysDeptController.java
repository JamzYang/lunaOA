package com.sjz.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sjz.modules.sys.entity.SysDeptEntity;
import com.sjz.modules.sys.service.SysDeptService;
import com.sjz.common.utils.PageUtils;
import com.sjz.common.utils.R;



/**
 * 部门表
 *
 * @author yang
 * @email 
 * @date 2019-12-04 21:27:42
 */
@RestController
@RequestMapping("sys/sysdept")
public class SysDeptController {
    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:sysdept:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysDeptService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{deptId}")
    @RequiresPermissions("sys:sysdept:info")
    public R info(@PathVariable("deptId") Integer deptId){
		SysDeptEntity sysDept = sysDeptService.getById(deptId);

        return R.ok().put("sysDept", sysDept);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:sysdept:save")
    public R save(@RequestBody SysDeptEntity sysDept){
		sysDeptService.save(sysDept);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:sysdept:update")
    public R update(@RequestBody SysDeptEntity sysDept){
		sysDeptService.updateById(sysDept);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:sysdept:delete")
    public R delete(@RequestBody Integer[] deptIds){
		sysDeptService.removeByIds(Arrays.asList(deptIds));

        return R.ok();
    }

}
