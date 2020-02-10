package br.com.rsinet.hub.ProjetoAppium.cucumber;

import br.com.rsinet.hub.ProjetoAppium.Manager.DriverManager;
import br.com.rsinet.hub.ProjetoAppium.Manager.PageObjectManager;

public class ContextoDeTeste {

	private DriverManager androidDriverManager;
	private PageObjectManager pageObjectManager;
//	 ContextoDeCenario  contextoCenario;
	 
	public ContextoDeTeste() throws Exception {
		androidDriverManager = new DriverManager(); 
		pageObjectManager = new PageObjectManager(androidDriverManager.iniciaDriver());
//		contextoCenario = new ContextoDeCenario();
	}

	public DriverManager getandroidDriverManager() throws Exception {
		return androidDriverManager;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
}
//	 public ContextoDeCenario getContextoCenario() {
//		 return contextoCenario;
//		 }
//}
