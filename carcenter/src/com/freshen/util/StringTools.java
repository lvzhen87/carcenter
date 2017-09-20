package com.freshen.util;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.UnsupportedEncodingException;

/**
 * Created by IntelliJ IDEA.
 * Author: James
 * Date: 2004-4-27
 * Time: 10:52:04
 * Function: 
 */
public class StringTools
{
   
    /**
     * 将字符串按照分隔符分割成字符串数组
     * @param str       --  要分割的字符串
     * @param delim     --  分隔符
     * @return          --  分割后的字符串数组
     */
    public static String[] split(String str, String delim)
    {
        
            return delim.split(str);
    }
    
    /**
     * 将期数数组转换为 '1|1!2|1!2|1'
     * @param times
     * @return
     */
    public static  String print(String[] times){
         String subtimes = "";
         try
         {
            if(times!=null){
                for(int i=0;i<times.length;i++){
                    String tem[] = StringTools.split(times[i],"!!");
                    String tem1 = tem[0];
                    String tem2 = tem[1];
                    if(i>0){
                        subtimes = subtimes+"!";
                    }
                    subtimes = subtimes+tem[0]+"|"+tem[1];
                }
            }

            return subtimes;
         }catch(Exception e){
             return subtimes;
          }
    }

    /**
     * 判断子串在主串出现的次数
     * @param str
     * @param substr
     * @return
     */
    public static  int subStringNumber(String str,String substr){
         int number = 0;
         try
         {
            if(str!=null){
                for(int i=0;i<str.length();i++){
                    if(!(i+substr.length()>str.length())){
                        if(str.substring(i,substr.length()).equals(substr)){
                            number++;
                        }
                    }
                }
            }

            return number;
         }catch(Exception e){
             return number;
          }
    }

    public static String convertToGBK(String s)
    {
        String convertString = "";
        try {
            convertString = new String(s.toString().getBytes("ISO-8859-1"), "gbk");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return convertString;
    }
    
    /**
     * 
       
     * fillString 填充字符串
     * @param   str    原字符串
     *          fillStr 填充字符串
     *          places  填充到几位
     * @param  @return    设定文件    
     * @return String    
     * @Exception 异常对象    
     * @since  CodingExample　Ver(编码范例查看) 1.1
     */
    public static String fillString(String str,String fillStr,int places)
    {
        if(str==null)
        {
        	return str;
        }
        if(str.length()<places){
        	while(true){
        		str = fillStr+str;
        		 if(str.length()>=places){
        			 return str;
        		 }
        	}
        }
        return str;
    }
    /**
     * 将集合按照指定连接符拼接
     * jointString 
     * @param   name    
     * @param  @return    设定文件    
     * @return String    
     * @Exception 异常对象    
     * @since  CodingExample　Ver(编码范例查看) 1.1
     */
    public static String jointString(Object str,String joint){
    	String request = "";
    	if(str.getClass()==String[].class){
    		String[] strtmp = (String[])str;
    		for(int i=0;i<strtmp.length;i++){
    			if(i==0){
    				request = strtmp[i];
    			}else{
    				request = request+joint;
    				request = request+strtmp[i];
    			}    			
    		}
    	}else if(str.getClass()==List.class||str.getClass()==ArrayList.class){
    		List strtmp = (List)str;
    		for(int i=0;i<strtmp.size();i++){
    			if(i==0){
    				request = String.valueOf(strtmp.get(i));
    			}else{
    				request = request+joint;
    				request = request+String.valueOf(strtmp.get(i));
    			}    			
    		}
    	}
    	return request;
    }
    
    /**
     * 将字符串某部分转换为大写       
     * getstrUpperCase 
     * @param   str 原字符串 start 开始位置 end结束位置    
     * @param  @return    设定文件    
     * @return String    
     * @Exception 异常对象    
     * @since  CodingExample　Ver(编码范例查看) 1.1
     */
    public static String getstrUpperCase(String str,int start,int end){
		 String strtmp1 = str.substring(0,start);
		 String strtmp2 = str.substring(start,end);
		 String strtmp3 = str.substring(end,str.length());
		 String newstrtmp = strtmp2.toUpperCase();
		 str = strtmp1+newstrtmp+strtmp3;
    	 return str;
    }
         

    /** 
     * 将字符串的指定位置替换成新的字符 
     * @param str 原字符串 
     * @param n 指定要替换的位数 
     * @param newChar 要替换的字符 
     * @return String 替换后的字符串 
     * @throws Throwable 
	 */ 
	public static String replace(String str,int n,String newChar) throws Exception{ 
		String s1=""; 
		String s2=""; 
		try{ 
		s1=str.substring(0,n-1); 
		s2=str.substring(n,str.length()); 
		}catch(Exception ex){ 
			throw new Exception("替换的位数大于字符串的位数"); 
		}
	    return s1+newChar+s2; 	    
    }

	public static String formatJson(String jsonStr) {
	    int level = 0;
	    StringBuffer jsonForMatStr = new StringBuffer();
	    for(int i=0;i<jsonStr.length();i++){
	      char c = jsonStr.charAt(i);
	      if(level>0&&'\n'==jsonForMatStr.charAt(jsonForMatStr.length()-1)){
	        jsonForMatStr.append(getLevelStr(level));
	      }
	      switch (c) {
	      case '{': 
	      case '[':
	        jsonForMatStr.append(c+"\n");
	        level++;
	        break;
	      case ',': 
	        jsonForMatStr.append(c+"\n");
	        break;
	      case '}':
	      case ']':
	        jsonForMatStr.append("\n");
	        level--;
	        jsonForMatStr.append(getLevelStr(level));
	        jsonForMatStr.append(c);
	        break;
	      default:
	        jsonForMatStr.append(c);
	        break;
	      }
	    }
	    
	    return jsonForMatStr.toString();

	  }
	  
	  private static String getLevelStr(int level){
	    StringBuffer levelStr = new StringBuffer();
	    for(int levelI = 0;levelI<level ; levelI++){
	      levelStr.append("\t");
	    }
	    return levelStr.toString();
	  }

    public static void main(String[] a){
    	String jsonStr = "{\"id\" : \"Post702\" , \"value\" : \"保安队员\"},{\"id\" : \"Post703\" , \"value\" : \"安保消防科科长\"}";
        String fotmatStr = StringTools.formatJson(jsonStr);
//    		fotmatStr = fotmatStr.replaceAll("\n", "<br/>");
//    		fotmatStr = fotmatStr.replaceAll("\t", "    ");
        System.out.println(fotmatStr);

    	//System.out.println(s); 
    }
}
