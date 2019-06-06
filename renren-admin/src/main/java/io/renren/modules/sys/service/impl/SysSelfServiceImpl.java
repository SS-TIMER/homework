package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.SysSelfDao;
import io.renren.modules.sys.entity.SysSelfEntity;
import io.renren.modules.sys.service.SysSelfService;


@Service("sysSelfService")
public class SysSelfServiceImpl extends ServiceImpl<SysSelfDao, SysSelfEntity> implements SysSelfService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysSelfEntity> page = this.page(
                new Query<SysSelfEntity>().getPage(params),
                new QueryWrapper<SysSelfEntity>()
        );

        return new PageUtils(page);
    }

}
