package com.wty.control;
import java.util.*;
import com.wty.domain.*;
import com.wty.method.*;


public class ViewCl {

	//�ӽ�����յ���Ʒ���� �����Żݼ���
	private Vector<Product> products;
	private String[] favours;  //��Ϣ����ʽ���磺"S-BNGMF-2-1"������-����-2-1��
							   //			 "S-DISNM-95"������-�ۿ�-95��     "T-ONMM-100-10"��ȫ��-����-100-10��
					           //            String[] favours = {"S-BNGMF-2-1", "T-ONMM-100-10"};
	private Strategry strategry;
	private int nStyle;
	
	public ViewCl(Vector<Product> prods, String[] favs) {
		
		this.products = prods;
		this.favours = favs;
		nStyle = 0;
	}

	public Vector<Product> getProducts() {
		return products;
	}
	
	public String[] getFavour() {
		
		return favours;
	}
	
	private void judegtStyle() {
		
		int size = favours.length;
		int nS = 0;
		int nT = 0;
		for (int i = 0; i < size; ++i) {
			String[] str = favours[i].split("-");
			if("S".equals(str[0])) {
				
				nS++;
			}
			else if ("T".equals(str[0])) {
				
				nT++;
			}
		}
		
		if (nS == size && 0 == nT) {
			
			strategry = new FavourAllSingle();
		}
		else if (nT == size && 0 == nS) {
			
			strategry = new FavourAllTotal();
		}
		else {
			
			strategry = new FavourSingleTotal();
		}
	}
	
	
	public void resultCl() {
		
		judegtStyle();
		
		FavourContext fc = new FavourContext(products, favours, strategry);
		fc.getResult();
		
	}
}
