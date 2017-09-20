package com.freshen.oneCard.service.impl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.IDriverService;
import com.freshen.basis.service.impl.DriverServiceImpl;
import com.freshen.entity.barrierGate.TBarriergateCancellationBak;
import com.freshen.entity.basis.CustomerUser;
import com.freshen.entity.basis.Driver;
import com.freshen.entity.oneCard.TOnecardPbemplyBak;
import com.freshen.entity.reception.ReceptionCustomerUser;
import com.freshen.entity.reception.ReceptionOrder;
import com.freshen.oneCard.service.IOneCardPbEmplyService;
import com.freshen.oneCard.service.ItOnecardMjreguserService;
import com.freshen.preorder.service.IcustomerUserService;
import com.freshen.preorder.service.IorderDetailService;
import com.freshen.preorder.service.impl.CustomerUserServiceImpl;
import com.freshen.reception.service.IreceptionCustomerUserService;
import com.freshen.reception.service.IreceptionOrderService;
import com.freshen.reception.service.impl.ReceptionCustomerUserServiceImpl;
import com.freshen.reception.service.impl.ReceptionOrderServiceImpl;
import com.freshen.util.BasicTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DataResource;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

/**
 * 操作一卡通用户基本信息表
 *     
 * 项目名称：carcenter    
 * 类名称：OneCardPbEmplyServiceImpl    
 * 类描述：    
 * 创建人：kxc    
 * 创建时间：2014-7-7 下午07:24:18    
 * 修改人：kxc    
 * 修改时间：2014-7-7 下午07:24:18    
 * 修改备注：    
 * @version     
 *
 */
public class OneCardPbEmplyServiceImpl extends ClimsServiceBase implements IOneCardPbEmplyService{

