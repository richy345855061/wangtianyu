package com.wty.method;

import java.util.Vector;

import com.wty.domain.FavourStyle;
import com.wty.domain.OutputList;
import com.wty.domain.Product;

public class FavourAllTotal extends Strategry {

	@Override
	public void getResult(Vector<Product> prods, Vector<Favourable> faVec) {
		// TODO Auto-generated method stub
		
		Vector<Product> finalProInfo = new Vector<Product>();
		
		faVec = filterFavourByPriority(faVec);
		
		System.out.println(faVec.size());
		for (int i = 0; i < faVec.size(); ++i) {
			
			Favourable f = faVec.get(i);
			f.favourTotal(prods);
		}
		finalProInfo = prods; 
		outputList = new OutputList(finalProInfo);
	}
}