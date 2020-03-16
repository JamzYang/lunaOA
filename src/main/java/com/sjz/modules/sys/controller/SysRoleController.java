package com.sjz.modules.sys.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.sjz.modules.sys.vo.RoleVO2;
import com.sjz.modules.sys.vo.SysRoleTreeVO;
import com.sjz.modules.sys.vo.SysRoleTreeVO2;
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
        List<SysRoleTreeVO2> vo2 =  VOTOVO2(roleTree);
        return R.ok().put("data", vo2);
    }

    private List<SysRoleTreeVO2> VOTOVO2(List<SysRoleTreeVO> roleTree) {
        List<SysRoleTreeVO2> vo2List = new ArrayList<SysRoleTreeVO2>();
        roleTree.forEach(treeVO ->{
            SysRoleTreeVO2 vo2 = new SysRoleTreeVO2();
            vo2.setList(new ArrayList<RoleVO2>());
            vo2List.add(vo2);
            vo2.setName(treeVO.getName());
            vo2.setPid(treeVO.getRoleType());
            vo2.setList(new ArrayList<RoleVO2>());
            List<SysRoleEntity> roleEntityList = treeVO.getList();
            roleEntityList.forEach(roleEntity ->{
                RoleVO2 roleVO2 = new RoleVO2();
                vo2.getList().add(roleVO2);
                roleVO2.setId(roleEntity.getRoleId());
                roleVO2.setPid(roleEntity.getRoleType());
                roleVO2.setRemark(roleEntity.getRoleName());
                roleVO2.setTitle(roleEntity.getRoleName());
//                roleVO2.setStatus(roleEntity.getStatus());
            });
        });
        return vo2List;
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
