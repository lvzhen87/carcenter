package com.freshen.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 *     
 * 项目名称：capg    
 * 类名称：DateUtil    
 * 类描述：    
 * 创建人：Administrator    
 * 创建时间：2014-3-27 上午10:14:01    
 * 修改人：Administrator    
 * 修改时间：2014-3-27 上午10:14:01    
 * 修改备注：    
 * @version     
 *
 */
public class DateUtil {
	/**
	 * 
	   
	 * getDateSequenceStr 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public static String getDateSequenceStr(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
		return sdf.format(new Date());
	}
	
	public static String getCurrentDateAsString(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
	public static Date getCurrentDate(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		try {
			date =sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 *  Function:
	 *  @author sharonyshi  DateTime 2014-8-1 下午03:33:34
	 *  @param dateStr 需要转型成 Date的 字符串
	 *  @param fmt	转型格式
	 *  @return
	 */
	public static Date strToDate(String dateStr,String fmt){
		SimpleDateFormat sdf=new SimpleDateFormat(fmt);
		Date date=null;
		try {
			date= sdf.parse(dateStr);
		} catch (ParseException e) {
			//System.out.println("DateUtil类中  strToDate方法 将字符串转型为date时 出错！请检查 fmt字符串的格式");
		}
		return date;
	}
	
	/**
	 * 
	   
	 * getDate 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public static Date getDate(String dateStr){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		try {
			date= sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * getDate 
	 * @param   dateStr待转换的 日期字符串
	 * @param datefmt 日期字符串的格式，需要与 日期字符串 匹配
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public static Date getDate(String dateStr,String datefmt){
		SimpleDateFormat sdf=new SimpleDateFormat(datefmt);
		Date date=new Date();
		try {
			date= sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * getDate 
	 * @param dateStr 转型成字符串的格式串
	 * @param date 转型成字符串的 日期
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public static String getDate(Date date ,String dateStr){
		String ds=null;
		SimpleDateFormat sdf=new SimpleDateFormat(dateStr);
		ds =sdf.format(date);
		//date= sdf.parse(ds);
		return ds;
	}
	

	
	

	/**
     * 一天的毫秒数
     */
    static final long mselPerDay = 3600 * 24 * 1000;

    /**
     * 将输入的yyyymmdd格式的字符串转换成Date型
     * @param strDate
     * @return  转换好的日期型
     * @throws TrustException
     */
    public static Date stringToDate(String strDate) throws Exception
    {
        try
        {
            Date renDate;
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            df.setLenient(false);

            if (strDate == null || strDate.trim().equals(""))
                return null;
            renDate = df.parse(strDate);

            return renDate;
        }
        catch (ParseException e)
        {
            throw new Exception(e.getMessage());
        }
    }
    public static Date stringToDate1(String strDate) throws Exception
    {
        try
        {
            Date renDate;
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            df.setLenient(false);

            if (strDate == null || strDate.trim().equals(""))
                return null;
            renDate = df.parse(strDate);

            return renDate;
        }
        catch (ParseException e)
        {
            throw new Exception(e.getMessage());
        }
    }

    public static Date stringToDateformat(String strDate,String format) throws Exception
    {
        try
        {
            Date renDate;
            DateFormat df = new SimpleDateFormat(format);
            df.setLenient(false);

            if (strDate == null || strDate.trim().equals(""))
                return null;
            renDate = df.parse(strDate);

            return renDate;
        }
        catch (ParseException e)
        {
            throw new Exception(e.getMessage());
        }
    }
    

     /**
     * 将输入的Date型转换成format格式的字符串
     * @param strDate
     * @return 格式为format的字符串
     */
    public static String dateToString(Date strDate,String format)
    {
        String renStr;
        DateFormat df = new SimpleDateFormat(format);
        df.setLenient(false);

        if (strDate == null)
            return "";
        renStr = df.format(strDate);

        return renStr;
    }
    /**
     * 将输入的日期串加一个月份后输出 （intMon -- 格式为yyyymm）
     * @param intMon
     * @return 格式为yyyymmdd的字符串
     * @throws Exception
     */
    public static String getNextMonth(String intMon) throws Exception
    {
        Calendar monDate = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("yyyyMM");
        String nextMonth = "";
        try
        {
            df.setLenient(false);
            monDate.setTime(df.parse(intMon));

            monDate.roll(monDate.MONTH, true);
            nextMonth = dateToString(monDate.getTime(),"yyyyMMdd");
            if ("01".equals(nextMonth.substring(4, 6)))
            {
                monDate.roll(monDate.YEAR, true);
                nextMonth = dateToString(monDate.getTime(),"yyyyMMdd");
            }
            nextMonth = nextMonth.substring(0, 6);

            return nextMonth;
        }
        catch (ParseException e)
        {
            throw new Exception(e.getMessage());
        }
    }
    
