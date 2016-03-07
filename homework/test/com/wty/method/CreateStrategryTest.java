package com.wty.method;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wty.control.ViewManage;
import com.wty.domain.FavourStyle;
import com.wty.domain.OutputList;
import com.wty.domain.Product;
import com.wty.test.helper.HelperAssertEqual2Class;

public class CreateStrategryTest {

	private static CreateStrategry cs = null;
	@Before
	public void setUp() throws Exception {
	}

	@BeforeClass
	public static void init() {
		
		Vector<FavourStyle> favStr2 = new Vector<FavourStyle>();
		favStr2.add(new FavourStyle("折扣", "单件", 2, "95", 1, 2, "ITEM000002-ITEM000003-ITEM000004-ITEM000005"));
		favStr2.add(new FavourStyle("买赠", "单件", 1, "2~1", 2, 1, "ITEM000002-ITEM000003-ITEM000004-ITEM000005"));
		favStr2.add(new FavourStyle("满减", "全场", 3, "100~10", 2, 0, "ITEM000001-ITEM000002-ITEM000003-ITEM000004-ITEM000005"));
		
		Vector<Product> proVec = new Vector<Product>();
		proVec.add(new Product("可口可乐", 3.0f, 2.0f, "瓶", "ITEM000001"));
		proVec.add(new Product("羽毛球", 1.0f, 3.0f, "个", "ITEM000002"));
		proVec.add(new Product("苹果", 5.5f, 6.0f, "斤", "ITEM000003"));
		proVec.add(new Product("饼干", 4.5f, 1.0f, "包", "ITEM000004"));
		proVec.add(new Product("火龙果", 9.0f, 4.0f, "斤", "ITEM000005"));
		
		cs = new CreateStrategry(proVec, favStr2);
	}
	@Test
	public void testJudegtStyle() {
		
		cs.judegtStyle();
		boolean b = false;
		if (cs.getStrategry().getClass() == FavourSingleTotal.class) {
			
			b = true;
		}
		assertEquals(b, true);
	}

	@Test
	public void testResultCl() {
		
		cs.resultCl();
		
		OutputList outputList = cs.getOutputList();
		Vector<Product> proVec = outputList.getProVec();
		Vector<Product> proVec1 = new Vector<Product>();
		
		Product p1 = new Product("可口可乐", 3.0f, 2.0f, "瓶", "ITEM000001");
		p1.setBuyFree(0.0f);
		p1.setFavourMoney(0.0f);
		p1.setTotal(6.0f);
		Product p2 = new Product("羽毛球", 1.0f, 4.0f, "个", "ITEM000002");
		p2.setBuyFree(1.0f);
		p2.setFavourMoney(0.0f);
		p2.setTotal(3.0f);
		Product p3 = new Product("苹果", 5.5f, 9.0f, "斤", "ITEM000003");
		p3.setBuyFree(3.0f);
		p3.setFavourMoney(0.0f);
		p3.setTotal(33.0f);
		Product p4 = new Product("饼干", 4.5f, 1.0f, "包", "ITEM000004");
		p4.setBuyFree(0.0f);
		p4.setFavourMoney(0.0f);
		p4.setTotal(4.5f);
		Product p5 = new Product("火龙果", 9.0f, 6.0f, "斤", "ITEM000005");
		p5.setBuyFree(2.0f);
		p5.setFavourMoney(0.0f);
		p5.setTotal(36.0f);
		proVec1.add(p1);
		proVec1.add(p2);
		proVec1.add(p3);
		proVec1.add(p4);
		proVec1.add(p5);
		
		HelperAssertEqual2Class.helpProduct(proVec, proVec1);
	}

}
