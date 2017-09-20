package com.freshen.preorder.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.entity.Customer;
import com.freshen.entity.VehicleInfo;
import com.freshen.preorder.service.IvehicleInfoService;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class VehicleInfoServiceImpl extends ClimsServiceBase implements  IvehicleInfoService{

	Session session= HibernateUtil.getSession();
	Transaction tx = null;
	String orderID_s;
	String vehicleCPG_s;
	String model_s;
	String color_s;
	Date createDate_t;
	String createUser_s;
	String lastUpdateUser_s;
	Date lastUpdateDate_t;
	String resaveds1;
	String resaveds2;
	String resaveds3;
	String resaveds4;
	String resaveds5;
	String fuelDemand_s;
	String weight_s;
	String maxWeight_s;
	String licensPlate_s;
	String brandType_s;
	String maxSpeed_s;
	String vin_s;
	String fuelConsumption_s;
	Integer category_i;
	Integer axleNumber_i;
	public ArrayList<VehicleInfo> getVehicleInfo(VehicleInfo vehicleInfo,
			int start, int size) throws Exception {
		// TODO Auto-generated method stub
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		List<VehicleInfo> list = null;
		try{
			if(vehicleInfo==null){
				//System.out.println("执行无条件查询 分页");
				Query query=session.createQuery("from VehicleInfo");
				if(start!=ConstantUtil.pagingNot){
					query.setFirstResult(start);
				    query.setMaxResults(size);
				}
			    list = query.list();	  			
				return (ArrayList) list;
			}			
			setModel(vehicleInfo);
			String hql="from VehicleInfo as vehicleInfo where 1=1 "; 
		    String condition = "";
			if(orderID_s!=null&&vehicleCPG_s!=null){
				condition = condition+" and vehicleInfo.vehicleCPG_s like '%"+vehicleCPG_s+"%'";
		    }
	
					 
		    
		    if(orderID_s!=null){
		    	condition = condition+" and vehicleInfo.orderID_s like '%"+orderID_s+"%'";
		    }
		    if(vehicleCPG_s!=null){
		    	condition = condition+" and vehicleInfo.vehicleCPG_s like '%"+vehicleCPG_s+"%'";
		    }
		    if(model_s!=null){
		    	condition = condition+" and vehicleInfo.model_s like '%"+model_s+"%'";
		    }
		    if(color_s!=null){
		    	condition = condition+" and vehicleInfo.color_s like '%"+color_s+"%'";
		    }		    
		    if(createDate_t!=null){
		    	condition = condition+" and to_char(vehicleInfo.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s!=null){
		    	condition = condition+" and vehicleInfo.createUser_s like '%"+createUser_s+"%'";
		    }	
		    if(lastUpdateUser_s!=null){
		    	condition = condition+" and vehicleInfo.lastUpdateUser_s like '%"+lastUpdateUser_s+"%'";
		    }	
		    if(lastUpdateDate_t!=null){
		    	condition = condition+" and to_char(vehicleInfo.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    
		    if(resaveds1!=null){
		    	condition = condition+" and vehicleInfo.resaveds1 like '%"+resaveds1+"%'";
		    }	
		    if(resaveds2!=null){
		    	condition = condition+" and vehicleInfo.resaveds2 like '%"+resaveds2+"%'";
		    }	
		    if(resaveds3!=null){
		    	condition = condition+" and vehicleInfo.resaveds3 like '%"+resaveds3+"%'";
		    }	
		    if(resaveds4!=null){
		    	condition = condition+" and vehicleInfo.resaveds4 like '%"+resaveds4+"%'";
		    }	
		    if(resaveds5!=null){
		    	condition = condition+" and vehicleInfo.resaveds5 like '%"+resaveds5+"%'";
		    }	
		    if(fuelDemand_s!=null){
		    	condition = condition+" and vehicleInfo.fuelDemand_s like '%"+fuelDemand_s+"%'";
		    }	
		    if(weight_s!=null){
		    	condition = condition+" and vehicleInfo.weight_s like '%"+weight_s+"%'";
		    }	
		    if(maxWeight_s!=null){
		    	condition = condition+" and vehicleInfo.maxWeight_s like '%"+maxWeight_s+"%'";
		    }	
		    if( licensPlate_s!= null){
		    	condition = condition+" and vehicleInfo.licensPlate_s like '%"+licensPlate_s+"%'";
		    }
		    if( brandType_s!= null){
		    	condition = condition+" and vehicleInfo.brandType_s like '%"+brandType_s+"%'";
		    }
		    if( maxSpeed_s!= null){
		    	condition = condition+" and vehicleInfo.maxSpeed_s like '%"+maxSpeed_s+"%'";
		    }
		    if( vin_s!= null){
		    	condition = condition+" and vehicleInfo.vin_s like '%"+vin_s+"%'";
		    }
		    if( fuelConsumption_s!= null){
		    	condition = condition+" and vehicleInfo.fuelConsumption_s like '%"+fuelConsumption_s+"%'";
		    }
		    if( category_i!= null){
		    	condition = condition+" and vehicleInfo.category_i  = '"+category_i+"'";
		    }
		    if( axleNumber_i!= null){
		    	condition = condition+" and vehicleInfo.axleNumber_i  = '"+axleNumber_i+"'";
		    }
		    Query query=session.createQuery(hql+condition);
		    if(start!=ConstantUtil.pagingNot){
			    query.setFirstResult(start);
			    query.setMaxResults(size);
		    }
		    list = query.list();	    
			return (ArrayList<VehicleInfo>) list;
		}catch (Exception e){		
			throw new Exception(e);
		}finally{
			 
		}
	}

	public long getVehicleInfoNumber(VehicleInfo vehicleInfo) throws Exception {
		// TODO Auto-generated method stub
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		List<VehicleInfo> list = null;
		try{
			if(vehicleInfo==null){
				//System.out.println("执行无条件查询 分页");
				Query query=session.createQuery("select count(*) from VehicleInfo");
				long n=0;
			    if(query.iterate().hasNext()){
			    	n=(Long) query.iterate().next();
			    } 
			}			
			setModel(vehicleInfo);
		 
			if(orderID_s!=null&&vehicleCPG_s!=null){			
				vehicleInfo=(VehicleInfo)session.get(vehicleInfo.getClass(), vehicleInfo);
				if(vehicleInfo==null){
					return 0;
				}
		    	return 1;
		    }
	
			String hql="select count(*) from VehicleInfo as vehicleInfo where 1=1 "; 
		    String condition = "";		 
		    
		    if(orderID_s!=null){
		    	condition = condition+" and vehicleInfo.orderID_s like '%"+orderID_s+"%'";
		    }
		    if(vehicleCPG_s!=null){
		    	condition = condition+" and vehicleInfo.vehicleCPG_s like '%"+vehicleCPG_s+"%'";
		    }
		    if(model_s!=null){
		    	condition = condition+" and vehicleInfo.model_s like '%"+model_s+"%'";
		    }
		    if(color_s!=null){
		    	condition = condition+" and vehicleInfo.color_s like '%"+color_s+"%'";
		    }
		    if(createDate_t!=null){
		    	condition = condition+" and to_char(vehicleInfo.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s!=null){
		    	condition = condition+" and vehicleInfo.createUser_s like '%"+createUser_s+"%'";
		    }	
		    if(lastUpdateUser_s!=null){
		    	condition = condition+" and vehicleInfo.lastUpdateUser_s like '%"+lastUpdateUser_s+"%'";
		    }	
		    if(lastUpdateDate_t!=null){
		    	condition = condition+" and to_char(vehicleInfo.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    
		    if(resaveds1!=null){
		    	condition = condition+" and vehicleInfo.resaveds1 like '%"+resaveds1+"%'";
		    }	
		    if(resaveds2!=null){
		    	condition = condition+" and vehicleInfo.resaveds2 like '%"+resaveds2+"%'";
		    }	
		    if(resaveds3!=null){
		    	condition = condition+" and vehicleInfo.resaveds3 like '%"+resaveds3+"%'";
		    }	
		    if(resaveds4!=null){
		    	condition = condition+" and vehicleInfo.resaveds4 like '%"+resaveds4+"%'";
		    }	
		    if(resaveds5!=null){
		    	condition = condition+" and vehicleInfo.resaveds5 like '%"+resaveds5+"%'";
		    }	
		    if(fuelDemand_s!=null){
		    	condition = condition+" and vehicleInfo.fuelDemand_s like '%"+fuelDemand_s+"%'";
		    }	
		    if(weight_s!=null){
		    	condition = condition+" and vehicleInfo.weight_s like '%"+weight_s+"%'";
		    }	
		    if(maxWeight_s!=null){
		    	condition = condition+" and vehicleInfo.maxWeight_s like '%"+maxWeight_s+"%'";
		    }	
		    if( licensPlate_s!= null){
		    	condition = condition+" and vehicleInfo.licensPlate_s like '%"+licensPlate_s+"%'";
		    }
		    if( brandType_s!= null){
		    	condition = condition+" and vehicleInfo.brandType_s like '%"+brandType_s+"%'";
		    }
		    if( maxSpeed_s!= null){
		    	condition = condition+" and vehicleInfo.maxSpeed_s like '%"+maxSpeed_s+"%'";
		    }
		    if( vin_s!= null){
		    	condition = condition+" and vehicleInfo.vin_s like '%"+vin_s+"%'";
		    }
		    if( fuelConsumption_s!= null){
		    	condition = condition+" and vehicleInfo.fuelConsumption_s like '%"+fuelConsumption_s+"%'";
		    }
		    if( category_i!= null){
		    	condition = condition+" and vehicleInfo.category_i  = '"+category_i+"'";
		    }
		    if( axleNumber_i!= null){
		    	condition = condition+" and vehicleInfo.axleNumber_i  = '"+axleNumber_i+"'";
		    }
		    Query query=session.createQuery(hql+condition);
		    long n=0;
		    if(query.iterate().hasNext()){
		    	n=(Long) query.iterate().next();
		    }  		  
			return n;
		}catch (Exception e){		
			throw new Exception(e);
		}finally{
			 
		}
	}

	public int OperationSubscribeVehicleInfo(
			 List<VehicleInfo> vehicleInfo,int operation)
			throws Exception {	
		try{
			if(!session.isOpen()){
				session= HibernateUtil.getSession();							
			}
			tx=session.beginTransaction();//开启事务
			 
			//新增
			if(operation==1){
				IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
				if(vehicleInfo!=null||vehicleInfo.size()>0){
					for(int i=0;i<vehicleInfo.size();i++){		
						VehicleInfo vtmp = vehicleInfo.get(i);
						if(vtmp.getVehicleCPG_s() ==null || vtmp.getVehicleCPG_s().trim().length()<1){
							String cpg = systemSequenceServiceImpl.getPK(ConstantUtil.SUBCPGBusiness, session);
							vtmp.setVehicleCPG_s(cpg);
						}
						session.saveOrUpdate(vtmp);
						session.flush();
					    session.clear();
					}
				}
			}
			//删除
			if(operation==2){
				if(vehicleInfo!=null&&vehicleInfo.size()>0){
					for(int i=0;i<vehicleInfo.size();i++){
						session.delete(vehicleInfo.get(i));
						session.flush();
						session.clear();
					}
				}
			}
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
	 * 对属性进行赋值
	 * setModel 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void setModel(VehicleInfo vehicleInfo){
		if(vehicleInfo!=null){
			 orderID_s = vehicleInfo.getOrderID_s();
			 vehicleCPG_s = vehicleInfo.getVehicleCPG_s();
			 model_s = vehicleInfo.getModel_s();
			 color_s = vehicleInfo.getColor_s();
			 createDate_t = vehicleInfo.getCreateDate_t();
			 createUser_s = vehicleInfo.getCreateUser_s();
			 lastUpdateUser_s = vehicleInfo.getLastUpdateUser_s();
			 lastUpdateDate_t = vehicleInfo.getLastUpdateDate_t();
			 resaveds1 = vehicleInfo.getResaveds1();
			 resaveds2 = vehicleInfo.getResaveds2();
			 resaveds3 = vehicleInfo.getResaveds3();
			 resaveds4 = vehicleInfo.getResaveds4();
			 resaveds5 = vehicleInfo.getResaveds5() ;
			 fuelDemand_s = vehicleInfo.getFuelDemand_s();
			 weight_s = vehicleInfo.getWeight_s();
		     maxWeight_s = vehicleInfo.getMaxWeight_s();
		     licensPlate_s = vehicleInfo.getLicensPlate_s();
		 	 brandType_s = vehicleInfo.getBrandType_s();
		 	 maxSpeed_s = vehicleInfo.getMaxSpeed_s();
		 	 vin_s = vehicleInfo.getVin_s();
		 	 fuelConsumption_s = vehicleInfo.getFuelConsumption_s();
		 	 category_i = vehicleInfo.getCategory_i();
		 	axleNumber_i = vehicleInfo.getAxleNumber_i();
		}
	}

	public int OperationSubscribeVehicleInfo(List<VehicleInfo> vehicleInfo,
			int operation, Session session) throws Exception {
		try{
			tx=session.beginTransaction();//开启事务
			 
			//新增
			if(operation==1){
				IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
				if(vehicleInfo!=null||vehicleInfo.size()>0){
					for(int i=0;i<vehicleInfo.size();i++){		
						VehicleInfo vtmp = vehicleInfo.get(i);
						if(vtmp.getVehicleCPG_s() ==null || vtmp.getVehicleCPG_s().equals("")){
							String cpg = systemSequenceServiceImpl.getPK(ConstantUtil.SUBCPGBusiness, session);
							vtmp.setVehicleCPG_s(cpg);
						}
						session.merge(vtmp);
					}
				}
			}
			//删除
			if(operation==2){
				if(vehicleInfo!=null&&vehicleInfo.size()>0){
					for(int i=0;i<vehicleInfo.size();i++){
						session.delete(vehicleInfo.get(i));
					}
				}
			}
			return 1;
		}catch(Exception e){
			throw new Exception(e);
		}finally{					 
			session.clear();
		    			 
		}	
	}

	/*public static void main(String arg[]){		
		List<VehicleInfo> v = new ArrayList();		 
		VehicleInfo vehicleInfo = new VehicleInfo();
		vehicleInfo.setOrderID_s("DD2014041007");
		vehicleInfo.setModel_s("车型1");
		vehicleInfo.setColor_s("红");
		vehicleInfo.setWeight_s("100");
		vehicleInfo.setMaxWeight_s("200");
		vehicleInfo.setFuelDemand_s("1");
		vehicleInfo.setCreateDate_t(new Date());
		vehicleInfo.setCreateUser_s("kxc");
		VehicleInfo vehicleInfo1 = new VehicleInfo();
		vehicleInfo1.setOrderID_s("DD2014041007");
		vehicleInfo1.setModel_s("车型2");
		vehicleInfo1.setColor_s("黄");
		vehicleInfo1.setWeight_s("101");
		vehicleInfo1.setMaxWeight_s("201");
		vehicleInfo1.setFuelDemand_s("2");
		vehicleInfo1.setCreateDate_t(new Date());
		vehicleInfo1.setCreateUser_s("kxc");
		v.add(vehicleInfo1);
		v.add(vehicleInfo);
		
		VehicleInfoServiceImpl vehicleInfoServiceImpl = new VehicleInfoServiceImpl();
		try {
			int l = vehicleInfoServiceImpl.OperationSubscribeVehicleInfo(v, 1);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Customer customer = new Customer();
		customer.setCustomerID_s("KH2014042045");
		 try {
			List l = new VehicleInfoServiceImpl().getCustomer(customer,-1,2);
			//System.out.println(l);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
}
