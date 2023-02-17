package com.zxd.admin.mapper;

import com.zxd.admin.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author tapas
* @description 针对表【sys_menu(权限 & 菜单)】的数据库操作Mapper
* @createDate 2023-02-17 15:38:29
* @Entity com.zxd.admin.entity.SysMenu
*/
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

}




