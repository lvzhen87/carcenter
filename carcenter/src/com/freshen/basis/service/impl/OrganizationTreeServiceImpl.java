package com.freshen.basis.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.IemployeeService;
import com.freshen.basis.service.IorganizationDeptService;
import com.freshen.basis.service.IorganizationPostService;
import com.freshen.basis.service.IorganizationTreeService;
import com.freshen.clims.baseclass.BeanModel;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.OrganizationDept;
import com.freshen.entity.basis.OrganizationPost;
import com.freshen.entity.basis.OrganizationTree;
import com.freshen.hibernate.HibernateSessionFactory;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.BasicTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

/**
 * 组织架构树操作
 *     
 * 项目名称：carcenter    
 * 类名称：OrganizationTreeServiceImpl    
 * 类描述：    
 * 创建人：kxc    
 * 创建时间：2014-6-23 上午11:26:27    
 * 修改人：kxc    
 * 修改时间：2014-6-23 上午11:26:27    
 * 修改备注：    
 * @version     
 *
 */
public class OrganizationTreeServiceImpl extends ClimsServiceBase implements IorganizationTreeService{

	String organization_s, name_s, createUser_s, lastUpdateUser_s;
	Date createDate_t, lastUpdateDate_t;
	String resaveds1_s, resaveds2_s, resaveds3_s, resaveds4_s, resaveds5_s;
	String superior_s;//上级编号 部门上级为部门或根节点编号 岗位上级为部门编号 员工上级为岗位编号
	Integer type_i;//1:部门 2：岗位 3：员工
	Integer superiorType_i;//上级节点的类型1:部门 2：岗位 3：员工  4根结点
	//以下为员工信息
	//员工的部门
	String organizationDept_s;
	String customerUserName_s;
	String identityCard_s;
	String telephone_s, facsimile_s,email_s;
	
