window.addEventListener('load', inicializarEventos, false);

function inicializarEventos()
{
    var nueva = document.getElementById('imagen_nueva');
    nueva.style.display = 'none';
    var elegir = document.getElementById('imagen_elegir');
    elegir.style.display = 'none';
    ob = document.getElementById('opcion');
    ob.addEventListener('change', modificarControl, false);
    form = document.getElementById('form_modificar');
    form.addEventListener('submit', enviarDatos, false);
}
function modificarControl(e)
{
    var ob = e.target;
    var actual = document.getElementById('imagen_actual');
    var nueva = document.getElementById('imagen_nueva');
    var elegir = document.getElementById('imagen_elegir');
    var form = document.getElementById('form_modificar');
    if (ob.options[ob.selectedIndex].value == 1) {
        actual.style.display = 'table-row';
        nueva.style.display = 'none';
        elegir.style.display = 'none';
        form.setAttribute('enctype',"");
        form.setAttribute('action','productoServlet');
        var reset_input = document.getElementById('input_imagen');
        reset_input.value = "";
    } else if (ob.options[ob.selectedIndex].value == 2) {
        actual.style.display = 'none';
        nueva.style.display = 'table-row';
        elegir.style.display = 'none';
        form.setAttribute('enctype',"multipart/form-data");
        form.setAttribute('action','modificarProductoServlets');
    } else if (ob.options[ob.selectedIndex].value == 3) {
        elegir.style.display = 'table-row';
        actual.style.display = 'none';
        nueva.style.display = 'none';
    }
}
function enviarDatos(e)
{    
    var nombre = document.getElementById('nombre');
    var descripcion = document.getElementById('descripcion');
    var precio = document.getElementById('precio');
    var input = document.getElementById('input_imagen');
    var select = document.getElementById('opcion').value;
    if (nombre.value == '' || descripcion.value == '' || precio.value == "" || select == 2 && input.value == "")
    {
        alert('Debes Ingresar todos los datos obligatorios');
        e.preventDefault();
        return false;
    }
    else
        return true;
}
