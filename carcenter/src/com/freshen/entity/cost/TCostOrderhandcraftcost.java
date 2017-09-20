package com.freshen.entity.cost;

import java.util.Date;

import com.freshen.clims.baseclass.BeanModel;
import com.freshen.entity.basis.CustomerUser;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.VCustomeuser;
import com.freshen.entity.reception.ReceptionOrder;
import com.freshen.entity.reception.ReceptionVehicleInfo;


/**
 * TCostOrderhandcraftcost entity. @author MyEclipse Persistence Tools
 */

public class TCostOrderhandcraftcost  extends  BeanModel {


    // Fields

     private String handcraftserialnumberS;
     private String orderidS;
     private Date occurdatetimeT;
     private Double reckoncostI;
     private String customerusercardS;
     private String vehicleCPG_s;
     private String employeeidS;
     private Date createdateT;
     private String createuserS;
     private String remarkS="";
     private String resaveds1S;
     private String resaveds2S;
     private String resaveds3S;
     private String resaveds4S;
     private String resaveds5S;
     ReceptionOrder receptionOrder = new ReceptionOrder(); //相关订单
     VCustomeuser customerUser = new VCustomeuser();      //相关客户人员
     ReceptionVehicleInfo receptionVehicleInfo = new ReceptionVehicleInfo();//相关车辆
     //Employee employee;//确认职员
     private String employeeNameS;
     private Date startoccurdatetimeT;//事件开始时间
     private Date endoccurdatetimeT;//事件结束时间
     
    // Constructors

    /** default constructor */
    public TCostOrderhandcraftcost() {
    }

	/** minimal constructor */
    public TCostOrderhandcraftcost(String handcraftserialnumberS) {
        this.handcraftserialnumberS = handcraftserialnumberS;
    }
    
    /** full constructor */
    public TCostOrderhandcraftcost(String handcraftserialnumberS, String orderidS, Date occurdatetimeT, Double reckoncostI, String customerusercardS, String carcardS, String employeeidS, Date createdateT, String createuserS, String remarkS, String resaveds1S, String resaveds2S, String resaveds3S, String resaveds4S, String resaveds5S) {
        this.handcraftserialnumberS = handcraftserialnumberS;
        this.orderidS = orderidS;
        this.occurdatetimeT = occurdatetimeT;
        this.reckoncostI = reckoncostI;
        this.customerusercardS = customerusercardS;
      
        this.employeeidS = employeeidS;
        this.createdateT = createdateT;
        this.createuserS = createuserS;
        this.remarkS = remarkS;
        this.resaveds1S = resaveds1S;
        this.resaveds2S = resaveds2S;
        this.resaveds3S = resaveds3S;
        this.resaveds4S = resaveds4S;
        this.resaveds5S = resaveds5S;
    }

   
    // Property accessors

    @Override
	public String toString() {
		return "TCostOrderhandcraftcost [createdateT=" + createdateT
				+ ", createuserS=" + createuserS + ", customerUser="
				+ customerUser + ", customerusercardS=" + customerusercardS
				+ ", employeeNameS=" + employeeNameS + ", employeeidS="
				+ employeeidS + ", endoccurdatetimeT=" + endoccurdatetimeT
				+ ", handcraftserialnumberS=" + handcraftserialnumberS
				+ ", occurdatetimeT=" + occurdatetimeT + ", orderidS="
				+ orderidS + ", receptionOrder=" + receptionOrder
				+ ", receptionVehicleInfo=" + receptionVehicleInfo
				+ ", reckoncostI=" + reckoncostI + ", remarkS=" + remarkS
				+ ", resaveds1S=" + resaveds1S + ", resaveds2S=" + resaveds2S
				+ ", resaveds3S=" + resaveds3S + ", resaveds4S=" + resaveds4S
				+ ", resaveds5S=" + resaveds5S + ", startoccurdatetimeT="
				+ startoccurdatetimeT + ", vehicleCPG_s=" + vehicleCPG_s + "]";
	}

	public String getHandcraftserialnumberS() {
        return this.handcraftserialnumberS;
    }
    
