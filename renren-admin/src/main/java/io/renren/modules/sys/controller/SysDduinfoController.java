package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.List;


import io.renren.modules.sys.entity.SysDduinfoEntity;
import io.renren.modules.sys.service.SysDduinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.renren.common.utils.R;

/**
 * Created on 2019/6/611:12.
 *
 * @Author liupine.
 * @eamil younamesong@163.com
 */


@RestController
@RequestMapping("sys/sysdduinfo")
public class SysDduinfoController {
    @Autowired
    private SysDduinfoService sysDduinfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public List<SysDduinfoEntity> list() {
        List<SysDduinfoEntity> findAll = sysDduinfoService.findAll();
        return findAll;
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id) {
        SysDduinfoEntity sysDduinfo = sysDduinfoService.getInfoById(id);
        return R.ok().put("sysDduinfo", sysDduinfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SysDduinfoEntity sysDduinfoEntity) {
        sysDduinfoService.addDiData(sysDduinfoEntity);
        sysDduinfoService.addDuData(sysDduinfoEntity);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SysDduinfoEntity sysDduinfoEntity) {
        sysDduinfoService.updateDuData(sysDduinfoEntity);
        sysDduinfoService.updateDiData(sysDduinfoEntity);
        return R.ok();
    }

    /**
     * 删除
     */
   /* @RequestMapping("/delete")
    public R delete(@RequestBody String[] ids) {

        for (String id : ids) {
            sysDduinfoService.deleteDiData(id);
        }
        return R.ok();
    }
*/
    @RequestMapping("/delete")
    //    @RequiresPermissions("sys:sysself:delete")
    public R delete(@RequestBody Long[] ids) {
        sysDduinfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
