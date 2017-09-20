package com.freshen.basis.action;

import java.util.ArrayList;
import java.util.List;

import com.freshen.entity.basis.OrganizationTree;

public class Treejson2 {

	String strjson="";
	ArrayList<TreeJson> jsonlist;
	
	public String jsonformat(List<OrganizationTree> otree){
		jsonlist =changetoTreejson(otree);
		
		
		strjson += "[";
		for (int i = 0; i < jsonlist.size(); i++) {
			if(jsonlist.get(i).getPid()==null){//没有父节点，说明是一级节点
				if(jsonlist.get(i).getOldId() == 4){
					strjson +="{";
					
					if(jsonlist.get(i).getOldId() == 1){
						strjson += "\"id\":\"" + "Dept" + jsonlist.get(i).getId() +"\",\"text\": \""+ jsonlist.get(i).getText()+"\"";
						strjson += ",\"iconCls\": \"icon-dept\"";
					}else if(jsonlist.get(i).getOldId() == 2){
						strjson += "\"id\":\"" + "Post" + jsonlist.get(i).getId() +"\",\"text\": \""+ jsonlist.get(i).getText()+"\"";
						strjson += ",\"iconCls\": \"icon-post\"";
					}else if(jsonlist.get(i).getOldId() == 3){
						strjson += "\"id\":\"" + "Em" + jsonlist.get(i).getId() +"\",\"text\": \""+ jsonlist.get(i).getText()+"\"";
						strjson += ",\"iconCls\": \"icon-employ\"";
					}else if (jsonlist.get(i).getOldId() == 4){
						strjson += "\"id\":\"" + "BM" + jsonlist.get(i).getId() +"\",\"text\": \""+ jsonlist.get(i).getText()+"\"";
						strjson += ",\"iconCls\": \"icon-employ\"";
					}
	//				int num=0;//记录孩子个数
					if(!jsonlist.get(i).getId().startsWith("RY"))
					{
						addChildren(jsonlist,jsonlist.get(i).getId());
					}
	//				for (int j = 0; j < jsonlist.size(); j++) {//循环遍历查找子节点
						
						
	//					if(jsonlist.get(j).getPid()!=null &&jsonlist.get(j).getPid().equals(jsonlist.get(i).getId())){
	//						num++;
	//						if(num==1){//说明第一次添加孩子节点
	//							strjson += ",\"children\":[{\"id\":\"" +jsonlist.get(j).getId() +"\",\"text\": \""+ jsonlist.get(j).getText()+ "\"}";
	//							
	//						}else{
	//							strjson +=",{";
	//							strjson += "\"id\":\"" +jsonlist.get(j).getId()+ "\",\"text\": \""+ jsonlist.get(j).getText()+ "\"}";
	//							
	//						}
	//						
	//					}
						
	//				}
	//				if(num >0){//说明有孩子节点
	//					strjson += "]";
	//				}
					strjson +="},";
				}
			}
		}
		
		strjson=strjson.substring(0, strjson.length() - 1); 
		strjson+="]";
		return strjson;
	}
	
	public void addChildren(ArrayList<TreeJson> jsonlist,String pid){
		int num=0;//记录孩子个数
		for (int j = 0; j < jsonlist.size(); j++) {//循环遍历查找子节点
			
			
			if(jsonlist.get(j).getPid()!=null &&jsonlist.get(j).getPid().equals(pid)){
				num++;
				if(num==1){//说明第一次添加孩子节点
					
					if(jsonlist.get(j).getOldId() == 1){
						strjson += ",\"children\":[{\"id\":\"" + "Dept" + jsonlist.get(j).getId() +"\",\"text\": \""+ jsonlist.get(j).getText()+"\"";
						strjson += ",\"iconCls\": \"icon-dept\"";
					}else if(jsonlist.get(j).getOldId() == 2){
						strjson += ",\"children\":[{\"id\":\"" + "Post" + jsonlist.get(j).getId() +"\",\"text\": \""+ jsonlist.get(j).getText()+"\"";
						strjson += ",\"iconCls\": \"icon-post\"";
					}else if(jsonlist.get(j).getOldId() == 3){
						strjson += ",\"children\":[{\"id\":\"" + "Em" +jsonlist.get(j).getId() +"\",\"text\": \""+ jsonlist.get(j).getText()+"\"";
						strjson += ",\"iconCls\": \"icon-employ\"";
					}
					if(jsonlist.get(j).getOldId() != 3)
					{
						addChildren(jsonlist,jsonlist.get(j).getId())	;
					}
					strjson += "}";
				}else{
					strjson +=",{";
					
					if(jsonlist.get(j).getOldId() == 1){
						strjson += "\"id\":\"" + "Dept" +jsonlist.get(j).getId()+ "\",\"text\": \""+ jsonlist.get(j).getText()+"\"";
						strjson += ",\"iconCls\": \"icon-dept\"";
					}else if(jsonlist.get(j).getOldId() == 2){
						strjson += "\"id\":\"" + "Post" +jsonlist.get(j).getId()+ "\",\"text\": \""+ jsonlist.get(j).getText()+"\"";
						strjson += ",\"iconCls\": \"icon-post\"";
					}else if(jsonlist.get(j).getOldId() == 3){
						strjson += "\"id\":\"" + "Em" +jsonlist.get(j).getId()+ "\",\"text\": \""+ jsonlist.get(j).getText()+"\"";
						strjson += ",\"iconCls\": \"icon-employ\"";
					}
					if(jsonlist.get(j).getOldId() != 3)
					{
						addChildren(jsonlist,jsonlist.get(j).getId())	;
					}
					strjson += "}";
				}
				
			}
			
		}
		if(num >0){//说明有孩子节点
			strjson += "]";
		}
		
	}
	
	
	
	/**
	 * 将组织架构树中的个别字段分别对应于json中的id，pid（父节点），text
	 * @param otree 需要转换的组织架构树
	 * @author sharonyshi
	 * @return
	 */
	public ArrayList<TreeJson> changetoTreejson(List<OrganizationTree> otree){
		ArrayList<TreeJson> treelist=new ArrayList<TreeJson>(); 
		for (int i = 0; i < otree.size(); i++) {
				if(otree.get(i).getOrganization_s().equals("1")){//说明是根节点，部门或者岗位信息
					
					TreeJson tj=new TreeJson();
		 			tj.setId(otree.get(i).getOrganization_s());
		 			tj.setPid(otree.get(i).getSuperior_s());
		 			tj.setText(otree.get(i).getName_s());
		 			tj.setOldId(4);
		 			treelist.add(tj);
				}else{//说明是人员信息
					//如果树的上一节不为空，也就是人员有岗位，那么转换格式
					if(otree.get(i).getSuperior_s()!=null && !otree.get(i).getSuperior_s().equals("")){
						TreeJson tj=new TreeJson();
			 			tj.setId(otree.get(i).getOrganization_s());
			 			tj.setPid(otree.get(i).getSuperior_s());
			 			tj.setText(otree.get(i).getName_s());
			 			tj.setOldId(otree.get(i).getType_i());
			 			treelist.add(tj);
					}
				}
	 		}
		return treelist;
	}
	
}
