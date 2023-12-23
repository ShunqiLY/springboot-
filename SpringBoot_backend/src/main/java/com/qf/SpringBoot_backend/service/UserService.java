package com.qf.SpringBoot_backend.service;

import com.qf.SpringBoot_backend.entity.User;
import com.qf.SpringBoot_backend.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("用户业务类")
public interface UserService {
    @ApiOperation("添加用户")
    public Result<?> save(User user);
    @ApiOperation("更新用户")
    public Result<?> update(User user);
    @ApiOperation("删除用户")
    public Result<?> delete(Long id);
    @ApiOperation("根据用户的id查询用户信息")
    public Result<?> getById(Long id);
    @ApiOperation("分页查询")
    public Result<?> findPage(Integer pageNum,Integer pageSize,String search);
    @ApiOperation("用户登录")
    public Result<?> login(User user);
    @ApiOperation("用户注册")
    public Result<?> register(User user);
}
