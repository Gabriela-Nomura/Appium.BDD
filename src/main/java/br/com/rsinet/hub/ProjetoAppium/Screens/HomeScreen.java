package br.com.rsinet.hub.ProjetoAppium.Screens;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class HomeScreen {
	/**
	 * Classe de manipulacao de webElements da pagina inicial da aplicacao
	 */
	final AndroidDriver driver;

	public HomeScreen(AndroidDriver driver) {
		this.driver = driver;

	}


	// Metodo para aguardar visibilidade do elemento passado como parametro
	private void waitUntil(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

//ícone menu da tela inicial recebe um clique
	private WebElement menuIcone() {
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		return driver.findElement(By.id("com.Advantage.aShopping:id/imageViewMenu"));
	}

	public void clicaNoMenu() {
		menuIcone().click();
	}

//acessa o login de usuarios
	private WebElement loginIcone() {
		return driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser"));
	}

	public void clicaNoLogin() {
		waitUntil(loginIcone());
		loginIcone().click();
	}

//acessa a criacao de um novo user
	private WebElement novaConta() {
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		return driver.findElement(By.id("com.Advantage.aShopping:id/textViewSingUpToday"));

	}

	public void clicaNaNovaConta() {
		
		waitUntil(novaConta());
		novaConta().click();
	}

	
	

	
	

}
