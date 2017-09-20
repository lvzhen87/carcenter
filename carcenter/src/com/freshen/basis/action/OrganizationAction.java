package com.freshen.basis.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
import com.freshen.basis.service.IViewOrganizationService;
import com.freshen.basis.service.IemployeeService;
import com.freshen.basis.service.IorganizationDeptService;
import com.freshen.basis.service.IorganizationTreeService;
import com.freshen.basis.service.impl.EmployeeServiceImpl;
import com.freshen.basis.service.impl.OrganizationDeptServiceImpl;
import com.freshen.basis.service.impl.OrganizationTreeServiceImpl;
import com.freshen.basis.service.impl.ViewOrganizationServiceImpl;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.OrganizationDept;
import com.freshen.entity.basis.OrganizationTree;
import com.freshen.entity.basis.ViewOrganization;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;


public class OrganizationAction extends CapgActionSupport{

	private static final long serialVersionUID = 1L;
	
	List<OrganizationTree> otree=new ArrayList<OrganizationTree>();//记录获取到的架构树
	List<TreeJson> treejson=new ArrayList<TreeJson>();//存放转换后的json树
//	String json;
	String Dept_s;//存放从页面传来的人员所属部门的信息
	List<Employee> employeelist=new ArrayList<Employee>();//存放查询出来的人员信息
	String organization_s,name_s,superior_s;
	String emplist;//存放选择的人员id和name
	int type_i,superiorType_i;
	String employeeID_s,organizationPost_s,organizationDept_s,employeeLoginName,customerUserName_s, 
	identityCard_s, telephone_s, facsimile_s,email_s,msgstr;
	
	String organizationDeptName_s;


	int isModify;//标志位，用于判断是否新增或者修改，新增1，修改2
	
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人
	//分页必须
	long totalPages;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	String remsg;
	
	
	public String execute(){
		return SUCCESS;
	}
	
