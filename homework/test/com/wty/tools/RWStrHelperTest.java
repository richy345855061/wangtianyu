package com.wty.tools;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wty.domain.FavourStyle;
import com.wty.domain.Product;
import com.wty.test.helper.HelperAssertEqual2Class;

public class RWStrHelperTest {

	//��ʼ������
	@BeforeClass
	public static void init() {
		
	}

	@Before
	public void setUp() throws Exception {
	}

//	@Test
//	public void testReadTxt() {
//	}
//
//	@Test
//	public void testGetAllData() {
//	}

	@Test
	public void testReadBarData() {

		String filePath = "data.txt";
		Map<String, Integer> mapActual = RWStrHelper.readBarData(filePath);
		
		Map<String, Integer> mapTheory = new LinkedHashMap<String, Integer>();
		mapTheory.put("ITEM000001", 2);
		mapTheory.put("ITEM000002", 3);
		mapTheory.put("ITEM000003", 6);
		mapTheory.put("ITEM000004", 1);
		mapTheory.put("ITEM000005", 4);
		
		assertEquals("readBarData����", mapActual, mapTheory);
		
	}

	@Test
	public void testCreObjByCkb() {
		
		//static public Vector<FavourStyle> creObjByCkb(Vector<String> strVec)
		Vector<String> strVec = new Vector<String>();
		strVec.add("�ۿ�-����-95-1-2");
		strVec.add("����-����-2~1-2-1");
		
		Vector<FavourStyle> favStr1 = RWStrHelper.creObjByCkb(strVec);
		
		Vector<FavourStyle> favStr2 = new Vector<FavourStyle>();
		favStr2.add(new FavourStyle("�ۿ�", "����", 2, "95", 1, 2, "ITEM000002-ITEM000003-ITEM000004-ITEM000005"));
		favStr2.add(new FavourStyle("����", "����", 1, "2~1", 2, 1, "ITEM000002-ITEM000003-ITEM000004-ITEM000005"));
		
		HelperAssertEqual2Class.helpFavourStyle(favStr1, favStr2);
	}

	@Test
	public void testCreObjByBarcode() {
		//static public Vector<Product> creObjByBarcode(Map<String, Integer> proMap)
		
		Map<String, Integer> proMap = new LinkedHashMap<String, Integer>();
		proMap.put("ITEM000001", 2);
		proMap.put("ITEM000002", 3);
		proMap.put("ITEM000003", 6);
		proMap.put("ITEM000004", 1);
		proMap.put("ITEM000005", 4);
		
		Vector<Product> proVec1 = RWStrHelper.creObjByBarcode(proMap);
		Vector<Product> proVec = new Vector<Product>();
		proVec.add(new Product("�ɿڿ���", 3.0f, 2.0f, "ƿ", "ITEM000001"));
		proVec.add(new Product("��ë��", 1.0f, 3.0f, "��", "ITEM000002"));
		proVec.add(new Product("ƻ��", 5.5f, 6.0f, "��", "ITEM000003"));
		proVec.add(new Product("����", 4.5f, 1.0f, "��", "ITEM000004"));
		proVec.add(new Product("������", 9.0f, 4.0f, "��", "ITEM000005"));
		
		HelperAssertEqual2Class.helpProductVec(proVec1, proVec);
	}
	
}
