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
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //�õ���Ļ�ĳߴ� 
	int width1 = screenSize.width; //���
	int height1 = screenSize.height; //�߶�
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
		//��ס800����590����������
		//g2.drawString("nihao",333,80);
		Rectangle2D rect = new Rectangle2D.Double(realWidth-60,10,920,660);
		Rectangle2D rect1 = new Rectangle2D.Double(realWidth,115,800,490);
		//�������������ζ��󣬾��ε����Ͻ���(333��100)������800������550
		g2.draw(rect);
		g2.draw(rect1);
		g2.drawString("����ѧԺ��", realWidth, 105);
		g2.drawString(tValues[1][2], realWidth+60, 105);
	    String s = "  " + tValues[1][0] + "  " ; 
	    //�������
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  
	    RenderingHints.VALUE_ANTIALIAS_ON); 
	    //������������ͺʹ�С
	    Font plainFont = new Font("����ϸ��", Font.BOLD, 15);  
	    /*
	     * String s = "/www.java2s.com/is great." ;
	     * as.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON, 1, 15);  
	     *	as.addAttribute(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON, 18, 25);
	     * ���Ը����ַ�����λ�ý��в�ͬ��ʽ�ĸ�ʽ�趨
	     * Java�ṩ�� AttributedString �࣬ ͨ��
	     * attributedString.addAttribute(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
		 *	attributedString.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		 *	���ɸ��������ɾ���ߺ��»��ߣ���ͨ��
       	 *	graphics2D.drawString(as.getIterator(), x, y);
		 *	�Ϳ�����ʾ�»��ߺ�ɾ���ߵ�Ч����
	     * 
	     */
	    AttributedString as = new AttributedString(s);  
	    as.addAttribute(TextAttribute.FONT, plainFont);  
	    as.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);  
	    String s1 = "ѧ���";
	    AttributedString as1 = new AttributedString(s1);
	    as1.addAttribute(TextAttribute.FONT,plainFont);
	    String s2 ="   " + tValues[1][1] + "   " ;
	    AttributedString as2 = new AttributedString(s2);  
	    as2.addAttribute(TextAttribute.FONT, plainFont);
	    as2.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
	    String s3 = "ѧ����ĩ�����Ծ��";
	    AttributedString as3 = new AttributedString(s3);  
	    as3.addAttribute(TextAttribute.FONT, plainFont);
	    g2.drawString(as.getIterator(), 300, 80);
	    g2.drawString(as1.getIterator(), 390, 80);
	    g2.drawString(as2.getIterator(), 450, 80);
	    g2.drawString(as3.getIterator(), 500, 80);
	    //����ں��ŵ���
	    Line2D line = new Line2D.Double(realWidth,155,realWidth+800,155);
	    g2.draw(line);
	    
	    Line2D line1 = new Line2D.Double(realWidth,195,realWidth+800,195);
	    g2.draw(line1);
	    Line2D line2 = new Line2D.Double(realWidth,235,realWidth+800,235);
	    g2.draw(line2);
	    Line2D line3 = new Line2D.Double(realWidth,495,realWidth+800,495);
	    g2.draw(line3);
	    //��������ŵ���
	    //��һ�б��
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
	    g2.drawString("�γ̺�", realWidth+10, 140);
	    g2.drawString(tValues[1][3], realWidth+110, 140);
	    g2.drawString("�γ���", realWidth+210, 140);
	    g2.drawString(tValues[1][4], realWidth+310, 140);
	    g2.drawString("�����", realWidth+610, 140);
	    g2.drawString(tValues[1][5], realWidth+710, 140);
	    //�ڶ��б��
	    Line2D line9 = new Line2D.Double(realWidth+100,155,realWidth+100,195);
	    g2.draw(line9);
	    Line2D line10 = new Line2D.Double(realWidth+400,155,realWidth+400,195);
	    g2.draw(line10);
	    Line2D line11 = new Line2D.Double(realWidth+500,155,realWidth+500,195);
	    g2.draw(line11);
	    Line2D line12 = new Line2D.Double(realWidth+800,155,realWidth+800,195);
	    g2.draw(line12);
	    
	    g2.drawString("���Եص�", realWidth+10, 180);
	    g2.drawString(tValues[1][6], realWidth+110, 180);
	    g2.drawString("����ʱ��", realWidth+410, 180);
	    g2.drawString(tValues[1][7], realWidth+510, 180);
	    
	    //�����б��
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
	    g2.drawString("������", realWidth+10, 220);
	    g2.drawString(tValues[1][8], realWidth+110, 220);
	    g2.drawString("����", realWidth+210, 220);
	    g2.drawString(tValues[1][9], realWidth+310, 220);
	    g2.drawString("��������", realWidth+410, 220);
	    g2.drawString(tValues[1][10], realWidth+510, 220);
	    g2.drawString("�ο���ʦ", realWidth+610, 220);
	    g2.drawString(tValues[1][11], realWidth+710, 220);
	    //�����б��
	    g2.drawString("���ڲ���", realWidth+10, 340);
	    g2.drawString("������", realWidth+10, 360);
	    
	    g2.drawString("������ѧ������", realWidth+110, 270);
	    g2.drawString("���Ծ� ��__"+tValues[1][12]+"__��", realWidth+110, 295);
	    g2.drawString("��������¼ ��__"+tValues[1][13]+"__��", realWidth+110, 320);
	    g2.drawString("������ֽ ��__"+tValues[1][14]+"__��", realWidth+110, 345);
	    g2.drawString("�����⿨ ��__"+tValues[1][15]+"__��", realWidth+110, 370);
	    g2.drawString(" ��������˵��", realWidth+110, 395);
	    
	    //�����б��
	    Line2D line20 = new Line2D.Double(realWidth+100,565,realWidth+800,565);
	    g2.draw(line20);
	    g2.drawString("Ӧ��____�ˣ�ʵ��____�ˣ�ȱ��_____�ˡ�", realWidth+110, 515);
	    g2.drawString("�࿼��ʦ��ǩ�֣���", realWidth+110, 540);
	    g2.drawString("����칫�Ҹ����ˣ�ǩ�֣���", realWidth+110, 585);
	}
}

