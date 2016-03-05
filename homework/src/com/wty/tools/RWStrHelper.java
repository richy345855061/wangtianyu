package com.wty.tools;

import java.util.*;
import java.util.Map.Entry;
import java.io.*;
import com.wty.domain.Product;

public class RWStrHelper {

	
	static public String[] readTxt(String fileName) {
		
		
		String[] ss = {};
		return ss;
	}
	
	static public Map<String, Integer> readBarData(String filename) {
		
				
		Map<String, Integer> proMap = new HashMap<String, Integer>();
		String encoding = "GBK";
		File file = new File("C:\\Users\\hhs\\Workspaces\\MyEclipse 10\\homework\\src\\data.txt");
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		if (file.isFile() && file.exists()) {
			
			try {
				isr = new InputStreamReader(new FileInputStream(file), encoding);
				
				br = new BufferedReader(isr);
				String lineTxt = "";
				while ((lineTxt = br.readLine()) != null) {
					
					//正则：  前面去掉   空格+’      后面去掉‘+空格 或 ’，+空格
					String s1 = lineTxt.replaceAll("^\\s*'|('\\s*$|',\\s*$)", "");
					String[] s2 = s1.split("-");
					if (s2.length == 1) {
						
						//proMap.put(key, value)
					}
					
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


		return proMap;
	}

	
	//通过条形码数组生成一个对应类的实例
	static public Vector<Product> creObjByBarcode(Map<String, Integer> proMap) {
		
		Vector<Product> proVec = new Vector<Product>();
		
		//通过条形码 生成对象
		String[] proStr = readTxt("######");

		for (Map.Entry<String, Integer> entry : proMap.entrySet()) {
			
			for (int i = 0; i < proStr.length; ++i) {
				
				String[] proObj = proStr[i].split("\\s+");
				
				//如果map的条形码和数据中的一样则创建对象
				if (entry.getKey().equals(proObj[proObj.length-1])) {
					
					for (int k = 0; k < entry.getValue(); ++k) {
						
						proVec.add(new Product(proObj[0], Float.parseFloat(proObj[1]), proObj[2], proObj[3], proObj[4]));
					}
				}
				
			}
		}
		return proVec;	
	}
}
