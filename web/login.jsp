<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="StyleSheet" media="screen" type="text/css" href="./css/newcss.css">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <script src="./js/menu.js"></script>
    </head>
    <body>
        <div id="caja_superior" class="principal circular">
            <%@ include file="modulo/logo.jsp" %>
            <%@ include file="modulo/menu.jsp" %>
        </div>
        <div class="principal circular">  
            <div class="titulo">
                Identificación
            </div> 
            <div class="tabla">
                <form action="loginServlet" method="POST"> 
                    <table class="normal" summary="Tabla genérica">
                        <tr>
                            <th scope="col">Nombre</th>
                            <th scope="col"><input type="text" name="nombre" /></th>
                        </tr>
                        <tr>
                            <th scope="col">Contraseña</th>
                            <th scope="col"><input type="text" name="contra" /></th>
                        </tr>
                        <tr>
                            <th scope="col"><input class="input_boton" type="submit" name="submit" value="Ingresar" /></th>
                            <th scope="col"><a class="submit2" href="index.jsp">Volver</a></th>
                        </tr>
                    </table> 
                </form>
            </div>
        </div>
        <%@ include file="modulo/contacto.jsp" %>
    </body>
</html>
