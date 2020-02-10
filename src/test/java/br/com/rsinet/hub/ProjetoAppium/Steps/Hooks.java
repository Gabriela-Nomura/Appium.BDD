package br.com.rsinet.hub.ProjetoAppium.Steps;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import br.com.rsinet.hub.ProjetoAppium.Manager.ScreenObjectManager;
import br.com.rsinet.hub.ProjetoAppium.Screens.BuscaScreen;
import br.com.rsinet.hub.ProjetoAppium.Screens.CadastraScreen;
import br.com.rsinet.hub.ProjetoAppium.Screens.HomeScreen;
import br.com.rsinet.hub.ProjetoAppium.Utils.MassaDeDados;
import br.com.rsinet.hub.ProjetoAppium.cucumber.ContextoDeTeste;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;

public class Hooks {

	ScreenObjectManager pageObjectManager;
	static ContextoDeTeste contextoDeTeste;
	BuscaScreen busca;
	HomeScreen home;
	CadastraScreen cadastra;
	@SuppressWarnings("rawtypes")
	static	AndroidDriver driver;

	public Hooks(ContextoDeTeste contextoDeTeste) {
		this.contextoDeTeste = contextoDeTeste;
	}

	@Before
	public void inicio() throws Exception {
		driver = contextoDeTeste.getandroidDriverManager().iniciaDriver();
		MassaDeDados.configExcel();
	}

	@After(order=0) 
	public void quitConfig() throws Exception {
		driver = contextoDeTeste.getandroidDriverManager().encerra();
	}
	@After(order=1)
	 public void afterScenario(Scenario scenario) throws WebDriverException, Exception {
		
		 String screenshotName = scenario.getName().replaceAll(" ", "_");
		
		 //This takes a screenshot from the driver at save it to the specified location
		 File sourcePath = ((TakesScreenshot) contextoDeTeste.getandroidDriverManager().iniciaDriver()).getScreenshotAs(OutputType.FILE);
		 
		 //Building up the destination path for the screenshot to save
		 //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
		 File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
		 
		 //Copy taken screenshot from source location to destination location
		 Files.copy(sourcePath, destinationPath);   
		 
		 //This attach the specified screenshot to the test
		 Reporter.addScreenCaptureFromPath(destinationPath.toString());
		 Reporter.addStepLog ("Print obtido com sucesso ");
		 }
		 }
		 


