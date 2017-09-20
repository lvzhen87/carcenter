package com.freshen.basis.service;

import com.freshen.entity.basis.ViewOrganization;

public interface IViewOrganizationService {
	/**
	 * 在视图中查询 是否包含在订单中的 成员   如果包含 不可以删除  返回FALSE  
	 * 如果可以删除 返回TRUE
	 * @param iewOrganization
	 * @return
	 * @throws Exception
	 */
	public boolean getIsVisible(ViewOrganization viewOrganization) throws Exception;
}
