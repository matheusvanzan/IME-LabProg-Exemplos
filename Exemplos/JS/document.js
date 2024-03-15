// ID
document.getElementById('meu-id');

// Classe
document.getElementsByClassName('nome-classe');

// Nome da tag HTML
var nodes = document.getElementsByTagName('p'); // nodes[0], nodes[1], etc.
alert(nodes[0].nodeName);

// Seletor CSS
document.querySelector('ul#my-list > li'); // primeiro
document.querySelectorAll('ul#my-list li'); // todos

// CSS
var el = document.getElementById();
el.style.display = 'none';