package com.javashitang.pojo;

import com.javashitang.groupValidate.ValidateGroup.RouteValidStart;
import com.javashitang.groupValidate.ValidateGroup.RouteValidEnd;
import com.javashitang.util.CommonUtil;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class Route {

		@NotNull(groups = {RouteValidStart.class}, message = "始发地省id不能为空")
		private Integer startProvinceId;
		@NotNull(groups = {RouteValidStart.class}, message = "始发地市id不能为空")
		private Integer startCityId;
		@NotNull(groups = {RouteValidEnd.class}, message = "目的地省id不能为空")
		private Integer endProvinceId;
		@NotNull(groups = {RouteValidEnd.class}, message = "目的地市id不能为空")
		private Integer endCityId;
		@NotNull(groups = {RouteValidStart.class, RouteValidEnd.class}, message = "始发地详细地址不能为空")
		private String startAddress;
		@NotNull(groups = {RouteValidStart.class, RouteValidEnd.class}, message = "目的地详细地址不能为空")
		private String endAddress;

		public static void main(String[] args) {
				Route route = Route.builder().build();
				String errorMsg = CommonUtil.getErrorResult(route, RouteValidStart.class);
				// 目的地详细地址不能为空 始发地详细地址不能为空 始发地市id不能为空 始发地省id不能为空
				System.out.println(errorMsg);
				route = Route.builder().startProvinceId(1).startCityId(1).startAddress("始发地详细地址").build();
				errorMsg = CommonUtil.getErrorResult(route, RouteValidStart.class);
				// 目的地详细地址不能为空
				System.out.println(errorMsg);
				route = Route.builder().startAddress("始发地详细地址").endAddress("目的地详细地址").build();
				errorMsg = CommonUtil.getErrorResult(route, RouteValidEnd.class);
				// 目的地省id不能为空 目的地市id不能为空
				System.out.println(errorMsg);
		}

}
