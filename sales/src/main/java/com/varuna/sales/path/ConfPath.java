package com.varuna.sales.path;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Marco Jr.
 */
public class ConfPath {
	public static final Path PATH_IN = Paths.get(System.getProperty("user.home") + "\\data\\in\\");
	public static final Path PATH_OUT = Paths.get(System.getProperty("user.home") + "\\data\\out\\");

}
