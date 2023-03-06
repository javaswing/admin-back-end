package com.zxd.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxd.admin.core.query.AbstractPageQuery;
import com.zxd.admin.dto.admin.user.AddUserCommand;
import com.zxd.admin.dto.admin.user.UpdateUserCommand;
import com.zxd.admin.dto.admin.user.UserDetailDTO;
import com.zxd.admin.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author tapas
* @description 针对表【sys_user】的数据库操作Service
* @createDate 2023-02-17 15:48:20
*/
public interface SysUserService extends IService<SysUser> {


    Page<SysUser> getUserList(AbstractPageQuery query);

    void addUser(AddUserCommand command);

    void updateUser(UpdateUserCommand command);

    void deleteUserByIds(List<Long> ids);

    void resetPassWord(Long id);


    boolean isAccountDuplicated(String account);

    boolean isMobileDuplicated(String mobile, Long userId);

    boolean isEmailDuplicated(String email, Long userId);
}
