package com.wty.test;

class test1 {

	private String name;
	private String age;
	
	public test1(String name) {
		
		this.name = name;
		this.age = "";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
	
}

class tt {
	
	public test1 f(test1 t) {
		
		t.setAge("1111");
		
		return t;
	}
}
