package com.freshen.util;

import java.util.Hashtable;



/**
 * 
 * 保存常量    
 * 项目名称：carcenter    
 * 类名称：ConstantUtil    
 * 类描述：    
 * 创建人：kxc    
 * 创建时间：2014-3-31 下午03:21:46    
 * 修改人：kxc    
 * 修改时间：2014-3-31 下午03:21:46    
 * 修改备注：    
 * @version     
 *
 */
public class ConstantUtil {

	//系统名称
	public final static String Project_name = "clims";
	//订单状态
	public final static int orderStatus_1 = 1;
	public final static int orderStatus_2 = 2;
	public final static int orderStatus_3 = 3;
	public final static int orderStatus_4 = 4;
	public final static int orderStatus_5 = 5;
	public final static int orderStatus_6 = 6;
	public final static int orderStatus_7 = 7;
	public final static int orderStatus_8 = 8;
	
	public final static Hashtable orderStatusHashTable = new Hashtable(); 
	static { 
		orderStatusHashTable.put(orderStatus_1, "预订未确认");
		orderStatusHashTable.put(orderStatus_2, "预订已确认");
		orderStatusHashTable.put(orderStatus_3, "预订取消");
		orderStatusHashTable.put(orderStatus_4, "预订冲突");
		orderStatusHashTable.put(orderStatus_5, "已进场");
		orderStatusHashTable.put(orderStatus_6, "试验进行中");
		orderStatusHashTable.put(orderStatus_7, "试验结束");
		orderStatusHashTable.put(orderStatus_8, "订单已结算");
	}
	
	//子订单状态
	public final static int subitemOrderStatus_0 = 0;
	public final static int subitemOrderStatus_1 = 1;
	public final static int subitemOrderStatus_2 = 2;
	public final static Hashtable subitemOrderStatusHashTable = new Hashtable(); 
	static { 
		subitemOrderStatusHashTable.put(subitemOrderStatus_0, "初始");
		subitemOrderStatusHashTable.put(subitemOrderStatus_1, "已确认");
		subitemOrderStatusHashTable.put(subitemOrderStatus_2, "冲突");
	}
	
	//客户信息状态
	public final static int customerStatus_0 = 0;
	public final static int customerStatus_1 = 1;
	public final static int customerStatus_2 = 2;
	public final static Hashtable subitemCustomerStatusHashTable = new Hashtable(); 
	static { 
		subitemCustomerStatusHashTable.put(customerStatus_0, "未通过");
		subitemCustomerStatusHashTable.put(customerStatus_1, "提交");
		subitemCustomerStatusHashTable.put(customerStatus_2, "已通过");
	}
	//客户审核邮件信息
	public final static String customerCheck_Subject = "客户注册审核";
	public final static String orderCheck_Subject = "预约订单审核";
	
	//当为pagingNot时表示不分页
	public final static int  pagingNot = -1;
	//分页默认条数
	public final static int  pageSize = 15;
	//sequence的种子
	public final static int  seed_i = 1000;
	//业务代码
	public final static String  RYBusiness = "RY";
	public final static String  KHBusiness = "KH";
	public final static String  DDBusiness = "DD";
	public final static String  KKBusiness = "kk";
	public final static String  JSYBusiness = "JSY";
	public final static String  DLSYLXBusiness = "DLSYLX";
	public final static String  SUBCPGBusiness = "SCPG";
	public final static String  SUBCPGBBAKusiness = "SCPGBAK";
	public final static String  ZGBusiness = "ZG";
	public final static String  DJJBusiness = "DJJ";
	public final static String  DJBusiness = "DJ";
	public final static String  SYCBusiness = "SYC";
	public final static String  JSYCPGBusiness = "JSYCPG";
	public final static String  ZDDBusiness = "ZDD";
	public final static String  DLBusiness = "DL";
	public final static String  GCBusiness = "GC";
	public final static String  SQBusiness = "SQ";
	public final static String  KXXBusiness = "KXX";
	public final static String  SBZYBusiness = "SBZY";
	public final static String  BJBusiness = "BJ";
	public final static String  CCBusiness = "CC";
	public final static String  GXCSBusiness = "GXCS";
	public final static String  BCYDBusiness = "BCYD";
	public final static String  YFFBusiness = "YFF";
	public final static String  ProcessBusiness = "PB";
	public final static String  CardCancellationsiness = "CAN";
	public final static String  Processsiness = "PRO";
	public final static String  UnSubscibeBusiness = "UNS";
	public final static String  TimeBusiness = "TIME";
	public final static String  MJUBusiness = "MJU";
	public final static String  DLFYBusiness = "DLFY";
	public final static String  QTFYBusiness = "QTFY";
	public final static String  USBusiness = "US";
	public final static String  HCBusiness = "HC";	
	public final static String  DZBusiness = "DZ";	
	public final static String  IOBBusiness = "IOB"; //过站信息
	public final static String  CLBusiness = "CL";//常量
	
