package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.SysSelfEntity;

import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-03 00:10:34
 */
public interface SysSelfService extends IService<SysSelfEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

