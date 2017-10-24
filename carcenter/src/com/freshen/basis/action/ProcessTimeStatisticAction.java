package com.freshen.basis.action;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

import com.freshen.action.common.CapgActionSupport;
import com.freshen.entity.Department;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.entity.basis.RoadUseStatistic;

public class ProcessTimeStatisticAction extends CapgActionSupport {

	String inputDate,workday;

	public String getWorkday() {
		return workday;
	}

	public void setWorkday(String workday) {
		this.workday = workday;
	}

	ArrayList<RoadUseStatistic> roaduselist = new ArrayList<RoadUseStatistic>();// 记录道路信息

	public String execute() {

		return "success";
	}

	public String processTimeStatisticCacu() {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.252.12:1521:clims";
		String username = "sjy";
		String psw = "catarc";
		Department dpt = new Department();
		String dptName = "";
		String dptid = "";
		String status = "";
		String startDate = "";
		String endDate = "";
		String queryDate = "";
		String CacuStatus = "";
		Date datetemp;
		// System.out.println(breakfirstMoney);
		// System.out.println(lanchMoney);
		// System.out.println(dinnerMoney);
		// System.out.println(breakfirstStatus);
		// System.out.println(lanchStatus);
		// System.out.println(dinnerStatus);
		// System.out.println(dptList);
		String sql = "";
		String sqlInsert = "truncate table dbo.A_subsidies_dep ";
		// String[] dptArray = dptList.split(",");
		boolean executeResult;
		try {

			Properties prop = new Properties();
			InputStream in = getClass().getResourceAsStream(
					"dataConnect.properties");
			prop.load(in); // /加载属性列表
			Iterator<String> it = prop.stringPropertyNames().iterator();

			// driver = prop.getProperty("driver1");
			// url = prop.getProperty("url1");
			// username = prop.getProperty("username1");
			// psw = prop.getProperty("password1");
			in.close();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdfparse = new SimpleDateFormat("yyyy-MM-dd");
			datetemp = sdf.parse(inputDate);
			queryDate = inputDate;
			if (inputDate != null) {
				startDate = queryDate + " 00:00:00";
				endDate = queryDate + " 23:59:59";
			}

			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, psw);

			PreparedStatement pstmt = conn
					.prepareStatement(" select count(1) cacustatus from  t_process_station_statistic where t_process_station_statistic.createdate_t = to_date('"
							+ queryDate + "','yyyy/mm/dd')");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				// out.println(rs.getString("dept"));
				// out.println("<br>");
				CacuStatus = rs.getString("cacustatus");
				if (CacuStatus == null || CacuStatus.equals("")) {
					CacuStatus = "0";
				}
			}

//			if(datetemp.getDate()==1)
//			{
//				CacuStatus = "0";
//			}
			if (CacuStatus.equals("0")) {
				sql = "call OrderCostCompute.mappingInorOutStatisticCacu('"
						+ startDate + "','" + endDate + "')";

				pstmt = conn.prepareStatement(sql);
				executeResult = pstmt.execute();
			}

			sql = "select round(a.runtime/(b.maxcapacity_i*to_number(b.usefultime_s))*100,2) rate ,b.roadname_s,b.maxcapacity_i,b.usefultime_s,a.createdate_t,runtime  "
					+ " from (select a.facilityid_s,a.createdate_t,sum(a.resaveds1_s) runtime "
					+ " from t_process_station_statistic a "
					+ "where a.createdate_t = to_date('"
					+ queryDate
					+ "','yyyy/mm/dd')"
					+ "group by a.facilityid_s,a.createdate_t ) a inner join t_basis_roadinfo b on a.facilityid_s = b.roadid_s ";
					

