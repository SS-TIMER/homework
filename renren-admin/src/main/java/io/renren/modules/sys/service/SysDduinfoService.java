package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.SysDduinfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author liupine
 * @email younamesong@163.com
 * @date 2019-06-03 17:34:15
 */

public interface SysDduinfoService extends IService<SysDduinfoEntity> {

    List<SysDduinfoEntity> findAll();

    PageUtils queryPage(Map<String, Object> params);

    void addDuData(SysDduinfoEntity sysDduinfoEntity);
    void addDiData(SysDduinfoEntity sysDduinfoEntity);

    void updateDuData(SysDduinfoEntity sysDduinfoEntity);
    void updateDiData(SysDduinfoEntity sysDduinfoEntity);


    void deleteDiData(String id);

    SysDduinfoEntity getInfoById(String id);

}

