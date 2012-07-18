package com.tiny.infrastructure;

public enum UserAgent {
	ANDROID_2_2_HIGHER_EQUAL_WEBKIT("safari", "flicking", "2.2", "webkit"),
	ANDROID_2_2_UNDER_WEBKIT("default", "touch", "2.2", "webkit"), 
	IOS_4_2_HIGHER_EQUAL_SAFARI("safari", "flicking", "4.2", "safari"),
	IOS_4_0_HIGHER_EQUAL_SAFARI("safari", "flicking", "4.0", "safari"),
	IOS_4_0_UNDER_SAFARI("safari", "touch", "4.0", "safari"),
	IPAD_SAFARI("default", "touch", "0", "ipadSafari"),
	WINDOWS_MOBILE_OS("default", "touch", "0", "nonstandard"),
	UNKNOWN("default", "touch", "0", "nonstandard");

	private String viewName;
	private String interactionType;
	private String version;
	private String browserName;

	private UserAgent(String viewName, String interactionType, String version, String browserName) {
		this.viewName = viewName;
		this.interactionType = interactionType;
		this.version = version;
		this.browserName = browserName;
	}

	public String getViewName() {
		return viewName;
	}

	public String getInteractionType() {
		return interactionType;
	}

	public String getVersion() {
		return version;
	}

	public String getBrowserName() {
		return browserName;
	}
	public boolean isSafari() {
		return this.getBrowserName().equals("safari");
	}

	public boolean isWebkit() {
		return this.getBrowserName().equals("webkit");
	}

	public boolean isOther() {
		return !isSafari() && !isWebkit();
	}
}