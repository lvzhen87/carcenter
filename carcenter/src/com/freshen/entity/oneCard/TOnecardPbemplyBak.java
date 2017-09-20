package com.freshen.entity.oneCard;

import java.util.Date;

import com.freshen.clims.baseclass.BeanModel;

/**
 * TOnecardPbemplyBak entity. @author MyEclipse Persistence Tools
 */

public class TOnecardPbemplyBak extends  BeanModel {

	// Fields

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

	private Date editFlagTimeT;//操作时间 oracle 中有，sql中没有
	// Constructors

	/** default constructor */
	public TOnecardPbemplyBak() {
	}

	/** minimal constructor */
	public TOnecardPbemplyBak(String sysnoS) {
		this.sysnoS = sysnoS;
	}

	/** full constructor */
	public TOnecardPbemplyBak(String sysnoS, Integer dptidI,
			String emplyidS, String emplynameS, String cardnoS, String serialS,
			String emplytypeS, String emplysexS, String emplypassS,
			Date invalidateT, String emplycodeS, String isdeletedS) {
		this.sysnoS = sysnoS;
		this.dptidI = dptidI;
		this.emplyidS = emplyidS;
		this.emplynameS = emplynameS;
		this.cardnoS = cardnoS;
		this.serialS = serialS;
		this.emplytypeS = emplytypeS;
		this.emplysexS = emplysexS;
		this.emplypassS = emplypassS;
		this.invalidateT = invalidateT;
		this.emplycodeS = emplycodeS;
		this.isdeletedS = isdeletedS;
	}

	// Property accessors

	public String getSysnoS() {
		return this.sysnoS;
	}

	public void setSysnoS(String sysnoS) {
		this.sysnoS = sysnoS;
	}

	

	@Override
	public String toString() {
		return "TOnecardPbemplyBak [cardnoS=" + cardnoS + ", dptidI=" + dptidI
				+ ", editFlagTimeT=" + editFlagTimeT + ", emplycodeS="
				+ emplycodeS + ", emplyidS=" + emplyidS + ", emplynameS="
				+ emplynameS + ", emplypassS=" + emplypassS + ", emplysexS="
				+ emplysexS + ", emplytypeS=" + emplytypeS + ", invalidateT="
				+ invalidateT + ", isdeletedS=" + isdeletedS + ", serialS="
				+ serialS + ", sysnoS=" + sysnoS + "]";
	}

	 

	public Date getEditFlagTimeT() {
		return editFlagTimeT;
	}

	public void setEditFlagTimeT(Date editFlagTimeT) {
		this.editFlagTimeT = editFlagTimeT;
	}

	public Integer getDptidI() {
		return dptidI;
	}

	public void setDptidI(Integer dptidI) {
		this.dptidI = dptidI;
	}

	public String getEmplyidS() {
		return this.emplyidS;
	}

	public void setEmplyidS(String emplyidS) {
		this.emplyidS = emplyidS;
	}

	public String getEmplynameS() {
		return this.emplynameS;
	}

	public void setEmplynameS(String emplynameS) {
		this.emplynameS = emplynameS;
	}

	public String getCardnoS() {
		return this.cardnoS;
	}

	public void setCardnoS(String cardnoS) {
		this.cardnoS = cardnoS;
	}

	public String getSerialS() {
		return this.serialS;
	}

	public void setSerialS(String serialS) {
		this.serialS = serialS;
	}

	public String getEmplytypeS() {
		return this.emplytypeS;
	}

	public void setEmplytypeS(String emplytypeS) {
		this.emplytypeS = emplytypeS;
	}

	public String getEmplysexS() {
		return this.emplysexS;
	}

	public void setEmplysexS(String emplysexS) {
		this.emplysexS = emplysexS;
	}

	public String getEmplypassS() {
		return this.emplypassS;
	}

	public void setEmplypassS(String emplypassS) {
		this.emplypassS = emplypassS;
	}

	public Date getInvalidateT() {
		return this.invalidateT;
	}

	public void setInvalidateT(Date invalidateT) {
		this.invalidateT = invalidateT;
	}

	public String getEmplycodeS() {
		return this.emplycodeS;
	}

	public void setEmplycodeS(String emplycodeS) {
		this.emplycodeS = emplycodeS;
	}

	public String getIsdeletedS() {
		return this.isdeletedS;
	}

	public void setIsdeletedS(String isdeletedS) {
		this.isdeletedS = isdeletedS;
	}

}