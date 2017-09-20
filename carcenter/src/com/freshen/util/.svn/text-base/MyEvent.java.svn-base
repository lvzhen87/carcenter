package com.freshen.util;

import com.lowagie.text.pdf.*;  
import com.lowagie.text.*;  
import java.awt.Color;  

public class MyEvent extends PdfPageEventHelper {  
	 //  public Image headerImage;  
	 
	   /** The headertable. */  
	   public PdfPTable table;  
	  
	    /** The Graphic state */  
	    public PdfGState gstate;  
	  
	    /** A template that will hold the total number of pages. */  
	    public PdfTemplate tpl;  
	  
	    /** The font that will be used. */  
	    public BaseFont helv;  
	  
	    public void onOpenDocument(PdfWriter writer, Document document) {  
	        try {  
	            // initialization of the header table  
	      /*      headerImage = Image  
	                    .getInstance("c:logo.gif");  */
	            table = new PdfPTable(2);  
	            Phrase p = new Phrase();  
	            Chunk ck = new Chunk("leniz\n", new Font(Font.TIMES_ROMAN, 16,  
	                    Font.BOLDITALIC, Color.blue));  
	            p.add(ck);  
	            ck = new Chunk("author", new Font(Font.HELVETICA, 12, Font.NORMAL,  
	                    Color.darkGray));  
	            p.add(ck);  
	            table.getDefaultCell().setBackgroundColor(Color.yellow);  
	            table.getDefaultCell().setBorderWidth(0);  
	            table.addCell(p);  
	            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);  
	    //        table.addCell(new Phrase(new Chunk(headerImage, 0, 0)));  
	            // initialization of the Graphic State  
	            gstate = new PdfGState();  
	            gstate.setFillOpacity(0.3f);  
	            gstate.setStrokeOpacity(0.3f);  
	            // initialization of the template  
	            tpl = writer.getDirectContent().createTemplate(100, 100);  
	            tpl.setBoundingBox(new Rectangle(-20, -20, 100, 100));  
	            // initialization of the font  
	            helv = BaseFont.createFont("Helvetica", BaseFont.WINANSI, false);  
	        }  
	  
	        catch (Exception e) {  
	            throw new ExceptionConverter(e);  
	        }  
	    }  
	  
	    public void onEndPage(PdfWriter writer, Document document) {  
	        PdfContentByte cb = writer.getDirectContent();  
	        cb.saveState();  
	        // write the headertable  
	        table.setTotalWidth(document.right() - document.left());  
	        table.writeSelectedRows(0, -1, document.left(), document.getPageSize().getHeight() - 50, cb);  
	        // compose the footer  
	        String text = "Page " + writer.getPageNumber() + " of ";  
	        float textSize = helv.getWidthPoint(text, 12);  
	        float textBase = document.bottom() - 20;  
	        cb.beginText();  
	        cb.setFontAndSize(helv, 12);  
	        // for odd pagenumbers, show the footer at the left  
	        if ((writer.getPageNumber() & 1) == 1) {  
	            cb.setTextMatrix(document.left(), textBase);  
	            cb.showText(text);  
	            cb.endText();  
	            cb.addTemplate(tpl, document.left() + textSize, textBase);  
	        } else {  
	            float adjust = helv.getWidthPoint("0", 12);  
	            cb.setTextMatrix(document.right() - textSize - adjust, textBase);  
	            cb.showText(text);  
	            cb.endText();  
	            cb.addTemplate(tpl, document.right() - adjust, textBase);  
	        }  
	        cb.saveState();  
	        // draw a Rectangle around the page  
	        cb.setColorStroke(Color.red);  
	        cb.setLineWidth(2);  
	        cb.rectangle(20, 20, document.getPageSize().getWidth() - 40, document  
	                .getPageSize().getHeight() - 40);  
	        cb.stroke();  
	        cb.restoreState();  
	        // starting on page 3, a watermark with an Image that is made  
	        // transparent  
	        if (writer.getPageNumber() >= 3) {  
	            cb.setGState(gstate);  
	            cb.setColorFill(Color.red);  
	            cb.beginText();  
	            cb.setFontAndSize(helv, 48);  
	            cb.showTextAligned(Element.ALIGN_CENTER, "Watermark Opacity "  
	                    + writer.getPageNumber(),  
	                    document.getPageSize().getWidth() / 2, document.getPageSize()  
	                            .getHeight() / 2, 45);  
	           cb.endText();  
	            try {  
	             /*   cb.addImage(headerImage, headerImage.getWidth(), 0, 0, headerImage  
	                        .getHeight(), 440, 80);  */
	            } catch (Exception e) {  
	                throw new ExceptionConverter(e);  
	            }  
	            cb.restoreState();  
	        }  
	    }  
	  
	    public void onStartPage(PdfWriter writer, Document document) {  
	        if (writer.getPageNumber() < 3) {  
	            PdfContentByte cb = writer.getDirectContentUnder();  
	            cb.saveState();  
	            cb.setColorFill(Color.pink);  
	  
	            cb.beginText();  
	            cb.setFontAndSize(helv, 48);  
	            cb.showTextAligned(Element.ALIGN_CENTER, "My Watermark Under "  
	                    + writer.getPageNumber(),  
	                    document.getPageSize().getWidth() / 2, document.getPageSize()  
	                            .getHeight() / 2, 45);  
	            cb.endText();  
	            cb.restoreState();  
	        }  
	    }  
	  
	    public void onCloseDocument(PdfWriter writer, Document document) {  
	        tpl.beginText();  
	        tpl.setFontAndSize(helv, 12);  
	        tpl.setTextMatrix(0, 0);  
	        tpl.showText("" + (writer.getPageNumber() - 1));  
	        tpl.endText();  
	    }  
	  
}  