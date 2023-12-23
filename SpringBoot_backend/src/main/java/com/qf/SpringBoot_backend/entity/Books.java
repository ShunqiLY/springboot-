package com.qf.SpringBoot_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
@TableName("books")
@Api("Books 实体类")
@Data
public class Books {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("书籍id")
    private Integer id;
    private String name;
    private String price;// BigDecimal
    @ApiModelProperty("作者")
    private String author;
    @JsonFormat(pattern  = "yyyy-mm-dd hh:mm:ss",timezone = "Asia/Shanghai")
    private Date  create_time;//Timestamp
    @ApiModelProperty("图片路径")
    private String cover;
}
