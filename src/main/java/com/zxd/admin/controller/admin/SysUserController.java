package com.zxd.admin.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxd.admin.core.base.BaseController;
import com.zxd.admin.core.vo.BaseResponseVO;
import com.zxd.admin.core.vo.PageVO;
import com.zxd.admin.dto.admin.user.AddUserCommand;
import com.zxd.admin.dto.admin.user.SearchUserQueryDTO;
import com.zxd.admin.dto.admin.user.UpdateUserCommand;
import com.zxd.admin.entity.SysUser;
import com.zxd.admin.service.SysUserService;
import com.zxd.admin.vo.admin.SysUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Api(tags = "系统用户接口")
@RestController
@RequestMapping("/system/user")
@RequiredArgsConstructor
public class SysUserController extends BaseController {

    private SysUserService sysUserService;

    @Autowired
    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @ApiOperation(value = "获取系统用户列表")
    @GetMapping("/list")
    public BaseResponseVO<PageVO<SysUserVO>> list(SearchUserQueryDTO query) {
          Page<SysUser> page =  sysUserService.getUserList(query);
          PageVO result = new PageVO<>(page.getRecords().stream().map(SysUserVO::new).collect(Collectors.toList()));
          return BaseResponseVO.ok(result);
    }

    @ApiOperation(value = "新增一个用户")
    @PostMapping
    public BaseResponseVO<?> add(@Validated @RequestBody AddUserCommand command) {
        sysUserService.addUser(command);
        return BaseResponseVO.ok();
    }

    @ApiOperation(value = "更新一个用户")
    @PutMapping
    public BaseResponseVO<?> update(@Validated @RequestBody UpdateUserCommand command) {
        sysUserService.updateUser(command);
        return BaseResponseVO.ok();
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/userIds")
    public BaseResponseVO<?> remove(@PathVariable List<Long> ids) {
        sysUserService.deleteUserByIds(ids);
        return BaseResponseVO.ok();
    }

    @ApiOperation(value = "重置用户密码")
    @PutMapping("/{userId}/password/reset")
    public BaseResponseVO<?> resetPassword(@PathVariable Long userId) {
        sysUserService.resetPassWord(userId);
        return BaseResponseVO.ok();
    }

}
