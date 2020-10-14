package com.umtest.testframe.base;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.umtest.testframe.lib.SQLConnectionHelper;
import com.umtest.testframe.listener.ExtentTestNGITestListener;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;


public class DriverFactory {

	private static List<WebDriverThread> webDriverThreadPool = Collections.synchronizedList(new ArrayList<WebDriverThread>());
	private static ThreadLocal<WebDriverThread> driverThread;
	private static Logger logger = LogManager.getLogger(DriverFactory.class);
	protected static Map<String, RemoteWebDriver> driverPool;


	@BeforeSuite
	public static void instantiateDriverObject() {
		logger.info("Instantiating Driver Object");
		File dir = new File("extentreport");
		dir.mkdir();
		ExtentTestNGITestListener.getExtent();
		driverThread = ThreadLocal.withInitial(() -> {
			WebDriverThread webDriverThread = new WebDriverThread();
			webDriverThreadPool.add(webDriverThread);
			return webDriverThread;
		});
	}


	public static RemoteWebDriver getDriver(String browserName) {
		logger.info("Getting WebDriver");
		driverThread.get().getDriver(browserName);
		return getDriverPool().get(browserName);
	}


	public static RemoteWebDriver getDriver(String appName, String platformName) {

		/*AppiumServer appiumServer = new AppiumServer();

		int port = 4651;
		if(!appiumServer.checkIfServerIsRunnning(port)) {
			appiumServer.startServer();
			appiumServer.stopServer();
		} else {
			System.out.println("Appium Server already running on Port - " + port);
		}*/

		driverThread.get().getDriver(appName, platformName);
		return getDriverPool().get(appName);
	}

	public static RemoteWebDriver getDriver(String appName, String appPackage, String appActivity, String deviceName, String fileName) {
		driverThread.get().getDriver(appName, appPackage, appActivity, deviceName, fileName);
		return getDriverPool().get(appName);
	}


	public static RemoteWebDriver getDriver(String appName, String uuid, String bundleId, String xcodeOrgId, int timeout) {
		driverThread.get().getDriver(appName, uuid, bundleId, xcodeOrgId, timeout);
		return getDriverPool().get(appName);
	}


	public static Map<String, RemoteWebDriver> getDriverPool() {
		if (driverPool == null) {
			driverPool = new HashMap<>();
		}
		return driverPool;
	}

	@AfterMethod
	public static void clearCookies() {
		try {
			if (!getDriverPool().entrySet().isEmpty()) {
				for (Map.Entry<String, RemoteWebDriver> driver : getDriverPool().entrySet()) {
					if (!((driver.getValue() instanceof AndroidDriver) || ((driver.getValue() instanceof IOSDriver))))
						driver.getValue().manage().deleteAllCookies();
				}
			}
		} catch (WebDriverException wde) {
			logger.error("No need of clearing the cookies");
		}

	}


	@AfterSuite
	public static void closeDriverObjects() {
		logger.info("Terminating Driver Session");
		try {
			for (WebDriverThread webDriverThread : webDriverThreadPool) {
				if (webDriverThread != null) {
					webDriverThread.quitDriver();
				} else {
					logger.info("No Active Driver Session");
				}
			}

			SQLConnectionHelper.closeDBConnPool();
			driverThread.remove();
		} catch (Exception e) {
			logger.error("Error Occured While Terminating Driver", e);
		}

	}
}