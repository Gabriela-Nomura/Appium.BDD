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
  Esquema do Cenario: Cadastro de um novo usuario com sucesso
    Quando inserir um nome de usuario valido
    E inserir "<email>" valido
    E inserir senha valida
    E inserir a confirmacao de senha
    E inserir o primeiro nome
    E inserir o ultimo nome
    E inserir o numero de telefone
    E ajustar a tela
    E ativar o preenchimento automatico pelo gps
    E aceitar que o app obtenha a localizacao do dispositivo
    E clicar no registro
    Entao na homepage, no menu, o nome do usuario sera exibido

    Exemplos: 
      | email                |
      | gabriela@hotmail.com |
      | judith@Hotmail.com   |

  @CadastroInvalido
  Cenario: Cadastro de um novo usuario com falha
    Quando inserir um nome de usuario ja cadastrado
    E inserir email valido
    E inserir senha valida
    E inserir a confirmacao de senha
    E ajustar a tela
    E clicar no registro
    Entao o cadastro nao sera concluido e a mensagem de erro aparecera
