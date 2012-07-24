package com.tiny.controller;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.site.SitePreference;

import com.tiny.common.CommonTest;

public class HomeControllerTest extends CommonTest {
	@Autowired
	private HomeController homeController;

	@Test
	public void testFireFox() {
		// Given
		WebDriver webdriver = new FirefoxDriver();

		// When
		webdriver.get("https://github.com");

		// Then
		assertThat(webdriver.getTitle(), is("GitHub · Social Coding"));
		webdriver.quit();
	}

	@Test
	public void testChrome() {
		// Given
		String chromeBinary = System.getProperty(" ");
		if (chromeBinary == null || chromeBinary.equals("")) {
			if (isWindow()) {
				chromeBinary = "src/main/resources/drivers/chrome/chromedriver.exe";
			} else if (isMac()) {
				chromeBinary = "src/main/resources/drivers/chrome/chromedriver-mac";
			} else if (isLinux()) {
				if (is64bit()) {
					chromeBinary = "src/main/resources/drivers/chrome/chromedriver-linux64";
				} else {
					chromeBinary = "src/main/resources/drivers/chrome/chromedriver-linux32";
				}
			}

			System.setProperty("webdriver.chrome.driver", chromeBinary);
		}

		System.setProperty("webdriver.chrome.driver", chromeBinary);
		WebDriver webdriver = new ChromeDriver();

		// When
		webdriver.get("https://github.com");

		// Then
		assertThat(webdriver.getTitle(), is("GitHub · Social Coding"));
		webdriver.quit();
	}

	@Test
	public void testIE() {
		if (isWindow()) {
			// Given
			DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
			capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			WebDriver webdriver = new InternetExplorerDriver(capability);

			// When
			webdriver.get("https://github.com");

			// Then
			assertThat(webdriver.getTitle(), is("GitHub · Social Coding"));
			webdriver.quit();
		}
	}

	@Test
	public void testHome() {
		assertThat(homeController.home(SitePreference.MOBILE).getViewName(), is("homeMobile"));
	}

	@Test
	public void testHomeMobile() {
		assertThat(homeController.home(SitePreference.NORMAL).getViewName(), is("home"));
	}

	private boolean isWindow() {
		String os = System.getProperty("os.name").toLowerCase();
		if (0 <= os.indexOf("win")) {
			return true;
		}
		return false;
	}

	private boolean isMac() {
		String os = System.getProperty("os.name").toLowerCase();
		if (0 <= os.indexOf("mac")) {
			return true;
		}

		return false;
	}

	private boolean isLinux() {
		String os = System.getProperty("os.name").toLowerCase();
		if (0 <= os.indexOf("linux")) {
			return true;
		}

		return false;
	}

	private boolean is64bit() {
		if (System.getProperty("os.arch").equals("64")) {
			return true;
		}
		return false;
	}
}