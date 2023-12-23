package com.qf.SpringBoot_backend.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qf.SpringBoot_backend.entity.User;
import com.qf.SpringBoot_backend.mapper.UserMapper;
import com.qf.SpringBoot_backend.service.UserService;
import com.qf.SpringBoot_backend.utils.Result;

import kotlin.jvm.internal.Lambda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result<?> save(User user) {
        if(user.getPassword() == null)user.setPassword("123456");//设置初始密码
        userMapper.insert(user);
        return Result.success();
    }

    @Override
    public Result<?> update(User user) {
        userMapper.updateById(user);
        return Result.success();
    }

    @Override
    public Result<?> delete(Long id) {
        userMapper.deleteById(id);
        return Result.success();
    }

    @Override
    public Result<?> getById(Long id) {
        User user = userMapper.selectById(id);
        return Result.success(user);
    }

    @Override
    public Result<?> findPage(Integer pageNum, Integer pageSize, String search) {
        //获取自定义条件对象
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
        //sql:通过like模糊查询nick_name
        //isnotblank：判断是否为空
        if(StrUtil.isNotBlank(search))wrapper.like(User::getNick_name,search);
        Page<User> userPage = userMapper.selectPage(new Page<>(pageNum,pageSize),wrapper);
        return Result.success(userPage);
    }

    @Override
    public Result<?> login(User user) {
        User user_data = userMapper.selectOne(Wrappers.<User>lambdaQuery()
                .eq(User::getUsername,user.getUsername())
                .eq(User::getPassword,user.getPassword()));
        if(user_data == null) return Result.error("1","用户名称或者密码错误");
        return Result.success(user_data);
    }

    @Override
    public Result<?> register(User user) {
        User user_data = userMapper.selectOne(Wrappers.<User>lambdaQuery()
                .eq(User::getUsername,user.getUsername()));
        if (user_data != null)return Result.error("1","用户名已被占用");
        if(user.getPassword() == null)user.setPassword("123456");
        userMapper.insert(user);
        return Result.success();
    }
}

