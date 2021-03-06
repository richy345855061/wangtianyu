package com.wty.method;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;


import com.wty.domain.FavourStyle;
import com.wty.domain.OutputList;
import com.wty.domain.Product;

public class FavourAllSingle extends Strategry {

	@Override
	public void getResult(Vector<Product> prods, Vector<Favourable> faVec) {
		// TODO Auto-generated method stub
		
		//得到每个商品满足的优惠
		Map<Product, Vector<Favourable>> mapPro = this.getProSelfFavour(prods, faVec);
		Vector<Product> finalProInfo = new Vector<Product>();
		
				
		for (int j = 0; j < prods.size(); ++j) {
			
			//测试一下
			Product p = prods.get(j);
			Vector<Favourable> favv = mapPro.get(p);
			
			favv = filterFavourByPriority(favv);
			
			if (favv.size() > 0) {
				
				for (int i = 0; i < favv.size(); ++i) {
					
					Favourable f = favv.get(i);
					f.favourSingle(p);
				}
			}
			else {
				
				//如果一个优惠都不满足
				p.getResultByself();
			}

			finalProInfo.add(p);
		}
		outputList = new OutputList(finalProInfo);
	}	
}