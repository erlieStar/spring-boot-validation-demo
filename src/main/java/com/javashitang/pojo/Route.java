package com.javashitang.pojo;

import com.javashitang.groupValidate.ValidateGroup.RouteValidStart;
import com.javashitang.groupValidate.ValidateGroup.RouteValidEnd;
import com.javashitang.util.CommonUtil;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 这个例子主要介绍了分组校验
 * 即在不同的场景下使用不同的校验规则
 */
@Data
@Builder
public class Route {

    @NotNull(groups = {RouteValidStart.class}, message = "始发地省id不能为空")
    private Integer startProvinceId;
    @NotNull(groups = {RouteValidEnd.class}, message = "目的地省id不能为空")
    private Integer endProvinceId;
    @NotNull(groups = {RouteValidStart.class, RouteValidEnd.class}, message = "详细地址不能为空")
    private String address;

    public static void main(String[] args) {
        Route route = Route.builder().build();
        String errorMsg = CommonUtil.getErrorResult(route, RouteValidStart.class);
        // 始发地省id不能为空 详细地址不能为空
        System.out.println(errorMsg);

        route = Route.builder().startProvinceId(1).address("详细地址").build();
        errorMsg = CommonUtil.getErrorResult(route, RouteValidStart.class);
        // ""
        System.out.println(errorMsg);

        route = Route.builder().address("详细地址").build();
        errorMsg = CommonUtil.getErrorResult(route, RouteValidEnd.class);
        // 目的地省id不能为空
        System.out.println(errorMsg);
    }

}
