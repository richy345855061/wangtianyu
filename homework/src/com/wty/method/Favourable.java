package com.wty.method;

abstract class Favourable {

//	protected int priority;     //��������ʱ�����ȼ�
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
		
		//������2��һ
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
		//����95��
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
		
		//������200��10
	}
	
	
}
