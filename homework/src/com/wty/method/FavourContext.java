package com.wty.method;
import java.util.*;

import com.wty.domain.*;

public class FavourContext {

	private Vector<Favourable> faVec;
	private Vector<Product> products;
	private Vector<FavourStyle> favs;
	private Strategry strategry;
	private Vector<Product> finalProInfo;
	
	public FavourContext(Vector<Product> prods, Vector<FavourStyle> fas, Strategry sg) {
		
		this.products = prods;
		this.strategry = sg;
		this.favs = fas;
		Favourable fa = null;
		faVec = new Vector<Favourable>();
		
		for (int i = 0; i < favs.size(); ++i) {
			fa = null;
			
			FavourStyle fs = favs.get(i);
			int nType = fs.getId();
			
			//优惠数据
//			String[] favStr = fs.getFavWeight().split("-");
			//[0]标注是单件还是全场   [1]标注是哪种优惠
//          String[] favours = {"S-买N赠M-2-1", "T-满N减M-100-10"};
			switch (nType) {
			case 1://买2赠一
				fa = new FactoryB2G1F(fs).createFavour();
				break;
				
			case 2://95%
				fa = new Factory95Dis(fs).createFavour();
				break;
				
			case 3://满200减100
				fa = new FactoryO200M10(fs).createFavour();
				break;

			default:
				break;
			}
			
			faVec.add(fa);  //可以能为组合
		}
	}
	
	public Vector<Product> getFinalProInfo() {
		return finalProInfo;
	}

	public void getResult() {
		
		//将每个商品进行判断处理
		//例如结果如下
		//可口可乐
		
		strategry.getResult(products, faVec);
		this.finalProInfo = strategry.getFinalProInfo();		
	}
	
}
