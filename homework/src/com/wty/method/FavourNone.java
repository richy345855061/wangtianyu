package com.wty.method;

import java.util.Vector;

import com.wty.domain.Product;

public class FavourNone extends Strategry{

	@Override
	public void getResult(Vector<Product> prods, Vector<Favourable> faVec) {
		// TODO Auto-generated method stub
		
		finalProInfo = new Vector<Product>();
		System.out.println("caonima");
		for (int i = 0; i < prods.size(); ++i) {
			
			Product p = prods.get(i);
			p.getResultByself();
			finalProInfo.add(p);
		}
	}

}
