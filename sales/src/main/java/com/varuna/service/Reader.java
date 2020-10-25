/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.varuna.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.varuna.sales.path.ConfPath;


/**
 *
 * @author Marco Jr.
 */
public class Reader {
	private static List<String> filein = new ArrayList<String>();

	public static void LoadData(String file) {
		BufferedReader br;
		ConfPath config = new ConfPath();

		try {
			br = new BufferedReader(new FileReader(config.PATH_IN + "\\" + file));
			String line = "";
			while ((line = br.readLine()) != null) {
				if (line.contains("001ç")) {
					String[] data = line.split("001ç");
					for (int i = 1; i < data.length; i++) {
						filein.add("001ç" + data[i]);
					}
				} else if (line.contains("002ç")) {
					String[] data = line.split("002ç");
					for (int i = 1; i < data.length; i++) {
						filein.add("002ç" + data[i]);
					}
				} else if (line.contains("003ç")) {
					String[] data = line.split("003ç");
					for (int i = 1; i < data.length; i++) {
						filein.add("003ç" + data[i]);
					}
				}
			}

			br.close();
		} catch (IOException e) {
			System.out.println("Arquivo de entrada nao encontrado.");
		}
	}

	public static List<String> getFileFormated() {
		return filein;
	}
}
