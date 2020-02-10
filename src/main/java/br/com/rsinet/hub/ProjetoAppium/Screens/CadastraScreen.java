package br.com.rsinet.hub.ProjetoAppium.Screens;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import br.com.rsinet.hub.ProjetoAppium.Utils.MassaDeDados;
import br.com.rsinet.hub.ProjetoAppium.Utils.UserName;
import io.appium.java_client.android.AndroidDriver;

public class CadastraScreen {
	/**
	 * Classe de manipulacao de webElements da pagina de cadastro
	 */
	final AndroidDriver driver;

	public CadastraScreen(AndroidDriver driver) {
		this.driver = driver;

	}

	// Metodo que aguarda até que o elemento esteja disponivel para receber o
	// clique
	private void waitUntil(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 150);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Encontra o campo de nome de usuario
	private WebElement nomeUsuarioBox() {
		return driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.EditText\r\n"));
	}

//Insere o nome de usuario de acordo com o valor lido pelo excel. i= linha a ser lida
	public void insereNomeUsuario() {
		waitUntil(nomeUsuarioBox());
		nomeUsuarioBox().sendKeys(UserName.getNomeUsuario(10));
	}

	public void insereNomeInvalido(int i) throws Exception {
		waitUntil(nomeUsuarioBox());
		nomeUsuarioBox().sendKeys(MassaDeDados.userName(i));
	}

	private WebElement emailBox() {
		return driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText"));
	}

	public void insereEmail() throws Exception {
		emailBox().sendKeys(MassaDeDados.userEmail());
	}

	private WebElement senhaBox() {
		return driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.EditText"));
	}

	public void insereSenha() throws Exception {
		senhaBox().sendKeys(MassaDeDados.userSenha());
	}

	private WebElement confirmaSenhaBox() {
		return driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.EditText"));
	}

	public void insereSenhaConfirmacao() throws Exception {
		confirmaSenhaBox().sendKeys(MassaDeDados.userSenhaConfirmacao());
	}
	private WebElement menuIcone2() {
		return driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.ImageView[1]"));
	}
	public void clicaNoMenu() {
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		waitUntil(menuIcone2());
		menuIcone2().click();
	}
	private WebElement primeiroNomeBox() {
		return driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.EditText"));
	}

	public void inserePrimeiroNome() throws Exception {
		primeiroNomeBox().sendKeys(MassaDeDados.userPrimeiroNome());
	}

	private WebElement ultimoNomeBox() {
		return driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.EditText"));
	}

	public void insereUltimoNome() throws Exception {
		ultimoNomeBox().sendKeys(MassaDeDados.userUltimoNome());
	}

	private WebElement telefoneBox() {
		return driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText"));
	}

	public void insereTelefone() throws Exception {
		telefoneBox().sendKeys(MassaDeDados.userTelefone());
	}

	private WebElement localizacao() {
		return driver.findElement(By.id("com.Advantage.aShopping:id/switchLocation"));
	}

	public void preencheEndereco() {
		localizacao().click();
	}

	private WebElement registraBotao() {
		return driver.findElement(By.id("com.Advantage.aShopping:id/buttonRegister"));
	}

	public boolean botaoRegistraAtivo() {
		return registraBotao().isEnabled();

	}

	public void clicaNoRegistro() {
		registraBotao().click();
	}

	private WebElement autorizacao() {
		return driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
	}

	public void autorizaLocalizacao() {
		autorizacao().click();
	}

	public void ajustaTela(String esperado) {
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
                        + esperado + "\").instance(0))");
	}

	public void testaInvalido() {
		Assert.assertTrue(botaoRegistraAtivo());
		
	}
	public void testaValido() {
		String nomeUsuarioCadastrado = driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser"))
				.getText();
		Assert.assertTrue(nomeUsuarioCadastrado != null);

	}
}