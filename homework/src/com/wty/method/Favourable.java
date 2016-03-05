package com.wty.method;

import java.util.Vector;

import com.wty.domain.FavourStyle;
import com.wty.domain.Product;

abstract class Favourable {

	protected FavourStyle favourConcrete;
	public FavourStyle getFavourConcrete() {
		return favourConcrete;
	}
	public void setFavourConcrete(FavourStyle favourConcrete) {
		this.favourConcrete = favourConcrete;
	}
	//单件优惠
	public abstract void favourSingle(Product p);
	//全部商品优惠
	public abstract void favourTtoal(Vector<Product> proVec);
}

class FavourB2G1F extends Favourable {

	public FavourB2G1F(FavourStyle fc) {
		
		this.favourConcrete = fc;
	}
	
	@Override
	public void favourSingle(Product p) {
		// TODO Auto-generated method stub
		
		//单件买2赠一  买2斤送1斤  
		
		String[] favStr = favourConcrete.getFavWeight().split("~");  // index 0 1 
		float buy = Float.parseFloat(favStr[0]);
		float free = Float.parseFloat(favStr[1]);
		float nums = p.getNums();
		
		
		//如果是个数不整或者买赠不整  如买2.5斤送0.5斤
		float buyFree = (int)(nums*10) / (int)(buy*10) * free;
		
		//小计
		float total = nums * p.getPrice();
		
		p.setTotal(total);
		p.setBuyFree(buyFree);
		p.setNums(nums + buyFree);
//		System.out.println("总价" + total);
//		System.out.println("赠" + buyFree);
	}
	@Override
	public void favourTtoal(Vector<Product> proVec) {
		// TODO Auto-generated method stub
	}
	
	
}

class Favour95Dis extends Favourable {

	public Favour95Dis(FavourStyle fc) {
		this.favourConcrete = fc;
	}
	@Override
	public void favourSingle(Product p) {
		// TODO Auto-generated method stub
		//单件95折
		
		float discount = Float.parseFloat(favourConcrete.getFavWeight());
		float total = p.getNums() * p.getPrice();
		float favourMoney = (100 - discount) / 100.0f * total;
		
		p.setTotal(total - favourMoney);
		p.setFavourMoney(favourMoney);
		
	}

	@Override
	public void favourTtoal(Vector<Product> proVec) {
		// TODO Auto-generated method stub
	}
	
	
}

class FavourO200M10 extends Favourable {

	public FavourO200M10(FavourStyle fc) {
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
		//说明商品前面已经经过一次优惠
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
		}
		
	}

	@Override
	public void favourTtoal(Vector<Product> proVec) {
		// TODO Auto-generated method stub
		
		//总体满200减10
	}
	
	
}
