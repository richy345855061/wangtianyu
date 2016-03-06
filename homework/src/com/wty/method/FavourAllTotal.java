package com.wty.method;

import java.util.Vector;

import com.wty.domain.FavourStyle;
import com.wty.domain.Product;

public class FavourAllTotal extends Strategry {

	@Override
	public void getResult(Vector<Product> prods, Vector<Favourable> faVec) {
		// TODO Auto-generated method stub
		
		finalProInfo = new Vector<Product>();
		
		faVec = filterFavourByPriority(faVec);
		
		System.out.println(faVec.size());
		for (int i = 0; i < faVec.size(); ++i) {
			
			Favourable f = faVec.get(i);
			f.favourTtoal(prods);
		}
		finalProInfo = prods;
//		System.out.println("产品信息");
//		for (int i = 0; i < prods.size(); ++i) {
//			
//			Product p = prods.get(i);
//			System.out.println(p.getName() + "-" +
//								p.getNums() + "-" +
//								p.getPrice() + "-" +
//								p.getStyle() + "-" +
//								p.getBarcode());
//		}
//		
//		System.out.println("优惠信息");
//		for (int i = 0; i < faVec.size(); ++i) {
//			
//			FavourStyle fs = faVec.get(i).getFavourConcrete();
//			System.out.println(fs.getName() + "-" +
//					fs.getId() + "-" +
//					fs.getScope() + "-" +
//					fs.getPriority() + "-" +
//					fs.getMorePriority() + "-" +
//					fs.getFavWeight());
//		}
	}
}