package com.freshen.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.entity.Customer;
import com.freshen.entity.OrderDetail;
import com.freshen.entity.PdfInfo;
import com.freshen.entity.basis.CustomerUser;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.process.OccupyConsumerLists;
import com.freshen.hibernate.HibernateSessionFactory;

/**
 * 
 *     
 * 项目名称：capg    
 * 类名称：OperationPDF    
 * 类描述：    
 * 创建人：kxc    
 * 创建时间：2014-3-26 下午01:53:03    
 * 修改人：kxc    
 * 修改时间：2014-3-26 下午01:53:03    
 * 修改备注：    
 * **
 * @version     
 *
 */
public class OperationPDF {
	
	private static Session session = null;
	//private static Transaction tx = null;
	/**
	 * 
	 * getPDFInfo 获得填充信息 
	 * @param   orderID_s   
	 * @param  @return    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public static PdfInfo getPDFInfo(String orderID_s) throws Exception 
	{		
		PdfInfo pdfInfomodel = new PdfInfo();
		OrderDetail order = getOrderInfo(orderID_s);
		if(order==null)
		{
			 throw new Exception("该订单不存在");
		}
		Customer customer = new Customer();
		if(order.getCustomerID_s()!=null){
			customer = getCustomerInfo(order.getCustomerID_s());
			if(customer==null){
				customer = new Customer();
			}
		}
		Employee employee = new Employee();
		if(order.getEmployeeID_s()!=null){
			employee = getEmployeeInfo(order.getEmployeeID_s());
		}
		OccupyConsumerLists occupyConsumerLists = new OccupyConsumerLists();
		pdfInfomodel.setProperty(order, customer, employee,occupyConsumerLists);
		return pdfInfomodel;
	}

	/**
	 * generatePDF 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public static void generatePDF(String jasperFilePath,String orderID_s)throws Exception {  	      
	    List tmpList = new ArrayList();  
	    try {  
	    	  PdfInfo bean = getPDFInfo(orderID_s);
	    	  bean.setWelcoming_s("欢迎");
	          tmpList.add(bean);
	          File jasper = new File(jasperFilePath);
	          //System.out.println("成功1");	          
	          Map<String, Object> params = new HashMap<String, Object>();   
	          JasperPrint jasperPrint = JasperFillManager.fillReport(new FileInputStream(jasper),params,new JRBeanCollectionDataSource(tmpList));	           
	          //System.out.println("成功12");	
	          JRPdfExporter exporter = new JRPdfExporter();  
	          exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint); 
	          String pdfName = getPdfName(orderID_s);
	          exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, pdfName);
	          exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");  
	          //System.out.println("成功3");	
	          exporter.exportReport();  			             
		 } catch (Exception e) {  
			 e.printStackTrace();
			 throw new Exception(e);
		 }  	         
	}
	/**
	 * 	   
	 * getEmployeeInfo 
	 * @param   name    
	 * @param  @return    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	private static Employee getEmployeeInfo(String employeeIDS) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		session = HibernateSessionFactory.getSession();
	 
		employee=(Employee) session.get(employee.getClass(), employeeIDS);
	 
		return employee;
	 
	}

	/**
	 * 
	 * getCustomerInfo :获得客户信息
	 * @param   name    
	 * @param  @return    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	private static Customer getCustomerInfo(String customerIDS) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		session = HibernateSessionFactory.getSession();
	 
		customer=(Customer) session.get(customer.getClass(), customerIDS);
	 
		return customer;
		
	}

	/**
	 * 
	   
	 * getOrderInfo 
	 * @param   orderIDS    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	private static OrderDetail getOrderInfo(String orderIDS) {
		// TODO Auto-generated method stub
		OrderDetail orderDetail = new OrderDetail();
		session = HibernateSessionFactory.getSession();
 
		orderDetail=(OrderDetail) session.get(orderDetail.getClass(), orderIDS);
	 
		return orderDetail;
	}
	
	public static String getPdfName(String orderID_s){
		String pdfName="";
		try {
			PdfInfo bean = getPDFInfo(orderID_s);
			pdfName= "c:\\"+bean.getCustomerName_s()+bean.getOrderName_s()+bean.getReservationDate_s().substring(0, 10)+".pdf";
			return pdfName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pdfName;
	}
	public static void main(String[] arg)
	{
	 
			
			OperationPDF OperationPDF = new OperationPDF();
		//	OperationPDF.getPDFInfo("1395548379389");
			try {
				//OperationPDF.generatePDF("./src/com/freshen/file/pdf/江苏盐城试验场确认函.jasper", "DD2014041006");
				new SimpleMailSender().sendOrderCheckMail("DD2014041006");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("成功");
		 
	}
	
}
