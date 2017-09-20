package com.freshen.basis.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.VCustomeuser;

public interface IemployeeService {

	
	
	/**
	 *  Function:根据登录名查找 Employee实体
	 *  @author Freshen  DateTime 2014-4-17 上午10:43:18
	 *  @param ep 还有EmployeeID属性的对象
	 *  @return 完整的Employee对象
	 * @throws Exception 
	 */
	public boolean isLoginNamehere(String loginname) throws Exception;
	/**
	 *  Function:根据ID查找 Employee实体
	 *  @author Freshen  DateTime 2014-4-17 上午10:43:18
	 *  @param ep 还有EmployeeID属性的对象
	 *  @return 完整的Employee对象
	 * @throws Exception 
	 */
	public Employee getEmployeeById(Employee ep) throws Exception;
	/**
	 *  Function:查找 Employee实体
	 *  @author Freshen  DateTime 2014-4-17 上午10:43:18
	 *  @param ep Employee对象，如果该对象含有ID属性，则等同于getEmployeeById
	 *  	当organizationPost_s为字符串null查询没有岗位的职员
	 *  @return 
	 */
	public List<Employee> getEmployees(Employee ep,int start ,int size) throws Exception;
	
	/**
	 * 查询 所有 employee数量 
	 * lz
	 * @param ep
	 * @return
	 * @throws Exception
	 */
	public long getEmployeesNumber(Employee ep) throws Exception;
	 
	/**
	 * 在事务中操作职员表
	 * OperationEmployeesbyTransaction 
	 * @param   OrganizationPost  修改的对象  
	 * session 上下文  
	 * operation 操作 1：新增或修改 2：删除
	 * @param  @return   
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationEmployeesbyTransaction(Employee employee, Session session,int operation)
	throws Exception ;
	
	/**
	 * 在事务中操作职员表
	 * OperationEmployeesbyTransaction 
	 * @param   OrganizationPost  修改的对象  
	 * session 上下文  
	 * operation 操作 1：新增或修改 2：删除
	 * @param  @return   
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationEmployees(Employee employee,int operation)
	throws Exception ;
	/**
	 *  Function: 根据登录名 ，查找员工信息
	 *  @author Freshen  DateTime 2014-7-21 下午05:27:00
	 *  @param loginEmployee 已经登录的员工对象，应包含employeeLoginName属性
	 *  @return
	 */
	public Employee getEmployeeByLoginName(Employee loginEmployee);
	
	/**
	 * 在事务中操作职员表
	 * OperationEmployeesbyTransaction 
	 * @param  employ修改的对象  
	 * session 上下文  
	 * operation 操作 1：新增或修改 2：删除
	 * @param  @return   
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public String OperationEmployeesold(Employee employee, int operation)	throws Exception;
	
	
	public void synchronizationEmployee()throws Exception;
	
	/**
	 * 获得客户人员与职工集合
	 * getAllcustomerUserAddEmploee 
	 * @param   cards    卡号
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<VCustomeuser> getAllcustomerUserAddEmploee(String cards) throws Exception;
	
	/**
	 * 增加一卡通进出门卫二信息	   
	 * addMj_Iodata 
	 * @param   cards	   卡号
	 * 			inout    1:进 2：出
	 * @param  @return       
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int addMj_Iodata(String cards,int inout)throws Exception;
}
