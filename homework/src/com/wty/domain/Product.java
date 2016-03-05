package com.wty.domain;

//产品类
public class Product {

	
	private String name;
	private int nums;
	private float price;
	private String style;
	private String barcode;
	private String favourStyle;  //享受所有折扣类型
	
	public Product(String name, float price, String style, String favourStyle, String barcode) {
		
		
	}
	
	
	public String getFavourStyle() {
		return favourStyle;
	}
	public void setFavourStyle(String favourStyle) {
		this.favourStyle = favourStyle;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	
}