	//业务代码对应业务名称
	public final static Hashtable BusinessHashTable = new Hashtable(); 
	static { 
		BusinessHashTable.put(RYBusiness, "人员信息表");
		BusinessHashTable.put(KHBusiness, "客户信息表");
		BusinessHashTable.put(DDBusiness, "订单表");
		BusinessHashTable.put(KKBusiness, "测试表");	
		BusinessHashTable.put(JSYBusiness, "驾驶员信息表");
		BusinessHashTable.put(DLSYLXBusiness, "道路试验类型基础信息表");
		BusinessHashTable.put(SUBCPGBusiness, "订单车辆信息表");
		BusinessHashTable.put(SUBCPGBBAKusiness, "订单车辆信息备份表");
		BusinessHashTable.put(ZGBusiness, "职工信息表");
		BusinessHashTable.put(DJJBusiness, "对讲机信息表");
		BusinessHashTable.put(DJBusiness, "道闸信息表");
		BusinessHashTable.put(SYCBusiness, "试验场信息表");
		BusinessHashTable.put(JSYCPGBusiness, "驾驶员许可信息表");
		BusinessHashTable.put(ZDDBusiness, "子订单信息表");
		BusinessHashTable.put(DLBusiness, "道路信息表");
		BusinessHashTable.put(GCBusiness, "工厂信息表");
		BusinessHashTable.put(SQBusiness, "授权信息表");
		BusinessHashTable.put(KXXBusiness, "卡信息表");
		BusinessHashTable.put(SBZYBusiness, "设备占用信息表");
		BusinessHashTable.put(BJBusiness, "车卡权限信息表");
		BusinessHashTable.put(CCBusiness, "车卡权限作废信息");
		BusinessHashTable.put(GXCSBusiness, "共享测试道路信息表");
		BusinessHashTable.put(BCYDBusiness, "包场预定信息表");
		BusinessHashTable.put(YFFBusiness, "预付费信息表");
		BusinessHashTable.put(ProcessBusiness, "对讲机过程管理表");
		BusinessHashTable.put(CardCancellationsiness, "车卡权限作废信息");
		BusinessHashTable.put(Processsiness, "进出设施信息表");
		BusinessHashTable.put(UnSubscibeBusiness, "退订信息表");
		BusinessHashTable.put(TimeBusiness, "预定时间规则信息表");
		BusinessHashTable.put(MJUBusiness, "登记用户表");
		BusinessHashTable.put(DLFYBusiness, "道路费用信息表");
		BusinessHashTable.put(QTFYBusiness, "其他费用信息表");
		BusinessHashTable.put(USBusiness, "订单退订费用信息表");
		BusinessHashTable.put(HCBusiness, "订单手工录入费用信息表");
		BusinessHashTable.put(DZBusiness, "道闸信息表");
		BusinessHashTable.put(IOBBusiness, "过站信息表");
		BusinessHashTable.put(CLBusiness, "常量信息表");
	}
	//卡类型
	public final static String cardType_1 = "1";
	public final static String cardType_2 = "2";
	public final static String cardType_3 = "3";
	public final static String cardType_4 = "4";
	public final static Hashtable cardTypeHashTable = new Hashtable(); 
	static { 
		cardTypeHashTable.put(cardType_1, "人卡");
		cardTypeHashTable.put(cardType_2, "车卡");
		cardTypeHashTable.put(cardType_3, "油卡");
		cardTypeHashTable.put(cardType_4, "对讲机");
	}
	
