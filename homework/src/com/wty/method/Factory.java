package com.wty.method;

import com.wty.domain.FavourStyle;

//工厂
abstract class Factory {

	protected FavourStyle favourConcrete;  //具体是买2赠一还是买3赠一
	public abstract Favourable createFavour();
}

//买二赠一   买一斤赠0.5斤
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


//单件 95折  全场95折
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

//满200减20  满10减1.5
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
