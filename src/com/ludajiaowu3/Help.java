package com.ludajiaowu3;

import javax.swing.*;
import java.awt.*;
public class Help {
	JDialog d1;
	JPanel contentPane=new JPanel( );
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//获取屏幕的宽高;
	public Help(JFrame jf){
		d1 = new JDialog(jf,"帮助文档",true);
		d1.setBounds((screenSize.width-400)/2, (screenSize.height-300)/2, 400, 300);
		
	  
        JLabel label1=new JLabel("  一、软件包说明  	1.软件包包含两个文件一个是'测试程序.exe'，一个是jre8的文件夹。2.jre8的包为软件自带编译环境【使用者无需安装任何环境包】。");//创建两个标签组件
//        
//        一、软件包说明
//    	1.软件包包含两个文件一个是'测试程序.exe'，一个是jre8的文件夹。
//    	2.jre8的包为软件自带编译环境【使用者无需安装任何环境包】。
//    二、使用说明
//    	1.使用时，直接点击'测试程序.exe'即可，出现图形化界面，根据菜单操作即可。一般使用的就是下方的"导入Excel文件"，"生成word文档"两个按钮。
//    三、功能说明
//    	1.就只有两个功能，一个是将excle导入到图形化界面的表格内，另一个就是将导入的表格数据根据一种特定的方式生成到doc文档中。doc文档可以根据用户的要求更改。
//    四、软件优化问题
//    	1.这只是一个测试版本，主要是测试最基本的功能（即读取excle，生成doc），对数据导入后的界面刷新问题、对界面表格最基本的操作问题都没有解决，不过这个在正式版本的时候会得到解决。	

        d1.add(contentPane);
        contentPane.add(label1);
        d1.setVisible(true);
        
	}
	
	

}
