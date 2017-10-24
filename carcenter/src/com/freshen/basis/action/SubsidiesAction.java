package com.freshen.basis.action;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import com.freshen.action.common.CapgActionSupport;
import com.freshen.entity.Department;

public class SubsidiesAction extends CapgActionSupport {

	private static final long serialVersionUID = 1L;

	private String breakfirstMoney = "";
	private String lanchMoney = "";
	private String dinnerMoney = "";
	private String breakfirstStatus = "";
	private String lanchStatus = "";
	private String dinnerStatus = "";
	
	private String breakfirststart = "";
	private String breakfirstend = "";
	
	private String lanchstart="";
	private String lanchend = "";
	
	private String dinnerstart="";
	private String dinnerend = "";
	
	public String getBreakfirststart() {
		return breakfirststart;
	}

	public void setBreakfirststart(String breakfirststart) {
		this.breakfirststart = breakfirststart;
	}

	public String getBreakfirstend() {
		return breakfirstend;
	}

	public void setBreakfirstend(String breakfirstend) {
		this.breakfirstend = breakfirstend;
	}

	public String getLanchstart() {
		return lanchstart;
	}

	public void setLanchstart(String lanchstart) {
		this.lanchstart = lanchstart;
	}

	public String getLanchend() {
		return lanchend;
	}

	public void setLanchend(String lanchend) {
		this.lanchend = lanchend;
	}

	public String getDinnerstart() {
		return dinnerstart;
	}

	public void setDinnerstart(String dinnerstart) {
		this.dinnerstart = dinnerstart;
	}

	public String getDinnerend() {
		return dinnerend;
	}

	public void setDinnerend(String dinnerend) {
		this.dinnerend = dinnerend;
	}

	List<Department> dlist = new ArrayList<Department>();
	private String dptList = "";
	public List<Department> getDlist() {
		return dlist;
	}

	public void setDlist(List<Department> dlist) {
		this.dlist = dlist;
	}

	public String execute() {
		String driver = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
		String url = "jdbc:microsoft:sqlserver://192.168.0.20:1433;DatabaseName=fqit";
		String username = "sa";
		String psw = "126.com";
		Department dpt = new Department();
		String dptName = "";
		String dptid = "";
		String status = "";
		try {
			Properties prop = new Properties();
			InputStream in = getClass().getResourceAsStream(
					"dataConnect.properties");
			prop.load(in); // /加载属性列表
			Iterator<String> it = prop.stringPropertyNames().iterator();

			driver = prop.getProperty("driver2");
			url = prop.getProperty("url2");
			username = prop.getProperty("username2");
			psw = prop.getProperty("password2");
			in.close();

			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, psw);
			
			PreparedStatement pstmt = conn
					.prepareStatement("SELECT TOP 1000 breakfirstMoney,lanchMoney,dinnerMoney,breakfirstStatus,lanchStatus,dinnerStatus,"
							+ "subsidiesStatus,breakfirststart,breakfirstend,lanchstart,lanchend,dinnerstart,dinnerend"
							+ ",id FROM dbo.A_subsidies_param");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				// out.println(rs.getString("dept"));
				// out.println("<br>");
				breakfirstMoney = rs.getString("breakfirstMoney");
				lanchMoney = rs.getString("lanchMoney");
				dinnerMoney = rs.getString("dinnerMoney");
				breakfirstStatus = rs.getString("breakfirstStatus");
				lanchStatus = rs.getString("lanchStatus");
				dinnerStatus = rs.getString("dinnerStatus");
				
				breakfirststart = rs.getString("breakfirststart");
				breakfirstend = rs.getString("breakfirstend");
				
				lanchstart=rs.getString("lanchstart");
				lanchend = rs.getString("lanchend");
				
				dinnerstart=rs.getString("dinnerstart");
				dinnerend = rs.getString("dinnerend");
			}
			pstmt = conn
					.prepareStatement("SELECT TOP 1000 pb_depart.DptId ,DptName,case when A_subsidies_dep.dptId is null then 0 else 1 end as checkstatus  FROM ocs_udp.dbo.pb_depart LEFT join dbo.A_subsidies_dep on A_subsidies_dep.dptId  = pb_depart.DptId where IsDeleted = 0");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// out.println(rs.getString("dept"));
				// out.println("<br>");
				dpt = new Department();
				dptName = rs.getString("DptName");
				dptid = rs.getString("DptId");
				status = rs.getString("checkstatus");
				if (dptName == null || dptName.equals("")) {
					continue;
				}
				dpt.setDptId(dptid);
				dpt.setCheckstatus(status);
				dpt.setDptName(dptName);

				if (!rs.next()) {

					dlist.add(dpt);
					continue;
				}
//				rs.next();
				dptName = rs.getString("DptName");
				dptid = rs.getString("DptId");
				status = rs.getString("checkstatus");
				if (dptName == null || dptName.equals("")) {
					continue;
				}
				dpt.setDptId2(dptid);
				dpt.setCheckstatus2(status);
				dpt.setDptName2(dptName);