    /**
     * 得到输入年月的最后一天的日期（intMon -- 格式为yyyymm）
     * @param intMon
     * @return 格式为yyyymmdd的String
     * @throws Exception
     */
    public static String getMonLastDay(String intMon) throws Exception
    {
        Calendar monDate = Calendar.getInstance();
        String beforeDate = "";

        monDate.setTime(stringToDate(intMon + "01"));
        monDate.roll(monDate.DATE, false);
        beforeDate = dateToString(monDate.getTime(),"yyyyMMdd");

        return beforeDate;
    }
    /**
     * 取得传入日期的下一天
     * @param date
     * @return 返回下一天的Date型
     */
    public static Date getNextDay(Date date)
    {
        return new Date(date.getTime() + mselPerDay);
    }
    /**
     * 取得传入日期的上一天
     * @param date
     * @return 返回上一天的Date型
     */
    public static Date getYesterday(Date date)
    {
        return new Date(date.getTime() - mselPerDay);
    }
    /**
     * 获取当前时段为上午还是下午 add by lue
     * @return
     * @throws DaoException
     */
    public static int getSection() throws Exception
    {

        Date date = new Date();
        DateFormat df = new SimpleDateFormat("HHmmss");
        String curTime = df.format(date);
        long curNum = (new Long(curTime)).longValue();
        long strNum = 120000;
        if (curNum <= strNum)
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }
    /**
     * 得到传入日期的日子（如：传入20030210，则传出10）
     * @param date
     * @return int型日期
     */
    public static int getDay(Date date)
    {
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        return cale.get(Calendar.DAY_OF_MONTH);
    }
    /**
     * 得到传入日期的月份（如：传入20030210，则传出2）
     * @param date
     * @return int型月份
     */
    public static int getMonth(Date date)
    {
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        return cale.get(Calendar.MONTH) + 1;
    }
    /**
     * 得到输入日期的年份
     * @param date
     * @return int型月份
     */
    public static int getYear(Date date)
    {
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        return cale.get(Calendar.YEAR);
    }
    /**
     * 得到输入日期是星期几
     * 周日返回“7”
     * 周一返回“1”
     * 周二返回“2”
     * 周三返回“3”
     * 周四返回“4”
     * 周五返回“5”
     * 周六返回“6”
     * @param date
     * @return int型周几
     */
    public static int getWeekDay(Date date)
    {
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        int weekDay = cale.get(Calendar.DAY_OF_WEEK)-1;
        int newWeekDay = weekDay;
        if (weekDay == 0)
            newWeekDay = 7;
        return newWeekDay;
    }
    /**
     * 得到输入日期是星期几
     * 周日返回“7”
     * 周一返回“1”
     * 周二返回“2”
     * 周三返回“3”
     * 周四返回“4”
     * 周五返回“5”
     * 周六返回“6”
     * @param date
     * @return
     */
    public static int getWeekDay(String date)
    {
        try
        {
            Calendar cale = Calendar.getInstance();
            cale.setTime(stringToDate(date));
            int weekDay = cale.get(Calendar.DAY_OF_WEEK)-1;
            int newWeekDay = weekDay;
            if (weekDay == 0)
                newWeekDay = 7;
            return newWeekDay;
        }
        catch (Exception e)
        {
            return 0;
        }
    }
    /**
     * 根据传进来的日期求出该日期的当月一号
     * @param d
     * @return yyyyMMdd型的字符串
     */
    public static String getFirstDayOfOneMonth(Date d)
    {
        return formatDate(d, "yyyyMM01");
    }

