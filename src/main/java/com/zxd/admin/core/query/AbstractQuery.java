package com.zxd.admin.core.query;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zxd.admin.utils.DatePickUtil;
import lombok.Data;


import java.util.Date;
import java.util.Map;

@Data
public abstract class AbstractQuery {
    protected String orderByColumn;

    protected String isAsc;

    protected Date beginTime;

    protected Date endTime;

    private static final String ASC = "ascending";

    private static final String DESC = "descending";

    protected Map<String, String> filedOverride = MapUtil.empty();

    public abstract QueryWrapper toQueryWrapper();


    /**
     * 获取需要覆盖的字符串
     *
     * @param columnName
     * @return
     */
    public String columnName(String columnName) {
        if (filedOverride.get(columnName) != null) {
            return filedOverride.get(columnName);
        }
        return columnName;
    }

    public void addSortCondition(QueryWrapper<?> queryWrapper) {
        if (queryWrapper != null) {
            boolean sortDirection = convertSortDirection();
            queryWrapper.orderBy(StrUtil.isNotBlank(orderByColumn),
                    sortDirection, StrUtil.toUnderlineCase(orderByColumn));
        }
    }

    public void addTimeCondition(QueryWrapper<?> queryWrapper, String fieldName) {
        if (queryWrapper != null) {
            queryWrapper.ge(beginTime != null, fieldName, DatePickUtil.getBeginOfTheDay(beginTime))
                    .le(endTime != null, fieldName, DatePickUtil.getEndOfTheDay(endTime));
        }
    }

    public boolean convertSortDirection() {
        boolean orderDirection = true;
        if (StrUtil.isNotEmpty(isAsc)) {
            if (ASC.equals(isAsc)) {
                orderDirection = true;
            } else if (DESC.equals(isAsc)) {
                orderDirection = false;
            }
        }
        return orderDirection;
    }
}
