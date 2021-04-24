package com.javashitang.controller;

import com.javashitang.common.ServerResponse;
import com.javashitang.groupValidate.ValidateGroup.RouteValidStart;
import com.javashitang.pojo.Route;
import com.javashitang.util.CommonUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ServerResponse addRoute(@RequestBody @Validated({RouteValidStart.class}) Route route, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> errorList = bindingResult.getFieldErrors();
            if (CollectionUtils.isNotEmpty(errorList)) {
                return ServerResponse.illegalArgument(errorList.get(0).getDefaultMessage());
            }
        }
        // 调用service
        return ServerResponse.success();
    }

    @RequestMapping("addRouteV2")
    public ServerResponse addRouteV2(@RequestBody Route route) {
        String errorMsg = CommonUtil.getErrorResult(route, RouteValidStart.class);
        if (StringUtils.isNotEmpty(errorMsg)) {
            return ServerResponse.illegalArgument(errorMsg);
        }
        // 调用service
        return ServerResponse.success();
    }
}
