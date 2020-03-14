package com.sjz.modules.sys.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.sjz.modules.sys.vo.SysRoleTreeVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sjz.modules.sys.entity.SysRoleEntity;
import com.sjz.modules.sys.service.SysRoleService;
import com.sjz.common.utils.PageUtils;
import com.sjz.common.utils.R;

import javax.validation.Valid;


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

    @PostMapping("/getAllRoleList")
    @RequiresPermissions("sys:role:list")
    public R getAllRoleList(){
        List<SysRoleTreeVO> roleTree = sysRoleService.queryAll();
        return R.ok().put("data", roleTree);
    }

    @PostMapping("/getRoleTypeList")
    @RequiresPermissions("sys:role:list")
    public R getRoleTypeList(){
        List<SysRoleTreeVO> roleTypes = sysRoleService.getRoleTypeList();
        return R.ok().put("data", roleTypes);
    }

    @PostMapping("/getRoleByType")
    @RequiresPermissions("sys:role:list")
    public R getRoleByType(int roleType){
        List<SysRoleEntity> roles = sysRoleService.getRoleByType(roleType);
        return R.ok().put("data", roles);
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
    @PostMapping("/save")
    @RequiresPermissions("sys:role:save")
    public R save(@Valid SysRoleEntity sysRole){
		sysRoleService.save(sysRole);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @RequiresPermissions("sys:role:update")
    public R update(@Valid SysRoleEntity sysRole){
		sysRoleService.updateById(sysRole);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @RequiresPermissions("sys:role:delete")
    public R delete(Integer roleId){
//		sysRoleService.removeByIds(Arrays.asList(roleIds));
        sysRoleService.removeById(roleId);
        return R.ok();
    }
}
