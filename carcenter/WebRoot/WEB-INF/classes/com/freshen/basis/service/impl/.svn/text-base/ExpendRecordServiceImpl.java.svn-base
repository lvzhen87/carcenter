package com.freshen.basis.service.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.freshen.basis.service.ExpendRecordService;
import com.freshen.entity.basis.ExpendRecord;
import com.freshen.entity.basis.ExpendRecordTotal;

import com.freshen.util.ConstantUtil;
import com.freshen.util.DataResource;
import com.freshen.util.DateUtil;
import com.freshen.util.Page;
import com.freshen.util.ResourceTools;

import com.freshen.clims.baseclass.ClimsServiceBase;
import com.sun.org.apache.commons.beanutils.ResultSetIterator;

public class ExpendRecordServiceImpl extends ClimsServiceBase implements ExpendRecordService{
	
	/**
	 * 通过条件查询员工消费记录表
	 * 	   
	 * getExpendRecord
	 * 
	 * @param		String strSysNo
	 * @return		ArrayList    
	 * @throws		Exception 
	 * @Exception	异常对象    
	 * @since		CodingExample　
	 */
	public ArrayList<ExpendRecord> getExpendRecord(String strSysNo, String strEmplyName, Page page) throws Exception{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ArrayList<ExpendRecord> list = new ArrayList<ExpendRecord>();
		//	立方数据库连接
    	Connection sqlcon = DataResource.getConnect(ConstantUtil.OneCardSERVERCONN);
		PreparedStatement prest = null;
		
		//获得sql server连接
		sqlcon.setAutoCommit(false);
		
		String sql = " SELECT ic.SysNo,DealMoney,EmplyName,DptName,ic.Dealdate,ic.DptId,CONVERT(date,ic.Dealdate) as datenow FROM pb_Icanteen as ic " +
					 " LEFT JOIN pb_depart as dp ON " +
					 " ic.Dptid = dp.DptId " +
					 " LEFT JOIN pb_emply as em ON " +
					 " ic.SysNo = em.SysNo " +
					 " WHERE " +
					 " DealMoney < 0 and em.IsDeleted = 0 and dp.IsDeleted = 0 and" +
					 " ic.Dptid in ('5','6','7','8','9','10','11','12','14') and " +
					 " DateName (MONTH, Dealdate) = ? and " +
					 " ((left(CONVERT(varchar(100), Dealdate, 8),2) >= ? and left(CONVERT(varchar(100), Dealdate, 8),2) < ?) or " +
					 " (left(CONVERT(varchar(100), Dealdate, 8),2) >= ? and left(CONVERT(varchar(100), Dealdate, 8),2) < ?) or " +
					 " (left(CONVERT(varchar(100), Dealdate, 8),2) >= ? and left(CONVERT(varchar(100), Dealdate, 8),2) < ?))";
		if(null != strSysNo && !"".equals(strSysNo.trim())){
			sql += " and ic.SysNo like '%" + strSysNo.trim() + "%' ";
		}
		if(null != strEmplyName && !"".equals(strEmplyName.trim())){
			sql += " and EmplyName like '%" + strEmplyName.trim() + "%' ";
		}
		prest = sqlcon.prepareStatement(sql+ " order by datenow ,ic.SysNo" ,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		//	临时变量，会改为可配置项
		int breakfirstTimeFrom = 6;				//	早餐开始小时
		int breakfirstTimeTo = 9;				//	早餐结束小时
		int lanchTimeFrom = 11;					//	午餐开始小时
		int lanchTimeTo = 14;					//	午餐结束小时
		int dinnerTimeFrom = 17;				//	晚餐开始小时
		int dinnerTimeTo = 20;					//	晚餐结束小时
		int subsidiesBreakFirst = 5;			//	早餐补贴金额
		int subsidiesLanch = 15;				//	午餐补贴金额
		int subsidiesDinner = 10;				//	晚餐补贴金额
		
		//	获取当前时间  
		Calendar cal = Calendar.getInstance();
		//	调到上个月  
		cal.add(Calendar.MONTH, -1);
		
        SimpleDateFormat sdf = new SimpleDateFormat("MM"); 
        String strSdf = sdf.format(cal.getTime());
	   
		prest.setString(1, strSdf);
        prest.setInt(2, breakfirstTimeFrom);
		prest.setInt(3, breakfirstTimeTo);
		prest.setInt(4, lanchTimeFrom);
		prest.setInt(5, lanchTimeTo);
		prest.setInt(6, dinnerTimeFrom);
		prest.setInt(7, dinnerTimeTo);
		
		prest.setMaxRows(page.getEndIndex());		//	关键代码，设置最大记录数为当前页记录的截止下标 
		ResultSet rs = prest.executeQuery();
		if (page.getBeginIndex() > 0) { 
			rs.absolute(page.getBeginIndex());		//	关键代码，直接移动游标为当前页起始记录处 
		} 
		
		while (rs.next()) {
			ExpendRecord er = new ExpendRecord();
			//	把员工的消费时间分割，只取到某一天的时分秒
			//	再根据规定的可消费时间段，来判断员工的消费，是否需要给予补贴
			String strDealDate = rs.getString(5);
			String tempTime = strDealDate.substring(11, 19);
			String temp = tempTime.replace(":", "");
			int intTime = Integer.parseInt(temp);
			
			//	设置员工证件号
			er.setSysNo(rs.getString(1));
			//	设置消费金额
			er.setDealMoney(rs.getInt(2));
			//	设置员工姓名
			er.setEmployName(rs.getString(3));
			//	设置部门名称
			er.setDepartMentName(rs.getString(4));
			//	设置消费时间
			er.setDealDate(DateUtil.getDate(rs.getString(5),"yyyy-MM-dd HH:mm:ss"));
			er.setDealDate_s(formatter.format((DateUtil.getDate(rs.getString(5),"yyyy-MM-dd HH:mm:ss"))));
			//	设置部门ID
			er.setDepartMentId(rs.getInt(6));
			//	rs.getInt(2)为员工当日规定时间的消费记录，未消费、充值(消费记录为正数)，不计入补贴
			if (intTime >= breakfirstTimeFrom * 10000 && intTime <= breakfirstTimeTo * 10000){
				//	设置给员工发放的补贴金额(早餐)
				er.setSubsidies(subsidiesBreakFirst);
			} else if (intTime >= lanchTimeFrom * 10000 && intTime <= lanchTimeTo * 10000){
				//	设置给员工发放的补贴金额(午餐)
				er.setSubsidies(subsidiesLanch);
			}else if (intTime >= dinnerTimeFrom * 10000 && intTime <= dinnerTimeTo * 10000){
				//	设置给员工发放的补贴金额(晚餐)
				er.setSubsidies(subsidiesDinner);
			}
			
			
			list.add(er);
		}
		return list;
	} 
	
	/**
	 * 通过条件查询员工消费记录表,返回记录件数
	 * 	   
	 * getExpendRecordNumber
	 * 
	 * @param		String strSysNo
	 * @return		Int    
	 * @throws		Exception 
	 * @Exception	异常对象    
	 * @since		CodingExample　
	 */
	public int getExpendRecordNumber(String strSysNo, String strEmplyName) throws Exception{
		
//		ArrayList<ExpendRecord> list = new ArrayList<ExpendRecord>();
		//	立方数据库连接
    	Connection sqlcon = DataResource.getConnect(ConstantUtil.OneCardSERVERCONN);
		PreparedStatement prest = null;
		
		//获得sql server连接
		sqlcon.setAutoCommit(false);
		
		String sql = " SELECT count(*) FROM pb_Icanteen as ic " +
					 " LEFT JOIN pb_depart as dp ON " +
					 " ic.Dptid = dp.DptId " +
					 " LEFT JOIN pb_emply as em ON " +
					 " ic.SysNo = em.SysNo " +
					 " WHERE " +
					 " DealMoney < 0 and em.IsDeleted = 0 and dp.IsDeleted = 0 and" +
					 " ic.Dptid in ('5','6','7','8','9','10','11','12','14') and " +
					 " DateName (MONTH, Dealdate) = ? and " +
					 " ((left(CONVERT(varchar(100), Dealdate, 8),2) >= ? and left(CONVERT(varchar(100), Dealdate, 8),2) < ?) or " +
					 " (left(CONVERT(varchar(100), Dealdate, 8),2) >= ? and left(CONVERT(varchar(100), Dealdate, 8),2) < ?) or " +
					 " (left(CONVERT(varchar(100), Dealdate, 8),2) >= ? and left(CONVERT(varchar(100), Dealdate, 8),2) < ?))";
		if(null != strSysNo && !"".equals(strSysNo.trim())){
			sql += " and ic.SysNo like '%" + strSysNo.trim() + "%' ";
		}
		if(null != strEmplyName && !"".equals(strEmplyName.trim())){
			sql += " and EmplyName like '%" + strEmplyName.trim() + "%' ";
		}
		prest = sqlcon.prepareStatement(sql);
		
		//	临时变量，会改为可配置项
		int breakfirstTimeFrom = 6;				//	早餐开始小时
		int breakfirstTimeTo = 9;				//	早餐结束小时
		int lanchTimeFrom = 11;					//	午餐开始小时
		int lanchTimeTo = 14;					//	午餐结束小时
		int dinnerTimeFrom = 17;				//	晚餐开始小时
		int dinnerTimeTo = 20;					//	晚餐结束小时
	   
		//	获取当前时间  
		Calendar cal = Calendar.getInstance();
		//	调到上个月  
		cal.add(Calendar.MONTH, -1);
		
        SimpleDateFormat sdf = new SimpleDateFormat("MM"); 
        String strSdf = sdf.format(cal.getTime());
        
		prest.setString(1, strSdf);
		prest.setInt(2, breakfirstTimeFrom);
		prest.setInt(3, breakfirstTimeTo);
		prest.setInt(4, lanchTimeFrom);
		prest.setInt(5, lanchTimeTo);
		prest.setInt(6, dinnerTimeFrom);
		prest.setInt(7, dinnerTimeTo);
		 
		ResultSet rs = prest.executeQuery();
		int number = 0;

		if (rs.next()) {
			//	rs.getInt(2)为员工当日规定时间的消费记录，未消费、充值(消费记录为正数)，不计入补贴
			number = rs.getInt(1);
		}
		return number;		
	}	
	
	
	
	/**
	 * 通过查询出员工消费记录,按照补贴规则,一次性发放员工上月补贴
	 * 	   
	 * setExpend
	 * 
	 * @param		String strSysNo
	 * @return		Int    
	 * @throws		Exception 
	 * @Exception	异常对象    
	 * @since		CodingExample　
	 */
	public int setExpend() throws Exception{
		ArrayList<ExpendRecord> eList = new ArrayList<ExpendRecord>();
		ArrayList<ExpendRecord> expendList = new ArrayList<ExpendRecord>();
		ExpendRecord er = new ExpendRecord();
		ArrayList<ExpendRecordTotal> expendTotalList = new ArrayList<ExpendRecordTotal>();
		ExpendRecordTotal ert = new ExpendRecordTotal();
		Connection sqlcon = DataResource.getConnect(ConstantUtil.OneCardSERVERCONN);
		PreparedStatement prest = null;
		PreparedStatement prestPre = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		//获得sql server连接
		sqlcon.setAutoCommit(false);
		Integer CaluDate = Integer.valueOf(ResourceTools.getStaticDataResource("CaluDate"));
		Date dateNow = new Date();
		Calendar ca=Calendar.getInstance();
		ca.setTime(new Date());
		if(ca.getTime().getMonth() == CaluDate)
		{
			return 0;
		}
		
		try {
			ResourceTools.writeData("CaluDate", (((CaluDate+1)%12==0)?12:(CaluDate+1)%12) +"");
			String sql = " SELECT ic.SysNo,DealMoney,EmplyName,DptName,ic.Dealdate,ic.DptId FROM pb_Icanteen as ic " +
						 " LEFT JOIN pb_depart as dp ON " +
						 " ic.Dptid = dp.DptId " +
						 " LEFT JOIN pb_emply as em ON " +
						 " ic.SysNo = em.SysNo " +
						 " WHERE " +
						 " DealMoney < 0 and em.IsDeleted = 0 and dp.IsDeleted = 0 and" +
						 " ic.Dptid in ('5','6','7','8','9','10','11','12','14') and " +
						 " DateName (MONTH, Dealdate) = ? and " +
						 " ((left(CONVERT(varchar(100), Dealdate, 8),2) >= ? and left(CONVERT(varchar(100), Dealdate, 8),2) < ?) or " +
						 " (left(CONVERT(varchar(100), Dealdate, 8),2) >= ? and left(CONVERT(varchar(100), Dealdate, 8),2) < ?) or " +
						 " (left(CONVERT(varchar(100), Dealdate, 8),2) >= ? and left(CONVERT(varchar(100), Dealdate, 8),2) < ?))";

			prest = sqlcon.prepareStatement(sql + " order by ic.SysNo,ic.Dealdate" ,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			//	临时变量，会改为可配置项
			Integer breakfirstTimeFrom = 6;			//	早餐开始小时
			Integer breakfirstTimeTo = 9;				//	早餐结束小时
			Integer lanchTimeFrom = 12;				//	午餐开始小时
			Integer lanchTimeTo = 15;					//	午餐结束小时
			Integer dinnerTimeFrom = 17;				//	晚餐开始小时
			Integer dinnerTimeTo = 19;					//	晚餐结束小时
			int subsidiesBreakFirst = 5;				//	早餐补贴金额
			int subsidiesLanch = 15;					//	午餐补贴金额
			int subsidiesDinner = 10;					//	晚餐补贴金额
			Integer workMealtime = 0;						//  工作餐次数
			//	获取当前时间  
			Calendar cal = Calendar.getInstance();
			//	调到上个月  
			cal.add(Calendar.MONTH, -1);
			
	        SimpleDateFormat sdf = new SimpleDateFormat("MM"); 
	        String strSdf = sdf.format(cal.getTime());
		   
			prest.setString(1, strSdf);
	        prest.setInt(2, breakfirstTimeFrom);
			prest.setInt(3, breakfirstTimeTo);
			prest.setInt(4, lanchTimeFrom);
			prest.setInt(5, lanchTimeTo);
			prest.setInt(6, dinnerTimeFrom);
			prest.setInt(7, dinnerTimeTo);
			
			ResultSet rs = prest.executeQuery();
			
			Integer state = 0;
			int departMentId = 0;			//	部门ID
			String departMentName="";		//	部门名称
			String sysNo = "";				//	员工证件号
			String employName = "";			//	员工姓名
			Date dealDate;				//	消费日期
			Integer subsidies = 0;				//	补贴金额
			Integer mealSeq = 0;         //1 早饭   5  2午饭  15   3晚饭 10
			Integer mealLeftbreakfirst = 0;        // 早饭是否已打卡
			Integer mealLeftlanch = 0;        // 午饭是否已打卡
			Integer mealLeftdinner = 0;        //晚饭 是否已打卡
			Date dateDay = new Date() ;
			
			String sqlPre = " select Recordid,Dptid,pb_Icanteen.SysNo,Serial,'C' as  AppType,'pb_06' as OpType," +
				"Dealdate,DealMoney,Balance,IcanOrder,DeviceSysid "+
				",isnull(Oper,'00'),isnull(CardType,'') from ocs_udplz.dbo.pb_Icanteen inner join " +
				"( SELECT  distinct SysNo,MAX(Recordid) as  msxid  FROM ocs_udplz.dbo.pb_Icanteen " + 
				 "  where Serial <> '' and Serial is not null   group by SysNo ) a   on a.msxid = pb_Icanteen.Recordid  order by pb_Icanteen.SysNo";

			prestPre = sqlcon.prepareStatement(sqlPre + "" ,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rsPre = prestPre.executeQuery();
			
			while(rsPre.next())
			{
				er = new ExpendRecord();
				er.setRecordid(rsPre.getInt(1));
				er.setDepartMentId(rsPre.getInt(2));
				er.setSysNo(rsPre.getString(3));
				er.setSerial(rsPre.getString(4));
				er.setAppType(rsPre.getString(5));
				er.setOpType(rsPre.getString(6));
				er.setDealDate(DateUtil.getDate(rsPre.getString(7),"yyyy-MM-dd HH:mm:ss"));
				er.setDealMoney(rsPre.getInt(8));
				er.setBalance(rsPre.getInt(9));
				er.setIcanOrder(rsPre.getInt(10));
				er.setDeviceSysid(rsPre.getInt(11));
				er.setOper(rsPre.getString(12)==null?"":rsPre.getString(12));
				er.setCardType(rsPre.getString(13)==null?"":rsPre.getString(13));
				eList.add(er);
			}
			
			while (rs.next()) {
				
				if(rs.getString(1).equals("000014"))
				{
					String a="";
				}
				if(sysNo.trim().equals("") || !sysNo.equals(rs.getString(1)))
				{
					if(sysNo.trim().equals(""))
					{
						workMealtime = 0;
						mealLeftbreakfirst = 0;        // 早饭是否已打卡
						mealLeftlanch = 0;        // 午饭是否已打卡
						mealLeftdinner = 0;        //晚饭 是否已打卡
						sysNo = rs.getString(1);
						departMentName= rs.getString(4);
						departMentId = rs.getInt(6);
						employName = rs.getString(3);
						dealDate = DateUtil.getDate(rs.getString(5),"yyyy-MM-dd HH:mm:ss");
						dateDay = DateUtil.getDate(rs.getString(5),"yyyy-MM-dd");
						subsidies = 0;
						if(dealDate.getHours()>=breakfirstTimeFrom && dealDate.getHours() < breakfirstTimeTo){
								subsidies = subsidiesBreakFirst;
								mealLeftbreakfirst = 1;
						}
						else if(dealDate.getHours()>=lanchTimeFrom && dealDate.getHours() < lanchTimeTo){
							subsidies = subsidiesLanch;
							mealLeftlanch = 1;
						}
						else if(dealDate.getHours()>=dinnerTimeFrom && dealDate.getHours() < dinnerTimeTo){
							subsidies = subsidiesDinner;
							mealLeftdinner = 1;
						}
						workMealtime += 1;
					}
					else 
					{
						ert = new ExpendRecordTotal();
						ert.setDepartMentId(departMentId);
						ert.setDepartMentName(departMentName);
						ert.setEmployName(employName);
						ert.setSubsidies(subsidies);
						ert.setSysNo(sysNo);
						workMealtime = 0;
						expendTotalList.add(ert);
						mealLeftbreakfirst = 0;        // 早饭是否已打卡
						mealLeftlanch = 0;        // 午饭是否已打卡
						mealLeftdinner = 0;        //晚饭 是否已打卡
						sysNo = rs.getString(1);
						departMentName= rs.getString(4);
						departMentId = rs.getInt(6);
						employName = rs.getString(3);
						dealDate = DateUtil.getDate(rs.getString(5),"yyyy-MM-dd HH:mm:ss");
						dateDay = DateUtil.getDate(rs.getString(5),"yyyy-MM-dd");
						subsidies = 0;
						if(dealDate.getHours()>=breakfirstTimeFrom && dealDate.getHours() < breakfirstTimeTo){
								subsidies = subsidiesBreakFirst;
								mealLeftbreakfirst = 1;
						}
						else if(dealDate.getHours()>=lanchTimeFrom && dealDate.getHours() < lanchTimeTo){
							subsidies = subsidiesLanch;
							mealLeftlanch = 1;
						}
						else if(dealDate.getHours()>=dinnerTimeFrom && dealDate.getHours() < dinnerTimeTo){
							subsidies = subsidiesDinner;
							mealLeftdinner = 1;
						}
						workMealtime += 1;
					}
				}
				
				else 
				{
					sysNo = rs.getString(1);
					departMentName= rs.getString(2);
					departMentId = rs.getInt(6);
					employName = rs.getString(3);
					dealDate = DateUtil.getDate(rs.getString(5),"yyyy-MM-dd HH:mm:ss");
					if(!dateDay.toString().equals(DateUtil.getDate(rs.getString(5),"yyyy-MM-dd").toString()) ){
						mealLeftbreakfirst = 0;        // 早饭是否已打卡
						mealLeftlanch = 0;        // 午饭是否已打卡
						mealLeftdinner = 0;        //晚饭 是否已打卡
					}
					dateDay = DateUtil.getDate(rs.getString(5),"yyyy-MM-dd");
					
					if(dealDate.getHours()>=breakfirstTimeFrom && dealDate.getHours() < breakfirstTimeTo){
						if(mealLeftbreakfirst == 0)
						{
							subsidies += subsidiesBreakFirst;
							mealLeftbreakfirst = 1;
						}
					}
					else if(dealDate.getHours()>=lanchTimeFrom && dealDate.getHours() < lanchTimeTo){
						if(mealLeftlanch==0)
						{
							subsidies += subsidiesLanch;
							mealLeftlanch = 1;
						}
						
					}
					else if(dealDate.getHours()>=dinnerTimeFrom && dealDate.getHours() < dinnerTimeTo){
						if(mealLeftdinner == 0)
						{
							subsidies += subsidiesDinner;
							mealLeftdinner = 1;
						}
					}
					workMealtime += 1;
				}
				
			}
			ert = new ExpendRecordTotal();
			ert.setDepartMentId(departMentId);
			ert.setDepartMentName(departMentName);
			ert.setEmployName(employName);
			ert.setSubsidies(subsidies);
			ert.setSysNo(sysNo);
			ert.setWorkMeal(workMealtime);
			expendTotalList.add(ert);
			
			Statement st=sqlcon.createStatement();
			ExpendRecordTotal etmp;
			ca.set(ca.getTime().getYear()+1900, ca.getTime().getMonth(), 1);
			ca.add(Calendar.DAY_OF_YEAR, -1);
			String sqlAll="insert into pb_balance_bak(sysNo,deptId,dealMoney,balence)"+
			 " (select  SysNo,Dptid,DealMoney,Balance from pb_Icanteen pic where Dealdate > '" +(ca.getTime().getYear()+1900) + "-"
			 + ((ca.getTime().getMonth()+1)<10?"0" + (ca.getTime().getMonth()+1):(ca.getTime().getMonth()+1)) + "-" +
			 ((ca.getTime().getDate())<10?"0" + (ca.getTime().getDate()):(ca.getTime().getDate())) + "')";
			st.executeUpdate(sqlAll);
			sqlcon.commit();
			for(int j = 0;j<expendTotalList.size();j++)
			{
				
				etmp = expendTotalList.get(j);
				
				for(int k=0;k<eList.size();k++)
				{
					er = eList.get(k);
					if(er.getSysNo().trim().equals(etmp.getSysNo()))
					{
						eList.remove(er);
						break;
					}
				}
				
				  String sql1="update pb_balance set BigBag ='" +0.00+"', LitBag='" + Integer.valueOf(er.getBalance())
				  + "',Subsidy='" + etmp.getSubsidies()+
				  "',WorkMeal='" + etmp.getWorkMeal() + "',CanUpdate='" + 0+"',SubUpdate='" + 3+"' where SysNo ='" + etmp.getSysNo() + "'";
					  
//					  "insert into pb_balance (SysNo, BigBag,LitBag,Subsidy,WorkMeal,CanUpdate,SubUpdate) values('"
//					  +etmp.getSysNo()+"','"+0.00+"','"+0.00+"','"+etmp.getSubsidies()+"','"+etmp.getWorkMeal()+"','"+0+"','"+ 3 + "')";
				  st.executeUpdate(sql1);
				  
				  String sql2="insert into pb_BillBook (dptid,SysNo, Serial,AppType,OpType,Realin,Cardcost,Deposit,JoinCost,Operatorid,Dealdate) values('"
					  +etmp.getDepartMentId()+"','"+etmp.getSysNo()+"','"+er.getSerial()+"','"+er.getAppType()+"','"+er.getOpType()+"','"+etmp.getSubsidies()
					  +"','"+ 0.00+"','"+0.00+"','"+0.00+"','"+"SessionId" +"','"+formatter.format(new Date()) + "')";
				  st.executeUpdate(sql2);
				  
				  String sql3="insert into pb_Icanteen (dptid,SysNo, Serial,AppType,OpType," +
				  		"DealMoney,Balance,IcanOrder,DeviceSysid,Oper,CardType,Dealdate) values('"
					  +etmp.getDepartMentId()+"','"+etmp.getSysNo()+"','"+er.getSerial()+"','"+er.getAppType()+"','"+er.getOpType()+"','"
					  +etmp.getSubsidies()+"','"+(Integer.valueOf(etmp.getSubsidies()) + Integer.valueOf(er.getBalance()))+"','"+(er.getIcanOrder() + 1)+"','"+er.getDeviceSysid()
					  +"','"+er.getOper()+ "','"+ er.getCardType() + "','" + formatter.format(new Date()) + "')";
				  st.executeUpdate(sql3);
				  
				  String sql4="insert into pb_balance_bak (sysNo,deptId, dealMoney,balence) values('"
				  +etmp.getSysNo()+"','"+er.getDepartMentId()+"','"+etmp.getSubsidies()+
				  	"','"+(Integer.valueOf(etmp.getSubsidies()) + Integer.valueOf(er.getBalance()))+ "')";
				  st.executeUpdate(sql4);
			  
				  sqlcon.commit();
			}
			st.close();
//				//int returnValue = 0;
//				int expendTemp = 0;
//				if(null != eList && eList.size() > 0){
//					for(int i = 0;i < eList.size();i++){
//						ExpendRecord er = new ExpendRecord();
//						String idTemp = "";
//						if(i == 0){
//							idTemp = eList.get(i).getSysNo();
//							expendTemp += eList.get(i).getDealMoney();
//							continue;
//						}
//						if(eList.get(i).getSysNo().equals(eList.get(i - 1).getSysNo())){
//							idTemp = eList.get(i).getSysNo();
//							expendTemp += eList.get(i).getDealMoney();
//						} else {
//							er.setSysNo(idTemp);
//							er.setDealMoney(expendTemp);
//							expendTemp = 0;
//						}
//						expendList.add(er);
//					}
//					
//				}
			
			return 1;
		} catch (Exception e) {
			sqlcon.rollback();
			// TODO: handle exception
			return 2;
		}
		
		
	}
	
	public int getInfoDate(ResultSetIterator rsi){
		
		return 0;
	}
	
	
	//	test main
	 
	public static void main(String[] args)   {
				
		ExpendRecordServiceImpl impl = new ExpendRecordServiceImpl();
		try {
			int count = impl.getExpendRecordNumber(null, null);
			//System.out.println(count);
			int pageCount = 1;//从页面取得页码 
			pageCount = Integer.parseInt("10");
			Page page = new Page(count, pageCount); 
			impl.getExpendRecord(null, null, page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<ExpendRecord> getLastBalenceinfo() throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ArrayList<ExpendRecord> list = new ArrayList<ExpendRecord>();
		//	立方数据库连接
    	Connection sqlcon = DataResource.getConnect(ConstantUtil.OneCardSERVERCONN);
		PreparedStatement prest = null;
		//获得sql server连接
		sqlcon.setAutoCommit(false);
		Calendar ca=Calendar.getInstance();
		ca.setTime(new Date());
		String sql = " SELECT ba.sysNo,em.EmplyName,de.DptName,updateTime,dealMoney,balence,em.Serial,dealTime,dealTotal,MissDealTime,MissDealTotal,Moneyleft"+
		  " FROM pb_balance_bak ba inner join dbo.pb_depart de  on ba.deptId = de.DptId"+
		  " inner join dbo.pb_emply em on ba.sysNo  = em.SysNo where em.EmplyType = 'A' and em.IsDeleted = '0' and" +// ca.getTime().getMonth();
		  " YEAR(ba.updateTime) ="+ (ca.getTime().getYear()+1900) +  
		  " and MONTH(ba.updateTime) = "+ (ca.getTime().getMonth()+1);
		prest = sqlcon.prepareStatement(sql  ,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

		ResultSet rs = prest.executeQuery();
		
		while (rs.next()) {
			ExpendRecord er = new ExpendRecord();
			//	设置消费金额
			er.setDealMoney(rs.getInt(5));
			//	设置员工姓名
			er.setEmployName(rs.getString(2));
			//	设置部门名称
			er.setDepartMentName(rs.getString(3));
			//	设置消费时间
			er.setDealDate_s(formatter.format((DateUtil.getDate(rs.getString(4),"yyyy-MM-dd"))));
			//	
			er.setBalance(rs.getInt(6));

			er.setSerial(rs.getString(7));
			
			er.setDealTime(rs.getInt(8));
			
			er.setDealTotal(rs.getInt(9));
			
			er.setMissDealTime(rs.getInt(10));
			
			er.setMissDealTotal(rs.getInt(11));
			
			er.setSysNo(rs.getString(1));
			
			er.setMoneyLeft(rs.getInt(12));
			list.add(er);
		}
		return list;
	}
}
