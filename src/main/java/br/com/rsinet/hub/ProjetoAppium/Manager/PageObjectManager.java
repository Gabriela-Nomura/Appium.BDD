package br.com.rsinet.hub.ProjetoAppium.Manager;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub.ProjetoAppium.Pages.BuscaPage;
import br.com.rsinet.hub.ProjetoAppium.Pages.CadastraPage;
import br.com.rsinet.hub.ProjetoAppium.Pages.HomePage;

public class PageObjectManager {

	private WebDriver driver;

	private CadastraPage cadastra;

	private BuscaPage busca;

	private HomePage home;

	public PageObjectManager(WebDriver driver) {	 
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
