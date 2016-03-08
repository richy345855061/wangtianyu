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

	//初始化对象
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
		
		assertEquals("readBarData错误", mapActual, mapTheory);
		
	}

	@Test
	public void testCreObjByCkb() {
		
		//static public Vector<FavourStyle> creObjByCkb(Vector<String> strVec)
		Vector<String> strVec = new Vector<String>();
		strVec.add("折扣-单件-95-1-2");
		strVec.add("买赠-单件-2~1-2-1");
		
		Vector<FavourStyle> favStr1 = RWStrHelper.creObjByCkb(strVec);
		
		Vector<FavourStyle> favStr2 = new Vector<FavourStyle>();
		favStr2.add(new FavourStyle("折扣", "单件", 2, "95", 1, 2, "ITEM000002-ITEM000003-ITEM000004-ITEM000005"));
		favStr2.add(new FavourStyle("买赠", "单件", 1, "2~1", 2, 1, "ITEM000002-ITEM000003-ITEM000004-ITEM000005"));
		
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
		proVec.add(new Product("可口可乐", 3.0f, 2.0f, "瓶", "ITEM000001"));
		proVec.add(new Product("羽毛球", 1.0f, 3.0f, "个", "ITEM000002"));
		proVec.add(new Product("苹果", 5.5f, 6.0f, "斤", "ITEM000003"));
		proVec.add(new Product("饼干", 4.5f, 1.0f, "包", "ITEM000004"));
		proVec.add(new Product("火龙果", 9.0f, 4.0f, "斤", "ITEM000005"));
		
		HelperAssertEqual2Class.helpProductVec(proVec1, proVec);
	}
	
}
