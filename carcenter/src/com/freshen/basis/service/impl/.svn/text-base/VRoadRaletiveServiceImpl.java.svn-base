package com.freshen.basis.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.IvroadRaletiveService;
import com.freshen.entity.basis.Driver;
import com.freshen.entity.basis.VRoadRaletive;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;

public class VRoadRaletiveServiceImpl implements IvroadRaletiveService {

	String roadid;
	//Session session = HibernateUtil.getSession();
	Transaction tx = null;
	public ArrayList<VRoadRaletive> getBasisVRoadRaletiveInfo(
			VRoadRaletive vRoadRaletive,Session session) throws Exception {
		
		try{
			List<VRoadRaletive> list = new ArrayList();
			
			if(vRoadRaletive == null){
				Query query=session.createQuery(" from VRoadRaletive as vRoadRaletive ");
			    list = query.list();	  			
				return (ArrayList) list;
			}
			else
			{
				if(!vRoadRaletive.getRoadid().trim().equals(""))
				{
					String hql = " from VRoadRaletive as vRoadRaletive where 1=1 ";
				    String condition = " and vRoadRaletive.roadid like '%" +vRoadRaletive.getRoadid().trim() + "%'" ;
				    Query query = session.createQuery(hql+condition);
					list = query.list();
			    	return (ArrayList) list;
				}
			}
					
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			//session.clear();
		}	
		return null;
	}

}
