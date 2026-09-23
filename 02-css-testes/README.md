# Exercício 2 - Testes de CSS

O PDF `02 - CSS.pdf` pede para fazer os testes junto com a aula: criar uma pasta, um
`index.html` e usar o CSS nos três níveis, depois media query e por último id e class.

## Arquivos

| Arquivo | Nível de CSS |
|---|---|
| `01-inline.html` | CSS direto na tag, pelo atributo `style` |
| `02-interno.html` | CSS dentro do `<style>` no `<head>` |
| `index.html` + `style/styles.css` | CSS em arquivo separado, com id, class e media query |

## Como testar o media query

Abra o `index.html` e vá diminuindo a largura da janela. Abaixo de 600px o fundo troca
de `lightblue` para `lightcoral`, o título cai para 24px e o texto para 10px.

## Sobre a força dos seletores

No `index.html` o `<h1>` usa `id="titulo"` e os parágrafos usam `class="texto"`. O último
parágrafo ficou sem class de propósito, para mostrar que o seletor `.texto` só pega quem
foi marcado. No CSS o id é `#titulo` e a class é `.texto`, e o media query repete esses
mesmos seletores, senão os textos não mudariam de tamanho na tela pequena.
