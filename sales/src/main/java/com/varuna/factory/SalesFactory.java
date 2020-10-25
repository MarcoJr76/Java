/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.varuna.factory;

import com.varuna.sales.entities.Sales;
import com.varuna.service.Reader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Marco Jr.
 */
public class SalesFactory {
	private List<Sales> sales = new ArrayList<Sales>();

	public void getSalesList() {
		for (String sale : Reader.getFileFormated()) {
			if (sale.startsWith("003")) {
				String data[] = sale.split("ç");
				sales.add(new Sales(data[1], getSalesPrice(data[2]), data[3]));
			}
		}
	}

	public int TotalSales() {
		return sales.size();
	}

	public List<Sales> getSales() {
		return sales;
	}

	public double getSalesPrice(String sale) {
		double price = 0;
		String splitincoma[] = sale.split(",");
		for (int i = 0; i < splitincoma.length; i++) {
			String splitinindent[] = splitincoma[i].split("-");
			price = price + Double.parseDouble(splitinindent[1].replace("[", ""))
					* Double.parseDouble(splitinindent[2].replace("]", ""));
		}
		return price;
	}

	public String getIdBestSelling() {
		sales.sort(Comparator.comparing(Sales::getPrices).reversed());
		return sales.get(0).getId_sales();
	}

	public String getWorstSale() {
		sales.sort(Comparator.comparing(Sales::getPrices));
		return sales.get(0).getSalesman();
	}
}
