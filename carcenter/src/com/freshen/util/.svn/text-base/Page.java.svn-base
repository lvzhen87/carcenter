package com.freshen.util;
/**
 * jdbc分页
 *     
 * 项目名称：carcenter    
 * 类名称：Page    
 * 类描述：    
 * 创建人：kxc    
 * 创建时间：2014-8-10 上午11:16:00    
 * 修改人：kxc    
 * 修改时间：2014-8-10 上午11:16:00    
 * 修改备注：    
 * @version     
 *
 */
public class Page { 
	private int rowTotal;// 总记录数 
	private int pageSize = ConstantUtil.pageSize;// 每页记录数 
	private int count;// 当前页码 
	private int total;// 总页数 
	private int beginIndex;//起始记录下标 
	private int endIndex;//截止记录下标 
	/** 
	* 使用总记录数、当前页码构造 
	* 
	* @param rowTotal 
	* @param count 
	* 页码，从1开始 
	*/ 
	public Page(int totalRow, int count) { 
		this.rowTotal = totalRow; 
		this.count = count; 
		calculate(); 
	} 
	/** 
	* 使用总记录数、当前页码和每页记录数构造 
	* 
	* @param rowTotal 
	* @param count 
	* 页码，从1开始 
	* @param pageSize 
	* 默认30条 
	*/ 
	public Page(int totalRow, int count, int pageSize) { 
		this.rowTotal = totalRow; 
		this.count = count; 
		this.pageSize = pageSize; 
		calculate(); 
	} 
	private void calculate() { 
		total = rowTotal / pageSize + ((rowTotal % pageSize) > 0 ? 1 : 0); 
		if (count > total) { 
			count = total; 
		} else if (count < 0) { 
			count = 1; 
		} 
		beginIndex = count  * pageSize ; 
		endIndex = beginIndex + pageSize ; 
		if (endIndex > rowTotal) { 
			endIndex = rowTotal; 
		} 
	}
	public int getRowTotal() {
		return rowTotal;
	}
	public void setRowTotal(int rowTotal) {
		this.rowTotal = rowTotal;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getBeginIndex() {
		return beginIndex;
	}
	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	@Override
	public String toString() {
		return "Page [beginIndex=" + beginIndex + ", count=" + count
				+ ", endIndex=" + endIndex + ", pageSize=" + pageSize
				+ ", rowTotal=" + rowTotal + ", total=" + total + "]";
	}  

}

