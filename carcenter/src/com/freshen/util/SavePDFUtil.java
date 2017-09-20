package com.freshen.util;


import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.freshen.entity.process.RoadEmployInventory;
import com.freshen.entity.process.RoadEmployInventory.StationDetailModel;
import com.freshen.entity.process.RoadEmployInventory.StationDetailModel.StationDetailTimeModel;
import com.freshen.process.service.IstationService;
import com.freshen.process.service.impl.StationServiceImpl;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEvent;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
public class SavePDFUtil {

	static float lineHeight1 = (float)13.0;
	

	/**
	   * 创建一个单元格
	   * @param paragraph 单元格内容文字	  
	   * @param width 宽度的倍数
	   */
	   public static  PdfPCell newPdfPCell(Paragraph paragraph,int width){
		PdfPCell iCell=new PdfPCell();
		iCell.setFixedHeight(lineHeight1*width);
		paragraph.setAlignment(1);
		 
		iCell.addElement(paragraph);
		iCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		iCell.setVerticalAlignment(Element.ALIGN_MIDDLE);	 
		iCell.setPadding(0);
		return iCell;
	   }
	
	/**
	   * 创建一个跨多行的单元格
	   * @param rows 所占行数
	   * @param bgColor 背景色
	   * @param paragraph 单元格内容文字
	   * @param align 对齐方式 
	   */
	   public static  PdfPCell newPdfPCellByRows(int rows,Paragraph paragraph,int align){
		PdfPTable iTable=new PdfPTable(1);
		PdfPCell iCell=new PdfPCell();
		iCell.setFixedHeight(iCell.getFixedHeight()*rows);
		iTable.addCell(iCell);
		iCell.addElement(paragraph);
		iCell.setHorizontalAlignment(align);
		PdfPCell cell=new PdfPCell(iTable);
		return cell;
	   }
	   
	   /**
	    * 创建一个跨多列的单元格
	    * @param colspan 所占列数
	    * @param bgColor 背景色
	    * @param paragraph 单元格内容文字
	    * @param align 对齐方式 
	    */
	    public static  PdfPCell newPdfPCellByColspan(int colspan,Paragraph paragraph,int align){
	     PdfPTable iTable=new PdfPTable(1);
	     PdfPCell iCell=new PdfPCell();
	     iCell.setColspan(colspan);
	     iCell.setBorder(0);
	     iCell.addElement(paragraph);
	     iCell.setHorizontalAlignment(align);
	     iTable.addCell(iCell);
	     PdfPCell cell=new PdfPCell(iTable);
	     return cell;
	    }
	    
