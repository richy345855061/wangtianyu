package com.wty.method;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import com.wty.domain.FavourStyle;
import com.wty.domain.Product;

public class FavourAllSingle extends Strategry {

	@Override
	public void getResult(Vector<Product> prods, Vector<Favourable> faVec) {
		// TODO Auto-generated method stub
		
		//�õ�ÿ����Ʒ������Ż�
		Map<Product, Vector<Favourable>> mapPro = this.getProSelfFavour(prods, faVec);
		for (int j = 0; j < prods.size(); ++j) {
			
			//����һ��
			Product p = prods.get(j);
			//System.out.println(p.getName());
			Vector<Favourable> favv = mapPro.get(p);
			
			favv = filterFavourByPriority(favv);
			
			System.out.println("��"+ (j + 1) + "����Ʒ:");
			System.out.println(p.getName() + "-" +
					p.getNums() + "-" +
					p.getPrice() + "-" +
					p.getStyle() + "-" +
					p.getBarcode() + "-" +
					p.getBuyFree() + "-" +
					p.getTotal() + "-" +
					p.getFavourMoney());
			
			for (int i = 0; i < favv.size(); ++i) {
				
				Favourable f = favv.get(i);
				System.out.println(f.getFavourConcrete().getName());
				f.favourSingle(p);
			}
			
			
			System.out.println(p.getName() + "-" +
					p.getNums() + "-" +
					p.getPrice() + "-" +
					p.getStyle() + "-" +
					p.getBarcode() + "-" +
					p.getBuyFree() + "-" +
					p.getTotal() + "-" +
					p.getFavourMoney());
		}
		
	}	
}