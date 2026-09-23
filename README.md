# Exercícios - professor Crispim Luiz Martins

Um exercício por pasta. Cada pasta tem o próprio README com o enunciado e o que foi feito.

| Pasta | Exercício | Como abrir |
|---|---|---|
| `01-html-curriculo` | Currículo em HTML, tela única com menu e seção de contato | abrir `index.html` |
| `02-css-testes` | CSS nos três níveis, media query, id e class | abrir `index.html` |
| `03-javascript-lampada` | Lâmpada com botões e lâmpada com o mouse | abrir `lampadaUm.html` |
| `04-thymeleaf-usuario` | Novos atributos no usuário (rg, cpf, nomeMae) e CSS refeito | `mvn spring-boot:run` |
| `05-thymeleaf-usuario-orcamento` | Relação um para muitos entre usuário e orçamento | `mvn spring-boot:run` |

Os PDFs originais das aulas continuam aqui na raiz.

## Observações

- Os exercícios 4 e 5 são projetos Spring Boot separados, os dois sobem em
  `http://localhost:8080`. Rode um de cada vez.
- O 5 continua de onde o 4 parou, então já vem com rg, cpf e nomeMae.
- O banco é H2 em memória: os dados somem quando a aplicação para.
- O link do Inputmask que aparece no PDF de HTML está com o caminho errado no cdnjs.
  O caminho certo está explicado no README do exercício 4.
