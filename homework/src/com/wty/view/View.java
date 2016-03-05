/*
 * 功能：QQ客户端登陆界面
 */
package com.wty.view;

import java.io.*;
import java.net.*;
import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
public class View extends JFrame implements ActionListener{

	/** 定义统一资源标识符对象 */
	private URI uri1,uri2,uri3;
	//定义北部需要的组件
	JLabel jbl1;
	//定义中部需要的组件
	//中部有三个JPanel，有一个叫选项卡窗口管理
	JPanel jp2;
	JLabel jp2_jbl1,jp2_jbl2,jp2_jbl3,jp2_jbl4,jp2_jbl5;
	JTextField jp2_jtf;
	JPasswordField jp2_jpf;
	JCheckBox jp2_jcb1,jp2_jcb2;


	//定义南部需要的组件
	JPanel jp1;
	JButton jp1_jb1,jp1_jb2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		View  qqClientLogin=new View();
	}
	
	public View()
	{
		//处理北部
		jbl1=new JLabel(new ImageIcon("image/logo554.GIF"));
		//jp5.add(jbl1);
		//处理中部
		jp2=new JPanel(new GridLayout(3,3));

		jp2_jbl1=new JLabel("QQ号码",JLabel.CENTER);
		jp2_jbl2=new JLabel("QQ密码",JLabel.CENTER);
		jp2_jbl3=new JLabel("忘记密码",JLabel.CENTER);
		jp2_jbl3.setForeground(Color.BLUE);
		jp2_jbl4=new JLabel("申请密码保护",JLabel.CENTER);
		jp2_jbl4.setForeground(Color.BLUE);
		jp2_jbl5=new JLabel("申请账号",JLabel.CENTER);
		jp2_jbl5.setForeground(Color.BLUE);
		jp2_jtf=new JTextField();
		jp2_jpf=new JPasswordField();
		jp2_jcb1=new JCheckBox("隐身登录");
		jp2_jcb2=new JCheckBox("记住密码");


		//处理JLabel的超链接情况，鼠标的事件
		 //申请QQ号码
		jp2_jbl5.setCursor(new Cursor(Cursor.HAND_CURSOR));//设置鼠标外观

		//设置鼠标事件监听
		jp2_jbl5.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e)
			{
			}
			public void mouseExited(MouseEvent e){
			}
            public void mouseClicked(MouseEvent e) {
            }
        });
		
		//申请密码保护
		jp2_jbl4.setCursor(new Cursor(Cursor.HAND_CURSOR));//设置鼠标外观

		//设置鼠标事件监听
		jp2_jbl4.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e)
			{
			
			}
			public void mouseExited(MouseEvent e){
			
			}
            public void mouseClicked(MouseEvent e) {
            
            }
        });
		
		//申请密码保护
		jp2_jbl3.setCursor(new Cursor(Cursor.HAND_CURSOR));//设置鼠标外观

		//设置鼠标事件监听
		jp2_jbl3.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e)
			{
			}
			public void mouseExited(MouseEvent e){
			}
            public void mouseClicked(MouseEvent e) {
            }
        });
		//把控件按照顺序加到jp2
		jp2.add(jp2_jbl1);
		jp2.add(jp2_jtf);
		jp2.add(jp2_jbl5);
		jp2.add(jp2_jbl2);
		jp2.add(jp2_jpf);
		jp2.add(jp2_jbl3);
		jp2.add(jp2_jcb1);
		jp2.add(jp2_jcb2);
		jp2.add(jp2_jbl4);


		//处理南部
		jp1=new JPanel(new FlowLayout());
		jp1_jb1=new JButton("登陆");
		//响应用户点击登录
		jp1_jb1.addActionListener(this);
		jp1_jb2=new JButton("哈哈");
		jp1_jb2.addActionListener(this);


		//把两个按钮放到jp1
		jp1.add(jp1_jb1);
		jp1.add(jp1_jb2);


		this.add(jbl1,"North");
		this.add(jp2,"Center");
		//把jp1放在南面
		this.add(jp1,"South");
		this.setSize(325,220);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();   //获取当前屏幕大小
		Dimension frameSize = this.getPreferredSize();//获取当前窗口大小
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);//保持窗口弹出位置居中
		this.setIconImage((new ImageIcon("image/头像.GIF").getImage()));
		this.setTitle("QQ用户登录");
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jp1_jb1)
		{
			jp2_jbl1.setText("shit");
		}
	}
}