    /**
     * 得到 informix7.x 当前数据库时间
     * @return Date型当前的数据库时间
     * @throws DaoException
     */
    public static Date getCurDBDate() throws Exception
    {
        return new Date();

    }
    /**
     * 取得工资费用控制信息中的当前工资月份
     * @return
     * @throws DaoException
     * @throws Exception
     */
   /* public static String getWageCurMon() throws DaoException,Exception
    {
        DaoManager daoManager = DaoConfig.getConfiguredDaoManager();
        WageCtlInfoDao dao = (WageCtlInfoDao) daoManager.getDao("WageCtlInfo");
        String mon = "";
        try
        {
            WageCtlInfoModel wageCtlInfoModel = dao.doSelect();
            if(wageCtlInfoModel == null || wageCtlInfoModel.getWageCurMon() == null || "".equals(wageCtlInfoModel.getWageCurMon().trim())){
                throw new Exception("工资费用控制信息中没有当前工资月份！");
            }
            mon = wageCtlInfoModel.getWageCurMon();
        }
        catch (DaoException e)
        {
            throw new DaoException(e.getMessage());
        }catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
        return mon;
        }*/
    /**
     * 得到系统日期的月份
     * @return
     * @throws DaoException
     */
    public static String getCurDBMonth() throws Exception{
        Date dbDate = getCurDBDate();
        return dateToString(dbDate,"yyyyMMdd").substring(0,6);
    }
    /**
     * 得到系统日期的年份
     * @return
     * @throws DaoException
     */
    public static String getCurDBYear() throws Exception{
        Date dbDate = getCurDBDate();
        return dateToString(dbDate,"yyyyMMdd").substring(0,4);
    }
   
    /**
     * 判断是否是月末
     * @param date
     * @return 布尔值（true -- 是月末 false -- 不是月末）
     */
    public static boolean isLastDayOfMonth(Date date)
    {
        boolean isLastDay = true;
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        int oldMonth = cale.get(Calendar.MONTH);
        cale.add(Calendar.DATE, 1);
        int newMonth = cale.get(Calendar.MONTH);
        if (oldMonth == newMonth)
            isLastDay = false;
        else
            isLastDay = true;
        return isLastDay;
    }
    /**
     * 判断是否是季度末
     * @param date
     * @return 布尔值（true -- 是季末 false -- 不是季末）
     */
    public static boolean isLastDayOfQuarter(Date date)
    {
        if (!isLastDayOfMonth(date))
        {
            return false;
        }
        else
        {
            Calendar cale = Calendar.getInstance();
            cale.setTime(date);
            int month = cale.get(Calendar.MONTH) + 1;
            if (month == 3 || month == 6 || month == 9 || month == 12)
                return true;
            else
                return false;
        }
    }
    /**
     * 判断是否是年末
     * @param date
     * @return  布尔值（true -- 是年末 false -- 不是年末）
     */
    public static boolean isLastDayOfYear(Date date)
    {
        boolean isLastDay = true;
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        int oldMonth = cale.get(Calendar.YEAR);
        cale.add(Calendar.DATE, 1);
        int newMonth = cale.get(Calendar.YEAR);
        if (oldMonth == newMonth)
            isLastDay = false;
        else
            isLastDay = true;
        return isLastDay;
    }
    /**
     * 两个时间是否跨月
     * @param date1
     * @param date2
     * @return 布尔值 （true -- 跨月 false -- 没有跨月）
     */
    public static boolean isSpanMonth(Date date1, Date date2)
    {
        Calendar cale = Calendar.getInstance();
        cale = Calendar.getInstance();
        cale.setTime(date1);
        int oldMonth = cale.get(Calendar.MONTH);
        cale.setTime(date2);
        int newMonth = cale.get(Calendar.MONTH);
        if (oldMonth != newMonth)
            return true;
        else
            return false;
    }
    /**
     * 判断是否为闰年
     * @param date
     * @return True : 是闰年 false : 是平年
     */
    public static boolean isLeapYear(Date date)
    {
        /*
        闰年是指那些年份可以被4整除的年份，
        有一个例外，就是如果一个年份可以被100整除，则只有当该年份能够被400整除，该年份才是闰年，
        如2000年是闰年，而1900年不是
        */
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        int year = cale.get(Calendar.YEAR);
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
            return true;
        else
            return false;
    }
    

