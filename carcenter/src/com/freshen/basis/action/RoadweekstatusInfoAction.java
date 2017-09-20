package com.freshen.basis.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
import com.freshen.basis.service.IroadExperimentTypeService;
import com.freshen.basis.service.IroadInfoService;
import com.freshen.basis.service.impl.RoadExperimentTypeServiceImpl;
import com.freshen.basis.service.impl.RoadInfoServiceImpl;
import com.freshen.basis.service.impl.TBasisRoadweekstatusinfoDAO;
import com.freshen.entity.basis.AbstractTBasisRoadweekstatusinfo;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.RoadCost;
import com.freshen.entity.basis.RoadExperimentType;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;

public class RoadweekstatusInfoAction extends CapgActionSupport{

	private static final long serialVersionUID = 1L;
	private String roadidS;
    private String weekstatusS;
    private Date createdateT;
    private String createuserS;
    private String lastupdateuserS;
    private Date lastupdatedateT;
    private String resaveds1S;
    private String resaveds2S;
    private String resaveds3S;
    private String resaveds4S;
    private String resaveds5S;
      
    private String w1 = "1";
    private String w2 = "2";
    private String w3="3";
    private String w4="4";
    private String w5="5";
	int maxCapacity;
	List<AbstractTBasisRoadweekstatusinfo> roadweeklist = new ArrayList<AbstractTBasisRoadweekstatusinfo>();//璁板綍閬撹矾淇℃伅
	
 	 
	/**
	 * 鏌ヨ閬撹矾淇℃伅锛岄粯璁ゆ椂鏌ヨ鎵�湁閬撹矾淇℃伅锛屽綋鏈夋煡璇㈡潯浠舵椂鏌ヨ璇ヤ俊鎭�
	 * @author sharonyshi 2014-5-13
	 */
	/*public String execute(){
		try {
			//璁剧疆鏌ヨ鏉′欢
			RoadInfo ri=new RoadInfo();
			ri.setState_i(-1);//璁剧疆鏌ヨ0鍜�鐨勭姸鎬侊紝鍗虫煡璇㈡墍鏈夌姸鎬�
			
			ArrayList<RoadInfo> rilist=new ArrayList<RoadInfo>();
			rilist.add(ri);
			
			IroadInfoService iris=new RoadInfoServiceImpl();
			roadlist=iris.getRoadInfo(ri);
			
			for (int i = 0; i < roadlist.size(); i++) {
				String temp="";
				Iterator<RoadExperimentType> it = roadlist.get(i).getRoadExperimentTypeSet().iterator();
				while(it.hasNext()){
					temp += it.next().getExperimentTypeName_s()+";";
				}
				roadlist.get(i).setTypes(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
		}
		
		return SUCCESS;
	}*/
	
