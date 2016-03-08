package com.wty.method;

import com.wty.domain.FavourStyle;

//工厂
abstract class Factory {

	protected FavourStyle favourConcrete;  //具体是买2赠一还是买3赠一
	public abstract Favourable createFavour();
}

//买二赠一   买一斤赠0.5斤
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


//单件 95折  全场95折
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

//满200减20  满10减1.5
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
