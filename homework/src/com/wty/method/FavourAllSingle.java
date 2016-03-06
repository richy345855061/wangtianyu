package com.wty.method;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;


import com.wty.domain.FavourStyle;
import com.wty.domain.Product;

public class FavourAllSingle extends Strategry {

	@Override
	public void getResult(Vector<Product> prods, Vector<Favourable> faVec) {
		// TODO Auto-generated method stub
		
		//�õ�ÿ����Ʒ������Ż�
		Map<Product, Vector<Favourable>> mapPro = this.getProSelfFavour(prods, faVec);
		finalProInfo = new Vector<Product>();
				
		for (int j = 0; j < prods.size(); ++j) {
			
			//����һ��
			Product p = prods.get(j);
			Vector<Favourable> favv = mapPro.get(p);
			
			//��Ʒ�������κ��Ż�    ���߳��в��ṩ�κ��Ż�
//			if (favv.size() == 0) {
//				
//				p.getResultByself(); //�����Լ��ķ���
//			}
			
			favv = filterFavourByPriority(favv);
			
//			System.out.println(p.getName() + "-" +
//			p.getNums() + "-" +
//			p.getPrice() + "-" +
//			p.getStyle() + "-" +
//			p.getBarcode() + "-" +
//			p.getBuyFree() + "-" +
//			p.getTotal() + "-" +
//			p.getFavourMoney());
			
			if (favv.size() > 0) {
				
				for (int i = 0; i < favv.size(); ++i) {
					
					Favourable f = favv.get(i);
					//System.out.println(f.getFavourConcrete().getName());
					f.favourSingle(p);
				}
			}
			else {
				
				//���һ���Żݶ�������
				p.getResultByself();
			}
			
			
			
//			System.out.println(p.getName() + "-" +
//			p.getNums() + "-" +
//			p.getPrice() + "-" +
//			p.getStyle() + "-" +
//			p.getBarcode() + "-" +
//			p.getBuyFree() + "-" +
//			p.getTotal() + "-" +
//			p.getFavourMoney());
			
			finalProInfo.add(p);
		}
	}	
}
//
//
//
//System.out.println(p.getName() + "-" +
//		p.getNums() + "-" +
//		p.getPrice() + "-" +
//		p.getStyle() + "-" +
//		p.getBarcode() + "-" +
//		p.getBuyFree() + "-" +
//		p.getTotal() + "-" +
//		p.getFavourMoney());