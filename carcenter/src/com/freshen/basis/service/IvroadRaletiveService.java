package com.freshen.basis.service;

import java.util.ArrayList;

import org.hibernate.Session;

import com.freshen.entity.basis.VRoadRaletive;


public interface IvroadRaletiveService {

	/**
	 * 通过条件查询驾驶员信息表
	   
	 * getBasisDriverInfo 
	 * @param   name    
	 * @param  @return    List    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　
	 */
	public ArrayList<VRoadRaletive> getBasisVRoadRaletiveInfo(VRoadRaletive vRoadRaletive,Session session) throws Exception;
	
}
