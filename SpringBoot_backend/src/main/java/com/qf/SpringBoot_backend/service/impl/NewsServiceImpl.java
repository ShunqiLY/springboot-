package com.qf.SpringBoot_backend.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qf.SpringBoot_backend.entity.News;
import com.qf.SpringBoot_backend.mapper.NewsMapper;
import com.qf.SpringBoot_backend.service.NewsService;
import com.qf.SpringBoot_backend.utils.Result;
import net.sf.jsqlparser.statement.select.Wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public Result<?> save(News news) {
        news.setTime(new Date());
        newsMapper.insert(news);
        return Result.success();

    }

    @Override
    public Result<?> update(News news) {
        newsMapper.updateById(news);
        return Result.success();
    }

    @Override
    public Result<?> delete(Long id) {
        newsMapper.deleteById(id);
        return Result.success();
    }

    @Override
    public Result<?> getById(Long id) {
        News news = newsMapper.selectById(id);
        return Result.success();
    }

    @Override
    public Result<?> findPage(Integer pageNum, Integer pageSize, String search) {
        LambdaQueryWrapper<News> wrapper = Wrappers.<News>lambdaQuery();
        if(StrUtil.isNotBlank(search))wrapper.like(News::getTitle,search);
        Page<News> newsPage = newsMapper.selectPage(new Page<>(pageNum,pageSize),wrapper);
        return Result.success(newsPage);
    }
}
