package com.freshen.system.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.entity.OrderDetail;
import com.freshen.entity.system.Sequence;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;
import com.freshen.util.StringTools;

public class SystemSequenceServiceImpl extends ClimsServiceBase implements IsystemSequenceService{

	public String getPK(String business_s, Session session) {
		String pkstr  = "";
		int number =0;
		Calendar calendar = Calendar.getInstance();
		Sequence sequence = new Sequence();
		//得到该表标识在sequence表中记录
		sequence=(Sequence)session.get(sequence.getClass(), business_s);
		
		if(sequence!=null&&sequence.getBusiness_s()!=null){
			//月的第一天，序列号从新开始
			if(calendar.get(Calendar.DAY_OF_MONTH)==1&&!DateUtil.dateToString(calendar.getTime(),"yyyyMM").equals(sequence.getResaveds2_s())){
				pkstr = business_s+DateUtil.dateToString(calendar.getTime(),"yyyyMM")+sequence.getSeed_i();
				sequence.setPresent_i(sequence.getSeed_i());		
				sequence.setIndexNumber_i(sequence.getSeed_i()+1);
				sequence.setResaveds2_s(DateUtil.dateToString(calendar.getTime(),"yyyyMM"));
			}else{
				pkstr = business_s+DateUtil.dateToString(calendar.getTime(),"yyyyMM")+sequence.getIndexNumber_i();
				sequence.setPresent_i(sequence.getIndexNumber_i());
				sequence.setIndexNumber_i(sequence.getIndexNumber_i()+1);
			}
			//System.out.println("pp="+sequence.getPresent_i());
			//System.out.println("ii="+sequence.getIndexNumber_i());
			//System.out.println("rr="+sequence.getResaveds2_s());
			session.update(sequence);
		}else{
			sequence = new Sequence();
			Hashtable h = ConstantUtil.BusinessHashTable;
			sequence.setResaveds1_s(String.valueOf(ConstantUtil.BusinessHashTable.get(business_s)));
			sequence.setBusiness_s(business_s);
			sequence.setIndexNumber_i(ConstantUtil.seed_i+1);
			sequence.setPrefixion_s(business_s);
			sequence.setPresent_i(ConstantUtil.seed_i);
			sequence.setSeed_i(ConstantUtil.seed_i);	
			sequence.setResaveds2_s(DateUtil.dateToString(calendar.getTime(),"yyyyMM"));
			pkstr  = business_s+DateUtil.dateToString(calendar.getTime(),"yyyyMM")+ConstantUtil.seed_i;
			session.save(sequence);
		}
	
		session.flush();
		return pkstr;
	}

	public static void main(String arg[]){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		IsystemSequenceService systemSequenceServiceImpl  = new SystemSequenceServiceImpl();
		String pk = systemSequenceServiceImpl.getPK("YFF", session);
		//System.out.println(pk);
		pk = systemSequenceServiceImpl.getPK("YFF", session);
		//System.out.println(pk);
		tx.commit();
	}
}
