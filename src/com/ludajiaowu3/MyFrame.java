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
//�ҵ���ҳ��
public class MyFrame {
	private TableColumn column = null;
	JFrame jf;
	private JTable table;
	JTableHeader tableHeader;
	private JScrollPane scrollpane;
	private static String s[][] = new String[1000][200];
	String[] columnNames = new String[100];
	static String[] columnName = {"��һ��","�ڶ���","������","������","������","������","������","�ڰ���","�ھ���","��ʮ��","��ʮһ��","��ʮ����","��ʮ����","��ʮ����","��ʮ����","��ʮ����","��ʮ����","��ʮ����","��ʮ����","�ڶ�ʮ��"};
	static int maxRow = 100;
	static int maxCol = 20;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//��ȡ��Ļ�Ŀ��;
	public void returnValues(String str,int i,int j){
			MyFrame.getS()[i][j] = str;
			new MyOTable().getValueAt(i, j);
			new MyMonitor().getValues(str, i, j);
			
	}
	
	public void Initial(){
		jf = new JFrame("���Է�Ƥ����ϵͳ");//������
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jp = new JPanel();
		JButton jb1 = new JButton("����excle");
		JButton jb2 = new JButton("����doc�ĵ�");
		MyMonitor mm = new MyMonitor();//ʵ����ʱ�䴦������������õĵ�
		JMenuBar mb = new JMenuBar();//�˵���
		jf.add(mb,"North");
		jf.add(jp,"South");
		JMenu m1 = new JMenu("�ļ�");
		JMenu m2 = new JMenu("����");
		JMenu m3 = new JMenu("��ӡԤ��");
		JMenu m4 = new JMenu("��ӡ");
		JMenuItem mi2 = new JMenuItem("�����ĵ�");
		JMenuItem mi11 = new JMenuItem("��");
		JMenuItem mi15 = new JMenuItem("��ĩ�����Ծ������");
		JMenuItem mi16 = new JMenuItem("������Ծ������");
		JMenuItem kw1 = new JMenuItem("��ĩ�����Ծ�������ǩ");
		JMenuItem kw2 = new JMenuItem("������Ծ��");
		JMenuItem mi14 = new JMenuItem("�˳�");
//		JMenuItem mi17 = new JMenuItem("��ĩ�Ծ��Ƥ");
//		JMenuItem mi18 = new JMenuItem("������Ծ��Ƥ");
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
	    table.setRowSelectionAllowed(true);//���ñ���Ƿ��ѡ
		table.setSelectionMode(0);//���ñ��Ŀ�ѡģʽ��0Ϊֻ��ѡ��һ����1Ϊֻ������ѡ��2��������ѡ��
		table.setAutoResizeMode(0);
	    tableHeader = table.getTableHeader();
		jf.getContentPane().add(tableHeader,BorderLayout.CENTER);//�����ͷ�����Ź������仯
	    scrollpane = new JScrollPane(table);
	    jf.add(scrollpane);
	    jf.pack();
	    jf.setBounds(0,0,screenSize.width-100,screenSize.height-100);//���ÿ�ܴ�С����Ļ�ĳ���
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
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//��ȡ��Ļ�Ŀ��;
	public MyJDialog(JFrame frame){
		super(frame,"ѡ������Ҫ���ɵ�ģ��",true);
		Container container = getContentPane();
		JButton jbb1 = new JButton("��ĩ�Ծ��Ƥ");
		JButton jbb2 = new JButton("������Ծ��Ƥ");
		setLayout(new FlowLayout());
		jbb1.addActionListener(mm);
		jbb2.addActionListener(mm);
		container.add(jbb1);
		container.add(jbb2);
		setBounds(screenSize.width/2-150,screenSize.height/2-100,300,200);
		
	}
	
	
}

