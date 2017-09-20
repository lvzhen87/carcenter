package com.freshen.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/**
 * 保存文件的工具类
 * @author Freshen
 *
 */
public class UploadFile {
	/**
	 * @param path 目标文件路径
	 * @param fileName  目标文件名
	 * @param uploadFile 源文件
	 * @return 成功返回 true，否则返回false
	 */
	public boolean saveFile(String path,String fileName,File uploadFile){
		boolean r=true;
		File dir =null;
		File file=null;
		FileOutputStream fos;
		FileInputStream fis;
		
		try {
			dir=new File(path);
			if(!dir.exists()) 
				dir.mkdirs();
			file=new File(dir,fileName);
			if(!file.exists())
				file.createNewFile();
			//创建 输入输出 流
			fis =new FileInputStream(uploadFile);
			fos =new FileOutputStream(file);
			byte[] buffer=new byte[8*1024];
			int count=0;
			while((count = fis.read(buffer))>0){
				fos.write(buffer,0,count);
			}
			fos.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r=false;
		}finally{
			
		}
		return r;
	}
	
}
