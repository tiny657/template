package com.tiny.common.util;

public class XssFilter {
	public static String doFilter(String inputString) {
		return inputString.replace("'", "&acute").replace("\"", "&quot").replace("<", "&lt").replace(">", "&gt")
				.replace(" ", "&nbsp").replace("\r\n", "<br/>");
	}
}