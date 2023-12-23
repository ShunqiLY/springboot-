package com.qf.SpringBoot_backend.controller;

import com.qf.SpringBoot_backend.entity.User;
import com.qf.SpringBoot_backend.service.UserService;
import com.qf.SpringBoot_backend.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api("用户控制器层")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    @ApiOperation("添加用户")
    public Result<?> save(User user){
        return userService.save(user);
    };

    @PutMapping
    @ApiOperation("更新用户")
    public Result<?> update(@RequestBody User user){
        return userService.update(user);
    };

    @DeleteMapping("/{id}")
    @ApiOperation("删除用户")
    public Result<?> delete(@PathVariable Long id){
        return userService.delete(id);
    };
    @GetMapping("/{id}")
    @ApiOperation("根据用户的id查询用户信息")
    public Result<?> getById(@PathVariable Long id){
        return userService.getById(id);
    };

    @GetMapping
    @ApiOperation("分页查询")
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10")Integer pageSize,
                              @RequestParam(defaultValue = "")String search){
        return userService.findPage(pageNum,pageSize,search);
    };

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Result<?> login(@RequestBody User user){
        System.out.println(user);
        return userService.login(user);
    };

    @PostMapping("/register")
    @ApiOperation("用户注册")
    public Result<?> register(@RequestBody User user){
        return userService.register(user);
    };
}