				if (!rs.next()) {

					dlist.add(dpt);
					continue;
				}
//				rs.next();
				dptName = rs.getString("DptName");
				dptid = rs.getString("DptId");
				status = rs.getString("checkstatus");
				if (dptName == null || dptName.equals("")) {
					continue;
				}
				dpt.setDptId3(dptid);
				dpt.setCheckstatus3(status);
				dpt.setDptName3(dptName);
				dlist.add(dpt);
			}
			rs.close();
			pstmt.close();
			conn.close();
			return "success";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return "success";
		} catch (SQLException e) {
			e.printStackTrace();
			return "success";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "success";
		} catch (IOException e) {
			e.printStackTrace();
			return "success";
		}
	}

	public String updateSubsidiesinfo() {
		String driver = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
		String url = "jdbc:microsoft:sqlserver://192.168.0.20:1433;DatabaseName=fqit";
		String username = "sa";
		String psw = "126.com";
		Department dpt = new Department();
		String dptName = "";
		String dptid = "";
		String status = "";
//		System.out.println(breakfirstMoney);
//		System.out.println(lanchMoney);
//		System.out.println(dinnerMoney);
//		System.out.println(breakfirstStatus);
//		System.out.println(lanchStatus);
//		System.out.println(dinnerStatus);
//		System.out.println(dptList);
		String sql = "";
		String sqlInsert = "truncate table dbo.A_subsidies_dep ";
		String[] dptArray = dptList.split(","); 
		boolean executeResult ;
		try {
			if(breakfirststart.indexOf(":")<0)
			{
				breakfirststart = breakfirststart+":00";
			}
			if(breakfirstend.indexOf(":")<0)
			{
				breakfirstend = breakfirstend+":00";
			}
			if(lanchstart.indexOf(":")<0)
			{
				lanchstart = lanchstart+":00";
			}
			if(lanchend.indexOf(":")<0)
			{
				lanchend = lanchend+":00";
			}
			if(dinnerstart.indexOf(":")<0)
			{
				dinnerstart = dinnerstart+":00";
			}
			if(dinnerend.indexOf(":")<0)
			{
				dinnerend = dinnerend+":00";
			}
			Properties prop = new Properties();
			InputStream in = getClass().getResourceAsStream(
					"dataConnect.properties");
			prop.load(in); // /加载属性列表
			Iterator<String> it = prop.stringPropertyNames().iterator();

			driver = prop.getProperty("driver2");
			url = prop.getProperty("url2");
			username = prop.getProperty("username2");
			psw = prop.getProperty("password2");
			in.close();
			
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, psw);
			
			sql = "update dbo.A_subsidies_param set breakfirstMoney = "+breakfirstMoney.toString()+
					",lanchMoney = "+ lanchMoney.toString()+",dinnerMoney = "+dinnerMoney +",breakfirstStatus= "+breakfirstStatus+
					",lanchStatus = "+lanchStatus.toString()+",dinnerStatus = "+dinnerStatus.toString()+",breakfirststart = '"+breakfirststart.toString()
					+"',breakfirstend = '"+breakfirstend.toString()+"',lanchstart = '"+lanchstart.toString()+"',lanchend = '"+lanchend.toString()
					+"',dinnerstart = '"+dinnerstart.toString()+"',dinnerend = '"+dinnerend.toString() + "'";
			
			PreparedStatement pstmt = conn
					.prepareStatement(sql);
			executeResult = pstmt.execute();
			
			for (int i = 0 ;i<dptArray.length;i++)
			{
				sqlInsert = sqlInsert  + "   insert into A_subsidies_dep(dptId) values("+ dptArray[i].toString() +") ";
			}
			pstmt = conn
					.prepareStatement(sqlInsert);
			executeResult = pstmt.execute();
			
			pstmt.close();
			conn.close();
			return "success";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return "success";
		} catch (SQLException e) {
			e.printStackTrace();
			return "success";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "success";
		} catch (IOException e) {
			e.printStackTrace();
			return "success";
		}
	}

	public String getDptList() {
		return dptList;
	}

	public void setDptList(String dptList) {
		this.dptList = dptList;
	}

	public String getBreakfirstMoney() {
		return breakfirstMoney;
	}

	public void setBreakfirstMoney(String breakfirstMoney) {
		this.breakfirstMoney = breakfirstMoney;
	}

	public String getLanchMoney() {
		return lanchMoney;
	}

	public void setLanchMoney(String lanchMoney) {
		this.lanchMoney = lanchMoney;
	}

	public String getDinnerMoney() {
		return dinnerMoney;
	}

	public void setDinnerMoney(String dinnerMoney) {
		this.dinnerMoney = dinnerMoney;
	}

	public String getBreakfirstStatus() {
		return breakfirstStatus;
	}

	public void setBreakfirstStatus(String breakfirstStatus) {
		this.breakfirstStatus = breakfirstStatus;
	}

	public String getLanchStatus() {
		return lanchStatus;
	}

	public void setLanchStatus(String lanchStatus) {
		this.lanchStatus = lanchStatus;
	}

	public String getDinnerStatus() {
		return dinnerStatus;
	}

	public void setDinnerStatus(String dinnerStatus) {
		this.dinnerStatus = dinnerStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
