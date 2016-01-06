package com.ludajiaowu3;

import java.awt.*;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.*;
//我的主页面
public class MyFrame {
	private TableColumn column = null;
	JFrame jf;
	private JTable table;
	JTableHeader tableHeader;
	private JScrollPane scrollpane;
	private static String s[][] = new String[1000][200];
	String[] columnNames = new String[100];
	static String[] columnName = {"第一列","第二列","第三列","第四列","第五列","第六列","第七列","第八列","第九列","第十列","第十一列","第十二列","第十三列","第十四列","第十五列","第十六列","第十七列","第十八列","第十九列","第二十列"};
	static int maxRow = 100;
	static int maxCol = 20;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//获取屏幕的宽高;
	public void returnValues(String str,int i,int j){
			MyFrame.getS()[i][j] = str;
			new MyOTable().getValueAt(i, j);
			new MyMonitor().getValues(str, i, j);
			
	}
	
	public void Initial(){
		jf = new JFrame("考试封皮生成系统");//定义框架
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jp = new JPanel();
		JButton jb1 = new JButton("导入excle");
		JButton jb2 = new JButton("生成doc文档");
		MyMonitor mm = new MyMonitor();//实例化时间处理器，后面会用的到
		JMenuBar mb = new JMenuBar();//菜单栏
		jf.add(mb,"North");
		jf.add(jp,"South");
		JMenu m1 = new JMenu("文件");
		JMenu m2 = new JMenu("帮助");
		JMenu m3 = new JMenu("打印预览");
		JMenu m4 = new JMenu("打印");
		JMenuItem mi2 = new JMenuItem("帮助文档");
		JMenuItem mi11 = new JMenuItem("打开");
		JMenuItem mi15 = new JMenuItem("期末考试试卷袋封面");
		JMenuItem mi16 = new JMenuItem("结课周试卷袋封面");
		JMenuItem kw1 = new JMenuItem("期末考试试卷袋封面标签");
		JMenuItem kw2 = new JMenuItem("结课周试卷袋");
		JMenuItem mi14 = new JMenuItem("退出");
//		JMenuItem mi17 = new JMenuItem("期末试卷封皮");
//		JMenuItem mi18 = new JMenuItem("结课周试卷封皮");
		m2.add(mi2);
		m3.add(kw1);
		m3.add(kw2);
		m4.add(mi15);
		m4.add(mi16);
		m1.add(mi11);
		m1.add(m4);
		m1.add(m3);
		m1.addSeparator();
		m1.add(mi14);
//		jb2.add(mi17);
//		jb2.add(mi18);
		jp.add(jb1);
		jp.add(jb2);
		mi2.addActionListener(mm);
		jb1.addActionListener(mm);
		jb2.addActionListener(mm);
		mi11.addActionListener(mm);
		mi14.addActionListener(mm);
		mi15.addActionListener(mm);
		mi16.addActionListener(mm);
		kw1.addActionListener(mm);
		kw2.addActionListener(mm);
		mb.add(m1);
		mb.add(m2);
		
		jf.add(mb,BorderLayout.NORTH);
		MyOTable myt = new MyOTable();
		table = new JTable(myt);
	    table.setRowHeight(30);
	    table.setAutoResizeMode(0);
	    for (int i = 0; i < 20; i++) {  
            column = table.getColumnModel().getColumn(i);  
            column.setPreferredWidth(120);
        } 
	    table.setRowSelectionAllowed(true);//设置表格是否可选
		table.setSelectionMode(0);//设置表格的可选模式：0为只能选择一个，1为只能连续选择，2可以任意选择
		table.setAutoResizeMode(0);
	    tableHeader = table.getTableHeader();
		jf.getContentPane().add(tableHeader,BorderLayout.CENTER);//定义表头不随着滚动条变化
	    scrollpane = new JScrollPane(table);
	    jf.add(scrollpane);
	    jf.pack();
	    jf.setBounds(0,0,screenSize.width-100,screenSize.height-100);//设置框架大小及屏幕的长宽
		jf.setVisible(true);
	}
	
	public static String[][] getS() {
		return s;
	}

	public static void setS(String s[][]) {
		MyFrame.s = s;
	}
}	
class MyOTable extends AbstractTableModel{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	 
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 20;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return 300;
	}

	public String getValueAt(int i, int j) {
		new MyFrame();
		// TODO Auto-generated method stub
		return MyFrame.getS()[i][j];
	}
	public String getColumnName(int column){
		new MyFrame();
		return MyFrame.columnName[column];
	}
	public boolean isCellEditable(int row, int col) {
		return true;
	}
	
}
class MyJDialog extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MyMonitor mm = new MyMonitor();
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//获取屏幕的宽高;
	public MyJDialog(JFrame frame){
		super(frame,"选择所需要生成的模板",true);
		Container container = getContentPane();
		JButton jbb1 = new JButton("期末试卷封皮");
		JButton jbb2 = new JButton("结课周试卷封皮");
		setLayout(new FlowLayout());
		jbb1.addActionListener(mm);
		jbb2.addActionListener(mm);
		container.add(jbb1);
		container.add(jbb2);
		setBounds(screenSize.width/2-150,screenSize.height/2-100,300,200);
		
	}
	
	
}

