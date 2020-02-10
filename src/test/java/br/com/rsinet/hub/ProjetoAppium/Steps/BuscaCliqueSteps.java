package br.com.rsinet.hub.ProjetoAppium.Steps;

import br.com.rsinet.hub.ProjetoAppium.Manager.PageObjectManager;
import br.com.rsinet.hub.ProjetoAppium.Screens.BuscaPage;
import br.com.rsinet.hub.ProjetoAppium.cucumber.ContextoDeTeste;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.android.AndroidDriver;

public class BuscaCliqueSteps {
	/**
	 * Classe de teste da funcionalidade de busca por cliques
	 */
	@SuppressWarnings("rawtypes")
	public static AndroidDriver driver;
	private BuscaPage busca;
	PageObjectManager pageObjectManager;
	ContextoDeTeste contextoDeTeste;

	public BuscaCliqueSteps(ContextoDeTeste contextoDeTeste) throws Exception {
		this.contextoDeTeste = contextoDeTeste;
		busca = contextoDeTeste.getPageObjectManager().getBuscaPage();
	}

	@Quando("^eu clicar sobre uma categoria de produtos$")
	public void eu_clicar_sobre_uma_categoria_de_produtos() throws Throwable {
		busca.clickHeadphones();
	}

	@E("^selecionar um dos produtos$")
	public void selecionar_um_dos_produtos() throws Throwable {
		busca.selecionaFone();
	}

	@Entao("^o produto aberto sera correspondente ao selecionado$")
	public void o_produto_aberto_sera_correspondente_ao_selecionado() throws Throwable {
		busca.resultadoClique();

	}

	@Quando("^clicar nos filtros$")
	public void clicar_nos_filtros() throws Throwable {
		busca.clicaNoFiltro();
	}

	@E("^selecionar os filtros$")
	public void selecionar_os_filtros() throws Throwable {
		busca.selecionaFiltros();
	}

	@E("^aplicar os filtros$")
	public void aplicar_os_filtros() throws Throwable {
		busca.aplicaFiltro();
	}

	@Entao("^a busca nao retorna o resultado$")
	public void produto_nao_encontrado() {
		busca.resultadoEsperado();
	}

}
