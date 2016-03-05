package com.wty.domain;

//优惠类
public class FavourStyle {

	private String scope;
	private String name;
	private int id;
	private int priority;     //优先级
	private int morePriority; //更高优先级
	private String favWeight; //优惠程度 2-1       100-10        95
	private String favProducts;   //享受优惠的产品条形码  "ITEM000001-ITEM000002-ITEM000003"
	


	public FavourStyle(String name, String scope, int id, String favWeight, int priority, 
							int morePriority, String favProducts) {
		
		this.scope = scope;
		this.name = name;
		this.id = id;
		this.priority = priority;
		this.morePriority = morePriority;
		this.favWeight = favWeight;
		this.favProducts = favProducts;
	}
	
	
	
	public String getFavProducts() {
		return favProducts;
	}



	public void setFavProducts(String favProducts) {
		this.favProducts = favProducts;
	}



	public String getScope() {
		return scope;
	}



	public void setScope(String scope) {
		this.scope = scope;
	}



	public String getFavWeight() {
		return favWeight;
	}

	public void setFavWeight(String favWeight) {
		this.favWeight = favWeight;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getMorePriority() {
		return morePriority;
	}
	public void setMorePriority(int morePriority) {
		this.morePriority = morePriority;
	}
	
	
	
	
}
