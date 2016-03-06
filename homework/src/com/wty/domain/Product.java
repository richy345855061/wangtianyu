package com.wty.domain;

//��Ʒ��
public class Product {

	
	private String name;
	private float nums;
	private float price;
	private String style;
	private String barcode;
	private float total;         //С��
	private float favourMoney;   //�Żݿ���û��  ��String���� ������Ϊ " " �򲻿ɼ�
	private float buyFree;       //��������    ��Ϊ�����ǽ� ������float
	
	public Product(String name, float price, float nums, String style, 
								String barcode) {
		
		
		this.name = name;                       //����
		this.price = price;                     //����
		this.nums = nums;                       //����
		this.style = style;                     //��λ����
		this.barcode = barcode;                 //������
		this.total = 0.0f;                      //С��
		this.favourMoney = 0.0f;                //��ʡ
		this.buyFree = 0.0f;                    //��
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
	
	//���������κ��Żݵ�ʱ���������ļ��㷽��
	public void getResultByself() {
		
		this.total = this.price * this.nums;
	}
}
