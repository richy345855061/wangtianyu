package com.wty.method;

import java.util.Vector;

import com.wty.domain.FavourStyle;
import com.wty.domain.Product;

public class FavourBuyForFree extends Favourable {

	public FavourBuyForFree(FavourStyle fc) {
		
		this.favourConcrete = fc;
	}
	
	@Override
	public void favourSingle(Product p) {
		// TODO Auto-generated method stub
		
		//单件买2赠一  买2斤送1斤  
		
		String[] favStr = favourConcrete.getFavWeight().split("~");  // index 0 1 
		float buy = Float.parseFloat(favStr[0]);
		float free = Float.parseFloat(favStr[1]);
		float nums = p.getNums();
		
		
		//如果是个数不整或者买赠不整  如买2.5斤送0.5斤
		float buyFree = (int)(nums*10) / (int)(buy*10) * free;
		
		//小计
		float total = nums * p.getPrice();
		
		p.setTotal(total);
		p.setBuyFree(buyFree);
		p.setNums(nums + buyFree);
	}
	@Override
	public void favourTotal(Vector<Product> proVec) {
		// TODO Auto-generated method stub
	}
	
	
}
