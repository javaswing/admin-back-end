package com.zxd.admin.dto.admin.user;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zxd.admin.core.query.AbstractPageQuery;
import com.zxd.admin.entity.SysUser;
import lombok.Data;

@Data
public class SearchUserQueryDTO extends AbstractPageQuery {
    private Long userId;

    private String userName;

    private String mobile;

    private String email;

    @Override
    public QueryWrapper toQueryWrapper() {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();

        queryWrapper.like(StrUtil.isNotEmpty(userName), "username", userName)
                .like(StrUtil.isNotEmpty(mobile), "mobile", mobile)
                .like(StrUtil.isNotEmpty(email), "email", email)
                .eq(userId != null, "id", userId);

        this.addTimeCondition(queryWrapper, "create_at");
        return queryWrapper;
    }
}
