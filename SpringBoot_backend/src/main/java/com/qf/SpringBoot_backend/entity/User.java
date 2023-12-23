package com.qf.SpringBoot_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@TableName("user")
@Api("User 实体类")
@Data
public class User {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("用户id")
    private Integer id;
    private String username;
    private String password;
    @ApiModelProperty("用户昵称")
    private String nick_name;
    private Integer age;
    private String sex;
    private String address;
    @ApiModelProperty("用户角色")//1 or 2
    private Integer role;


}
