package com.wty.domain;

//产品类
public class Product {

	
	private String name;
	private int nums;
	private float price;
	private String style;
	private String barcode;
	private String favourStyle;  //享受所有折扣类型
	
	public Product(String name, float price, int nums, String style, String favourStyle, String barcode) {
		
		
		this.name = name;
		this.price = price;
		this.nums = nums;
		this.style = style;
		this.favourStyle = favourStyle;
		this.barcode = barcode;
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
