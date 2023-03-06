package com.zxd.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxd.admin.constant.GlobalConstants;
import com.zxd.admin.core.query.AbstractPageQuery;
import com.zxd.admin.dto.admin.user.AddUserCommand;
import com.zxd.admin.dto.admin.user.UpdateUserCommand;
import com.zxd.admin.entity.SysUser;
import com.zxd.admin.exception.ApiException;
import com.zxd.admin.exception.error.ErrorCode;
import com.zxd.admin.mapper.SysUserMapper;
import com.zxd.admin.service.SysUserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tapas
 * @description 针对表【sys_user】的数据库操作Service实现
 * @createDate 2023-02-17 15:48:20
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
        implements SysUserService {

    @Override
    public Page<SysUser> getUserList(AbstractPageQuery query) {
        return baseMapper.getUserList(query.toPage(), query.toQueryWrapper());
    }

    @Override
    public void addUser(AddUserCommand command) {
        if (checkUnique(command)) {
            SysUser user = BeanUtil.copyProperties(command, SysUser.class, "userId");
            user.setPassword(SecureUtil.md5(GlobalConstants.INIT_PWD));
            this.baseMapper.insert(user);
        }
    }

    @Override
    public void updateUser(UpdateUserCommand command) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userId", "id");
        if (checkEmailAndMobile(command)) {
            SysUser user = BeanUtil.toBean(command,
                    SysUser.class,
                    CopyOptions.create()
                            .setFieldMapping(map)
                            .setIgnoreProperties("account"));
            this.baseMapper.updateById(user);
        }
    }

    @Override
    public void deleteUserByIds(List<Long> ids) {
        for (Long id : ids) {
            this.baseMapper.deleteById(id);
        }
    }

    @Override
    public void resetPassWord(Long id) {
        SysUser user = this.baseMapper.selectById(id);
        if(user == null) {
            throw new ApiException(ErrorCode.Business.USER_NOT_EXISTENCE);
        }
        user.setPassword(SecureUtil.md5(GlobalConstants.INIT_PWD));
        this.baseMapper.updateById(user);
    }

    @Override
    public boolean isAccountDuplicated(String account) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", account);
        return this.baseMapper.exists(queryWrapper);
    }

    @Override
    public boolean isMobileDuplicated(String mobile, Long userId) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne(userId != null, "id", userId)
                .eq("mobile", mobile);
        return this.baseMapper.exists(queryWrapper);
    }

    @Override
    public boolean isEmailDuplicated(String email, Long userId) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne(userId != null, "id", userId)
                .eq("email", email);
        return this.baseMapper.exists(queryWrapper);
    }

    private boolean checkUnique(AddUserCommand command) {
        if (isAccountDuplicated(command.getAccount())) {
            throw new ApiException(ErrorCode.Business.USER_ACCOUNT_IS_NOT_UNIQUE);
        }
        return checkEmailAndMobile(command);
    }


    private boolean checkEmailAndMobile(AddUserCommand command) {
        Long userId = command instanceof UpdateUserCommand ? ((UpdateUserCommand) command).getUserId() : null;
        if (isEmailDuplicated(command.getEmail(), userId)) {
            throw new ApiException(ErrorCode.Business.USER_EMAIL_IS_NOT_UNIQUE);
        }

        if (isMobileDuplicated(command.getPhone(), userId)) {
            throw new ApiException(ErrorCode.Business.USER_MOBILE_IS_NOT_UNIQUE);
        }
        return true;
    }
}




