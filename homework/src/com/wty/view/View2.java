/*
 * ���ܣ�QQ�ͻ��˵�½����
 */
package com.wty.view;

import java.io.*;
import java.net.*;
import java.util.Map;
import java.util.Vector;

import javax.swing.*;

import com.wty.control.ViewCl;
import com.wty.domain.FavourStyle;
import com.wty.domain.Product;
import com.wty.tools.RWStrHelper;


import java.awt.*;
import java.awt.event.*;
public class View2 extends JFrame implements ActionListener{

	//���山�������
	JPanel jp1;  
	JLabel jp1_jbl1;   
	JButton jp1_jb1;
	
	//�в�
	JPanel jp2;
	JTextArea jp2_jtf1, jp2_jtf2;
	
	//�ϲ�
	JPanel jp3, jp4;
	JCheckBox jp3_jcb1, jp3_jcb2, jp3_jcb3;
	JButton jp3_jb1;
	
	Vector<JCheckBox> jbVec;
	String filePath;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new View2();
	}
	
	public View2()
	{
		
		jbVec = new Vector<JCheckBox>();
		filePath = "";
		
		//���山�������
		jp1 = new JPanel(new FlowLayout());  
		jp1_jbl1 = new JLabel("Thoughtworks sell", JLabel.CENTER);   
		jp1_jb1 = new JButton("��ȡ������");
		
		//�в�
		jp2 = new JPanel(new GridLayout(1, 2));
		jp2_jtf1 = new JTextArea("��������Ϣ:\n");
		jp2_jtf1.setEditable(false);
		jp2_jtf1.setBackground(new Color(184,211,237));
		jp2_jtf2 = new JTextArea("��ӡСƱ���:\n");
		jp2_jtf2.setEditable(false);
		jp2_jtf2.setBackground(new Color(93,131,173));
		//�ϲ�
		jp3 = new JPanel(new GridLayout(1, 2));
		jp4 = new JPanel(new GridLayout(2, 2));
		jp3_jcb1 = new JCheckBox("S-�ۿ�-95");
		jp3_jcb2 = new JCheckBox("S-����-2-1");
		jp3_jcb3 = new JCheckBox("T-����-100-10");
		jp3_jb1 = new JButton("����");
		
		jbVec.add(jp3_jcb1);
		jbVec.add(jp3_jcb2);
		jbVec.add(jp3_jcb3);

	
		jp1.add(jp1_jbl1);
		jp1.add(jp1_jb1);
		
		jp2.add(jp2_jtf1);
		jp2.add(jp2_jtf2);
		
		jp4.add(jp3_jcb1);
		jp4.add(jp3_jcb2);
		jp4.add(jp3_jcb3);
		jp3.add(jp4);
		jp3.add(jp3_jb1);

		//��Ӧ�û������¼
		jp1_jb1.addActionListener(this);
		jp3_jb1.addActionListener(this);

		this.add(jp1,"North");
		this.add(jp2,"Center");
		//��jp1��������
		this.add(jp3,"South");
		this.setSize(800,600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();   //��ȡ��ǰ��Ļ��С
		Dimension frameSize = this.getPreferredSize();//��ȡ��ǰ���ڴ�С
		this.setLocation(50, 50);//���ִ��ڵ���λ�þ���
		//this.setIconImage((new ImageIcon("image/ͷ��.GIF").getImage()));
		this.setTitle("Thoughtworks-homework");
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jp1_jb1) {
			JFileChooser jfc = new JFileChooser();
			jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			jfc.showDialog(new JLabel(), "ѡ��");
			File file = jfc.getSelectedFile();
			
			filePath = file.getAbsolutePath();
			Vector<String> strVec = RWStrHelper.readTxt(filePath);
			for (int i = 0; i < strVec.size(); ++i) {
				
				jp2_jtf1.append(strVec.get(i) + "\n");
			}
			
		}
		if (e.getSource() == jp3_jb1) {

						
			
			Vector<String> strVec = new Vector<String>();
			for (int k = 0; k < jbVec.size(); ++k) {
				
				if (jbVec.get(k).isSelected()) {
					
					strVec.add(jbVec.get(k).getText());
					//System.out.println(jbVec.get(k).getText());
				}
			}
			
			Vector<FavourStyle> fsVec = RWStrHelper.creObjByCkb(strVec);
		
			
			Map<String, Integer> proMap = RWStrHelper.readBarData(filePath);
			Vector<Product> proVec = RWStrHelper.creObjByBarcode(proMap);
			ViewCl vc = new ViewCl(proVec, fsVec);
			vc.resultCl();
		}
	}
}
