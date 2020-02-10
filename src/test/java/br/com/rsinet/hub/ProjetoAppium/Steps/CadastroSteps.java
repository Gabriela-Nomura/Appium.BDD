package br.com.rsinet.hub.ProjetoAppium.Steps;

import br.com.rsinet.hub.ProjetoAppium.Manager.PageObjectManager;
import br.com.rsinet.hub.ProjetoAppium.Pages.CadastraPage;
import br.com.rsinet.hub.ProjetoAppium.Pages.HomePage;
import br.com.rsinet.hub.ProjetoAppium.Utils.MassaDeDados;
import br.com.rsinet.hub.ProjetoAppium.cucumber.ContextoDeTeste;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.android.AndroidDriver;

public class CadastroSteps {

	public static AndroidDriver driver;
	CadastraPage cadastra;
	HomePage home;
	PageObjectManager pageObjectManager;
	ContextoDeTeste contextoDeTeste;

	public CadastroSteps(ContextoDeTeste contextoDeTeste) throws Exception {
		this.contextoDeTeste = contextoDeTeste;
		cadastra = contextoDeTeste.getPageObjectManager().getcadastraPage();
		home = contextoDeTeste.getPageObjectManager().getHomePage();

	}

//@CadastroValido

	@Dado("^que esteja na pagina inicial da aplicacao$")
	public void que_esteja_na_pagina_inicial_da_aplicacao() throws Throwable {
//PENSAR OQ FAZER
	}

	@Quando("^clicar no menu$")
	public void clicar_no_menu() throws Throwable {
		home.clicaNoMenu();
	}

	@E("^clicar no login$")
	public void clicar_no_login() throws Throwable {
		home.clicaNoLogin();
	}

	@E("^selecionar a opcao de criar uma nova conta$")
	public void selecionar_a_opcao_de_criar_uma_nova_conta() throws Throwable {
		home.clicaNaNovaConta();
	}

	@Quando("^inserir um nome de usuario valido$")
	public void inserir_um_nome_de_usuario_valido() throws Throwable {
//		Reporter.addScenarioLog(message);
//		.createTest("Cenario: cadastro valido ");
		cadastra.insereNomeUsuario();
	}

	@E("^inserir email valido$")
	public void inserir_email_valido() throws Throwable {
		cadastra.insereEmail();
	}

	@E("^inserir senha valida$")
	public void inserir_senha_valida() throws Throwable {
		cadastra.insereSenha();
	}

	@E("^inserir a confirmacao de senha$")
	public void inserir_confirmacao_de_senha() throws Throwable {
		cadastra.insereSenhaConfirmacao();
	}

	@E("^inserir o primeiro nome$")
	public void inserir_o_primeiro_nome() throws Throwable {
		cadastra.inserePrimeiroNome();
	}

	@E("^inserir o ultimo nome$")
	public void inserir_o_ultimo_nome() throws Throwable {
		cadastra.insereUltimoNome();
	}

	@E("^inserir o numero de telefone$")
	public void inserir_o_numero_de_telefone() throws Throwable {
		cadastra.insereTelefone();
	}

	@E("^ajustar a tela$")
	// PENSAR METODO PARA AJUSTAR A TELA
	public void ajustar_a_tela() throws Throwable {
		cadastra.ajustaTela("REGISTER");
	}

	@E("^ativar o preenchimento automatico pelo gps$")
	public void ativar_o_preenchimento_automatico_pelo_gps() throws Throwable {
		cadastra.preencheEndereco();
	}

	@E("^aceitar que o app obtenha a localizacao do dispositivo$")
	public void aceitar_que_o_app_obtenha_a_localizacao_do_dispositivo() throws Throwable {
		cadastra.autorizaLocalizacao();
	}

	@E("^clicar no registro$")
	public void clicar_no_registro() throws Throwable {
		cadastra.clicaNoRegistro();
	}

	@Entao("^na homepage, no menu, o nome do usuario sera exibido$")
	public void na_homepage_no_menu_o_nome_do_usuario_sera_exibido() throws Throwable {
		cadastra.clicaNoMenu();
		cadastra.testaValido();

	}

	@Quando("^inserir um nome de usuario ja cadastrado$")
	public void inserir_um_nome_de_usuario_ja_cadastrado() throws Throwable {
//		test = ExtentReport.createTest("CadastroFalha");
		cadastra.insereNomeInvalido(1);
	}

	@Entao("^o cadastro nao sera concluido e a mensagem de erro aparecera$")
	public void o_cadastro_nao_sera_concluido_e_a_mensagem_de_erro_aparecera() throws Throwable {
		cadastra.testaInvalido();
	}
}
