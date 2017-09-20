package com.freshen.system.service;

import org.hibernate.Session;

public interface IsystemSequenceService {

	/**
	 * 获得指定表标识的主键	   
	 * getPK 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public String getPK(String business_s,Session session);
	
	 
}
