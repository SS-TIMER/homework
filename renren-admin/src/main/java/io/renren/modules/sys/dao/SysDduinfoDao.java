package io.renren.modules.sys.dao;

import io.renren.modules.sys.entity.SysDduinfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 *
 * @author liupine
 * @email younamesong@163.com
 * @date 2019-06-03 17:34:15
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
