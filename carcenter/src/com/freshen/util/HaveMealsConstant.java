package com.freshen.util;

/**
 * 
 * 用餐相关常量    
 * 项目名称：carcenter    
 * 类名称：HaveMealsConstant    
 * 类描述：    
 * 创建人：kxc    
 * 创建时间：2014-11-23 上午11:19:48    
 * 修改人：kxc    
 * 修改时间：2014-11-23 上午11:19:48    
 * 修改备注：    
 * @version     
 *
 */
public class HaveMealsConstant {

	public final static String breakfastFinal = "B";  //早餐段
	public final static String breakfastStartTiem = "6"; //早餐开始时间
	public final static String breakfastEndTiem = "9"; //早餐结束时间
	
	public final static String lunchFinal = "L"; //午餐段
	public final static String lunchStartTiem = "11"; //午餐开始时间
	public final static String lunchEndTiem = "14"; //午餐结束时间
	
	public final static String supperFinal = "S"; //晚餐段
	public final static String supperStartTiem = "17"; //晚餐开始时间
	public final static String supperEndTiem = "20"; //晚餐结束时间
	
	public final static String deviceSysid ="'29', '40'"; //对应消费机id
	
	public final static int singleLimit = 12; //单人额度，总额除以单人额度的商为人次
	
	public final static int lowerLimit  = 3; //下限额度，不超过该额度不计算人数
}
