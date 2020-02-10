# language: pt
#coding: UTF-8
Funcionalidade: Busca pelo campo de busca
  Testa o resultado obtido atraves da busca pelo campo na tela inicial

  Contexto: 
    Dado que esteja na pagina inicial da aplicacao
    Quando clicar sobre o campo de pesquisa

  @BuscaLupaValida
  Esquema do Cenario: Busca pela lupa valida
    E enviar um "<parametroBuscaValida>" de busca
    E processar a busca
    Entao a busca retornara o resultado esperado

    Exemplos: 
      | parametroBuscaValida       |
      | HP ELITEPAD 1000 G2 TABLET |

  @BuscaLupaInvalida
  Esquema do Cenario: Busca pela lupa invalida
    E enviar o "<parametroBuscaInvalida>" de busca com o nome do produto
    E processar a busca
    Entao a busca nao retorna nenhum resultado

    Exemplos: 
      | parametroBuscaInvalida |
      | HP ELITEBOOK FOLIO     |
