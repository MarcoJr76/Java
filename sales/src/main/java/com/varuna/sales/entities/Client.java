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
public class Client {

	private String cnpj;
	private String name;
	private String business;

	public Client(String cnpj, String name, String business) {
		this.cnpj = cnpj;
		this.name = name;
		this.business = business;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getName() {
		return name;
	}

	public String getBusiness() {
		return business;
	}

}
