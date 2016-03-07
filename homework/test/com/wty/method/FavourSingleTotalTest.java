package com.wty.method;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wty.domain.FavourStyle;
import com.wty.domain.OutputList;
import com.wty.domain.Product;
import com.wty.test.helper.HelperAssertEqual2Class;

public class FavourSingleTotalTest {

	private static FavourSingleTotal fst = null;
	private static Vector<Product> proVec = null;
	private static Vector<Favourable> favVec = null;
	
	@BeforeClass
	public static void init() {
		
		proVec = new Vector<Product>();
		proVec.add(new Product("可口可乐", 3.0f, 2.0f, "瓶", "ITEM000001"));
		proVec.add(new Product("羽毛球", 1.0f, 3.0f, "个", "ITEM000002"));
		proVec.add(new Product("苹果", 5.5f, 6.0f, "斤", "ITEM000003"));
		proVec.add(new Product("饼干", 4.5f, 1.0f, "包", "ITEM000004"));
		proVec.add(new Product("火龙果", 9.0f, 4.0f, "斤", "ITEM000005"));
		
		favVec = new Vector<Favourable>();
		Favourable f1 = new FavourOverMinus(new FavourStyle("满减", "全场", 3, "30~5", 2, 0, 
													"ITEM000002-ITEM000003-ITEM000004-ITEM000005"));
		Favourable f2 = new FavourBuyForFree(new FavourStyle("买赠", "单件", 1, "2~1", 2, 1, 
				"ITEM000002-ITEM000003-ITEM000004-ITEM000005"));
		
		favVec.add(f1);
		favVec.add(f2);
		
		
		fst = new FavourSingleTotal();
		fst.setOutputList((new OutputList(new Vector<Product>())));
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetResult() {
		fst.getResult(proVec, favVec);
		
		OutputList outputList = fst.getOutputList();
		Vector<Product> proVec1 = outputList.getProVec();
		Vector<Product> proVec2 = new Vector<Product>();
		Product p1 = new Product("可口可乐", 3.0f, 2.0f, "瓶", "ITEM000001");
		p1.setBuyFree(0.0f);
		p1.setFavourMoney(0.0f);
		p1.setTotal(6.0f);
		Product p2 = new Product("羽毛球", 1.0f, 4.0f, "个", "ITEM000002");
		p2.setBuyFree(0.0f);
		p2.setFavourMoney(0.0f);
		p2.setTotal(3.0f);
		p2.setBuyFree(1.0f);
		Product p3 = new Product("苹果", 5.5f, 9.0f, "斤", "ITEM000003");
		p3.setBuyFree(0.0f);
		p3.setFavourMoney(0.0f);
		p3.setTotal(33.0f);
		p3.setBuyFree(3.0f);
		Product p4 = new Product("饼干", 4.5f, 1.0f, "包", "ITEM000004");
		p4.setBuyFree(0.0f);
		p4.setFavourMoney(0.0f);
		p4.setTotal(4.5f);
		Product p5 = new Product("火龙果", 9.0f, 6.0f, "斤", "ITEM000005");
		p5.setBuyFree(0.0f);
		p5.setFavourMoney(0.0f);
		p5.setTotal(36.0f);
		p5.setBuyFree(2.0f);
		proVec2.add(p1);
		proVec2.add(p2);
		proVec2.add(p3);
		proVec2.add(p4);
		proVec2.add(p5);
		
		HelperAssertEqual2Class.helpProduct(proVec1, proVec2);
	}

	@Test
	public void testGetVecByScope() {
		
		Vector<Favourable> favVec = new Vector<Favourable>();
		Favourable f1 = new FavourOverMinus(new FavourStyle("满减", "单件", 3, "30~5", 2, 2, 
													"ITEM000002-ITEM000003-ITEM000004-ITEM000005"));
		Favourable f2 = new FavourDiscount(new FavourStyle("买赠", "单件", 1, "2~1", 1, 1, 
				"ITEM000002-ITEM000003-ITEM000004-ITEM000005"));
		
		favVec.add(f1);
		favVec.add(f2);
		
		Vector<Favourable> favVec1 = fst.getVecByScope(favVec, "单件");
		Vector<Favourable> favVec2 = new Vector<Favourable>();
		favVec2.add(new FavourOverMinus(new FavourStyle("满减", "单件", 3, "30~5", 2, 2, 
				"ITEM000002-ITEM000003-ITEM000004-ITEM000005")));
		favVec2.add(new FavourDiscount(new FavourStyle("买赠", "单件", 1, "2~1", 1, 1, 
				"ITEM000002-ITEM000003-ITEM000004-ITEM000005")));
		
		HelperAssertEqual2Class.helpFavourable(favVec1, favVec2);
		
	}

}
