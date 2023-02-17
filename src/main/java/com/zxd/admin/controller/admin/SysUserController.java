package com.zxd.admin.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxd.admin.core.base.BaseController;
import com.zxd.admin.core.vo.BaseResponseVO;
import com.zxd.admin.core.vo.PageVO;
import com.zxd.admin.dto.admin.SearchUserQueryDTO;
import com.zxd.admin.entity.SysUser;
import com.zxd.admin.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "系统用户接口")
@RestController
@RequestMapping("/system/user")
@RequiredArgsConstructor
public class SysUserController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation(value = "获取系统用户列表")
    @GetMapping("/list")
    public BaseResponseVO<PageVO> list(SearchUserQueryDTO query) {
          Page<SysUser> page =  sysUserService.getUserList(query);
          PageVO result = new PageVO<>(page.getRecords());
          return BaseResponseVO.ok(result);
    }

}
