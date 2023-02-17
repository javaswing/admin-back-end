package com.zxd.admin.controller.admin;

import com.zxd.admin.core.base.BaseController;
import com.zxd.admin.core.vo.BaseResponseVO;
import com.zxd.admin.core.vo.PageVO;
import com.zxd.admin.dto.SystemUserQuery;
import com.zxd.admin.entity.SysUser;
import com.zxd.admin.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "系统用户接口")
@RestController
@RequestMapping("/system/user")
@RequiredArgsConstructor
public class SysUserController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation(value = "获取系统用户列表")
    @GetMapping("/list")
    public BaseResponseVO<PageVO> list(SystemUserQuery query) {
          List<SysUser> list =   sysUserService.list();
          PageVO page = new PageVO<>(list);
          return BaseResponseVO.ok(page);
    }

}
