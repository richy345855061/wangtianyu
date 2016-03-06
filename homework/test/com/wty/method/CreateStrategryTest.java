package com.wty.method;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wty.control.ViewManage;
import com.wty.domain.FavourStyle;

public class CreateStrategryTest {

	private static CreateStrategry cs = null;
	@Before
	public void setUp() throws Exception {
	}

	@BeforeClass
	public static void init() {
		
		Vector<FavourStyle> favStr2 = new Vector<FavourStyle>();
		favStr2.add(new FavourStyle("折扣", "单件", 2, "95", 1, 2, "ITEM000005"));
		favStr2.add(new FavourStyle("买赠", "单件", 1, "2~1", 2, 1, "ITEM000002-ITEM000003"));
		favStr2.add(new FavourStyle("满减", "全场", 1, "100~10", 2, 1, "ITEM000002-ITEM000003"));
		
		cs = new CreateStrategry(null, favStr2);
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
	}

}
