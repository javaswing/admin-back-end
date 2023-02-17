package com.zxd.admin.mapper;

import com.zxd.admin.entity.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author tapas
* @description 针对表【sys_user_role(用户角色关联表)】的数据库操作Mapper
* @createDate 2023-02-17 15:49:40
* @Entity com.zxd.admin.entity.SysUserRole
*/
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

}




