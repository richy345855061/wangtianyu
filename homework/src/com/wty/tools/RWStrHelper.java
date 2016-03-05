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
					
					//����  ǰ��ȥ��   �ո�+��      ����ȥ����+�ո� �� ����+�ո�
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

	
	//ͨ����������������һ����Ӧ���ʵ��
	static public Vector<Product> creObjByBarcode(Map<String, Integer> proMap) {
		
		Vector<Product> proVec = new Vector<Product>();
		
		//ͨ�������� ���ɶ���
		String[] proStr = readTxt("######");

		for (Map.Entry<String, Integer> entry : proMap.entrySet()) {
			
			for (int i = 0; i < proStr.length; ++i) {
				
				String[] proObj = proStr[i].split("\\s+");
				
				//���map��������������е�һ���򴴽�����
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