    public void setHandcraftserialnumberS(String handcraftserialnumberS) {
        this.handcraftserialnumberS = handcraftserialnumberS;
    }

    public String getOrderidS() {
        return this.orderidS;
    }
    
    public void setOrderidS(String orderidS) {
        this.orderidS = orderidS;
    }

    public Date getOccurdatetimeT() {
        return this.occurdatetimeT;
    }
    
    public void setOccurdatetimeT(Date occurdatetimeT) {
        this.occurdatetimeT = occurdatetimeT;
    }

    public Double getReckoncostI() {
        return this.reckoncostI;
    }
    
    public void setReckoncostI(Double reckoncostI) {
        this.reckoncostI = reckoncostI;
    }

    public String getCustomerusercardS() {
        return this.customerusercardS;
    }
    
    public void setCustomerusercardS(String customerusercardS) {
        this.customerusercardS = customerusercardS;
    }

    
    public String getEmployeeidS() {
        return this.employeeidS;
    }
    
    public void setEmployeeidS(String employeeidS) {
        this.employeeidS = employeeidS;
    }

    public Date getCreatedateT() {
        return this.createdateT;
    }
    
    public void setCreatedateT(Date createdateT) {
        this.createdateT = createdateT;
    }

    public String getCreateuserS() {
        return this.createuserS;
    }
    
    public void setCreateuserS(String createuserS) {
        this.createuserS = createuserS;
    }

    public String getRemarkS() {
        return this.remarkS;
    }
    
    public void setRemarkS(String remarkS) {
        this.remarkS = remarkS;
    }

    public String getResaveds1S() {
        return this.resaveds1S;
    }
    
    public void setResaveds1S(String resaveds1S) {
        this.resaveds1S = resaveds1S;
    }

    public String getResaveds2S() {
        return this.resaveds2S;
    }
    
    public void setResaveds2S(String resaveds2S) {
        this.resaveds2S = resaveds2S;
    }

    public String getResaveds3S() {
        return this.resaveds3S;
    }
    
    public void setResaveds3S(String resaveds3S) {
        this.resaveds3S = resaveds3S;
    }

    public String getResaveds4S() {
        return this.resaveds4S;
    }
    
    public void setResaveds4S(String resaveds4S) {
        this.resaveds4S = resaveds4S;
    }

    public String getResaveds5S() {
        return this.resaveds5S;
    }
    
    public void setResaveds5S(String resaveds5S) {
        this.resaveds5S = resaveds5S;
    }

	public ReceptionOrder getReceptionOrder() {
		return receptionOrder;
	}

	public void setReceptionOrder(ReceptionOrder receptionOrder) {
		this.receptionOrder = receptionOrder;
	}

	public Date getStartoccurdatetimeT() {
		return startoccurdatetimeT;
	}

	public void setStartoccurdatetimeT(Date startoccurdatetimeT) {
		this.startoccurdatetimeT = startoccurdatetimeT;
	}

	public Date getEndoccurdatetimeT() {
		return endoccurdatetimeT;
	}

	public void setEndoccurdatetimeT(Date endoccurdatetimeT) {
		this.endoccurdatetimeT = endoccurdatetimeT;
	}

	public String getVehicleCPG_s() {
		return vehicleCPG_s;
	}

	public void setVehicleCPG_s(String vehicleCPGS) {
		vehicleCPG_s = vehicleCPGS;
	}

	 

	public VCustomeuser getCustomerUser() {
		return customerUser;
	}

	public void setCustomerUser(VCustomeuser customerUser) {
		this.customerUser = customerUser;
	}

	public ReceptionVehicleInfo getReceptionVehicleInfo() {
		return receptionVehicleInfo;
	}

	public void setReceptionVehicleInfo(ReceptionVehicleInfo receptionVehicleInfo) {
		this.receptionVehicleInfo = receptionVehicleInfo;
	}

	public String getEmployeeNameS() {
		return employeeNameS;
	}

	public void setEmployeeNameS(String employeeNameS) {
		this.employeeNameS = employeeNameS;
	}

	 
   
	
}