package com.freshen.entity.basis;

import java.util.Date;


/**
 * AbstractTBasisRoadweekstatusinfo entity provides the base persistence definition of the TBasisRoadweekstatusinfo entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTBasisRoadweekstatusinfo  implements java.io.Serializable {


    // Fields    

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

     private String roadname;
     private String s1;
     private String s2;
     private String s3;
     private String s4;
     private String s5;
    // Constructors

    /** default constructor */
    public AbstractTBasisRoadweekstatusinfo() {
    }

	/** minimal constructor */
    public AbstractTBasisRoadweekstatusinfo(String roadidS) {
        this.roadidS = roadidS;
    }
    
    /** full constructor */
    public AbstractTBasisRoadweekstatusinfo(String roadidS, String weekstatusS, Date createdateT, String createuserS, String lastupdateuserS, Date lastupdatedateT, String resaveds1S, String resaveds2S, String resaveds3S, String resaveds4S, String resaveds5S) {
        this.roadidS = roadidS;
        this.weekstatusS = weekstatusS;
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

    public String getRoadidS() {
        return this.roadidS;
    }
    
    public void setRoadidS(String roadidS) {
        this.roadidS = roadidS;
    }

    public String getWeekstatusS() {
        return this.weekstatusS;
    }
    
    public void setWeekstatusS(String weekstatusS) {
        this.weekstatusS = weekstatusS;
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

    public String getLastupdateuserS() {
        return this.lastupdateuserS;
    }
    
    public void setLastupdateuserS(String lastupdateuserS) {
        this.lastupdateuserS = lastupdateuserS;
    }

    public Date getLastupdatedateT() {
        return this.lastupdatedateT;
    }
    
    public void setLastupdatedateT(Date lastupdatedateT) {
        this.lastupdatedateT = lastupdatedateT;
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

	public String getS1() {
		return s1;
	}

	public void setS1(String s1) {
		this.s1 = s1;
	}

	public String getS2() {
		return s2;
	}

	public void setS2(String s2) {
		this.s2 = s2;
	}

	public String getS3() {
		return s3;
	}

	public void setS3(String s3) {
		this.s3 = s3;
	}

	public String getS4() {
		return s4;
	}

	public void setS4(String s4) {
		this.s4 = s4;
	}

	public String getS5() {
		return s5;
	}

	public void setS5(String s5) {
		this.s5 = s5;
	}

	public String getRoadname() {
		return roadname;
	}

	public void setRoadname(String roadname) {
		this.roadname = roadname;
	}
 
   








}