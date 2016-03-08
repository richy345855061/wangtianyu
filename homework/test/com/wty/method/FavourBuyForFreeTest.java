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

public class FavourBuyForFreeTest {
	
	private static FavourBuyForFree fbff = null;
	private static FavourStyle fs = null;

	@BeforeClass
	public static void init() {
		
		fs = new FavourStyle("ÂòÔù", "µ¥¼þ", 1, "2~1", 1, 1, 
				"ITEM000002-ITEM000003-ITEM000004-ITEM000005");
		fbff = new FavourBuyForFree(fs);
		
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFavourSingle() {

		Product p1 = new Product("ÓðÃ«Çò", 1.0f, 5.0f, "¸ö", "ITEM000002"); 
		fbff.favourSingle(p1);
		Product p2 = new Product("ÓðÃ«Çò", 1.0f, 7.0f, "¸ö", "ITEM000002"); 
		p2.setBuyFree(2.0f);
		p2.setFavourMoney(0.0f);
		p2.setTotal(5.0f);
		
		HelperAssertEqual2Class.helpProductSingle(p1, p2);
	}

	@Test
	public void testFavourTotal() {

	}

}
