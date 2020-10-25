/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.varuna.sales.entities;

/**
 *
 * @author Marco Jr.
 */
public class Sales {
	private String id_sales;
	private double prices;
	private String salesman;

	public Sales(String id_sales, double prices, String salesman) {
		this.id_sales = id_sales;
		this.prices = prices;
		this.salesman = salesman;
	}

	public String getId_sales() {
		return id_sales;
	}

	public double getPrices() {
		return prices;
	}

	public String getSalesman() {
		return salesman;
	}

}
