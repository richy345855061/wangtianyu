package com.wty.method;

import java.util.Vector;

import com.wty.domain.FavourStyle;
import com.wty.domain.Product;

public class FavourOverMinus extends Favourable {

	public FavourOverMinus(FavourStyle fc) {
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
		//˵����Ʒǰ��û�о���һ���Ż�
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
			//��������û��
			//Product.sAllOverFree += minus;
		}
		
	}

	@Override
	public void favourTotal(Vector<Product> proVec) {
		// TODO Auto-generated method stub
		
		//������200��10
		//���ֱ��ȫ������ ������ȵõ����в�Ʒ���Ե�С��
		if (proVec.size() > 0 && proVec.get(0).getTotal() < 0.0000001) {
			
			for (int i = 0; i < proVec.size(); ++i) {
				
				proVec.get(i).getResultByself();
			}
		}
		
		String[] favStr = favourConcrete.getFavWeight().split("~");
		float over = Float.parseFloat(favStr[0]);
		float minus = Float.parseFloat(favStr[1]);
		
		float allTotal = 0.0f;
		for (int i = 0; i < proVec.size(); ++i) {
			
			Product p = proVec.get(i);
			allTotal += p.getTotal();
		}
		
		if (allTotal - over > 0.0000001) {
			
			Product.sAllOverFree = minus;
		}
	}
}
