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

import com.sjz.modules.sys.entity.SysRoleEntity;
import com.sjz.modules.sys.service.SysRoleService;
import com.sjz.common.utils.PageUtils;
import com.sjz.common.utils.R;



/**
 * 角色表
 *
 * @author yang
 * @email
 * @date 2019-12-04 21:27:42
 */
@RestController
@RequestMapping("sys/role")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:role:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysRoleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{roleId}")
    @RequiresPermissions("sys:role:info")
    public R info(@PathVariable("roleId") Integer roleId){
		SysRoleEntity sysRole = sysRoleService.getById(roleId);

        return R.ok().put("sysRole", sysRole);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:role:save")
    public R save(@RequestBody SysRoleEntity sysRole){
		sysRoleService.save(sysRole);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:role:update")
    public R update(@RequestBody SysRoleEntity sysRole){
		sysRoleService.updateById(sysRole);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:role:delete")
    public R delete(@RequestBody Integer[] roleIds){
		sysRoleService.removeByIds(Arrays.asList(roleIds));

        return R.ok();
    }

}
