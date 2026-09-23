# Exercício 3 - Lâmpada

Tarefa do PDF `03 - Javascript.pdf`:

> Crie um arquivo lampadaUm. Crie uma página com uma lâmpada apagada e com um botão
> escrito ligar, que muda para uma lâmpada acesa, e outro que apaga. No mesmo arquivo,
> abaixo, outra lâmpada que quando o mouse está em cima da foto a lâmpada está acesa e
> quando sai, apaga.

## Como abrir

Abra o `lampadaUm.html` no navegador.

## Como funciona

As duas lâmpadas são a mesma tag `<img>` trocando o `src` entre `img/lampada-apagada.svg`
e `img/lampada-acesa.svg`, do jeito que a aula mostrou:

```js
document.getElementById("lampadaBotao").setAttribute("src", acesa);
```

- Lâmpada 1: dois `addEventListener("click", ...)`, um no botão Ligar e outro no Desligar.
- Lâmpada 2: `addEventListener("mouseover", ...)` para acender e `mouseout` para apagar.

O JavaScript ficou dentro do próprio HTML, no final do `<body>`, para o exercício ser um
arquivo só. As imagens são SVG, então não perdem qualidade e não dependem de internet.
