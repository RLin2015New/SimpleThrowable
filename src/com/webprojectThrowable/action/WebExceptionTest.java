package com.webprojectThrowable.action;

import com.mythrowable.MyException;

/**
 * @projectName SimpleThrowable
 * @fileName WebExceptionTest.java
 * @description
 * @author lifl
 * @time 2017ÏÂÎç7:48:02
 *
 */

public class WebExceptionTest extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8278523342143021509L;

	public String test() throws MyException {

		try {
			System.out.println("test");
			if (Math.random() < 0.5) {
				throw new NullPointerException("aba");
			}
		} catch (Exception e) {
			MyException mye = new MyException(e);
			setException(mye);
			// TODO ´íÎóÐ´ÈÕÖ¾
			System.out.println(mye.toString());
			throw mye;
		}
		return "success";
	}

}
