package com.wty.control;
import java.util.*;

import com.wty.domain.*;
import com.wty.method.*;
import com.wty.tools.RWStrHelper;


public class ViewCl {

	private String filePath;
	private Vector<String> strVec;
	
	public ViewCl(String fp, Vector<String> sv) {
		
		this.filePath = fp;
		this.strVec = sv;
		
		this.doPro();
	}
	
	private void doPro() {
		
		//得到FavourStyle类集合
		Vector<FavourStyle> fsVec = RWStrHelper.creObjByCkb(strVec);
		
		//得到Product类集合
		Map<String, Integer> proMap = RWStrHelper.readBarData(filePath);
		Vector<Product> proVec = RWStrHelper.creObjByBarcode(proMap);
		
		//传递给类CreateStrategry 生成相应的Strategry
		CreateStrategry cs = new CreateStrategry(proVec, fsVec);
		
//		RWStrHelper.printProduct(proVec);
//		RWStrHelper.printFavour(fsVec);
		
		cs.resultCl();
	}
}