			pstmt = conn.prepareStatement(sql);
			ResultSet rs_detail = pstmt.executeQuery();
			RoadUseStatistic rus = new RoadUseStatistic();
			while (rs_detail.next()) {
				rus = new RoadUseStatistic();
				// out.println(rs.getString("dept"));
				// out.println("<br>");
				rus.setRoadName_s(rs_detail.getString("roadname_s"));
				rus.setMaxcapacity_s(rs_detail.getString("maxcapacity_i"));
				rus.setCreatedate_s(rs_detail.getString("createdate_t")
						.substring(0, 10));
				rus.setRate_s(rs_detail.getString("rate").startsWith(".") ? "0"
						+ rs_detail.getString("rate") : rs_detail
						.getString("rate"));
				rus.setUsefultime_s(rs_detail.getString("usefultime_s"));
				rus.setRoadName_s(rs_detail.getString("roadname_s"));
				rus.setRuntime_s(rs_detail.getString("runtime"));
				roaduselist.add(rus);
			}

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
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "success";
		}
	}

	public String reprocessTimeStatisticCacu() {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.252.12:1521:clims";
		String username = "sjy";
		String psw = "catarc";
		Department dpt = new Department();
		String dptName = "";
		String dptid = "";
		String status = "";
		String startDate = "";
		String endDate = "";
		String queryDate = "";
		String CacuStatus = "";
		// System.out.println(breakfirstMoney);
		// System.out.println(lanchMoney);
		// System.out.println(dinnerMoney);
		// System.out.println(breakfirstStatus);
		// System.out.println(lanchStatus);
		// System.out.println(dinnerStatus);
		// System.out.println(dptList);
		String sql = "";
		String sqlInsert = "truncate table dbo.A_subsidies_dep ";
		// String[] dptArray = dptList.split(",");
		boolean executeResult;
		try {

			Properties prop = new Properties();
			InputStream in = getClass().getResourceAsStream(
					"dataConnect.properties");
			prop.load(in); // /加载属性列表
			Iterator<String> it = prop.stringPropertyNames().iterator();

			// driver = prop.getProperty("driver1");
			// url = prop.getProperty("url1");
			// username = prop.getProperty("username1");
			// psw = prop.getProperty("password1");
			in.close();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdfparse = new SimpleDateFormat("yyyy-MM-dd");

			queryDate = inputDate;
			if (inputDate != null) {
				startDate = queryDate + " 00:00:00";
				endDate = queryDate + " 23:59:59";
			}

			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, psw);

			PreparedStatement pstmt = conn
					.prepareStatement(" select count(1) cacustatus from  t_process_station_statistic where t_process_station_statistic.createdate_t = to_date('"
							+ queryDate + "','yyyy/mm/dd')");
//			ResultSet rs = pstmt.executeQuery();
//			while (rs.next()) {
//				// out.println(rs.getString("dept"));
//				// out.println("<br>");
//				CacuStatus = rs.getString("cacustatus");
//				if (CacuStatus == null || CacuStatus.equals("")) {
//					CacuStatus = "0";
//				}
//			}

			sql = "call OrderCostCompute.mappingInorOutStatisticCacu('"
					+ startDate + "','" + endDate + "')";

			pstmt = conn.prepareStatement(sql);
			executeResult = pstmt.execute();

			sql = "select round(a.runtime/(b.maxcapacity_i*to_number(b.usefultime_s))*100,2) rate ,b.roadname_s,b.maxcapacity_i,b.usefultime_s,a.createdate_t,runtime  "
					+ " from (select a.facilityid_s,a.createdate_t,sum(a.resaveds1_s) runtime "
					+ " from t_process_station_statistic a "
					+ "where a.createdate_t = to_date('"
					+ queryDate
					+ "','yyyy/mm/dd')"
					+ "group by a.facilityid_s,a.createdate_t ) a inner join t_basis_roadinfo b on a.facilityid_s = b.roadid_s ";
					

			pstmt = conn.prepareStatement(sql);
			ResultSet rs_detail = pstmt.executeQuery();
			RoadUseStatistic rus = new RoadUseStatistic();
			while (rs_detail.next()) {
				rus = new RoadUseStatistic();
				// out.println(rs.getString("dept"));
				// out.println("<br>");
				rus.setRoadName_s(rs_detail.getString("roadname_s"));
				rus.setMaxcapacity_s(rs_detail.getString("maxcapacity_i"));
				rus.setCreatedate_s(rs_detail.getString("createdate_t")
						.substring(0, 10));
				rus.setRate_s(rs_detail.getString("rate").startsWith(".") ? "0"
						+ rs_detail.getString("rate") : rs_detail
						.getString("rate"));
				rus.setUsefultime_s(rs_detail.getString("usefultime_s"));
				rus.setRoadName_s(rs_detail.getString("roadname_s"));
				rus.setRuntime_s(rs_detail.getString("runtime"));

				roaduselist.add(rus);
			}

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

	public String processTimeStatisticCacuMonth() {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.252.12:1521:clims";
		String username = "sjy";
		String psw = "catarc";
		Department dpt = new Department();
		String dptName = "";
		String dptid = "";
		String status = "";
		String startDate = "";
		String endDate = "";
		String queryDate = "";
		String CacuStatus = "";
		Date dateStart;
		Date dateEnd;
		int yearstart=0,monthstart=0,daystart=0;
		// System.out.println(breakfirstMoney);
		// System.out.println(lanchMoney);
		// System.out.println(dinnerMoney);
		// System.out.println(breakfirstStatus);
		// System.out.println(lanchStatus);
		// System.out.println(dinnerStatus);
		// System.out.println(dptList);
		String sql = "";
		String sqlInsert = "truncate table dbo.A_subsidies_dep ";
		// String[] dptArray = dptList.split(",");
		boolean executeResult;
		try {

			Properties prop = new Properties();
			InputStream in = getClass().getResourceAsStream(
					"dataConnect.properties");
			prop.load(in); // /加载属性列表
			Iterator<String> it = prop.stringPropertyNames().iterator();

			// driver = prop.getProperty("driver1");
			// url = prop.getProperty("url1");
			// username = prop.getProperty("username1");
			// psw = prop.getProperty("password1");
			in.close();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdfparse = new SimpleDateFormat("yyyy-MM-dd");

			queryDate = inputDate;
			Calendar calendar = Calendar.getInstance();   
			int maxDay = 0;
			if (inputDate != null) {
				dateStart = sdf.parse(queryDate);
				
				yearstart = dateStart.getYear()+1900;
				monthstart = dateStart.getMonth()+1;
				daystart = dateStart.getDay();
				
				calendar.setTime(dateStart);  
				//calendar.add(Calendar.MONTH,1);//日期加3个月 
				startDate = yearstart + "-" + monthstart + "-" + "01" + " 00:00:00";
				//dateEnd = calendar.getTime();
				maxDay=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);  
				endDate = yearstart + "-" + monthstart+"-" + maxDay + " 23:59:59";
			}
			else
			{
				return "success";
			}

			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, psw);

			PreparedStatement pstmt = conn
					.prepareStatement(" select count(1) cacustatus from  t_process_station_statisticm where t_process_station_statisticm.createdate_t = to_date('"
							+ yearstart + "-" + monthstart + "-" + "01" + "','yyyy/mm/dd')");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				// out.println(rs.getString("dept"));
				// out.println("<br>");
				CacuStatus = rs.getString("cacustatus");
				if (CacuStatus == null || CacuStatus.equals("")) {
					CacuStatus = "0";
				}
			}

