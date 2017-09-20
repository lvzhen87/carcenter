package com.freshen.preorder.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import com.freshen.util.ExceptionDispose;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;

public class DownloadFileAction extends CapgActionSupport{
	String rstr=SUCCESS;
	String filePath;
	String fileName;
	
	public String execute(){
		try {
			filePath =new String(filePath.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			ExceptionDispose.saveExceptionInfo(e);
			e.printStackTrace();
		}
		fileName=filePath.substring(filePath.lastIndexOf("\\")+1);
		//System.out.println("下载文件 "+filePath +" fileName="+fileName);
		if(filePath==null){
			rstr=ERROR;
		}
		File file =new File(filePath);
		if(!file.exists()){
			rstr=ERROR;
		}
		return rstr;
	}
	//下载流
	public InputStream getInputStream() throws Exception {
        return new FileInputStream(filePath);    //如果dir是绝对路径
//        return ServletActionContext.getServletContext().getResourceAsStream(dir);    //如果dir是Resource下的相对路径
    }
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		String fn="newfile.zip";
		try {
			fn= new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			ExceptionDispose.saveExceptionInfo(e);
			e.printStackTrace();
		}
		return fn;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
