package com.javashitang.pojo;

import com.javashitang.groupValidate.ValidateGroup.RouteValidStart;
import com.javashitang.groupValidate.ValidateGroup.RouteValidEnd;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 这个例子主要介绍了分组校验
 * 即在不同的场景下使用不同的校验规则
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Route {

    @NotNull(groups = {RouteValidStart.class}, message = "始发地省id不能为空")
    private Integer startProvinceId;
    @NotNull(groups = {RouteValidEnd.class}, message = "目的地省id不能为空")
    private Integer endProvinceId;
    @NotNull(groups = {RouteValidStart.class, RouteValidEnd.class}, message = "详细地址不能为空")
    private String address;
}
