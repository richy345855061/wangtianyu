package com.wty.method;

import com.wty.domain.FavourStyle;

//����
abstract class Factory {

	protected FavourStyle favourConcrete;  //��������2��һ������3��һ
	public abstract Favourable createFavour();
}

class FactoryB2G1F extends Factory {

	public FactoryB2G1F(FavourStyle favs) {
		
		this.favourConcrete = favs;
	}
	
	@Override
	public Favourable createFavour() {
		// TODO Auto-generated method stub
		
		return new FavourB2G1F();
	}
	
	
}

class Factory95Dis extends Factory {

	public Factory95Dis(FavourStyle favs) {
		
		this.favourConcrete = favs;
	}
	
	@Override
	public Favourable createFavour() {
		// TODO Auto-generated method stub
		return new Favour95Dis();
	}
	
	
}

class FactoryO200M10 extends Factory {
	
	public FactoryO200M10(FavourStyle favs) {
		
		this.favourConcrete = favs;
	}
	
	@Override
	public Favourable createFavour() {
		// TODO Auto-generated method stub
		return new FavourO200M10();
	}
	
	
}
