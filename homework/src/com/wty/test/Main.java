package com.wty.test;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Vector;

import com.wty.domain.Product;
import com.wty.tools.RWStrHelper;
import com.wty.view.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String encoding = "GBK";
//		File file = new File("C:\\Users\\hhs\\Workspaces\\MyEclipse 10\\homework\\src\\data.txt");
//		InputStreamReader isr = null;
//		BufferedReader br = null;
//		
//		if (file.isFile() && file.exists()) {
//			
//			try {
//				isr = new InputStreamReader(new FileInputStream(file), encoding);
//				
//				br = new BufferedReader(isr);
//				String lineTxt = "";
//				while ((lineTxt = br.readLine()) != null) {
//					
//					System.out.println(lineTxt);
//				}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} finally {
//				
//				try {
//					br.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				try {
//					isr.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
		
		
			
//		Map<String, Integer> maps = RWStrHelper.readBarData("data.txt");
//		System.out.println(maps);
//		Vector<Product> proVec = RWStrHelper.creObjByBarcode(maps);
//		
//		for (int i = 0; i < proVec.size(); ++i) {
//			
//			Product p = proVec.get(i);
//			System.out.println(p.getName() + "  " + p.getPrice() + "  " + p.getNums() + "  "
//						+ p.getFavourStyle() + "  " + p.getBarcode());
//			
//		}
		
		//new View2();
		Map<String, String> mapp = new LinkedHashMap<String, String>();
		mapp.put("0ITEM000001", "1");
		mapp.put("2ITEM000002", "1");
		mapp.put("5ITEM000003", "1");
		mapp.put("1ITEM000004", "1");
		mapp.put("4ITEM000005", "1");
		
		for (Entry<String, String> entry : mapp.entrySet()) {
			
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
//		for (int i = 0; i < a.length; ++i) {
//			
//			System.out.println(a[i]); 
//		}
		
		//		float f = 2.5f;
//		if ((int)f == f) {
//			
//			System.out.println("haha1");
//		}
//		else {
//			
//			System.out.println("haha2");
//		}
		
//		test1 t1 = new test1("haha");
//		t1 = new tt().f(t1);
//		
//		System.out.println(t1.getName() + "  " + t1.getAge());
		
		
		
		
		//String str = "�ɿڿ���       3.0       BNGMF                    ITEM000001";
		//String str = "                   'ITEM000001',     ";
//		String str2 = "                   'ITEM000001-2'     ";
//		
//		String sss = str2.replaceAll("^\\s*'|('\\s*$|',\\s*$)", "");
//		String[] strs = sss.split("-");
//		System.out.println(strs[1]);
		//System.out.println(sss.split(" ").length);
		
//		String[] strs = str.split("\\s+");  //������ʽ����ո�
//		for (int i = 0; i < strs.length; ++i) {
//			
//			String ss = strs[i];
//			ss.replaceAll("\\s+", "");
//			System.out.println(ss);
//		}
		
//		Map<Integer, Integer> mapp = new HashMap<Integer, Integer>();
//		
//		mapp.put(1, 2);
//		mapp.put(2, 20);
//		
//		int[] nn = {1, 1, 2, 2, 2};
//		for (int i = 0; i < nn.length; ++i) {
//			
//			mapp.put(nn[i], mapp.get(nn[i]) + 1);
//		}
		
//		for (Map.Entry<Integer, Integer> entry : mapp.entrySet()) {
//			
//			System.out.println(entry.getKey() + "   " + entry.getValue());
//		}
	}

}
