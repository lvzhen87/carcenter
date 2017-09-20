package com.freshen.preorder.service.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.clims.baseclass.ClimsServiceBase;
import com.freshen.entity.OrderOther;
import com.freshen.entity.OrderRoadDetail;
import com.freshen.entity.VehicleInfo;
import com.freshen.preorder.service.IorderOthersListService;

public class OrderOtherServiceImpl extends ClimsServiceBase implements IorderOthersListService {

	public int OperationorderOthers(List<OrderOther> orderOther, int operation,
			Session session) throws Exception {
		// TODO Auto-generated method stub
		try{
			if(orderOther!=null && orderOther.size()>0){
				
				for(int i=0;i<orderOther.size();i++){
					OrderOther ord = orderOther.get(i);
					OrderOther tmp = (OrderOther)session.get(OrderOther.class, ord.getOrderID_s());
					if(operation==1){
						String orderID_s = ord.getOrderID_s();
						String vehicleCPG_s = ord.getVehicleCPG_s();
						Integer isConfidentiality_i = ord.getIsConfidentiality_i();
						Integer isHighRiskTest_i = ord.getIsHighRiskTest_i();
						String highRiskTestDescription_s = ord.getHighRiskTestDescription_s();
						Integer isCamera_i = ord.getIsCamera_i();
						Date createDate_t = ord.getCreateDate_t();
						String createUser_s = ord.getCreateUser_s();
						String lastUpdateUser_s = ord.getLastUpdateUser_s();
						Date lastUpdateDate_t = ord.getLastUpdateDate_t();
						String resaveds1 = ord.getResaveds1();
						String resaveds2 = ord.getResaveds2();
						String resaveds3 = ord.getResaveds3();
						String resaveds4 = ord.getResaveds4();
						String resaveds5 = ord.getResaveds5();
						String status_i = ord.getStatus_i();
						
						if(orderID_s==null){
							ord.setOrderID_s(tmp.getOrderID_s());
						}
						if(vehicleCPG_s == null){
							ord.setVehicleCPG_s(tmp.getVehicleCPG_s());
						}
						if(isConfidentiality_i == null){
							ord.setIsConfidentiality_i(tmp.getIsConfidentiality_i());
						}
						if(isHighRiskTest_i == null){
							ord.setIsHighRiskTest_i(tmp.getIsHighRiskTest_i());
						}
						if(highRiskTestDescription_s == null){
							ord.setHighRiskTestDescription_s(tmp.getHighRiskTestDescription_s());
						}
						if(isCamera_i == null){
							ord.setIsCamera_i(tmp.getIsCamera_i());
						}
						if(createDate_t == null){
							ord.setCreateDate_t(tmp.getCreateDate_t());
						}
						if(createUser_s == null){
							ord.setCreateUser_s(tmp.getCreateUser_s());
						}
						if(lastUpdateUser_s == null){
							ord.setLastUpdateUser_s(tmp.getLastUpdateUser_s());
						}
						if(lastUpdateDate_t == null){
							ord.setLastUpdateDate_t(tmp.getLastUpdateDate_t());
						}
						if(resaveds1 == null){
							ord.setResaveds1(tmp.getResaveds1());
						}
						if(resaveds2 == null){
							ord.setResaveds2(tmp.getResaveds2());
						}
						if(resaveds3 == null){
							ord.setResaveds3(tmp.getResaveds3());
						}
						if(resaveds4 == null){
							ord.setResaveds4(tmp.getResaveds4());
						}
						if(resaveds5 == null){
							ord.setResaveds5(tmp.getResaveds5());
						}
						if(status_i == null){
							ord.setStatus_i(tmp.getStatus_i());
						}
						
					}
					//删除
					if(operation==2){
						session.delete(ord);
						session.flush();
						session.clear();
					}
					return 1;
				}
			}
		}
		catch(Exception e){
			throw e;
		}
		finally{
			
		}
		return 0;
	}
	
}
