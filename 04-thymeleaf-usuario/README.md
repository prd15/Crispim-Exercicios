# Exercício 4 - Thymeleaf, novos atributos no usuário

Tarefa do PDF `04 - thymeleaf - telas para um projeto JAVA.pdf`:

> Tarefa 1 - Crie mais atributos no usuário e faça funcionar. Atributos como rg, cpf,
> nomeMae. Refaça todo o CSS para uma tela apresentável.

Base: projeto `aula_thymeleaf_java` do professor
(https://github.com/crispimluiz/aula_thymeleaf_java).

## Como rodar

```bash
mvn spring-boot:run
```

Depois abra `http://localhost:8080/usuarios`.

O banco é o H2 em memória, dá para olhar em `http://localhost:8080/h2-console`
com a JDBC URL `jdbc:h2:mem:user_orcamento`, usuário `sa` e senha em branco.
Como é em memória, os dados somem quando a aplicação para.

## O que foi alterado

**`UsuarioModel.java`**
- Campos novos: `rg`, `cpf` e `nomeMae`, com os respectivos `@Column`, getters e setters.
- O `@OneToMany` estava como `mappedBy = "id"`. O `mappedBy` tem que apontar para o campo
  de relação do outro lado, que em `OrcamentoModel` é o `usuario`. Corrigido para
  `mappedBy = "usuario"`, senão o mapeamento não bate com a chave estrangeira.

**`UsuarioService.java`**
- O `atualizaUsuario` agora copia também rg, cpf e nomeMae.

**`usuarioPage.html`**
- CSS refeito: cabeçalho com degradê, formulário em cartão, campos em duas colunas,
  tabela listrada e media query para telas até 600px.
- Formulário com os quatro campos e a tabela com as quatro colunas.
- Máscara de RG e CPF com o Inputmask, do jeito mostrado no PDF de HTML.

## Um detalhe do slide

O endereço do Inputmask que aparece no PDF de HTML retorna 404:

```
https://cdnjs.cloudflare.com/ajax/libs/inputmask/5.0.7/inputmask.min.js
```

No cdnjs a biblioteca está publicada como `jquery.inputmask`, então o link que funciona é:

```
https://cdnjs.cloudflare.com/ajax/libs/jquery.inputmask/5.0.7/inputmask.min.js
```

Mesmo arquivo, mesma versão, só o caminho que muda. Sem isso o `Inputmask` fica
`undefined` e as máscaras não aparecem.
