package br.com.rsinet.hub.ProjetoAppium.Manager;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.rsinet.hub.ProjetoAppium.Utils.MassaDeDados;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverManager {

	/**
	 * Classe de configura��o do driver a executar os testes. Inicializa��o
	 * do navegador, defini��o da url, arquivo do excel e
	 */
	@SuppressWarnings("rawtypes")
	AndroidDriver driver;

	@SuppressWarnings("rawtypes")
	public AndroidDriver iniciaDriver() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "CelularDaGabi");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.Advantage.aShopping");
		capabilities.setCapability("appActivity", ".SplashActivity");
		capabilities.setCapability("newCommandTimeOut", "120");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		AndroidDriver driver = null;
		if (driver == null) {
			driver = new AndroidDriver<MobileElement>(url, capabilities);

		}
		return driver;
	}

	public static void encerra(WebDriver driver) {
		if (driver != null) {
			driver.close();
		}
	}
}
