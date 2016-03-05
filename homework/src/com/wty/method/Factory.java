package com.wty.method;

import com.wty.domain.FavourStyle;

//����
abstract class Factory {

	protected FavourStyle favourConcrete;  //��������2��һ������3��һ
	public abstract Favourable createFavour();
}

//�����һ   ��һ����0.5��
class FactoryB2G1F extends Factory {

	public FactoryB2G1F(FavourStyle favs) {
		
		this.favourConcrete = favs;

	}

	@Override
	public Favourable createFavour() {
		// TODO Auto-generated method stub
		
		return new FavourB2G1F(favourConcrete);
	}
	
	
}


//���� 95��  ȫ��95��
class Factory95Dis extends Factory {

	public Factory95Dis(FavourStyle favs) {
		
		this.favourConcrete = favs;
	}

	@Override
	public Favourable createFavour() {
		// TODO Auto-generated method stub
		return new Favour95Dis(favourConcrete);
	}
	
	
}

//��200��20  ��10��1.5
class FactoryO200M10 extends Factory {
	
	public FactoryO200M10(FavourStyle favs) {
		
		this.favourConcrete = favs;
	}

	@Override
	public Favourable createFavour() {
		// TODO Auto-generated method stub
		return new FavourO200M10(favourConcrete);
	}
	
	
}
