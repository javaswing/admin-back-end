package com.zxd.admin.core.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import javax.validation.constraints.Max;

@Data
public abstract class AbstractPageQuery extends AbstractQuery {
    // TODO 这里设置最大值
    public static final int MAX_PAGE_NUM = 200;
    public static final int MAX_PAGE_SIZE = 500;

    @Max(MAX_PAGE_NUM)
    protected Integer pageNum = 1;

    @Max(MAX_PAGE_SIZE)
    protected Integer pageSize = 10;


    public Page toPage() {
        return new Page<>(pageNum, pageSize);
    }
}
