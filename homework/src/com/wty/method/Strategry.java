package com.wty.method;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.wty.domain.FavourStyle;
import com.wty.domain.Product;

public abstract class Strategry {

	//最终的商品信息
	protected Vector<Product> finalProInfo;
	
	public Vector<Product> getFinalProInfo() {
		return finalProInfo;
	}

	public void setFinalProInfo(Vector<Product> finalProInfo) {
		this.finalProInfo = finalProInfo;
	}
	////////////////////////////////////
	abstract public void getResult(Vector<Product> prods, Vector<Favourable> faVec);
	
	//确定商品都有哪些优惠
	public Map<Product, Vector<Favourable>> getProSelfFavour(Vector<Product> prods, 
			Vector<Favourable> faVec) {
		
		Map<Product, Vector<Favourable>> mapPro = new HashMap<Product, Vector<Favourable>>();
		
		//先确定商品满足的优惠
		for (int j = 0; j < prods.size(); ++j) {
			
			//indexOf
			Product p = prods.get(j);
			Vector<Favourable> proVec = new Vector<Favourable>();//商品满足的优惠
			
			for (int i = 0; i < faVec.size(); ++i) {
				
				Favourable f = faVec.get(i);
				String favStr = f.getFavourConcrete().getFavProducts();
				//如果该商品在优惠条形码中
				if (favStr.indexOf(p.getBarcode()) != -1) {
					
					proVec.add(f);
				}
			}
			
			//通过优先级滤掉优惠   如果优先级相同  排优惠顺序
			
			
			mapPro.put(p, proVec);
		}
		
		return mapPro;
	}
	
	//根据优先级滤掉优惠  如果优先级相同排优惠顺序
	public Vector<Favourable> filterFavourByPriority(Vector<Favourable>favVec) {
		
	
		//优先级提取
		int size = favVec.size();
		int[] priNums = new int[size];
		for (int i = 0; i < size; ++i) {
			
			priNums[i] = favVec.get(i).getFavourConcrete().getPriority();
		}
		
		Arrays.sort(priNums);
		Vector<Favourable> vec1 = new Vector<Favourable>();
		
		for (int i = 0; i < size; ++i) {
			
			Favourable f = favVec.get(i);
			int priority = f.getFavourConcrete().getPriority();
			if (priNums[priNums.length - 1] == priority) {
				
				vec1.add(f);
			}
		}
		//更高优先级排序
		Vector<Favourable> vec2 = new Vector<Favourable>();
		
		int size2 = vec1.size();
		if (size2 > 1) {
			int[] morePriNums = new int[size2];
			
			for (int k = 0; k < size2; ++k) {
				
				Favourable f = vec1.get(k);
				morePriNums[k] = f.getFavourConcrete().getMorePriority();
			}
			
			Arrays.sort(morePriNums);
			
			for (int i = morePriNums.length-1; i >= 0; --i) {
			
				for (int j = 0; j < vec1.size(); ++j) {
				
					if (morePriNums[i] == vec1.get(j).getFavourConcrete().getMorePriority()) {
					
						vec2.add(vec1.get(j));
						break;
					}
				}
			}
//		if (vec1.size() > 1) {
//			
//			//排序
//			Map<Integer, Favourable> maps = new HashMap<Integer, Favourable>();
//			
//			int size2 = vec1.size();
//			int[] morePriNums = new int[size2];
//			for (int k = 0; k < size2; ++k) {
//				
//				Favourable f = vec1.get(k);
//				int priTemp = f.getFavourConcrete().getMorePriority();
//				morePriNums[k] = priTemp;
//				maps.put(priTemp, f);
//				
//			}
//			
//			Arrays.sort(morePriNums);
//			
//			
//			for (int p = morePriNums.length - 1; p >= 0; --p) {
//				
//				vec2.add(maps.get(p));
//			}
			//System.out.println(vec2.get(0).getFavourConcrete().getName());
			return vec2;
		}
		else {
			
			return vec1;
		}
	}
}
