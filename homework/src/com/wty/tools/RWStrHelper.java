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
		
		//LinkedHashMap ������˳��洢
		Map<String, Integer> proMap = new LinkedHashMap<String, Integer>();
		
		Vector<String> strVec = readTxt(filePath);

		for (int i = 0; i < strVec.size(); ++i) {
			
			String lineTxt = strVec.get(i); 
			//����  ǰ��ȥ��   �ո�+��      ����ȥ����+�ո� �� ����+�ո�
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

	//ͨ������ѡ����Żݷ�ʽ��ճ���
	static public Vector<FavourStyle> creObjByCkb(Vector<String> strVec) {
		//S-��N��M-2-1            ������   ����-����-2~1-2-1
						//    //����-��Χ-�Żݳ̶�-���ȼ�-�������ȼ�
		Vector<FavourStyle> fsVec = new Vector<FavourStyle>();
		
		Vector<String> fsStrVec = readTxt("favour.txt");
		
		for (int i = 0; i < strVec.size(); ++i) {
			
			String strTemp = strVec.get(i);
			String[] fsObj1 = strTemp.split("-");   //����-��Χ-�Żݳ̶�-���ȼ�-�������ȼ�
			
			for (int j = 0; j < fsStrVec.size(); ++j) {
				
				//�ۿ�����       ���                  �����Ż���Ʒ������
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
	
	//ͨ����������������һ����Ӧ���ʵ��
	static public Vector<Product> creObjByBarcode(Map<String, Integer> proMap) {
		
		Vector<Product> proVec = new Vector<Product>();
		
		//ͨ�������� ���ɶ���
		Vector<String> strVec = readTxt("product.txt");

		for (Map.Entry<String, Integer> entry : proMap.entrySet()) {
			
			 System.out.println("!!!" + entry.getKey());
			for (int i = 0; i < strVec.size(); ++i) {
				
				String[] proObj = strVec.get(i).split("\\s+");
				
				//���map��������������е�һ���򴴽�����
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
