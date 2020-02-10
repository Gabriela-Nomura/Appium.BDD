package br.com.rsinet.hub.ProjetoAppium.Manager;

import br.com.rsinet.hub.ProjetoAppium.Screens.BuscaPage;
import br.com.rsinet.hub.ProjetoAppium.Screens.CadastraPage;
import br.com.rsinet.hub.ProjetoAppium.Screens.HomePage;
import br.com.rsinet.hub.ProjetoAppium.cucumber.ContextoDeTeste;
import io.appium.java_client.android.AndroidDriver;

public class PageObjectManager {

	private AndroidDriver driver;

	private CadastraPage cadastra;

	private BuscaPage busca;

	private HomePage home;

	public PageObjectManager(AndroidDriver driver) {	 
		 this.driver = driver;
		 
		 }

	public HomePage getHomePage() {

		return (home == null) ? home = new HomePage(driver) : home;

	}

	public CadastraPage getcadastraPage() {

		return (cadastra == null) ? cadastra = new CadastraPage(driver) : cadastra;

	}

	public BuscaPage getBuscaPage() {

		return (busca == null) ? busca = new BuscaPage(driver) : busca;

	}

}
