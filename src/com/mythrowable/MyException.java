package com.mythrowable;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName SimpleThrowable
 * @fileName MyException.java
 * @description
 * @author lifl
 * @time 2017下午7:22:18
 *
 */

public class MyException extends Exception {

	
	private static final long serialVersionUID = -8214275875995584647L;
	
	/**
	 * 一个简单的基于错误列表的实现，给前台提示错误号和指定错误提示；在日志中记录实际错误记录
	 */
	private static Map<Integer, String> errorMaps = new HashMap<Integer, String>();
	static{
		errorMaps.put(1000, "原型错误");
		errorMaps.put(1001, "大脑短路");
		errorMaps.put(1002, "鸡血打得过多");
	}
	
	private int errorCode;
	/**
	 * 用于处理系统自带错误
	 * @param e
	 */
	public MyException(Exception e){
		super(e.getMessage());
		errorCode = 1000;
	}
	/**
	 * 用于处理自定义错误
	 * @param code
	 * @param description
	 */
	public MyException(int code,String description){
		super(description);
		errorCode = code;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	public String toString(){
		return errorCode+":"+errorMaps.get(errorCode)+" ___:"+getMessage();
	}
	
	public String getErrorMessage(){
		return errorCode+":"+errorMaps.get(errorCode);
	}
	
	public static void main(String[] args){
			try {
				double r = Math.random();
				if (r < 0.3) {
					throw new MyException(1001, "这都能行，小于0.5");
				}else if(r < 0.6 ){
					throw new MyException(1002, "这也行，大于0.5");
				}else{
					throw new MyException(new NullPointerException());
				}
			} catch (Exception e) {
				// TODO: handle exception
//				System.out.println(e.toString());
				e.printStackTrace();
			}
	}

}


