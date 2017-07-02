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
 * @time 2017下午6:59:17
 *
 */

public class FileReadModel {
	/**
	 * 
	 * @description
	 * 通过这个测试可以获知的一点是，Java application的build路径是项目的第1级主路径
	 * @param path
	 * @return String
	 * @time 2017下午7:05:19
	 */
	public static String read(String path) {
		String string = "";
		File file = new File(path);
		FileReader reader = null;
		try { // 第一层只处理文件读取器抛出的错误
			reader = new FileReader(file);
			try { // 第二层处理文件读取过程中的错误
				int ch = 0;
				while ((ch = reader.read()) != -1) {
//					System.out.print((char) ch);
					string+=(char)ch;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try { // 第三层处理关闭文件流时的错误
					reader.close();
				} catch (IOException e) { // 理论上这层并没有处理完善，如果这层出错，文件流还是可能未被关闭
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
		
		try {	//打印 当前路径
			File directory = new File("");//参数为空 
			System.out.println( directory.getCanonicalPath()); 
			System.out.println( directory.getAbsolutePath()); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println(read("src\\com\\config\\file\\a.txt"));
	}
	
}