	    public static void buidPDF(String pdfFile, String imageFile,  
	            String waterMarkName, int permission) {  
	        try {  
	        	 File file = File.createTempFile("tempFile", ".pdf"); // 创建临时文件  
	            
	        
	            // 生成PDF  
	        	/* if (createPDFFile(file)) {  
		                waterMark(file.getPath(), name,pdfFile
		                        ); // 添加水印  
		            } 
	               */
	           
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  
	    
	    public static List<RoadEmployInventory> getData(String orderID_s,String startComeDate_s,String endComeDate_s){
	    	IstationService stationServiceImpl = new StationServiceImpl();
			try {
				RoadEmployInventory model = new RoadEmployInventory();
				model.setOrderId_s(orderID_s);
				model.setStartComeDate_s(startComeDate_s);
				model.setEndComeDate_s(endComeDate_s);
				List<RoadEmployInventory> roadEmployInventoryList = stationServiceImpl.getRoadEmployInventoryList(model);
				return roadEmployInventoryList;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				ExceptionDispose.saveExceptionInfo(e);
				return null;
			}
			
	    }
	    
	    public static void waterMark(String inputFile,  String name, String outputFile) {  
	        try {  
	        	File output = new File(outputFile);
	        	//如果文件夹不存在则创建    
	        	if  (!output .exists()  && !output .isDirectory())      
	        	{       
	        	    //System.out.println("//不存在");  
	        	    output .mkdir();    
	        	}
	            PdfReader reader = new PdfReader(inputFile);  
	            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(  
	                    outputFile+"\\"+name+".pdf"));  
	  
	            BaseFont base = BaseFont.createFont(  
	                    "C:/WINDOWS/Fonts/SIMSUN.TTC,1", "Identity-H", true);// 使用系统字体  
	  
	            int total = reader.getNumberOfPages() + 1;  
	           // Image image = Image.getInstance(imageFile);  
	  
	            // 图片位置  
	        //    image.setAbsolutePosition(400, 600);  
	            PdfContentByte under = stamper.getUnderContent(1);  
	           // int j = waterMarkName.length();  
	            /*char c = 0;  
	            int rise = 0;  
	            for (int i = 1; i < total; i++) {  
	                rise = 400;  
	                under = stamper.getUnderContent(i);  
	                under.beginText();  
	                under.setFontAndSize(base, 30);  
	  
	                if (j >= 15) {  
	                    under.setTextMatrix(200, 120);  
	                    for (int k = 0; k < j; k++) {  
	                        under.setTextRise(rise);  
	                        c = waterMarkName.charAt(k);  
	                        under.showText(c + "");  
	                    }  
	                } else {  
	                    under.setTextMatrix(240, 100);  
	                    for (int k = 0; k < j; k++) {  
	                        under.setTextRise(rise);  
	                        c = waterMarkName.charAt(k);  
	                        under.showText(c + "");  
	                        rise -= 18;  
	  
	                    }  
	                }*/  
	  
	                // 添加水印文字  
	                //under.endText();  
	  
	                // 添加水印图片  
	          //      under.addImage(image);  
	  
	               /* // 画个圈  
	                under.ellipse(250, 450, 350, 550);  
	                under.setLineWidth(1f);  
	                under.stroke();*/  
	            //}  
	            stamper.close();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  
	    /** 
	     * 创建PDF文件 
	     *  
	     * @param file 
	     *            临时文件 
	     * @return 成功/失败 
	     */  
	    public static boolean createPDFFileold(File file) {
	        Rectangle rect = new Rectangle(PageSize.A4);  
	        Document document = new Document();    
            try {    

            	List<RoadEmployInventory> roadEmployInventoryList = getData("DD2014111017","2014-01-31","2015-01-31");
            		// 第二步：    
                    // 创建一个PdfWriter实例，    
                    // 将文件输出流指向一个文件。    
                    //PdfWriter.getInstance(document,new FileOutputStream("f:\\2015\\AsianTest.pdf"));    
            	 PdfWriter.getInstance(document, new FileOutputStream(file));  
                    // 第三步：打开文档。    
                    document.open();    

                 // 生成名为 AsianTest.pdf 的文档  
                  
                 
                    /*
                      	新建一个字体,iText的方法 STSongStd-Light 是字体，在iTextAsian.jar 中以property为后缀 
                      UniGB-UCS2-H 是编码，在iTextAsian.jar 中以cmap为后缀 H 代表文字版式是 横版， 相应的 V 
                     	代表竖版 */
                       
                    BaseFont bfChinese = BaseFont.createFont("C:/WINDOWS/Fonts/SIMSUN.TTC,1",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                    
                    Font bold_fontChinese = new Font(bfChinese, 10, Font.BOLD);  
                    Font italic_fontChinese = new Font(bfChinese, 12, Font.ITALIC);  
                    Font impressFont = new Font(bfChinese, 16, Font.BOLDITALIC);  
                    // 打开文档，将要写入内容  
                   
                    PdfPTable headerTable = new PdfPTable(2);//主
                    
                    PdfPTable table = new PdfPTable(5);
                    
                   
                    //cell = new PdfPCell(new Phrase("差旅费用"),font);
                    PdfPCell headcell;
                    headcell= new PdfPCell(new Paragraph("差旅费用",bold_fontChinese));  
                    headcell.setHorizontalAlignment(Element.ALIGN_CENTER);
                   
                    headcell.setColspan(5);
                    table.addCell(headcell);
                   // cell = new PdfPCell(new Phrase("申请人："));
                    
                   // table.addCell(cell);
                    PdfPCell cell;
                    //1
                   /* table.addCell(new Paragraph("申请人：",bold_fontChinese));
                    table.addCell(new Paragraph("石韵",bold_fontChinese));
                    table.addCell(new Paragraph("项目名称：",bold_fontChinese));
                    table.addCell(new Paragraph("20150109测试",bold_fontChinese));
                    table.addCell(new Paragraph("项目阶段：",bold_fontChinese));*/
                 //   table.addCell(new Paragraph("测试",bold_fontChinese));
                    
                    
                    //newPdfPCellByRows
                   /* cell= new PdfPCell(new Paragraph("跨行",bold_fontChinese));  
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setColspan(2);
                    cell.setPadding(0);	
                    table.addCell(cell);*/
                    
                    cell = new PdfPCell(new Paragraph("D"));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setPadding(0);
                    cell.setFixedHeight(lineHeight1*2+2);
                    table.addCell(cell);            
                  //  table.addCell(newPdfPCellByRows(2,new Paragraph("跨行：",bold_fontChinese),Element.ALIGN_CENTER));
                   // table.addCell(newPdfPCellByColspan(4,new Paragraph("跨行：",bold_fontChinese),Element.ALIGN_CENTER));
                    
                    //2
                   // table.addCell(new Paragraph("开始时间：",bold_fontChinese));
                    cell = newPdfPCell(new Paragraph("2015-01-11",bold_fontChinese), Element.ALIGN_CENTER);
                    table.addCell(cell);
                    table.addCell(newPdfPCell(new Paragraph("结束时间",bold_fontChinese),Element.ALIGN_CENTER));
                    table.addCell(newPdfPCell(new Paragraph("结束时间",bold_fontChinese),Element.ALIGN_CENTER));
                    table.addCell(newPdfPCell(new Paragraph("2015-01-10",bold_fontChinese),Element.ALIGN_CENTER));

                    table.addCell(newPdfPCell(new Paragraph("出差地点：",bold_fontChinese),Element.ALIGN_CENTER));
                    table.addCell(newPdfPCell(new Paragraph("盐城",bold_fontChinese),Element.ALIGN_CENTER));

                    //table.addCell(newPdfPCell(new Paragraph("出差总天数:",bold_fontChinese),Element.ALIGN_CENTER));
                    table.addCell(newPdfPCell(new Paragraph("盐城",bold_fontChinese),Element.ALIGN_CENTER));
                    table.addCell(newPdfPCell(new Paragraph("工作日(不含节假日):",bold_fontChinese),Element.ALIGN_CENTER));
                    table.addCell(newPdfPCell(new Paragraph("8",bold_fontChinese),Element.ALIGN_CENTER));   
                    table.addCell(newPdfPCell(new Paragraph("",bold_fontChinese),Element.ALIGN_CENTER)); 
                    table.addCell(newPdfPCell(new Paragraph("",bold_fontChinese),Element.ALIGN_CENTER));
                                    
                    table.addCell(newPdfPCell(new Paragraph("出租车费",bold_fontChinese),Element.ALIGN_CENTER));
                    table.addCell(newPdfPCell(new Paragraph("50",bold_fontChinese),Element.ALIGN_CENTER));
                    table.addCell(newPdfPCell(new Paragraph("交通费：",bold_fontChinese),Element.ALIGN_CENTER));  
                    table.addCell(newPdfPCell(new Paragraph("500",bold_fontChinese),Element.ALIGN_CENTER));
                    table.addCell(newPdfPCell(new Paragraph("住宿费：",bold_fontChinese),Element.ALIGN_CENTER));
                //    table.addCell(newPdfPCell(new Paragraph("1000",bold_fontChinese),Element.ALIGN_CENTER));

                    table.addCell(newPdfPCell(new Paragraph("汽油费:",bold_fontChinese),Element.ALIGN_CENTER));
                    table.addCell(newPdfPCell(new Paragraph("100",bold_fontChinese),Element.ALIGN_CENTER));
                    table.addCell(newPdfPCell(new Paragraph("采购费：",bold_fontChinese),Element.ALIGN_CENTER));
                    table.addCell(newPdfPCell(new Paragraph("0",bold_fontChinese),Element.ALIGN_CENTER));
                    table.addCell(newPdfPCell(new Paragraph("邮电费：",bold_fontChinese),Element.ALIGN_CENTER));
                    cell = new PdfPCell(table);
                    cell.setPadding(0);
                    headerTable.addCell(cell);       
                    cell = new PdfPCell(new Paragraph("D"));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setPadding(0);
                    
                    cell.setFixedHeight(lineHeight1*5);
                    headerTable.addCell(cell);            
                    
                    
                    
                    
                    /*table.addCell(newPdfPCell(new Paragraph("2015-01-11",bold_fontChinese), Element.ALIGN_CENTER));
                    table.addCell(newPdfPCell(new Paragraph("结束时间",bold_fontChinese),Element.ALIGN_CENTER));
                    table.addCell(newPdfPCell(new Paragraph("2015-01-10",bold_fontChinese),Element.ALIGN_CENTER));
 
                    table.addCell(new Paragraph("出差地点：",bold_fontChinese));
                    table.addCell(new Paragraph("盐城",bold_fontChinese));
                    
                    //table.addCell(new Paragraph("出差总天数:",bold_fontChinese));
                    table.addCell("10");
                    table.addCell(new Paragraph("工作日(不含节假日):",bold_fontChinese));
                    table.addCell("8");
                    table.addCell("");
                    table.addCell("");
                                       
                    
                    table.addCell(new Paragraph("出租车费:",bold_fontChinese));
                    table.addCell("50");
                    table.addCell(new Paragraph("交通费：",bold_fontChinese));
                    table.addCell("500");
                    table.addCell(new Paragraph("住宿费：",bold_fontChinese));
                    table.addCell("1000");
                    
                    table.addCell(new Paragraph("汽油费:",bold_fontChinese));
                    table.addCell("100");
                    table.addCell(new Paragraph("采购费：",bold_fontChinese));
                    table.addCell("0");
                    table.addCell(new Paragraph("邮电费：",bold_fontChinese));
                    table.addCell("0");
                    
                    table.addCell(new Paragraph("差旅费用：",bold_fontChinese));
                    table.addCell("2000");
                    table.addCell(new Paragraph("中心补助：",bold_fontChinese));
                    table.addCell("500");
                    table.addCell(new Paragraph("院补助：",bold_fontChinese));
                    table.addCell("500");
                    
                    table.addCell(new Paragraph("合计：",bold_fontChinese));
                    table.addCell("3000");*/
                    
                    
                    
                    document.add(headerTable);
                    // 第五步：关闭文档。    
                    document.close();    
                    // 检验程序是否正常运行到这里。    
                    //System.out.println("快去看看吧"); 
                    return true;
                    
                    //document.add(new Paragraph("Hello World"+","+"Hello iText"+","+"Hello xDuan"));    
            } catch (DocumentException de) {    
                    System.err.println(de.getMessage());    
            } catch (IOException ioe) {    
                    System.err.println(ioe.getMessage());    
            }    
           
	        return false;  
	    }  
	    
	    /** 
	     * 创建PDF文件 
	     *  
	     * @param file 
	     *            临时文件 
	     * @return 成功/失败 
	     */  
	    public static String createPDFFileold(File file,List<RoadEmployInventory> roadEmployInventoryList,String order_name,String orderid_s,String startComeDate_s,String endComeDate_s) {
	        Rectangle rect = new Rectangle(PageSize.A4);  
	        Document document = new Document(rect);    
            try {
            	 
            	//List<RoadEmployInventory> roadEmployInventoryList = getData("DD2014111017","2014-01-31","2015-01-31");
            		// 第二步：    
                    // 创建一个PdfWriter实例，    
                    // 将文件输出流指向一个文件。    
                    //PdfWriter.getInstance(document,new FileOutputStream("f:\\2015\\AsianTest.pdf"));    
            	 
            	PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));    
            /*	 MyEvent events = new MyEvent();  
            	 writer.setPageEvent((PdfPageEvent) events);  */
                   // 第三步：打开文档。    
                    document.open();    

                 // 生成名为 AsianTest.pdf 的文档  
                  
                 
                    /*
                      	新建一个字体,iText的方法 STSongStd-Light 是字体，在iTextAsian.jar 中以property为后缀 
                      UniGB-UCS2-H 是编码，在iTextAsian.jar 中以cmap为后缀 H 代表文字版式是 横版， 相应的 V 
                     	代表竖版 */
                       
                    BaseFont bfChinese = BaseFont.createFont("C:/WINDOWS/Fonts/SIMSUN.TTC,1",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                    
                    Font bold_fontChinese = new Font(bfChinese, 8, Font.NORMAL);  
                    Font italic_fontChinese = new Font(bfChinese, 12, Font.BOLD);  
               //     Font impressFont = new Font(bfChinese, 16, Font.BOLDITALIC);  
                    // 打开文档，将要写入内容  
                   
                    PdfPTable headerTable = new PdfPTable(4);//主，分四部分   
                    headerTable.setWidths(new int[] {3, 1, 5,2 });
                    PdfPTable table1 = new PdfPTable(3);//第一部分
                    table1.setWidths(new int[] {2, 1, 1 });
                    PdfPTable table2 = new PdfPTable(1);//第二部分
                    PdfPTable table3 = new PdfPTable(3);//第三部分
                    table3.setWidths(new int[] {3, 3, 1 });
                    PdfPTable table4 = new PdfPTable(4);//第四部分
                    PdfPCell cell;
                    //cell = new PdfPCell(new Phrase("差旅费用"),font);
                    PdfPCell headcell;
                    //表头
                    headcell= new PdfPCell(new Paragraph("中汽中心盐城汽车试验有限公司",italic_fontChinese));  
                    headcell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    headcell.setColspan(4);
                    headerTable.addCell(headcell);
                    headcell= new PdfPCell(new Paragraph("道路使用量确认清单",italic_fontChinese));  
                    headcell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    headcell.setColspan(4);
                    headerTable.addCell(headcell);
                    headcell= new PdfPCell(new Paragraph("客户名称："+order_name,bold_fontChinese));  
                    headcell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    headcell.setColspan(4);
                    headerTable.addCell(headcell);
                    headcell= new PdfPCell(new Paragraph("订单号："+orderid_s,bold_fontChinese));  
                    headcell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    headcell.setColspan(4);
                    headerTable.addCell(headcell);
                    headcell= new PdfPCell(new Paragraph("起止时间："+startComeDate_s+"到"+endComeDate_s,bold_fontChinese));  
                    headcell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    headcell.setColspan(4);
                    headerTable.addCell(headcell);
                    
                    if(BasicTools.isnotNull(roadEmployInventoryList)){
//System.out.println("size======="+roadEmployInventoryList.size());
                    	for(int i=0;i<roadEmployInventoryList.size();i++){
                    		/*if(i>0){
                    			document.add(headerTable);
                    			document.newPage();
                    		}*/
                    		RoadEmployInventory rem = roadEmployInventoryList.get(i);                    		                            
                            cell = newPdfPCell(new Paragraph(rem.getCardId_s(),bold_fontChinese),rem.getStationDetailModelsize());
                            table1.addCell(cell);
                            cell = newPdfPCell(new Paragraph(rem.getHandworkCpg(),bold_fontChinese),rem.getStationDetailModelsize());
                            table1.addCell(cell);
                            cell = newPdfPCell(new Paragraph(rem.getBrandType_s(),bold_fontChinese),rem.getStationDetailModelsize());
                            table1.addCell(cell);
                            List<StationDetailModel> smlist = rem.getStationDetailModelList();
                            for(int j=0;j<smlist.size();j++){
                            	StationDetailModel sm = smlist.get(j);
                            	cell = newPdfPCell(new Paragraph(sm.getRoadName_s(),bold_fontChinese),sm.getStationDetailTimeModelSize());
                            	table2.addCell(cell);
                            	cell = newPdfPCell(new Paragraph(sm.getRoadName_s(),bold_fontChinese),sm.getStationDetailTimeModelSize());
                            	cell = newPdfPCell(new Paragraph(sm.getEmployTimeCount()+"",bold_fontChinese),sm.getStationDetailTimeModelSize());
                            	table4.addCell(cell);
                            	cell = newPdfPCell(new Paragraph(sm.getShareTimeCount()+"",bold_fontChinese),sm.getStationDetailTimeModelSize());
                            	table4.addCell(cell);
                            	cell = newPdfPCell(new Paragraph(sm.getPreTimeCount()+"",bold_fontChinese),sm.getStationDetailTimeModelSize());
                            	table4.addCell(cell);
                            	cell = newPdfPCell(new Paragraph(sm.getWholeTimeCount()+"",bold_fontChinese),sm.getStationDetailTimeModelSize());
                            	table4.addCell(cell);
                            	
                            	List<StationDetailTimeModel> stmlist = sm.getStationDetailTimeModelList();
                            	for(int k=0;k<stmlist.size();k++){
                            		StationDetailTimeModel stm = stmlist.get(k);
                            		cell = newPdfPCell(new Paragraph(stm.getComeTime(),bold_fontChinese),1);
                                	table3.addCell(cell);
                                	cell = newPdfPCell(new Paragraph(stm.getEnterTime()+"",bold_fontChinese),1);
                                	table3.addCell(cell);
                                	cell = newPdfPCell(new Paragraph(stm.getTimeCount()+"",bold_fontChinese),1);
                                	table3.addCell(cell);
                            	}
                            }                            
                    	}
                    }
                    cell = new PdfPCell(table1);
                    headerTable.addCell(cell);
                    cell = new PdfPCell(table2);
                    headerTable.addCell(cell);
                    cell = new PdfPCell(table3);
                    headerTable.addCell(cell);
                    cell = new PdfPCell(table4);
                    headerTable.addCell(cell);
                    headerTable.setWidthPercentage(100);  
                    document.add(headerTable);
                    // 第五步：关闭文档。    
                    document.close();
                    // 检验程序是否正常运行到这里。    
            //        waterMark(file.getPath(), order_name,  "\\2017");
                    return order_name;
                    
                    //document.add(new Paragraph("Hello World"+","+"Hello iText"+","+"Hello xDuan"));    
            } catch (DocumentException de) {
            		de.printStackTrace();
                    System.err.println(de.getMessage());    
            } catch (IOException ioe) {   
            		ioe.printStackTrace();
                    System.err.println(ioe.getMessage());    
            }    
           
	        return order_name;  
	    }
	    
	    /** 
	     * 创建PDF文件 
	     *  
	     * @param file 
	     *            临时文件 
	     * @return 成功/失败 
	     */  
	    public static String createPDFFile(File file,List<RoadEmployInventory> roadEmployInventoryList,String order_name,String orderid_s,String startComeDate_s,String endComeDate_s) {
	        Rectangle rect = new Rectangle(PageSize.A4);  
	        Document document = new Document(rect);    
            try {
            	 
            
            	PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));    
            /*	 MyEvent events = new MyEvent();  
            	 writer.setPageEvent((PdfPageEvent) events);  */
                   // 第三步：打开文档。    
                    document.open();    
                    BaseFont bfChinese = BaseFont.createFont("C:/WINDOWS/Fonts/SIMSUN.TTC,1",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                    
                    Font bold_fontChinese = new Font(bfChinese, 8, Font.NORMAL);  
                    Font italic_fontChinese = new Font(bfChinese, 12, Font.BOLD);  
               //     Font impressFont = new Font(bfChinese, 16, Font.BOLDITALIC);  
                    // 打开文档，将要写入内容  
                    PdfPTable htable = new PdfPTable(1);//主，分四部分   
                    PdfPTable headerTable = new PdfPTable(4);//主，分四部分   
                    PdfPTable tablees = new PdfPTable(4);//主，分四部分   
                    
                    PdfPCell cell;
                    
                    
                    
                    tablees.setWidths(new int[] {3, 1, 5,2 });
                    PdfPTable table1 = new PdfPTable(3);//第一部分
                    table1.setWidths(new int[] {2, 1, 1 });
                    PdfPTable table2 = new PdfPTable(1);//第二部分
                    PdfPTable table3 = new PdfPTable(3);//第三部分
                    table3.setWidths(new int[] {3, 3, 1 });
                    PdfPTable table4 = new PdfPTable(4);//第四部分
                    
                    //cell = new PdfPCell(new Phrase("差旅费用"),font);
                    PdfPCell headcell;
                    //表头
                    headerTable.setWidths(new int[] {3, 1, 5,4 });
                    headcell= new PdfPCell(new Paragraph("中汽中心盐城汽车试验有限公司",italic_fontChinese));  
                    headcell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    headcell.setColspan(4);
                    headerTable.addCell(headcell);
                    headcell= new PdfPCell(new Paragraph("道路使用量确认清单",italic_fontChinese));  
                    headcell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    headcell.setColspan(4);
                    headerTable.addCell(headcell);
                    headcell= new PdfPCell(new Paragraph("客户名称："+order_name,bold_fontChinese));  
                    headcell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    headcell.setColspan(4);
                    headerTable.addCell(headcell);
                    headcell= new PdfPCell(new Paragraph("订单号："+orderid_s,bold_fontChinese));  
                    headcell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    headcell.setColspan(4);
                    headerTable.addCell(headcell);
                    headcell= new PdfPCell(new Paragraph("起止时间："+startComeDate_s+"到"+endComeDate_s,bold_fontChinese));  
                    headcell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    headcell.setColspan(4);
                    headerTable.addCell(headcell);
                    cell = new PdfPCell(headerTable);
                    htable.addCell(cell);
                    
                    cell = newPdfPCell(new Paragraph("车卡号",bold_fontChinese),1);
                    table1.addCell(cell);
                    cell = newPdfPCell(new Paragraph("CPG牌照号",bold_fontChinese),1);
                    table1.addCell(cell);
                    cell = newPdfPCell(new Paragraph("车辆",bold_fontChinese),1);
                    table1.addCell(cell);
                    cell = newPdfPCell(new Paragraph("道路及场地",bold_fontChinese),1);
                    table2.addCell(cell);
                    cell = newPdfPCell(new Paragraph("进道闸时间",bold_fontChinese),1);
                    table3.addCell(cell);
                    cell = newPdfPCell(new Paragraph("出道闸时间",bold_fontChinese),1);
                    table3.addCell(cell);
                    cell = newPdfPCell(new Paragraph("用时(min)",bold_fontChinese),1);
                    table3.addCell(cell);
                    cell = newPdfPCell(new Paragraph("总计\n\t(min)",bold_fontChinese),1);
                    table4.addCell(cell);
                    cell = newPdfPCell(new Paragraph("共享用时(min)",bold_fontChinese),1);
                    table4.addCell(cell);
                    cell = newPdfPCell(new Paragraph("精确用时(min)",bold_fontChinese),1);
                    table4.addCell(cell);
                    cell = newPdfPCell(new Paragraph("包场用时(min)",bold_fontChinese),1);
                    table4.addCell(cell);
                    cell = new PdfPCell(table1);
                    tablees.addCell(cell);
                    cell = new PdfPCell(table2);
                    tablees.addCell(cell);
                    cell = new PdfPCell(table3);
                    tablees.addCell(cell);
                    cell = new PdfPCell(table4);
                    tablees.addCell(cell);
                    cell = new PdfPCell(tablees);
                    htable.addCell(cell);
                    
                    if(BasicTools.isnotNull(roadEmployInventoryList)){
//System.out.println("size======="+roadEmployInventoryList.size());                    	
                    	for(int i=0;i<roadEmployInventoryList.size();i++){					
                    		tablees = new PdfPTable(4);//主，分四部分   
                    		tablees.setWidths(new int[] {3, 1, 5,2 });
                    		table1 = new PdfPTable(3);//第一部分
                            table1.setWidths(new int[] {2, 1, 1 });
                            table2 = new PdfPTable(1);//第二部分
                            table3 = new PdfPTable(3);//第三部分
                            table3.setWidths(new int[] {3, 3, 1 });
                            table4 = new PdfPTable(4);//第四部分
                            
                    		RoadEmployInventory rem = roadEmployInventoryList.get(i);                    		                            
                            cell = newPdfPCell(new Paragraph(rem.getCardId_s(),bold_fontChinese),rem.getStationDetailModelsize());
                            table1.addCell(cell);
                            cell = newPdfPCell(new Paragraph(rem.getHandworkCpg(),bold_fontChinese),rem.getStationDetailModelsize());
                            table1.addCell(cell);
                            cell = newPdfPCell(new Paragraph(rem.getBrandType_s(),bold_fontChinese),rem.getStationDetailModelsize());
                            table1.addCell(cell);
                            List<StationDetailModel> smlist = rem.getStationDetailModelList();
                            for(int j=0;j<smlist.size();j++){
                            	StationDetailModel sm = smlist.get(j);
                            	cell = newPdfPCell(new Paragraph(sm.getRoadName_s(),bold_fontChinese),sm.getStationDetailTimeModelSize());
                            	table2.addCell(cell);
                            	cell = newPdfPCell(new Paragraph(sm.getRoadName_s(),bold_fontChinese),sm.getStationDetailTimeModelSize());
                            	cell = newPdfPCell(new Paragraph(sm.getEmployTimeCount()+"",bold_fontChinese),sm.getStationDetailTimeModelSize());
                            	table4.addCell(cell);
                            	cell = newPdfPCell(new Paragraph(sm.getShareTimeCount()+"",bold_fontChinese),sm.getStationDetailTimeModelSize());
                            	table4.addCell(cell);
                            	cell = newPdfPCell(new Paragraph(sm.getPreTimeCount()+"",bold_fontChinese),sm.getStationDetailTimeModelSize());
                            	table4.addCell(cell);
                            	cell = newPdfPCell(new Paragraph(sm.getWholeTimeCount()+"",bold_fontChinese),sm.getStationDetailTimeModelSize());
                            	table4.addCell(cell);
                            	
                            	List<StationDetailTimeModel> stmlist = sm.getStationDetailTimeModelList();
                            	for(int k=0;k<stmlist.size();k++){
                            		StationDetailTimeModel stm = stmlist.get(k);
                            		cell = newPdfPCell(new Paragraph(stm.getComeTime(),bold_fontChinese),1);
                                	table3.addCell(cell);
                                	cell = newPdfPCell(new Paragraph(stm.getEnterTime()+"",bold_fontChinese),1);
                                	table3.addCell(cell);
                                	cell = newPdfPCell(new Paragraph(stm.getTimeCount()+"",bold_fontChinese),1);
                                	table3.addCell(cell);
                            	}
                            }
                            cell = new PdfPCell(table1);
                            tablees.addCell(cell);
                            cell = new PdfPCell(table2);
                            tablees.addCell(cell);
                            cell = new PdfPCell(table3);
                            tablees.addCell(cell);
                            cell = new PdfPCell(table4);
                            tablees.addCell(cell);
                            cell = new PdfPCell(tablees);
                            htable.addCell(cell);
                    	}
                    }
                    tablees = new PdfPTable(3);//主，分四部分                                       
                    tablees.setWidths(new int[] {4,5,2 });
                    cell = newPdfPCell(new Paragraph("试验场负责人：",bold_fontChinese),1);
                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    tablees.addCell(cell);
                 
                    cell = newPdfPCell(new Paragraph("客户负责人：",bold_fontChinese),1);
                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    tablees.addCell(cell);
                    cell = newPdfPCell(new Paragraph("时间：",bold_fontChinese),1);           
                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    tablees.addCell(cell);
                    cell = new PdfPCell(tablees);
                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    htable.addCell(cell);
                    
                    /*headerTable = new PdfPTable(4);//主，分四部分   
                    headerTable.setWidths(new int[] {3, 1, 5,4 });
                    headcell= new PdfPCell(new Paragraph("试验场负责人：",bold_fontChinese));
                    headcell.setHorizontalAlignment(Element.ALIGN_LEFT);
                 //   headcell.setColspan(3);
                    headerTable.addCell(headcell);
                    headcell= new PdfPCell(new Paragraph("",bold_fontChinese));  
                    headcell.setHorizontalAlignment(Element.ALIGN_LEFT);
                  //  headcell.setColspan(2);
                    headerTable.addCell(headcell);
                    headcell= new PdfPCell(new Paragraph("客户责任人：",bold_fontChinese));  
                    headcell.setHorizontalAlignment(Element.ALIGN_LEFT);
                 //   headcell.setColspan(2);
                    headerTable.addCell(headcell);
                    headcell= new PdfPCell(new Paragraph("时间：",bold_fontChinese));
                    headcell.setHorizontalAlignment(Element.ALIGN_LEFT);
                 //   headcell.setColspan(3);
                    headerTable.addCell(headcell);
                    cell = new PdfPCell(headerTable);*/
                   
                    document.add(htable);
                    
                    // 第五步：关闭文档。
                    document.close();
                    return order_name;
                    
                    //document.add(new Paragraph("Hello World"+","+"Hello iText"+","+"Hello xDuan"));    
            } catch (DocumentException de) {
            		de.printStackTrace();
                    System.err.println(de.getMessage());    
            } catch (IOException ioe) {   
            		ioe.printStackTrace();
                    System.err.println(ioe.getMessage());    
            }    
           
	        return order_name;  
	    }
	    
	    public static void main(String[] args) {  
	    	
	    	//path = path.replaceAll("%20", " ");
	        String imageFilePath = "f:\\2015\\yin.png"; // 水印图片路径  
	        String pdfFilePath = "f:\\2017"; // 文件生成路径  
	        String name="itext2.pdf";
	        buidPDF(pdfFilePath,imageFilePath, "", 16);  
	    }  
}
