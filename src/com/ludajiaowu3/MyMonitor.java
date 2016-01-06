package com.ludajiaowu3;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.swing.JFrame;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TextAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageSz;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPageOrientation;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;

import java.awt.FileDialog;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.List;
//�ļ��˵�����Ĺ���ʵ��
class MyMonitor implements ActionListener{
	private JFrame jf;
	private FileDialog fd_load;
	private FileDialog fd_save;
	private TextArea ta;
//	public XSSFCell cellValue; 
	//�˴������¼���
	static String d,f,g,h,y,z;
	private static XSSFWorkbook xssfWorkbook;
	private static HSSFWorkbook hssfWorkbook;
	static int maxRow;
	private static int maxCol;
	static String[][] tValues = new String[500][50];
	static String[] trueValues = new String[500];
	static String s[] = new String[500];
	public void getValues(String str,int i,int j){
		MyMonitor.setMaxCol(j);
		MyMonitor.setMaxRow(i);
	}
	public void actionPerformed(ActionEvent e){
		fd_load = new FileDialog(jf,"���ļ�",FileDialog.LOAD);
		fd_save = new FileDialog(jf,"���ļ�",FileDialog.SAVE);
		String s = e.getActionCommand();
		if(s.equals("�˳�")){
			System.exit(0);
		}else if((s.equals("��"))||(s.equals("����excle"))){
			//�����ļ��򿪴���ɼ�
			fd_load.setVisible(true);
			d = fd_load.getDirectory();
			f = fd_load.getFile();
			this.loadValues();
		}else if(s.equals("����doc�ĵ�")){
			new MyJDialog(new MyFrame().jf).setVisible(true);
			
//			fd_save.setVisible(true);
//		    g = fd_save.getDirectory();
//			h = fd_save.getFile();
//			this.createDoc();
		}else if(s.equals("��ĩ�����Ծ�������ǩ")){
			QiMo newprint = new QiMo();
			newprint.newprint();
		}else if(s.equals("������Ծ��")){
			JKe newP = new JKe();
			newP.newprint1();
			//Ԥ��
		}else if(s.equals("��ĩ�����Ծ������")){
			fd_save.setVisible(true);
		    y = fd_save.getDirectory();
			z = fd_save.getFile();
			this.createDoc();
			this.printJob(y, z);
			
		}else if(s.equals("������Ծ������")){
			fd_save.setVisible(true);
		    g = fd_save.getDirectory();
			h = fd_save.getFile();
			this.createDoc2();
			this.printJob(g, h);
			//��ӡ 
		}else if(s.equals("������Ծ��Ƥ")){
			fd_save.setVisible(true);
		    g = fd_save.getDirectory();
			h = fd_save.getFile();
			this.createDoc2();
			
		}else if(s.equals("��ĩ�Ծ��Ƥ")){
			fd_save.setVisible(true);
		    y = fd_save.getDirectory();
			z = fd_save.getFile();
			this.createDoc();
			//����
		}else if(s.equals("�����ĵ�")){
			
			new Help(jf);
			
		}
	}	
	
