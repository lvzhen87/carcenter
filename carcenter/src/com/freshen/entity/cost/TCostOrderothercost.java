package com.freshen.entity.cost;

import java.math.BigDecimal;
import java.util.Date;


/**
 * TCostOrderothercost entity. @author MyEclipse Persistence Tools
 */

public class TCostOrderothercost  implements java.io.Serializable {


    // Fields    

	 private String orderidS;
	 private double electricchargeI;
	 private double administrativefeeI;
	 private double telephonebillI;
	 private double artisanchargeI;
	 Date createDate_t;
	String createUser_s;
	String resaveds1_s;
	String resaveds2_s;
	String resaveds3_s; 
	String resaveds4_s; 
	String resaveds5_s;
	 private int datenumberI;


    // Constructors

    public void setElectricchargeI(double electricchargeI) {
		this.electricchargeI = electricchargeI;
	}

	public void setTelephonebillI(double telephonebillI) {
		this.telephonebillI = telephonebillI;
	}

	public void setArtisanchargeI(double artisanchargeI) {
		this.artisanchargeI = artisanchargeI;
	}

	public void setDatenumberI(int datenumberI) {
		this.datenumberI = datenumberI;
	}

	/** default constructor */
    public TCostOrderothercost() {
    }

	/** minimal constructor */
    public TCostOrderothercost(String orderidS) {
        this.orderidS = orderidS;
    }
    
    

   
    // Property accessors

    public Date getCreateDate_t() {
		return createDate_t;
	}

	public void setCreateDate_t(Date createDate_t) {
		this.createDate_t = createDate_t;
	}

	public String getCreateUser_s() {
		return createUser_s;
	}

	public void setCreateUser_s(String createUser_s) {
		this.createUser_s = createUser_s;
	}

	public String getResaveds1_s() {
		return resaveds1_s;
	}

	public void setResaveds1_s(String resaveds1_s) {
		this.resaveds1_s = resaveds1_s;
	}

	public String getResaveds2_s() {
		return resaveds2_s;
	}

	public void setResaveds2_s(String resaveds2_s) {
		this.resaveds2_s = resaveds2_s;
	}

	public String getResaveds3_s() {
		return resaveds3_s;
	}

	public void setResaveds3_s(String resaveds3_s) {
		this.resaveds3_s = resaveds3_s;
	}

	public String getResaveds4_s() {
		return resaveds4_s;
	}

	public void setResaveds4_s(String resaveds4_s) {
		this.resaveds4_s = resaveds4_s;
	}

	public String getResaveds5_s() {
		return resaveds5_s;
	}

	public void setResaveds5_s(String resaveds5_s) {
		this.resaveds5_s = resaveds5_s;
	}

	public String getOrderidS() {
        return this.orderidS;
    }
    
    public void setOrderidS(String orderidS) {
        this.orderidS = orderidS;
    }
 
    public double getAdministrativefeeI() {
        return this.administrativefeeI;
    }
    
    public void setAdministrativefeeI(double administrativefeeI) {
        this.administrativefeeI = administrativefeeI;
    }
 
	public TCostOrderothercost(String orderidS, double electricchargeI,
			double administrativefeeI, double telephonebillI,
			double artisanchargeI, Date createDate_t, String createUser_s,
			String resaveds1_s, String resaveds2_s, String resaveds3_s,
			String resaveds4_s, String resaveds5_s, int datenumberI) {
		super();
		this.orderidS = orderidS;
		this.electricchargeI = electricchargeI;
		this.administrativefeeI = administrativefeeI;
		this.telephonebillI = telephonebillI;
		this.artisanchargeI = artisanchargeI;
		this.createDate_t = createDate_t;
		this.createUser_s = createUser_s;
		this.resaveds1_s = resaveds1_s;
		this.resaveds2_s = resaveds2_s;
		this.resaveds3_s = resaveds3_s;
		this.resaveds4_s = resaveds4_s;
		this.resaveds5_s = resaveds5_s;
		this.datenumberI = datenumberI;
	}

	public double getElectricchargeI() {
		return electricchargeI;
	}

	public double getTelephonebillI() {
		return telephonebillI;
	}

	public double getArtisanchargeI() {
		return artisanchargeI;
	}

	public int getDatenumberI() {
		return datenumberI;
	}
   








}