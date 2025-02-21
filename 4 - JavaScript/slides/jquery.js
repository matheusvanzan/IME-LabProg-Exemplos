
var clickHandler = function() { 
    // Your click handler
};

// Exemplo com JS (Vanilla JS)
var anchors = document.getElementsByTagName("a");

for (var i = 0; i < anchors.length; i++) {
    var current = anchors[i];
    current.addEventListener('click', clickHandler, false);
}

// Exemplo com JQuery
$('a').click(clickHandler);