//			if(datetemp.getDate()==1)
//			{
//				CacuStatus = "0";
//			}
			if (CacuStatus.equals("0")) {
				sql = "call OrderCostCompute.mappingInorOutStatisticCacum('"
						+ startDate + "','" + endDate + "')";

				pstmt = conn.prepareStatement(sql);
				executeResult = pstmt.execute();
			}

			sql = "select round(a.runtime/(b.maxcapacity_i*to_number(b.usefultime_s)*"+workday+")*100,2) rate ,b.roadname_s,b.maxcapacity_i,b.usefultime_s,a.createdate_t,runtime  "
					+ " from (select a.facilityid_s,a.createdate_t,sum(a.resaveds1_s) runtime "
					+ " from t_process_station_statisticm a where  a.createdate_t >= to_date('"+startDate+"','yyyy-mm-dd hh24:mi:ss') "
					+ "and a.createdate_t <= to_date('"+endDate+"','yyyy-mm-dd hh24:mi:ss')"
					+ " group by a.facilityid_s,a.createdate_t ) a inner join t_basis_roadinfo b on a.facilityid_s = b.roadid_s ";

			pstmt = conn.prepareStatement(sql);
			ResultSet rs_detail = pstmt.executeQuery();
			RoadUseStatistic rus = new RoadUseStatistic();
			while (rs_detail.next()) {
				rus = new RoadUseStatistic();
				// out.println(rs.getString("dept"));
				// out.println("<br>");
				rus.setRoadName_s(rs_detail.getString("roadname_s"));
				rus.setMaxcapacity_s(rs_detail.getString("maxcapacity_i"));
				rus.setCreatedate_s(yearstart + "-" + monthstart );
				rus.setRate_s(rs_detail.getString("rate").startsWith(".") ? "0"
						+ rs_detail.getString("rate") : rs_detail
						.getString("rate"));
				rus.setUsefultime_s(rs_detail.getString("usefultime_s"));
				rus.setRoadName_s(rs_detail.getString("roadname_s"));
				rus.setRuntime_s(rs_detail.getString("runtime"));

				roaduselist.add(rus);
			}

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
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "success";
		}
	}
	
	public String reprocessTimeStatisticCacuMonth() {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.252.12:1521:clims";
		String username = "sjy";
		String psw = "catarc";
		Department dpt = new Department();
		String dptName = "";
		String dptid = "";
		String status = "";
		String startDate = "";
		String endDate = "";
		String queryDate = "";
		String CacuStatus = "";
		Date dateStart;
		Date dateEnd;
		int yearstart=0,monthstart=0,daystart=0;
		// System.out.println(breakfirstMoney);
		// System.out.println(lanchMoney);
		// System.out.println(dinnerMoney);
		// System.out.println(breakfirstStatus);
		// System.out.println(lanchStatus);
		// System.out.println(dinnerStatus);
		// System.out.println(dptList);
		String sql = "";
		String sqlInsert = "truncate table dbo.A_subsidies_dep ";
		// String[] dptArray = dptList.split(",");
		boolean executeResult;
		try {

			Properties prop = new Properties();
			InputStream in = getClass().getResourceAsStream(
					"dataConnect.properties");
			prop.load(in); // /加载属性列表
			Iterator<String> it = prop.stringPropertyNames().iterator();

			// driver = prop.getProperty("driver1");
			// url = prop.getProperty("url1");
			// username = prop.getProperty("username1");
			// psw = prop.getProperty("password1");
			in.close();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdfparse = new SimpleDateFormat("yyyy-MM-dd");

			queryDate = inputDate;
			Calendar calendar = Calendar.getInstance();   
			int maxDay = 0;
			if (inputDate != null) {
				dateStart = sdf.parse(queryDate);
				
				yearstart = dateStart.getYear()+1900;
				monthstart = dateStart.getMonth()+1;
				daystart = dateStart.getDay();
				
				calendar.setTime(dateStart);  
				//calendar.add(Calendar.MONTH,1);//日期加3个月 
				startDate = yearstart + "-" + monthstart + "-" + "01" + " 00:00:00";
				//dateEnd = calendar.getTime();
				maxDay=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);  
				endDate = yearstart + "-" + monthstart+"-" + maxDay + " 23:59:59";
			}
			else
			{
				return "success";
			}

			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, psw);

			PreparedStatement pstmt = conn
					.prepareStatement(" select count(1) cacustatus from  t_process_station_statisticm where t_process_station_statisticm.createdate_t = to_date('"
							+ yearstart + "-" + monthstart + "-" + "01" + "','yyyy/mm/dd')");
