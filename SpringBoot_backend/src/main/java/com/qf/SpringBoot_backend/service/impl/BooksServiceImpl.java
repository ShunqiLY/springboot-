package com.qf.SpringBoot_backend.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.qf.SpringBoot_backend.entity.Books;
import com.qf.SpringBoot_backend.mapper.BooksMapper;
import com.qf.SpringBoot_backend.service.BooksService;
import com.qf.SpringBoot_backend.utils.Result;
import kotlin.jvm.internal.Lambda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BooksMapper booksMapper;
    @Override
    public Result<?> save(Books books) {

        booksMapper.insert(books);
        return Result.success();
    }

    @Override
    public Result<?> update(Books books) {
        booksMapper.updateById(books);
        return Result.success();
    }

    @Override
    public Result<?> delete(Long id) {
        booksMapper.deleteById(id);
        return Result.success();
    }

    @Override
    public Result<?> getById(Long id) {
        Books books = booksMapper.selectById(id);
        return Result.success();
    }

    @Override
    public Result<?> findPage(Integer pageNum, Integer pageSize, String search) {
       LambdaQueryWrapper<Books> wrapper = Wrappers.<Books>lambdaQuery();
       if(StrUtil.isNotBlank(search))wrapper.like(Books::getName,search);
       Page<Books> booksPage = booksMapper.selectPage(new Page<>(pageNum,pageSize),wrapper);


        return Result.success();
    }
}
