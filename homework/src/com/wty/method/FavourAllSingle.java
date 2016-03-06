package com.wty.method;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;


import com.wty.domain.FavourStyle;
import com.wty.domain.Product;

public class FavourAllSingle extends Strategry {

	@Override
	public void getResult(Vector<Product> prods, Vector<Favourable> faVec) {
		// TODO Auto-generated method stub
		
		//得到每个商品满足的优惠
		Map<Product, Vector<Favourable>> mapPro = this.getProSelfFavour(prods, faVec);
		finalProInfo = new Vector<Product>();
				
		for (int j = 0; j < prods.size(); ++j) {
			
			//测试一下
			Product p = prods.get(j);
			Vector<Favourable> favv = mapPro.get(p);
			
			//商品本身不受任何优惠    或者超市不提供任何优惠
//			if (favv.size() == 0) {
//				
//				p.getResultByself(); //调用自己的方法
//			}
			
			favv = filterFavourByPriority(favv);
			
//			System.out.println(p.getName() + "-" +
//			p.getNums() + "-" +
//			p.getPrice() + "-" +
//			p.getStyle() + "-" +
//			p.getBarcode() + "-" +
//			p.getBuyFree() + "-" +
//			p.getTotal() + "-" +
//			p.getFavourMoney());
			
			if (favv.size() > 0) {
				
				for (int i = 0; i < favv.size(); ++i) {
					
					Favourable f = favv.get(i);
					//System.out.println(f.getFavourConcrete().getName());
					f.favourSingle(p);
				}
			}
			else {
				
				//如果一个优惠都不满足
				p.getResultByself();
			}
			
			
			
//			System.out.println(p.getName() + "-" +
//			p.getNums() + "-" +
//			p.getPrice() + "-" +
//			p.getStyle() + "-" +
//			p.getBarcode() + "-" +
//			p.getBuyFree() + "-" +
//			p.getTotal() + "-" +
//			p.getFavourMoney());
			
			finalProInfo.add(p);
		}
	}	
}
//
//
//
//System.out.println(p.getName() + "-" +
//		p.getNums() + "-" +
//		p.getPrice() + "-" +
//		p.getStyle() + "-" +
//		p.getBarcode() + "-" +
//		p.getBuyFree() + "-" +
//		p.getTotal() + "-" +
//		p.getFavourMoney());