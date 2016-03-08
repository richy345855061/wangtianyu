package com.wty.method;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wty.domain.FavourStyle;
import com.wty.domain.Product;
import com.wty.test.helper.HelperAssertEqual2Class;

public class FavourDiscountTest {
	
	private static FavourDiscount fd = null;
	private static Vector<Product> proVec = null;
	private static FavourStyle fs = null;

	@BeforeClass
	public static void init() {
		
		fs = new FavourStyle("折扣", "单件", 2, "95", 1, 1, 
				"ITEM000001");
		fd = new FavourDiscount(fs);
		
		proVec = new Vector<Product>();
		proVec.add(new Product("可口可乐", 3.0f, 2.0f, "瓶", "ITEM000001"));
		proVec.add(new Product("羽毛球", 1.0f, 3.0f, "个", "ITEM000002"));
		proVec.add(new Product("苹果", 5.5f, 6.0f, "斤", "ITEM000003"));
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFavourSingle() {

		Product p1 = new Product("可口可乐", 3.0f, 2.0f, "瓶", "ITEM000001");
		fd.favourSingle(p1);
		
		Product p2 = new Product("可口可乐", 3.0f, 2.0f, "瓶", "ITEM000001");
		p2.setBuyFree(0.0f);
		p2.setFavourMoney(0.3f);
		p2.setTotal(5.7f);
		
		HelperAssertEqual2Class.helpProductSingle(p1, p2);
	}

	@Test
	public void testFavourTotal() {

		fd.favourTotal(proVec);
		Vector<Product> proVec1 = new Vector<Product>();
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
		proVec1.add(p1);
		proVec1.add(p2);
		proVec1.add(p3);
		
		HelperAssertEqual2Class.helpProductVec(proVec, proVec1);
		
		
	}

}
