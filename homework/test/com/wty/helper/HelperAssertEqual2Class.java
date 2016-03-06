package com.wty.helper;

import static org.junit.Assert.assertEquals;

import java.util.Vector;

import com.wty.domain.FavourStyle;
import com.wty.domain.Product;

public class HelperAssertEqual2Class {

	
	//比较favourStyle类是否相同
	public static void helpFavourStyle(Vector<FavourStyle> favStr1, Vector<FavourStyle> favStr2) {
		
		for (int i = 0; i < favStr1.size(); ++i) {
			
			FavourStyle fs1 = favStr1.get(i);
			FavourStyle fs2 = favStr2.get(i);
			assertEquals(fs1.getName(), fs2.getName());
			assertEquals(fs1.getScope(), fs2.getScope());
			assertEquals(fs1.getId(), fs2.getId());
			assertEquals(fs1.getFavWeight(), fs2.getFavWeight());
			assertEquals(fs1.getPriority(), fs2.getPriority());
			assertEquals(fs1.getMorePriority(), fs2.getMorePriority());
			assertEquals(fs1.getFavProducts(), fs2.getFavProducts());
		}
	}
	
	//比较product类是否相同
	public static void helpProduct(Vector<Product> proVec1, Vector<Product> proVec2) {
		
		for (int i = 0; i < proVec1.size(); ++i) {
			
			Product p1 = proVec1.get(i);
			Product p2 = proVec2.get(i);
			assertEquals("1", p1.getName(), p2.getName());
			assertEquals("22", p1.getPrice()+"", p2.getPrice()+"");
			assertEquals("3", p1.getNums()+"", p2.getNums()+"");
			assertEquals("4", p1.getStyle(), p2.getStyle());
			assertEquals("5", p1.getBarcode(), p2.getBarcode());
			assertEquals("6", p1.getBuyFree()+"", p2.getBuyFree()+"");
			assertEquals("7", p1.getTotal()+"", p2.getTotal()+"");
			assertEquals("8", p1.getFavourMoney()+"", p2.getFavourMoney()+"");
		}
	}
}
