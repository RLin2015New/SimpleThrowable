package com.mythrowable;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName SimpleThrowable
 * @fileName MyException.java
 * @description
 * @author lifl
 * @time 2017����7:22:18
 *
 */

public class MyException extends Exception {

	
	private static final long serialVersionUID = -8214275875995584647L;
	
	/**
	 * һ���򵥵Ļ��ڴ����б��ʵ�֣���ǰ̨��ʾ����ź�ָ��������ʾ������־�м�¼ʵ�ʴ����¼
	 */
	private static Map<Integer, String> errorMaps = new HashMap<Integer, String>();
	static{
		errorMaps.put(1000, "ԭ�ʹ���");
		errorMaps.put(1001, "���Զ�·");
		errorMaps.put(1002, "��Ѫ��ù���");
	}
	
	private int errorCode;
	/**
	 * ���ڴ���ϵͳ�Դ�����
	 * @param e
	 */
	public MyException(Exception e){
		super(e.getMessage());
		errorCode = 1000;
	}
	/**
	 * ���ڴ����Զ������
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
					throw new MyException(1001, "�ⶼ���У�С��0.5");
				}else if(r < 0.6 ){
					throw new MyException(1002, "��Ҳ�У�����0.5");
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


