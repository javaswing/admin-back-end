package com.zxd.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxd.admin.core.query.AbstractPageQuery;
import com.zxd.admin.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author tapas
* @description 针对表【sys_user】的数据库操作Service
* @createDate 2023-02-17 15:48:20
*/
public interface SysUserService extends IService<SysUser> {


    Page<SysUser> getUserList(AbstractPageQuery query);
}
