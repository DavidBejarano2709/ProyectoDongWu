<%-- 
    Document   : Login
    Created on : 19-nov-2019, 14:31:16
    Author     : master
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <link rel="shortcut icon" type="image/x-icon" href="img/icono.png">
        <title>Biovet</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- CSS here -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/themify-icons.css">
        <link rel="stylesheet" href="css/nice-select.css">
        <link rel="stylesheet" href="css/flaticon.css">
        <link rel="stylesheet" href="css/gijgo.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="css/slicknav.css">
        <link rel="stylesheet" href="css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
</head>
<body>
    <!-- Inicio Area Formulario-->
    <div class="main-wrapper account-wrapper">
        <div class="account-page">
            <div class="account-center">
                <div class="account-box">
                    <form action="Usuario" method="post" class="form-signin">
                        <div class="account-logo">
                            <a href="index.jsp"><img src="img/logo.png" alt=""></a>
                        </div>                        
                        <div class="form-group">
                            <label>Número de Documento</label>
                            <input type="text" name="textCedula" autofocus="" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Contraseña</label>
                            <input type="password" name="textContrasena" class="form-control">
                        </div>
            <!--            <div class="form-group text-right">
                            <a href="forgot-password.html">Olvido su contraseña?</a>
                        </div>
            -->            <div class="form-group text-center">
                            <button name="opcion" type="hidden" value="5" class="btn btn-primary account-btn">Ingresar</button>
                        </div>
                        <div class="text-center register-link">
                            No tienes una cuenta? <a href="registrarUsuario.jsp">Registrate ahora</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- Fin Area Formulario-->
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/app.js"></script>

    <% if (request.getAttribute("mensajeError") != null) {  %> 
    ${mensajeError}
    <% }%>
</body>
</html>
