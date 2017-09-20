package com.freshen.util;
 

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2003-8-8
 * Time: 15:11:55
 */
public class NumTools
{
	private final static DecimalFormat nf = new DecimalFormat("###,##0.00");
    private final static DecimalFormat nf4 = new DecimalFormat("###,##0.0000");
    //  利息的格式
    private final static DecimalFormat intFormat = new DecimalFormat("#0.00000");
    //  金额的格式
    private final static DecimalFormat numFormat = new DecimalFormat("#0.00");
    //  结存的格式
    private final static DecimalFormat sumFormat = new DecimalFormat("###,##0");
    //  显示金额数量的格式
    private final static DecimalFormat sumShowFormat = new DecimalFormat("##0.##");
    /**
     * 判断两个double型是否相等
     * @param a
     * @param b
     * @return  相等时返回 true,不等时返回 false
     */
    public static boolean isEquals(double a, double b)
    {
        if (Math.abs(a - b) < 0.0001)
        {
            return true;
        }
        else
            return false;
    }
    /**
     * 判断double型和BigDecimal是否相等
     * @param a
     * @param b
     * @return  相等时返回 true,不等时返回 false
     */
    public static boolean isEquals(BigDecimal a, double b)
    {
        BigDecimal bDecimal = new BigDecimal(b);
        if (a.compareTo(bDecimal) == 0)
        {
            return true;
        }
        else
            return false;
    }
    /**
     *补零 add by delia
     * length:(补零后的长度)
     * patchNum:(要补零的数)
     * @param length
     * @param patchNum
     * @return
     */
    public static String patchZero(int length, String patchNum)
    {
        NumberFormat format = NumberFormat.getInstance();
        format.setMinimumIntegerDigits(length);
        format.setMaximumIntegerDigits(length);
        format.setGroupingUsed(false);
        String backStr = format.format(Integer.parseInt(patchNum));
        return backStr;
    }
    /**
     * 去字符串中的逗号 为空时返回0.00
     * @param money
     * @return
     */
    public static String moneyToNumber(String money)
    {
        if (money == null || money.trim().equals(""))
            return "0.00";
        StringTokenizer stoken = new StringTokenizer(money, ",");
        String number = "";
        while (stoken.hasMoreTokens())
        {
            number += stoken.nextToken();
        }
        return number;
    }
    /**
     * 将文字转化为货币形式
     * @param s
     * @return
     */
    public static String formatToMoney(String s)
    {
        if (s == null || s.equals(""))
        {
            return "0.00";
        }
        try
        {
            return formatToMoney(Double.parseDouble(s));
        }
        catch (Exception e)
        {
            return s;
        }
    }
    //999999.9999
    public static String formatToMoneyDot4(String s)
    {
        if (s == null || s.equals(""))
        {
            return "0.00";
        }
        try
        {
            return formatToMoneyDot4(Double.parseDouble(s));
        }
        catch (Exception e)
        {
            return s;
        }
    }
    /**
     * 将double型转换成金额式
     * @param d
     * @return
     */
    public static String formatToMoney(double d)
    {
        try
        {
            return nf.format(d);
        }
        catch (Exception e)
        {
            return String.valueOf(d);
        }
    }
    /**
     * 将double型转换成金额式
     * @param d
     * @return
     */
    public static String formatToMoneyDot4(double d)
    {
        try
        {
            return nf4.format(d);
        }
        catch (Exception e)
        {
            return String.valueOf(d);
        }
    }
    /**
     * 将double型转换成显示格式
     * @param d
     * @return
     */
    public static String formatToShow(double d)
    {
        try
        {
            return sumShowFormat.format(d);
        }
        catch (Exception e)
        {
            return String.valueOf(d);
        }
    }
    /**
     * 将double型转换为7.5格式
     * @param d
     * @return
     */
    public static String formatToInterest(double d)
    {
        try
        {
            return intFormat.format(d);
        }
        catch (Exception e)
        {
            return String.valueOf(d);
        }
    }
    /**
     * 将double型转换成两位小数的普通数字格式
     * @param d
     * @return
     */
    public static String formatToNum(double d)
    {
        try
        {
            return numFormat.format(d);
        }
        catch (Exception e)
        {
            return String.valueOf(d);
        }
    }
    /**
     * 将int型转换成结存形式
     * @param sum
     * @return
     */
    public static String formatToSum(int sum)
    {
        try
        {
            return sumFormat.format(sum);
        }
        catch (Exception e)
        {
            return String.valueOf(sum);
        }
    }
    /**
     * dividend除以divisor,保留scale位，scale后一位只要不为0则进位
     * 例如：4除以3保留5位第六位只要不为0则进位 ：divide(4,3,5)
     * @param dividend 被除数
     * @param divisor  除数
     * @param scale    保留几位
     * @return
     */
    public static double divide(double dividend,double divisor,int scale)
    {
        double addend = 1 / Double.parseDouble(divideAssis(scale + 1)) * 9;
        double tem = new BigDecimal(dividend).divide(new BigDecimal(divisor),scale+1,1).doubleValue();
        double one = 1;
        double result = new BigDecimal(tem + addend).divide(new BigDecimal(one),scale,1).doubleValue();

        return result;
    }
    private static String divideAssis(int index)
    {
        StringBuffer tem = new StringBuffer("1");
        for (int i = 0; i < index;i ++)
        {
            tem.append(new StringBuffer("0"));
        }

        return tem.toString();
    }
    //保留round位小数,四舍五入
    public static double getDouble(double value,int round){
//        double tV = value;
//        double dF = 1;
//        for(int i=0;i<round;i++){
//           tV = tV * 10;
//           dF = dF/10;
//        }
//        tV = tV * 10;
//        dF = dF/10;
//        int v = (int)(tV%10);
//        if(v==5){
//           value = value + dF;
//        }
        double v = 0;
        if(round == 1){
           v = ((value * 100)%10);
           if(v>4.999999 || v==5){
               value = value + 0.01;
           }
        }
        if(round == 2){
           v = ((value * 1000)%10);
           if(v> 4.99999 || v==5){
               value = value + 0.001;
           }
        }
        if(round == 3){
           v = ((value * 10000)%10);
           if(v>4.999999 || v==5){
               value = value + 0.0001;
           }
        }
        if(round == 4){
           v = ((value * 100000)%10);
           if(v>4.999999 || v==5){
               value = value + 0.00001;
           }
        }
        if(round == 5){
           v = ((value * 1000000)%10);
           if(v>4.999999 || v==5){
               value = value + 0.000001;
           }
        }
         NumberFormat   nf=NumberFormat.getInstance();
         nf.setMaximumFractionDigits(round);
         String sValue = nf.format(value);
         sValue = moneyToNumber(sValue);
         return Double.parseDouble(sValue);
    }

