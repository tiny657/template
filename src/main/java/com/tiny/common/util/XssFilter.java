package com.tiny.common.util;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.stereotype.Component;

@Component
public class XssFilter {
	public String doFilter(String inputString) {
		String escapedHtml = StringEscapeUtils.escapeHtml(inputString);
		return escapedHtml.replace("\r\n", "<br/>").replace(" ", "&nbsp");
	}
}