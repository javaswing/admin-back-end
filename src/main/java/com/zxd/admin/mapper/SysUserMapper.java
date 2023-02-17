package com.zxd.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxd.admin.dto.admin.SearchUserQueryDTO;
import com.zxd.admin.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
* @author tapas
* @description 针对表【sys_user】的数据库操作Mapper
* @createDate 2023-02-17 15:48:20
* @Entity com.zxd.admin.entity.SysUser
*/
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {


    @Select("SELECT * FROM sys_user " + "${ew.customSqlSegment}")
    Page<SysUser> getUserList(Page<SearchUserQueryDTO> page,
                              @Param(Constants.WRAPPER) Wrapper<SearchUserQueryDTO> queryWrapper);
}




