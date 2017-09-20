package com.freshen.basis.action;

import java.util.ArrayList;
import java.util.List;

import com.freshen.action.common.CapgActionSupport;
import com.freshen.basis.service.IOtherChargeInfoService;
import com.freshen.basis.service.impl.OtherChargeInfoServiceImpl;
import com.freshen.clims.baseclass.ServiceImpl;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.OtherChargeInfo;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;

public class ChargeInfoAction extends CapgActionSupport{

	private static final long serialVersionUID = 1L;
	
	List<OtherChargeInfo> chargelist=new ArrayList<OtherChargeInfo>();
	OtherChargeInfo chargeinfo=new OtherChargeInfo();
	String id_i;
	int electricCharge_i,administrativeFee_i,telephoneBill_i,artisanCharge_i;
	
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人
	
	
	public String execute(){
		try {
			IOtherChargeInfoService ios=new OtherChargeInfoServiceImpl();
			chargelist=ios.getOtherChargeInfo(null, ConstantUtil.pagingNot,0);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;

	}
	
	public String prepareCharge(){
		try {
			OtherChargeInfo ci=new OtherChargeInfo();
			if(id_i != null && id_i.trim().length()>0){
				ci.setId_i(Integer.valueOf(id_i));
			}
			IOtherChargeInfoService ios=new OtherChargeInfoServiceImpl();
			List<OtherChargeInfo> list=ios.getOtherChargeInfo(ci, ConstantUtil.pagingNot,0);
			if(list!=null){
				chargeinfo=list.get(0);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;

	}
	
	public String modifyCharge(){
		try {
			OtherChargeInfo ci=new OtherChargeInfo();
			if(id_i !=null && id_i.trim().length()>0){//说明是更新操作
				ci.setId_i(Integer.valueOf(id_i));
			}
			ci.setCreateDate_t(DateUtil.getCurrentDate());
			ci.setCreateUser_s(employ.getCustomerUserName_s());
			ci.setAdministrativeFee_i(administrativeFee_i);
			ci.setArtisanCharge_i(artisanCharge_i);
			ci.setElectricCharge_i(electricCharge_i);
			ci.setTelephoneBill_i(telephoneBill_i);
			
			/*if(electricCharge_i!=null && electricCharge_i.trim().length()>0){
				ci.setElectricCharge_i(Integer.valueOf(electricCharge_i));
			}else{
				ci.setElectricCharge_i(0);
			}
			if(administrativeFee_i!=null && administrativeFee_i.trim().length()>0){
				ci.setAdministrativeFee_i(Integer.valueOf(administrativeFee_i));
			}*/
			List<OtherChargeInfo> clist=new ArrayList<OtherChargeInfo>();
			clist.add(ci);
			
			Object[] o = {clist,1};
			List<ServiceImpl> se = new ArrayList<ServiceImpl>();
			ServiceImpl tmp = new ServiceImpl(OtherChargeInfoServiceImpl.class.toString().substring(6),"OperationOtherChargeInfoWithOutTrans",o);
			se.add(tmp);
			ServiceImpl.invoke(se);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;

	}
	
	public String deleteCharge(){
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}

	public List<OtherChargeInfo> getChargelist() {
		return chargelist;
	}

	public void setChargelist(List<OtherChargeInfo> chargelist) {
		this.chargelist = chargelist;
	}

	public OtherChargeInfo getChargeinfo() {
		return chargeinfo;
	}

	public void setChargeinfo(OtherChargeInfo chargeinfo) {
		this.chargeinfo = chargeinfo;
	}

	public String getId_i() {
		return id_i;
	}

	public void setId_i(String id_i) {
		this.id_i = id_i;
	}

	public int getElectricCharge_i() {
		return electricCharge_i;
	}

	public void setElectricCharge_i(int electricCharge_i) {
		this.electricCharge_i = electricCharge_i;
	}

	public int getAdministrativeFee_i() {
		return administrativeFee_i;
	}

	public void setAdministrativeFee_i(int administrativeFee_i) {
		this.administrativeFee_i = administrativeFee_i;
	}

	public int getTelephoneBill_i() {
		return telephoneBill_i;
	}

	public void setTelephoneBill_i(int telephoneBill_i) {
		this.telephoneBill_i = telephoneBill_i;
	}

	public int getArtisanCharge_i() {
		return artisanCharge_i;
	}

	public void setArtisanCharge_i(int artisanCharge_i) {
		this.artisanCharge_i = artisanCharge_i;
	}
	
	
	

}
