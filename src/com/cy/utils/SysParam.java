package com.cy.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * 系统参数
 * @author CY
 *
 */
public class SysParam {

	private static Properties properties = new Properties();
	static {
		try {
			properties.load(SysParam.class.getClassLoader().getResourceAsStream("sysparam.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String read (String key) {
		return (String)properties.getProperty(key);
	}
}
