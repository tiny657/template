package com.tiny.infrastructure;

import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.wurfl.WurflDevice;
import org.springframework.stereotype.Component;

@Component
public class DeviceJudgement {
	public boolean isSafariOnIphone(Device device) {
		WurflDevice wurflDevice = new WurflDevice((net.sourceforge.wurfl.core.Device) device);

		return "false".equals(wurflDevice.getCapability("is_tablet"))
				&& "iPhone OS".equals(wurflDevice.getCapability("device_os"))
				&& "Safari".equals(wurflDevice.getCapability("mobile_browser"));
	}

	public boolean isSafariOnIpad(Device device) {
		WurflDevice wurflDevice = new WurflDevice((net.sourceforge.wurfl.core.Device) device);

		return "true".equals(wurflDevice.getCapability("is_tablet"))
				&& "iPhone OS".equals(wurflDevice.getCapability("device_os"))
				&& "Safari".equals(wurflDevice.getCapability("mobile_browser"));
	}

	public boolean isWebkitOnAndroid(Device device) {
		WurflDevice wurflDevice = new WurflDevice((net.sourceforge.wurfl.core.Device) device);

		return "Android".equals(wurflDevice.getCapability("device_os"))
				&& "Android Webkit".equals(wurflDevice.getCapability("mobile_browser"));
	}

	public boolean isWindowsMobile(Device device) {
		WurflDevice wurflDevice = new WurflDevice((net.sourceforge.wurfl.core.Device) device);

		return "Windows Mobile OS".equals(wurflDevice.getCapability("device_os"));
	}

	public UserAgent createUserAgent(Device device) {
		if (isSafariOnIphone(device)) {
			return getUserAgentOfSafariOnIphone(device);
		} else if (isSafariOnIpad(device)) {
			return getUserAgentOfSafariOnIpad(device);
		} else if (isWebkitOnAndroid(device)) {
			return getUserAgentOfWebkitOnAndroid(device);
		} else if (isWindowsMobile(device)) {
			return getUserAgentOfWindowsMobile(device);
		}

		return UserAgent.UNKNOWN;
	}

	public String getOsVersion(Device device) {
		WurflDevice wurflDevice = new WurflDevice((net.sourceforge.wurfl.core.Device) device);
		return wurflDevice.getCapability("device_os_version");
	}

	private boolean isHigherOrEqualVersion(Device device, String version) {
		return (0 <= getOsVersion(device).compareTo(version));
	}

	private UserAgent getUserAgentOfSafariOnIphone(Device device) {
		if (isHigherOrEqualVersion(device, UserAgent.IOS_4_0_HIGHER_EQUAL_SAFARI.getVersion())) {
			return UserAgent.IOS_4_0_HIGHER_EQUAL_SAFARI;
		} else if (!isHigherOrEqualVersion(device, UserAgent.IOS_4_0_HIGHER_EQUAL_SAFARI.getVersion())) {
			return UserAgent.IOS_4_0_UNDER_SAFARI;
		}

		return UserAgent.UNKNOWN;
	}

	private UserAgent getUserAgentOfSafariOnIpad(Device device) {
		return UserAgent.IPAD_SAFARI;
	}

	private UserAgent getUserAgentOfWebkitOnAndroid(Device device) {
		if (isHigherOrEqualVersion(device, UserAgent.ANDROID_2_2_HIGHER_EQUAL_WEBKIT.getVersion())) {
			return UserAgent.ANDROID_2_2_HIGHER_EQUAL_WEBKIT;
		} else if (!isHigherOrEqualVersion(device, UserAgent.ANDROID_2_2_HIGHER_EQUAL_WEBKIT.getVersion())) {
			return UserAgent.ANDROID_2_2_UNDER_WEBKIT;
		}

		return UserAgent.UNKNOWN;
	}

	private UserAgent getUserAgentOfWindowsMobile(Device device) {
		return UserAgent.WINDOWS_MOBILE_OS;
	}
}