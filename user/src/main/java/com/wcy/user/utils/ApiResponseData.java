package com.wcy.user.utils;

import lombok.Data;

/**
 * <p>
 * 通用的 API 接口封装
 * </p>
 *
 * @package: com.xkcoding.exception.handler.model
 * @description: 通用的 API 接口封装
 * @author: yangkai.shen
 * @date: Created in 2018/10/2 8:57 PM
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Data
public class ApiResponseData {
	/**
	 * <p>
	 * 本次服务的返回码信息
	 * value = "本次服务的返回码信息，0：计算成功，1：计算异常"
	 * <ul>
	 * <li>1计算成功</li>
	 * <li>0计算异常</li>
	 * </ul>
	 * </p>
	 */
	private Integer code;

	/**
	 * 错误信息说明或者正常信息说明
	 */

	private String message;

	/**
	 * 具体的返回数据，均已json格式数据返回
	 * 具体的返回数据，均已json格式数据返回
	 */

	private Object data;

	/**
	 * 无参构造函数
	 */
	public ApiResponseData() {
		this.code = 1;
		this.message = "";
	}

	/**
	 * 全参构造函数
	 *
	 * @param code    状态码
	 * @param message 返回内容
	 * @param rule_result    返回数据
	 */
	public ApiResponseData(Integer code, String message, Object rule_result) {
		this.code = code;
		this.message = message;
		this.data = rule_result;
	}

	/**
	 * 构造一个自定义的API返回
	 *
	 * @param code    状态码
	 * @param message 返回内容
	 * @param rule_result    返回数据
	 * @return ApiResponseData
	 */
	public static ApiResponseData of(Integer code, String message, Object rule_result) {
		return new ApiResponseData(code, message, rule_result);
	}
}
