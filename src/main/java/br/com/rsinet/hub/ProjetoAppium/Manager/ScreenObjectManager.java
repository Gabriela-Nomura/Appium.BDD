package br.com.rsinet.hub.ProjetoAppium.Manager;

import br.com.rsinet.hub.ProjetoAppium.Screens.BuscaScreen;
import br.com.rsinet.hub.ProjetoAppium.Screens.CadastraScreen;
import br.com.rsinet.hub.ProjetoAppium.Screens.HomeScreen;
import br.com.rsinet.hub.ProjetoAppium.cucumber.ContextoDeTeste;
import io.appium.java_client.android.AndroidDriver;

public class ScreenObjectManager {

	private AndroidDriver driver;

	private CadastraScreen cadastra;

	private BuscaScreen busca;

	private HomeScreen home;

	public ScreenObjectManager(AndroidDriver driver) {	 
		 this.driver = driver;
		 
		 }

	public HomeScreen getHomePage() {

		return (home == null) ? home = new HomeScreen(driver) : home;

	}

	public CadastraScreen getcadastraPage() {

		return (cadastra == null) ? cadastra = new CadastraScreen(driver) : cadastra;

	}

	public BuscaScreen getBuscaPage() {

		return (busca == null) ? busca = new BuscaScreen(driver) : busca;

	}

}
