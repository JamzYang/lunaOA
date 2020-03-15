package com.sjz.modules.sys.controller;

import java.util.*;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.sjz.modules.sys.vo.SysDeptVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sjz.modules.sys.entity.SysDeptEntity;
import com.sjz.modules.sys.service.SysDeptService;
import com.sjz.common.utils.PageUtils;
import com.sjz.common.utils.R;

import javax.validation.Valid;


/**
 * 部门表
 *
 * @author yang
 * @email
 * @date 2019-12-04 21:27:42
 */
@Api(tags = "部门")
@RestController
@RequestMapping("sys/dept")
public class SysDeptController {
    @Autowired
    private SysDeptService sysDeptService;


    /**
     * 部门树
     * @return
     */
    @ApiOperation("部门树")
    @PostMapping("queryDeptTree")
    @RequiresPermissions("sys:dept:list")
    public R queryDeptTree(){
        SysDeptVO sysDeptVO = sysDeptService.queryDeptTree();
//        String data = JSON.toJSONString(sysDeptVO);
        List<Object> data = new ArrayList<>();
        data.add(sysDeptVO);
        return R.ok().put("data", data);
    }


    /**
     * 列表
     */
    @ApiOperation("列表")
    @GetMapping("/list")
    @RequiresPermissions("sys:dept:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysDeptService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{deptId}")
    @RequiresPermissions("sys:dept:info")
    public R info(@PathVariable("deptId") Integer deptId){
		SysDeptEntity sysDept = sysDeptService.getById(deptId);

        return R.ok().put("sysDept", sysDept);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("sys:dept:save")
    public R save(@Valid SysDeptEntity sysDept){
		sysDeptService.save(sysDept);
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @RequiresPermissions("sys:dept:update")
    public R update(@Valid SysDeptEntity sysDept){
		sysDeptService.updateById(sysDept);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:dept:delete")
    public R delete(@RequestBody Integer[] deptIds){
		sysDeptService.removeByIds(Arrays.asList(deptIds));

        return R.ok();
    }

}
