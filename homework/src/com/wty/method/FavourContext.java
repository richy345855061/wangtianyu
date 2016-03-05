package com.wty.method;
import java.util.*;
import com.wty.domain.*;

public class FavourContext {

	private Vector<Favourable> faVec;
	private Vector<Product> products;
	private String[] favs;
	private Strategry strategry;
	
	public FavourContext(Vector<Product> prods, String[] fas, Strategry sg) {
		
		this.products = prods;
		this.strategry = sg;
		this.favs = fas;
		Favourable fa = null;
		faVec = new Vector<Favourable>();
		
		for (int i = 0; i < favs.length; ++i) {
			fa = null;
			
			String style = favs[i];
			String[] styles = style.split("-");
			int[] iStyles = new int[styles.length];
			for (int j = 0; j < styles.length; ++j) {
				
				iStyles[j] = Integer.parseInt(styles[j]);
			}
			//[0]标注是单件还是全场   [1]标注是哪种优惠
//          String[] favours = {"S-买N赠M-2-1", "T-满N减M-100-10"};
			switch (iStyles[1]) {
			case 1://买2赠一
				fa = new FactoryB2G1F(style).createFavour();
				break;
				
			case 2://95%
				fa = new Factory95Dis(style).createFavour();
				break;
				
			case 3://满200减100
				fa = new FactoryO200M10(style).createFavour();
				break;

			default:
				break;
			}
			
			faVec.add(fa);  //可以能为组合
		}
	}
	
	
	public void getResult() {
		
		//将每个商品进行判断处理
		//例如结果如下
		//可口可乐
		
		strategry.getResult(products, faVec);
		
		
	}
	
}
