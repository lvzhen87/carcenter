package com.freshen.basis.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.IorganizationDeptService;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.OrganizationDept;
import com.freshen.hibernate.HibernateSessionFactory;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.BasicTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DataResource;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;
import com.freshen.util.StringTools;

 
public class OrganizationDeptServiceImpl extends ClimsServiceBase implements IorganizationDeptService{

	String organizationDept_s, deptName_s, createUser_s, lastUpdateUser_s;
	Date createDate_t, lastUpdateDate_t;
	String resaveds1_s, resaveds2_s, resaveds3_s, resaveds4_s, resaveds5_s;
	String superior_s;//上级编号
	
	public List<OrganizationDept> getOrganizationDept(OrganizationDept organizationDept,int start ,int size) throws Exception {
		 
		List<OrganizationDept> organizationDeptList =null;
		Session session = HibernateUtil.getSession();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}		
		try {
			if(organizationDept!=null){
				setPro(organizationDept);
			}
			//主键查询
			if(organizationDept_s!=null){
				organizationDept = (OrganizationDept)session.get(OrganizationDept.class, organizationDept_s);
				organizationDeptList = new ArrayList();
				organizationDeptList.add(organizationDept);
				return organizationDeptList;
			}
			String hql="from OrganizationDept as em where 1=1 and em.resaveds2_s = 0 ";
			StringBuffer buf =new StringBuffer();
			if(organizationDept_s!=null&&organizationDept_s.trim().length()>0){
				buf.append(" and em.organizationDept_s='"+organizationDept_s+"'");
			}
			if(deptName_s!=null&&deptName_s.trim().length()>0){
				buf.append(" and em.deptName_s like '%"+deptName_s+"%'");
			}
			if(superior_s!=null&&superior_s.trim().length()>1){
				buf.append(" and em.superior_s = '"+superior_s+"'");
			}
			if(resaveds1_s!=null&&resaveds1_s.equals("null")){
				buf.append(" and em.resaveds1_s is null");
			}else if(resaveds1_s!=null&&resaveds1_s.trim().length()>1){
				buf.append(" and em.resaveds1_s = '"+resaveds1_s+"'");
			}
			if(resaveds2_s!=null&&resaveds2_s.trim().length()>1){
				buf.append(" and em.resaveds2_s = '"+resaveds2_s+"'");
			}
			if(resaveds3_s!=null&&resaveds3_s.trim().length()>1){
				buf.append(" and em.resaveds3_s = '"+resaveds3_s+"'");
			}
			session =HibernateSessionFactory.getSession();

			Query query=session.createQuery(hql+buf.toString());
			if(start!=ConstantUtil.pagingNot){
			    query.setFirstResult(start);
			    query.setMaxResults(size);
		    }
			organizationDeptList=query.list();
			session.flush();
			session.clear();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;		
		}finally{
	//		close(session);
			session.clear();
		}
		return organizationDeptList;
	}
	
	/**
	 * 在事务中操作组织架构部门表
	 * OperationOrganizationDept 
	 * @param   organizationDept  修改的对象  
	 * session 上下文  
	 * operation 操作 1：新增或修改 2：删除   3：根据id，下级序号+1
	 * @param  @return    如果是修改下级序号+1，将当前下级序号返回
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public OrganizationDept OperationOrganizationDeptbyTransaction(OrganizationDept organizationDept, Session session,int operation)
	throws Exception {
		// TODO Auto-generated method stub		 
		String subordinateSeqS = "";
		try{		  
			//新增
			if(operation==1){
				if(organizationDept!=null&&organizationDept.isnotNull(organizationDept)){
					if(organizationDept.getCreateDate_t()==null){
						organizationDept.setCreateDate_t(new Date());
					}
					session.merge(organizationDept);
					session.flush();
			//	    session.clear();
				}
			}
			//删除
			if(operation==2){
				if(organizationDept!=null&&organizationDept.isnotNull(organizationDept)){
					session.delete(organizationDept);
					session.flush();
			//		session.clear();
				}
			}
			//增加对象下级序号下一个值
			if(operation==3){				
				List<OrganizationDept> list = getOrganizationDept(organizationDept, ConstantUtil.pagingNot, 1);
				if(BasicTools.isnotNull(list)){
					organizationDept = list.get(0);
					subordinateSeqS = organizationDept.getSubordinateNextSeq_s();
					String subordinateNextSeqS = (Integer.valueOf(subordinateSeqS)+1)+"";
					subordinateNextSeqS = StringTools.fillString(subordinateNextSeqS, "0", 2);
					organizationDept.setSubordinateNextSeq_s(subordinateNextSeqS);
					session.saveOrUpdate(organizationDept);
					session.flush();
		//			session.clear();
				}
			}
			return organizationDept;
		}catch(Exception e){
			throw e;
		}finally{				
		}	
	}
	/**
	 * 操作组织架构部门表
	 * OperationOrganizationDept 
	 * @param   organizationDept  修改的对象  
	 * session 上下文  
	 * operation 操作 1：新增或修改 2：删除 3：根据id增加下级
	 * @param  @return     如果是修改下级序号+1，将当前下级序号返回
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public OrganizationDept OperationOrganizationDept(OrganizationDept organizationDept,int operation)
	throws Exception {
		Transaction tx = null;
		String subordinateNextSeqS = "";
		try{
			Session session = HibernateUtil.getSession();
			if(!session.isOpen()){
				session = HibernateUtil.getSession();
			}			
			tx = session.beginTransaction();
			organizationDept  = this.OperationOrganizationDeptbyTransaction(organizationDept, session, operation);
			tx.commit();
			return organizationDept;
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
	public void setPro(OrganizationDept organizationDept){
		this.organizationDept_s = organizationDept.getOrganizationDept_s();
		this.superior_s = organizationDept.getSuperior_s();
		this.deptName_s = organizationDept.getDeptName_s();	 
		this.resaveds1_s = organizationDept.getResaveds1_s();
		this.resaveds2_s = organizationDept.getResaveds2_s();		
		this.resaveds3_s = organizationDept.getResaveds3_s();
	}
	
	
	
	/**
	 * 获得一卡通部门信息集合	   
	 * getOneCardpbDepart 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<OrganizationDept> getOneCardpbDepart() throws Exception{
		List<OrganizationDept> organizationDepts = new ArrayList();
		Connection sqlcon = DataResource.getConnect(ConstantUtil.OneCardSERVERCONN);
		PreparedStatement prest = null;
		try{
			String sql = "select Dptid,Dptparent,Dptname,IsDeleted from pb_depart order by Dptid";
			prest = sqlcon.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = prest.executeQuery();
			OrganizationDept tmp = null;
			while (rs.next()) {
				tmp = new OrganizationDept();
				tmp.setOrganizationDept_s(rs.getString("Dptid"));
				tmp.setSuperior_s(rs.getString("Dptparent"));
				tmp.setDeptName_s(rs.getString("Dptname"));
				tmp.setResaveds2_s(rs.getString("IsDeleted"));
				tmp.setSubordinateNextSeq_s("01");
				organizationDepts.add(tmp);
			}
		}catch(Exception e){
			sqlcon.close();
			throw e;
		}
		return organizationDepts;
	}
	
	/**
	 * 同步部门	   
	 * synchronizationDept 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void synchronizationDept()throws Exception{
		Transaction tx = null;
		Session session = HibernateUtil.getSession();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}			
		try {
			
			//获得一卡通的部门信息
			List<OrganizationDept> list = this.getOneCardpbDepart();
			if(list!=null&&list.size()>0){
				for(int i=0;i<list.size();i++){
					tx = session.beginTransaction();
					OrganizationDept tmp = list.get(i);
					//用一卡通部门id查询当前部门是否存在
					List<OrganizationDept> l = getOrganizationDept(tmp,ConstantUtil.pagingNot,0);
					//该部门已经存在
					if(BasicTools.isnotNull(l)){
						OrganizationDept oldtmp = l.get(0);//之前部门信息
						if(superior_s.equals("0")){//根节点
							tmp.setSuperior_s("");
							tmp.setSubordinateNextSeq_s(oldtmp.getSubordinateNextSeq_s());
							this.OperationOrganizationDeptbyTransaction(tmp, session, 1);
							tx.commit();
							continue;
						}
						//如果父部门与之前不同并不为根节点,需要给新的父部门的下级序号+1
						if(oldtmp.getSuperior_s()!=null&&!oldtmp.getSuperior_s().equals(tmp.getSuperior_s())){
							String superior_s = tmp.getSuperior_s();
							
							OrganizationDept supOrganizationDept = new OrganizationDept();
							supOrganizationDept.setOrganizationDept_s(superior_s);
							//给父节点下级序号加一，并获得新的序号
							supOrganizationDept = this.OperationOrganizationDeptbyTransaction(supOrganizationDept, session, 3);
							tmp.setSuperior_s(supOrganizationDept.getSubordinateNextSeq_s());
							if(supOrganizationDept.getResaveds1_s()==null||"".equals(supOrganizationDept.getResaveds1_s())){
								tmp.setResaveds1_s(ConstantUtil.organizationDept+superior_s+supOrganizationDept.getSubordinateNextSeq_s());
							}else{
								tmp.setResaveds1_s(ConstantUtil.organizationDept+supOrganizationDept.getResaveds1_s()+(Integer.valueOf(supOrganizationDept.getSubordinateNextSeq_s())-1));
							}
							tmp.setSubordinateNextSeq_s(oldtmp.getSubordinateNextSeq_s());
						}else{
							tmp.setResaveds1_s(oldtmp.getResaveds1_s());							
							tmp.setSuperior_s(oldtmp.getSuperior_s());
							tmp.setSubordinateNextSeq_s(oldtmp.getSubordinateNextSeq_s());
						}
					}else{//部门不存在
						//查询父部门
						String superior_s = tmp.getSuperior_s();//父部门id
						if(superior_s.equals("0")){//根节点
							tmp.setSuperior_s("");
						}
						OrganizationDept superiorOrganizationDept = new OrganizationDept();
						superiorOrganizationDept.setOrganizationDept_s(superior_s);
						List<OrganizationDept> superiorDept = getOrganizationDept(superiorOrganizationDept,ConstantUtil.pagingNot,0);
						//给父节点下级序号加一，并获得新的序号
						if(BasicTools.isnotNull(superiorDept)){
							superiorOrganizationDept = this.OperationOrganizationDeptbyTransaction(superiorDept.get(0), session, 3);
							if(superiorOrganizationDept.getResaveds1_s()==null||"".equals(superiorOrganizationDept.getResaveds1_s())){
								tmp.setResaveds1_s(ConstantUtil.organizationDept+superior_s+superiorOrganizationDept.getSubordinateNextSeq_s());
							}else{
								tmp.setResaveds1_s(ConstantUtil.organizationDept+superiorOrganizationDept.getResaveds1_s()+(Integer.valueOf(superiorOrganizationDept.getSubordinateNextSeq_s())-1));
							}
						}
						tmp.setSubordinateNextSeq_s(ConstantUtil.organizationStart);//设置下级序号的起始值
					}
					//保存本部门信息
					this.OperationOrganizationDeptbyTransaction(tmp, session, 1);
					tx.commit();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw e;
		}
	}
	public static void main(String[] a){
		
	//	organizationDept.setOrganizationDept_s("BM001");
		IorganizationDeptService iorganizationDeptService = new OrganizationDeptServiceImpl();
		try {
			 OrganizationDept organizationDept = new OrganizationDept();
			 organizationDept.setResaveds1_s("null");
			 List l = iorganizationDeptService.getOrganizationDept(organizationDept, ConstantUtil.pagingNot, 0);
			//System.out.println(l.get(0).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
