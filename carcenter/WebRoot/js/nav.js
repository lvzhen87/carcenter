// 导航栏配置文件
var outlookbar=new outlook();
var t;
//tab1 二级导航
t=outlookbar.addtitle('客户管理','客户管理',1)
//	yepeng add start
outlookbar.additem('客户注册',t,'./checkregister/registCustomer.jsp')
//	yepeng add end
//	yepeng del start
//outlookbar.additem('注册审核',t,'./preorderInitAction')
//	yepeng del end
outlookbar.additem('企业信息管理',t,'./registerCustomerSearchAction')
outlookbar.additem('企业人员管理',t,'./searchcustomeruserAction')



//tab2 二级导航a
t=outlookbar.addtitle('预约管理','预约管理',1)
//alert($("#authorStr").val());
outlookbar.additem('待分配试验',t,'./distrubuteOrderAction')
outlookbar.additem('审核试验',t,'./searchOrdersAction')
//	yepeng del start
//outlookbar.additem('道路占用查询',t,'./roadOccupationAction')
//	yepeng del end
//outlookbar.additem('车间占用查询',t,'./wokshopOccupationAction')

//	yepeng Del Start
//tab2 二级导航b
//t=outlookbar.addtitle('试验管理','试验管理',1)
//outlookbar.additem('今日接待试验',t,'./searchMyOrderAction')
//outlookbar.additem('已确认试验',t,'./searchMyOrderAction')
//outlookbar.additem('进行中试验',t,'./searchMyOrderAction')
//outlookbar.additem('已结束试验',t,'./searchMyOrderAction')
//outlookbar.additem('已结算试验',t,'./searchMyOrderAction')
//outlookbar.additem('试验查询',t,'./searchMyOrderAction')
//	yepeng Del End


//tab3 二级导航a
t=outlookbar.addtitle('接待管理','接待管理',1)
outlookbar.additem('今日试验接待',t,'./receptExpAction')
outlookbar.additem('已接待试验',t,'./recepExperienceAction');
//outlookbar.additem('进场人员信息核对',t,'./intoMemberInfoCheckAction');
//outlookbar.additem('对讲机发放',t,'./recExperiencephoneAction');

//	yepeng del Start
//outlookbar.additem('添加客户人员',t,'./prepareAddCustomerUserAction')
//outlookbar.additem('添加驾驶员',t,'./prepareAddDriverInfoAction')
//	yepeng del End
//sharonyshi
//outlookbar.additem('车辆信息查询',t,'./prepareSearchVehicleInfoAction')
//outlookbar.additem('驾驶员查询',t,'./driverInfoAction')
//outlookbar.additem('卡片信息查询',t,'./cardSearchAction')
//outlookbar.additem('随行人员查询',t,'./presearchEntourageInfoAction')
//outlookbar.additem('驾驶员培训',t,'./#')
//sharonyshi

//tab4 二级导航a
t=outlookbar.addtitle('信息管理','信息管理',1)
outlookbar.additem('组织架构管理',t,"./initTreeAction?time=new Date().getTime()")
outlookbar.additem('职员管理',t,'./searchemployeeInfoAction')
outlookbar.additem('权限管理',t,'./searchPostAction')
outlookbar.additem('道闸管理',t,'./searchbarrierAction')
outlookbar.additem('道路管理',t,'./searchroadAction')
outlookbar.additem('道路单周状态管理',t,'./searchBasisRoadweekstatusinfo')
outlookbar.additem('车间管理',t,'./searchworkshopAction')
outlookbar.additem('对讲机管理',t,'./initinterphoneAction')
//outlookbar.additem('客户人员管理',t,'./searchcustomeruserAction')
//outlookbar.additem('驾驶员信息管理',t,'./searchdriverInfoAction')
outlookbar.additem('驾驶员培训规则管理',t,"./searchTrainruleAction")
outlookbar.additem('退订规则管理',t,"./searchunRuleAction")
outlookbar.additem('预订时间规则管理',t,"./searchTimeruleAction")
outlookbar.additem('道路精确预订规则管理',t,"./searchRuleAction")
outlookbar.additem('发放补贴查询',t,'./expendRecordAction')
outlookbar.additem('常量信息管理',t,'./ConstantInfoAction')
outlookbar.additem('其他费用管理',t,'./initChargeAction')
outlookbar.additem('门禁管理',t,'./initDoorinfoAction')
outlookbar.additem('试验场管理信息',t,'./catarcManageAction')
outlookbar.additem('补贴设置',t,'./getsubsidiesinfoAction')
outlookbar.additem('修改密码',t,'./basismanage/changepwd.jsp')

//tab4 二级导航a
t=outlookbar.addtitle('场内管理','场内管理',1)
outlookbar.additem('订单修改',t,'./searchRecorderAction')
outlookbar.additem('订单查询',t,'./searchRecorderShowAction')
outlookbar.additem('在场人员查询',t,'./searchRecuserShowAction')
outlookbar.additem('车辆通过查询',t,'./searchVeRecordShowAction')
outlookbar.additem('订单道路查询',t,'./searchprocessorderAction')
outlookbar.additem('车辆超时查询',t,'./searchOvertimeAction')
outlookbar.additem('对讲机记录查询',t,'./searchinterphoneAction')
outlookbar.additem('对讲机发放与回收',t,'./recExperiencephoneAction')
outlookbar.additem('公卡管理',t,'./initStaticOVAction')
outlookbar.additem('洗车信息查询',t,'./ground/washcar.jsp')
outlookbar.additem('道路使用率查询',t,'./roadstaticticstatistic')

//	yepeng del start
//outlookbar.additem('道路占用查询',t,'./groundroadOccupationAction')
//outlookbar.additem('道路/车间占用状态设置',t,'./setOccupationalAction')
//	yepeng del end
//tab6 收费管理  by freshen
t=outlookbar.addtitle('订单核算','订单核算',1)
outlookbar.additem('费用核算',t,'./initOrderCostAction?states=-1')
outlookbar.additem('费用调整',t,'./searchOrderCostAction?type=1&states=-1')
outlookbar.additem('道路使用量确认清单',t,'./searchPeriodCostAction')
outlookbar.additem('手工录入费用信息',t,'./initHandcraftAction')


//tab4 二级导航a
//t=outlookbar.addtitle('过程管理','过程管理',1)
//outlookbar.additem('出入道路查询',t,'./searchprocessorderAction')
//outlookbar.additem('对讲机过程查询',t,'./searchinterphoneAction')
//outlookbar.additem('对讲机回收',t,'./process/callbackinterphone.jsp')