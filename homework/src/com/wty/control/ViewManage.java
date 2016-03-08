package com.wty.control;
import java.text.DecimalFormat;
import java.util.*;

import com.wty.domain.*;
import com.wty.method.*;
import com.wty.tools.RWStrHelper;


public class ViewManage {

	private String filePath;
	private Vector<String> strVec;
	private OutputList outputList;
	
	public ViewManage(String fp, Vector<String> sv) {
		
		this.filePath = fp;
		this.strVec = sv;
		
		//this.doPro();
	}
	
	public OutputList getOutputList() {
		return outputList;
	}
	
	public void calProductList() {
		
		//�õ�FavourStyle�༯��
		Vector<FavourStyle> fsVec = RWStrHelper.creObjByCkb(strVec);
		
		//�õ�Product�༯��
		Map<String, Integer> proMap = RWStrHelper.readBarData(filePath);
		Vector<Product> proVec = RWStrHelper.creObjByBarcode(proMap);
		
		//���ݸ���CreateStrategry ������Ӧ��Strategry
		CreateStrategry cs = new CreateStrategry(proVec, fsVec);
		
		cs.resultCl();
		this.outputList = cs.getOutputList();
	}
	
	public String getFinalInfo() {
		
		Vector<Product> finalProInfo = outputList.getProVec();
		//�����ص����������ַ������ظ�view
		Vector<Product> proBuyGetFree = new Vector<Product>();
		
		String finalInfo = "";
		finalInfo += "**<ûǮ׬�̵�>�����嵥**\n";
		for (int i = 0; i < finalProInfo.size(); ++i) {
			
			Product p = finalProInfo.get(i);
		
			String s1 = "����:" + p.getName() + "," +
						"����:" + ((p.getNums() == (int)(p.getNums()))?(int)(p.getNums())+"":p.getNums()) + p.getStyle() + "," +
						"����:" + new  DecimalFormat("##0.00").format(p.getPrice()) + "(Ԫ)," +
						"С��:" + new  DecimalFormat("##0.00").format(p.getTotal()) +"(Ԫ)";
			if (p.getBuyFree() > 0.0000001) {
				
				proBuyGetFree.add(p);
			}
			
			String s2 = "";
			if (p.getFavourMoney() > 0.0000001) {
				
				s2 = ",��ʡ" + new  DecimalFormat("##0.00").format(p.getFavourMoney()) + "(Ԫ)";
			}
			finalInfo += (s1 + s2 + "\n");
		}

		if (outputList.isExistBuyGetFree()) {
			
			finalInfo += "---------------------------\n�����һ��Ʒ:\n";

			for (int i = 0; i < proBuyGetFree.size(); ++i) {
				
				Product p = proBuyGetFree.get(i);
				String ss = "����:" + p.getName() + "," + "����:" + ((p.getBuyFree() == (int)(p.getBuyFree()))?(int)(p.getBuyFree())+"":p.getBuyFree()) + p.getStyle() + "\n";
				finalInfo += ss;
			}
		}
		
		finalInfo += "---------------------------\n";
		finalInfo += "�ܼ�:" + new  DecimalFormat("##0.00").format(outputList.getAllTotal()) + "(Ԫ)\n";
		
		if (outputList.getAllFavourMoney() + Product.sAllOverFree > 0.0000001) {
			
			finalInfo += "��ʡ:" + new  DecimalFormat("##0.00").format(outputList.getAllFavourMoney() + Product.sAllOverFree) + "(Ԫ)\n";
		}
		finalInfo += "*******************************************************";

		return finalInfo;
	}
	
}
