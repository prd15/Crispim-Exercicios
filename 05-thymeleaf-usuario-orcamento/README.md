# Exercício 5 - Relação um para muitos na tela

O PDF `05 - thymeleaf - Relação um para muitos na criação de telas.pdf` mostra o caso de
Fornecedor e Produto e manda transpor para o exercício:

> Aqui pode ser Supplier e para seu caso pode ser Usuario e Product pode ser Orcamento.

Um usuário pode ter vários orçamentos, e todo orçamento pertence a um usuário. Na tela de
orçamento é preciso pesquisar o usuário pelo nome, clicar no resultado e guardar o id dele
junto com o orçamento.

Este projeto continua de onde parou o exercício 4, então os campos rg, cpf e nomeMae já
estão aqui.

## Como rodar

```bash
mvn spring-boot:run
```

- `http://localhost:8080/usuarios` - cadastro de usuários (cadastre um antes)
- `http://localhost:8080/orcamentos` - cadastro de orçamentos

## Como o caminho da pesquisa foi montado

| Camada | Arquivo | O que faz |
|---|---|---|
| Repository | `UsuarioRepository.java` | `findByNomeUsuarioContainingIgnoreCase` - consulta por nome |
| Service | `UsuarioService.java` | `buscarPorNome` - se o termo vier vazio devolve todos |
| Controller | `UsuarioController.java` | `GET /usuarios/search` com `@ResponseBody`, devolve JSON |
| Tela | `orcamentoPage.html` | jQuery `$.get('/usuarios/search', ...)` monta as divs do resultado |

O `OrcamentoController` precisou receber o `UsuarioService` para buscar o usuário pelo id
na hora de salvar, igual o PDF faz com o `SupplierService` dentro do `ProductController`.

## As duas partes do JavaScript

1. Clicou em Pesquisar, pega o que foi digitado em `#usuarioSearchTerm`, chama
   `/usuarios/search` e monta uma `div.usuario-result` para cada usuário encontrado,
   guardando o id em `data-usuario-id`.
2. Clicou em um nome, lê o `data-usuario-id`, escreve o nome em `#selectedUsuarioName`,
   joga o id no input escondido `#idUsuario` e limpa a lista de resultados.

O input escondido é o que faz o id chegar no post:

```html
<input type="hidden" id="idUsuario" name="idUsuario">
```

No controller ele é lido com `@RequestParam(name="idUsuario")` e usado para carregar o
usuário antes de salvar o orçamento:

```java
if (idUsuario != null) {
    orcamentoModel.setUsuario(usuarioService.buscaId(idUsuario));
}
```

## Outras mudanças

- `OrcamentoController` deixou de ser `@RestController` e virou `@Controller`, porque
  agora ele devolve a tela `orcamentoPage` e não mais JSON. A única rota que continua
  devolvendo JSON é a de pesquisa de usuário, marcada com `@ResponseBody`.
- O select de estado é preenchido com `IcmsEstados.values()`, que o controller manda para
  a tela no atributo `estados`. O cálculo do ICMS continua sendo o Strategy que já existia
  (MG 18%, RJ 17%, SP 12%).
- A tela usa Bootstrap 5 e o cadastro fica dentro de um modal, como no PDF.
- O valor do orçamento é um `input type="number"`, então use ponto e não vírgula
  (1000.50). Vírgula não converte para `BigDecimal`.
