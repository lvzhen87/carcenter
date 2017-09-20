package com.freshen.oneCard.service.impl;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.entity.basis.CustomerUser;
import com.freshen.entity.oneCard.TOnecardMjdoorBak;
import com.freshen.entity.oneCard.TOnecardMjreguserBak;
import com.freshen.entity.reception.ReceptionCustomerUser;
import com.freshen.entity.reception.ReceptionOrder;
import com.freshen.oneCard.service.IOneCardPbEmplyService;
import com.freshen.oneCard.service.ITOnecardMjdoorBakService;
import com.freshen.oneCard.service.ItOnecardMjreguserService;
import com.freshen.preorder.service.IcustomerUserService;
import com.freshen.preorder.service.impl.CustomerUserServiceImpl;
import com.freshen.reception.service.IreceptionCustomerUserService;
import com.freshen.reception.service.impl.ReceptionCustomerUserServiceImpl;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.BasicTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DataResource;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;
import com.freshen.util.NumTools;
import com.freshen.util.StringTools;
import com.freshen.reception.service.impl.ReceptionOrderServiceImpl;
import com.freshen.reception.service.IreceptionOrderService;
/**
 * 
 * 项目名称：carcenter    
 * 类名称：TOnecardMjreguserServiceImpl    
 * 类描述：    
 * 创建人：kxc    
 * 创建时间：2014-7-11 下午06:03:09    
 * 修改人：kxc    
 * 修改时间：2014-7-11 下午06:03:09    
 * 修改备注：    
 * @version     
 *
 */
public class TOnecardMjreguserServiceImpl extends ClimsServiceBase implements ItOnecardMjreguserService{

