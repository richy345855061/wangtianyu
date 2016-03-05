package com.wty.tools;

import java.util.*;
import java.util.Map.Entry;
import java.io.*;

import com.wty.domain.FavourStyle;
import com.wty.domain.Product;

public class RWStrHelper {

	
	static public Vector<String> readTxt(String filePath) {
		
		
		Vector<String> strVec = new Vector<String>();
		String encoding = "GBK";
		File file = new File(filePath);
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		if (file.isFile() && file.exists()) {
			
			try {
				isr = new InputStreamReader(new FileInputStream(file), encoding);
				
				br = new BufferedReader(isr);
				String lineTxt = "";
				while ((lineTxt = br.readLine()) != null) {
					
					strVec.add(lineTxt);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					isr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		return strVec;
	}
	
	
	static public String getAllData(String filePath) {
		
		Vector<String> strVec = readTxt(filePath);
		
		String str = "";
		for (int i = 0; i < strVec.size(); ++i) {
			
			str += (strVec.get(i) + "\n");
		}
		
		return str;
	}
	
	static public Map<String, Integer> readBarData(String filePath) {
		
		//LinkedHashMap 按输入顺序存储
		Map<String, Integer> proMap = new LinkedHashMap<String, Integer>();
		
		Vector<String> strVec = readTxt(filePath);

		for (int i = 0; i < strVec.size(); ++i) {
			
			String lineTxt = strVec.get(i); 
			//正则：  前面去掉   空格+’      后面去掉‘+空格 或 ’，+空格
			String s1 = lineTxt.replaceAll("^\\s*'|('\\s*$|',\\s*$)", "");
			
			if (s1.length() < 5) {
				
				continue;
			}
			String[] s2 = s1.split("-");
			
			if (proMap.get(s2[0]) == null) {
				
				if (s2.length == 1) {
					
					proMap.put(s2[0], 1);
				}
				else if (s2.length == 2) {
					
					proMap.put(s2[0], Integer.parseInt(s2[1]));
				}
			}
			else {
				
				if (s2.length == 1) {
					
					proMap.put(s2[0], proMap.get(s2[0])+1);
				} 
				else if (s2.length == 2) {
					
					proMap.put(s2[0], proMap.get(s2[0])+Integer.parseInt(s2[1]));
				}
			}
		}

		return proMap;
	}

	//通过界面选择的优惠方式封闭成类
	static public Vector<FavourStyle> creObjByCkb(Vector<String> strVec) {
		//S-买N赠M-2-1            现在是   买赠-单件-2~1-2-1
						//    //买赠-范围-优惠程度-优先级-更高优先级
		Vector<FavourStyle> fsVec = new Vector<FavourStyle>();
		
		Vector<String> fsStrVec = readTxt("favour.txt");
		
		for (int i = 0; i < strVec.size(); ++i) {
			
			String strTemp = strVec.get(i);
			String[] fsObj1 = strTemp.split("-");   //买赠-范围-优惠程度-优先级-更高优先级
			
			for (int j = 0; j < fsStrVec.size(); ++j) {
				
				//折扣名字       编号                  享受优惠商品条形码
				String[] fsObj2 = fsStrVec.get(j).split("\\s+");
				
				if (fsObj1[0].equals(fsObj2[0])) {

					fsVec.add(new FavourStyle(fsObj1[0],
							fsObj1[1], 
							Integer.parseInt(fsObj2[1]), 
							fsObj1[2], 
							Integer.parseInt(fsObj1[3]),
							Integer.parseInt(fsObj1[4]),
							fsObj2[2]));
				}
			}
			
		}
		return fsVec;
	}
	
	//通过条形码数组生成一个对应类的实例
	static public Vector<Product> creObjByBarcode(Map<String, Integer> proMap) {
		
		Vector<Product> proVec = new Vector<Product>();
		
		//通过条形码 生成对象
		Vector<String> strVec = readTxt("product.txt");

		for (Map.Entry<String, Integer> entry : proMap.entrySet()) {
			
			 System.out.println("!!!" + entry.getKey());
			for (int i = 0; i < strVec.size(); ++i) {
				
				String[] proObj = strVec.get(i).split("\\s+");
				
				//如果map的条形码和数据中的一样则创建对象
				if (entry.getKey().equals(proObj[proObj.length-1])) {
						
					proVec.add(new Product(proObj[0], Float.parseFloat(proObj[1]), 
							entry.getValue(), proObj[2], proObj[3]));
				}
				
			}
		}
		return proVec;	
	}
	
	static public void printProduct(Vector<Product> proVec) {
		
		
		for (int i = 0; i < proVec.size(); ++i) {
			
			Product p = proVec.get(i);
			System.out.println(p.getName() + "-" +
					           p.getNums() + "-" +
					           p.getPrice() + "-" +
					           p.getStyle() + "-" +
					           p.getBarcode() + "-" +
					           p.getTotal() + "-" +
					           p.getFavourMoney() + "-" +
					           p.getBuyFree());
		}
	}
	
	static public void printFavour(Vector<FavourStyle> favVec) {
		
		for (int i = 0; i < favVec.size(); ++i) {
			
			FavourStyle p = favVec.get(i);
			System.out.println(p.getScope() + "-" +
					           p.getName() + "-" +
					           p.getId() + "-" +
					           p.getPriority() + "-" +
					           p.getMorePriority() + "-" +
					           p.getFavWeight() + "-" +
					           p.getFavProducts());
		}
	}
}
