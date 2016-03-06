package com.wty.method;

import java.util.Vector;

import com.wty.domain.FavourStyle;
import com.wty.domain.Product;

public class FavourDiscount extends Favourable {

	public FavourDiscount(FavourStyle fc) {
		this.favourConcrete = fc;
	}
	@Override
	public void favourSingle(Product p) {
		// TODO Auto-generated method stub
		//ЕЅМў95ел
		
		float discount = Float.parseFloat(favourConcrete.getFavWeight());
		float total = p.getTotal();
		if (total < 0.000001) {
			
			total = p.getNums() * p.getPrice();
		}

		float favourMoney = (100 - discount) / 100.0f * total;
		
		p.setTotal(total - favourMoney);
		p.setFavourMoney(favourMoney + p.getFavourMoney());
				
	}

	@Override
	public void favourTtoal(Vector<Product> proVec) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < proVec.size(); ++i) {
			
			Product p = proVec.get(i);
			this.favourSingle(p);
		}
	}
	
	
}
