package com.wty.domain;

//产品类
public class Product {

	
	private String name;
	private float nums;
	private float price;
	private String style;
	private String barcode;
	private float total;         //小计
	private float favourMoney;   //优惠可能没有  用String类型 可设置为 " " 则不可见
	private float buyFree;       //买赠数量    因为可能是斤 所以用float
	
	public Product(String name, float price, float nums, String style, 
								String barcode) {
		
		
		this.name = name;                       //名字
		this.price = price;                     //单价
		this.nums = nums;                       //数量
		this.style = style;                     //单位类型
		this.barcode = barcode;                 //条形码
		this.total = 0.0f;                      //小计
		this.favourMoney = 0.0f;                //节省
		this.buyFree = 0.0f;                    //赠
	}
	
	public float getBuyFree() {
		return buyFree;
	}

	public void setBuyFree(float buyFree) {
		this.buyFree = buyFree;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getFavourMoney() {
		return favourMoney;
	}

	public void setFavourMoney(float favourMoney) {
		this.favourMoney = favourMoney;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getNums() {
		return nums;
	}
	public void setNums(float nums) {
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
	
	//当不享受任何优惠的时候调用自身的计算方法
	public void getResultByself() {
		
		this.total = this.price * this.nums;
	}
}
