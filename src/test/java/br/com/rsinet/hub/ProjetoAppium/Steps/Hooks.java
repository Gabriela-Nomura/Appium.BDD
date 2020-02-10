package br.com.rsinet.hub.ProjetoAppium.Steps;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import br.com.rsinet.hub.ProjetoAppium.Manager.DriverManager;
import br.com.rsinet.hub.ProjetoAppium.Manager.PageObjectManager;
import br.com.rsinet.hub.ProjetoAppium.Pages.BuscaPage;
import br.com.rsinet.hub.ProjetoAppium.Pages.CadastraPage;
import br.com.rsinet.hub.ProjetoAppium.Pages.HomePage;
import br.com.rsinet.hub.ProjetoAppium.Utils.ExtentReport;
import br.com.rsinet.hub.ProjetoAppium.Utils.MassaDeDados;
import br.com.rsinet.hub.ProjetoAppium.Utils.Prints;
import br.com.rsinet.hub.ProjetoAppium.cucumber.ContextoDeTeste;
import io.appium.java_client.android.AndroidDriver;

public class Hooks {

	PageObjectManager pageObjectManager;
	static ContextoDeTeste contextoDeTeste;
	BuscaPage busca;
	HomePage home;
	CadastraPage cadastra;
	@SuppressWarnings("rawtypes")
	static	AndroidDriver driver;

	public Hooks(ContextoDeTeste contextoDeTeste) {
		this.contextoDeTeste = contextoDeTeste;
	}

	@BeforeTest
	public void report() {
		ExtentReport.setExtent();
	}

	@BeforeMethod
	public static void inicio() throws Exception {
		driver = contextoDeTeste.getandroidDriverManager().iniciaDriver();
		MassaDeDados.setExcelFile(MassaDeDados.Path_TestData, "Teste");
	}

	@AfterMethod
	public static void tearDown(ITestResult result, ExtentTest test, WebDriver driver) throws Exception {
		String caminho = Prints.tirarPrints(driver, result.getName());
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Caso de teste falhou " + result.getName()); // Adiciona o nome na extenção reporte
			test.log(Status.FAIL, "Caso de teste falhou " + result.getThrowable()); // Adiciona o erro/ exceção
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Caso de teste que pulou " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Caso de teste passou " + result.getName());
		}
		test.addScreenCaptureFromPath(caminho);

		DriverManager.encerra(driver);
	}

	@AfterTest
	public void encerraReport() {
		ExtentReport.endReport();

	}

}
