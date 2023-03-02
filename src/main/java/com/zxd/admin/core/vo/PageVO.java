package com.zxd.admin.core.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "PageVO", description = "通用前分页信息结构")
public class PageVO <T>{

    @ApiModelProperty(value = "总条数", example = "200")
    private Long total;

    @ApiModelProperty(value = "返回数据")
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
