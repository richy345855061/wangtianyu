package com.wty.method;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wty.domain.FavourStyle;
import com.wty.domain.OutputList;
import com.wty.domain.Product;
import com.wty.test.helper.HelperAssertEqual2Class;

public class StrategryTest {

	private static FavourAllSingle fas = null;
	
	@BeforeClass
	public static void init() {
		
		fas = new FavourAllSingle();
		fas.setOutputList((new OutputList(new Vector<Product>())));
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetProSelfFavour() {
		
		//Map<Product, Vector<Favourable>> getProSelfFavour(Vector<Product> prods, 
		//		Vector<Favourable> faVec)
		Vector<Product> prods = new Vector<Product>();
		prods = new Vector<Product>();
		Product p1 = new Product("可口可乐", 3.0f, 2.0f, "瓶", "ITEM000001");
		prods.add(p1);
		Product p2 = new Product("羽毛球", 1.0f, 3.0f, "个", "ITEM000002");
		prods.add(p2);
		Product p3 = new Product("苹果", 5.5f, 6.0f, "斤", "ITEM000003");
		prods.add(p3);
		Product p4 = new Product("饼干", 4.5f, 1.0f, "包", "ITEM000004");
		prods.add(p4);
		Product p5 = new Product("火龙果", 9.0f, 4.0f, "斤", "ITEM000005");
		prods.add(p5);
		
		
		
		Vector<Favourable> favVec = new Vector<Favourable>();
		Favourable f1 = new FavourOverMinus(new FavourStyle("满减", "单件", 3, "30~5", 2, 2, 
				"ITEM000002-ITEM000003-ITEM000004-ITEM000005"));
		Favourable f2 = new FavourDiscount(new FavourStyle("买赠", "单件", 1, "2~1", 1, 1, 
				"ITEM000002-ITEM000003-ITEM000004-ITEM000005"));
		favVec.add(f1);
		favVec.add(f2);
		
		Map<Product, Vector<Favourable>> favMap = fas.getProSelfFavour(prods, favVec);
		Map<Product, Vector<Favourable>> favMap2 = new LinkedHashMap<Product, Vector<Favourable>>();
		
		Vector<Favourable> favVec1 = new Vector<Favourable>();
		favVec1.add(new FavourOverMinus(new FavourStyle("满减", "单件", 3, "30~5", 2, 2, 
				"ITEM000002-ITEM000003-ITEM000004-ITEM000005")));
		favVec1.add(new FavourDiscount(new FavourStyle("买赠", "单件", 1, "2~1", 1, 1, 
				"ITEM000002-ITEM000003-ITEM000004-ITEM000005")));
		
		Vector<Favourable> favVec2 = new Vector<Favourable>();
		favVec2.add(new FavourOverMinus(new FavourStyle("满减", "单件", 3, "30~5", 2, 2, 
				"ITEM000002-ITEM000003-ITEM000004-ITEM000005")));
		favVec2.add(new FavourDiscount(new FavourStyle("买赠", "单件", 1, "2~1", 1, 1, 
				"ITEM000002-ITEM000003-ITEM000004-ITEM000005")));
		
		Vector<Favourable> favVec3 = new Vector<Favourable>();
		favVec3.add(new FavourOverMinus(new FavourStyle("满减", "单件", 3, "30~5", 2, 2, 
				"ITEM000002-ITEM000003-ITEM000004-ITEM000005")));
		favVec3.add(new FavourDiscount(new FavourStyle("买赠", "单件", 1, "2~1", 1, 1, 
				"ITEM000002-ITEM000003-ITEM000004-ITEM000005")));
		
		Vector<Favourable> favVec4 = new Vector<Favourable>();
		favVec4.add(new FavourOverMinus(new FavourStyle("满减", "单件", 3, "30~5", 2, 2, 
				"ITEM000002-ITEM000003-ITEM000004-ITEM000005")));
		favVec4.add(new FavourDiscount(new FavourStyle("买赠", "单件", 1, "2~1", 1, 1, 
				"ITEM000002-ITEM000003-ITEM000004-ITEM000005")));
		favMap2.put(p1, favVec1);
		favMap2.put(p2, favVec1);
		favMap2.put(p3, favVec2);
		favMap2.put(p4, favVec3);
		favMap2.put(p5, favVec4);
		
		HelperAssertEqual2Class.helperMap(favMap, favMap2);
		
	}

	@Test
	public void testFilterFavourByPriority() {
		
		Vector<Favourable> favVec = new Vector<Favourable>();
		favVec.add(new FavourOverMinus(new FavourStyle("满减", "单件", 3, "30~5", 2, 2, 
				"ITEM000002-ITEM000003-ITEM000004-ITEM000005")));
		favVec.add(new FavourDiscount(new FavourStyle("买赠", "单件", 1, "2~1", 2, 1, 
				"ITEM000002-ITEM000003-ITEM000004-ITEM000005")));
		favVec.add(new FavourDiscount(new FavourStyle("折扣", "单件", 2, "95", 2, 3, 
				"ITEM000002-ITEM000003-ITEM000004-ITEM000005")));
		
		favVec = fas.filterFavourByPriority(favVec);
		Vector<Favourable> favVec1 = new Vector<Favourable>();
		favVec1.add(new FavourDiscount(new FavourStyle("折扣", "单件", 2, "95", 2, 3, 
				"ITEM000002-ITEM000003-ITEM000004-ITEM000005")));
		favVec1.add(new FavourOverMinus(new FavourStyle("满减", "单件", 3, "30~5", 2, 2, 
				"ITEM000002-ITEM000003-ITEM000004-ITEM000005")));
		favVec1.add(new FavourDiscount(new FavourStyle("买赠", "单件", 1, "2~1", 2, 1, 
				"ITEM000002-ITEM000003-ITEM000004-ITEM000005")));
		
		HelperAssertEqual2Class.helpFavourable(favVec, favVec1);
		
	}

}
