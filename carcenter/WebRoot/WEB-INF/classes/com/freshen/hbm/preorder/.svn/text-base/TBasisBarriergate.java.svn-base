package com.freshen.hbm.preorder;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TBasisBarriergate entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_BASIS_BARRIERGATE", schema = "SYSTEM")
public class TBasisBarriergate implements java.io.Serializable {

	// Fields

	private String gateidS;
	private String gatetypeS;
//	private String gatecompanyS;
	private String roadidS;
	private short stateI;
	private Date createdateT;
	private String createuserS;
	private String lastupdateuserS;
	private Date lastupdatedateT;
	private String resaveds1S;
	private String resaveds2S;
	private String resaveds3S;
	private String resaveds4S;
	private String resaveds5S;

	// Constructors

	/** default constructor */
	public TBasisBarriergate() {
	}

	/** minimal constructor */
	public TBasisBarriergate(String roadidS, Date createdateT,
			String createuserS) {
		this.roadidS = roadidS;
		this.createdateT = createdateT;
		this.createuserS = createuserS;
	}

	/** full constructor */
	public TBasisBarriergate(String gatetypeS, 
//			String gatecompanyS,
			String roadidS, short stateI, Date createdateT, String createuserS,
			String lastupdateuserS, Date lastupdatedateT, String resaveds1S,
			String resaveds2S, String resaveds3S, String resaveds4S,
			String resaveds5S) {
		this.gatetypeS = gatetypeS;
//		this.gatecompanyS = gatecompanyS;
		this.roadidS = roadidS;
		this.stateI = stateI;
		this.createdateT = createdateT;
		this.createuserS = createuserS;
		this.lastupdateuserS = lastupdateuserS;
		this.lastupdatedateT = lastupdatedateT;
		this.resaveds1S = resaveds1S;
		this.resaveds2S = resaveds2S;
		this.resaveds3S = resaveds3S;
		this.resaveds4S = resaveds4S;
		this.resaveds5S = resaveds5S;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "GATEID_S", unique = true, nullable = false, length = 80)
	public String getGateidS() {
		return this.gateidS;
	}

	public void setGateidS(String gateidS) {
		this.gateidS = gateidS;
	}

	@Column(name = "GATETYPE_S", length = 80)
	public String getGatetypeS() {
		return this.gatetypeS;
	}

	public void setGatetypeS(String gatetypeS) {
		this.gatetypeS = gatetypeS;
	}

//	@Column(name = "GATECOMPANY_S", length = 80)
//	public String getGatecompanyS() {
//		return this.gatecompanyS;
//	}
//
//	public void setGatecompanyS(String gatecompanyS) {
//		this.gatecompanyS = gatecompanyS;
//	}

	@Column(name = "ROADID_S", nullable = false, length = 80)
	public String getRoadidS() {
		return this.roadidS;
	}

	public void setRoadidS(String roadidS) {
		this.roadidS = roadidS;
	}

	@Column(name = "STATE_I", precision = 3, scale = 0)
	public short getStateI() {
		return this.stateI;
	}

	public void setStateI(short stateI) {
		this.stateI = stateI;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATEDATE_T", nullable = false, length = 7)
	public Date getCreatedateT() {
		return this.createdateT;
	}

	public void setCreatedateT(Date createdateT) {
		this.createdateT = createdateT;
	}

	@Column(name = "CREATEUSER_S", nullable = false, length = 80)
	public String getCreateuserS() {
		return this.createuserS;
	}

	public void setCreateuserS(String createuserS) {
		this.createuserS = createuserS;
	}

	@Column(name = "LASTUPDATEUSER_S", length = 80)
	public String getLastupdateuserS() {
		return this.lastupdateuserS;
	}

	public void setLastupdateuserS(String lastupdateuserS) {
		this.lastupdateuserS = lastupdateuserS;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "LASTUPDATEDATE_T", length = 7)
	public Date getLastupdatedateT() {
		return this.lastupdatedateT;
	}

	public void setLastupdatedateT(Date lastupdatedateT) {
		this.lastupdatedateT = lastupdatedateT;
	}

	@Column(name = "RESAVEDS1_S", length = 80)
	public String getResaveds1S() {
		return this.resaveds1S;
	}

	public void setResaveds1S(String resaveds1S) {
		this.resaveds1S = resaveds1S;
	}

	@Column(name = "RESAVEDS2_S", length = 80)
	public String getResaveds2S() {
		return this.resaveds2S;
	}

	public void setResaveds2S(String resaveds2S) {
		this.resaveds2S = resaveds2S;
	}

	@Column(name = "RESAVEDS3_S", length = 80)
	public String getResaveds3S() {
		return this.resaveds3S;
	}

	public void setResaveds3S(String resaveds3S) {
		this.resaveds3S = resaveds3S;
	}

	@Column(name = "RESAVEDS4_S", length = 80)
	public String getResaveds4S() {
		return this.resaveds4S;
	}

	public void setResaveds4S(String resaveds4S) {
		this.resaveds4S = resaveds4S;
	}

	@Column(name = "RESAVEDS5_S", length = 80)
	public String getResaveds5S() {
		return this.resaveds5S;
	}

	public void setResaveds5S(String resaveds5S) {
		this.resaveds5S = resaveds5S;
	}

}