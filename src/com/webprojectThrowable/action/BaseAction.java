package com.webprojectThrowable.action;

import com.mythrowable.MyException;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @projectName SimpleThrowable
 * @fileName BaseAction.java
 * @description
 * @author lifl
 * @time 2017обнГ7:52:16
 *
 */

public class BaseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 65666089690782834L;

	private MyException exception;

	public MyException getException() {
		return exception;
	}

	public void setException(MyException exception) {
		this.exception = exception;
	}

}