    /**
     * 为字符串加入分隔符 add by luke
     * @param date
     * @param delim
     * @return
     */
    public static String dateFormat(String date, String delim)
    {
        if (date == null && date.equals(""))
        {
            return "";
        }
        else
            return date.substring(0, 4) + delim + date.substring(4, 6) + delim + date.substring(6, 8);
    }
    /**
     * 根据需要格式化日期型（如：pattern 为 "yyyy年MM月dd日"）
     * @param date
     * @param pattern
     * @return 格式化之后的String
     */
    public static String formatDate(Date date, String pattern)
    {
        if (date == null)
            return "";
        if (pattern == null || "".equals(pattern))
            pattern = "yyyy-MM-dd";
        DateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }
    /**
     * 按照默认的pattern（yyyy年MM月dd日）格式化日期型
     * @param date
     * @return
     */
    public static String formatDate(Date date)
    {
        String pattern = "yyyy-MM-dd";
        return formatDate(date, pattern);
    }

    /**
     * 按照默认的pattern（yyyy年MM月dd日）格式化日期型
     * @param date
     * @return
     */
    public static String formatDate1(Date date)
    {
        String pattern = "yyyyMMdd";
        return formatDate(date, pattern);
    }
    
    /**
     * 计算两个时间的间隔小时数(按自然日计算)
     *  
     * @param date1
     * @param date2
     * @return 间隔小时数
     */
    public static int countDistanceHourNum(Date date1, Date date2)
    {
        Long result = new Long(Math.abs(date1.getTime() - date2.getTime()));
        //System.out.println(result);
        Long diffHours = result / (60 * 60 * 1000) / 24;
          diffHours = (result/(60*60*1000) );
        return diffHours.intValue();
    }
    
    /**
     * 计算两个时间的间隔天数(按自然日计算)
     * 例如：2004.1.1 与 2004.1.4之间间隔2天
     * @param date1
     * @param date2
     * @return 间隔天数
     */
    public static int countDistanceDayNum(Date date1, Date date2)
    {
        Long result = new Long(Math.abs(date1.getTime() - date2.getTime()));
        Long dayNum = new Long(result.longValue() / mselPerDay - 1);
        return dayNum.intValue();
    }
    /**
     * 计算两个时间的间隔天数(按自然日计算)
     * 例如：2004.1.1 与 2004.1.4之间差3天
     * @param date1
     * @param date2
     * @return 天数差
     */
    public static int countNatureDayNum(Date date1, Date date2)
    {
        Long result = new Long(Math.abs(date1.getTime() - date2.getTime()));
        Long dayNum = new Long(result.longValue() / mselPerDay);
        return dayNum.intValue()+1;
    }
    /**
     * 计算两个日期的间隔天数（非自然日的），每月按30天算，一年360天
     * @param pDate 日期型
     * @param nDate 日期型
     * @return
     *   如果返回值>=0则  返回值为间隔天数
     *   如果返回值=-1则  则错误，起始日期大于截止日期
     */
    public static int countUnNatureDayNum(Date pDate, Date nDate) throws Exception
    {
        int dayNum = 0;
        String pDateStr = dateToString(pDate,"yyyyMMdd");
        String nDateStr = dateToString(nDate,"yyyyMMdd");
        dayNum = countUnNatureDayNum (pDateStr, nDateStr);
        return dayNum ;
    }
    /**
     * 计算两个日期的间隔天数（非自然日的），每月按30天算，一年360天
     * @param pDateStr 字符型 格式yyyymmdd
     * @param nDateStr 字符型 格式yyyymmdd
     * @return
     *   如果返回值>=0则  返回值为间隔天数
     *   如果返回值=-1则  则错误，起始日期大于截止日期
     * @throws Exception
     */
    public static int countUnNatureDayNum(String pDateStr, String nDateStr) throws Exception
    {
        Date pDate = stringToDate(pDateStr);
        Date nDate = stringToDate(nDateStr);

        if (pDate.compareTo(nDate) > 0){
            return -1;
        }
        int pYear = Integer.parseInt(pDateStr.substring(0,4));
        int nYear = Integer.parseInt(nDateStr.substring(0,4));
        int pMonth = Integer.parseInt(pDateStr.substring(4,6));
        int nMonth = Integer.parseInt(nDateStr.substring(4,6));
        int pDay = Integer.parseInt(pDateStr.substring(6,8));
        int nDay = Integer.parseInt(nDateStr.substring(6,8));
        if (isLastDayOfMonth(pDate))
            pDay = 30;
        if (isLastDayOfMonth(nDate))
            nDay = 30;
        return (nYear - pYear) * 360 + (nMonth - pMonth) * 30 + (nDay - pDay);
    }
    /**
     * 两个日期之间相隔几个月
     * 比如： 2003-04-05 与 2003-05-04之间相差0个月
     * 比如： 2004-04-05 与 2003-05-04之间相差12个月
     * @param date1
     * @param date2
     * @return
     */
    public static int countDistanceMonNum(Date date1, Date date2)
    {
        int year1 = getYear(date1);
        int year2 = getYear(date2);
        int mon1 = getMonth(date1);
        int mon2 = getMonth(date2);
        if (year1 == year2)
            return Math.abs(mon1 - mon2 -1);
        else
        {
            if (year1 < year2)
            {
                return (12-mon1)+(year2-year1-1)*12+mon2 - 1;
            }
            else
            {
                return (12-mon2)+(year1-year2-1)*12+(mon1) - 1;
            }
        }
    }
    /**
     * 两个月份之间相隔几个月
     * 比如： 2003-04-05 与 2003-05-04之间相差0个月
     * 比如： 2004-04-05 与 2003-05-04之间相差12个月
     * @param year1
     * @param mon1
     * @param year2
     * @param mon2
     * @return
     */
    public static int countDistanceMonNum(int year1, int mon1, int year2, int mon2)
    {
        if (year1 == year2)
            return Math.abs(mon1 - mon2 -1);
        else
        {
            if (year1 < year2)
            {
                return (12-mon1)+(year2-year1-1)*12+mon2 - 1;
            }
            else
            {
                return (12-mon2)+(year1-year2-1)*12+(mon1) - 1;
            }
        }
    }
    /**
     * 将输入的日期多个月份后输出
     * @param intMon
     * @param mon
     * @return
     */
    public static Date getNextDouMonth(Date intMon, int mon)
    {
        Calendar monDate = Calendar.getInstance();
        monDate.setTime(intMon);
        monDate.setTime(intMon);
        monDate.add(Calendar.MONTH,mon);

        return monDate.getTime();
    }

