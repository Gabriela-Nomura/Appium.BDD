package br.com.rsinet.hub.ProjetoAppium.cucumber;

import br.com.rsinet.hub.ProjetoAppium.Manager.DriverManager;
import br.com.rsinet.hub.ProjetoAppium.Manager.ScreenObjectManager;

public class ContextoDeTeste {

	private DriverManager androidDriverManager;
	private ScreenObjectManager pageObjectManager;
//	 ContextoDeCenario  contextoCenario;
	 
	public ContextoDeTeste() throws Exception {
		androidDriverManager = new DriverManager(); 
		pageObjectManager = new ScreenObjectManager(androidDriverManager.iniciaDriver());
//		contextoCenario = new ContextoDeCenario();
	}

	public DriverManager getandroidDriverManager() throws Exception {
		return androidDriverManager;
	}

	public ScreenObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
}
//	 public ContextoDeCenario getContextoCenario() {
//		 return contextoCenario;
//		 }
//}
