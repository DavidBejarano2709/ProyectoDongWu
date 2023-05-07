<%-- 
    Document   : registrarUsuario
    Created on : 6/03/2020, 07:11:11 PM
    Author     : Dave
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="modeloDAO.TipoDocumentoDAO"%>
<%@page import="modeloVO.TipoDocumentoVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    TipoDocumentoVO documentoVO = new TipoDocumentoVO();
    TipoDocumentoDAO documentoDAO = new TipoDocumentoDAO();

    ArrayList<TipoDocumentoVO> arrayTipoDoc = documentoDAO.consultarGeneral();

%>
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
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/themify-icons.css">
        <link rel="stylesheet" href="css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <body> 
        <!-- Inicio Area Formulario-->
        <div class="main-wrapper  account-wrapper">
            <div class="account-page">
                <div class="account-center">
                    <div class="account-box">
                        <form  method="post" action="Usuario" class="form-signin was-validated">
                            <div class="account-logo">
                                <a href="index.jsp"><img src="img/logo.png" alt=""></a>
                            </div>
                            <div class="form-row">
                                <div class="col-md-6">
                                    <label>Tipo de Documento</label>
                                    <select  id="tipoDocumento" name="textFkTipoDocu" class="custom-select" required>
                                        <%for (int i = 0; i < arrayTipoDoc.size(); i++) {
                                                documentoVO = arrayTipoDoc.get(i);%>
                                        <option value="<%=documentoVO.getIdTipoDocu()%>"> <%=documentoVO.getTipoDocu()%></option>

                                        <%}%>        
                                    </select>
                                </div>
                                <div class="col-md-6">
                                    <label>Número de Documento</label>
                                    <input type="text" name="textCedula" class="form-control is-valid" required>
                                </div>
                                <div class="col-md-12">
                                    <label>Nombres Completos</label>
                                    <input type="text" name="textNombreUsuario" class="form-control is-valid" required>
                                </div>
                                <div class="col-md-12">
                                    <label>Apellidos Completos</label>
                                    <input type="text" name="textApellidoUsuario" class="form-control is-valid" required>
                                </div>
                                <div class="col-md-6">
                                    <label>Contraseña</label>
                                    <input type="password" name="textContrasena" class="form-control is-valid" required>
                                </div>
                                <div class="col-md-6">
                                    <label>Confirme su Contraseña</label>
                                    <input type="password" name="textContrasena" class="form-control is-valid" required>
                                </div>
                                <div class="col-md-12">
                                    <label>Correo</label>
                                    <input type="email" name="textCorreoUsuario" class="form-control is-valid" required>
                                </div>
                                <div class="col-md-3">
                                    <button class="btn btn-primary account-btn" name="opcion" value="1" type="submit">Registrarse</button>
                                </div>
                            </div>
                            <div class="login-link">
                                Ya tienes una cuenta? <a href="login.jsp">Ingresar</a>
                            </div>
                        </form>
                        <% if (request.getAttribute("mensajeError") != null) {  %> 
                        ${mensajeError}
                        <% } else { %>
                        ${mensajeExito}
                        <% }%>
                    </div>
                </div>
            </div>
            <!-- Inicio Area Footer  -->
            <footer class="footer">
                <div class="footer_top">
                    <div class="container">
                        <div class="bordered_1px"></div>
                        <div class="row">
                            <div class="col-md-3 col-lg-9">
                                <p class="copy_right text-center">
                                <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                    Derechos de autor &copy;<script>document.write(new Date().getFullYear());</script> reservados BIOVET
                                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                                </p>
                            </div>
                            <div class="col-md-9 col-lg-3">
                                <div class="footer_logo">
                                    <a href="index.jsp">
                                        <img src="img/logo.png" alt="">
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </footer>
            <!-- Fin Area Footer  -->
        </div>
        <script src="js/vendor/modernizr-3.5.0.min.js"></script>
        <script src="js/vendor/jquery-1.12.4.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/isotope.pkgd.min.js"></script>
        <script src="js/ajax-form.js"></script>
        <script src="js/waypoints.min.js"></script>
        <script src="js/jquery.counterup.min.js"></script>
        <script src="js/imagesloaded.pkgd.min.js"></script>
        <script src="js/scrollIt.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/wow.min.js"></script>
        <script src="js/nice-select.min.js"></script>
        <script src="js/jquery.slicknav.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/plugins.js"></script>
        <script src="js/gijgo.min.js"></script>
    </body>

</html>
