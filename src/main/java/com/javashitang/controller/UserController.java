package com.javashitang.controller;

import com.javashitang.common.ServerResponse;
import com.javashitang.pojo.Student;
import com.javashitang.util.CommonUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: lilimin
 * @Date: 2019/10/20 20:48
 */
@RestController
public class UserController {

    @RequestMapping("regist")
    public ServerResponse regist(@RequestParam("name") String name,
                                 @RequestParam("phone") String phone,
                                 @RequestParam("email") String email) {
        if (StringUtils.isBlank(name)) {
            return ServerResponse.illegalArgument("用户名不能为空");
        }
        // 其他一堆校验过程,调用service
        return ServerResponse.success();
    }

    @RequestMapping("registV2")
    public ServerResponse registV2(@Valid @RequestBody Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> errorList = bindingResult.getFieldErrors();
            if (CollectionUtils.isNotEmpty(errorList)) {
                return ServerResponse.illegalArgument(errorList.get(0).getDefaultMessage());
            }
        }
        // 调用service
        return ServerResponse.success();
    }

    /**
     * @Validated 比 @Valid 更强大，支持嵌套校验，分组校验
     */
    @RequestMapping("registV3")
    public ServerResponse registV3(@Validated @RequestBody Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> errorList = bindingResult.getFieldErrors();
            if (CollectionUtils.isNotEmpty(errorList)) {
                return ServerResponse.illegalArgument(errorList.get(0).getDefaultMessage());
            }
        }
        // 调用service
        return ServerResponse.success();
    }

    @RequestMapping("registV4")
    public ServerResponse registV4(@Validated @RequestBody Student student) {
        String errorMsg = CommonUtil.getErrorResult(student);
        if (StringUtils.isNotEmpty(errorMsg)) {
            return ServerResponse.illegalArgument(errorMsg);
        }
        // 调用service
        return ServerResponse.success();
    }
}