//			ResultSet rs = pstmt.executeQuery();
//			while (rs.next()) {
//				// out.println(rs.getString("dept"));
//				// out.println("<br>");
//				CacuStatus = rs.getString("cacustatus");
//				if (CacuStatus == null || CacuStatus.equals("")) {
//					CacuStatus = "0";
//				}
//			}

//			if(datetemp.getDate()==1)
//			{
//				CacuStatus = "0";
//			}
			sql = "call OrderCostCompute.mappingInorOutStatisticCacum('"
					+ startDate + "','" + endDate + "')";

			pstmt = conn.prepareStatement(sql);
			executeResult = pstmt.execute();
		

			sql = "select round(a.runtime/(b.maxcapacity_i*to_number(b.usefultime_s)*"+workday+")*100,2) rate ,b.roadname_s,b.maxcapacity_i,b.usefultime_s,a.createdate_t,runtime  "
					+ " from (select a.facilityid_s,a.createdate_t,sum(a.resaveds1_s) runtime "
					+ " from t_process_station_statisticm a where  a.createdate_t >= to_date('"+startDate+"','yyyy-mm-dd hh24:mi:ss') "
					+ "and a.createdate_t <= to_date('"+endDate+"','yyyy-mm-dd hh24:mi:ss')"
					+ " group by a.facilityid_s,a.createdate_t ) a inner join t_basis_roadinfo b on a.facilityid_s = b.roadid_s ";

			pstmt = conn.prepareStatement(sql);
			ResultSet rs_detail = pstmt.executeQuery();
			RoadUseStatistic rus = new RoadUseStatistic();
			while (rs_detail.next()) {
				rus = new RoadUseStatistic();
				// out.println(rs.getString("dept"));
				// out.println("<br>");
				rus.setRoadName_s(rs_detail.getString("roadname_s"));
				rus.setMaxcapacity_s(rs_detail.getString("maxcapacity_i"));
				rus.setCreatedate_s(yearstart + "-" + monthstart );
				rus.setRate_s(rs_detail.getString("rate").startsWith(".") ? "0"
						+ rs_detail.getString("rate") : rs_detail
						.getString("rate"));
				rus.setUsefultime_s(rs_detail.getString("usefultime_s"));
				rus.setRoadName_s(rs_detail.getString("roadname_s"));
				rus.setRuntime_s(rs_detail.getString("runtime"));

				roaduselist.add(rus);
			}

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
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "success";
		}
	}

	public String getInputDate() {
		return inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	public ArrayList<RoadUseStatistic> getRoaduselist() {
		return roaduselist;
	}

	public void setRoaduselist(ArrayList<RoadUseStatistic> roaduselist) {
		this.roaduselist = roaduselist;
	}
}
