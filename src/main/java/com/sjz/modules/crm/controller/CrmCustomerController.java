package com.sjz.modules.crm.controller;

import java.util.Arrays;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sjz.modules.crm.entity.CrmCustomerEntity;
import com.sjz.modules.crm.service.CrmCustomerService;
import com.sjz.common.utils.PageUtils;
import com.sjz.common.utils.R;



/**
 * 客户表
 *
 * @author yang
 * @email
 * @date 2020-03-16 19:38:43
 */
@RestController
@RequestMapping("crm/customer")
public class CrmCustomerController {
    @Autowired
    private CrmCustomerService crmCustomerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("crm:customer:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = crmCustomerService.queryPage(params);
        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/queryById")
    @RequiresPermissions("crm:customer:info")
    public R info(Integer customerId){
		CrmCustomerEntity crmCustomer = crmCustomerService.getById(customerId);
        return R.ok().put("data", crmCustomer);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("crm:customer:save")
    public R save(@RequestBody JSONObject json){
        Object ob = json.get("entity");
        CrmCustomerEntity entity = new CrmCustomerEntity();
        BeanUtils.copyProperties(ob,entity);
//        CrmCustomerEntity entity = (CrmCustomerEntity)json.get("entity");
        crmCustomerService.save(entity);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("crm:customer:update")
    public R update(@RequestBody CrmCustomerEntity crmCustomer){
		crmCustomerService.updateById(crmCustomer);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("crm:customer:delete")
    public R delete(@RequestBody Integer[] customerIds){
		crmCustomerService.removeByIds(Arrays.asList(customerIds));

        return R.ok();
    }

}
