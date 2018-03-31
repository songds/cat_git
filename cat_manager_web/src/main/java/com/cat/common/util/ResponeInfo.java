package com.cat.common.util;

import lombok.Data;

@Data
public class ResponeInfo<T>{

	private String code;
	private String message;
	private T data;

	public ResponeInfo(String code,String message,T data){
		this.code=code;
		this.message=message;
		this.data=data;
	}
	
	public ResponeInfo(){}
	
	public  static <T> ResponeInfo<T>  ok(T data){
		return new ResponeInfo<T>("SUC000","成功",data);
	}
	
	public  static <T> ResponeInfo<T>  error(String message,T data){
		return new ResponeInfo<T>("F00001",message,data);
	}
	
}
