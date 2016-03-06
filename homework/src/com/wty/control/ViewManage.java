package com.wty.control;
import java.text.DecimalFormat;
import java.util.*;

import com.wty.domain.*;
import com.wty.method.*;
import com.wty.tools.RWStrHelper;


public class ViewManage {

	private String filePath;
	private Vector<String> strVec;
	private Vector<Product> finalProInfo;
	
	public ViewManage(String fp, Vector<String> sv) {
		
		this.filePath = fp;
		this.strVec = sv;
		
		//this.doPro();
	}
	
	public Vector<Product> getFinalProInfo() {
		return finalProInfo;
	}
	
	public void calProductList() {
		
		//�õ�FavourStyle�༯��
		Vector<FavourStyle> fsVec = RWStrHelper.creObjByCkb(strVec);
		
		//�õ�Product�༯��
		Map<String, Integer> proMap = RWStrHelper.readBarData(filePath);
		Vector<Product> proVec = RWStrHelper.creObjByBarcode(proMap);
		
		//���ݸ���CreateStrategry ������Ӧ��Strategry
		CreateStrategry cs = new CreateStrategry(proVec, fsVec);
		
//		RWStrHelper.printProduct(proVec);
//		RWStrHelper.printFavour(fsVec);
		
		cs.resultCl();
		this.finalProInfo = cs.getFinalProInfo();
	}
	
	public String getFinalInfo() {
		
		//�����ص����������ַ������ظ�view
		//System.out.println(finalProInfo.size() + "���ص�ֵ");
		boolean bIsBuyGetFree = false; //�Ƿ���ʾ�������2��һ
		Vector<Product> proBuyGetFree = new Vector<Product>();
		float totalAll = 0.0f;
		float favourMoneyAll = 0.0f;
		
		String finalInfo = "";
		finalInfo += "**<ûǮ׬�̵�>�����嵥**\n";
		for (int i = 0; i < finalProInfo.size(); ++i) {
			
			Product p = finalProInfo.get(i);
		
			String s1 = "����:" + p.getName() + "," +
						"����:" + ((p.getNums() == (int)(p.getNums()))?(int)(p.getNums())+"":p.getNums()) + p.getStyle() + "," +
						"����:" + new  DecimalFormat("##0.00").format(p.getPrice()) + "(Ԫ)," +
						"С��:" + new  DecimalFormat("##0.00").format(p.getTotal()) +"(Ԫ)";
			if (p.getBuyFree() > 0.0000001) {
				
				bIsBuyGetFree = true;
				proBuyGetFree.add(p);
			}
			
			String s2 = "";
			if (p.getFavourMoney() > 0.0000001) {
				
				s2 = ",��ʡ" + new  DecimalFormat("##0.00").format(p.getFavourMoney()) + "(Ԫ)";
			}
			finalInfo += (s1 + s2 + "\n");
			totalAll += p.getTotal(); //�ܺ�
			favourMoneyAll += p.getFavourMoney();
		}

		if (bIsBuyGetFree) {
			
			finalInfo += "---------------------------\n�����һ��Ʒ:\n";

			for (int i = 0; i < proBuyGetFree.size(); ++i) {
				
				Product p = proBuyGetFree.get(i);
				String ss = "����:" + p.getName() + "," + "����:" + ((p.getBuyFree() == (int)(p.getBuyFree()))?(int)(p.getBuyFree())+"":p.getBuyFree()) + p.getStyle() + "\n";
				finalInfo += ss;
			}
		}
		
		finalInfo += "---------------------------\n";
		finalInfo += "�ܼ�:" + new  DecimalFormat("##0.00").format(totalAll) + "(Ԫ)\n";
		
		if ((favourMoneyAll + Product.sAllOverFree) > 0.0000001) {
			
			finalInfo += "��ʡ:" + new  DecimalFormat("##0.00").format(favourMoneyAll + Product.sAllOverFree) + "(Ԫ)\n";
		}
		finalInfo += "*******************************************************";
		
		
		//���ƣ�****��������*ƿ�����ۣ�3.00��Ԫ����С�ƣ�6.00��Ԫ������ʡ0.55��Ԫ��
		//----------------------
		//�����һ��Ʒ��
		//���ƣ��ɿڿ��֣�������1ƿ
		//���ƣ���ë��������1��
		//----------------------
		//�ܼƣ�21.00��Ԫ��
		//��ʡ��4.00��Ԫ��
		return finalInfo;
	}
	
}
