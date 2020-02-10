# language: pt
#coding: UTF-8
Funcionalidade: Busca por cliques
  Testa o produto aberto apos a selecao por cliques

  Contexto: 
    Dado que esteja na pagina inicial da aplicacao
    Quando eu clicar sobre uma categoria de produtos

  @BuscaCliqueSucesso
  Cenario: Busca por clique com sucesso
    E selecionar um dos produtos
    Entao o produto aberto sera correspondente ao selecionado

  @BuscaCliqueFalha
  Cenario: Busca por clique Invalida
    Quando clicar nos filtros
    E selecionar os filtros
    E aplicar os filtros
    Entao a busca nao retorna o resultado
