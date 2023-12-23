package com.qf.SpringBoot_backend.service;

import com.qf.SpringBoot_backend.entity.Books;
import com.qf.SpringBoot_backend.entity.User;
import com.qf.SpringBoot_backend.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("书籍业务类")
public interface BooksService {
    @ApiOperation("添加书籍")
    public Result<?> save(Books books);
    @ApiOperation("更新书籍")
    public Result<?> update(Books books);
    @ApiOperation("删除书籍")
    public Result<?> delete(Long id);
    @ApiOperation("根据书籍的id查询书籍信息")
    public Result<?> getById(Long id);
    @ApiOperation("分页查询")
    public Result<?> findPage(Integer pageNum,Integer pageSize,String search);

}
