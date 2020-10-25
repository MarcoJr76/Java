/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.varuna.factory;

import com.varuna.sales.entities.Salespeople;
import com.varuna.service.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marco Jr.
 */
public class SalespeopleFactory {

	private List<Salespeople> salespeolple = new ArrayList<Salespeople>();

	public void getSalespeopleList() {
		for (String salesman : Reader.getFileFormated()) {
			if (salesman.startsWith("001")) {
				String data[] = salesman.split("ç");
				salespeolple.add(new Salespeople(data[1], data[2], Double.parseDouble(data[3])));
			}

		}
	}

	public int TotalSalesman() {
		return salespeolple.size();
	}

	public List<Salespeople> getSalesman() {
		return salespeolple;
	}
}
