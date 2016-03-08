package com.wty.method;

import com.wty.domain.FavourStyle;

//����
abstract class Factory {

	protected FavourStyle favourConcrete;  //��������2��һ������3��һ
	public abstract Favourable createFavour();
}

//�����һ   ��һ����0.5��
class FactoryBuyForFree extends Factory {

	public FactoryBuyForFree(FavourStyle favs) {
		
		this.favourConcrete = favs;

	}

	@Override
	public Favourable createFavour() {
		// TODO Auto-generated method stub
		
		return new FavourBuyForFree(favourConcrete);
	}
	
	
}


//���� 95��  ȫ��95��
class FactoryDiscount extends Factory {

	public FactoryDiscount(FavourStyle favs) {
		
		this.favourConcrete = favs;
	}

	@Override
	public Favourable createFavour() {
		// TODO Auto-generated method stub
		return new FavourDiscount(favourConcrete);
	}
	
	
}

//��200��20  ��10��1.5
class FactoryOverMinus extends Factory {
	
	public FactoryOverMinus(FavourStyle favs) {
		
		this.favourConcrete = favs;
	}

	@Override
	public Favourable createFavour() {
		// TODO Auto-generated method stub
		return new FavourOverMinus(favourConcrete);
	}
	
	
}
