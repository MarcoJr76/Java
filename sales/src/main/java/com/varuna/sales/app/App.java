/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.varuna.sales.app;


import com.varuna.service.Watcher;

/**
 *
 * @author Marco Jr.
 */
public class App {
	public static void main(String[] args) {
		Watcher watcher = new Watcher();
		watcher.watchDirectory();

	}
}
