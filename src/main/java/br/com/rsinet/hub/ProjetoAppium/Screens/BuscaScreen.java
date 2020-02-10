package br.com.rsinet.hub.ProjetoAppium.Screens;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class BuscaScreen {
	/**
	 * Classe de manipulacao de webElements das paginas de buscas
	 */
	final AndroidDriver driver;

	public BuscaScreen(AndroidDriver driver) {
		this.driver = driver;
	}

	private void waitUntil(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public boolean semResultado() {
		return  driver.findElement(By.id("com.Advantage.aShopping:id/textViewNoProductsToShow")).isDisplayed();
	}

	private WebElement resultado(){
		return driver.findElement(By.id("com.Advantage.aShopping:id/imageViewProduct"));
	}
		public boolean contemResultado() {
			waitUntil(resultado());
	return resultado().isDisplayed();
	}

		public void resultadoInvalido() {
			assertTrue(semResultado());
		}
	private WebElement fone() {
	return  driver.findElement(By.xpath(
			"//android.widget.RelativeLayout[@content-desc=\"Headphones\"]/android.widget.LinearLayout/android.widget.GridView/android.widget.RelativeLayout[1]/android.widget.TextView[1]"));
	}
	
	public void selecionaFone() throws InterruptedException {
		waitUntil(fone());
		fone().click();
	}
	private WebElement HeadPhone() {
		return driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.TextView"));
	}

	public void clickHeadphones() {
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		HeadPhone().click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

	}
	public boolean resultadoClique() {
		return driver.findElement(By.id("com.Advantage.aShopping:id/textViewProductName")).isDisplayed();
	}
	public void resultadoValido() {
	assertTrue(resultadoClique());
	
	}
	private WebElement campoBusca() {
		return driver.findElement(By.id("com.Advantage.aShopping:id/editTextSearch"));
	}

	public void clicaNaLupa() throws Exception {
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		waitUntil(campoBusca());
		campoBusca().click();
	}
		public void insereValorLupaInvalido(String texto) {
			waitUntil(campoBusca());
			campoBusca().sendKeys(texto);
	}

	public void insereValorLupaValido(String texto) throws Exception {
		waitUntil(campoBusca());
		campoBusca().sendKeys(texto);
	}

	private WebElement lupaIcone() {
		return driver.findElement(By.id("com.Advantage.aShopping:id/imageViewSearch"));
	}

	public void processaBusca() {
		lupaIcone().click();
	}

	public void resultadoEsperado() {
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		assertTrue(contemResultado());
		
	}

	private WebElement filtro() {
		return driver.findElement(By.id("com.Advantage.aShopping:id/imageViewFilter"));
	}
	
	public void clicaNoFiltro() {
		waitUntil(fone());
		filtro().click();
	}
	private WebElement byCompability() {
		return driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView"));
	}
	private WebElement compability() {
		return driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView"));
	}

	private WebElement byConnector() {
	return 	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[6]/android.widget.LinearLayout/android.widget.TextView"));
	}
	private WebElement connector(){
	return  driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView"));
	}

	
	public void selecionaFiltros() {
		byCompability().click();
		compability().click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		byConnector().click();
		connector().click();
	}

	private WebElement selecionaFiltro() {
		return driver.findElement(By.id("com.Advantage.aShopping:id/textViewApply"));
	}
	public void aplicaFiltro() {
		selecionaFiltro().click();
	}
	
	
}
