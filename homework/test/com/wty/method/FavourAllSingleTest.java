package com.wty.method;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wty.domain.FavourStyle;
import com.wty.domain.OutputList;
import com.wty.domain.Product;
import com.wty.test.helper.HelperAssertEqual2Class;

public class FavourAllSingleTest {

	private static FavourAllSingle fas = null;
	private static Vector<Product> proVec = null;
	private static Vector<Favourable> favVec = null;
	
	
	@BeforeClass
	public static void init() {
		
		proVec = new Vector<Product>();
		proVec.add(new Product("�ɿڿ���", 3.0f, 2.0f, "ƿ", "ITEM000001"));
		proVec.add(new Product("��ë��", 1.0f, 3.0f, "��", "ITEM000002"));
		proVec.add(new Product("ƻ��", 5.5f, 6.0f, "��", "ITEM000003"));
		proVec.add(new Product("����", 4.5f, 1.0f, "��", "ITEM000004"));
		proVec.add(new Product("������", 9.0f, 4.0f, "��", "ITEM000005"));
		
		favVec = new Vector<Favourable>();
		Favourable f1 = new FavourOverMinus(new FavourStyle("����", "����", 3, "30~5", 2, 2, 
													"ITEM000002-ITEM000003-ITEM000004-ITEM000005"));
		Favourable f2 = new FavourDiscount(new FavourStyle("����", "����", 1, "2~1", 1, 1, 
				"ITEM000002-ITEM000003-ITEM000004-ITEM000005"));
		
		favVec.add(f1);
		favVec.add(f2);
		
		
		fas = new FavourAllSingle();
		fas.setOutputList((new OutputList(new Vector<Product>())));
		
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetResult() {
		

		
		fas.getResult(proVec, favVec);
		
		OutputList outputList = fas.getOutputList();
		Vector<Product> proVec1 = outputList.getProVec();
		Vector<Product> proVec2 = new Vector<Product>();
		Product p1 = new Product("�ɿڿ���", 3.0f, 2.0f, "ƿ", "ITEM000001");
		p1.setBuyFree(0.0f);
		p1.setFavourMoney(0.0f);
		p1.setTotal(6.0f);
		Product p2 = new Product("��ë��", 1.0f, 3.0f, "��", "ITEM000002");
		p2.setBuyFree(0.0f);
		p2.setFavourMoney(0.0f);
		p2.setTotal(3.0f);
		Product p3 = new Product("ƻ��", 5.5f, 6.0f, "��", "ITEM000003");
		p3.setBuyFree(0.0f);
		p3.setFavourMoney(5.0f);
		p3.setTotal(28.0f);
		Product p4 = new Product("����", 4.5f, 1.0f, "��", "ITEM000004");
		p4.setBuyFree(0.0f);
		p4.setFavourMoney(0.0f);
		p4.setTotal(4.5f);
		Product p5 = new Product("������", 9.0f, 4.0f, "��", "ITEM000005");
		p5.setBuyFree(0.0f);
		p5.setFavourMoney(5.0f);
		p5.setTotal(31.0f);
		proVec2.add(p1);
		proVec2.add(p2);
		proVec2.add(p3);
		proVec2.add(p4);
		proVec2.add(p5);
		
		HelperAssertEqual2Class.helpProductVec(proVec1, proVec2);
	}

}
