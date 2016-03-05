package com.wty.method;

//����
abstract class Factory {

	protected String favourConcrete;  //��������2��һ������3��һ
	public abstract Favourable createFavour();
}

class FactoryB2G1F extends Factory {

	public FactoryB2G1F(String favs) {
		
		this.favourConcrete = favs;
	}
	
	@Override
	public Favourable createFavour() {
		// TODO Auto-generated method stub
		
		return new FavourB2G1F();
	}
	
	
}

class Factory95Dis extends Factory {

	public Factory95Dis(String favs) {
		
		this.favourConcrete = favs;
	}
	
	@Override
	public Favourable createFavour() {
		// TODO Auto-generated method stub
		return new Favour95Dis();
	}
	
	
}

class FactoryO200M10 extends Factory {
	
	public FactoryO200M10(String favs) {
		
		this.favourConcrete = favs;
	}
	
	@Override
	public Favourable createFavour() {
		// TODO Auto-generated method stub
		return new FavourO200M10();
	}
	
	
}
