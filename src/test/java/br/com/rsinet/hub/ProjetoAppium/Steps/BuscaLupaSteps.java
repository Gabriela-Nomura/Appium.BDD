package br.com.rsinet.hub.ProjetoAppium.Steps;

import br.com.rsinet.hub.ProjetoAppium.Manager.PageObjectManager;
import br.com.rsinet.hub.ProjetoAppium.Screens.BuscaPage;
import br.com.rsinet.hub.ProjetoAppium.Screens.HomePage;
import br.com.rsinet.hub.ProjetoAppium.cucumber.ContextoDeTeste;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.android.AndroidDriver;

public class BuscaLupaSteps {
	@SuppressWarnings("rawtypes")
	public static AndroidDriver driver;
	BuscaPage busca;
	PageObjectManager pageObjectManager;
	ContextoDeTeste contextoDeTeste;

	public BuscaLupaSteps(ContextoDeTeste contextoDeTeste) throws Exception {
		this.contextoDeTeste = contextoDeTeste;
		busca = contextoDeTeste.getPageObjectManager().getBuscaPage();
	}

	@Quando("^clicar sobre o campo de pesquisa$")
	public void clicar_sobre_a_lupa() throws Throwable {
		busca.clicaNaLupa();
	}

	@E("^enviar um \"([^\"]*)\" de busca$")
	public void valor_busca_valida(String texto) throws Throwable {
		busca.insereValorLupaValido(texto);
	}

	@E("^processar a busca$")
	public void processar_a_busca() {
		busca.processaBusca();
	}

	@Entao("^a busca retornara o resultado esperado$")
	public void resultado_esperado() {
		busca.resultadoEsperado();
	}

	@E("^enviar o \"([^\"]*)\" de busca com o nome do produto$")
	public void valor_busca_invalida(String texto) throws Throwable {
		busca.insereValorLupaInvalido(texto);
	}

	@Entao("^a busca nao retorna nenhum resultado$")
	public void a_busca_nao_retorna_nenhum_resultado() throws Throwable {
		busca.resultadoInvalido();
	}
}