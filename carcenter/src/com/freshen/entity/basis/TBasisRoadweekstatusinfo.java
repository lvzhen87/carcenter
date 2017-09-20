package com.freshen.entity.basis;

import java.util.Date;


/**
 * TBasisRoadweekstatusinfo entity. @author MyEclipse Persistence Tools
 */
public class TBasisRoadweekstatusinfo extends AbstractTBasisRoadweekstatusinfo implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public TBasisRoadweekstatusinfo() {
    }

	/** minimal constructor */
    public TBasisRoadweekstatusinfo(String roadidS) {
        super(roadidS);        
    }
    
    /** full constructor */
    public TBasisRoadweekstatusinfo(String roadidS, String weekstatusS, Date createdateT, String createuserS, String lastupdateuserS, Date lastupdatedateT, String resaveds1S, String resaveds2S, String resaveds3S, String resaveds4S, String resaveds5S) {
        super(roadidS, weekstatusS, createdateT, createuserS, lastupdateuserS, lastupdatedateT, resaveds1S, resaveds2S, resaveds3S, resaveds4S, resaveds5S);        
    }
   
}