	private String sysnoS;
	private Integer dptidI;
	private String emplyidS;
	private String emplynameS;
	private String cardnoS;
	private String serialS;
	private String emplytypeS;
	private String emplysexS;
	private String emplypassS;
	private Date invalidateT;
	private String emplycodeS;
	private String isdeletedS;
	Session session = HibernateUtil.getSession();	
	Transaction tx = null;
	/**
	 * 对试验场管理系统的用户基本信息表进行操作
	 * OperationPbEmplyClims 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationPbEmplyClims(List<TOnecardPbemplyBak> tOnecardPbemplyBaks,int operation,Session session) throws Exception{
		try{
			if(!BasicTools.isnotNull(tOnecardPbemplyBaks)){
				throw new Exception(this.getClass().getMethods()[0].getName()+"用户信息不存在");			
			}else{
				if(operation==1){
					for(TOnecardPbemplyBak tOnecardPbemplyBak:tOnecardPbemplyBaks){
						TOnecardPbemplyBak tmp = (TOnecardPbemplyBak)session.get(TOnecardPbemplyBak.class, tOnecardPbemplyBak.getSysnoS());
						if(TOnecardPbemplyBak.isnotNull(tmp)){
							if(this.cardnoS!=null){
								tmp.setCardnoS(cardnoS);
							}
							if(this.dptidI!=null){
								tmp.setDptidI(dptidI);
							}
							if(this.emplycodeS!=null){
								tmp.setEmplycodeS(emplycodeS);
							}
							if(this.emplyidS!=null){
								tmp.setEmplyidS(emplyidS);
							}
							if(this.emplynameS!=null){
								tmp.setEmplynameS(emplynameS);
							}
							if(this.emplypassS!=null){
								tmp.setEmplypassS(emplypassS);
							}
							if(this.emplysexS!=null){
								tmp.setEmplytypeS(emplytypeS);
							}
							if(this.invalidateT!=null){
								tmp.setInvalidateT(invalidateT);
							}
							if(this.isdeletedS!=null){
								tmp.setIsdeletedS(isdeletedS);
							}
							if(this.serialS!=null){
								tmp.setSerialS(serialS);
							}
							session.saveOrUpdate(tmp);
						}else{
							tOnecardPbemplyBak.setEditFlagTimeT(DateUtil.getCurrentDate());
							session.saveOrUpdate(tOnecardPbemplyBak);
						}					 
						session.flush();
					    session.clear();
					}
				}
				//删除
				if(operation==2){
					for(TOnecardPbemplyBak tOnecardPbemplyBak:tOnecardPbemplyBaks){
						session.delete(tOnecardPbemplyBak);
						session.flush();
						session.clear();
					}
				}
				return 1;
			}
		}
		catch(Exception e){
			throw e;
		}
		finally{
			
		}
	}
	
	/**
	 * 操作一卡通sql server数据库用户基本信息表	   
	 * OperationPbEmplyoOeCard 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationPbEmplyoOeCardold(List<TOnecardPbemplyBak> tOnecardPbemplyBaks,int operation) throws Exception{
		Connection sqlcon = DataResource.getConnect(ConstantUtil.OneCardSERVERCONN);
		PreparedStatement prest = null;
		try{
			//获得sql server连接
			sqlcon.setAutoCommit(false);
			if(operation==1){
				String sql = "INSERT into pb_emply(SysNo,Dptid,Emplyid,Emplyname," +
						"CardNo,Serial,EmplyType,Emplysex,EmplyPass," +
						"Invalidate,EmplyCode,IsDeleted) " +
						 "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";  			
				prest = sqlcon.prepareStatement(sql);  
				for(int i=0;i<tOnecardPbemplyBaks.size();i++){
					TOnecardPbemplyBak tmp = tOnecardPbemplyBaks.get(i);
					prest.setString(1, tmp.getSysnoS());
					prest.setInt(2, tmp.getDptidI());
					prest.setString(3, tmp.getEmplyidS());
					prest.setString(4, tmp.getEmplynameS());
					prest.setString(5, tmp.getCardnoS());
					prest.setString(6, tmp.getSerialS());
					prest.setString(7, tmp.getEmplytypeS());
					prest.setString(8, tmp.getEmplysexS());
					prest.setString(9, tmp.getEmplypassS());
					prest.setTimestamp(10, new Timestamp(tmp.getInvalidateT().getTime()));
					prest.setString(11, tmp.getEmplycodeS());
					prest.setString(12, tmp.getIsdeletedS());
					prest.addBatch();   
				}
				prest.executeBatch();
			}else{
				String sql ="delete pb_emply where SysNo=?";
				prest = sqlcon.prepareStatement(sql);  
				for(int i=0;i<tOnecardPbemplyBaks.size();i++){
					prest.setString(1, tOnecardPbemplyBaks.get(i).getSysnoS());
					prest.addBatch();   
				}
				prest.executeBatch();
			}
			sqlcon.commit();  
			return 1;
		}catch (Exception e){
			sqlcon.rollback();
			throw new Exception(e);
		}finally{
			try { 
				if (prest != null) prest.close(); 
			}catch(Exception e) {throw new Exception(e);} 
			try { 
				if (sqlcon != null) sqlcon.close(); 
			}
			catch (Exception e){throw new Exception(e);}
		} 		
	}
	
	/**
	 * 操作一卡通sql server数据库用户基本信息表
	 * OperationPbEmplyoOeCard 
	 * @param   receptionCustomerUsers 接待模块订单相关客户人员信息表
	 * 			operation 1：新增 2：删除
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<CustomerUser> OperationPbEmplyoOneCard(List<ReceptionCustomerUser> receptionCustomerUsers,int operation) throws Exception{
		if(!BasicTools.isnotNull(receptionCustomerUsers)){
			throw new Exception("相关客户人员信息不能为空");
		}
		Connection sqlcon = DataResource.getConnect(ConstantUtil.OneCardSERVERCONN);
		CallableStatement cstmt = null;
		CallableStatement cstmt1 = null;
		IcustomerUserService icustomerUserService = new CustomerUserServiceImpl();
		IreceptionOrderService receptionOrderServiceImpl = new ReceptionOrderServiceImpl(); 	 
		List<CustomerUser> customerUsers = new ArrayList();
		try{
			//获得sql server连接
			sqlcon.setAutoCommit(false);
			if(operation==1){
							
				for(int i=0;i<receptionCustomerUsers.size();i++){				
					ReceptionCustomerUser tmp = receptionCustomerUsers.get(i);
					//获得sysno
					CustomerUser customerUser = new CustomerUser();
					customerUser.setCustomerUserID_s(tmp.getCustomerUserID_s());
					customerUser = (CustomerUser)icustomerUserService.getCustomerUser(customerUser).get(0);			 
					
					//得到接待模块订单信息
					ReceptionOrder receptionOrder = new ReceptionOrder();
					receptionOrder.setOrderID_s(tmp.getOrderID_s());
					receptionOrder = receptionOrderServiceImpl.getReceptionOrder(receptionOrder, ConstantUtil.pagingNot, 0).get(0);
					CustomerUser customerUsertmp = new CustomerUser();
					//得到接待模块订单相关客户人员信息表信息并添加卡号
					customerUsertmp.setCustomerUserID_s(tmp.getCustomerUserID_s());
					customerUsertmp = (CustomerUser)(icustomerUserService.getCustomerUser(customerUsertmp, ConstantUtil.pagingNot, 0).get(0));
					customerUsertmp.setCard_s(tmp.getCard_s());//卡号
					customerUsertmp.setInvalidate(receptionOrder.getEndDate_d());//有效日期
					customerUsertmp.setSerialface_s(tmp.getSerialface_s());
					customerUsertmp.setDptid_i(Integer.valueOf(tmp.getResaveds1_s()));					
					customerUsertmp.setCustomerUserName_s(tmp.getCustomerUserName_s());
					//sysno为空新增客户人员，负责不添加
					if(customerUser.getSysNo_s()!=null&&!("null").equals(customerUser.getSysNo_s())&&!("").equals(customerUser.getSysNo_s())){
						cstmt = sqlcon.prepareCall("{call dbo.sp_pb_modify_user(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
						cstmt.setString(1,customerUser.getSysNo_s());
						cstmt.setInt(2, customerUsertmp.getDptid_i());
						cstmt.setString(3, customerUsertmp.getIdentityCard_s());
						cstmt.setString(4, customerUsertmp.getEmplycode_s());
						cstmt.setString(5, customerUsertmp.getCustomerUserName_s());
						//设为E,试验人员
						cstmt.setString(6,ConstantUtil.ONECARDUUSERTYPE02);						 
						if(customerUsertmp.getEmplypass_s()==null || customerUsertmp.getEmplypass_s().trim().equals("")){
							cstmt.setString(7, "1234");
						}else{
							cstmt.setString(7, customerUsertmp.getEmplypass_s());
						}
						cstmt.setString(8, customerUser.getSerialface_s());
						if(customerUsertmp.getEmplysex_s()==null){
							cstmt.setString(9, "男");
						}else{
							cstmt.setString(9, customerUsertmp.getEmplysex_s());
						}
						cstmt.setDate(10, new java.sql.Date(receptionOrder.getEndDate_d().getTime()));						
						if(customerUsertmp.getCreateDate_t()==null){
							cstmt.setDate(11,new java.sql.Date(new Date().getTime()));
						}else{
							cstmt.setDate(11,new java.sql.Date(customerUsertmp.getCreateDate_t().getTime()));
						}
						cstmt.setString(12, customerUsertmp.getDuty_s());
						cstmt.setString(13, customerUsertmp.getNation_s());
						cstmt.setString(14, customerUsertmp.getDegree_s());
						cstmt.setString(15, customerUsertmp.getAddress_s());
						cstmt.setString(16, customerUsertmp.getTelephone_s());
						cstmt.setString(17, customerUsertmp.getMemo_s());
						cstmt.registerOutParameter(18, java.sql.Types.INTEGER);
						cstmt.execute();
						 
					}else{
						cstmt = sqlcon.prepareCall("{call dbo.sp_pb_add_user(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");	
						cstmt.registerOutParameter(1, java.sql.Types.CHAR);
						cstmt.setInt(2, customerUsertmp.getDptid_i());
						cstmt.setString(3, customerUsertmp.getIdentityCard_s());
						cstmt.setString(4, customerUsertmp.getEmplycode_s());
						cstmt.setString(5, customerUsertmp.getCustomerUserName_s());
						//设为E,试验人员
						cstmt.setString(6,ConstantUtil.ONECARDUUSERTYPE02);						 
						if(customerUsertmp.getEmplypass_s()==null || customerUsertmp.getEmplypass_s().trim().equals("")){
							cstmt.setString(7, "1234");
						}else{
							cstmt.setString(7, customerUsertmp.getEmplypass_s());
						}
						if(customerUsertmp.getEmplysex_s()==null){
							cstmt.setString(8, "男");
						}else{
							cstmt.setString(8, customerUsertmp.getEmplysex_s());
						}
						cstmt.setDate(9, new java.sql.Date(receptionOrder.getEndDate_d().getTime()));						
						if(customerUsertmp.getCreateDate_t()==null){
							cstmt.setDate(10,new java.sql.Date(new Date().getTime()));
						}else{
							cstmt.setDate(10,new java.sql.Date(customerUsertmp.getCreateDate_t().getTime()));
						}
						cstmt.setString(11, customerUsertmp.getDuty_s());
						cstmt.setString(12, customerUsertmp.getNation_s());
						cstmt.setString(13, customerUsertmp.getDegree_s());
						cstmt.setString(14, customerUsertmp.getAddress_s());
						cstmt.setString(15, customerUsertmp.getTelephone_s());
						cstmt.setString(16, customerUsertmp.getMemo_s());
						cstmt.registerOutParameter(17, java.sql.Types.INTEGER);
						cstmt.execute();
						int r = cstmt.getInt(17);
						if(r==0){//成功
							customerUsertmp.setSysNo_s(cstmt.getString(1)); //人员编号
						}else if(r==-1){
							throw new Exception ("证件号已经存在");
						}else if(r==-2){
							throw new Exception ("密码无效");
						}else if(r==-3){
							throw new Exception ("密码长度要为4位");
						}
					} 
					customerUsers.add(customerUsertmp);
				}
			}else{
				cstmt = sqlcon.prepareCall("{call dbo.sp_pb_del_user(?,?)}");
				for(int i=0;i<receptionCustomerUsers.size();i++){
					ReceptionCustomerUser tmp = receptionCustomerUsers.get(i);
					CustomerUser customerUsertmp = new CustomerUser();
					customerUsertmp.setCustomerUserID_s(tmp.getCustomerUserID_s());
					customerUsertmp = (CustomerUser)(icustomerUserService.getCustomerUser(customerUsertmp, ConstantUtil.pagingNot, 0).get(0));
					cstmt.setString(1, customerUsertmp.getSysNo_s());
					cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
					cstmt.execute();
					int r = cstmt.getInt(2);
					//System.out.println(r);
				}
			}
			sqlcon.commit();		 
			return customerUsers;
		}catch (Exception e){
			e.printStackTrace();
			//sqlcon.rollback();
			throw new Exception(e);
		}finally{
			try { 
				if (cstmt != null) cstmt.close(); 
			}catch(Exception e) {throw new Exception(e);} 
			try { 
				if (sqlcon != null) sqlcon.close(); 
			}
			catch (Exception e){throw new Exception(e);}
		} 		
	}
	
	/**
	 * 发卡	   
	 * sendcard 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int sendcard(List<CustomerUser> customerUsers)throws Exception{
		Connection sqlcon = DataResource.getConnect(ConstantUtil.OneCardSERVERCONN);
		CallableStatement cstmt = null;
		try{			
			sqlcon.setAutoCommit(false);
			cstmt = sqlcon.prepareCall("{call dbo.sp_pb_sendcard_2(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			for(int i=0;i<customerUsers.size();i++){
				CustomerUser tmp = customerUsers.get(i);
				cstmt.setInt(1, tmp.getDptid_i());
				cstmt.setString(2, tmp.getSysNo_s());
				cstmt.setString(3, tmp.getIdentityCard_s());
				cstmt.setString(4, tmp.getCustomerUserName_s());
				cstmt.setString(5, tmp.getCard_s());
				if(tmp.getSerialface_s()==null){
					cstmt.setString(6, "abc");
				}else{
					cstmt.setString(6, tmp.getSerialface_s());
				}
				cstmt.setBigDecimal(7, new BigDecimal(0));
				cstmt.setBigDecimal(8, new BigDecimal(0));
				cstmt.setBigDecimal(9, new BigDecimal(0));
				cstmt.setBigDecimal(10, new BigDecimal(0));
				cstmt.setTimestamp(11, new Timestamp(DateUtil.getCurrentDate().getTime()));
				cstmt.setDate(12, new java.sql.Date(tmp.getInvalidate().getDate()));
				cstmt.setInt(13, 0);
				cstmt.setString(14, tmp.getEmplypass_s());
				cstmt.setString(15, ConstantUtil.Project_name);
				cstmt.setString(16, ConstantUtil.Project_name);
				cstmt.setString(17, "123");
				cstmt.registerOutParameter(18, java.sql.Types.INTEGER);
				cstmt.execute();
				int r = cstmt.getInt(18);
				//System.out.println(r);
			}
			sqlcon.commit();
			return 1;
		}catch (Exception e){
			e.printStackTrace();
			sqlcon.rollback();
			throw new Exception(e);
		}finally{
			try { 
				if (cstmt != null) cstmt.close(); 
			}catch(Exception e) {throw new Exception(e);} 
			try { 
				if (sqlcon != null) sqlcon.close(); 
			}
			catch (Exception e){throw new Exception(e);}
		} 		
	}
	
	/**
	 * 操作一卡通用户信息表
	 * OperationPbEmply
	 * @param   tOnecardPbemplyBaks  用户信息    
	 * 			operation 1:新增 2：删除
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationPbEmply(List<ReceptionCustomerUser> receptionCustomerUsers,String orderID_s,int operation) throws Exception{
		try{
			
			session = HibernateUtil.getSession();			
			if(!session.isOpen()){
				session= HibernateUtil.getSession();
			}
			tx=session.beginTransaction();//开启事务
			IcustomerUserService icustomerUserService = new CustomerUserServiceImpl();
			IreceptionCustomerUserService ireceptionCustomerUserService = new ReceptionCustomerUserServiceImpl();
			ReceptionCustomerUser receptionCustomerUsertmp = new ReceptionCustomerUser();
			receptionCustomerUsertmp.setOrderID_s(orderID_s);
			//1、获得原订单相关客户人员信息
			//ArrayList<ReceptionCustomerUser> delReceptionCustomerUsers = ireceptionCustomerUserService.getReceptionCustomerUser(receptionCustomerUsertmp,ConstantUtil.pagingNot,0);
			/*for(int i=0;i<delReceptionCustomerUsers.size();i++){
				ReceptionCustomerUser tmp = delReceptionCustomerUsers.get(i);
				CustomerUser customerUsertmp = new CustomerUser();
				customerUsertmp.setCustomerUserID_s(tmp.getCustomerUserID_s());
				customerUsertmp = icustomerUserService.getCustomerUser(customerUsertmp).get(0);
				tmp.setSysNo_s(customerUsertmp.getSysNo_s());
				delReceptionCustomerUsers.set(i, tmp);
			}*/
			if(operation==1){//新增
				//1、保存一卡通用户基本信息表
				List<CustomerUser> customerUsers = this.OperationPbEmplyoOneCard(receptionCustomerUsers, operation);
				//2、删除原接待模块订单相关客户人员信息表 
				List<ReceptionCustomerUser> tmplist = new ArrayList();
				ReceptionCustomerUser receptionCustomerUser = new ReceptionCustomerUser();
				receptionCustomerUser.setOrderID_s(orderID_s);
				tmplist.add(receptionCustomerUser);
				ireceptionCustomerUserService.OperationReceptionCustomerUser(tmplist, session,2);				
				//3、保存基础信息客户人员信息表，主要保存一卡通编号			
				icustomerUserService.OperationBasisCustomerUserList(customerUsers, session);
				//4、保存接待模块订单相关客户人员信息表 
				ireceptionCustomerUserService.OperationReceptionCustomerUser(receptionCustomerUsers, session,operation);
				//5、发卡
				this.sendcard(customerUsers);
			}
			tx.commit();
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			throw e;
		}finally{
			session.clear();
		}
	}
	private void setPro(TOnecardPbemplyBak tOnecardPbemplyBak){
		this.cardnoS = tOnecardPbemplyBak.getCardnoS();
		this.dptidI  = tOnecardPbemplyBak.getDptidI();
		this.emplycodeS = tOnecardPbemplyBak.getEmplycodeS();
		this.emplyidS = tOnecardPbemplyBak.getEmplyidS();
		this.emplynameS = tOnecardPbemplyBak.getEmplynameS();
		this.emplypassS = tOnecardPbemplyBak.getEmplypassS();
		this.emplysexS  = tOnecardPbemplyBak.getEmplysexS();
		this.emplytypeS = tOnecardPbemplyBak.getEmplytypeS();
		this.invalidateT = tOnecardPbemplyBak.getInvalidateT();
		this.isdeletedS = tOnecardPbemplyBak.getIsdeletedS();
		this.serialS = tOnecardPbemplyBak.getSerialS();
		this.sysnoS  = tOnecardPbemplyBak.getSysnoS(); 
	}
	
	public static void main(String[] a){
		IOneCardPbEmplyService iOneCardPbEmplyService = new OneCardPbEmplyServiceImpl();
		int operation = 1;
		List<ReceptionCustomerUser> ReceptionCustomerUsers = new ArrayList();
		ReceptionCustomerUser tmp = new ReceptionCustomerUser();
		tmp.setCustomerUserID_s("RY2014061011");
		tmp.setCard_s("k011");		
		tmp.setOrderID_s("DD2014041007"); 
		tmp.setSerialface_s("x11");
		tmp.setDeviceSysid_s("8");
		ReceptionCustomerUsers.add(tmp);
		ReceptionCustomerUser tmp1 = new ReceptionCustomerUser();
		tmp1.setCustomerUserID_s("RY2014061012");
		tmp1.setCard_s("k022");
		tmp1.setOrderID_s("DD2014041007"); 
		tmp1.setSerialface_s("x22");
		tmp1.setDeviceSysid_s("5vv43");
		ReceptionCustomerUsers.add(tmp1);
		try {
		/*	IOneCardPbEmplyService iOneCardPbEmplyService = new OneCardPbEmplyServiceImpl();
			iOneCardPbEmplyService.OperationPbEmply(receptionCustomerUsers,"DD2014041007", operation);
		*/	ItOnecardMjreguserService ItOnecardMjreguserService = new TOnecardMjreguserServiceImpl();
			ItOnecardMjreguserService.OperationMjreguser("DD2014041007", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
