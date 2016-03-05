package com.wty.method;

abstract class Favourable {

//	protected int priority;     //遇到互斥时的优先级
	public abstract void favourSingle();
	public abstract void favourTtoal();
}

class FavourB2G1F extends Favourable {

//	public FavourB2G1F() {
//		
//		priority = 1;
//	}
	@Override
	public void favourSingle() {
		// TODO Auto-generated method stub
		
		//单件买2赠一
	}

	@Override
	public void favourTtoal() {
		// TODO Auto-generated method stub
		
	}
	
	
}

class Favour95Dis extends Favourable {

//	public Favour95Dis() {
//		
//		priority = 2;
//	}
	@Override
	public void favourSingle() {
		// TODO Auto-generated method stub
		//单件95折
	}

	@Override
	public void favourTtoal() {
		// TODO Auto-generated method stub
		
	}
	
	
}

class FavourO200M10 extends Favourable {

//	public FavourO200M10() {
//		
//		priority = 3;
//	}
	
	@Override
	public void favourSingle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void favourTtoal() {
		// TODO Auto-generated method stub
		
		//总体满200减10
	}
	
	
}
