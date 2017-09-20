package com.freshen.util;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;    
import java.util.Enumeration;
import java.util.Properties;   
import java.util.Vector;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;    
import javax.mail.BodyPart;    
import javax.mail.Message;    
import javax.mail.MessagingException;    
import javax.mail.Multipart;    
import javax.mail.Session;    
import javax.mail.Transport;    
import javax.mail.internet.InternetAddress;    
import javax.mail.internet.MimeBodyPart;    
import javax.mail.internet.MimeMessage;    
import javax.mail.internet.MimeMultipart; 
import javax.mail.internet.MimeUtility;

import com.freshen.entity.Customer;
import com.freshen.entity.OrderDetail;
import com.freshen.entity.basis.CustomerUser;
import com.freshen.entity.basis.Employee;
import com.freshen.preorder.service.IcustomerService;
import com.freshen.preorder.service.IcustomerUserService;
import com.freshen.preorder.service.IorderInfoService;
import com.freshen.preorder.service.impl.CustomerServiceImpl;
import com.freshen.preorder.service.impl.CustomerUserServiceImpl;
import com.freshen.preorder.service.impl.OrderInfoServiceImpl;
import com.lowagie.text.List;
public class SimpleMailSender {
	
	/**  
	  * 以文本格式发送邮件  
	  * @param mailInfo 待发送的邮件的信息  
	  */   
	    public boolean sendTextMail(MailSenderInfo mailInfo) {   
	      // 判断是否需要身份认证   
	      MyAuthenticator authenticator = null;   
	      Properties pro = mailInfo.getProperties();  
	      if (mailInfo.isValidate()) {   
	      // 如果需要身份认证，则创建一个密码验证器   
	        authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());   
	      }  
	      // 根据邮件会话属性和密码验证器构造一个发送邮件的session   
	      Session sendMailSession = Session.getDefaultInstance(pro,authenticator);   
	      try {   
	      // 根据session创建一个邮件消息
	      Message mailMessage = new MimeMessage(sendMailSession);   
	      // 创建邮件发送者地址   
	      Address from = new InternetAddress(mailInfo.getFromAddress());   
	      // 设置邮件消息的发送者   
	      mailMessage.setFrom(from);   
	      // 创建邮件的接收者地址，并设置到邮件消息中   
	      Address to = new InternetAddress(mailInfo.getToAddress());   
	      mailMessage.setRecipient(Message.RecipientType.TO,to);   
	      // 设置邮件消息的主题   
	      mailMessage.setSubject(mailInfo.getSubject());   
	      // 设置邮件消息发送的时间   
	      mailMessage.setSentDate(new Date());   
	      // 设置邮件消息的主要内容   
	      String mailContent = mailInfo.getContent();   
	      if(mailContent==null){
	    	  mailContent = "";
	      }
	      mailMessage.setText(mailContent);   
	      // 发送邮件   
	      Transport.send(mailMessage);  
	      return true;   
	      } catch (MessagingException ex) {   
	          ex.printStackTrace();   
	      }   
	      return false;   
	    }
	      
	    /**  
	      * 以HTML格式发送邮件  
	      * @param mailInfo 待发送的邮件信息  
	      */   
	    public static boolean sendHtmlMail(MailSenderInfo mailInfo){   
	      // 判断是否需要身份认证   
	      MyAuthenticator authenticator = null;  
	      Properties pro = mailInfo.getProperties();  
	      //如果需要身份认证，则创建一个密码验证器    
	      if (mailInfo.isValidate()) {   
	        authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());  
	      }   
	      // 根据邮件会话属性和密码验证器构造一个发送邮件的session   
	      Session sendMailSession = Session.getDefaultInstance(pro,authenticator);   
	      try {   
	      // 根据session创建一个邮件消息   
	      Message mailMessage = new MimeMessage(sendMailSession);   
	      // 创建邮件发送者地址   
	      Address from = new InternetAddress(mailInfo.getFromAddress());   
	      // 设置邮件消息的发送者   
	      mailMessage.setFrom(from);   
	      // 创建邮件的接收者地址，并设置到邮件消息中   
	      String toAddress = mailInfo.getToAddress();
	      String[] toAddresser = toAddress.split("vv");
	      String toList = getMailList(toAddresser);
	      InternetAddress[] iaToList = new InternetAddress().parse(toList); 
	      
	     // Address to = new InternetAddress(mailInfo.getToAddress());
	      // Message.RecipientType.TO属性表示接收者的类型为TO   
	      mailMessage.setRecipients(Message.RecipientType.TO,iaToList);   
	      
	      // 设置邮件消息的主题   
	      mailMessage.setSubject(mailInfo.getSubject());   
	      // 设置邮件消息发送的时间   
	      mailMessage.setSentDate(new Date());   
	      // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象   
	      Multipart mainPart = new MimeMultipart();   
	      // 创建一个包含HTML内容的MimeBodyPart   
	     
	      // 设置HTML内容    添加邮件内容
	      MimeMultipart mp = new MimeMultipart();  
	      MimeBodyPart mailContentPart = new MimeBodyPart();
	      mailContentPart.setContent(mailInfo.getContent(), "text/html; charset=GBK"); 	
	      mailMessage.setContent(mailInfo.getContent(),"text/html" + ";charset=GBK");

	      mp.setSubType("related");
	      mp.addBodyPart(mailContentPart);
	      //添加附件
	      if(mailInfo.getFile()!=null&&!mailInfo.getFile().equals("")){
		      File file = new File(mailInfo.getFile());
		      Boolean b = file.exists();
		      
		      MimeBodyPart mailArchieve = new MimeBodyPart();
		      FileDataSource fds = new FileDataSource(mailInfo.getFile());
		      mailArchieve.setDataHandler(new DataHandler(fds));
			  mailArchieve.setFileName(MimeUtility.encodeText(fds.getName(),"GBK","B"));
		      mp.addBodyPart(mailArchieve);  
		      mailMessage.setContent(mp);  
	      }
	      Transport transport = sendMailSession.getTransport("smtp");   
	      transport.connect("smtp.163.com",mailInfo.getUserName(),mailInfo.getPassword());
	      transport.sendMessage(mailMessage,mailMessage.getAllRecipients());//发送邮件,其中第二个参数是所有   

	  //    mailMessage.setContent(mp+mailMessage.getContent()); 
	      // 发送邮件   
	  //    Transport.send(mailMessage);   
	      return true;   
	      } catch (Exception ex) {   
	          ex.printStackTrace();   
	      }   
	      return false;   
	    }   
	    
	    //客户审核调用
	    public void sendCustomerCheckMail(String customerid){
	    	try{
	    		
	    		IcustomerService icustomerService = new CustomerServiceImpl();
		    	Customer customer = new Customer();
		    	customer.setCustomerID_s(customerid);
		    	ArrayList<Customer> list = icustomerService.getCustomer(customer,ConstantUtil.pagingNot,0);
		    	if(list!=null&&list.size()>0){
		    		customer = list.get(0);
		    	}else{
		    		return;
		    	}
		    	IcustomerUserService icustomerUserService = new CustomerUserServiceImpl();
		    	CustomerUser customerUser = new CustomerUser();
		    	customerUser.setCustomerUserID_s(customer.getCustomerUserID_s());
		    	ArrayList<CustomerUser> customerUserList = icustomerUserService.getCustomerUser(customerUser);
		    	if(customerUserList!=null&&customerUserList.size()>0){
		    		customerUser = customerUserList.get(0);
		    	}else{
		    		return;
		    	}
		    	
			    MailSenderInfo mailInfo = new MailSenderInfo();
			    mailInfo.setValidate(true);    
			    mailInfo.setUserName("capgms@163.com");
			    mailInfo.setPassword("capgms00");//您的邮箱密码    
			    mailInfo.setFromAddress("capgms@163.com");    
			    mailInfo.setToAddress(customerUser.getEmail_s());
			    mailInfo.setSubject(ConstantUtil.customerCheck_Subject);
			     
			    mailInfo.setFile("./试验预订确认单.pdf");		   
			    String content = "<h1 align='center'>盐城汽车试验场注册确认函</h1>";
			    content = content+"尊敬的客户:"+customer.getCustomerName_s()+customer.getCustomerName_s()+"您好：<br><br>";
			    content = content+"&nbsp;&nbsp;&nbsp;&nbsp;欢迎您使用盐城汽车试验场注册系统。<br><br>";
			    if(customer.getStatus_i().equals(Integer.valueOf(ConstantUtil.customerStatus_2))){
			    	content = content+"恭喜您，您注册成功。<br><br>";
			    	content = content+"您的登陆账号为:"+customer.getCustomerID_s();
			    }else{
			    	content = content+"很遗憾您注册失败。<br><br>";
			    }
			    mailInfo.setContent(content);    
			         //这个类主要来发送邮件   		      
			    sendHtmlMailnew(mailInfo);//发送文体格式    
	    	}catch(Exception e){
	    		
	    	}
	    }
	    
	    //订单审核调用
	    public void sendOrderCheckMail(String orderID_s){
	    	//获得订单信息
	    	try{
		    	IorderInfoService iorderInfoService = new OrderInfoServiceImpl();
		    	OrderDetail orderDetail = new OrderDetail();
		    	orderDetail.setOrderID_s(orderID_s);
		    	ArrayList<OrderDetail> list = iorderInfoService.getOrder(orderDetail);
		    	if(list!=null&&list.size()>0){
		    		orderDetail = list.get(0);
		    	}else{
		    		return;
		    	}
		    	//获得客户信息
		    	String customerid = orderDetail.getCustomerID_s();
		    	Customer customermodel = new  Customer();
		    	org.hibernate.Session session1 = HibernateUtil.getSession();
		    	customermodel=(Customer)session1.get(customermodel.getClass(), customerid);
		    	IcustomerUserService icustomerUserService = new CustomerUserServiceImpl();
		    	CustomerUser customerUser = new CustomerUser();
		    	customerUser.setCustomerUserID_s(orderDetail.getCustomerUserID_s());
		    	ArrayList<CustomerUser> listCustomer = icustomerUserService.getCustomerUser(customerUser);
		    	if(listCustomer!=null&&listCustomer.size()>0){
		    		customerUser = listCustomer.get(0);
		    	}
		    	 
			    MailSenderInfo mailInfo = new MailSenderInfo();
			    mailInfo.setValidate(true);    
			    mailInfo.setUserName("capgms@163.com");    
			    mailInfo.setPassword("capgms00");//您的邮箱密码    
			    mailInfo.setFromAddress("capgms@163.com");
			    
			    
			    mailInfo.setSubject(ConstantUtil.orderCheck_Subject);
			    String content = "<h1 align='center'>盐城汽车试验场预订确认函</h1>";
			    content = content+"尊敬的客户:"+customermodel.getCustomerName_s()+customerUser.getCustomerUserName_s()+"您好：<br><br>";
			    content = content+"&nbsp;&nbsp;&nbsp;&nbsp;欢迎您使用盐城汽车试验场预订系统。<br><br>";
			    if(orderDetail.getStatus_i().equals(Integer.valueOf(ConstantUtil.orderStatus_2))){
			    	String pdfName = OperationPDF.getPdfName(orderID_s);
			    	mailInfo.setFile(pdfName);
			    	mailInfo.setToAddress(customerUser.getEmail_s());
			    	content = content+"恭喜您，您预约成功。<br><br>";
			    	content = content+"您的预约订单编号为:"+orderDetail.getOrderID_s();		    	
			    }else{
			    	//失败也给客户助理发邮件
			    	Employee employee = orderDetail.getEmployee();
			    	//mailInfo.setToAddress(customerUser.getEmail_s());
			    	mailInfo.setToAddress(customerUser.getEmail_s()+"vv"+employee.getEmail_s());
			    	content = content+"很遗憾您预约失败。<br><br>";
			    }
			    mailInfo.setContent(content);    
			         //这个类主要来发送邮件   		      
			    sendHtmlMail(mailInfo);//发送文体格式
	    	}catch(Exception e){
	    		
	    	}
	    }
	    
	    public void sendOrderCheckMailnew(String orderID_s){
	    	try{
	    	//获得订单信息
		    	IorderInfoService iorderInfoService = new OrderInfoServiceImpl();
		    	OrderDetail orderDetail = new OrderDetail();
		    	orderDetail.setOrderID_s(orderID_s);
		    	ArrayList<OrderDetail> list = iorderInfoService.getOrder(orderDetail);
		    	if(list!=null&&list.size()>0){
		    		orderDetail = list.get(0);
		    	}else{
		    		return;
		    	}
		    	//获得客户信息
		    	String customerid = orderDetail.getCustomerID_s();
		    	Customer customermodel = new  Customer();
		    	org.hibernate.Session session1 = HibernateUtil.getSession();
		    	customermodel=(Customer)session1.get(customermodel.getClass(), customerid);
		    	IcustomerUserService icustomerUserService = new CustomerUserServiceImpl();
		    	CustomerUser customerUser = new CustomerUser();
		    	customerUser.setCustomerUserID_s(customermodel.getCustomerUserID_s());
		    	ArrayList<CustomerUser> listCustomer = icustomerUserService.getCustomerUser(customerUser);
		    	if(listCustomer!=null&&listCustomer.size()>0){
		    		customerUser = listCustomer.get(0);
		    	}
		    	 
			    MailSenderInfo mailInfo = new MailSenderInfo();
			    mailInfo.setValidate(true);    
			    mailInfo.setUserName("capgms@163.com");    
			    mailInfo.setPassword("capgms00");//您的邮箱密码    
			    mailInfo.setFromAddress("capgms@163.com");    
			    mailInfo.setToAddress(customerUser.getEmail_s());    
			  //  mailInfo.setToAddress("kangxiaocheng123@163.com");    
			    mailInfo.setFile("试验预订确认单.pdf");
			//    mailInfo.setToAddress("kangxiaocheng123@163.com");
			    mailInfo.setSubject(ConstantUtil.orderCheck_Subject);
			    String content = "<h1 align='center'>盐城汽车试验场预订确认函</h1>";
			    content = content+"尊敬的客户:"+customermodel.getCustomerName_s()+customerUser.getCustomerUserName_s()+"您好：<br><br>";
			    content = content+"&nbsp;&nbsp;&nbsp;&nbsp;欢迎您使用盐城汽车试验场预订系统。<br><br>";
			    if(orderDetail.getStatus_i().equals(Integer.valueOf(ConstantUtil.orderStatus_2))){
			    	content = content+"恭喜您，您预约成功。<br><br>";
			    	content = content+"您的预约订单编号为:"+orderDetail.getOrderID_s();		    	
			    }else{
			    	content = content+"很遗憾您预约失败。<br><br>";
			    }
			    mailInfo.setContent(content);    
			         //这个类主要来发送邮件   		      
			    sendHtmlMailnew(mailInfo);//发送文体格式    
	    	}catch(Exception e){
	    		
	    	}
	    }
	    
	    public static boolean sendHtmlMailnew(MailSenderInfo mailInfo){   
		      // 判断是否需要身份认证  
		      MyAuthenticator authenticator = null;  
		      Properties pro = mailInfo.getProperties();  
		      //如果需要身份认证，则创建一个密码验证器    
		      if (mailInfo.isValidate()) {   
		        authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());  
		      }   
		      // 根据邮件会话属性和密码验证器构造一个发送邮件的session   
		      Session sendMailSession = Session.getDefaultInstance(pro,authenticator);   
		      try {   
		      // 根据session创建一个邮件消息   
		      Message mailMessage = new MimeMessage(sendMailSession);   
		      // 创建邮件发送者地址   
		      Address from = new InternetAddress(mailInfo.getFromAddress());   
		      // 设置邮件消息的发送者   
		      mailMessage.setFrom(from);   
		      // 创建邮件的接收者地址，并设置到邮件消息中   
		      Address to = new InternetAddress(mailInfo.getToAddress());   
		      // Message.RecipientType.TO属性表示接收者的类型为TO   
		      mailMessage.setRecipient(Message.RecipientType.TO,to);   
		      // 设置邮件消息的主题   
		      mailMessage.setSubject(mailInfo.getSubject());   
		      // 设置邮件消息发送的时间   
		      mailMessage.setSentDate(new Date());   
		      // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象   
		      Multipart mainPart = new MimeMultipart();   
		      // 创建一个包含HTML内容的MimeBodyPart   
		      BodyPart html = new MimeBodyPart();   
		      // 设置HTML内容   
		      html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");   
		      mainPart.addBodyPart(html);   
		      // 将MiniMultipart对象设置为邮件内容   
		      mailMessage.setContent(mainPart);   
		      // 发送邮件   
		      Transport.send(mailMessage);   
		      return true;   
		      } catch (MessagingException ex) {   
		          ex.printStackTrace();   
		      }   
		      return false;   
		} 
	    
	    private static String getMailList(String[] mailArray) { 

	    	StringBuffer toList = new StringBuffer(); 
	    	int length = mailArray.length; 
	    	if (mailArray != null && length < 2) { 
	    		toList.append(mailArray[0]); 
	    	} else { 
	    		for (int i = 0; i < length; i++) { 
	    			toList.append(mailArray[i]); 
	    			if (i != (length - 1)) { 
	    				toList.append(","); 
	    			}
	    		}
	    	}
	    	return toList.toString(); 
	    }

	    public static void main(String[] args) {
	    	MailSenderInfo mailInfo = new MailSenderInfo();
	    	/*IcustomerUserService icustomerUserService = new CustomerUserServiceImpl();
	    	CustomerUser customerUser = new CustomerUser();
	    	customerUser.setCustomerUserID_s("ZC2014041008");
	    	ArrayList<CustomerUser> list = icustomerUserService.getCustomerUser(customerUser);
	    	if(list!=null&&list.size()>0){*/
	    		new SimpleMailSender().sendCustomerCheckMail("ZC2014041011");
	    //	}
	        new SimpleMailSender().sendOrderCheckMail("DD2014043024");
	    }
}
