window.addEventListener('load', inicializarEventos, false);

function inicializarEventos()
{
    window.addEventListener('scroll', cambioScroll, false);
}
function cambioScroll(e)
{
    var caja_superior = document.getElementById('caja_superior');
    var circular = document.getElementById('circular');
    if (document.body.scrollTop >= 600) {
        circular.style.top = (document.body.scrollTop) + 'px';
        circular.style.position = 'absolute';
        circular.style.width = '85%';
    }else{
        circular.style.position = 'initial';
        caja_superior.appendChild(circular);
        circular.style.width = '100%';  
    }
}

