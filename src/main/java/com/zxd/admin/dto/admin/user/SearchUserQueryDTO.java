package com.zxd.admin.dto.admin.user;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zxd.admin.core.query.AbstractPageQuery;
import com.zxd.admin.entity.SysUser;
import lombok.Data;

@Data
public class SearchUserQueryDTO extends AbstractPageQuery {
    private Long id;

    private String account;

    private String mobile;

    private String email;

    @Override
    public QueryWrapper toQueryWrapper() {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();

        queryWrapper.like(StrUtil.isNotEmpty(account), "account", account)
                .like(StrUtil.isNotEmpty(mobile), "mobile", mobile)
                .like(StrUtil.isNotEmpty(email), "email", email)
                .eq(id != null, "id", id);

        this.addTimeCondition(queryWrapper, "create_at");
        this.addSortCondition(queryWrapper);
        return queryWrapper;
    }
}