    /**
     * 得到当前日期
     */
    public static String getCurrentDate_s(){
        Calendar c = Calendar.getInstance ();
        String year = String.valueOf ( c.get ( Calendar.YEAR ) );
        String month = String.valueOf ( c.get ( Calendar.MONTH ) + 1 );
        if(new Integer(month).intValue()<10){
            month = "0"+month;
        }
        String day = String.valueOf ( c.get ( Calendar.DATE ) );
        if(new Integer(day).intValue()<10){
            day = "0"+day;
        }
        return year+month+day;
    }
    
   

    /**
     * 将输入的Date型转换成yyyymmdd格式的字符串
     * @param strDate
     * @return 格式为yyyymmdd的字符串
     */
    public static String dateToString(Date strDate) {
        String renStr;
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        df.setLenient(false);

        if (strDate == null)
            return "";
        renStr = df.format(strDate);

        return renStr;
    }


    /**
     * 将输入的日期串减一个月份后输出 （intMon -- 格式为yyyymm）
     * @param intMon
     * @return 格式为yyyymm的串
     * @throws Exception
     */
    public static String getPreMonth(String intMon) throws Exception {
        Calendar monDate = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("yyyyMM");
        String preMonth = "";
        try {
            df.setLenient(false);
            monDate.setTime(df.parse(intMon));

            monDate.roll(monDate.MONTH, false);
            preMonth = dateToString(monDate.getTime());
            if ("12".equals(preMonth.substring(4, 6))) {
                monDate.roll(monDate.YEAR, false);
                preMonth = dateToString(monDate.getTime());
            }
            preMonth = preMonth.substring(0, 6);

            return preMonth;
        } catch (ParseException e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * 得到输入的日期的上一个月的最后一天
     * @param yyyymmdd  例如：20050301
     * @return 格式为yyyymmdd的串   例如：20050228
     * @throws Exception
     */
    public static String getMonUp(String yyyymmdd) throws Exception {
        try {
            String yyyymm = yyyymmdd.substring(0, 6);
            yyyymm = getPreMonth(yyyymm);
            return getMonLastDay(yyyymm);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * 得到输入的日期的上一年的最后一天
     * @param yyyymmdd
     * @return 格式为yyyymmdd的串
     * @throws Exception
     */
    public static String getYearUp(String yyyymmdd) throws Exception {
        try {
            String yyyy = yyyymmdd.substring(0, 4);
            int value = Integer.parseInt(yyyy);
            value = value - 1;
            return String.valueOf(value) + "1231";

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * 得到机器时间日期对象的年月日形式
     * @return 格式为2005年03月05日的串
     * @throws Exception
     */
    public static String getTodayString() throws Exception {
        try {
            String ymd = dateToString(new Date());
            ymd = ymd.substring(0, 4) + "年" + ymd.substring(4, 6) + "月" + ymd.substring(6) + "日";
            return ymd;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    

    /**
     * 判断是否是月末
     * @return 布尔值（true -- 是月末 false -- 不是月末）
     */
    public static boolean isLastDayOfMonthString(String ymd) {
        boolean isLastDay = true;
        try {
            Date date = stringToDate(ymd);

            Calendar cale = Calendar.getInstance();
            cale.setTime(date);
            int oldMonth = cale.get(Calendar.MONTH);
            cale.add(Calendar.DATE, 1);
            int newMonth = cale.get(Calendar.MONTH);
            if (oldMonth == newMonth)
                isLastDay = false;
            else
                isLastDay = true;
        } catch (Exception e) {
           //System.out.println("DateTools isLastDayOfMonthString is error");
        }

        return isLastDay;
    }
    


    /**
	 *  Function:在 指定的日期 加上一定的时间量，得到新的日期
	 *  @author Freshen  DateTime 2014-7-30 下午03:26:18
	 *  @param startDate 开始日期
	 *  @param type	时间量的单位，1表示增加多少天，2 月，3半年，4年
	 *  @param amount 时间量，与type参数配合，确定需要偏移的日期
	 *  @return 偏移后的日期
	 */
    public static Date addDate(Date date,int i) {
   
	     
	    
	     Calendar cld=Calendar.getInstance();	       
	     cld.setTime(date);	        
	     cld.add(Calendar.DATE, i);	   
	     //System.out.println(cld.getTime());
	     return cld.getTime();
    }

    /**
	 *  Function:在 指定的日期 加上一定的时间量，得到新的日期
	 *  @author Freshen  DateTime 2014-7-30 下午03:26:18
	 *  @param startDate 开始日期
	 *  @param type	时间量的单位，1表示增加多少天，2 月，3半年，4年,5 小时
	 *  @param amount 时间量，与type参数配合，确定需要偏移的日期
	 *  @return 偏移后的日期
	 */
	public static Date addDate(Date startDate,int type,int amount){
		Calendar c=Calendar.getInstance();
		c.setTime(startDate);
		switch(type){
		case 1:
			c.add(Calendar.DAY_OF_MONTH, amount);
			break;
		case 2:
			c.add(Calendar.MONTH, amount);
			break;
		case 3:
			c.add(Calendar.MONTH, amount*6);
			break;
		case 4:
			c.add(Calendar.YEAR, amount);
			break;
		case 5:
			c.add(Calendar.HOUR, amount);
			break;
		}
		return c.getTime();
	}
	
	public static int timeInterval(Date startDate,Date endDate){
		int days=0;
		
		/*DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		startDate = df.parse(startDate.toString());
		endDate =df.parse(endDate.toString());*/
		long beginTime = startDate.getTime(); 
		long endTime = endDate.getTime(); 
		days = (int) ((endTime - beginTime) / (1000 * 60 * 60 *24) + 0.5); 
		return days;
	}
	
	/**
	 * 将不标准的日期格式转化为标准日期格式	   
	 * dateStringTOstr 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public static String dateStringTOstr(String t){
		String s[] = t.split("/");
		if(s[0].length()<2){
			t = "0"+t;
		}
		if(s[1].length()<2){
			t=t.substring(0,3)+"0"+t.substring(3, t.length());
		}
		return t;
	}
	
    public static void main(String[] a){
    	String s = "2016-08-19";
    	Date d = DateUtil.getDate(s, "yyyy-MM-dd");
    	boolean b = d.before(new Date());
    	System.out.println(b); 
    }
    
}
