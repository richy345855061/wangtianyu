/*
 * ���ܣ�QQ�ͻ��˵�½����
 */
package com.wty.view;

import java.io.*;
import java.util.Vector;

import javax.swing.*;
import javax.xml.ws.handler.MessageContext.Scope;

import com.wty.control.ViewCl;
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
	
	//�Żݲ���
	JPanel jp4_jp1, jp4_jp2, jp4_jp3;
	JComboBox  jp4_jp1_jcb1, jp4_jp1_jcb2, jp4_jp1_jcb3;
	JTextField jp4_jp1_jtf1, jp4_jp1_jtf2, jp4_jp1_jtf3;
	JTextField jp4_jp2_jtf1, jp4_jp2_jtf2, jp4_jp2_jtf3, jp4_jp2_jtf4;
	JTextField jp4_jp3_jtf1, jp4_jp3_jtf2, jp4_jp3_jtf3, jp4_jp3_jtf4;
	JLabel jp4_jbl1, jp4_jbl2, jp4_jbl3, jp4_jbl4, jp4_jbl5;
	
	///
	String str1, str2, str3;
	
	Vector<JCheckBox> jbVec;
	Vector<String> scpeVec;
	Vector<JTextField> favWightVec;
	Vector<JTextField> priVec;
	Vector<JTextField> morePrijbVec;
	
	String filePath;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new View2();
	}
	
	public View2()
	{
		
		jbVec = new Vector<JCheckBox>();
		scpeVec = new Vector<String>();
		favWightVec = new Vector<JTextField>();
		priVec = new Vector<JTextField>();
		morePrijbVec = new Vector<JTextField>();
		
		str1 = "����";
		str2 = "����";
		str3 = "����";
		
		scpeVec.add(str1);
		scpeVec.add(str2);
		scpeVec.add(str3);


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
		jp3 = new JPanel(new GridLayout(2, 1));
		jp4 = new JPanel(new GridLayout(4, 0));
		//����-��Χ-�Żݳ̶�-���ȼ�-�������ȼ�
		jp3_jcb1 = new JCheckBox("�ۿ�");
		jp3_jcb2 = new JCheckBox("����");
		jp3_jcb3 = new JCheckBox("����");
		jp3_jb1 = new JButton("����");
		
//		JPanel jp4_jp1, jp4_jp2, jp4_jp3;
//		JComboBox  jp4_jp1_jcb1, jp4_jp1_jcb2, jp4_jp1_jcb3;
//		JTextField jp4_jp1_jtf1, jp4_jp1_jtf2, jp4_jp1_jtf3;
//		JTextField jp4_jp2_jtf1, jp4_jp2_jtf2, jp4_jp2_jtf3,;
//		JTextField jp4_jp3_jtf1, jp4_jp3_jtf2, jp4_jp3_jtf3,;
//		JLabel jp4_jbl1, jp4_jbl2, jp4_jbl3, jp4_jbl4;
		//��һ��
		jp4_jbl1 = new JLabel("�ۿ�����", JLabel.CENTER); 
		jp4_jbl2 = new JLabel("�ۿ۷�Χ", JLabel.CENTER); 
		jp4_jbl3 = new JLabel("�ۿ�����(95�ۻ���2��1)", JLabel.CENTER); 
		jp4_jbl4 = new JLabel("���ȼ�", JLabel.CENTER); 
		jp4_jbl5 = new JLabel("���ȼ���ͬʱ��������", JLabel.CENTER); 
		//�ڶ���
		jp4_jp1_jcb1 = new JComboBox();
		jp4_jp1_jcb1.addItem("����");
		jp4_jp1_jcb1.addItem("ȫ��");
		jp4_jp1_jcb1.setSelectedItem("����");
		jp4_jp1_jcb2 = new JComboBox();
		jp4_jp1_jcb2.addItem("����");
		jp4_jp1_jcb2.addItem("ȫ��");
		jp4_jp1_jcb2.setSelectedItem("����");
		jp4_jp1_jcb3 = new JComboBox();
		jp4_jp1_jcb3.addItem("����");
		jp4_jp1_jcb3.addItem("ȫ��");
		jp4_jp1_jcb3.setSelectedItem("����");
		
		jp4_jp1_jtf1 = new JTextField("95");
		jp4_jp1_jtf1.setHorizontalAlignment(JTextField.CENTER);
		jp4_jp1_jtf2 = new JTextField("2~1");
		jp4_jp1_jtf2.setHorizontalAlignment(JTextField.CENTER);
		jp4_jp1_jtf3 = new JTextField("30~5");
		jp4_jp1_jtf3.setHorizontalAlignment(JTextField.CENTER);
		favWightVec.add(jp4_jp1_jtf1);
		favWightVec.add(jp4_jp1_jtf2);
		favWightVec.add(jp4_jp1_jtf3);
		
		jp4_jp2_jtf1 = new JTextField("1");
		jp4_jp2_jtf1.setHorizontalAlignment(JTextField.CENTER);
		jp4_jp2_jtf2 = new JTextField("2");
		jp4_jp2_jtf2.setHorizontalAlignment(JTextField.CENTER);
		jp4_jp2_jtf3 = new JTextField("2");
		jp4_jp2_jtf3.setHorizontalAlignment(JTextField.CENTER);
		priVec.add(jp4_jp2_jtf1);
		priVec.add(jp4_jp2_jtf2);
		priVec.add(jp4_jp2_jtf3);
		
		jp4_jp3_jtf1 = new JTextField("2");
		jp4_jp3_jtf1.setHorizontalAlignment(JTextField.CENTER);
		jp4_jp3_jtf2 = new JTextField("1");
		jp4_jp3_jtf2.setHorizontalAlignment(JTextField.CENTER);
		jp4_jp3_jtf3 = new JTextField("0");
		jp4_jp3_jtf3.setHorizontalAlignment(JTextField.CENTER);
		morePrijbVec.add(jp4_jp3_jtf1);
		morePrijbVec.add(jp4_jp3_jtf2);
		morePrijbVec.add(jp4_jp3_jtf3);
		
		
		jbVec.add(jp3_jcb1);
		jbVec.add(jp3_jcb2);
		jbVec.add(jp3_jcb3);

	
		jp1.add(jp1_jbl1);
		jp1.add(jp1_jb1);
		
		jp2.add(jp2_jtf1);
		jp2.add(jp2_jtf2);
		
		jp4.add(jp4_jbl1);
		jp4.add(jp4_jbl2);
		jp4.add(jp4_jbl3);
		jp4.add(jp4_jbl4);
		jp4.add(jp4_jbl5);
		
		jp4.add(jp3_jcb1);
		jp4.add(jp4_jp1_jcb1);
		jp4.add(jp4_jp1_jtf1);
		jp4.add(jp4_jp2_jtf1);
		jp4.add(jp4_jp3_jtf1);
		
		jp4.add(jp3_jcb2);
		jp4.add(jp4_jp1_jcb2);
		jp4.add(jp4_jp1_jtf2);
		jp4.add(jp4_jp2_jtf2);
		jp4.add(jp4_jp3_jtf2);
//		
		jp4.add(jp3_jcb3);
		jp4.add(jp4_jp1_jcb3);
		jp4.add(jp4_jp1_jtf3);
		jp4.add(jp4_jp2_jtf3);
		jp4.add(jp4_jp3_jtf3);
		
		jp3.add(jp4);
		jp3.add(jp3_jb1);

		//��Ӧ�û������¼
		jp1_jb1.addActionListener(this);
		jp3_jb1.addActionListener(this);
		jp4_jp1_jcb1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent evt) {
				// TODO Auto-generated method stub
				
				if (evt.getStateChange() == ItemEvent.SELECTED) {
					
					try {
						
						String s = evt.getItem().toString();
						str1 = s;
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		});
		jp4_jp1_jcb2.addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent evt) {
						// TODO Auto-generated method stub
						
						if (evt.getStateChange() == ItemEvent.SELECTED) {
							
							try {
								
								String s = evt.getItem().toString();
								str2 = s;
							} catch (Exception e) {
								// TODO: handle exception
							}
						}
					}
				});
		jp4_jp1_jcb3.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent evt) {
				// TODO Auto-generated method stub
				
				if (evt.getStateChange() == ItemEvent.SELECTED) {
					
					try {
						
						String s = evt.getItem().toString();
						str3 = s;
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		});

		this.add(jp1,"North");
		this.add(jp2,"Center");
		//��jp1��������
		this.add(jp3,"South");
		this.setSize(800,600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			
			jp2_jtf1.append(RWStrHelper.getAllData(filePath));
			
		}
		if (e.getSource() == jp3_jb1) {

			Vector<String> strVec = new Vector<String>();
			for (int k = 0; k < jbVec.size(); ++k) {
				
				if (jbVec.get(k).isSelected()) {
					
					String st = jbVec.get(k).getText() + "-" +
								scpeVec.get(k) + "-" + 
								favWightVec.get(k).getText() + "-" +
								priVec.get(k).getText() + "-" +
								morePrijbVec.get(k).getText();
					strVec.add(st);
					//System.out.println(jbVec.get(k).getText());
				}
			}
			
//			for (int i = 0; i < strVec.size(); ++i) {
//				
//				System.out.println(strVec.get(i));
//			}
			//���������ദ��
			ViewCl vc = new ViewCl(filePath, strVec);
			jp2_jtf2.setText("");
			jp2_jtf2.append("��ӡСƱ���:\n" + vc.getFinalInfo());
		}
	}
}
