package com.wty.method;

import java.util.Vector;

import com.wty.domain.Product;

public abstract class Strategry {

	abstract public void getResult(Vector<Product> prods, Vector<Favourable> faVec);
}
