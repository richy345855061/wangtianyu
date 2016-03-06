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
		
		//得到FavourStyle类集合
		Vector<FavourStyle> fsVec = RWStrHelper.creObjByCkb(strVec);
		
		//得到Product类集合
		Map<String, Integer> proMap = RWStrHelper.readBarData(filePath);
		Vector<Product> proVec = RWStrHelper.creObjByBarcode(proMap);
		
		//传递给类CreateStrategry 生成相应的Strategry
		CreateStrategry cs = new CreateStrategry(proVec, fsVec);
		
//		RWStrHelper.printProduct(proVec);
//		RWStrHelper.printFavour(fsVec);
		
		cs.resultCl();
		this.finalProInfo = cs.getFinalProInfo();
	}
	
	public String getFinalInfo() {
		
		//将返回的类制作成字符串返回给view
		//System.out.println(finalProInfo.size() + "返回的值");
		boolean bIsBuyGetFree = false; //是否显示下面的买2赠一
		Vector<Product> proBuyGetFree = new Vector<Product>();
		float totalAll = 0.0f;
		float favourMoneyAll = 0.0f;
		
		String finalInfo = "";
		finalInfo += "**<没钱赚商店>购物清单**\n";
		for (int i = 0; i < finalProInfo.size(); ++i) {
			
			Product p = finalProInfo.get(i);
		
			String s1 = "名称:" + p.getName() + "," +
						"数量:" + ((p.getNums() == (int)(p.getNums()))?(int)(p.getNums())+"":p.getNums()) + p.getStyle() + "," +
						"单价:" + new  DecimalFormat("##0.00").format(p.getPrice()) + "(元)," +
						"小计:" + new  DecimalFormat("##0.00").format(p.getTotal()) +"(元)";
			if (p.getBuyFree() > 0.0000001) {
				
				bIsBuyGetFree = true;
				proBuyGetFree.add(p);
			}
			
			String s2 = "";
			if (p.getFavourMoney() > 0.0000001) {
				
				s2 = ",节省" + new  DecimalFormat("##0.00").format(p.getFavourMoney()) + "(元)";
			}
			finalInfo += (s1 + s2 + "\n");
			totalAll += p.getTotal(); //总和
			favourMoneyAll += p.getFavourMoney();
		}

		if (bIsBuyGetFree) {
			
			finalInfo += "---------------------------\n买二赠一商品:\n";

			for (int i = 0; i < proBuyGetFree.size(); ++i) {
				
				Product p = proBuyGetFree.get(i);
				String ss = "名称:" + p.getName() + "," + "数量:" + ((p.getBuyFree() == (int)(p.getBuyFree()))?(int)(p.getBuyFree())+"":p.getBuyFree()) + p.getStyle() + "\n";
				finalInfo += ss;
			}
		}
		
		finalInfo += "---------------------------\n";
		finalInfo += "总计:" + new  DecimalFormat("##0.00").format(totalAll) + "(元)\n";
		
		if ((favourMoneyAll + Product.sAllOverFree) > 0.0000001) {
			
			finalInfo += "节省:" + new  DecimalFormat("##0.00").format(favourMoneyAll + Product.sAllOverFree) + "(元)\n";
		}
		finalInfo += "*******************************************************";
		
		
		//名称：****，数量：*瓶，单价：3.00（元），小计：6.00（元），节省0.55（元）
		//----------------------
		//买二赠一商品：
		//名称：可口可乐，数量：1瓶
		//名称：羽毛球，数量：1个
		//----------------------
		//总计：21.00（元）
		//节省：4.00（元）
		return finalInfo;
	}
	
}
