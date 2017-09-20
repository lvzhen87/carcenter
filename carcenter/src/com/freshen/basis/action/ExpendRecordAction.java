package com.freshen.basis.action;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import jxl.SheetSettings;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.UnderlineStyle;
import jxl.write.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ChineseTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.Page;
import com.freshen.basis.service.ExpendRecordService;
import com.freshen.basis.service.impl.ExpendRecordServiceImpl;

import com.freshen.entity.basis.ExpendRecord;

import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;

public class ExpendRecordAction extends CapgActionSupport{

	private static final long serialVersionUID = 1L;
	
	//	员工证件号
	String strSysNo;
	//	员工姓名
	String strEmplyName;
	//	记录员工的消费记录
	ArrayList<ExpendRecord> erList = new ArrayList<ExpendRecord>();
	private HttpServletResponse response ; 
	String errmsg;
	
	//分页必须
	int totalPages;
	int currentPage, maxPage, pageSize = ConstantUtil.pageSize;
	
	public final static String closepage = "closepage";
	
	/**
	 * 默认查询所有员工消费记录，当有查询条件时查询该员工的消费记录
	 * @author Ypeng 2014-08-09
	 */
	public String execute(){
		try {
			//	设置查询条件
			
			ExpendRecordService ers = new ExpendRecordServiceImpl();
			//	确定记录总数
			totalPages = ers.getExpendRecordNumber(strSysNo, strEmplyName);
			maxPage = (int) (totalPages % pageSize == 0 ? totalPages / pageSize : totalPages / pageSize + 1);
			//	合适当前页的有效性
			if(currentPage <= 0){
				currentPage = 0;
			}else if(currentPage >= maxPage){
				currentPage = maxPage;
			}

			Page page = new Page(totalPages, currentPage);
			erList = ers.getExpendRecord(strSysNo, strEmplyName, page);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return SUCCESS;
	}
	
	/**
	 * 默认查询所有员工消费记录，当有查询条件时查询该员工的消费记录
	 * @author Ypeng 2014-08-09
	 */
	public String searchExpendRecord(){
		try {
			//	设置查询条件

			if(strEmplyName != null && !"".equals(strEmplyName.trim()) && ChineseTools.isMessyCode(strEmplyName)){
				strEmplyName = new String(strEmplyName.getBytes("ISO-8859-1"),"UTF-8").trim();
			}
			
			ExpendRecordService ers = new ExpendRecordServiceImpl();
			//	确定记录总数
			totalPages = ers.getExpendRecordNumber(strSysNo, strEmplyName);
			maxPage = (int) (totalPages % pageSize == 0 ? totalPages / pageSize : totalPages / pageSize + 1);
			//	合适当前页的有效性
			if(currentPage <= 0){
				currentPage = 0;
			}else if(currentPage >= maxPage){
				currentPage = maxPage;
			}
			
			Page page = new Page(totalPages, currentPage );
			erList = ers.getExpendRecord(strSysNo, strEmplyName, page);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return SUCCESS;
	}
	
	public void setExpend() throws Exception{
		
		ExpendRecordService ers = new ExpendRecordServiceImpl();
		int state =  ers.setExpend();
		PrintWriter pw=null;
		String value = "";
		switch (state) {
		case 0:
			value = "calu";
			break;
		case 1:
			value = "success";
			break;
		case 2:
			value = "error";
			break;
		}
		pw=response.getWriter();
		pw.println(value);
		pw.flush();
		pw.close();
		
	}

	public void ExportBalence() throws Exception{
		
		ExpendRecordService ers = new ExpendRecordServiceImpl();
		ArrayList<ExpendRecord> list =  ers.getLastBalenceinfo();
		
		if(list != null && list.size()>0)
		{
			exportExcel(response,list);
		}
		
	}
	
	public boolean exportExcel(HttpServletResponse response,ArrayList<ExpendRecord> list) 
    {   
		try 
		{ 
				OutputStream os ;
				 response = (HttpServletResponse) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);  
			       response.reset(); 
				os= response.getOutputStream();// 取得输出流   
				
		        response.setHeader("Content-disposition", "attachment; filename=ExpendRecord.xls");// 设定输出文件头   
		        response.setContentType("application/msexcel");// 定义输出类型 
		        
		        WritableWorkbook wbook = Workbook.createWorkbook(os); // 建立excel文件   
		        String tmptitle = "补贴报表"; // 标题   
		        WritableSheet wsheet = wbook.createSheet(tmptitle, 0); // sheet名称  
		        SheetSettings sheetSettings =  wsheet.getSettings();//设置sheet表格式
		        //sheetSettings.setHorizontalFreeze(2);
		        sheetSettings.setVerticalFreeze(1);
		        wsheet.setColumnView(0, 20);
		        wsheet.setColumnView(1, 16);
		        wsheet.setColumnView(2, 20);
		        wsheet.setColumnView(3, 30);
		        wsheet.setColumnView(4, 16);
		        wsheet.setColumnView(5, 20);
		        wsheet.setColumnView(6, 20);
		        wsheet.setColumnView(7, 20);
		        wsheet.setColumnView(8, 15);
		        wsheet.setColumnView(9, 15);
		        wsheet.setColumnView(10, 15);
		        
		// 设置excel标题   
				WritableFont wfont = new WritableFont(WritableFont.ARIAL, 16,WritableFont.BOLD, 
				                       false,UnderlineStyle.NO_UNDERLINE,Colour.BLACK);   
				WritableCellFormat wcfFC = new WritableCellFormat(wfont); 
				wcfFC.setBackground(Colour.AQUA);  
				wfont = new jxl.write.WritableFont(WritableFont.ARIAL, 14,WritableFont.BOLD, 
				                   false, UnderlineStyle.NO_UNDERLINE,Colour.BLACK);   
				wcfFC = new WritableCellFormat(wfont);  
				
				// 开始生成主体内容                   
				WritableCellFormat cellFormattitle=new WritableCellFormat(wfont);
				cellFormattitle.setWrap(true);
				cellFormattitle.setAlignment(Alignment.CENTRE);
				cellFormattitle.setBorder(Border.ALL, BorderLineStyle.THIN); 
				
				//设置背景颜色;  
				cellFormattitle.setBackground(Colour.LIGHT_TURQUOISE);  
				
				WritableCellFormat cellFormat=new WritableCellFormat();
				cellFormat.setWrap(true);
				cellFormat.setAlignment(Alignment.CENTRE);
				cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN); 
				wsheet.addCell(new Label(0, 0, "员工证件号",cellFormattitle));
				wsheet.addCell(new Label(1, 0, "部门名称",cellFormattitle));   
				wsheet.addCell(new Label(2, 0, "员工名称",cellFormattitle));   
				wsheet.addCell(new Label(3, 0, "卡片编号",cellFormattitle));   
				wsheet.addCell(new Label(4, 0, "补贴金额",cellFormattitle)); 
				wsheet.addCell(new Label(5, 0, "发放时间",cellFormattitle));  
				wsheet.addCell(new Label(6, 0, "用餐次数",cellFormattitle));  
				wsheet.addCell(new Label(7, 0, "总用餐金额",cellFormattitle));  
				wsheet.addCell(new Label(8, 0, "无效次数",cellFormattitle));  
				wsheet.addCell(new Label(9, 0, "无效金额",cellFormattitle)); 
				wsheet.addCell(new Label(10, 0, "剩余金额",cellFormattitle));  
				for(int i=0;i<list.size();i++) {   
					wsheet.addCell(new Label(0, i+1, list.get(i).getSysNo(),cellFormat));
				    wsheet.addCell(new Label(1, i+1, list.get(i).getDepartMentName(),cellFormat)); 
				    wsheet.addCell(new Label(2, i+1, list.get(i).getEmployName(),cellFormat)); 
				    wsheet.addCell(new Label(3, i+1, list.get(i).getSerial(),cellFormat));  
				    wsheet.addCell(new Label(4, i+1, list.get(i).getDealMoney()+"",cellFormat));  
				    wsheet.addCell(new Label(5, i+1, list.get(i).getDealDate_s().substring(0,10),cellFormat));  
				    wsheet.addCell(new Label(6, i+1, list.get(i).getDealTime()+"",cellFormat));  
				    wsheet.addCell(new Label(7, i+1, list.get(i).getDealTotal()+"",cellFormat));  
				    wsheet.addCell(new Label(8, i+1, list.get(i).getMissDealTime()+"",cellFormat));  
				    wsheet.addCell(new Label(9, i+1, list.get(i).getMissDealTotal()+"",cellFormat));  
				    wsheet.addCell(new Label(10, i+1, list.get(i).getMoneyLeft()+"",cellFormat)); 
				    
				}           
				// 主体内容生成结束           
				wbook.write(); // 写入文件   
				wbook.close();  
				os.close(); // 关闭流
				return true; 
		} 
		catch(Exception ex) 
		{ 
			ex.printStackTrace(); 
			return false; 
		} 
    } 
	
	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public ArrayList<ExpendRecord> getErList() {
		return erList;
	}
	public void setErList(ArrayList<ExpendRecord> erList) {
		this.erList = erList;
	}

	public String getStrSysNo() {
		return strSysNo;
	}
	public void setStrSysNo(String strSysNo) {
		this.strSysNo = strSysNo;
	}

	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getStrEmplyName() {
		return strEmplyName;
	}

	public void setStrEmplyName(String strEmplyName) {
		this.strEmplyName = strEmplyName;
	}
	
}