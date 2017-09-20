package com.freshen.basis.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.freshen.entity.basis.OrganizationTree;

public class TreeJson implements Serializable{
	 private static final long serialVersionUID = 1L;

	    private String id ; //节点ID
	    private String pid ; //父节点ID
	    private String text ; //节点显示文字
	    private String iconCls ;
	    private String state="false" ; //节点状态，开、关
	    private String checked ; //Indicate whether the node is checked selected.
	    private int oldId;
	    
	   public int getOldId() {
			return oldId;
		}

		public void setOldId(int oldId) {
			this.oldId = oldId;
		}

		// private JSONObject attributes = new JSONObject() ; //节点中其他属性的集合
	    private List<TreeJson> children = new ArrayList<TreeJson>() ;//子节点集合
	    
	    
	   List<TreeJson> list=new ArrayList<TreeJson>();
	   
	    public List<TreeJson> formatTree(List<OrganizationTree> olist) {

	       /* TreeJson root = new TreeJson();
	        TreeJson node = new TreeJson();
	        List<TreeJson> treelist = new ArrayList<TreeJson>();// 拼凑好的json格式的数据
	        List<TreeJson> parentnodes = new ArrayList<TreeJson>();// parentnodes存放所有的父节点
	        
	          if (list != null && list.size() > 0) {//当传过来的list中存在数据遍历list
	        	root.setId(list.get(0).getOrganization_s());
	        	root.setText(list.get(0).getName_s());//显示文本
	        	
	      	for (int i = 0; i < list.size(); i++) {
	        		//设置节点必要属性
        			node.setId(list.get(i).getOrganization_s());//节点编号
					node.setText(list.get(i).getName_s());//显示文本
					node.setPid(list.get(i).getSuperior_s());//父节点
					
					//当list中没有上级编号时，为根节点直接设置
	        		if(node.getPid()==null ){
						
						//说明没有父节点，是一级节点，为tree root 增加子节点
						parentnodes.add(node);
	        			root.getChildren().add(node);
					}else{//当node中存在上级编号为孩子节点，需要查找到父节点然后设置
						getChildrenNodes(parentnodes, node);
						parentnodes.add(node);
						
					}
	        		
				}*/
	    	 for (int i = 0; i < olist.size(); i++) {
	 			TreeJson tj=new TreeJson();
	 			tj.setId(olist.get(i).getOrganization_s());
	 			tj.setPid(olist.get(i).getSuperior_s());
	 			tj.setText(olist.get(i).getName_s());
	 			
	 			list.add(tj);
	 		}
	    	
	        TreeJson root = new TreeJson();
	        TreeJson node = new TreeJson();
	        List<TreeJson> treelist = new ArrayList<TreeJson>();// 拼凑好的json格式的数据
	        List<TreeJson> parentnodes = new ArrayList<TreeJson>();// parentnodes存放所有的父节点
	        
	        if (list != null && list.size() > 0) {
	            root = list.get(0) ;
	            //循环遍历oracle树查询的所有节点
	            for (int i = 1; i < list.size(); i++) {
	                node = list.get(i);
	                if(node.getPid().equals(root.getId())){
	                    //为tree root 增加子节点
	                    parentnodes.add(node) ;
	                    root.getChildren().add(node) ;
	                }else{//获取root子节点的孩子节点
	                    getChildrenNodes(parentnodes, node);
	                    parentnodes.add(node) ;
	                }
	            }    
	        }
	        treelist.add(root) ;
	        return treelist ;

	    }

	    private static void getChildrenNodes(List<TreeJson> parentnodes, TreeJson node) {
	        //循环遍历所有父节点和node进行匹配，确定父子关系
	        for (int i = parentnodes.size() - 1; i >= 0; i--) {
	            
	            TreeJson pnode = parentnodes.get(i);
	            //如果是父子关系，为父节点增加子节点，退出for循环
	            if (pnode.getId().equals(node.getPid())) {
	                pnode.setState("closed") ;//关闭二级树
	                pnode.getChildren().add(node) ;
	                return ;
	            } else {
	                //如果不是父子关系，删除父节点栈里当前的节点，
	                //继续此次循环，直到确定父子关系或不存在退出for循环
	                parentnodes.remove(i) ;
	            }
	        }
	    }

	    
	    /******** setter and getter **********/
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getPid() {
			return pid;
		}

		public void setPid(String pid) {
			this.pid = pid;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public String getIconCls() {
			return iconCls;
		}

		public void setIconCls(String iconCls) {
			this.iconCls = iconCls;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getChecked() {
			return checked;
		}

		public void setChecked(String checked) {
			this.checked = checked;
		}

	/*	public JSONObject getAttributes() {
			return attributes;
		}

		public void setAttributes(JSONObject attributes) {
			this.attributes = attributes;
		}*/

		public List<TreeJson> getChildren() {
			return children;
		}

		public void setChildren(List<TreeJson> children) {
			this.children = children;
		}

		public static long getSerialVersionUID() {
			return serialVersionUID;
		}

		@Override
		public String toString() {
			return "TreeJson [id=" + id + ", pid=" + pid + ", text=" + text
					+ ", iconCls=" + iconCls + ", state=" + state
					+ ", checked=" + checked + ", children=" + children + "]";
		}

		
	
	    
}
