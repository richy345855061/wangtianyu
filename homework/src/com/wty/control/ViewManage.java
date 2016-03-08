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
		
		//得到FavourStyle类集合
		Vector<FavourStyle> fsVec = RWStrHelper.creObjByCkb(strVec);
		
		//得到Product类集合
		Map<String, Integer> proMap = RWStrHelper.readBarData(filePath);
		Vector<Product> proVec = RWStrHelper.creObjByBarcode(proMap);
		
		//传递给类CreateStrategry 生成相应的Strategry
		CreateStrategry cs = new CreateStrategry(proVec, fsVec);
		
		cs.resultCl();
		this.outputList = cs.getOutputList();
	}
	
	public String getFinalInfo() {
		
		Vector<Product> finalProInfo = outputList.getProVec();
		//将返回的类制作成字符串返回给view
		Vector<Product> proBuyGetFree = new Vector<Product>();
		
		String finalInfo = "";
		finalInfo += "**<没钱赚商店>购物清单**\n";
		for (int i = 0; i < finalProInfo.size(); ++i) {
			
			Product p = finalProInfo.get(i);
		
			String s1 = "名称:" + p.getName() + "," +
						"数量:" + ((p.getNums() == (int)(p.getNums()))?(int)(p.getNums())+"":p.getNums()) + p.getStyle() + "," +
						"单价:" + new  DecimalFormat("##0.00").format(p.getPrice()) + "(元)," +
						"小计:" + new  DecimalFormat("##0.00").format(p.getTotal()) +"(元)";
			if (p.getBuyFree() > 0.0000001) {
				
				proBuyGetFree.add(p);
			}
			
			String s2 = "";
			if (p.getFavourMoney() > 0.0000001) {
				
				s2 = ",节省" + new  DecimalFormat("##0.00").format(p.getFavourMoney()) + "(元)";
			}
			finalInfo += (s1 + s2 + "\n");
		}

		if (outputList.isExistBuyGetFree()) {
			
			finalInfo += "---------------------------\n买二赠一商品:\n";

			for (int i = 0; i < proBuyGetFree.size(); ++i) {
				
				Product p = proBuyGetFree.get(i);
				String ss = "名称:" + p.getName() + "," + "数量:" + ((p.getBuyFree() == (int)(p.getBuyFree()))?(int)(p.getBuyFree())+"":p.getBuyFree()) + p.getStyle() + "\n";
				finalInfo += ss;
			}
		}
		
		finalInfo += "---------------------------\n";
		finalInfo += "总计:" + new  DecimalFormat("##0.00").format(outputList.getAllTotal()) + "(元)\n";
		
		if (outputList.getAllFavourMoney() + Product.sAllOverFree > 0.0000001) {
			
			finalInfo += "节省:" + new  DecimalFormat("##0.00").format(outputList.getAllFavourMoney() + Product.sAllOverFree) + "(元)\n";
		}
		finalInfo += "*******************************************************";

		return finalInfo;
	}
	
}
