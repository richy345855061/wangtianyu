package com.wty.test;

import java.io.*;

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
		
		
			
		
		
		
		
		
		
		
		//String str = "可口可乐       3.0       BNGMF                    ITEM000001";
		//String str = "                   'ITEM000001',     ";
		String str2 = "                   'ITEM000001-2'     ";
		
		String sss = str2.replaceAll("^\\s*'|('\\s*$|',\\s*$)", "");
		String[] strs = sss.split("-");
		System.out.println(strs[1]);
		//System.out.println(sss.split(" ").length);
		
//		String[] strs = str.split("\\s+");  //正则表达式多个空格
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
