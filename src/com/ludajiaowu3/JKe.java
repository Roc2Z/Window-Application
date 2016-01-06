package com.ludajiaowu3;

import javax.swing.*;
import java.text.AttributedString;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.geom.Rectangle2D;
public class JKe extends Canvas{
	
	private static final long serialVersionUID = 1L;
	String[][] tValues = new String[500][50];
	Image image;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //得到屏幕的尺寸 
	int width1 = screenSize.width; //宽度
	int height1 = screenSize.height; //高度
	JFrame jf2 = new JFrame();
	public void newprint1(){
		jf2.setBounds(0,0,width1-100,height1-100);
		JKe jk = new JKe();
		new BorderLayout();
		jf2.add(jk,BorderLayout.CENTER);
		jf2.setVisible(true);
	}
	public void paint(Graphics g){
		new MyMonitor();
		tValues = MyMonitor.getTValues();
		Graphics2D gg2 = (Graphics2D) g;
		//记住800，和590这两个数字
		//gg2.drawString("nihao",333,80);
		Rectangle2D rect = new Rectangle2D.Double(100,30,800,554);
		gg2.draw(rect);
		String ss = tValues[1][0] ; 
		String ss1 = tValues[1][1];
		String ss2 = "课程号：";
		String ss3 = tValues[1][2];
		String ss4 = "课程名：";
		String ss5 = tValues[1][3];
		String ss6 = "主讲教师：";
		String ss7 = tValues[1][4];
		String ss8 = "上课班级：";
		String ss9 = tValues[1][5];
		//设置字体的类型和大小
		Font plainFonts = new Font("黑体", Font.BOLD, 28);
		Font plainFonts1 = new Font("黑体", Font.BOLD, 18);
		//消除锯齿
		gg2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  
		RenderingHints.VALUE_ANTIALIAS_ON); 
	  
	    AttributedString as = new AttributedString(ss);  
	    as.addAttribute(TextAttribute.FONT, plainFonts);  
	    gg2.drawString(as.getIterator(), 240, 120);
	    AttributedString as1 = new AttributedString(ss1);  
	    as1.addAttribute(TextAttribute.FONT, plainFonts);  
	    gg2.drawString(as1.getIterator(), 360, 160);
	    AttributedString as2 = new AttributedString(ss2);  
	    as2.addAttribute(TextAttribute.FONT, plainFonts1);  
	    gg2.drawString(as2.getIterator(), 170, 320);
	    AttributedString as3 = new AttributedString(ss3);  
	    as3.addAttribute(TextAttribute.FONT, plainFonts1);  
	    gg2.drawString(as3.getIterator(), 235, 320);
	    AttributedString as4 = new AttributedString(ss4);  
	    as4.addAttribute(TextAttribute.FONT, plainFonts1);  
	    gg2.drawString(as4.getIterator(), 170, 350);
	    AttributedString as5 = new AttributedString(ss5);  
	    as5.addAttribute(TextAttribute.FONT, plainFonts1);  
	    gg2.drawString(as5.getIterator(), 235, 350);
	    AttributedString as6 = new AttributedString(ss6);  
	    as6.addAttribute(TextAttribute.FONT, plainFonts1);  
	    gg2.drawString(as6.getIterator(), 170, 380);
	    AttributedString as7 = new AttributedString(ss7);  
	    as7.addAttribute(TextAttribute.FONT, plainFonts1);  
	    gg2.drawString(as7.getIterator(), 265, 380);
	    AttributedString as8 = new AttributedString(ss8);  
	    as8.addAttribute(TextAttribute.FONT, plainFonts1);  
	    gg2.drawString(as8.getIterator(), 170, 410);
	    AttributedString as9 = new AttributedString(ss9);  
	    as9.addAttribute(TextAttribute.FONT, plainFonts1);  
	    gg2.drawString(as9.getIterator(), 265, 410);
	
	}
//	public static void main(String args[]){
//		NewPrintUI1 np1 = new NewPrintUI1();
//		np1.newprint();
//	}
	
	           
	
}