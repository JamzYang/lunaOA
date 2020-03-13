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

import com.sjz.modules.sys.entity.SysRoleMenuEntity;
import com.sjz.modules.sys.service.SysRoleMenuService;
import com.sjz.common.utils.PageUtils;
import com.sjz.common.utils.R;



/**
 * 角色菜单对应关系表
 *
 * @author yang
 * @email
 * @date 2019-12-04 21:27:42
 */
@RestController
@RequestMapping("sys/rolemenu")
@Deprecated
public class SysRoleMenuController {
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:rolemenu:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysRoleMenuService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:rolemenu:info")
    public R info(@PathVariable("id") Integer id){
		SysRoleMenuEntity sysRoleMenu = sysRoleMenuService.getById(id);
        return R.ok().put("sysRoleMenu", sysRoleMenu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:rolemenu:save")
    public R save(@RequestBody SysRoleMenuEntity sysRoleMenu){
		sysRoleMenuService.save(sysRoleMenu);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:rolemenu:update")
    public R update(@RequestBody SysRoleMenuEntity sysRoleMenu){
		sysRoleMenuService.updateById(sysRoleMenu);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:rolemenu:delete")
    public R delete(@RequestBody Integer[] ids){
		sysRoleMenuService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
