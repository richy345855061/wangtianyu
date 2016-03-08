package com.wty.method;
import java.util.*;

import com.wty.domain.*;

public class FavourContext {

	private Vector<Favourable> faVec;
	private Vector<Product> products;
	private Vector<FavourStyle> favs;
	private Strategry strategry;
	private OutputList outputList;
	
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

			switch (nType) {
			case 1://��2��һ
				fa = new FactoryBuyForFree(fs).createFavour();
				break;
				
			case 2://95%
				fa = new FactoryDiscount(fs).createFavour();
				break;
				
			case 3://��200��100
				fa = new FactoryOverMinus(fs).createFavour();
				break;

			default:
				break;
			}
			
			faVec.add(fa);  //������Ϊ���
		}
	}
	
	public OutputList getOutputList() {
		return outputList;
	}

	public Vector<Favourable> getFaVec() {
		
		return faVec;
	}
	public void getResult() {
		
		//��ÿ����Ʒ�����жϴ���
		//����������
		//�ɿڿ���
		Product.sAllOverFree = 0.0f;
		strategry.getResult(products, faVec);
		this.outputList = strategry.getOutputList();		
	}
	
}
