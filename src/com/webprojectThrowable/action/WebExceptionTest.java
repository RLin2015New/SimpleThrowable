package com.webprojectThrowable.action;

import com.mythrowable.MyException;

/**
 * @projectName SimpleThrowable
 * @fileName WebExceptionTest.java
 * @description
 * @author lifl
 * @time 2017обнГ7:48:02
 *
 */

public class WebExceptionTest extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8278523342143021509L;

	public String test() throws MyException {
		System.out.println("test");
		MyException e = new MyException(new NullPointerException("aba"));
		setException(e);
		throw e;
	}

}
