package br.com.rsinet.hub.ProjetoAppium.Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "resources/features",
glue = { "br.com.rsinet.hub.ProjetoAppium.Steps"}, 

		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:report.html" }, 
		tags =
//	{"@CadastroValido, @CadastroInvalido"},
//		{"@BuscaLupaValida, @BuscaLupaInvalida"},
	{"@BuscaCliqueSucesso, @BuscaCliqueFalha "},
monochrome = true)
public class TesteRunner {
	
}

