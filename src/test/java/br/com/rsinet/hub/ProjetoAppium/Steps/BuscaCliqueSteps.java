package br.com.rsinet.hub.ProjetoAppium.Steps;

import com.cucumber.listener.Reporter;

import br.com.rsinet.hub.ProjetoAppium.Manager.ScreenObjectManager;
import br.com.rsinet.hub.ProjetoAppium.Screens.BuscaScreen;
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
	private BuscaScreen busca;
	ScreenObjectManager pageObjectManager;
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
		Reporter.addStepLog("O produto aberto e correspondente ao selecionado");
		Reporter.addStepLog("O teste foi finalizado.");


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
		Reporter.addStepLog("Os filtros selecionados foram aplicados");

	}

	@Entao("^a busca nao retorna o resultado$")
	public void produto_nao_encontrado() {
		busca.resultadoInvalido();
		Reporter.addStepLog("A busca nao retornou nenhum resultado");
		Reporter.addStepLog("O teste foi finalizado.");


	}

}
