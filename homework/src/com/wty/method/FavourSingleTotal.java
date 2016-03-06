package com.wty.method;

import java.util.Map;
import java.util.Vector;

import com.wty.domain.FavourStyle;
import com.wty.domain.Product;

public class FavourSingleTotal extends Strategry {

	//ͨ����Χ�õ���Ӧ��vector
	public Vector<Favourable> getVecByScope(Vector<Favourable> faVec, String scope) {
		
		Vector<Favourable> resVec = new Vector<Favourable>();
		
		for (int i = 0; i < faVec.size(); ++i) {
			
			Favourable f = faVec.get(i);
			if (scope.equals(f.getFavourConcrete().getScope())) {
				
				resVec.add(f);
			}
		}
		return resVec;
	}
	
	@Override
	public void getResult(Vector<Product> prods, Vector<Favourable> faVec) {
		// TODO Auto-generated method stub
		
		finalProInfo = new Vector<Product>();
		System.out.println("s-t");
		
		//�Ȱ�ȫ�͵��ֿ�
		Vector<Favourable> sVec = new Vector<Favourable>();
		sVec = this.getVecByScope(faVec, "����");
		Vector<Favourable> tVec = new Vector<Favourable>();
		tVec = this.getVecByScope(faVec, "ȫ��");

				
		//�ȴ�����
		Map<Product, Vector<Favourable>> mapPro = this.getProSelfFavour(prods, sVec);
				
		for (int j = 0; j < prods.size(); ++j) {
			

			//����һ��
			Product p = prods.get(j);
			Vector<Favourable> favv = mapPro.get(p);
			//System.out.println("��һ����С" + favv.size() + p.getName());
			//�������е�ȫ��
			favv.addAll(tVec);
//			//ͨ�����ȹ���			
			System.out.println(favv.size() + "qian");
			favv = filterFavourByPriority(favv);
			System.out.println(favv.size() + "hou");
//			//�ٴ�ȥ�������ȫ�����Ż�
			tVec = this.getVecByScope(favv, "ȫ��");
			favv = this.getVecByScope(favv, "����");
			System.out.println(tVec.size() + " " + favv.size());
			
//			
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
		}
//		
//		//ȫ��
//		//tVec = filterFavourByPriority(tVec);
//		
		for (int i = 0; i < tVec.size(); ++i) {
			
			Favourable f = tVec.get(i);
			f.favourTtoal(prods);
		}
		
		finalProInfo = prods;
		
	}
	
}

