package com.wty.method;

import java.util.Map;
import java.util.Vector;

import com.wty.domain.FavourStyle;
import com.wty.domain.OutputList;
import com.wty.domain.Product;

public class FavourSingleTotal extends Strategry {

	//通过范围得到相应的vector
	public Vector<Favourable> getVecByScope(Vector<Favourable> faVec, String scope) {
		
		Vector<Favourable> resVec = new Vector<Favourable>();
		
		for (int i = 0; i < faVec.size(); ++i) {
			
			Favourable f = faVec.get(i);
			if (scope.equals(f.getFavourConcrete().getScope())) {
				
				resVec.add(f);
			}
		}
		return resVec;
	}
	
	@Override
	public void getResult(Vector<Product> prods, Vector<Favourable> faVec) {
		// TODO Auto-generated method stub
		
		Vector<Product> finalProInfo = new Vector<Product>();
		System.out.println("s-t");
		
		//先把全和单分开
		Vector<Favourable> sVec = new Vector<Favourable>();
		sVec = this.getVecByScope(faVec, "单件");
		Vector<Favourable> tVec = new Vector<Favourable>();
		tVec = this.getVecByScope(faVec, "全场");

				
		//先处理单个
		Map<Product, Vector<Favourable>> mapPro = this.getProSelfFavour(prods, sVec);
				
		for (int j = 0; j < prods.size(); ++j) {
			

			//测试一下
			Product p = prods.get(j);
			Vector<Favourable> favv = mapPro.get(p);
			//System.out.println("第一个大小" + favv.size() + p.getName());
			//加上所有的全部
			favv.addAll(tVec);
//			//通过优先过滤			
			favv = filterFavourByPriority(favv);
//			//再次去掉里面的全局性优惠
			tVec = this.getVecByScope(favv, "全场");
			favv = this.getVecByScope(favv, "单件");
			
//			
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
		}
		
		
//		//全部
//		//tVec = filterFavourByPriority(tVec);
//		
		for (int i = 0; i < tVec.size(); ++i) {
			
			Favourable f = tVec.get(i);
			f.favourTtoal(prods);
		}
		
		finalProInfo = prods;
		outputList = new OutputList(finalProInfo);
	}
	
}

