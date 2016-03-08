package com.wty.method;
import java.util.*;

import com.wty.domain.*;
import com.wty.method.*;


public class CreateStrategry {

	//从界面会收到产品集合 还有优惠集合
	private Vector<Product> products;
	private Vector<FavourStyle> favours;  //信息的形式例如："折扣-单件-95-2-1"
							 		      //优惠类型-优惠范围-优惠力度-优先级-更高优先级
	private Strategry strategry;
	private OutputList outputList;
	
	public CreateStrategry(Vector<Product> prods, Vector<FavourStyle> favs) {
		
		this.products = prods;
		this.favours = favs;
		strategry = null;
	}
	
	public Strategry getStrategry() {
		return strategry;
	}

	public void setStrategry(Strategry strategry) {
		this.strategry = strategry;
	}

	public Vector<Product> getProducts() {
		return products;
	}
	
	public Vector<FavourStyle> getFavour() {
		
		return favours;
	}
	
	public OutputList getOutputList() {
		return outputList;
	}
	
	public void judegtStyle() {
		
		int size = favours.size();
		int nS = 0;
		int nT = 0;
		for (int i = 0; i < size; ++i) {
			String str = favours.get(i).getScope();
			if("单件".equals(str)) {
				
				nS++;
			}
			else if ("全场".equals(str)) {
				
				nT++;
			}
		}
		
		if (nS == size && 0 == nT && size != 0) {
			
			strategry = new FavourAllSingle();
		}
		else if (nT == size && 0 == nS && size != 0) {
			
			strategry = new FavourAllTotal();
		}
		else if (size == 0) {
			
			strategry = new FavourNoSingleTotal();
		}
		else {
			
			strategry = new FavourSingleTotal();
		}
	}
	
	public void resultCl() {
		
		//判断优惠叠加类型
		judegtStyle();
		
		//生成Context 通过相应的函数处理数据
		FavourContext fc = new FavourContext(products, favours, strategry);
		fc.getResult();
		this.outputList = fc.getOutputList();
	}
}
