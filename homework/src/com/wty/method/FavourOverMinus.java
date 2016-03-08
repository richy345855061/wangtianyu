package com.wty.method;

import java.util.Vector;

import com.wty.domain.FavourStyle;
import com.wty.domain.Product;

public class FavourOverMinus extends Favourable {

	public FavourOverMinus(FavourStyle fc) {
		this.favourConcrete = fc;
	}
	
	@Override
	public void favourSingle(Product p) {
		// TODO Auto-generated method stub
		
		String[] favStr = favourConcrete.getFavWeight().split("~");
		float over = Float.parseFloat(favStr[0]);
		float minus = Float.parseFloat(favStr[1]);
		//满 减前可能没有经过优惠 可能经过优惠 所以按下算
		float nums = p.getNums();
		float buyFree = p.getBuyFree();
		float price = p.getPrice();
		int flag = 0; //表示没满减
		
		//float total = (nums - buyFree) * price; //防止前面经过买 赠  先减去赠数量
		float total = p.getTotal();
		//说明商品前面没有经过一次优惠
		if (total < 0.00000001) {
			
			total = (nums - buyFree) * price; //防止前面经过买 赠  先减去赠数量
		}
		
		if (total - over > 0.00000001) {
			
			total -= minus;
			flag = 1;
		}
		
		p.setTotal(total);
		if (1 == flag) {
			float fm = p.getFavourMoney();
			p.setFavourMoney(minus + fm);
			//单件满减没有
			//Product.sAllOverFree += minus;
		}
		
	}

	@Override
	public void favourTotal(Vector<Product> proVec) {
		// TODO Auto-generated method stub
		
		//总体满200减10
		//如果直接全场满减 则必须先得到所有产品各自的小计
		if (proVec.size() > 0 && proVec.get(0).getTotal() < 0.0000001) {
			
			for (int i = 0; i < proVec.size(); ++i) {
				
				proVec.get(i).getResultByself();
			}
		}
		
		String[] favStr = favourConcrete.getFavWeight().split("~");
		float over = Float.parseFloat(favStr[0]);
		float minus = Float.parseFloat(favStr[1]);
		
		float allTotal = 0.0f;
		for (int i = 0; i < proVec.size(); ++i) {
			
			Product p = proVec.get(i);
			allTotal += p.getTotal();
		}
		
		if (allTotal - over > 0.0000001) {
			
			Product.sAllOverFree = minus;
		}
	}
}
