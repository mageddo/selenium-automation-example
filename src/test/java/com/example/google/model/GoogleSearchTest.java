package com.example.google.model;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by elvis on 27/08/16.
 */
public class GoogleSearchTest {

	private static final String SELENIUM_RC_URL = "http://selenium-hub.dev:4444/wd/hub";

	private static WebDriver driver = null;

	@Before
	public void before() throws MalformedURLException {
		DesiredCapabilities capabillities = DesiredCapabilities.chrome();
		driver = new RemoteWebDriver(new URL(SELENIUM_RC_URL), capabillities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void search() throws Exception {
		final int search = new GoogleSearch(driver).search("mageddo.com");
		Assert.assertNotEquals(search, 0);
		driver.close();
	}

}