	//对讲机状态
	public final static int interphoneState_0 = 0;
	public final static int interphoneState_1 = 1;
	public final static int interphoneState_2 = 2;
	public final static int interphoneState_3 = 3;

	public final static Hashtable interphoneStateHashTable = new Hashtable(); 
	static { 
		interphoneStateHashTable.put(interphoneState_0, "故障");
		interphoneStateHashTable.put(interphoneState_1, "使用中");
		interphoneStateHashTable.put(interphoneState_2, "闲置");
		interphoneStateHashTable.put(interphoneState_3, "停用");

	}

	//对应对讲机操作
	public final static int interphoneOperation_0 = 0;
	public final static int interphoneOperation_1 = 1;
	public final static int interphoneOperation_2 = 2;

	public final static Hashtable interphoneOperationHashTable = new Hashtable(); 
	static { 
		interphoneOperationHashTable.put(interphoneOperation_0, "报修");
		interphoneOperationHashTable.put(interphoneOperation_1, "发放");
		interphoneOperationHashTable.put(interphoneOperation_2, "归还");
	}
	
	//预订使用类型
	public final static String orderRoadType_0 = "0";
	public final static String orderRoadType_1 = "1";
	public final static Hashtable orderRoadTypeHashTable = new Hashtable(); 
	static { 
		orderRoadTypeHashTable.put(orderRoadType_0, "共享");
		orderRoadTypeHashTable.put(orderRoadType_1, "专用");
	}	
	
	//驾驶员培训时间条件
	public final static int TrainDay = 365;
	
	//接待人员类别
	public final static int userType_1 = 1;
	public final static int userType_2 = 2;
	public final static int userType_3 = 3;
	public final static Hashtable userTypeHashTable = new Hashtable(); 
	static { 
		userTypeHashTable.put(userType_1, "客户负责人");
		userTypeHashTable.put(userType_2, "陪同人员");
		userTypeHashTable.put(userType_3, "驾驶员");
	}
	
	//道闸状态
	public final static int barrierStatus_0 = 0;
	public final static int barrierStatus_1 = 1;
	public final static Hashtable barrierStatusHashTable = new Hashtable(); 
	static { 
		barrierStatusHashTable.put(barrierStatus_0, "故障");
		barrierStatusHashTable.put(barrierStatus_1, "启用");
	}
	
	//计费方式
	public final static int billingMode_1 = 1;
	public final static int billingMode_2 = 2;
	public final static Hashtable billingModeHashTable = new Hashtable(); 
	static { 
		billingModeHashTable.put(billingMode_1, "按时间计费");
		billingModeHashTable.put(billingMode_2, "按里程计费");
	}
	
	//包场费用
	public final static double price_1 = 1.0;
	public final static double price_0 = 0.0;
	public final static int serverprice_0=0;
	public final static Hashtable priceHashTable = new Hashtable(); 
	static { 
		priceHashTable.put(price_1, "包场计费");
		priceHashTable.put(price_0, "包场计费");
		priceHashTable.put(serverprice_0, "服务管理费每月每平米");
	}
	