	Session session = HibernateUtil.getSession();
	Transaction tx = null;
	/**
	 * 操作试验场管理系统登记用户表（Mj_RegUser）
	 * OperationTOnecardMjreguserBak 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationTOnecardMjreguserBak(
			 List<TOnecardMjreguserBak> tOnecardMjreguserBaks,Session session,int operation)
			throws Exception {	
		try{			 
			
			//新增
			if(operation==1){
				if(tOnecardMjreguserBaks!=null||tOnecardMjreguserBaks.size()>0){
					IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
					for(int i=0;i<tOnecardMjreguserBaks.size();i++){	
						TOnecardMjreguserBak tmp = tOnecardMjreguserBaks.get(i);
						String pk = systemSequenceServiceImpl.getPK(ConstantUtil.MJUBusiness, session);
						tmp.setEditFlagTimeT(DateUtil.getCurrentDate());
						tmp.setRecordidS(pk);
						session.saveOrUpdate(tmp);
						session.flush();
					    session.clear();
					}
				}
			}
			//删除
			if(operation==2){
				if(tOnecardMjreguserBaks!=null&&tOnecardMjreguserBaks.size()>0){
					for(int i=0;i<tOnecardMjreguserBaks.size();i++){
						session.delete(tOnecardMjreguserBaks.get(i));
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
	 
	
	/**
	 * 根据订单相关客户人员信息以及选择房门信息转换为登记用户表信息
	 * setTOnecardMjreguserPro 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @throws Throwable 
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<TOnecardMjreguserBak> setTOnecardMjreguserPro(List<ReceptionCustomerUser> receptionCustomerUsers)
	throws Exception{
		if(!BasicTools.isnotNull(receptionCustomerUsers)){
			throw new Exception("相关客户人员信息不能为空");
		}
		
		Integer devicesysidIOld = -1;
		String doorCode ="0000";//门号后四位
		String doorCodeOld ="0000";//门号后四位
		Integer devicesysidI =0;//所属设备号
		Integer devicesysidIcf =0;//所属设备号
		String userID = "";
		String userIDold = "";
		Integer channelNum = 0;
		TOnecardMjreguserBak tOnecardMjreguserBak=new TOnecardMjreguserBak();
		String channel = "";
		Integer sequence = 0;
		Integer state = 0;
		try{
			//房门表操作对象
			ITOnecardMjdoorBakService tOnecardMjdoorBakServiceImpl = new TOnecardMjdoorBakServiceImpl();
			List<TOnecardMjreguserBak> list = new ArrayList();
			//循环选择的人
			for(ReceptionCustomerUser receptionCustomerUser:receptionCustomerUsers){
				String deviceSysid_s = receptionCustomerUser.getDeviceSysid_s();//房门ID集合
				if(deviceSysid_s==null){
					continue;
				}
			
				userID = receptionCustomerUser.getCustomerUserID_s();
//				userIDold = userID;
				String card_s =  receptionCustomerUser.getCard_s();//卡号
				String sysno = receptionCustomerUser.getSysNo_s();			  
				String[] deviceSysid_ses = deviceSysid_s.split("vv");
				
				//循环选择的房门设备
				for(String deviceSysidtmp:deviceSysid_ses){
					TOnecardMjdoorBak tOnecardMjdoorBaktmp = new TOnecardMjdoorBak();
					tOnecardMjdoorBaktmp.setDoorIdI(Integer.valueOf(deviceSysidtmp));
					//通过所属设备识别号获得对应的门的信息，会有多条
					List<TOnecardMjdoorBak> tOnecardMjdoorBaks = tOnecardMjdoorBakServiceImpl.getTOnecardMjdoorBak(tOnecardMjdoorBaktmp);
					
					if(!BasicTools.isnotNull(tOnecardMjdoorBaks)){
						continue;
					}
					if(tOnecardMjdoorBaks.get(0).getGroupId_s()!= null && !tOnecardMjdoorBaks.get(0).getGroupId_s().trim().equals(""))
					{
						if(state == 0)
						{
							list.add(tOnecardMjreguserBak);
							tOnecardMjreguserBak=new TOnecardMjreguserBak();
						}
						TOnecardMjdoorBak newToneCard = new TOnecardMjdoorBak();
						newToneCard.setGroupId_s(tOnecardMjdoorBaks.get(0).getGroupId_s());
						List<TOnecardMjdoorBak> tOnecardMjList = tOnecardMjdoorBakServiceImpl.getTOnecardMjdoorBak(newToneCard);
						if(tOnecardMjList!= null && tOnecardMjList.size()>0)
						{
							for(int j = 0;j<tOnecardMjList.size();j++)
							{
								sequence = sequence>tOnecardMjList.get(j).getChannelnumI()?sequence:tOnecardMjList.get(j).getChannelnumI();
							}
							devicesysidI = tOnecardMjdoorBaks.get(0).getDevicesysidI();
							if(devicesysidI.equals(devicesysidIcf)){
								continue;
							}
							tOnecardMjreguserBak = new TOnecardMjreguserBak();
							tOnecardMjreguserBak.setDptid(receptionCustomerUser.getResaveds1_s());
							tOnecardMjreguserBak.setSysnoS(sysno);
							tOnecardMjreguserBak.setSerialS(card_s);
							tOnecardMjreguserBak.setIsdownS("0");
							tOnecardMjreguserBak.setDevicesysidI(devicesysidI);
							tOnecardMjreguserBak.setPass("1234");
							tOnecardMjreguserBak.setGroupList("00000000");
							switch (sequence) {
							case 1:
								channel = "01";
								
								break;
							case 2:
								channel = "03";		
								break;
							case 3:
								channel = "07";
								break;
							case 4:
								channel = "0F";
								break;
							default:
								break;
							} 
							//tOnecardMjreguserBak.setDevicesysidI(Integer.valueOf(deviceSysidtmp));
							tOnecardMjreguserBak.setDoorcodeS(channel);
							list.add(tOnecardMjreguserBak);
							tOnecardMjreguserBak=new TOnecardMjreguserBak();
							devicesysidIcf = devicesysidI;
							sequence = 0;
							state = 1;
						}
						else
						{
							continue;
						}
					}
					else
					{
						//循环房门设备对应的门
						for(TOnecardMjdoorBak tOnecardMjdoorBaktmp1:tOnecardMjdoorBaks){
							channelNum = tOnecardMjdoorBaktmp1.getChannelnumI();//门号
							
							devicesysidI = tOnecardMjdoorBaktmp1.getDevicesysidI();
							
						}
						if(devicesysidI.equals(devicesysidIOld)&& userIDold.equals(userID)  )
						{
//							devicesysidIOld = devicesysidI;
//							userIDold = userID;
						}
						else{
							if(devicesysidIOld != -1)
							{
								list.add(tOnecardMjreguserBak);
								tOnecardMjreguserBak = new TOnecardMjreguserBak();
								doorCode ="0000";
								doorCodeOld = "0000";
								devicesysidIOld = devicesysidI;
								userIDold = userID;
							}
							devicesysidIOld = devicesysidI;
							userIDold = userID;
						}
						if(channelNum==1){
							doorCode = StringTools.replace(doorCode, 4, "1");
						}else if(channelNum==2){
							doorCode = StringTools.replace(doorCode, 3, "1");
						}else if(channelNum==3){
							doorCode = StringTools.replace(doorCode, 2, "1");
						}else if(channelNum==4){
							doorCode = StringTools.replace(doorCode, 1, "1");
						}
						doorCodeOld = doorCode;
						tOnecardMjreguserBak.setDptid(receptionCustomerUser.getResaveds1_s());
						tOnecardMjreguserBak.setSysnoS(sysno);
						tOnecardMjreguserBak.setSerialS(card_s);
						tOnecardMjreguserBak.setIsdownS("0");
						tOnecardMjreguserBak.setDevicesysidI(devicesysidI);
						//tOnecardMjreguserBak.setDevicesysidI(Integer.valueOf(deviceSysidtmp));
						tOnecardMjreguserBak.setDoorcodeS(NumTools.binaryString2hexString(ConstantUtil.DoorCode_prefix+""+doorCodeOld));
						tOnecardMjreguserBak.setPass("1234");
						tOnecardMjreguserBak.setGroupList("00000000");
						state = 0;
					}
					
				}
			}
			if(receptionCustomerUsers!= null && receptionCustomerUsers.size()>0 && state == 0){
				list.add(tOnecardMjreguserBak);
			}
			return list;
		}catch(Exception e){
			throw e;
		}
		
	}
	
	/**
	 * 操作一卡通登记用户表	   
	 * OperationMjreguserOneCard 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationMjreguserOneCard(List<TOnecardMjreguserBak>  list,String orderId, int operation,Connection sqlcon)
		throws Exception{
		if(!BasicTools.isnotNull(list)){
			return 0;
		}
		//得到订单对象
		IreceptionOrderService ireceptionOrderService = new ReceptionOrderServiceImpl();
		ReceptionOrder receptionOrder = new ReceptionOrder();
		receptionOrder.setOrderID_s(orderId);
		receptionOrder = ireceptionOrderService.getReceptionOrder(receptionOrder,ConstantUtil.pagingNot , 0).get(0);
		
		PreparedStatement prest = null;
		try{
			//获得sql server连接
			sqlcon.setAutoCommit(false);
			if(operation==1){
				//1、将卡的原权限删除
				String sql = "update Mj_RegUser set IsDown = '2' where Serial=? ";
				prest = sqlcon.prepareStatement(sql);
				for(int i=0;i<list.size();i++){					
					TOnecardMjreguserBak tmp = list.get(i);
					prest.setString(1, tmp.getSerialS());					
					prest.addBatch();   
				}
				prest.executeBatch();
				//2、进行赋权
				sql = "insert into Mj_RegUser(SysNo,Serial,DeviceSysid,DoorCode,IsDown,Dptid,Starttime,Endtime,Reguser_pass,GroupList) values(?,?,?,?,?,?,?,?,?,?)";
				
				//sql = "insert into Mj_RegUser(SysNo,Serial,DeviceSysid,DoorCode,IsDown) values(?,?,?,?,?)";
				prest = sqlcon.prepareStatement(sql);  
				for(int i=0;i<list.size();i++){
					TOnecardMjreguserBak tmp = list.get(i);					
					if(tmp.getSysnoS()==null){
						continue;
					}
					prest.setString(1, tmp.getSysnoS());
					prest.setString(2, tmp.getSerialS());
					prest.setInt(3, tmp.getDevicesysidI());
					prest.setString(4, tmp.getDoorcodeS());
					prest.setString(5, tmp.getIsdownS());
					
					prest.setString(6, tmp.getDptid());
					prest.setTimestamp(7, new Timestamp(new java.util.Date().getTime()));
					prest.setTimestamp(8, new Timestamp(receptionOrder.getEndDate_d().getTime()));
					prest.setString(9, tmp.getPass());					
					prest.setString(10, tmp.getGroupList());
					prest.addBatch();   
				}
				prest.executeBatch();
			}else{
				String sql = "update Mj_RegUser set IsDown = '2' where Serial=? ";
				prest = sqlcon.prepareStatement(sql);  
				for(int i=0;i<list.size();i++){					
					TOnecardMjreguserBak tmp = list.get(i);
					prest.setString(1, tmp.getSerialS());				
					prest.addBatch();   
				}
				prest.executeBatch();
			}
			
			return 1;
		}catch (Exception e){
			e.printStackTrace();
			//sqlcon.rollback();
			throw new Exception(e);
		}finally{
			try { 
				if (prest != null) prest.close(); 
			}catch(Exception e) {throw new Exception(e);} 
			  
		}
	}
	
	/**
	 * 赋权或删除权限操作	   
	 * OperationMjreguser 
	 * @param   orderID_s 订单编号    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationMjreguser(String orderID_s,int operation) throws Exception{
		Connection sqlcon = null;
		try{
			session = HibernateUtil.getSession();			
			if(!session.isOpen()){
				session= HibernateUtil.getSession();							
			}
			tx=session.beginTransaction();//oracl开启事务
			sqlcon = DataResource.getConnect(ConstantUtil.OneCardSERVERCONN);
			sqlcon.setAutoCommit(false);
			//1、根据订单id（orderid）查出原订单包含的用户
			IreceptionCustomerUserService ireceptionCustomerUserService = new ReceptionCustomerUserServiceImpl();
			ReceptionCustomerUser receptionCustomerUser = new ReceptionCustomerUser();
			receptionCustomerUser.setOrderID_s(orderID_s);
			List<ReceptionCustomerUser> receptionCustomerUsers = ireceptionCustomerUserService.getCustomerUserAllpro(receptionCustomerUser);
			//2、根据订单相关客户人员信息以及选择房门信息转换为登记用户表信息
			List<TOnecardMjreguserBak> tOnecardMjreguserBaks = null;
			tOnecardMjreguserBaks = this.setTOnecardMjreguserPro(receptionCustomerUsers);
			
			//3、保存到一卡通登记用户表
			int request = OperationMjreguserOneCard(tOnecardMjreguserBaks,orderID_s,operation,sqlcon);
			if(request==0){//没有对门卡进行赋权
				return 0;
			}
			//3、保存到试验场登记用户表
			OperationTOnecardMjreguserBak(tOnecardMjreguserBaks,session,operation);
			tx.commit();
			sqlcon.commit();
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			sqlcon.rollback();
			throw e;
		}finally{
			if(sqlcon!=null){
				sqlcon.close();
			}
			session.clear();
		}
	}
	
	public static void main(String[] a){
		IOneCardPbEmplyService iOneCardPbEmplyService = new OneCardPbEmplyServiceImpl();
		int operation = 1;
		List<ReceptionCustomerUser> ReceptionCustomerUsers = new ArrayList();
		ReceptionCustomerUser tmp = new ReceptionCustomerUser();
		tmp.setCustomerUserID_s("RY2014041007");
		tmp.setCard_s("k333");		
		tmp.setOrderID_s("DD2014041009"); 
		tmp.setSerialface_s("x111");
		tmp.setDeviceSysid_s("9");
		tmp.setSysNo_s("000001");	
		ReceptionCustomerUsers.add(tmp);
		ReceptionCustomerUser tmp1 = new ReceptionCustomerUser();
		tmp1.setCustomerUserID_s("RY2014041004");
		tmp1.setCard_s("k444");
		tmp1.setOrderID_s("DD2014041009");
		tmp1.setSerialface_s("x222");
		tmp1.setDeviceSysid_s("5vv43");
		ReceptionCustomerUsers.add(tmp1);
		try {
		//	iOneCardPbEmplyService.OperationPbEmply(ReceptionCustomerUsers, operation);
			ItOnecardMjreguserService ItOnecardMjreguserService = new TOnecardMjreguserServiceImpl();
			ItOnecardMjreguserService.OperationMjreguser("DD2014041009", 1);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