	/**
	 * 读取数据库中的数据，并将实体类转换成easyui tree 可识别的json数据返回给前台用于显示整个树
	 * @author:sharonyshi 2014-7-10
	 * @return
	 */
	public void drawTree(){
		try {
			//获取整个树的所有节点
			IorganizationTreeService its=new OrganizationTreeServiceImpl();
			otree=its.getAllOrganizationNode();
			//String json = JSONArray.fromObject(otree).toString();
			//转换成json格式
			HttpServletResponse response = ServletActionContext.getResponse();
			String json = "";
			if(otree!= null && otree.size()>0)
			{
				json=new Treejson2().jsonformat(otree);
			}
			else
			{
				json= "ERROR";
			}
			//System.out.println(json);
			//设置编码格式
			response.setContentType("text/html;charset=UTF-8"); 
			PrintWriter out = response.getWriter(); 

//			JSONObject jsontest=new JSONObject();  
//			jsontest.accumulate("success", true);  
//			json = jsontest.toString();
	        out.println(json.toString());  
	        out.flush();  
	        out.close();  
//			response.getWriter().write(json);
//            response.getWriter().flush();
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			 
			// TODO: handle exception
		 
		}
	}
	public void CopyData(){
		try {
			IemployeeService ies = new EmployeeServiceImpl();
			ies.synchronizationEmployee();
			IorganizationDeptService iorganizationDeptService = new OrganizationDeptServiceImpl();
			iorganizationDeptService.synchronizationDept();			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	
	}
	public String addNode(){
		try {
			
			//设置树信息
			OrganizationTree ot=new OrganizationTree();
			
			if(isModify==1){
				ot.setName_s(name_s.replace("\r\n", ""));
				ot.setType_i(type_i);
				ot.setSuperior_s(superior_s.replace("\r\n", ""));
				if(superior_s.startsWith("Dept")){
					ot.setSuperior_s(superior_s.replace("\r\n", "").substring(4));
					ot.setSuperiorType_i(1);//如果父节点ID是以BM开头的，说明是部门
				}else if(superior_s.startsWith("Post")){
					ot.setSuperior_s(superior_s.replace("\r\n", "").substring(4));
					ot.setSuperiorType_i(2);//如果父节点ID是以Dept开头的，说明是岗位
				}else if(superior_s.startsWith("Em")){
					ot.setSuperior_s(superior_s.replace("\r\n", "").substring(2));
					ot.setSuperiorType_i(3);//
				}else if(superior_s.startsWith("BM")){
					ot.setSuperior_s(superior_s.replace("\r\n", "").substring(2));
					ot.setSuperiorType_i(4);//
				}
				ot.setCreateUser_s(employ.getCustomerUserName_s());
				ot.setCreateDate_t(DateUtil.getCurrentDate());
			}else if(isModify==2){
				ot.setOrganization_s(superior_s.replace("\r\n", ""));
				ot.setName_s(name_s.replace("\r\n", ""));
				if(superior_s.startsWith("Dept")){
					ot.setOrganization_s(superior_s.replace("\r\n", "").substring(4));
					ot.setType_i(1);
					//ot.setSuperiorType_i(1);//如果父节点ID是以BM开头的，说明是部门
				}else if(superior_s.startsWith("Post")){
					ot.setOrganization_s(superior_s.replace("\r\n", "").substring(4));
					ot.setType_i(2);
					//ot.setSuperiorType_i(2);//如果父节点ID是以Dept开头的，说明是岗位
				}else if(superior_s.startsWith("Em")){
					ot.setOrganization_s(superior_s.replace("\r\n", "").substring(2));
					ot.setType_i(3);
					//ot.setSuperiorType_i(4);//如果父节点ID是bm，说明是根节点
				}else if(superior_s.startsWith("BM")){
					ot.setOrganization_s(superior_s.replace("\r\n", "").substring(2));
					ot.setSuperiorType_i(4);//
				}
//				ot.setName_s(name_s);
//				
//				ot.setLastUpdateDate_t(DateUtil.getCurrentDate());
//				ot.setLastUpdateUser_s(employ.getCustomerUserName_s());
			}
			List<OrganizationTree> otlist=new ArrayList<OrganizationTree>();
			otlist.add(ot);
			
			
			IorganizationTreeService iots=new OrganizationTreeServiceImpl();
			remsg = iots.OperationOrganizationReturnNo(otlist, isModify);
		
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8"); 
			PrintWriter out = response.getWriter(); 
	        out.println("SUCCESS" + ":"+ remsg);  
	        out.flush();  
	        out.close();  
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			 
			// TODO: handle exception
		}
		return null;
	}
	
	public String deleteNode(){
		try {
			ViewOrganization vo=new ViewOrganization();
			//设置树信息
			OrganizationTree ot=new OrganizationTree();
			
			if(organization_s.startsWith("Dept")){
				ot.setType_i(1);//如果父节点ID是以BM开头的，说明是部门
				vo.setOrganizationdept_s(organization_s.replace("\r\n", "").substring(4));
				ot.setOrganization_s(organization_s.replace("\r\n", "").substring(4));
			}else if(organization_s.startsWith("Post")){
				ot.setType_i(2);//如果父节点ID是以Dept开头的，说明是岗位
				vo.setOrganizationpost_s(organization_s.replace("\r\n", "").substring(4));
				ot.setOrganization_s(organization_s.replace("\r\n", "").substring(4));
			}else if(organization_s.startsWith("Em")){
				ot.setType_i(3);//如果父节点ID是em，说明是员工
				vo.setEmployeeid_s(organization_s.replace("\r\n", "").substring(2));
				ot.setOrganization_s(organization_s.replace("\r\n", "").substring(2));
			}
			ot.setCreateUser_s(employ.getCustomerUserName_s());
			ot.setCreateDate_t(DateUtil.getCurrentDate());
			
			List<OrganizationTree> otlist=new ArrayList<OrganizationTree>();
			otlist.add(ot);
			
			IViewOrganizationService ivos=new ViewOrganizationServiceImpl();
			boolean istrue=ivos.getIsVisible(vo);
			
			String msg = "";
			
			if(istrue){//如果为真，订单里包含人不能删除
				msg="ERROR";
				msgstr = "员工在订单中，不能修改该员工岗位";
			}else{
				IorganizationTreeService iots=new OrganizationTreeServiceImpl();
				msg = iots.OperationOrganizationReturnNo(otlist, 3);
				msg = "SUCCESS";
			}

			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8"); 
			PrintWriter out = response.getWriter(); 
	        out.println( msg);  
	        out.flush();  
	        out.close();  
			
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
		 
		}
		return null;
	}
	
	
	public String addEmployNode(){
		try {
			List<OrganizationTree> otlist=new ArrayList<OrganizationTree>();
			String temp[] =emplist.split("I");
			for (int i = 0; i < temp.length; i++) {
				if(temp[i] != null ){
					String tt[]= temp[i].split(",");
					
					OrganizationTree ot=new OrganizationTree();
					ot.setCreateUser_s(employ.getCustomerUserName_s());
					ot.setCreateDate_t(DateUtil.getCurrentDate());
					ot.setOrganization_s(tt[0]);
					ot.setOrganizationDept_s(organizationDept_s.substring(4));
					if(organizationPost_s.lastIndexOf("PostPost")!=-1){
						ot.setSuperior_s(organizationPost_s.substring(4));
					}else{
						ot.setSuperior_s(organizationPost_s.substring(0,organizationPost_s.length()-2));
					}
					ot.setName_s(tt[1]);
					ot.setSuperiorType_i(ConstantUtil.organizationType_2);//职员的父节点说明是岗位
					ot.setType_i(ConstantUtil.organizationType_3);
					
					otlist.add(ot);
				}
			}
			
			/*OrganizationTree ot=new OrganizationTree();
			if(isModify==1){
				ot.setCreateUser_s(employ.getCustomerUserName_s());
				ot.setCreateDate_t(DateUtil.getCurrentDate());
			}else if(isModify==2){
				
				ot.setLastUpdateDate_t(DateUtil.getCurrentDate());
				ot.setLastUpdateUser_s(employ.getCustomerUserName_s());
			}
			
			ot.setOrganization_s(employeeID_s);
			ot.setOrganizationDept_s(organizationDept_s);
			ot.setSuperior_s(organizationPost_s);
			ot.setName_s(customerUserName_s);
			ot.setIdentityCard_s(identityCard_s);
			ot.setTelephone_s(telephone_s);
			ot.setFacsimile_s(facsimile_s);
			ot.setEmail_s(email_s);
			ot.setSuperiorType_i(ConstantUtil.organizationType_2);//职员的父节点说明是岗位
			ot.setType_i(ConstantUtil.organizationType_3);*/
			
			IorganizationTreeService iots=new OrganizationTreeServiceImpl();
			remsg=iots.OperationOrganizationReturnNo(otlist, isModify);
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8"); 
			PrintWriter out = response.getWriter(); 
	        out.println("SUCCESS" + ":"+ remsg);  
	        out.flush();  
	        out.close();
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return null;
	}
	
	public String searchEmployee(){
		try {
			Employee em=new Employee();
			organizationDept_s = organizationDept_s.substring(4);
			em.setOrganizationDept_s(organizationDept_s);
			em.setOrganizationPost_s("null");
			em.setIsOnline(0);//0代表有效职员
			
			IemployeeService ies=new EmployeeServiceImpl();
			/*//确定记录总数
			totalPages =ies.getEmployeesNumber(em);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}*/
			employeelist=ies.getEmployees(em,ConstantUtil.pagingNot, 0);
			
			HttpServletResponse response = ServletActionContext.getResponse();

			EmployeeJson ej=new EmployeeJson();
			String json=ej.drawejson(employeelist);
			//测试数据json
			//String json ="{\"total\":28,\"rows\":[{\"employid\":\"FI-SW-01\",\"employname\":\"Koi\"},{\"employid\":\"K9-DL-01\",\"employname\":\"Dalmation\"},{\"employid\":\"RP-SN-01\",\"employname\":\"Rattlesnake\"},{\"employid\":\"RP-SN-01\",\"employname\":\"Rattlesnake\"}]}";			
			//System.out.println(json);
			//设置编码格式
			response.setContentType("text/html;charset=UTF-8"); 
			PrintWriter out = response.getWriter(); 

//			JSONObject jsontest=new JSONObject();  
//			jsontest.accumulate("success", true);  
//			json = jsontest.toString();
	        out.println(json.toString());  
	        out.flush();  
	        out.close();  
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return null;
	}
	
	
	
	public void AddRoot()
	{
		try {
			OrganizationDept od = new OrganizationDept();
			od.setCreateDate_t(new Date());
			od.setCreateUser_s(employ.getCustomerUserName_s());
			od.setDeptName_s("试验场");
			od.setOrganizationDept_s("BM001");
			IorganizationDeptService iod = new OrganizationDeptServiceImpl();
			iod.OperationOrganizationDept(od, 1);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			 
			// TODO: handle exception
		}
	}
	
	public String getName_s() {
		return name_s;
	}

	public void setName_s(String name_s) {
		this.name_s = name_s;
	}

	public String getSuperior_s() {
		return superior_s;
	}

	public void setSuperior_s(String superior_s) {
		this.superior_s = superior_s;
	}

	public int getType_i() {
		return type_i;
	}

	public void setType_i(int type_i) {
		this.type_i = type_i;
	}

	public int getSuperiorType_i() {
		return superiorType_i;
	}

	public void setSuperiorType_i(int superiorType_i) {
		this.superiorType_i = superiorType_i;
	}

	public String getDept_s() {
		return Dept_s;
	}

	public void setDept_s(String dept_s) {
		Dept_s = dept_s;
	}

	public List<Employee> getEmployeelist() {
		return employeelist;
	}

	public void setEmployeelist(List<Employee> employeelist) {
		this.employeelist = employeelist;
	}

	public String getOrganization_s() {
		return organization_s;
	}

	public void setOrganization_s(String organization_s) {
		this.organization_s = organization_s;
	}

	public int getIsModify() {
		return isModify;
	}

	public void setIsModify(int isModify) {
		this.isModify = isModify;
	}

	public List<OrganizationTree> getOtree() {
		return otree;
	}

	public void setOtree(List<OrganizationTree> otree) {
		this.otree = otree;
	}

	public List<TreeJson> getTreejson() {
		return treejson;
	}

	public void setTreejson(List<TreeJson> treejson) {
		this.treejson = treejson;
	}

	public String getOrganizationPost_s() {
		return organizationPost_s;
	}

	public void setOrganizationPost_s(String organizationPost_s) {
		this.organizationPost_s = organizationPost_s;
	}

	public String getOrganizationDept_s() {
		return organizationDept_s;
	}

	public void setOrganizationDept_s(String organizationDept_s) {
		this.organizationDept_s = organizationDept_s;
	}

	public String getEmployeeLoginName() {
		return employeeLoginName;
	}

	public void setEmployeeLoginName(String employeeLoginName) {
		this.employeeLoginName = employeeLoginName;
	}

	public String getCustomerUserName_s() {
		return customerUserName_s;
	}

	public void setCustomerUserName_s(String customerUserName_s) {
		this.customerUserName_s = customerUserName_s;
	}

	public String getIdentityCard_s() {
		return identityCard_s;
	}

	public void setIdentityCard_s(String identityCard_s) {
		this.identityCard_s = identityCard_s;
	}

	public String getTelephone_s() {
		return telephone_s;
	}

	public void setTelephone_s(String telephone_s) {
		this.telephone_s = telephone_s;
	}

	public String getFacsimile_s() {
		return facsimile_s;
	}

	public void setFacsimile_s(String facsimile_s) {
		this.facsimile_s = facsimile_s;
	}

	public String getEmail_s() {
		return email_s;
	}

	public void setEmail_s(String email_s) {
		this.email_s = email_s;
	}

	public String getEmployeeID_s() {
		return employeeID_s;
	}

	public void setEmployeeID_s(String employeeID_s) {
		this.employeeID_s = employeeID_s;
	}

	public String getRemsg() {
		return remsg;
	}

	public void setRemsg(String remsg) {
		this.remsg = remsg;
	}

	public long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getEmplist() {
		return emplist;
	}

	public void setEmplist(String emplist) {
		this.emplist = emplist;
	}
	public String getOrganizationDeptName_s() {
		return organizationDeptName_s;
	}

	public void setOrganizationDeptName_s(String organizationDeptName_s) {
		this.organizationDeptName_s = organizationDeptName_s;
	}


	
}
