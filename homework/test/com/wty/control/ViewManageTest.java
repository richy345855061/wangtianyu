package com.wty.control;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wty.domain.OutputList;
import com.wty.domain.Product;
import com.wty.test.helper.HelperAssertEqual2Class;

public class ViewManageTest {

	private static ViewManage vc = null;
	
	@BeforeClass
	public static void init() {
		
		Vector<String> strVec = new Vector<String>();
		strVec.add("�ۿ�-����-95-1-2");
		strVec.add("����-����-2~1-2-1");
		String filePath = "data.txt";
		vc = new ViewManage(filePath, strVec);

	}
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCalProductList() {
		
		vc.calProductList();
		//�������ı仯
		OutputList outputList = vc.getOutputList();
		Vector<Product> proVec = outputList.getProVec();
		Vector<Product> proVec1 = new Vector<Product>();
		
//		System.out.println(p.getName() + "-" +
//		p.getNums() + "-" +
//		p.getPrice() + "-" +
//		p.getStyle() + "-" +
//		p.getBarcode() + "-" +
//		p.getBuyFree() + "-" +
//		p.getTotal() + "-" +
//		p.getFavourMoney());
		Product p1 = new Product("�ɿڿ���", 3.0f, 2.0f, "ƿ", "ITEM000001");
		p1.setBuyFree(0.0f);
		p1.setFavourMoney(0.0f);
		p1.setTotal(6.0f);
		Product p2 = new Product("��ë��", 1.0f, 4.0f, "��", "ITEM000002");
		p2.setBuyFree(1.0f);
		p2.setFavourMoney(0.0f);
		p2.setTotal(3.0f);
		Product p3 = new Product("ƻ��", 5.5f, 9.0f, "��", "ITEM000003");
		p3.setBuyFree(3.0f);
		p3.setFavourMoney(0.0f);
		p3.setTotal(33.0f);
		Product p4 = new Product("����", 4.5f, 1.0f, "��", "ITEM000004");
		p4.setBuyFree(0.0f);
		p4.setFavourMoney(0.0f);
		p4.setTotal(4.5f);
		Product p5 = new Product("������", 9.0f, 6.0f, "��", "ITEM000005");
		p5.setBuyFree(2.0f);
		p5.setFavourMoney(0.0f);
		p5.setTotal(36.0f);
		proVec1.add(p1);
		proVec1.add(p2);
		proVec1.add(p3);
		proVec1.add(p4);
		proVec1.add(p5);
		
		HelperAssertEqual2Class.helpProductVec(proVec1, proVec);
		
	}
}
