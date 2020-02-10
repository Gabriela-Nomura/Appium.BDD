package br.com.rsinet.hub.ProjetoAppium.Steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub.ProjetoAppium.Pages.BuscaPage;
import br.com.rsinet.hub.ProjetoAppium.Pages.CadastraPage;
import br.com.rsinet.hub.ProjetoAppium.Pages.HomePage;
import br.com.rsinet.hub.ProjetoAppium.Utils.ExtentReport;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class CadastroSteps {

	public static AndroidDriver driver;
	CadastraPage cadastra;
	HomePage home;
	private ExtentTest test;


//@CadastroValido

@Dado("^que esteja na pagina inicial da aplicacao$")
public void que_esteja_na_pagina_inicial_da_aplicacao() throws Throwable {
test = ExtentReport.createTest("Cenario: cadastro valido ");

}

@Quando("^clicar no menu$")
public void clicar_no_login() throws Throwable {
		home.clicaNoMenu();
}
@E("^selecionar a opcao de criar uma nova conta$")
		home.clicaNoLogin();
		home.clicaNaNovaConta();
//Pagina Cadastra - Dados da conta
		cadastra.insereNomeUsuario();
		cadastra.insereEmail();
		cadastra.insereSenha();
		cadastra.insereSenhaConfirmacao();
		cadastra.inserePrimeiroNome();
		cadastra.insereUltimoNome();
		cadastra.insereTelefone();
		// alterar toque.press(PointOption.point(860, 1400)).moveTo(PointOption.point(814, 300)).release().perform();
		cadastra.preencheEndereco();
		cadastra.autorizaLocalizacao();
		cadastra.clicaNoRegistro();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		home.clicaNoMenu();
		String nomeUsuarioCadastrado = driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser"))
				.getText();
		Assert.assertTrue(nomeUsuarioCadastrado != null);

	}

	@Test
	public void CadastroInvalido() throws Exception {
		// Interacoes na tela inicial
		test = ExtentReport.createTest("CadastroFalha");
		home.clicaNoMenu();
		home.clicaNoLogin();
		home.clicaNaNovaConta();
		// Pagina Cadastra - Dados da conta
		cadastra.insereNomeInvalido(1);
		cadastra.insereEmail();
		cadastra.insereSenha();
		cadastra.insereSenhaConfirmacao();
		toque.press(PointOption.point(860, 1400)).moveTo(PointOption.point(814, 300)).release().perform();
		cadastra.clicaNoRegistro();
		Assert.assertTrue(cadastra.botaoRegistraAtivo());
		ExtentReport.endReport();
	}
	@AfterMethod
	public void finalizaReporta(ITestResult result) throws Exception {
		ExtentReport.tearDown(result, test, driver);
//		DriverManager.encerra(driver);
	}

	@AfterTest
	public void encerraReport() {
		ExtentReport.endReport();

	}
}