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
		
		//�õ�FavourStyle�༯��
		Vector<FavourStyle> fsVec = RWStrHelper.creObjByCkb(strVec);
		
		//�õ�Product�༯��
		Map<String, Integer> proMap = RWStrHelper.readBarData(filePath);
		Vector<Product> proVec = RWStrHelper.creObjByBarcode(proMap);
		
		//���ݸ���CreateStrategry ������Ӧ��Strategry
		CreateStrategry cs = new CreateStrategry(proVec, fsVec);
		
//		RWStrHelper.printProduct(proVec);
//		RWStrHelper.printFavour(fsVec);
		
		cs.resultCl();
	}
}
