package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.SysSelfEntity;
import io.renren.modules.sys.service.SysSelfService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-03 00:10:34
 */
@RestController
@RequestMapping("sys/sysself")
public class SysSelfController {
    @Autowired
    private SysSelfService sysSelfService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:sysself:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysSelfService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//     @RequiresPermissions("sys:sysself:info")
    public R info(@PathVariable("id") Long id){
        SysSelfEntity sysSelf = sysSelfService.getById(id);

        return R.ok().put("sysSelf", sysSelf);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //    @RequiresPermissions("sys:sysself:save")
    public R save(@RequestBody SysSelfEntity sysSelf){
        sysSelfService.save(sysSelf);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //    @RequiresPermissions("sys:sysself:update")
    public R update(@RequestBody SysSelfEntity sysSelf){
        ValidatorUtils.validateEntity(sysSelf);
        sysSelfService.updateById(sysSelf);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //    @RequiresPermissions("sys:sysself:delete")
    public R delete(@RequestBody Long[] ids){
        sysSelfService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
