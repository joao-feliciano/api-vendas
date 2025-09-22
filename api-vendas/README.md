# Desafio X-Brain

## Enunciado

Criar uma API usando Spring Boot  
Utilizar um banco de dados em memória (HSQLDB ou H2). 
Não é necessário desenvolver frontend, apenas o backend.

### Teste:
Desenvolver um serviço que seja capaz de gerar uma venda.  
Uma venda é composta por *id, data da venda, valor, vendedor id e vendedor nome*.

Sua tarefa é desenvolver os serviços REST abaixo:
- Criar uma nova venda.
- Retornar a lista de vendedores com os campos: *nome, total de vendas do vendedor e média de vendas diária*, conforme o período informado por parâmetro.

A avaliação será feita considerando:
- Histórico de commits
- Maneira que o código foi escrito
- Solução apresentada
- Cobertura de testes automatizados

> Não é necessário implementar nenhum tipo de autenticação.

---

## Resolução

A solução foi construída em camadas seguindo boas práticas:

1. *Entity (Venda)*: representa a tabela de vendas no banco H2.
2. *Repository (VendaRepository)*: responsável por acessar e consultar os dados.
3. *Service (VendaService)*: aplica a lógica de negócio (criação de vendas, cálculo de estatísticas).
4. *Controller (VendaController)*: expõe os endpoints REST para consumo da API.

Fluxo completo:  
*Requisição HTTP → Controller → Service → Repository → Banco de Dados (H2)*

> Ainda não implementei testes unitários, pois estou estudando essa parte.

---

## Diagrama da Solução
![Diagrama](https://i.imgur.com/jR8ByQH.png)

---

## Postman
O arquivo de testes está na pasta **teste-postman**, contendo as seguintes requisições:

- *GET* Buscar Vendas
- *GET* Estatísticas Vendedores
- *POST* Criar Venda

---

## Como Executar

1.	Rode a aplicação:
```
mvn spring-boot:run
```

2.	Acesse os endpoints em:
```
http://localhost:8080/api/vendas
```