package com.javashitang.pojo;

import com.javashitang.groupValidate.ValidateGroup;
import com.javashitang.util.CommonUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class RouteTest {

    @Test
    public void test() {
        Route route = Route.builder().build();
        String errorMsg = CommonUtil.getErrorResult(route, ValidateGroup.RouteValidStart.class);
        // 始发地省id不能为空 详细地址不能为空
        System.out.println(errorMsg);

        route = Route.builder().startProvinceId(1).address("详细地址").build();
        errorMsg = CommonUtil.getErrorResult(route, ValidateGroup.RouteValidStart.class);
        // ""
        System.out.println(errorMsg);

        route = Route.builder().address("详细地址").build();
        errorMsg = CommonUtil.getErrorResult(route, ValidateGroup.RouteValidEnd.class);
        // 目的地省id不能为空
        System.out.println(errorMsg);
    }
}