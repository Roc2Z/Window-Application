package com.ludajiaowu3;

import javax.swing.*;
import java.awt.*;
public class Help {
	JDialog d1;
	JPanel contentPane=new JPanel( );
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//��ȡ��Ļ�Ŀ��;
	public Help(JFrame jf){
		d1 = new JDialog(jf,"�����ĵ�",true);
		d1.setBounds((screenSize.width-400)/2, (screenSize.height-300)/2, 400, 300);
		
	  
        JLabel label1=new JLabel("  һ�������˵��  	1.��������������ļ�һ����'���Գ���.exe'��һ����jre8���ļ��С�2.jre8�İ�Ϊ����Դ����뻷����ʹ�������谲װ�κλ���������");//����������ǩ���
//        
//        һ�������˵��
//    	1.��������������ļ�һ����'���Գ���.exe'��һ����jre8���ļ��С�
//    	2.jre8�İ�Ϊ����Դ����뻷����ʹ�������谲װ�κλ���������
//    ����ʹ��˵��
//    	1.ʹ��ʱ��ֱ�ӵ��'���Գ���.exe'���ɣ�����ͼ�λ����棬���ݲ˵��������ɡ�һ��ʹ�õľ����·���"����Excel�ļ�"��"����word�ĵ�"������ť��
//    ��������˵��
//    	1.��ֻ���������ܣ�һ���ǽ�excle���뵽ͼ�λ�����ı���ڣ���һ�����ǽ�����ı�����ݸ���һ���ض��ķ�ʽ���ɵ�doc�ĵ��С�doc�ĵ����Ը����û���Ҫ����ġ�
//    �ġ�����Ż�����
//    	1.��ֻ��һ�����԰汾����Ҫ�ǲ���������Ĺ��ܣ�����ȡexcle������doc���������ݵ����Ľ���ˢ�����⡢�Խ�����������Ĳ������ⶼû�н���������������ʽ�汾��ʱ���õ������	

        d1.add(contentPane);
        contentPane.add(label1);
        d1.setVisible(true);
        
	}
	
	

}
