package com.wty.method;
import java.util.*;

import com.wty.domain.*;

public class FavourContext {

	private Vector<Favourable> faVec;
	private Vector<Product> products;
	private Vector<FavourStyle> favs;
	private Strategry strategry;
	private Vector<Product> finalProInfo;
	
	public FavourContext(Vector<Product> prods, Vector<FavourStyle> fas, Strategry sg) {
		
		this.products = prods;
		this.strategry = sg;
		this.favs = fas;
		Favourable fa = null;
		faVec = new Vector<Favourable>();
		
		for (int i = 0; i < favs.size(); ++i) {
			fa = null;
			
			FavourStyle fs = favs.get(i);
			int nType = fs.getId();
			
			//�Ż�����
//			String[] favStr = fs.getFavWeight().split("-");
			//[0]��ע�ǵ�������ȫ��   [1]��ע�������Ż�
//          String[] favours = {"S-��N��M-2-1", "T-��N��M-100-10"};
			switch (nType) {
			case 1://��2��һ
				fa = new FactoryB2G1F(fs).createFavour();
				break;
				
			case 2://95%
				fa = new Factory95Dis(fs).createFavour();
				break;
				
			case 3://��200��100
				fa = new FactoryO200M10(fs).createFavour();
				break;

			default:
				break;
			}
			
			faVec.add(fa);  //������Ϊ���
		}
	}
	
	public Vector<Product> getFinalProInfo() {
		return finalProInfo;
	}

	public void getResult() {
		
		//��ÿ����Ʒ�����жϴ���
		//����������
		//�ɿڿ���
		
		strategry.getResult(products, faVec);
		this.finalProInfo = strategry.getFinalProInfo();		
	}
	
}
