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
	//�����Ż�
	public abstract void favourSingle(Product p);
	//ȫ����Ʒ�Ż�
	public abstract void favourTtoal(Vector<Product> proVec);
}

class FavourB2G1F extends Favourable {

	public FavourB2G1F(FavourStyle fc) {
		
		this.favourConcrete = fc;
	}
	
	@Override
	public void favourSingle(Product p) {
		// TODO Auto-generated method stub
		
		//������2��һ  ��2����1��  
		
		String[] favStr = favourConcrete.getFavWeight().split("~");  // index 0 1 
		float buy = Float.parseFloat(favStr[0]);
		float free = Float.parseFloat(favStr[1]);
		float nums = p.getNums();
		
		
		//����Ǹ�������������������  ����2.5����0.5��
		float buyFree = (int)(nums*10) / (int)(buy*10) * free;
		
		//С��
		float total = nums * p.getPrice();
		
		p.setTotal(total);
		p.setBuyFree(buyFree);
		p.setNums(nums + buyFree);
//		System.out.println("�ܼ�" + total);
//		System.out.println("��" + buyFree);
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
		//����95��
		
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
		//�� ��ǰ����û�о����Ż� ���ܾ����Ż� ���԰�����
		float nums = p.getNums();
		float buyFree = p.getBuyFree();
		float price = p.getPrice();
		int flag = 0; //��ʾû����
		
		//float total = (nums - buyFree) * price; //��ֹǰ�澭���� ��  �ȼ�ȥ������
		float total = p.getTotal();
		//˵����Ʒǰ���Ѿ�����һ���Ż�
		if (total < 0.00000001) {
			
			total = (nums - buyFree) * price; //��ֹǰ�澭���� ��  �ȼ�ȥ������
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
		
		//������200��10
	}
	
	
}
