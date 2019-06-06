package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * Created on 2019/6/611:26.
 *
 * @Author liupine.
 * @eamil younamesong@163.com
 */
@Data
@TableName("sys_dduinfo")
public class SysDduinfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    private Integer id;
    /**
     *
     */
    private String name;
    /**
     *
     */
    private Integer sex;
    /**
     *
     */
    private Integer userId;


    @TableField(exist = false)
    private String username;
    @TableField(exist = false)
    private String password;
}
