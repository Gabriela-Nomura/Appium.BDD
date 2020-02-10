# language: pt
#coding: UTF-8
Funcionalidade: Cadastro de um novo usuario

Deve realizar o cadastro de um novo usuario, quando inserir informacoes validas, 
e rejeitar tentativas com informacoes incorretas.

Contexto:
	Dado que esteja na pagina inicial da aplicacao
	Quando clicar no menu
	E clicar no login
	E selecionar a opcao de criar uma nova conta
	
@CadastroValido
Cenario: Cadastro de um novo usuario com sucesso
		
		Quando inserir um nome de usuario valido
		E inserir email valido
		E inserir senha valida
		E inserir contra senha valida 
		E inserir o primeiro nome
		E inserir o ultimo nome
		E inserir o numero de telefone
		E ajustar a tela
		E ativar o preenchimento automatico pelo gps
		E aceitar que o app obtenha a localizacao do dispositivo
		E clicar no registro
		Entao na homepage, no menu, o nome do usuario sera exibido
		
@CadastroInvalido
Cenario: Cadastro de um novo usuario com falha
		
		E inserir um nome de usuario ja cadastrado
		E inserir email valido
		E inserir senha valida
		E clicar no registro 
		Entao o cadastro nao sera concluido e a mensagem de erro aparecera