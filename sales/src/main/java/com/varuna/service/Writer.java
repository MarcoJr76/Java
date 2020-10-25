/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.varuna.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
import com.varuna.factory.ClientFactory;
import com.varuna.factory.SalesFactory;
import com.varuna.factory.SalespeopleFactory;
import com.varuna.sales.path.ConfPath;


/**
 *
 * @author Marco Jr.
 */
public class Writer {
	private Date fileDate = new Date();
	private ClientFactory clientfactory = new ClientFactory();
	private SalesFactory salesfactory = new SalesFactory();
	private SalespeopleFactory salesmanfactory = new SalespeopleFactory();

	SimpleDateFormat df = new SimpleDateFormat("dd_MM_yyyy_HH-mm-ss");

	public Writer() {
		this.clientfactory.getClientList();
		this.salesfactory.getSalesList();
		this.salesmanfactory.getSalespeopleList();
	}

	public void createFileWithResult() {
		FileWriter file;
		ConfPath config = new ConfPath();
		try {
			file = new FileWriter(new File(config.PATH_OUT + "\\" + df.format(fileDate) + ".dat"));
			file.write("Quantidade de clientes: " + clientfactory.TotalClients() + "\r\n" + "Quantidade de vendedores: "
					+ salesmanfactory.TotalSalesman() + "\r\n" + "ID da venda mais cara: "
					+ salesfactory.getIdBestSelling() + "\r\n" + "Pior Vendedor: " + salesfactory.getWorstSale());
			file.close();
			System.out.println("File Created...Please check the directory:" + config.PATH_OUT);

		
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