	public final static int beginningday=1;
	public final static Hashtable dayHashTable = new Hashtable(); 
	static { 
		dayHashTable.put(beginningday, "最少预订天数");
		
	}
	//办公车间默认平米数
	public final static double m2 =0.0;
	public final static Hashtable m2HashTable = new Hashtable(); 
	static { 
		m2HashTable.put(m2, "车间平米数");
		
	}
	

	//connction连接标识
	public final static String BarrierSERVERCONN = "0"; //道闸系统
	public final static String OneCardSERVERCONN = "2"; //立方系统
	
	//组织架构对象类型 //1:部门 2：岗位 3：员工  4根结点
	public final static int organizationType_1 = 1;
	public final static int organizationType_2 = 2;
	public final static int organizationType_3 = 3;
	public final static int organizationType_4 = 4;
	public final static Hashtable organizationTypeHashTable = new Hashtable(); 
	static { 
		organizationTypeHashTable.put(organizationType_1, "部门");
		organizationTypeHashTable.put(organizationType_2, "岗位");
		organizationTypeHashTable.put(organizationType_3, "员工");
		organizationTypeHashTable.put(organizationType_4, "根结点");
	}
	//组织架构树根节点序号
	public final static String organizationRoot = "00";
	//组织架构树节点序号的开始序号
	public final static String organizationStart = "01";
	//组织架构对象编号的种类代码
	public final static String organizationDept = "Dept";  
	public final static String organizationPost = "Post";
	public final static String organizationEmp = "Emp";
	public final static Hashtable organizationHashTable = new Hashtable(); 
	static { 
		organizationTypeHashTable.put(organizationDept, "部门");
		organizationTypeHashTable.put(organizationPost, "岗位");		
		organizationTypeHashTable.put(organizationEmp, "职员");	
	}
	
	//登记门号
	public final static String DoorCode_prefix = "0000";
	
	//客户发卡，选择部门的值
	public final static Integer LONGTIMECOUSUMERDEPT = 16;  
	public final static Integer SHOURTIMECOUSUMERDEPT = 17;
	public final static Hashtable COUSUMERDEPTTable = new Hashtable(); 
	static { 
		COUSUMERDEPTTable.put(LONGTIMECOUSUMERDEPT, "试验客户");
		COUSUMERDEPTTable.put(SHOURTIMECOUSUMERDEPT, "临时用卡人员");		
	}
	
	//一卡通客户类型
	public final static String ONECARDUUSERTYPE01 = "A";
	public final static String ONECARDUUSERTYPE02 = "E";
	public final static Hashtable ONECARDUUSERTYPETable = new Hashtable(); 
	static { 
		COUSUMERDEPTTable.put(ONECARDUUSERTYPE01, "职员");
		COUSUMERDEPTTable.put(ONECARDUUSERTYPE02, "试验客户");		
	}
	
	//收费类型
	public final static String COSTTYPE01 = "车间使用";
	public final static String COSTTYPE02 = "共享道路";
	public final static String COSTTYPE03 = "精确预约道路"; 
	public final static String COSTTYPE04 = "包场预约道路";
	public final static String COSTTYPE05 = "电费";
	public final static String COSTTYPE06 = "电话费";
	public final static String COSTTYPE07 = "技工费";
	public final static String COSTTYPE08 = "管理费";
	public final static String COSTTYPE09 = "洗车费";
	
	//默认密码
	public final static String PASSWORDCONSTANT = "000000";
	
	//道闸权限生效时间延迟秒数
	public final static int EFFECTIVETIMEDEFER = 5;
	
	//公卡orderid
	public final static String ORDERIDFinal = "order01";
	
	//车辆进出状态
	public final static String MONTIOS01 = "1";
	public final static String MONTIOS02 = "2";
	public final static Hashtable MONTIOSMappingTable = new Hashtable(); 
	static { 
		MONTIOSMappingTable.put(MONTIOS01, "入");
		MONTIOSMappingTable.put(MONTIOS02, "出");		
	}
	
}