	public void printJob(String a,String b){
		  
          
           File file = new File(a+"\\"+b+".docx"); //��ȡѡ����ļ�   
           //������ӡ�������Լ�   
           HashPrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();   
           //���ô�ӡ��ʽ����Ϊδȷ�����ͣ�����ѡ��autosense   
           DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;   
           //�������еĿ��õĴ�ӡ����   
           PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);   
           //��λĬ�ϵĴ�ӡ����   
           PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();   
           //��ʾ��ӡ�Ի���   
           PrintService service = ServiceUI.printDialog(null, 200, 200, printService,    
                   defaultService, flavor, pras);   
           if(service != null){   
               try {   
                   DocPrintJob job = service.createPrintJob(); //������ӡ��ҵ   
                   FileInputStream fis = new FileInputStream(file); //�������ӡ���ļ���   
                   DocAttributeSet das = new HashDocAttributeSet();   
                   Doc doc = new SimpleDoc(fis, flavor, das);   
                   job.print(doc, pras);   
               } catch (Exception e) {   
                   e.printStackTrace();   
               }   
           }   
       
		
		
	}
	public void loadValues(){
		if((d!=null)&&(f!=null)){
			try {
				if (f.endsWith("xls")) {  
					hssfWorkbook =  new HSSFWorkbook(new FileInputStream(new File(d+f)));
					HSSFSheet sheet = hssfWorkbook.getSheetAt(0);
					// ���� row��cell  
					HSSFRow row; 
					String cell = null;
					HSSFCell cellValue;
					// ѭ���������е�����  
					//row����Ϊ�У�cell����Ϊ��
					for(int zz=0;zz<500;zz++){
						for(int yy=0;yy<12;yy++){
							tValues[zz][yy]=null;
							new MyFrame().returnValues(null, zz, yy);
							
						}
						
					}
					for (int i=sheet.getFirstRowNum();i<=sheet.getPhysicalNumberOfRows();i++) {  
					    row = sheet.getRow(i);
					    if(row==null){
					    	break;
					    }
					    for (int j=row.getFirstCellNum();j<row.getLastCellNum();j++) {  
					        // ͨ�� row.getCell(j).toString() ��ȡ��Ԫ�����ݣ�
					    	cellValue = row.getCell(j);
					    	if(cellValue!=null){
					    		if(cellValue.getCellType()==XSSFCell.CELL_TYPE_NUMERIC){
					    			DecimalFormat df = new DecimalFormat("0");  
					    			cell = df.format(cellValue.getNumericCellValue());  
					    		}else{
					    			cell = row.getCell(j).toString();
					    		}
					    	}
					    	tValues[i][j] = cell;
					    	//ȡ�õ�һ�е�����
					    	int number = row.getLastCellNum();
					    	if(number<20){
					    		new MyFrame().returnValues(cell, i, j);
					    	}
					    }  
					}
	            } else {  
//	            	File file = new File(d+f);
//	            	OPCPackage opcPackage = OPCPackage.open(file);
	            	xssfWorkbook = new XSSFWorkbook(d+f);
	            	XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
	            	// ���� row��cell  
					XSSFRow row; 
					String cell = null;
					XSSFCell cellValue;
					// ѭ���������е�����  
					//row����Ϊ�У�cell����Ϊ��
					for(int zz=0;zz<500;zz++){
						for(int yy=0;yy<12;yy++){
							tValues[zz][yy]=null;
							new MyFrame().returnValues(null, zz, yy);
							
						}
						
					}
					for (int i=sheet.getFirstRowNum();i<=sheet.getPhysicalNumberOfRows();i++) {  
					    row = sheet.getRow(i);
					    if(row==null){
					    	break;
					    }
					    for (int j=row.getFirstCellNum();j<row.getLastCellNum();j++) {  
					        // ͨ�� row.getCell(j).toString() ��ȡ��Ԫ�����ݣ�
					    	cellValue = row.getCell(j);
					    	if(cellValue!=null){
					    		if(cellValue.getCellType()==XSSFCell.CELL_TYPE_NUMERIC){
					    			DecimalFormat df = new DecimalFormat("0");  
					    			cell = df.format(cellValue.getNumericCellValue());
					    		}else{
					    			cell = row.getCell(j).toString();
					    		}
					    	}
					    	tValues[i][j] = cell;
					    	//ȡ�õ�һ�е�����
					    	int number = row.getLastCellNum();
					    	if(number<20){
					    		new MyFrame().returnValues(cell, i, j);
					    	}
	                        
					    }  
					}
	            } 
				// ��ȡ��һ�±������  
				 
					
			}catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
	//��ĩ�����Ծ����Ƥ
	public void createDoc(){
		XWPFDocument doc = new XWPFDocument();
		for(int k=0;k<=getMaxRow();k++){
			for(int j=0;j<getMaxCol();j++){
					trueValues[j] = tValues[k][j];
			}
			//����ҳ�淽��ҳ���С��ע����������ô�С��ҳ�淽��������
			
			CTDocument1 document = doc.getDocument();
			CTBody body = document.getBody();
			if(!body.isSetSectPr()){
				body.addNewSectPr();
			}
			CTSectPr section = body.getSectPr();
			if(!section.isSetPgSz()){
				section.addNewPgSz();
			}
			CTPageSz pageSize = section.getPgSz();
			pageSize.setW(BigInteger.valueOf(16875));
			pageSize.setH(BigInteger.valueOf(11700));
			pageSize.setOrient(STPageOrientation.LANDSCAPE);
			XWPFParagraph p1 = doc.createParagraph();
			p1.setAlignment(ParagraphAlignment.CENTER);
			XWPFRun r1 = p1.createRun();
			r1.setText("   "+tValues[k][0]+"   ");
			r1.setBold(true);
			r1.setFontSize(15);
			r1.setFontFamily("����ϸ��");
			r1.setUnderline(UnderlinePatterns.SINGLE);
			r1.setTextPosition(40);
			XWPFRun r2 = p1.createRun();
			r2.setText(" ѧ��� ");
			r2.setBold(true);
			r2.setFontFamily("����ϸ��");
			r2.setFontSize(15);
			r2.setTextPosition(40);
			XWPFRun r3 = p1.createRun();
			r3.setText("   "+tValues[k][1]+"      ");
			r3.setBold(true);
			r3.setFontFamily("����ϸ��");
			r3.setFontSize(15);
			r3.setUnderline(UnderlinePatterns.SINGLE);
			r3.setTextPosition(40);
			XWPFRun r4 = p1.createRun();
			r4.setText(" ѧ����ĩ�����Ծ��");
			r4.setFontFamily("����ϸ��");
			r4.setFontSize(15);
			r4.setBold(true);
			r4.setTextPosition(40);
			XWPFParagraph p2 = doc.createParagraph();
			XWPFRun r5 = p2.createRun();
			r5.setText("����ѧԺ��");
			r5.setFontSize(15);
			r5.setFontFamily("����ϸ��");
			r5.setTextPosition(20);
			XWPFRun r6 = p2.createRun();
			r6.setText(tValues[k][2]);
			r6.setFontSize(15);
			r6.setFontFamily("����ϸ��");
			r6.setTextPosition(20);
		    //����һ��5��5�еı��
//		    XWPFTable table = doc.createTable(5, 2);
			XWPFTable table = doc.createTable(5, 5);
		    //�������ӵ���ԭ����ʼ����������5����ͨ��getTableCells()������ȡʱ��ȡ��������ͨ��row�����ľͿ��ԡ�
//		    table.addNewCol(); //���������һ�У����6��
//		    table.createRow(); //���������һ�У����6��
//		    List<XWPFTableRow> rows = table.getRows();
		    List<XWPFTableRow> rows = table.getRows(); 
		    //�������
		    CTTblPr tablePr = table.getCTTbl().addNewTblPr();
		    //�����
		    //CTTblWidth width = tablePr.addNewTblW();
		    //width.setW(BigInteger.valueOf(2000));
		    XWPFTableRow row;
		    List<XWPFTableCell> cells;
//		    List<XWPFTableCell> xiaoCells;
		    XWPFTableCell cell;
		    int rowSize = rows.size();
		    int cellSize;
		    for (int i=0; i<rowSize; i++) {
		       row = rows.get(i);
		       //������Ԫ��
		       if(i==2){
		    	   row.addNewTableCell();
	        	   row.addNewTableCell();
	        	   row.addNewTableCell();
	        	   row.addNewTableCell();
	        	   row.addNewTableCell();
	        	   row.addNewTableCell();
	        	  
		       }
		       if(i==0){
		    	   row.addNewTableCell();
		    	   row.addNewTableCell();
		    	   row.addNewTableCell();
		    	   row.addNewTableCell();
		       }
		       if(i==1){
		    	   row.addNewTableCell();
		    	   row.addNewTableCell();
		       }
		       row.setHeight(600);
		       cells = row.getTableCells();
		       cellSize = cells.size();
	           for (int j=0; j<cellSize; j++) {
	        	   cell = cells.get(j);
		           //��Ԫ������
		           CTTcPr cellPr = cell.getCTTc().addNewTcPr();
		           cellPr.addNewVAlign().setVal(STVerticalJc.CENTER);

		           
		           if(i==0&&j==0){
		        	   cellPr.addNewTcW().setW(BigInteger.valueOf(1700));
		        	   cell.setText("�γ̺�");
		           }
		           if (i==0&&j==1) {
		               //���ÿ��
		               cellPr.addNewTcW().setW(BigInteger.valueOf(1800));
		               cell.setText(tValues[k][3]);
		           }
		           if(i==0&&j==2){
		        	   cellPr.addNewTcW().setW(BigInteger.valueOf(1700));
		        	   cell.setText("�γ���");
		           }
		           if (i==0&&j==3) {
		               //���ÿ��
		               cellPr.addNewTcW().setW(BigInteger.valueOf(5000));
		               cell.setText(tValues[k][4]);
		           }
		           if(i==0&&j==4){
		        	   cellPr.addNewTcW().setW(BigInteger.valueOf(1700));
		        	   cell.setText("�����");
		           }
		           if(i==0&&j==5){
		        	   cellPr.addNewTcW().setW(BigInteger.valueOf(1700));
		        	   cell.setText(tValues[k][5]);
		           }
		           if(i==1&&j==0){
		        	   cellPr.addNewTcW().setW(BigInteger.valueOf(1700));
		        	   cell.setText("���Եص�");
		        	   
		           }
		           if (i==1&&j==1) {
		               //���ÿ��
		               cellPr.addNewTcW().setW(BigInteger.valueOf(5100));
		               cell.setText(tValues[k][6]);
		           }
		           if(i==1&&j==2){
		        	   cellPr.addNewTcW().setW(BigInteger.valueOf(1700));
		        	   cell.setText("����ʱ��");
		           }
		           if (i==1&&j==3) {
		               //���ÿ��
		               cellPr.addNewTcW().setW(BigInteger.valueOf(5100));
		               cell.setText(tValues[k][7]);
		           }
		           if(i==1&&j==4){
		        	  
		        	   cellPr.addNewTcW().setW(BigInteger.valueOf(-1));
		        	   
		           }
		           if(i==1&&j==5){
		        	   
		        	   cellPr.addNewTcW().setW(BigInteger.valueOf(0));
		        	  
		           }
		           if(i==2){
		               if(j==0){
			        	   cellPr.addNewTcW().setW(BigInteger.valueOf(1700));
			        	   cell.setText("������");
			        	   
			           }
			           if (j==1) {
			               //���ÿ��
			               cellPr.addNewTcW().setW(BigInteger.valueOf(1800));
			               cell.setText(tValues[k][8]);
			           }
			           if(j==2){
			        	   cellPr.addNewTcW().setW(BigInteger.valueOf(1700));
			        	   cell.setText("����");
			           }
			           if (j==3) {
			               //���ÿ��
			               cellPr.addNewTcW().setW(BigInteger.valueOf(1600));
			             
			               
			               cell.setText(tValues[k][9]);
			           }
			           if(j==4){
			        	   cellPr.addNewTcW().setW(BigInteger.valueOf(1700));
			        	   cell.setText("��������");
			           }
			           if(j==5){
			        	   cellPr.addNewTcW().setW(BigInteger.valueOf(1700));
			        	   cell.setText(tValues[k][10]);
			           }
			           if(j==6){
			        	   cellPr.addNewTcW().setW(BigInteger.valueOf(1700));
			        	   cell.setText("�ο���ʦ");
			           }
			           if(j==7){
			        	   cellPr.addNewTcW().setW(BigInteger.valueOf(1700));
			        	   cell.setText(tValues[k][11]);
			           }
		        	   
		           }
		           if(i==3){
		        	   row.setHeight(3000);
		        	   if(j==0){
		        		   cellPr.addNewTcW().setW(BigInteger.valueOf(1700));
			        	   cell.setText("���ڲ��ϼ�����");
		        		   
		        	   }
		        	  
		        	   if(j==1){
		        		   cellPr.addNewTcW().setW(BigInteger.valueOf(11900));
		        		   XWPFParagraph pp = cell.addParagraph();
		        		   XWPFRun rr = pp.createRun();
		        		   rr.setText("������ѧ������");
		        		   rr.setTextPosition(30);
		        		   rr.addBreak();
		        		   XWPFRun rr1 = pp.createRun();
		        		   rr1.setText("���Ծ� ��__"+tValues[k][12]+"__��");
		        		   rr1.setTextPosition(30);
		        		   rr1.addBreak();
		        		   XWPFRun rr2 = pp.createRun();
		        		   rr2.setText("��������¼ ��__"+tValues[k][13]+"__��");
		        		   rr2.setTextPosition(30);
		        		   rr2.addBreak();
		        		   XWPFRun rr3 = pp.createRun();
		        		   rr3.setText("������ֽ ��__"+tValues[k][14]+"__��");
		        		   rr3.setTextPosition(30);
		        		   rr3.addBreak();
		        		   XWPFRun rr4 = pp.createRun();
		        		   rr4.setText("�����⿨ ��__"+tValues[k][15]+"__��");
		        		   rr4.setTextPosition(40);
		        		   rr4.addBreak();
		        	   }
		        	   if(j==2){
		        		   cellPr.addNewTcW().setW(BigInteger.valueOf(0));
		        	   }
						if(j==3){
							cellPr.addNewTcW().setW(BigInteger.valueOf(0));
						}
						if(j==4){
							cellPr.addNewTcW().setW(BigInteger.valueOf(0));
						}
						if(j==5){
							cellPr.addNewTcW().setW(BigInteger.valueOf(0));
						}
		           }
		           if(i==4){
		        	   row.setHeight(1200);
		        	   if(j==0){
		        		   cellPr.addNewTcW().setW(BigInteger.valueOf(1700));
			        	   cell.setText("");
		        	   }
		        	   if(j==1){
		        		   cellPr.addNewTcW().setW(BigInteger.valueOf(11900));
		        		   XWPFParagraph pp = cell.addParagraph();
		        		   XWPFRun rr = pp.createRun();
		        		   rr.setText("Ӧ��____�ˣ�ʵ��____�ˣ�ȱ��_____�ˡ�");
		        		   rr.setTextPosition(30);
		        		   rr.addBreak();
		        		   XWPFRun rr1 = pp.createRun();
		        		   rr1.setText("�࿼��ʦ��ǩ�֣���");
		        		   rr1.setTextPosition(50);
		        		   rr1.addBreak();
		        		   XWPFRun rr2 = pp.createRun();
		        		   rr2.setText("����칫�Ҹ����ˣ�ǩ�֣���");
		        		   rr2.addBreak();
		        	   }
		        	   if(j==2){
		        		   cellPr.addNewTcW().setW(BigInteger.valueOf(0));
		        		   row.setHeight(0);
		        	   }if(j==3){
		        		   cellPr.addNewTcW().setW(BigInteger.valueOf(0));
		        		   row.setHeight(0);
					   }if(j==4){
					       cellPr.addNewTcW().setW(BigInteger.valueOf(0));
					    row.setHeight(0);
					   }if(j==5){
						   cellPr.addNewTcW().setW(BigInteger.valueOf(0));
						   row.setHeight(0);
					   }
		           }
		        }
		    }
		}
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(y+"\\"+z+".docx");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			doc.write(out);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	     try {
			out.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
	public void createDoc4(){
		XWPFDocument doc = new XWPFDocument();
		for(int k=0;k<getMaxRow();k++){
			for(int j=0;j<getMaxCol();j++){
					trueValues[j] = tValues[k][j];
			}
			//����ҳ�淽��ҳ���С��ע����������ô�С��ҳ�淽��������
			
			CTDocument1 document = doc.getDocument();
			CTBody body = document.getBody();
			if(!body.isSetSectPr()){
				body.addNewSectPr();
			}
			CTSectPr section = body.getSectPr();
			if(!section.isSetPgSz()){
				section.addNewPgSz();
			}
			CTPageSz pageSize = section.getPgSz();
			pageSize.setW(BigInteger.valueOf(16875));
			pageSize.setH(BigInteger.valueOf(11700));
			pageSize.setOrient(STPageOrientation.LANDSCAPE);
			XWPFParagraph p1 = doc.createParagraph();
			p1.setAlignment(ParagraphAlignment.CENTER);
			XWPFRun r1 = p1.createRun();
			r1.setText("   "+tValues[k][0]+"   ");
			r1.setBold(true);
			r1.setFontSize(15);
			r1.setFontFamily("����ϸ��");
			r1.setUnderline(UnderlinePatterns.SINGLE);
			r1.setTextPosition(40);
			XWPFRun r2 = p1.createRun();
			r2.setText(" ѧ��� ");
			r2.setBold(true);
			r2.setFontFamily("����ϸ��");
			r2.setFontSize(15);
			r2.setTextPosition(40);
			XWPFRun r3 = p1.createRun();
			r3.setText("   "+tValues[k][1]+"      ");
			r3.setBold(true);
			r3.setFontFamily("����ϸ��");
			r3.setFontSize(15);
			r3.setUnderline(UnderlinePatterns.SINGLE);
			r3.setTextPosition(40);
			XWPFRun r4 = p1.createRun();
			r4.setText(" ѧ����ĩ�����Ծ��");
			r4.setFontFamily("����ϸ��");
			r4.setFontSize(15);
			r4.setBold(true);
			r4.setTextPosition(40);
			XWPFParagraph p2 = doc.createParagraph();
			XWPFRun r5 = p2.createRun();
			r5.setText("����ѧԺ��");
			r5.setFontSize(15);
			r5.setFontFamily("����ϸ��");
			r5.setTextPosition(20);
			XWPFRun r6 = p2.createRun();
			r6.setText(tValues[k][2]);
			r6.setFontSize(15);
			r6.setFontFamily("����ϸ��");
			r6.setTextPosition(20);
		    //����һ��5��5�еı��
		    XWPFTable table = doc.createTable(1, 6);
		    XWPFTable table1 = doc.createTable(1, 4);
		    XWPFTable table2 = doc.createTable(1, 8);
		    XWPFTable table3 = doc.createTable(1, 2);
		    XWPFTable table4 = doc.createTable(1, 2);
		    //�������ӵ���ԭ����ʼ����������5����ͨ��getTableCells()������ȡʱ��ȡ��������ͨ��row�����ľͿ��ԡ�
//		    table.addNewCol(); //���������һ�У����6��
//		    table.createRow(); //���������һ�У����6��
		    List<XWPFTableRow> rows = table.getRows();
		    List<XWPFTableRow> rows1 = table1.getRows();
		    List<XWPFTableRow> rows2 = table2.getRows();
		    List<XWPFTableRow> rows3 = table3.getRows();
		    List<XWPFTableRow> rows4 = table4.getRows();
		    //�������
		    
		    //�����
		    //CTTblWidth width = tablePr.addNewTblW();
		    //width.setW(BigInteger.valueOf(2000));
		    XWPFTableRow row;
		    List<XWPFTableCell> cells;
		    XWPFTableCell cell;
		    int cellSize;
            row = rows.get(0);		   
		    row.setHeight(600);
		    cells = row.getTableCells();
		    cellSize = cells.size();
		    
		    XWPFTableRow row1;
		    List<XWPFTableCell> cells1;
		    XWPFTableCell cell1;
		    int cellSize1;
            row1 = rows1.get(0);		   
		    row1.setHeight(600);
		    cells1 = row1.getTableCells();
		    cellSize1 = cells1.size();
		    
		    XWPFTableRow row2;
		    List<XWPFTableCell> cells2;
		    XWPFTableCell cell2;
		    int cellSize2;
            row2 = rows2.get(0);		   
		    row2.setHeight(600);
		    cells2 = row2.getTableCells();
		    cellSize2 = cells2.size();
		    
		    XWPFTableRow row3;
		    List<XWPFTableCell> cells3;
		    XWPFTableCell cell3;
		    int cellSize3;
            row3 = rows3.get(0);		   
            row3.setHeight(3000);
		    cells3 = row3.getTableCells();
		    cellSize3 = cells3.size();
		    
		    XWPFTableRow row4;
		    List<XWPFTableCell> cells4;
		    XWPFTableCell cell4;
		    int cellSize4;
            row4 = rows4.get(0);		   
            row4.setHeight(1200);
		    cells4 = row1.getTableCells();
		    cellSize4 = cells4.size();
		    
		    
		    

	           for(int j=0; j<cellSize4; j++){
	        	   cell4 = cells4.get(j);
		           //��Ԫ������
		           CTTcPr cellPr4 = cell4.getCTTc().addNewTcPr();
		           cellPr4.addNewVAlign().setVal(STVerticalJc.CENTER);
		           
	        	   if(j==0){
	        		   cellPr4.addNewTcW().setW(BigInteger.valueOf(1700));
		        	   cell4.setText("");
	        	   }
	        	   if(j==1){
	        		   cellPr4.addNewTcW().setW(BigInteger.valueOf(11900));
	        		   XWPFParagraph pp2 = cell4.addParagraph();
	        		   XWPFRun rr = pp2.createRun();
	        		   rr.setText("Ӧ��____�ˣ�ʵ��____�ˣ�ȱ��_____�ˡ�");
	        		   rr.setTextPosition(30);
	        		   rr.addBreak();
	        		   XWPFRun rr1 = pp2.createRun();
	        		   rr1.setText("�࿼��ʦ��ǩ�֣���");
	        		   rr1.setTextPosition(50);
	        		   rr1.addBreak();
	        		   XWPFRun rr2 = pp2.createRun();
	        		   rr2.setText("����칫�Ҹ����ˣ�ǩ�֣���");
	        		   rr2.addBreak();
	        	   }
	        	   
	           }
		        
		    }
		
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(y+"\\"+z+".docx");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			doc.write(out);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	     try {
			out.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		    
	}
	//����Ŀ��Դ���Ƥ
	public void createDoc1(){
		XWPFDocument doc = new XWPFDocument();
		for(int i=0;i<=getMaxRow();i++){
			for(int j=0;j<getMaxCol();j++){
					trueValues[j] = tValues[i][j];
			}
			XWPFParagraph p1 = doc.createParagraph();
		     //�����ı�����
		     p1.setAlignment(ParagraphAlignment.LEFT);
		     //�����ַ�ƫ��
		     p1.setVerticalAlignment(TextAlignment.BOTTOM);
		     //�����ı�
		     XWPFRun r1 = p1.createRun();
		     r1.setBold(true);//���ô���
		     r1.setFontSize(10);//���ô�С
		     r1.setText((String) tValues[i][0]);
		     r1.setFontFamily("Courier");//����������ʽ
		     r1.setTextPosition(200);
		     XWPFParagraph p2 = doc.createParagraph();
		     p2.setAlignment(ParagraphAlignment.CENTER);
		     XWPFRun r2 = p2.createRun();
		     r2.setText("³����ѧ�Ծ��Ƥ��");
		     r2.setFontSize(38);
		     r2.setBold(true);
		     r2.setTextPosition(130);
		     XWPFParagraph p3 = doc.createParagraph();
		     p3.setAlignment(ParagraphAlignment.CENTER);
		     XWPFRun r3 = p3.createRun();
		     r3.setText("��������:");
		     r3.setFontSize(25);
		     r3.setTextPosition(210);
		     r3.setBold(true);
		     XWPFRun r4 = p3.createRun();
		     r4.setText("�վ���");
		     r4.setUnderline(UnderlinePatterns.SINGLE);
		     r4.setFontSize(20);
		     r4.setTextPosition(210);
		     r4.setBold(true);
		     XWPFParagraph p4 = doc.createParagraph();
		     p4.setAlignment(ParagraphAlignment.CENTER);
		     XWPFRun r5 = p4.createRun();
		     r5.setText("���Կ�Ŀ:");
		     r5.setFontSize(13);
		     r5.setTextPosition(30);
		     r5.setBold(true);
		     XWPFRun r6 = p4.createRun();
		     r6.setText("���ӻ��������ʵ���");
		     r6.setUnderline(UnderlinePatterns.SINGLE);
		     r6.setFontSize(13);
		     r6.setTextPosition(30);
		     r6.setBold(true);
		     XWPFParagraph p5 = doc.createParagraph();
		     p5.setAlignment(ParagraphAlignment.CENTER);
		     XWPFRun r8 = p5.createRun();
		     r8.setText("����ʱ��:");
		     r8.setFontSize(13);
		     r8.setBold(true);
		     r8.setTextPosition(30);
		     XWPFRun r9 = p5.createRun();
		     r9.setText((String) tValues[i][5]);
		     r9.setUnderline(UnderlinePatterns.SINGLE);
		     r9.setFontSize(13);
		     r9.setBold(true);
		     r9.setTextPosition(30);
		     XWPFParagraph p6 = doc.createParagraph();
		     p6.setAlignment(ParagraphAlignment.CENTER);
		     XWPFRun r10 = p6.createRun();
		     r10.setText("�࿼��Ա:");
		     r10.setFontSize(13);
		     r10.setBold(true);
		     r10.setTextPosition(300);
		     XWPFRun r11 = p6.createRun();
		     r11.setText((String) tValues[i][4]);
		     r11.setUnderline(UnderlinePatterns.SINGLE);
		     r11.setFontSize(13);
		     r11.setBold(true);
		     r11.setTextPosition(300);
		     XWPFParagraph p7 = doc.createParagraph();
		     p7.setAlignment(ParagraphAlignment.LEFT);
		     XWPFRun r12 = p7.createRun();
		     r12.setText("��ע:");
		     r12.setFontSize(9);
		     r12.setBold(true);
		     XWPFRun r13 = p7.createRun();
		     r13.setText((String) tValues[i][8]);
		     r13.setFontSize(9);
		     r13.setBold(true); 
		     r13.addBreak(BreakType.PAGE);
		}
		
		FileOutputStream out = null;
		
		try {
			out = new FileOutputStream(g+"\\"+h+".docx");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			doc.write(out);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	     try {
			out.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	//����ܿ��Դ���Ƥ
	
	public void createDoc2(){
		//���ú���ģ��
		XWPFDocument doc = new XWPFDocument();
		CTDocument1 document = doc.getDocument();
		CTBody body = document.getBody();

		if (!body.isSetSectPr()) {
		     body.addNewSectPr();
		}
		CTSectPr section = body.getSectPr();

		if(!section.isSetPgSz()) {
		    section.addNewPgSz();
		}
		CTPageSz pageSize = section.getPgSz();

		pageSize.setW(BigInteger.valueOf(18400));
		pageSize.setH(BigInteger.valueOf(13400));
		pageSize.setOrient(STPageOrientation.LANDSCAPE);
		for(int i=0;i<=getMaxRow();i++){
			for(int j=0;j<getMaxCol();j++){
					trueValues[j] = tValues[i][j];
			}
			
			XWPFParagraph p1 = doc.createParagraph();
			
		     //�����ı�����
		     p1.setAlignment(ParagraphAlignment.CENTER);
		     //�����ַ�ƫ��
		     p1.setVerticalAlignment(TextAlignment.BOTTOM);
		     //�����ı�
		     XWPFRun r1 = p1.createRun();
		     r1.setBold(true);//���ô���
		     r1.setFontSize(38);//���ô�С
		     r1.setText((String) tValues[i][0]);
		     r1.setFontFamily("����ϸ��");//����������ʽ
		     r1.setTextPosition(2);
		     //r1.setTextPosition(200);
		     XWPFParagraph p2 = doc.createParagraph();
		     p2.setAlignment(ParagraphAlignment.CENTER);
		     XWPFRun r2 = p2.createRun();
		     r2.setText((String)tValues[i][1]);
		     r2.setFontFamily("����ϸ��");
		     r2.setFontSize(38);
		     r2.setBold(true);
		     r2.setTextPosition(180);
		     XWPFParagraph p3 = doc.createParagraph();
		     p3.setAlignment(ParagraphAlignment.LEFT);
		     
		     XWPFRun r3 = p3.createRun();
		     r3.setText("�γ̺�:");
		     r3.setBold(true);
		     r3.setFontFamily("����ϸ��");
		     r3.setFontSize(28);
		     r3.setTextPosition(30);
		     XWPFRun r4 = p3.createRun();
		     r4.setText((String)tValues[i][2]);
		     r4.setFontFamily("����ϸ��");
		     r4.setFontSize(28);
		     r4.setBold(true);
		     r4.setTextPosition(30);
		     XWPFParagraph p4 = doc.createParagraph();
		     p4.setAlignment(ParagraphAlignment.LEFT);
		     XWPFRun r5 = p4.createRun();
		     r5.setText("�γ���:");
		     r5.setBold(true);
		     r5.setFontFamily("����ϸ��");
		     r5.setFontSize(28);
		     r5.setTextPosition(30);
		     XWPFRun r6 = p4.createRun();
		     r6.setText((String)tValues[i][3]);
		     r6.setFontFamily("����ϸ��");
		     r6.setFontSize(28);
		     r6.setBold(true);
		     r6.setTextPosition(30);
		     XWPFParagraph p5 = doc.createParagraph();
		     p5.setAlignment(ParagraphAlignment.LEFT);
		     XWPFRun r7 = p5.createRun();
		     r7.setText("������ʦ:");
		     r7.setBold(true);
		     r7.setFontFamily("����ϸ��");
		     r7.setFontSize(28);
		     r7.setTextPosition(30);
		     XWPFRun r8 = p5.createRun();
		     r8.setText((String)tValues[i][4]);
		     r8.setFontFamily("����ϸ��");
		     r8.setBold(true);
		     r8.setFontSize(28);
		     r8.setTextPosition(30);
		     XWPFParagraph p6 = doc.createParagraph();
		     p6.setAlignment(ParagraphAlignment.LEFT);
		     XWPFRun r9 = p6.createRun();
		     r9.setText("�Ͽΰ༶:");
		     r9.setBold(true);
		     r9.setFontFamily("����ϸ��");
		     r9.setFontSize(28);
		     r9.setTextPosition(30);
		     XWPFRun r10 = p6.createRun();
		     r10.setText((String)tValues[i][5]);
		     r10.setFontFamily("����ϸ��");
		     r10.setBold(true);
		     r10.setFontSize(28);
		     r10.setTextPosition(30);
		     r10.addBreak(BreakType.PAGE);
		}
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(g+"\\"+h+".docx");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			doc.write(out);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	     try {
			out.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	     
	}
	public void saveFile(){
		String content = ta.getText();
		try{
			PrintWriter pw = new PrintWriter(new FileWriter(g+h));
			pw.println(content);
			pw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static String[][] getTValues(){
		
		return tValues;
		
	}
	public static int getMaxCol() {
		return maxCol;
	}
	public static void setMaxCol(int maxCol) {
		MyMonitor.maxCol = maxCol;
	}
	public static int getMaxRow() {
		return maxRow;
	}
	public static void setMaxRow(int maxRow) {
		MyMonitor.maxRow = maxRow;
	}

}
