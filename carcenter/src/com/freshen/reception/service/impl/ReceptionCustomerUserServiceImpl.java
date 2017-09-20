package com.freshen.reception.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.entity.CustomerRegister;
import com.freshen.entity.basis.CustomerUser;
import com.freshen.entity.reception.ReceptionCustomerUser;
import com.freshen.preorder.service.IcustomerRegisterService;
import com.freshen.preorder.service.IcustomerUserService;
import com.freshen.preorder.service.impl.CustomerRegisterServiceimpl;
import com.freshen.preorder.service.impl.CustomerUserServiceImpl;
import com.freshen.reception.service.IreceptionCustomerUserService;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class ReceptionCustomerUserServiceImpl extends ClimsServiceBase implements IreceptionCustomerUserService{

	String customerUserID_s, orderID_s, customerUserName_s;
	Integer userType_i;
	Date createDate_t;
	String createUser_s, lastUpdateUser_s;
	Date lastUpdateDate_t;
	String resaveds1_s, resaveds2_s, resaveds3_s, resaveds4_s, resaveds5_s;
	String userType_s;
	
	String invoiceAddress_s;
	String registerAddress_s;
	String responsibleUserID_s;
	String invoiceUserID_s;
	
	String card_s;
	
	Date invalidate_t;
	
	Session session= HibernateUtil.getSession();
	Transaction tx = null;
	public ArrayList<ReceptionCustomerUser> getReceptionCustomerUser(
			ReceptionCustomerUser receptionCustomerUser, int start, int size) throws Exception{
		// TODO Auto-generated method stub
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			List<ReceptionCustomerUser> list = new ArrayList();
			//CustomerUser customerUsermodel = new CustomerUser();
			if(receptionCustomerUser==null){
				//System.out.println("执行无条件查询 分页");
				Query query=session.createQuery("from ReceptionCustomerUser");
				if(start!=ConstantUtil.pagingNot){
					query.setFirstResult(start);
				    query.setMaxResults(size);
				}
			    list = query.list();	  			
				return (ArrayList) list;
			}
			
			customerUserID_s = receptionCustomerUser.getCustomerUserID_s();
			orderID_s = receptionCustomerUser.getOrderID_s();
			customerUserName_s = receptionCustomerUser.getCustomerUserName_s();
			userType_i = receptionCustomerUser.getUserType_i();
			createDate_t = receptionCustomerUser.getCreateDate_t();
			createUser_s = receptionCustomerUser.getCreateUser_s();
			lastUpdateDate_t = receptionCustomerUser.getLastUpdateDate_t();
			lastUpdateUser_s = receptionCustomerUser.getLastUpdateUser_s();
			resaveds1_s = receptionCustomerUser.getResaveds1_s();
			resaveds2_s = receptionCustomerUser.getResaveds2_s();
			resaveds3_s = receptionCustomerUser.getResaveds3_s();
			resaveds4_s = receptionCustomerUser.getResaveds4_s();
			resaveds5_s = receptionCustomerUser.getResaveds5_s();
			
			userType_s=receptionCustomerUser.getUserType_s();
			
			/*if(customerUserID_s!=null && orderID_s!=null){
				receptionCustomerUser.setCustomerUserID_s(customerUserID_s);
				receptionCustomerUser.setOrderID_s(orderID_s);
				receptionCustomerUser=(ReceptionCustomerUser)session.load(receptionCustomerUser.getClass(), orderID_s);
				list.add(receptionCustomerUser);
		    	return (ArrayList)list;
			}*/
			String hql="from ReceptionCustomerUser as receptionCustomerUser where 1=1 "; 
		    String condition = "";
		    if(customerUserID_s!=null){
		    	condition = " and receptionCustomerUser.customerUserID_s like '%"+customerUserID_s+"%'";
		    }
		    if(orderID_s!=null){
		    	condition = condition+" and receptionCustomerUser.orderID_s like '%"+orderID_s.trim()+"%'";
		    }
		    if(customerUserName_s!=null){
		    	condition = condition+" and receptionCustomerUser.customerUserName_s like '%"+customerUserName_s+"%'";
		    }
		    card_s = receptionCustomerUser.getCard_s();
		    if(card_s!=null){
		    	condition = condition+" and receptionCustomerUser.card_s like '%"+card_s+"%'";
		    }
		    if(userType_i!=null){
		    	condition = condition+" and receptionCustomerUser.userType_i='"+userType_i+"'";
		    }
		    if(userType_s!=null){
		    	String[] types=userType_s.split("vv");
		    	for(int i=0;i<types.length;i++){
		    		if(i==0){
		    			condition = condition+" and (receptionCustomerUser.userType_i='"+types[i]+"'";
		    		}else{
		    			condition = condition+" or receptionCustomerUser.userType_i='"+types[i]+"'";
		    		}
		    		if(i==types.length-1){
		    			condition = condition+")";
		    		}
		    	}	 
 		    }
		    if(createDate_t!=null){
		    	condition = condition+" and to_char(receptionCustomerUser.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s!=null){
		    	condition = condition+" and receptionCustomerUser.createUser_s like '%"+createUser_s+"%'";
		    }
		    if(lastUpdateDate_t!=null){
		    	condition = condition+" and to_char(receptionCustomerUser.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    invalidate_t = receptionCustomerUser.getInvalidate_t();
		    if(invalidate_t!=null){
		    	condition = condition+" and to_char(receptionCustomerUser.invalidate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(invalidate_t, "yyyy-MM-dd") +"'";
		    }
		    if(lastUpdateUser_s!=null){
		    	condition = condition+" and receptionCustomerUser.lastUpdateUser_s like '%"+lastUpdateUser_s+"%'";
		    }
		    if(resaveds1_s!=null){
		    	condition = condition+" and receptionCustomerUser.resaveds1_s like '%"+resaveds1_s+"%'";
		    }
		    if(resaveds2_s!=null){
		    	condition = condition+" and receptionCustomerUser.resaveds2_s like '%"+resaveds2_s+"%'";
		    }
		    if(resaveds3_s!=null){
		    	condition = condition+" and receptionCustomerUser.resaveds3_s like '%"+resaveds3_s+"%'";
		    }
		    if(resaveds4_s!=null){
		    	condition = condition+" and receptionCustomerUser.resaveds4_s like '%"+resaveds4_s+"%'";
		    }
		    if(resaveds5_s!=null){
		    	condition = condition+" and receptionCustomerUser.resaveds5_s like '%"+resaveds5_s+"%'";
		    }
		    invoiceAddress_s = receptionCustomerUser.getInvoiceAddress_s();
			registerAddress_s = receptionCustomerUser.getRegisterAddress_s();
			responsibleUserID_s = receptionCustomerUser.getResponsibleUserID_s();
			invoiceUserID_s = receptionCustomerUser.getInvoiceUserID_s();
			if(invoiceAddress_s!=null){
		    	condition = condition+" and receptionCustomerUser.invoiceAddress_s like '%"+invoiceAddress_s+"%'";
		    }
		    if(registerAddress_s!=null){
		    	condition = condition+" and receptionCustomerUser.registerAddress_s like '%"+registerAddress_s+"%'";
		    }
		    if(responsibleUserID_s!=null){
		    	condition = condition+" and receptionCustomerUser.responsibleUserID_s like '%"+responsibleUserID_s+"%'";
		    }
		    if(invoiceUserID_s!=null){
		    	condition = condition+" and receptionCustomerUser.invoiceUserID_s like '%"+invoiceUserID_s+"%'";
		    }
		    Query query=session.createQuery(hql+condition);
		    if(start!=ConstantUtil.pagingNot){
		    	query.setFirstResult(start);
		    	query.setMaxResults(size);
		    }
		    list = query.list();
			return (ArrayList) list;
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			session.clear();		 
		}	 
	}

	public long getReceptionCustomerUserNumber(
			ReceptionCustomerUser receptionCustomerUser) throws Exception{
		// TODO Auto-generated method stub
		
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			List<ReceptionCustomerUser> list = new ArrayList();
			//CustomerUser customerUsermodel = new CustomerUser();
			if(receptionCustomerUser==null){
				//System.out.println("执行无条件查询 分页");
				Query query=session.createQuery("select count(*) from ReceptionCustomerUser");				
			    long n=0;
			    if(query.iterate().hasNext()){
			    	n=(Long) query.iterate().next();
			    } 
			    return n;
			}
			customerUserID_s = receptionCustomerUser.getCustomerUserID_s();
			orderID_s = receptionCustomerUser.getOrderID_s();
			customerUserName_s = receptionCustomerUser.getCustomerUserName_s();
			userType_i = receptionCustomerUser.getUserType_i();
			createDate_t = receptionCustomerUser.getCreateDate_t();
			createUser_s = receptionCustomerUser.getCreateUser_s();
			lastUpdateDate_t = receptionCustomerUser.getLastUpdateDate_t();
			lastUpdateUser_s = receptionCustomerUser.getLastUpdateUser_s();
			resaveds1_s = receptionCustomerUser.getResaveds1_s();
			resaveds2_s = receptionCustomerUser.getResaveds2_s();
			resaveds3_s = receptionCustomerUser.getResaveds3_s();
			resaveds4_s = receptionCustomerUser.getResaveds4_s();
			resaveds5_s = receptionCustomerUser.getResaveds5_s();
			String hql="select count(*) from ReceptionCustomerUser as receptionCustomerUser where 1=1 "; 
		    String condition = "";
		    if(customerUserID_s!=null){
		    	condition = " and receptionCustomerUser.customerUserID_s like '%"+customerUserID_s+"%'";
		    }
		    card_s = receptionCustomerUser.getCard_s();
		    if(card_s!=null){
		    	condition = condition+" and receptionCustomerUser.card_s like '%"+card_s+"%'";
		    }
		    if(orderID_s!=null){
		    	condition = condition+" and receptionCustomerUser.orderID_s like '%"+orderID_s+"%'";
		    }
		    if(customerUserName_s!=null){
		    	condition = condition+" and receptionCustomerUser.customerUserName_s like '%"+customerUserName_s+"%'";
		    }
		    if(userType_i!=null){
		    	condition = condition+" and receptionCustomerUser.userType_i='"+userType_i+"'";
		    }
		    if(createDate_t!=null){
		    	condition = condition+" and to_char(receptionCustomerUser.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s!=null){
		    	condition = condition+" and receptionCustomerUser.createUser_s like '%"+createUser_s+"%'";
		    }
		    if(lastUpdateDate_t!=null){
		    	condition = condition+" and to_char(receptionCustomerUser.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(lastUpdateUser_s!=null){
		    	condition = condition+" and receptionCustomerUser.lastUpdateUser_s like '%"+lastUpdateUser_s+"%'";
		    }
		    if(resaveds1_s!=null){
		    	condition = condition+" and receptionCustomerUser.resaveds1_s like '%"+resaveds1_s+"%'";
		    }
		    if(resaveds2_s!=null){
		    	condition = condition+" and receptionCustomerUser.resaveds2_s like '%"+resaveds2_s+"%'";
		    }
		    if(resaveds3_s!=null){
		    	condition = condition+" and receptionCustomerUser.resaveds3_s like '%"+resaveds3_s+"%'";
		    }
		    if(resaveds4_s!=null){
		    	condition = condition+" and receptionCustomerUser.resaveds4_s like '%"+resaveds4_s+"%'";
		    }
		    if(resaveds5_s!=null){
		    	condition = condition+" and receptionCustomerUser.resaveds5_s like '%"+resaveds5_s+"%'";
		    }
		    invoiceAddress_s = receptionCustomerUser.getInvoiceAddress_s();
			registerAddress_s = receptionCustomerUser.getRegisterAddress_s();
			responsibleUserID_s = receptionCustomerUser.getResponsibleUserID_s();
			invoiceUserID_s = receptionCustomerUser.getInvoiceUserID_s();
			if(invoiceAddress_s!=null){
		    	condition = condition+" and receptionCustomerUser.invoiceAddress_s like '%"+invoiceAddress_s+"%'";
		    }
		    if(registerAddress_s!=null){
		    	condition = condition+" and receptionCustomerUser.registerAddress_s like '%"+registerAddress_s+"%'";
		    }
		    if(responsibleUserID_s!=null){
		    	condition = condition+" and receptionCustomerUser.responsibleUserID_s like '%"+responsibleUserID_s+"%'";
		    }
		    if(invoiceUserID_s!=null){
		    	condition = condition+" and receptionCustomerUser.invoiceUserID_s like '%"+invoiceUserID_s+"%'";
		    }
		    invalidate_t = receptionCustomerUser.getInvalidate_t();
		    if(invalidate_t!=null){
		    	condition = condition+" and to_char(receptionCustomerUser.invalidate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(invalidate_t, "yyyy-MM-dd") +"'";
		    }
		    Query query=session.createQuery(hql+condition);
		    long n=0;
		    if(query.iterate().hasNext()){
		    	n=(Long) query.iterate().next();
		    }  		   
		//    list = HibernateUtil.Query(hql+condition);
			return n;	
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			session.clear();		    
		}	 
	}

	
	/**
	 * 
	 * OperationReceptionCustomerUser 
	 * @param   
	 *          customerUser  客户人员集合  
	 *          operatio 1：新增 2：删除
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationReceptionCustomerUser(
			 List<ReceptionCustomerUser> customerUser,int operation)
			throws Exception {	
		try{
			if(!session.isOpen()){
				session= HibernateUtil.getSession();							
			}
			tx=session.beginTransaction();//开启事务
			OperationReceptionCustomerUser(customerUser,session,operation);
			tx.commit();
			return 1;
		}catch(Exception e){
			tx.rollback();
			throw new Exception(e);
		}finally{					 
			session.clear();
		    			 
		}	
	}
	
	/**
	 * 操作接待模块订单相关客户人员信息表 在事务中
	 * OperationReceptionCustomerUser
	 * @param   
	 *          customerUser  客户人员集合  
	 *          operatio 1：新增 2：删除
	 *          session :在某事务中
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationReceptionCustomerUser(
			 List<ReceptionCustomerUser> customerUser,Session session,int operation)
			throws Exception {	
		try{			 
			//新增
			if(operation==1){
				if(customerUser!=null||customerUser.size()>0){
					for(int i=0;i<customerUser.size();i++){						
						session.saveOrUpdate(customerUser.get(i));
						session.flush();
					    session.clear();
					}
				}
			}
			//删除
			if(operation==2){
				if(customerUser!=null&&customerUser.size()>0){
					for(int i=0;i<customerUser.size();i++){
						ReceptionCustomerUser tmp = customerUser.get(i);
						if(tmp.getOrderID_s()!=null&&tmp.getCustomerUserID_s()!=null){
							session.delete(customerUser.get(i));
							session.flush();						 
						}else if(tmp.getOrderID_s()!=null){
							Query query = session.createQuery("delete ReceptionCustomerUser r where r.orderID_s = ?");   
							query.setString(0, tmp.getOrderID_s());   
							query.executeUpdate();
						}
					}
				}
			}
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}finally{
		}
	}
	
	public static void main(String[] a){
		ReceptionCustomerUserServiceImpl tmp = new ReceptionCustomerUserServiceImpl();
		//1、查询
		ReceptionCustomerUser receptionCustomerUser = new ReceptionCustomerUser();	
		receptionCustomerUser.setCustomerUserID_s("RY2014041007");
		//receptionCustomerUser.setOrderID_s("1111");
		List l;
		try {
			l = new ReceptionCustomerUserServiceImpl().getReceptionCustomerUser(receptionCustomerUser, 0, 10);
			System.out.print(l.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		//2、新增
		List list = new ArrayList();
		//list.add("003vv1");
		//list.add("004vv2");
		try {
	//		tmp.OperationReceptionCustomerUser("002", list, 2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据ReceptionCustomerUser集合查询customerUser得到每个用户的sysNo_s
	 * setCustomerUser 
	 * @param   orderid_s 订单编号    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<ReceptionCustomerUser> getCustomerUserAllpro(ReceptionCustomerUser receptionCustomerUser)throws Exception{
		ArrayList<ReceptionCustomerUser> receptionCustomerUsers = this.getReceptionCustomerUser(receptionCustomerUser, ConstantUtil.pagingNot, 0);
		IcustomerUserService icustomerUserService = new CustomerUserServiceImpl();
		for(int i=0;i<receptionCustomerUsers.size();i++){
			ReceptionCustomerUser receptionCustomerUsertmp = receptionCustomerUsers.get(i);
			CustomerUser customerUser = new CustomerUser();
			customerUser.setCustomerUserID_s(receptionCustomerUsertmp.getCustomerUserID_s());
			customerUser = (CustomerUser)icustomerUserService.getCustomerUser(customerUser).get(0);
			receptionCustomerUsertmp.setSysNo_s(customerUser.getSysNo_s());
			receptionCustomerUsers.set(i, receptionCustomerUsertmp);
		}
		return receptionCustomerUsers;
	}
	
	
	/**
	 * 
	 * 将订单对应的预约模块到访人员信息表复制到接待模块订单相关客户人员信息表
	 * addReceptionCustomerUser 
	 * @param   orderID_s 订单id
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void addReceptionCustomerUser(String orderID_s,Session session)throws Exception{
		//1、通过orderID_s获得订单下的到访人员信息登记信息
		IcustomerRegisterService icustomerRegisterService = new CustomerRegisterServiceimpl();
		CustomerRegister customerRegister = new CustomerRegister();
		customerRegister.setOrderID_s(orderID_s);
		List<CustomerRegister> customerRegisters = icustomerRegisterService.getBasisCustomerRegister(customerRegister, ConstantUtil.pagingNot, 0);
		//2、将到访人员信息登记信息保存至接待模块订单相关客户人员信息表
		List<ReceptionCustomerUser> receptionCustomerUsers = new ArrayList();
		for(int i=0;i<customerRegisters.size();i++){
			CustomerRegister tmp = customerRegisters.get(i);
			ReceptionCustomerUser receptionCustomerUser = new ReceptionCustomerUser();
			receptionCustomerUser.setproByCustomerRegister(tmp);
			receptionCustomerUsers.add(receptionCustomerUser);
		}
		OperationReceptionCustomerUser(receptionCustomerUsers,session,1);
	}
	
}
