package com.wty.method;
import java.util.*;

import com.wty.domain.*;
import com.wty.method.*;


public class CreateStrategry {

	//�ӽ�����յ���Ʒ���� �����Żݼ���
	private Vector<Product> products;
	private Vector<FavourStyle> favours;  //��Ϣ����ʽ���磺"�ۿ�-����-95-2-1"
							 		      //�Ż�����-�Żݷ�Χ-�Ż�����-���ȼ�-�������ȼ�
	private Strategry strategry;
	private OutputList outputList;
	
	public CreateStrategry(Vector<Product> prods, Vector<FavourStyle> favs) {
		
		this.products = prods;
		this.favours = favs;
		strategry = null;
	}
	
	public Strategry getStrategry() {
		return strategry;
	}

	public void setStrategry(Strategry strategry) {
		this.strategry = strategry;
	}

	public Vector<Product> getProducts() {
		return products;
	}
	
	public Vector<FavourStyle> getFavour() {
		
		return favours;
	}
	
	public OutputList getOutputList() {
		return outputList;
	}
	
	public void judegtStyle() {
		
		int size = favours.size();
		int nS = 0;
		int nT = 0;
		for (int i = 0; i < size; ++i) {
			String str = favours.get(i).getScope();
			if("����".equals(str)) {
				
				nS++;
			}
			else if ("ȫ��".equals(str)) {
				
				nT++;
			}
		}
		
		if (nS == size && 0 == nT && size != 0) {
			
			strategry = new FavourAllSingle();
		}
		else if (nT == size && 0 == nS && size != 0) {
			
			strategry = new FavourAllTotal();
		}
		else if (size == 0) {
			
			strategry = new FavourNoSingleTotal();
		}
		else {
			
			strategry = new FavourSingleTotal();
		}
	}
	
	public void resultCl() {
		
		//�ж��Żݵ�������
		judegtStyle();
		
		//����Context ͨ����Ӧ�ĺ�����������
		FavourContext fc = new FavourContext(products, favours, strategry);
		fc.getResult();
		this.outputList = fc.getOutputList();
	}
}
