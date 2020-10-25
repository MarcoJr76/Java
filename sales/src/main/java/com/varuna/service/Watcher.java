/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.varuna.service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Optional;
import com.varuna.sales.path.ConfPath;


/**
 *
 * @author Marco Jr.
 */
public class Watcher {
	ConfPath config = new ConfPath();

	public void watchDirectory() {

		try {
			WatchService watcher = FileSystems.getDefault().newWatchService();
			Path directory = config.PATH_IN;

			directory.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
			System.out.println("Waiting for .dat file in the directory:" + directory);
			while (true) {
				WatchKey key = watcher.take();
				Optional<WatchEvent<?>> watchEvent = key.pollEvents().stream().findFirst();
				Path path = (Path) watchEvent.get().context();
				if (path.toString().endsWith(".dat")) {
					System.out.println("Reading File...");
					Reader.LoadData(path.toString());
					Writer writer = new Writer();
					System.out.println("writing File...");
					writer.createFileWithResult();

				}
				boolean valid = key.reset();
				if (!valid) {
					break;
				}

			}
			watcher.close();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
