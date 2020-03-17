package com.sjz.modules.crm.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sjz.modules.crm.entity.CrmProductEntity;
import com.sjz.modules.crm.service.CrmProductService;
import com.sjz.common.utils.PageUtils;
import com.sjz.common.utils.R;



/**
 * 产品表
 *
 * @author yang
 * @email 
 * @date 2020-03-16 19:38:43
 */
@RestController
@RequestMapping("crm/crmproduct")
public class CrmProductController {
    @Autowired
    private CrmProductService crmProductService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("crm:crmproduct:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = crmProductService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{productId}")
    @RequiresPermissions("crm:crmproduct:info")
    public R info(@PathVariable("productId") Integer productId){
		CrmProductEntity crmProduct = crmProductService.getById(productId);

        return R.ok().put("crmProduct", crmProduct);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("crm:crmproduct:save")
    public R save(@RequestBody CrmProductEntity crmProduct){
		crmProductService.save(crmProduct);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("crm:crmproduct:update")
    public R update(@RequestBody CrmProductEntity crmProduct){
		crmProductService.updateById(crmProduct);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("crm:crmproduct:delete")
    public R delete(@RequestBody Integer[] productIds){
		crmProductService.removeByIds(Arrays.asList(productIds));

        return R.ok();
    }

}
