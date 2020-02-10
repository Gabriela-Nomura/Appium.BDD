package br.com.rsinet.hub.ProjetoAppium.Steps;

import java.util.concurrent.TimeUnit;

import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub.ProjetoAppium.Pages.BuscaPage;
import br.com.rsinet.hub.ProjetoAppium.Pages.HomePage;
import br.com.rsinet.hub.ProjetoAppium.Utils.ExtentReport;
import io.appium.java_client.android.AndroidDriver;

public class BuscaCliqueSteps {
	/**
	 * Classe de teste da funcionalidade de busca por cliques
	 */
	public static AndroidDriver driver;
	private BuscaPage busca;
	private HomePage home;
	ExtentTest test;



	//STEPS
	
	public void BuscaValida() throws Exception {

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		test = ExtentReport.createTest("Buscaporcliquevalida");
		home.clickHeadphones();
		busca.selecionaFone();
		AssertJUnit.assertTrue(busca.resultadoClique());
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
