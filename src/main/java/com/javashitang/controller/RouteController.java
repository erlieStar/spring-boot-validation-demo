package com.javashitang.controller;

import com.javashitang.common.ServerResponse;
import com.javashitang.groupValidate.ValidateGroup;
import com.javashitang.groupValidate.ValidateGroup.RouteValidStart;
import com.javashitang.pojo.Route;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: lilimin
 * @Date: 2019/10/20 20:48
 */
@RestController
public class RouteController {

    @RequestMapping("addRoute")
    public ServerResponse addRoute(@Validated({RouteValidStart.class}) Route route, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> errorList = bindingResult.getFieldErrors();
            if (CollectionUtils.isNotEmpty(errorList)) {
                return ServerResponse.illegalArgument(errorList.get(0).getDefaultMessage());
            }
        }
        // 调用service
        return ServerResponse.success();
    }
}
