/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.varuna.factory;

import com.varuna.sales.entities.Client;
import com.varuna.service.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marco Jr.
 */
public class ClientFactory {

	private List<Client> clients = new ArrayList<Client>();

	public void getClientList() {
		for (String client : Reader.getFileFormated()) {
			if (client.startsWith("002")) {
				String data[] = client.split("ç");
				clients.add(new Client(data[1], data[2], data[3]));
			}
		}
	}

	public int TotalClients() {
		return clients.size();
	}

	public List<Client> getClients() {
		return clients;
	}

}
