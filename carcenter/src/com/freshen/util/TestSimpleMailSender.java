package com.freshen.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class TestSimpleMailSender {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		 //这个类主要是设置邮件   
	      MailSenderInfo mailInfo = new MailSenderInfo();    
	      mailInfo.setMailServerHost("smtp.163.com");    
	      mailInfo.setMailServerPort("25");    
	      mailInfo.setValidate(true);    
	      mailInfo.setUserName("kangxiaocheng123@163.com");    
	      mailInfo.setPassword("831229ll");//您的邮箱密码    
	      mailInfo.setFromAddress("kangxiaocheng123@163.com");    
	      mailInfo.setToAddress("kangxiaochen83@163.com");    
	      mailInfo.setSubject("capg试验");    
	      mailInfo.setContent("capg发送邮件试验\r\naa");    
	         //这个类主要来发送邮件   
	      SimpleMailSender sms = new SimpleMailSender();   
	          sms.sendTextMail(mailInfo);//发送文体格式    
	          //sms.sendHtmlMail(mailInfo);//发送html格式   
		
		/*SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s =sdf.format(new Date());
		//System.out.println( s.subSequence(0, 4)+ s.substring(5,7)  );*/
		
	}

}