    /**
     * 判断是否为数字或小数      
     * isNumber 
     * @param   name    
     * @param  s    需判断的字符串
     *         b：true 可以为小数 false  不可以为小数
     * @return String    
     * @Exception 异常对象    
     * @since  CodingExample　Ver(编码范例查看) 1.1
     */
    public static boolean  isNumber(String s,boolean b )
    {
    	if(b){
	    	Pattern p = Pattern.compile("\\d+\\.?\\d*");
	    	Matcher m = p.matcher(s);
	    	return m.matches();
    	}else{
    		Pattern p = Pattern.compile("\\d+\\d*");
	    	Matcher m = p.matcher(s);
	    	return m.matches();
    	}

    }

    public static void main(String[] a){
    	Boolean b =NumTools.isNumber("1",false);
    	//System.out.println(b);
    }

    /**
     * 二进制转十六进制
     * binaryString2hexString 
     * @param   name    
     * @param  @return    
     * @return String    
     * @Exception    
     */
    public static String binaryString2hexString(String bString)  
    {  
    	if(bString.length()<8)
    	{
    		bString = "0000" + bString;
    	}
        if (bString == null || bString.equals("") || bString.length() % 8 != 0)  
            return null;  
        StringBuffer tmp = new StringBuffer();  
        int iTmp = 0;  
        for (int i = 0; i < bString.length(); i += 4)  
        {  
            iTmp = 0;  
            for (int j = 0; j < 4; j++)  
            {  
                iTmp += Integer.parseInt(bString.substring(i + j, i + j + 1)) << (4 - j - 1);  
            }  
            tmp.append(Integer.toHexString(iTmp));  
        }  
        return tmp.toString().toUpperCase();  
    }  

}
