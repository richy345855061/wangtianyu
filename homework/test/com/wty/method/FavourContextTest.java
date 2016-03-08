package com.wty.method;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wty.domain.FavourStyle;
import com.wty.domain.Product;
import com.wty.test.helper.HelperAssertEqual2Class;

public class FavourContextTest {
	
	private static FavourContext fc = null;
	private static Vector<Product> proVec = null;
	private static Vector<FavourStyle> fsVec = null;
	private static Strategry sg = null;

	@BeforeClass
	public static void init() {
		
		proVec = new Vector<Product>();
		sg = new FavourAllSingle();
		fsVec = new Vector<FavourStyle>();
		FavourStyle f1 = new FavourStyle("满减", "单件", 3, "30~5", 2, 2, 
				"ITEM000002-ITEM000003-ITEM000004-ITEM000005");
		FavourStyle f2 = new FavourStyle("买赠", "单件", 1, "2~1", 1, 1, 
				"ITEM000002-ITEM000003-ITEM000004-ITEM000005");
		fsVec.add(f1);
		fsVec.add(f2);
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFavourContext() {
	
		fc = new FavourContext(proVec, fsVec, sg);
		Vector<Favourable> favVec = fc.getFaVec();
		Vector<Favourable> favVec1 = new Vector<Favourable>();
		Favourable f1 = new FavourOverMinus(new FavourStyle("满减", "单件", 3, "30~5", 2, 2, 
				"ITEM000002-ITEM000003-ITEM000004-ITEM000005"));
		Favourable f2 = new FavourDiscount(new FavourStyle("买赠", "单件", 1, "2~1", 1, 1, 
				"ITEM000002-ITEM000003-ITEM000004-ITEM000005"));
		favVec1.add(f1);
		favVec1.add(f2);
		
		HelperAssertEqual2Class.helpFavourable(favVec, favVec1);
	}

}