	/**
	 * 根据上级编号和上级类型查询它的下一级对象
	 * getOrganizationNodebySuperior 
	 * @param   superior_s 上级编号
	 *     		superiorType_i 上级类型
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<OrganizationTree> getOrganizationNodebySuperior(String superior_s,Integer superiorType_i) throws Exception {
		
		List<OrganizationTree> organizationTreeList = new ArrayList();	
		IorganizationDeptService iorganizationDeptService = new OrganizationDeptServiceImpl();
		IorganizationPostService iorganizationPostService = new OrganizationPostServiceImpl();
		IemployeeService iemployeeService = new EmployeeServiceImpl();
		try {
			//根节点
			if(superior_s==null||superior_s.equals("")){
				OrganizationDept organizationDept = new OrganizationDept();
				organizationDept.setOrganizationDept_s(ConstantUtil.organizationDept+ConstantUtil.organizationRoot);
				List<OrganizationDept> deptlist = iorganizationDeptService.getOrganizationDept(organizationDept, 0, 1);
				if(BasicTools.isnotNull(deptlist)){
					for(int i=0;i<deptlist.size();i++){
						OrganizationTree organizationTree = new OrganizationTree();
						organizationTree.setpro(deptlist.get(i));
						organizationTreeList.add(organizationTree);
					}
				}
				return organizationTreeList;
			}
			//获得部门的下属部门
			OrganizationDept organizationDept = new OrganizationDept();
			organizationDept.setSuperior_s(superior_s);
			List<OrganizationDept> deptlist = iorganizationDeptService.getOrganizationDept(organizationDept, 0, 1);
			
			//获得部门下所有岗位
			OrganizationPost organizationPost = new OrganizationPost();
			organizationPost.setSuperior_s(superior_s);
			List<OrganizationPost> postlist = iorganizationPostService.getOrganizationPost(organizationPost, 0, 1);
			
			//获得岗位下所有职位
			Employee ep = new Employee();
			ep.setOrganizationPost_s(superior_s);
			List<Employee> employeelist = iemployeeService.getEmployees(ep, 0, 1);

			if(BasicTools.isnotNull(deptlist)){
				for(int i=0;i<deptlist.size();i++){
					OrganizationTree organizationTree = new OrganizationTree();
					organizationTree.setpro(deptlist.get(i));
					organizationTreeList.add(organizationTree);
				}
			}
			if(BasicTools.isnotNull(postlist)){
				for(int i=0;i<postlist.size();i++){
					OrganizationTree organizationTree = new OrganizationTree();
					organizationTree.setpro(postlist.get(i));
					organizationTreeList.add(organizationTree);
				}
			}
			if(BasicTools.isnotNull(employeelist)){
				for(int i=0;i<employeelist.size();i++){
					OrganizationTree organizationTree = new OrganizationTree();
					organizationTree.setpro(employeelist.get(i));
					organizationTreeList.add(organizationTree);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;		
		}finally{
	//		close(session);
		}
		return organizationTreeList;
	}
	
	/**
	 * 获得整个组织架构树对象
	 * getOrganizationNodebySuperior 
	 * @param   superior_s 上级编号
	 *     		superiorType_i 上级类型
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<OrganizationTree> getAllOrganizationNode() throws Exception {
		List<OrganizationTree> organizationTreeList = new ArrayList();
		IorganizationDeptService iorganizationDeptService = new OrganizationDeptServiceImpl();
		IorganizationPostService iorganizationPostService = new OrganizationPostServiceImpl();
		IemployeeService iemployeeService = new EmployeeServiceImpl();
		try {
			 OrganizationDept organizationDept = new OrganizationDept();
			// organizationDept.setOrganizationDept_s(ConstantUtil.organizationDept+ConstantUtil.organizationRoot);
			 //包含所有部门信息
			 List<OrganizationDept> deptlist = iorganizationDeptService.getOrganizationDept(organizationDept, ConstantUtil.pagingNot, 1);
			 if(BasicTools.isnotNull(deptlist)){
			 	 for(int i=0;i<deptlist.size();i++){
					 OrganizationTree organizationTree = new OrganizationTree();
					 organizationTree.setpro(deptlist.get(i));
					 organizationTreeList.add(organizationTree);
				 }
			 }
			 //包含所有岗位信息
			 OrganizationPost organizationPost = new OrganizationPost();
			 List<OrganizationPost> postlist = iorganizationPostService.getOrganizationPost(organizationPost, ConstantUtil.pagingNot, 1);
			 if(BasicTools.isnotNull(postlist)){
			 	 for(int i=0;i<postlist.size();i++){
					 OrganizationTree organizationTree = new OrganizationTree();
					 organizationTree.setpro(postlist.get(i));
					 organizationTreeList.add(organizationTree);
				 }
			 }
			//包含所有职员信息
			 Employee employee = new Employee();
			 List<Employee> employeelist = iemployeeService.getEmployees(employee, ConstantUtil.pagingNot, 1);
			 if(BasicTools.isnotNull(employeelist)){
			 	 for(int i=0;i<employeelist.size();i++){
					 OrganizationTree organizationTree = new OrganizationTree();
					 organizationTree.setpro(employeelist.get(i));
					 organizationTreeList.add(organizationTree);
				 }
			 }
			 return organizationTreeList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;		
		}finally{
	//		close(session);
		}
		 
	}
	/**
	 * 操作组织架构树 	   
	 * OperationOrganization 
	 * @param   organizationTree 树对象    一定包含上级编号和上级节点类型
	 * 			operation 操作 1：新增  2：修改 3：删除
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationOrganization(OrganizationTree organizationTree, int operation)
	throws Exception {
		// TODO Auto-generated method stub
		Transaction tx = null;
		
		//操作部门
		IorganizationDeptService iorganizationDeptService = new OrganizationDeptServiceImpl();
		//操作岗位
		IorganizationPostService iorganizationPostService = new OrganizationPostServiceImpl();
		//操职员
		IemployeeService iemployeeService = new EmployeeServiceImpl();
		Session session= HibernateUtil.getSession();
		try{
			if(BeanModel.isnotNull(organizationTree)){				
				setpro(organizationTree);
			}else{
				throw new Exception("不能添加空的组织架构对象");
			}			
			
			if(!session.isOpen()){
				session= HibernateUtil.getSession();							
			}
			tx=session.beginTransaction();//开启事务
			//新增
			if(operation==1){
				String subordinateNextSeqS = ""; //序号
				subordinateNextSeqS = getSubordinateSeq(organizationTree,session);
				if(type_i==ConstantUtil.organizationType_1){//部门
					OrganizationDept organizationDept = new OrganizationDept();
					organizationDept.setProbyorganizationTree(organizationTree);
					//设置对象的 编号=种类代码+上级编号+序号当前值
					organizationDept.setOrganizationDept_s(ConstantUtil.organizationDept+organizationTree.getOrganization_s()+subordinateNextSeqS);
					organizationDept.setSubordinateNextSeq_s(ConstantUtil.organizationStart);//设置下级序号的起始值
					iorganizationDeptService.OperationOrganizationDeptbyTransaction(organizationDept, session, operation);
				}
				if(type_i==ConstantUtil.organizationType_2){//岗位
					OrganizationPost organizationPost = new OrganizationPost();
					organizationPost.setProbyorganizationTree(organizationTree);
					//设置对象的 编号=种类代码+上级编号+序号当前值
					organizationPost.setOrganizationPost_s(ConstantUtil.organizationPost+organizationTree.getOrganization_s()+subordinateNextSeqS);
					organizationPost.setSubordinateNextSeq_s(ConstantUtil.organizationStart);//设置下级序号的起始值
					iorganizationPostService.OperationOrganizationPostbyTransaction(organizationPost, session, operation);
				}
				if(type_i==ConstantUtil.organizationType_3){//职员
					Employee employee = new Employee();
					employee.setProbyorganizationTree(organizationTree);
					//设置对象的 编号=种类代码+上级编号+序号当前值
					employee.setEmployeeID_s(ConstantUtil.organizationEmp+organizationTree.getOrganization_s()+subordinateNextSeqS);
					iemployeeService.OperationEmployeesbyTransaction(employee, session, operation);
					
				}
				session.flush();
			   
			}
			//修改
			if(operation==2){
				if(type_i==ConstantUtil.organizationType_1){//部门
					OrganizationDept organizationDept = new OrganizationDept();
					organizationDept.setProbyorganizationTree(organizationTree);
					iorganizationDeptService.OperationOrganizationDeptbyTransaction(organizationDept, session, 1);
				}
				if(type_i==ConstantUtil.organizationType_2){//岗位
					OrganizationPost organizationPost = new OrganizationPost();
					organizationPost.setProbyorganizationTree(organizationTree);					
					iorganizationPostService.OperationOrganizationPostbyTransaction(organizationPost, session, operation);
				}
				if(type_i==ConstantUtil.organizationType_3){//职员
					Employee employee = new Employee();
					employee.setProbyorganizationTree(organizationTree);					
					iemployeeService.OperationEmployeesbyTransaction(employee, session, operation);
				}
			}
			tx.commit();
			return 1;
		}catch(Exception e){
			tx.rollback();
			throw e;
		}finally{				
			 session.clear();
		}	
	}
	 
	/**
	 * 获得下级序号并修改上级对象的下级序号下一个值
	 * getSubordinateSeq 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	private String getSubordinateSeq(OrganizationTree organizationTree,Session session)throws Exception {
		String subordinateNextSeqS = "";
		//操作部门
		IorganizationDeptService iorganizationDeptService = new OrganizationDeptServiceImpl();
		//操作岗位
		IorganizationPostService iorganizationPostService = new OrganizationPostServiceImpl();
		try{
			if(superiorType_i==ConstantUtil.organizationType_4){//上级根节点
				OrganizationDept organizationDept = new OrganizationDept();
				organizationDept.setOrganizationDept_s(organizationTree.getSuperior_s());
				organizationDept = iorganizationDeptService.OperationOrganizationDeptbyTransaction(organizationDept, session, 3);
				subordinateNextSeqS = organizationDept.getSubordinateNextSeq_s();
			}
			if(superiorType_i==ConstantUtil.organizationType_1){//上级为部门
				OrganizationDept organizationDept = new OrganizationDept();
				organizationDept.setOrganizationDept_s(organizationTree.getSuperior_s());
				organizationDept = iorganizationDeptService.OperationOrganizationDeptbyTransaction(organizationDept, session, 3);
				subordinateNextSeqS = organizationDept.getSubordinateNextSeq_s();
			}
			if(superiorType_i==ConstantUtil.organizationType_2&&type_i==ConstantUtil.organizationType_3){//上级为岗位,新增的的也为岗位位
				OrganizationPost organizationPost = new OrganizationPost();
				organizationPost.setOrganizationPost_s(organizationTree.getSuperior_s());
				subordinateNextSeqS = iorganizationPostService.OperationOrganizationPostbyTransaction(organizationPost, session, 3);
			}
		}catch(Exception e){		
			throw e;
		}finally{				
		    			 
		}	
		return subordinateNextSeqS;
	}
	 
	/**
	 * 设置变量	   
	 * setpro 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	private void setpro(OrganizationTree organizationTree){
		organization_s = organizationTree.getOrganization_s();
		name_s = organizationTree.getName_s();
		createUser_s = organizationTree.getCreateUser_s();
		lastUpdateUser_s = organizationTree.getLastUpdateUser_s();
		createDate_t = organizationTree.getCreateDate_t();
		lastUpdateDate_t = organizationTree.getLastUpdateDate_t();
		superior_s = organizationTree.getSuperior_s();
		type_i = organizationTree.getType_i();
		superiorType_i = organizationTree.getSuperiorType_i();
		organizationDept_s = organizationTree.getOrganizationDept_s();
		customerUserName_s = organizationTree.getCustomerUserName_s();
		identityCard_s = organizationTree.getIdentityCard_s();
		telephone_s = organizationTree.getTelephone_s();
		facsimile_s = organizationTree.getFacsimile_s();
		email_s = organizationTree.getEmail_s();
	}

	public String OperationOrganizationReturnNo(
			List<OrganizationTree> organizationTree, int operation) throws Exception {
		// TODO Auto-generated method stub
		Session session= HibernateUtil.getSession();
		Transaction tx = null;
		String ReturnValue = "";
		//操作部门
		IorganizationDeptService iorganizationDeptService = new OrganizationDeptServiceImpl();
		//操作岗位
		IorganizationPostService iorganizationPostService = new OrganizationPostServiceImpl();
		//操职员
		IemployeeService iemployeeService = new EmployeeServiceImpl();
		try{			
			if(!session.isOpen()){
				session= HibernateUtil.getSession();							
			}			
			tx=session.beginTransaction();//开启事务
			for (int i = 0; i < organizationTree.size(); i++) {
				if(BeanModel.isnotNull(organizationTree.get(i))){				
					setpro(organizationTree.get(i));
				}else{
					throw new Exception("不能添加空的组织架构对象");
				}
				OrganizationDept organizationDept = new OrganizationDept();
				OrganizationPost organizationPost = new OrganizationPost();
				Employee employee = new Employee();
				//新增
				if(operation==1){
					String subordinateNextSeqS = ""; //序号
					subordinateNextSeqS = getSubordinateSeq(organizationTree.get(i),session);
					if(type_i==ConstantUtil.organizationType_1){//部门
						organizationDept.setProbyorganizationTree(organizationTree.get(i));
						//设置对象的 编号=种类代码+上级编号+序号当前值
						organizationDept.setOrganizationDept_s(ConstantUtil.organizationDept+organizationTree.get(i).getSuperior_s()+subordinateNextSeqS);
						organizationDept.setSubordinateNextSeq_s(ConstantUtil.organizationStart);//设置下级序号的起始值
						ReturnValue= organizationDept.getOrganizationDept_s().toString();
						iorganizationDeptService.OperationOrganizationDeptbyTransaction(organizationDept, session, operation);
					}
					if(type_i==ConstantUtil.organizationType_2){//岗位
						organizationPost.setProbyorganizationTree(organizationTree.get(i));
						//设置对象的 编号=种类代码+上级编号+序号当前值
						organizationPost.setDeptID_s(organizationPost.getSuperior_s());
						organizationPost.setOrganizationPost_s(ConstantUtil.organizationPost+organizationTree.get(i).getSuperior_s()+subordinateNextSeqS);
						organizationPost.setSubordinateNextSeq_s(ConstantUtil.organizationStart);//设置下级序号的起始值
						iorganizationPostService.OperationOrganizationPostbyTransaction(organizationPost, session, operation);
						ReturnValue= organizationPost.getOrganizationPost_s().toString();
					}
					if(type_i==ConstantUtil.organizationType_3){//职员
						employee.setProbyorganizationTree(organizationTree.get(i));
						//employee.setOrganizationDept_s(((OrganizationPost)session.get(organizationPost.getClass(),organizationTree.getSuperior_s())).getDeptID_s());
						//设置对象的 编号=种类代码+上级编号+序号当前值
						//employee.setEmployeeID_s(ConstantUtil.organizationEmp+organizationTree.get(i).getSuperior_s()+subordinateNextSeqS);
						//iemployeeService.OperationEmployeesbyTransaction(employee, session, operation);
						iemployeeService.OperationEmployeesold(employee, operation);
						ReturnValue= employee.getEmployeeID_s().toString();
					}
				}
				session.flush();			  
			//修改
			if(operation==2){
				if(type_i==ConstantUtil.organizationType_1){//部门
					OrganizationDept dept = (OrganizationDept)session.get(OrganizationDept.class,organizationTree.get(i).getOrganization_s());
					if(dept!= null)
					{
						dept.setDeptName_s(organizationTree.get(i).getName_s());
						session.clear();
						iorganizationDeptService.OperationOrganizationDeptbyTransaction(dept, session, 1);
						ReturnValue = "SUCCESS";
					}
				}
				if(type_i==ConstantUtil.organizationType_2){//岗位
					OrganizationPost post = (OrganizationPost)session.get(organizationPost.getClass(), organizationTree.get(i).getOrganization_s());
					if(post!= null)
					{
						post.setPostName_s(organizationTree.get(i).getName_s());				
						session.clear();
						iorganizationPostService.OperationOrganizationPostbyTransaction(post, session, 1);
						ReturnValue = "SUCCESS";
					}
				}
				if(type_i==ConstantUtil.organizationType_3){//职员
					Employee emp = (Employee)session.get(Employee.class,organizationTree.get(i).getOrganization_s());
					if(emp != null)
					{
						//emp.setCustomerUserName_s(organizationTree.get(i).getName_s());	
						emp.setOrganizationDept_s(null);
						emp.setOrganizationPost_s(null);
						session.clear();
						iemployeeService.OperationEmployeesbyTransaction(emp, session, 1);
						ReturnValue = "SUCCESS";
					}					
				}
			}
			//删除
			if(operation==3){
				if(type_i==ConstantUtil.organizationType_1){//部门
					organizationDept.setProbyorganizationTree(organizationTree.get(i));
					iorganizationDeptService.OperationOrganizationDeptbyTransaction(organizationDept, session,2);
					ReturnValue = "SUCCESS";
				}
				if(type_i==ConstantUtil.organizationType_2){//岗位
					organizationPost.setProbyorganizationTree(organizationTree.get(i));					
					iorganizationPostService.OperationOrganizationPostbyTransaction(organizationPost, session,2);
					Employee emp  = new Employee();
					emp.setOrganizationPost_s(organizationTree.get(i).getOrganization_s());
					List<Employee> list = new ArrayList<Employee>();					
					list =iemployeeService.getEmployees(emp, -1, 0);
					if(list.size()>0&& list != null){
						for(int j  = 0;j<list.size();j++){
							emp = list.get(j);
							if(emp != null)
							{
								//emp.setCustomerUserName_s(organizationTree.get(i).getName_s());	
								//emp.setOrganizationDept_s(null);
								emp.setOrganizationPost_s(null);
								session.clear();
								iemployeeService.OperationEmployeesbyTransaction(emp, session, 1);
								ReturnValue = "SUCCESS";
							}
						}					
					}					
					ReturnValue = "SUCCESS";
				}
				if(type_i==ConstantUtil.organizationType_3){//职员
//					employee.setProbyorganizationTree(organizationTree.get(i));					
//					iemployeeService.OperationEmployeesbyTransaction(employee, session, 2);
//					ReturnValue = "SUCCESS";
					//emp.setCustomerUserName_s(organizationTree.get(i).getName_s());	
					Employee emp = (Employee)session.get(Employee.class,organizationTree.get(i).getOrganization_s());
					if(emp != null)
					{
						//emp.setCustomerUserName_s(organizationTree.get(i).getName_s());	
						//emp.setOrganizationDept_s(null);
						emp.setOrganizationPost_s(null);
						session.clear();
						iemployeeService.OperationEmployeesbyTransaction(emp, session, 1);
						ReturnValue = "SUCCESS";
					}
				}
			}
		}
			tx.commit();
		}catch(Exception e){
			tx.rollback();
			throw e;
		}finally{				
			session.clear();
			return ReturnValue; 
		}	
	}
}
