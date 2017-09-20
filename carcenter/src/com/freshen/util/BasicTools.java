package com.freshen.util;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;

import com.freshen.clims.baseclass.BeanModel;
import com.freshen.entity.reception.CardInfo;
import com.freshen.entity.reception.ReceptionVehicleInfo;

public class BasicTools {

	/**
	 * 判断集合是否为null	   
	 * isnotNull 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public static boolean  isnotNull(List list){	
		if(list==null||list.size()==0){
			return false;
		}else{
			Object o = list.get(0);
			return BeanModel.isnotNull(o);
		}	 
	}
	
	/**
	 * 生成随机数
	 * @return
	 */
	public static int getRandom(){
		long t = System.currentTimeMillis();//获得当前时间的毫秒数

        Random rd = new Random(t);//作为种子数传入到Random的构造器中

        //System.out.println(rd.nextInt(100));//生成随即整数
        return rd.nextInt(1000);
	}
	public static void main(String[] a){
		/*String deleteVehicles = "asd,Ierd,I";
		//分解要删除的车辆信息
		if(deleteVehicles != null && deleteVehicles.length() > 0){
			deleteVehicles = deleteVehicles.replaceAll("I","");
			String del[]=deleteVehicles.split(",");
			for (int j = 0; j < del.length; j++) {
				String info[] = del[j].split(",");
				//为删除reception-vehicleInfo表
				ReceptionVehicleInfo deleteVehicle=new ReceptionVehicleInfo();
			 
			}
		}*/
		int s = BasicTools.getRandom();
		System.out.println("s===="+s);
	}
}
