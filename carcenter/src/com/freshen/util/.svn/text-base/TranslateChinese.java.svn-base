package com.freshen.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;

public class TranslateChinese {
    private String pinyinName = "";
    
    /**
    * 汉字转拼音的方法
    * @param name 汉字
    * @return 拼音
    */
    private String HanyuToPinyin(String name){
    	int letterNum = 0;
    	String ReturnValue = "";
        char[] nameChar = name.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = 
                                           new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < nameChar.length; i++) {
            if (nameChar[i] > 128) {
            	letterNum= -1;
                try {
                    pinyinName = PinyinHelper.toHanyuPinyinStringArray
                                           (nameChar[i], defaultFormat)[0];
                    ReturnValue += pinyinName.substring(0,1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } 
            else
            {
            	if(letterNum != -1)
            	{
            		letterNum+=1;
            		if(letterNum == 6)
            		{
            			if(name.length()>6)
            			{
            				ReturnValue = name.substring(0,6);
            			}
            			else
            			{
            				ReturnValue = name.substring(0,name.length());
            			}
            		}
            	}
            }
        }
        return ReturnValue;
    }
 
    public static void main(String[] args) {
        //System.out.println(new TranslateChinese().HanyuToPinyin("等发大水"));
    }    
}
