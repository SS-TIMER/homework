package io.renren.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.sys.entity.SysDduinfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created on 2019/6/611:25.
 *
 * @Author liupine.
 * @eamil younamesong@163.com
 */

@Mapper
public interface SysDduinfoDao extends BaseMapper<SysDduinfoEntity> {
    List<SysDduinfoEntity> findAll();

    @Transactional
    void addDiData(SysDduinfoEntity sysdduinfoEntity);

    @Transactional
    void addDuData(SysDduinfoEntity sysDduinfoEntity);


    @Transactional
    void updateDiData(SysDduinfoEntity sysdduinfoEntity);

    @Transactional
    void updateDuData(SysDduinfoEntity sysdduinfoEntity);


    @Transactional
    SysDduinfoEntity deleteDiData(String id);

    SysDduinfoEntity getInfoById(String id);
}

