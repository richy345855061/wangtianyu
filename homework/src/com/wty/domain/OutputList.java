package com.wty.domain;

import java.util.Vector;

public class OutputList {

	private Vector<Product> proVec;
	private float allTotal;
	private float allFavourMoney;
	
	public OutputList(Vector<Product> proVec) {
		
		this.proVec = proVec;
	}
	
	
	public boolean isExistBuyGetFree() {
		
		boolean isExist = false;
		for (int i = 0; i < proVec.size(); ++i) {
		
			Product p = proVec.get(i);
		
			if (p.getBuyFree() > 0.0000001) {
				
				isExist = true;
				break;
			}
		}
		return isExist;
	}
	
	public Vector<Product> getProVec() {
		return proVec;
	}
	public void setProVec(Vector<Product> proVec) {
		this.proVec = proVec;
	}
	public float getAllTotal() {
		
		allTotal = 0.0f;
		for (int i = 0; i < proVec.size(); ++i) {
			
			Product p = proVec.get(i);
			allTotal += p.getTotal();
		}
		return allTotal;
	}

	public float getAllFavourMoney() {
		
		allFavourMoney = 0.0f;
		for (int i = 0; i < proVec.size(); ++i) {
			
			Product p = proVec.get(i);
			allFavourMoney += p.getFavourMoney();
		}
		
		return allFavourMoney;
	}
	
}
