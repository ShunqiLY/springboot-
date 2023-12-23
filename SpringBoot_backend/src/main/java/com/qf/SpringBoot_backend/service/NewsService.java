package com.qf.SpringBoot_backend.service;

import com.qf.SpringBoot_backend.entity.News;
import com.qf.SpringBoot_backend.entity.User;
import com.qf.SpringBoot_backend.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("新闻业务类")
public interface NewsService {
    @ApiOperation("添加新闻")
    public Result<?> save(News news);
    @ApiOperation("更新新闻")
    public Result<?> update(News news);
    @ApiOperation("删除新闻")
    public Result<?> delete(Long id);
    @ApiOperation("根据新闻的id查询新闻信息")
    public Result<?> getById(Long id);
    @ApiOperation("分页查询")
    public Result<?> findPage(Integer pageNum,Integer pageSize,String search);

}
