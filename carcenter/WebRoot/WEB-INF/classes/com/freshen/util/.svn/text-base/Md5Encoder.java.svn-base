package com.freshen.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Encoder {

	public static String getEncoderStr(String str){
		String temp=str;
		try {
			MessageDigest md5=MessageDigest.getInstance("MD5");
			//使用Base64格式对字符串进行编码
			sun.misc.BASE64Encoder base64Encoder=new sun.misc.BASE64Encoder();
			temp=base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
}
