package com.zxd.admin.core.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * baseEntity 基类
 *
 * @param <T>
 */
@Data
// https://blog.csdn.net/zhanlanmg/article/details/50392266
// 该注解主要是用于判断对象相等时使用，子类统一调用父类的hasCode
@EqualsAndHashCode(callSuper = true)
public class BaseEntity<T extends Model<?>> extends Model<T> {

    @TableField(value = "create_at", fill = FieldFill.INSERT)
    private Date createAt;

    @TableField(value = "update_at", fill = FieldFill.UPDATE)
    private Date updateAt;

    @TableField(value = "delete_at")
    @TableLogic
    private Date deleteAt;
}
