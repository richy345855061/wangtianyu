package com.wty.method;
import java.util.*;

import com.wty.domain.*;
import com.wty.method.*;


public class CreateStrategry {

	//从界面会收到产品集合 还有优惠集合
	private Vector<Product> products;
	private Vector<FavourStyle> favours;  //信息的形式例如："S-BNGMF-2-1"（单件-买赠-2-1）
							   //			 "S-DISNM-95"（单件-折扣-95）     "T-ONMM-100-10"（全部-满减-100-10）
					           //            String[] favours = {"S-BNGMF-2-1", "T-ONMM-100-10"};
	private Strategry strategry;
	private int nStyle;
	private OutputList outputList;
	
	public CreateStrategry(Vector<Product> prods, Vector<FavourStyle> favs) {
		
		this.products = prods;
		this.favours = favs;
		nStyle = 0;
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
			
			//System.out.println("haha");
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
