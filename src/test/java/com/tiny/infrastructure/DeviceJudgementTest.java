package com.tiny.infrastructure;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import net.sourceforge.wurfl.core.WURFLManager;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.wurfl.WurflDeviceResolver;
import org.springframework.mobile.device.wurfl.WurflManagerFactoryBean;
import org.springframework.mock.web.MockHttpServletRequest;

import com.tiny.common.CommonMockTest;

public class DeviceJudgementTest extends CommonMockTest {
	private static final String IOS_SAFARI = "Mozilla/5.0 (iPhone; U; CPU iPhone OS 4_2_1 like Mac OS X; en-us) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8C148 Safari/6533.18.5";
	private static final String IOS5_SAFARI = "Mozilla/5.0 (iPhone; CPU iPhone OS 5_0 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9A334 Safari/7534.48.3";
	private static final String IPAD_SAFARI = "Mozilla/5.0 (iPad; U; CPU OS 4_2_1 like Mac OS X; en-us) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8C148 Safari/6533.18.5";
	private static final String ANDROID_WEBKIT = "Mozilla/5.0 (Linux; U; Android 2.2.1; en-us; Nexus One Build/FRG83) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";

	private DeviceJudgement deviceJudgement;
	private MockHttpServletRequest mockRequest = new MockHttpServletRequest();
	private static WURFLManager wurflManager;
	
	@Before
	public void setUp() {
		deviceJudgement = new DeviceJudgement();
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		WurflManagerFactoryBean factory = new WurflManagerFactoryBean(new FileSystemResource(
				"src/main/webapp/WEB-INF/wurfl/wurfl-2.3.2.zip"));
		factory.afterPropertiesSet();
		wurflManager = factory.getObject();
	}

	@Test
	public void testGetVersionOfIOSSafari() {
		// Given
		Device device = createMockDevice(IOS_SAFARI);

		// When
		String result = deviceJudgement.getOsVersion(device);

		// Then
		assertThat(result, is("4.2.1"));
	}

	@Test
	public void testGetVersionOfIOS5Safari() {
		// Given
		Device device = createMockDevice(IOS5_SAFARI);

		// When
		String result = deviceJudgement.getOsVersion(device);

		// Then
		assertThat(result, is("5.0"));
	}

	@Test
	public void testGetVersionOfAndroidWebkit() {
		// Given
		Device device = createMockDevice(ANDROID_WEBKIT);

		// When
		String result = deviceJudgement.getOsVersion(device);

		// Then
		assertThat(result, is("2.2.1"));
	}

	@Test
	public void testIsAgentOfIOSSafari() {
		// Given
		Device device = createMockDevice(IOS_SAFARI);

		// When
		boolean isActual = deviceJudgement.isSafariOnIphone(device);

		// Then
		assertThat(isActual, is(true));
	}

	@Test
	public void testIsAgentOfAndroid() {
		// Given
		Device device = createMockDevice(ANDROID_WEBKIT);

		// When
		boolean isActual = deviceJudgement.isWebkitOnAndroid(device);

		// Then
		assertThat(isActual, is(true));
	}

	@Test
	public void testGetUserAgentOfAndroidWebkit() {
		// Given
		Device device = createMockDevice(ANDROID_WEBKIT);

		// When
		UserAgent result = deviceJudgement.createUserAgent(device);

		// Then
		assertThat(result, is(UserAgent.ANDROID_2_2_HIGHER_EQUAL_WEBKIT));
	}

	@Test
	public void testGetUserAgentOfIOSSafari() {
		// Given
		Device device = createMockDevice(IOS_SAFARI);

		// When
		UserAgent result = deviceJudgement.createUserAgent(device);

		// Then
		assertThat(result, is(UserAgent.IOS_4_0_HIGHER_EQUAL_SAFARI));
	}

	@Test
	public void testGetUserAgentOfIPADSafari() {
		// Given
		Device device = createMockDevice(IPAD_SAFARI);

		// When
		UserAgent result = deviceJudgement.createUserAgent(device);

		// Then
		assertThat(result, is(UserAgent.IPAD_SAFARI));
	}

	@Test
	public void testGetUserAgentOfUnknown() {
		// Given
		Device device = createMockDevice("Unknown");

		// When
		UserAgent result = deviceJudgement.createUserAgent(device);

		// Then
		assertThat(result, is(UserAgent.UNKNOWN));
	}
	
	private Device createMockDevice(String userAgent) {
		WurflDeviceResolver service = new WurflDeviceResolver(wurflManager);
		mockRequest.addHeader("User-Agent", userAgent);
		Device mockDevice = service.resolveDevice(mockRequest);
		return mockDevice;
	}
}
