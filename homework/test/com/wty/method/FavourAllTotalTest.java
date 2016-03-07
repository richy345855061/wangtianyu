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

public class FavourAllTotalTest {

	private static FavourAllTotal fat = null;
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
		Favourable f1 = new FavourOverMinus(new FavourStyle("满减", "全场", 3, "30~5", 2, 1, 
													"ITEM000002-ITEM000003-ITEM000004-ITEM000005"));
		Favourable f2 = new FavourDiscount(new FavourStyle("折扣", "全场", 2, "95", 2, 2, 
				"ITEM000002-ITEM000003-ITEM000004-ITEM000005"));
		
		favVec.add(f1);
		favVec.add(f2);
		
		
		fat = new FavourAllTotal();
		fat.setOutputList((new OutputList(new Vector<Product>())));
		
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetResult() {
		fat.getResult(proVec, favVec);
		
		OutputList outputList = fat.getOutputList();
		Vector<Product> proVec1 = outputList.getProVec();
		Vector<Product> proVec2 = new Vector<Product>();
		Product p1 = new Product("可口可乐", 3.0f, 2.0f, "瓶", "ITEM000001");
		p1.setBuyFree(0.0f);
		p1.setFavourMoney(0.3f);
		p1.setTotal(5.7f);
		Product p2 = new Product("羽毛球", 1.0f, 3.0f, "个", "ITEM000002");
		p2.setBuyFree(0.0f);
		p2.setFavourMoney(0.15f);
		p2.setTotal(2.85f);
		Product p3 = new Product("苹果", 5.5f, 6.0f, "斤", "ITEM000003");
		p3.setBuyFree(0.0f);
		p3.setFavourMoney(1.65f);
		p3.setTotal(31.35f);
		Product p4 = new Product("饼干", 4.5f, 1.0f, "包", "ITEM000004");
		p4.setBuyFree(0.0f);
		p4.setFavourMoney(0.23f);
		p4.setTotal(4.275f);
		Product p5 = new Product("火龙果", 9.0f, 4.0f, "斤", "ITEM000005");
		p5.setBuyFree(0.0f);
		p5.setFavourMoney(1.8f);
		p5.setTotal(34.2f);
		proVec2.add(p1);
		proVec2.add(p2);
		proVec2.add(p3);
		proVec2.add(p4);
		proVec2.add(p5);
		
		HelperAssertEqual2Class.helpProduct(proVec1, proVec2);
	}

}
