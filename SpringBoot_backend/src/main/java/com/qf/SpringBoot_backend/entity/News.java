package com.qf.SpringBoot_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.sql.Timestamp;

@TableName("news")
@Api("News 实体类")
@Data
public class News {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("新闻id")
    private Integer id;
    private String title;
    private String content;
    private String author;
    @JsonFormat(pattern  = "yyyy-mm-dd hh:mm:ss",timezone = "Asia/Shanghai")
    private Date time;
}
