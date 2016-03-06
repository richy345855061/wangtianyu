package com.wty.method;

import java.util.Vector;

import com.wty.domain.FavourStyle;
import com.wty.domain.Product;

public abstract class Favourable {

	protected FavourStyle favourConcrete;
	public FavourStyle getFavourConcrete() {
		return favourConcrete;
	}
	public void setFavourConcrete(FavourStyle favourConcrete) {
		this.favourConcrete = favourConcrete;
	}
	//�����Ż�
	public abstract void favourSingle(Product p);
	//ȫ����Ʒ�Ż�
	public abstract void favourTtoal(Vector<Product> proVec);
}






