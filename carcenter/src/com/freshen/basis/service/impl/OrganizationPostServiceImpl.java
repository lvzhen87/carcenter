package com.freshen.basis.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.IorganizationDeptService;
import com.freshen.basis.service.IorganizationPostService;
import com.freshen.entity.Customer;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.OrganizationDept;
import com.freshen.entity.basis.OrganizationPost;
import com.freshen.hibernate.HibernateSessionFactory;
import com.freshen.util.BasicTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DynamicBinding;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;
import com.freshen.util.StringTools;

public class OrganizationPostServiceImpl extends ClimsServiceBase implements IorganizationPostService{

	String organizationPost_s, postName_s, createUser_s, lastUpdateUser_s;
	Date createDate_t, lastUpdateDate_t;
	String resaveds1_s, resaveds2_s, resaveds3_s, resaveds4_s, resaveds5_s;
	String deptID_s;//所属部门
	String superior_s;//上级编号
	String limitpage;//权限页
	
	public List<OrganizationPost> getOrganizationPost(OrganizationPost organizationPost,int start ,int size) throws Exception {
		//if(organizationPost==null)return null;
		List<OrganizationPost> organizationPostList =null;
		Session session =null;
		try {
			setPro(organizationPost);
			String hql="from OrganizationPost as em where 1=1";
			StringBuffer buf =new StringBuffer();
			if(organizationPost_s!=null&&organizationPost_s.trim().length()>0){
				buf.append(" and em.organizationPost_s='"+organizationPost_s+"'");
			}
			if(postName_s!=null&&postName_s.trim().length()>0){
				buf.append(" and em.postName_s='"+postName_s+"'");
			}
			if(deptID_s!=null&&deptID_s.trim().length()>0){
				buf.append(" and em.deptID_s = '"+deptID_s+"'");
			}
			if(superior_s!=null&&superior_s.trim().length()>0){
				buf.append(" and em.superior_s = '"+superior_s+"'");
			}
			if(limitpage !=null && limitpage.trim().length() >0){
				buf.append(" and em.limitpage_s like '%"+limitpage+"%'");
			}
			session =HibernateSessionFactory.getSession();

			Query query=session.createQuery(hql+buf.toString());
			if(start!=ConstantUtil.pagingNot){
			    query.setFirstResult(start);
			    query.setMaxResults(size);
		    }
			organizationPostList=query.list();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;		
		}finally{
	//		close(session);
		}
		
		return organizationPostList;
	}
	
	/**
	 * 在事务中操作组织架构岗位表
	 * OperationOrganizationPostbyTransaction 
	 * @param   OrganizationPost  修改的对象  
	 * session 上下文  
	 * operation 操作 1：新增或修改 2：删除 3：根据id增加下级
	 * @param  @return   如果是修改下级序号+1，将当前下级序号返回
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public String OperationOrganizationPostbyTransaction(OrganizationPost organizationPost, Session session,int operation)
	throws Exception {
		// TODO Auto-generated method stub	
		String subordinateSeqS = "";
		OrganizationPost tmp = new OrganizationPost();
		try{		  
			//新增
			if(operation==1){
				if(organizationPost!=null&&organizationPost.isnotNull(organizationPost)){
					tmp = (OrganizationPost)session.get(tmp.getClass(), organizationPost.getOrganizationPost_s());
					if(tmp != null )
					{
						//session.saveOrUpdate(organizationPost);
						DynamicBinding d = new DynamicBinding();
						tmp = d.MakeDynamicBindingData(OrganizationPost.class,organizationPost, tmp);
						session.merge(tmp);
					}
					else
					{
						session.merge(organizationPost);
					}
					session.flush();
				    session.clear();
				}
			}
			//删除
			if(operation==2){
				if(organizationPost!=null&&organizationPost.isnotNull(organizationPost)){
					session.delete(organizationPost);
					session.flush();
					session.clear();
				}
			}
			//增加对象下级序号下一个值
			if(operation==3){				
				List<OrganizationPost> list = getOrganizationPost(organizationPost, 0, 1);
				if(BasicTools.isnotNull(list)){
					organizationPost = list.get(0);
					subordinateSeqS = organizationPost.getSubordinateNextSeq_s();
					String subordinateNextSeqS = (Integer.valueOf(subordinateSeqS)+1)+"";
					subordinateNextSeqS = StringTools.fillString(subordinateNextSeqS, "0", 2);
					organizationPost.setSubordinateNextSeq_s(subordinateNextSeqS);
					session.saveOrUpdate(organizationPost);
				}
			}
			return subordinateSeqS;
		}catch(Exception e){
			throw e;
		}finally{				
		}	
	}
	/**
	 * 操作组织架构岗位表
	 * OperationOrganizationDept 
	 * @param   organizationDept  修改的对象  
	 * session 上下文  
	 * operation 操作 1：新增或修改 2：删除 3：根据id增加下级
	 * @param  @return    如果是修改下级序号+1，将当前下级序号返回
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public String OperationOrganizationDept(OrganizationPost organizationPost,int operation)
	throws Exception {
		Transaction tx = null;
		try{
			Session session = HibernateUtil.getSession();
			if(!session.isOpen()){
				session = HibernateUtil.getSession();
			}
			tx = session.beginTransaction();
			String subordinateNextSeqS = this.OperationOrganizationPostbyTransaction(organizationPost, session, operation);
			tx.commit();
			return subordinateNextSeqS;
		}catch(Exception e){
			try{
				if(tx!=null){
					tx.rollback();
				}
			}catch(Exception e1){
				throw e1;
			}
			throw e;
		}finally{				
		}	
	}
	public void setPro(OrganizationPost organizationPost){
		if(organizationPost!=null){
			this.organizationPost_s = organizationPost.getOrganizationPost_s();
			this.deptID_s = organizationPost.getDeptID_s();
			this.postName_s = organizationPost.getPostName_s();
			this.superior_s = organizationPost.getSuperior_s();
			this.limitpage=organizationPost.getLimitpage_s();
		}
		
	}
}
