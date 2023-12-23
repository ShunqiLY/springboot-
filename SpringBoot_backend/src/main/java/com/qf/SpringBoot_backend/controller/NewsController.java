package com.qf.SpringBoot_backend.controller;

import com.qf.SpringBoot_backend.entity.News;
import com.qf.SpringBoot_backend.entity.User;
import com.qf.SpringBoot_backend.service.NewsService;
import com.qf.SpringBoot_backend.service.UserService;
import com.qf.SpringBoot_backend.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/news")
@Api("新闻控制器层")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @PostMapping
    @ApiOperation("添加用户")
    public Result<?> save(@RequestBody News news){
        return newsService.save(news);
    };

    @PutMapping
    @ApiOperation("更新用户")
    public Result<?> update(@RequestBody News news){
        return newsService.update(news);
    };

    @DeleteMapping("/{id}")
    @ApiOperation("删除用户")
    public Result<?> delete(@PathVariable Long id){
        return newsService.delete(id);
    };
    @GetMapping("/{id}")
    @ApiOperation("根据用户的id查询用户信息")
    public Result<?> getById(@PathVariable Long id){
        return newsService.getById(id);
    };

    @GetMapping
    @ApiOperation("分页查询")
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10")Integer pageSize,
                              @RequestParam(defaultValue = "")String search){
        return newsService.findPage(pageNum,pageSize,search);
    };


}
