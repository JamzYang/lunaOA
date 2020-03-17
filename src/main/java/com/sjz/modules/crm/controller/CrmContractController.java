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

import com.sjz.modules.crm.entity.CrmContractEntity;
import com.sjz.modules.crm.service.CrmContractService;
import com.sjz.common.utils.PageUtils;
import com.sjz.common.utils.R;



/**
 * 合同表
 *
 * @author yang
 * @email 
 * @date 2020-03-16 19:38:43
 */
@RestController
@RequestMapping("crm/crmcontract")
public class CrmContractController {
    @Autowired
    private CrmContractService crmContractService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("crm:crmcontract:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = crmContractService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{contractId}")
    @RequiresPermissions("crm:crmcontract:info")
    public R info(@PathVariable("contractId") Integer contractId){
		CrmContractEntity crmContract = crmContractService.getById(contractId);

        return R.ok().put("crmContract", crmContract);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("crm:crmcontract:save")
    public R save(@RequestBody CrmContractEntity crmContract){
		crmContractService.save(crmContract);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("crm:crmcontract:update")
    public R update(@RequestBody CrmContractEntity crmContract){
		crmContractService.updateById(crmContract);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("crm:crmcontract:delete")
    public R delete(@RequestBody Integer[] contractIds){
		crmContractService.removeByIds(Arrays.asList(contractIds));

        return R.ok();
    }

}
