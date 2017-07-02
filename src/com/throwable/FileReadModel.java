package com.throwable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @projectName SimpleThrowable
 * @fileName FileReadModel.java
 * @description
 * @author lifl
 * @time 2017����6:59:17
 *
 */

public class FileReadModel {
	/**
	 * 
	 * @description
	 * ͨ��������Կ��Ի�֪��һ���ǣ�Java application��build·������Ŀ�ĵ�1����·��
	 * @param path
	 * @return String
	 * @time 2017����7:05:19
	 */
	public static String read(String path) {
		String string = "";
		File file = new File(path);
		FileReader reader = null;
		try { // ��һ��ֻ�����ļ���ȡ���׳��Ĵ���
			reader = new FileReader(file);
			try { // �ڶ��㴦���ļ���ȡ�����еĴ���
				int ch = 0;
				while ((ch = reader.read()) != -1) {
//					System.out.print((char) ch);
					string+=(char)ch;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try { // �����㴦��ر��ļ���ʱ�Ĵ���
					reader.close();
				} catch (IOException e) { // ��������㲢û�д������ƣ�����������ļ������ǿ���δ���ر�
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return string;
	}
	
	
	public static void main(String[] args){
		
		try {	//��ӡ ��ǰ·��
			File directory = new File("");//����Ϊ�� 
			System.out.println( directory.getCanonicalPath()); 
			System.out.println( directory.getAbsolutePath()); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println(read("src\\com\\config\\file\\a.txt"));
	}
	
}
