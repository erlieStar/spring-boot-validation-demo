package com.st.pojo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: lilimin
 * @Date: 2019/10/20 20:58
 */
@Data
public class Relation {

    @NotBlank(message = "父亲的姓名不能为空")
    private String fatherName;
    @NotBlank(message = "母亲的姓名不能为空")
    private String motherName;
}
