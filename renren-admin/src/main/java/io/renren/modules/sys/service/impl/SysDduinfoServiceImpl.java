package io.renren.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.sys.dao.SysDduinfoDao;
import io.renren.modules.sys.entity.SysDduinfoEntity;
import io.renren.modules.sys.service.SysDduinfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created on 2019/6/611:28.
 *
 * @Author liupine.
 * @eamil younamesong@163.com
 */

@Service("sysDduinfoService")
public class SysDduinfoServiceImpl extends ServiceImpl<SysDduinfoDao, SysDduinfoEntity> implements SysDduinfoService {

    @Override
    public List<SysDduinfoEntity> findAll() {
        return baseMapper.findAll();
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysDduinfoEntity> page = this.page(
                new Query<SysDduinfoEntity>().getPage(params),
                new QueryWrapper<SysDduinfoEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void addDuData(SysDduinfoEntity sysDduinfoEntity) {
        baseMapper.addDuData(sysDduinfoEntity);
    }

    @Override
    public void addDiData(SysDduinfoEntity sysDduinfoEntity) {
        baseMapper.addDiData(sysDduinfoEntity);
    }

    @Override
    public void updateDuData(SysDduinfoEntity sysDduinfoEntity) {
        baseMapper.updateDuData(sysDduinfoEntity);
    }

    @Override
    public void updateDiData(SysDduinfoEntity sysDduinfoEntity) {
        baseMapper.updateDiData(sysDduinfoEntity);
    }


    @Override
    public void deleteDiData(String id) {
        baseMapper.deleteDiData(id);
    }

    @Override
    public SysDduinfoEntity getInfoById(String id) {
        return baseMapper.getInfoById(id);
    }

}

