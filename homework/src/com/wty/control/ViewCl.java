package com.wty.control;
import java.util.*;
import com.wty.domain.*;
import com.wty.method.*;


public class ViewCl {

	//从界面会收到产品集合 还有优惠集合
	private Vector<Product> products;
	private String[] favours;  //信息的形式例如："S-BNGMF-2-1"（单件-买赠-2-1）
							   //			 "S-DISNM-95"（单件-折扣-95）     "T-ONMM-100-10"（全部-满减-100-10）
					           //            String[] favours = {"S-BNGMF-2-1", "T-ONMM-100-10"};
	private Strategry strategry;
	private int nStyle;
	
	public ViewCl(Vector<Product> prods, String[] favs) {
		
		this.products = prods;
		this.favours = favs;
		nStyle = 0;
	}

	public Vector<Product> getProducts() {
		return products;
	}
	
	public String[] getFavour() {
		
		return favours;
	}
	
	private void judegtStyle() {
		
		int size = favours.length;
		int nS = 0;
		int nT = 0;
		for (int i = 0; i < size; ++i) {
			String[] str = favours[i].split("-");
			if("S".equals(str[0])) {
				
				nS++;
			}
			else if ("T".equals(str[0])) {
				
				nT++;
			}
		}
		
		if (nS == size && 0 == nT) {
			
			strategry = new FavourAllSingle();
		}
		else if (nT == size && 0 == nS) {
			
			strategry = new FavourAllTotal();
		}
		else {
			
			strategry = new FavourSingleTotal();
		}
	}
	
	
	public void resultCl() {
		
		judegtStyle();
		
		FavourContext fc = new FavourContext(products, favours, strategry);
		fc.getResult();
		
	}
}
