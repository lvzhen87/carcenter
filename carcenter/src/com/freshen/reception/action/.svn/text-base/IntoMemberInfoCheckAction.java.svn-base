package com.freshen.reception.action;

import java.util.ArrayList;

import com.freshen.entity.basis.VCustomeuser;
import com.freshen.util.BasicTools;
import com.freshen.util.ExceptionDispose;
import com.freshen.action.common.CapgActionSupport;
import com.freshen.basis.service.impl.EmployeeServiceImpl;

/**
 *  Class Name: IntoMemberInfoCheckAction.java
 *  Function:门卫二岗亭安保人员根据提供的卡号，查看此人员是否有进入的权限
 *     Modifications:   
 *  @author   DateTime 2014-10-15 yepeng    
 *  @version 1.0
 */
public class IntoMemberInfoCheckAction extends CapgActionSupport {
	
	String rs=SUCCESS;
	String sysNo;					//	人卡卡号
	String memberName;				//	人员姓名
	String companyName;				//	公司名称
	String deptName;				//	部门名称
	String tellPhone;				//	电话
	String position;				//	驾照号
	String cpgDrivingLicence;		//	CPG驾驶证编号
	String cpgLevel;				//	CPG准驾级别
	String inOutMsg;
	String btnFlag;

	ArrayList<VCustomeuser> memberInfoList = new ArrayList<VCustomeuser>();

	public String execute(){
		try {
			
			EmployeeServiceImpl ies = new EmployeeServiceImpl();
			if(null != btnFlag && btnFlag.equals("searchBtn")){
				memberInfoList = ies.getAllcustomerUserAddEmploee(sysNo);
				if(BasicTools.isnotNull(memberInfoList)){
					memberName = memberInfoList.get(0).getCustomerusername_s();
					companyName = memberInfoList.get(0).getCustomername();
					deptName = memberInfoList.get(0).getDepartment_s();
					tellPhone = memberInfoList.get(0).getTelephone_s();
					position = memberInfoList.get(0).getPosition_s();
					cpgDrivingLicence = memberInfoList.get(0).getDrivingLicenceCPG_s();
					cpgLevel = memberInfoList.get(0).getLevelCPG_s();
				} else {
					inOutMsg = "无法根据卡片查找记录，禁止通行！";
				}
			} else if(null != btnFlag && btnFlag.equals("inBtn")){
				//	进道闸的人员，计数，赋权(1：进入道闸)
				if(null != sysNo && !"".equals(sysNo)){
					int inOutFlg = ies.addMj_Iodata(sysNo, 1);
					if(inOutFlg == 1){
						inOutMsg="成功进入";
					} else {
						inOutMsg="已经进入，请先从出口离开后再次进入";
					}
				} else {
					inOutMsg="请输入正确的卡号";
				}
				
			} else if(null != btnFlag && btnFlag.equals("outBtn")){
				//	出道闸的人员，计数，赋权
				if(null != sysNo && !"".equals(sysNo)){
					int inOutFlg = ies.addMj_Iodata(sysNo, 0);
					if(inOutFlg == 1){
						inOutMsg="成功离开";
					} else {
						inOutMsg="已经离开，请先从入口进入后再次离开";
					}
					
				} else {
					inOutMsg="请输入正确的卡号";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return rs;
	}

	public String getBtnFlag() {
		return btnFlag;
	}

	public void setBtnFlag(String btnFlag) {
		this.btnFlag = btnFlag;
	}

	public String getInOutMsg() {
		return inOutMsg;
	}

	public void setInOutMsg(String inOutMsg) {
		this.inOutMsg = inOutMsg;
	}

	public String getTellPhone() {
		return tellPhone;
	}

	public void setTellPhone(String tellPhone) {
		this.tellPhone = tellPhone;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCpgDrivingLicence() {
		return cpgDrivingLicence;
	}

	public void setCpgDrivingLicence(String cpgDrivingLicence) {
		this.cpgDrivingLicence = cpgDrivingLicence;
	}

	public String getCpgLevel() {
		return cpgLevel;
	}

	public void setCpgLevel(String cpgLevel) {
		this.cpgLevel = cpgLevel;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getSysNo() {
		return sysNo;
	}
	public void setSysNo(String sysNo) {
		this.sysNo = sysNo;
	}

	public ArrayList<VCustomeuser> getMemberInfoList() {
		return memberInfoList;
	}

	public void setMemberInfoList(ArrayList<VCustomeuser> memberInfoList) {
		this.memberInfoList = memberInfoList;
	}
}
