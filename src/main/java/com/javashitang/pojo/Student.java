package com.javashitang.pojo;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @Author: lilimin
 * @Date: 2019/10/20 20:40
 */
@Data
public class Student {

    @NotBlank(message = "用户名不能为空")
    private String name;
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号码格式错误")
    private String phone;
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式错误")
    private String email;
    @NotNull(message = "父母名字不能为空")
    @Valid
    private Relation relation;
}
