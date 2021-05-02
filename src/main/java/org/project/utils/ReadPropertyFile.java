package org.project.utils;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

import org.project.constants.FrameworkConstants;

public final class ReadPropertyFile {

	private ReadPropertyFile() {}

	private static Properties prop = new Properties();
	static {
		FileInputStream fip;
		try {
			fip = new FileInputStream(FrameworkConstants.getPropfilepath());
			prop.load(fip);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String get(String key) throws Exception {
		if(prop.getProperty(key) == null || Objects.isNull(key)) {
			throw new Exception("key " + key + " not found in config.properties. Please check.");
		}
		return prop.getProperty(key);
	}
}
