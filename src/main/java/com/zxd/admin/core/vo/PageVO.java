package com.zxd.admin.core.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.List;

@Data
public class PageVO <T>{

    private Long total;

    private List<T> rows;

    public PageVO(List<T> list) {
        this.rows = list;
        this.total = (long) list.size();
    }

    public PageVO(Page<T> page) {
        this.rows = page.getRecords();
        this.total = page.getTotal();
    }

    public PageVO(List<T> list, Long count) {
        this.rows = list;
        this.total = count;
    }
}
