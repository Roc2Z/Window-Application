package com.ludajiaowu3;

import javax.swing.*;
import java.text.AttributedString;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
public class QiMo extends Canvas{
	
	private static final long serialVersionUID = 1L;
	Image image;
	String[][] tValues = new String[500][50];
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //得到屏幕的尺寸 
	int width1 = screenSize.width; //宽度
	int height1 = screenSize.height; //高度
	JFrame jf1;
	
	public void newprint(){
		jf1 = new JFrame();
		jf1.setBounds(0,0,width1-100,height1-100);
		QiMo newp = new QiMo();
		new BorderLayout();
		jf1.add(newp,BorderLayout.CENTER);
		jf1.setVisible(true);
	}
	public void paint(Graphics g){
		new MyMonitor();
		tValues=MyMonitor.getTValues();
		int realWidth = 100;
		Graphics2D g2 = (Graphics2D) g;
		//记住800，和590这两个数字
		//g2.drawString("nihao",333,80);
		Rectangle2D rect = new Rectangle2D.Double(realWidth-60,10,920,660);
		Rectangle2D rect1 = new Rectangle2D.Double(realWidth,115,800,490);
		//声明并创建矩形对象，矩形的左上角是(333，100)，宽是800，高是550
		g2.draw(rect);
		g2.draw(rect1);
		g2.drawString("开课学院：", realWidth, 105);
		g2.drawString(tValues[1][2], realWidth+60, 105);
	    String s = "  " + tValues[1][0] + "  " ; 
	    //消除锯齿
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  
	    RenderingHints.VALUE_ANTIALIAS_ON); 
	    //设置字体的类型和大小
	    Font plainFont = new Font("华文细黑", Font.BOLD, 15);  
	    /*
	     * String s = "/www.java2s.com/is great." ;
	     * as.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON, 1, 15);  
	     *	as.addAttribute(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON, 18, 25);
	     * 可以根据字符串的位置进行不同形式的格式设定
	     * Java提供了 AttributedString 类， 通过
	     * attributedString.addAttribute(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
		 *	attributedString.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		 *	即可给文字添加删除线和下划线，再通过
       	 *	graphics2D.drawString(as.getIterator(), x, y);
		 *	就可以显示下划线和删除线的效果了
	     * 
	     */
	    AttributedString as = new AttributedString(s);  
	    as.addAttribute(TextAttribute.FONT, plainFont);  
	    as.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);  
	    String s1 = "学年第";
	    AttributedString as1 = new AttributedString(s1);
	    as1.addAttribute(TextAttribute.FONT,plainFont);
	    String s2 ="   " + tValues[1][1] + "   " ;
	    AttributedString as2 = new AttributedString(s2);  
	    as2.addAttribute(TextAttribute.FONT, plainFont);
	    as2.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
	    String s3 = "学期期末考试试卷袋";
	    AttributedString as3 = new AttributedString(s3);  
	    as3.addAttribute(TextAttribute.FONT, plainFont);
	    g2.drawString(as.getIterator(), 300, 80);
	    g2.drawString(as1.getIterator(), 390, 80);
	    g2.drawString(as2.getIterator(), 450, 80);
	    g2.drawString(as3.getIterator(), 500, 80);
	    //表格内横着的线
	    Line2D line = new Line2D.Double(realWidth,155,realWidth+800,155);
	    g2.draw(line);
	    
	    Line2D line1 = new Line2D.Double(realWidth,195,realWidth+800,195);
	    g2.draw(line1);
	    Line2D line2 = new Line2D.Double(realWidth,235,realWidth+800,235);
	    g2.draw(line2);
	    Line2D line3 = new Line2D.Double(realWidth,495,realWidth+800,495);
	    g2.draw(line3);
	    //表格内竖着的线
	    //第一行表格
	    Line2D line4 = new Line2D.Double(realWidth+100,115,realWidth+100,605);
	    g2.draw(line4);
	    Line2D line5 = new Line2D.Double(realWidth+200,115,realWidth+200,155);
	    g2.draw(line5);
	    Line2D line6 = new Line2D.Double(realWidth+300,115,realWidth+300,155);
	    g2.draw(line6);
	    Line2D line7 = new Line2D.Double(realWidth+600,115,realWidth+600,155);
	    g2.draw(line7);
	    Line2D line8 = new Line2D.Double(realWidth+700,115,realWidth+700,155);
	    g2.draw(line8);
	    g2.drawString("课程号", realWidth+10, 140);
	    g2.drawString(tValues[1][3], realWidth+110, 140);
	    g2.drawString("课程名", realWidth+210, 140);
	    g2.drawString(tValues[1][4], realWidth+310, 140);
	    g2.drawString("课序号", realWidth+610, 140);
	    g2.drawString(tValues[1][5], realWidth+710, 140);
	    //第二行表格
	    Line2D line9 = new Line2D.Double(realWidth+100,155,realWidth+100,195);
	    g2.draw(line9);
	    Line2D line10 = new Line2D.Double(realWidth+400,155,realWidth+400,195);
	    g2.draw(line10);
	    Line2D line11 = new Line2D.Double(realWidth+500,155,realWidth+500,195);
	    g2.draw(line11);
	    Line2D line12 = new Line2D.Double(realWidth+800,155,realWidth+800,195);
	    g2.draw(line12);
	    
	    g2.drawString("考试地点", realWidth+10, 180);
	    g2.drawString(tValues[1][6], realWidth+110, 180);
	    g2.drawString("考试时间", realWidth+410, 180);
	    g2.drawString(tValues[1][7], realWidth+510, 180);
	    
	    //第三行表格
	    Line2D line13 = new Line2D.Double(realWidth+100,195,realWidth+100,235);
	    g2.draw(line13);
	    Line2D line14 = new Line2D.Double(realWidth+200,195,realWidth+200,235);
	    g2.draw(line14);
	    Line2D line15 = new Line2D.Double(realWidth+300,195,realWidth+300,235);
	    g2.draw(line15);
	    Line2D line18 = new Line2D.Double(realWidth+400,195,realWidth+400,235);
	    g2.draw(line18);
	    Line2D line19 = new Line2D.Double(realWidth+500,195,realWidth+500,235);
	    g2.draw(line19);
	   
	    Line2D line16 = new Line2D.Double(realWidth+600,195,realWidth+600,235);
	    g2.draw(line16);
	    Line2D line17 = new Line2D.Double(realWidth+700,195,realWidth+700,235);
	    g2.draw(line17);
	    g2.drawString("考场号", realWidth+10, 220);
	    g2.drawString(tValues[1][8], realWidth+110, 220);
	    g2.drawString("座号", realWidth+210, 220);
	    g2.drawString(tValues[1][9], realWidth+310, 220);
	    g2.drawString("考场人数", realWidth+410, 220);
	    g2.drawString(tValues[1][10], realWidth+510, 220);
	    g2.drawString("任课老师", realWidth+610, 220);
	    g2.drawString(tValues[1][11], realWidth+710, 220);
	    //第四行表格
	    g2.drawString("袋内材料", realWidth+10, 340);
	    g2.drawString("及数量", realWidth+10, 360);
	    
	    g2.drawString("■考场学生名单", realWidth+110, 270);
	    g2.drawString("■试卷 共__"+tValues[1][12]+"__份", realWidth+110, 295);
	    g2.drawString("■考场记录 共__"+tValues[1][13]+"__份", realWidth+110, 320);
	    g2.drawString("□答题纸 共__"+tValues[1][14]+"__份", realWidth+110, 345);
	    g2.drawString("□答题卡 共__"+tValues[1][15]+"__份", realWidth+110, 370);
	    g2.drawString(" 其他材料说明", realWidth+110, 395);
	    
	    //第五行表格
	    Line2D line20 = new Line2D.Double(realWidth+100,565,realWidth+800,565);
	    g2.draw(line20);
	    g2.drawString("应考____人，实考____人，缺考_____人。", realWidth+110, 515);
	    g2.drawString("监考教师（签字）：", realWidth+110, 540);
	    g2.drawString("考务办公室负责人（签字）：", realWidth+110, 585);
	}
}

