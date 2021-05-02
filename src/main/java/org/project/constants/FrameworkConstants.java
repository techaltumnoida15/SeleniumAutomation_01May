package org.project.constants;

public final class FrameworkConstants {
	private FrameworkConstants() {}

	private static final String PROPFILEPATH = System.getProperty("user.dir") + "\\resources\\config.properties";

	public static String getPropfilepath() {
		return PROPFILEPATH;
	}
}