	/**
	 * 鏌ヨ閬撹矾淇℃伅锛岄粯璁ゆ椂鏌ヨ鎵�湁閬撹矾淇℃伅锛屽綋鏈夋煡璇㈡潯浠舵椂鏌ヨ璇ヤ俊鎭�
	 * @author sharonyshi 2014-5-13
	 */
	public String searchBasisRoadweekstatusinfo(){
		try {
		//	AbstractTBasisRoadweekstatusinfo roadweek = new AbstractTBasisRoadweekstatusinfo(){};
			TBasisRoadweekstatusinfoDAO roadweekDao = new TBasisRoadweekstatusinfoDAO();
			List<AbstractTBasisRoadweekstatusinfo> roadweeklisttmp = roadweekDao.findAll();
			//RoadInfo roadinfo = new RoadInfo();//瑕佹洿鏂扮殑閬撹矾淇℃伅
			IroadInfoService iris=new RoadInfoServiceImpl();
			if(roadweeklisttmp!=null&&roadweeklisttmp.size()>0){
				for(int i=0;i<roadweeklisttmp.size();i++){
					AbstractTBasisRoadweekstatusinfo roadweek = roadweeklisttmp.get(i);
				//for(AbstractTBasisRoadweekstatusinfo roadweek:roadweeklisttmp){
					String[] weekstatusS = roadweek.getWeekstatusS().split(",");
					roadweek.setS1(weekstatusS[0]);
					roadweek.setS2(weekstatusS[1]);
					roadweek.setS3(weekstatusS[2]);
					roadweek.setS4(weekstatusS[3]);
					roadweek.setS5(weekstatusS[4]);
					RoadInfo roadinfo = new RoadInfo();
					roadinfo.setRoadID_s(roadweek.getRoadidS());
					List<RoadInfo> roadlist=iris.getRoadInfo(roadinfo,ConstantUtil.pagingNot,0);
					if(roadlist!=null&&roadlist.size()>0){
						roadinfo = roadlist.get(0);
						roadweek.setRoadname(roadinfo.getRoadName_s());
					}
					roadweeklist.add(roadweek);
					roadidS +=roadweek.getRoadidS();
					if(i<roadweeklisttmp.size()){
						roadidS+=",";
					}
				}				
			}
			
			 
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return SUCCESS;
	}
	
	
/*	 
	
	/**
	 * 娣诲姞鏂扮殑閬撹矾淇℃伅
	 * @author sharonyshi 2014-5-13
	 
	public String addRoadinfo(){
		try {
			TBasisRoadweekstatusinfoDAO roadweekDao = new TBasisRoadweekstatusinfoDAO();
			 
			//璁剧疆閬撹矾鏀惰垂
			RoadCost rc=new RoadCost();
			rc.setRoadID_s(roadID);
			rc.setRemark_s(remark);
			rc.setCreateUser_s(employ.getCustomerUserName_s());
			rc.setCreateDate_t(DateUtil.getCurrentDate());
			rc.setLastUpdateDate_t(DateUtil.getCurrentDate());
			rc.setLastUpdateUser_s(employ.getCustomerUserName_s());
			
			//涓嬮潰杩欏嚑涓垂鐢ㄥ�锛屽鏋滀粠椤甸潰涓紶杩囨潵鏈夊�锛屽垯set閭ｄ釜鍊硷紝鍚﹀垯榛樿鍊间负0.0

			if(unitPrie_i !=null && !unitPrie_i.equals("")){
				rc.setUnitPrie_i(Double.valueOf(unitPrie_i));
			}else{
				rc.setUnitPrie_i(ConstantUtil.price_0);
			}
			
			if(wholeUnitPrie_i !=null && !wholeUnitPrie_i.equals("")){
				rc.setWholeUnitPrie_i(Double.valueOf(wholeUnitPrie_i));
			}else{
				rc.setWholeUnitPrie_i(ConstantUtil.price_0);
			}
			
			if(minuteUnitPrie_i !=null && !minuteUnitPrie_i.equals("")){
				rc.setMinuteUnitPrie_i(Integer.valueOf(minuteUnitPrie_i));
			}else{
				rc.setMinuteUnitPrie_i(ConstantUtil.serverprice_0);
			}
			if(coefficient_i != null && !coefficient_i.equals("")){
				rc.setCoefficient_i(Double.valueOf(coefficient_i));
			}else{
				rc.setCoefficient_i(ConstantUtil.price_1);
			}
			if(activityUnitPrie_i != null && !activityUnitPrie_i.equals("")){
				rc.setActivityUnitPrie_i(Double.valueOf(activityUnitPrie_i));
			}else{
				rc.setActivityUnitPrie_i(ConstantUtil.price_0);
			}
			if(resaveds1 != null && resaveds1.length() >0){
				rc.setResaveds1_s(resaveds1);
			}
			if(resaveds2 != null && resaveds2.length() >0){
				rc.setResaveds2_s(resaveds2);
			}else{
				rc.setResaveds2_s(ConstantUtil.price_0 + "");
			}
			
			
			
			RoadInfo ri=new RoadInfo();
			if(roadID != null &&!roadID.trim().equals("")){//鏇存柊鎿嶄綔
				ri.setRoadID_s(roadID);
				ri.setLastUpdateDate_t(DateUtil.getCurrentDate());
				ri.setLastUpdateUser_s(employ.getCustomerUserName_s());
			}else{//鏂板鎿嶄綔
				ri.setCreateDate_t(DateUtil.getCurrentDate());
				ri.setCreateUser_s(employ.getCustomerUserName_s());
				ri.setLastUpdateDate_t(DateUtil.getCurrentDate());
			}
			ri.setRoadName_s(roadName);
			ri.setTechnicalParameters_s(technicalParameters);
			ri.setMaxCapacity_i(maxCapacity);
			//ri.setInputDate_t(DateUtil.getDate(inputdate));
			ri.setBeginningDay_i(beginningDay_i);
			ri.setState_i(Integer.valueOf(state));
			ri.setRemark_s(remark);
			ri.setRoadType_s(roadType);
			ri.setInputDate_t(inputDate_t);
			rc.setRoadInfo(ri);
			ri.setRoadCost(rc);
			ri.setResaveds1_s(resaveds1_s);
			ri.setResaveds2_s(resaveds2_s);
			ri.setResaveds4_s(resaveds4);
			//灏佽list
			ArrayList<RoadInfo> rilist=new ArrayList<RoadInfo>();
			rilist.add(ri);
			
			sharonyshi-2014-7-31   鐩墠娌＄敤
		 * //灏佽瀹為獙绫诲瀷,棣栧厛鏄惊鐜亶鍘嗛〉闈腑杈撳叆鐨勮瘯楠岀被鍨嬪悕绉帮紝灏嗘瘡鏉¤瘯楠岀被鍨嬭褰曚笌閬撹矾淇℃伅缁勫悎鎴愪竴鏉¤褰�
			ArrayList<RoadExperimentType> retlist=new ArrayList<RoadExperimentType>();
			String ets[]=experimentTypeName.split("vv");
			for (int i = 0; i < ets.length; i++) {
				if(!ets[i].trim().equals("")){
					RoadExperimentType temp=new RoadExperimentType();
					temp.setExperimentTypeName_s(ets[i]);
					temp.setRoadID_s(roadID);
					temp.setRoadName_s(roadName);
					temp.setCreateDate_t(DateUtil.getCurrentDate());
					temp.setCreateUser_s(employ.getCustomerUserName_s());
					retlist.add(temp);
				}
			}
			
			for (int i = 0; i < experimentTypeName.size(); i++) {
				if(!experimentTypeName.get(i).trim().equals("")){
					RoadExperimentType temp=new RoadExperimentType();
					temp.setExperimentTypeName_s(experimentTypeName.get(i));
					temp.setRoadID_s(roadID);
					temp.setRoadName_s(roadName);
					temp.setCreateDate_t(DateUtil.getCurrentDate());
					temp.setCreateUser_s(employ.getCustomerUserName_s());
					retlist.add(temp);
				}
			}
			
			
			IroadInfoService iris=new RoadInfoServiceImpl();
			int result = iris.OperationRoadInfoInfo(rilist, 1);
			if(result == 0){
				return ERROR;
			}
//			IroadExperimentTypeService irets=new RoadExperimentTypeServiceImpl();
//			irets.saveOrUpdateBasisRoadExperimentTypeInfo(retlist);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}


*/

	public String getRoadidS() {
		return roadidS;
	}




	public void setRoadidS(String roadidS) {
		this.roadidS = roadidS;
	}




	public String getWeekstatusS() {
		return weekstatusS;
	}




	public void setWeekstatusS(String weekstatusS) {
		this.weekstatusS = weekstatusS;
	}




	public Date getCreatedateT() {
		return createdateT;
	}




	public void setCreatedateT(Date createdateT) {
		this.createdateT = createdateT;
	}




	public String getCreateuserS() {
		return createuserS;
	}




	public void setCreateuserS(String createuserS) {
		this.createuserS = createuserS;
	}




	public String getLastupdateuserS() {
		return lastupdateuserS;
	}




	public void setLastupdateuserS(String lastupdateuserS) {
		this.lastupdateuserS = lastupdateuserS;
	}




	public Date getLastupdatedateT() {
		return lastupdatedateT;
	}




	public void setLastupdatedateT(Date lastupdatedateT) {
		this.lastupdatedateT = lastupdatedateT;
	}




	public String getResaveds1S() {
		return resaveds1S;
	}




	public void setResaveds1S(String resaveds1s) {
		resaveds1S = resaveds1s;
	}




	public String getResaveds2S() {
		return resaveds2S;
	}




	public void setResaveds2S(String resaveds2s) {
		resaveds2S = resaveds2s;
	}




	public String getResaveds3S() {
		return resaveds3S;
	}




	public void setResaveds3S(String resaveds3s) {
		resaveds3S = resaveds3s;
	}




	public String getResaveds4S() {
		return resaveds4S;
	}




	public void setResaveds4S(String resaveds4s) {
		resaveds4S = resaveds4s;
	}




	public String getResaveds5S() {
		return resaveds5S;
	}




	public void setResaveds5S(String resaveds5s) {
		resaveds5S = resaveds5s;
	}




	public List<AbstractTBasisRoadweekstatusinfo> getRoadweeklist() {
		return roadweeklist;
	}




	public void setRoadweeklist(List<AbstractTBasisRoadweekstatusinfo> roadweeklist) {
		this.roadweeklist = roadweeklist;
	}



	public String getW1() {
		return w1;
	}



	public void setW1(String w1) {
		this.w1 = w1;
	}



	public String getW2() {
		return w2;
	}



	public void setW2(String w2) {
		this.w2 = w2;
	}



	public String getW3() {
		return w3;
	}



	public void setW3(String w3) {
		this.w3 = w3;
	}



	public String getW4() {
		return w4;
	}



	public void setW4(String w4) {
		this.w4 = w4;
	}



	public String getW5() {
		return w5;
	}



	public void setW5(String w5) {
		this.w5 = w5;
	}


 
 
}
