<%-- 
    Document   : homeAdministrador
    Created on : 26-nov-2019, 19:08:56
    Author     : master
--%>

<%@page import="modeloVO.UsuarioVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String nombreUsuario = "";
    ArrayList<UsuarioVO> usuarioVOSesion = (ArrayList<UsuarioVO>) session.getAttribute("usuariosArray");

    String redirectURL = "index.jsp";

    if (usuarioVOSesion != null) {
        nombreUsuario = usuarioVOSesion.get(0).getNombreUsuario();
        if (Integer.parseInt(usuarioVOSesion.get(0).getFkRol()) != 1) {
            response.sendRedirect(redirectURL);
        }
    } else {

        response.sendRedirect(redirectURL);
    }
%>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <link rel="shortcut icon" type="image/x-icon" href="img/icono.png">
        <title>Biovet</title>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- CSS here -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/fullcalendar.min.css">
        <link rel="stylesheet" href="css/select2.min.css">
        <link rel="stylesheet" type="text/css" href="css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">
        <link rel="stylesheet" href="css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">      
    </head>
    <body>
        <div class="header">
            <div class="row">
                <div class="col-md-2">
                    <div class="header-left">
                        <a  href="index.jsp" class="logo">
                            <img src="img/logo.png">
                        </a>
                    </div>
                </div>
                <a id="toggle_btn" href="javascript:void(0);"><i class="fa fa-bars"></i></a>
                <a id="mobile_btn" class="mobile_btn float-left" href="#sidebar"><i class="fa fa-bars"></i></a>
                <div class ="col-md-8 col-xl-9">
                    <ul class="nav user-menu float-right">
                        <li class="nav-item dropdown has-arrow">
                            <a href="#" class="dropdown-toggle nav-link user-link" data-toggle="dropdown">
                                <span class="user-img">
                                    <i class="fa fa-user-circle-o"></i>
                                </span>
                                <span><%=nombreUsuario%></span>
                            </a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="Usuario?opcion=6">Cerrar Sesión</a>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="dropdown mobile-user-menu float-right">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-ellipsis-v"></i></a>
                    <div class="dropdown-menu dropdown-menu-right">
                        <a class="dropdown-item" href="Usuario?opcion=6">Cerrar Sesión</a>               
                    </div>
                </div>
            </div>                        
        </div>
        <div class="sidebar" id="sidebar">
            <div class="sidebar-inner slimscroll">
                <div id="sidebar-menu" class="sidebar-menu">
                    <ul>
                        <li class="menu-title">Menú</li>
                        <li>
                            <a href="listaUsuarios.jsp"><i class="fa fa-user"></i> <span>Usuarios</span></a>
                        </li>
                        <li>
                            <a href="listaMascotas.jsp"><i class="fa fa-paw"></i> <span>Mascotas</span></a>
                        </li>
                        <li>
                            <a href="Agenda?opcion=5"><i class="fa fa-calendar"></i> <span>Calendario</span></a>
                        </li>
                        <li class="submenu">
                            <a href="#"><i class="fa fa-folder-open"></i> <span> Reportes </span> <span class="menu-arrow"></span></a>
                            <ul style="display: none;">
                                <a class="dropdown-item" href="Reportes?opcion=1">Reporte Cx</a><br>
                                <a class="dropdown-item" href="Reportes?opcion=2">Reporte Exámenes</a><br>
                                <a class="dropdown-item" href="Reportes?opcion=3">Reporte Vacunas</a><br>
                            </ul>
                        </li>
                        <li>
                            <a href="actualizarUsuario.jsp"><i class="fa fa-address-card"></i> <span>Actualizar Datos</span></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="page-wrapper">
            <div class="content">
                <div class="row">
                    <div class="col-sm-8 col-4">
                        <h4 class="page-title">Calendario de Citas</h4>
                    </div>
                </div>
                <div class="row">
                    <!--   <div class="col-lg-12">
                                  <div class="card-box mb-0"> 
                                      <div class="row">
                                          <div class="col-md-12">  -->
                    <!-- <div id="calendar"></div>-->
                    <div class="col-md-12">
                        <div class="table-responsive">
                            <table class="table table-border table-striped custom-table datatable mb-0">
                                <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Fecha Agenda</th>
                                        <th>Servicio</th>
                                        <th>Estado</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="agenda" items="${arrayAgendas}" >
                                        <tr>
                                            <td><c:out value="${agenda.getIdAgenda()}"/></td>
                                            <td><c:out value="${agenda.getFechaAgenda()}"/></td>
                                            <td><c:out value="${agenda.getFkServicio()}"/></td>
                                            <td><c:out value="${agenda.getFkEstadoAgenda()}"/></td>

                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!--           </div>
                                                          </div>
                                                      </div>
                                                  </div>  -->
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
        <%         if (request.getAttribute("mensajeError") != null) {        %>
        ${mensajeError}
        <%            } else { %>
        ${mensajeExito}
        <% }%>                            
        <div class="sidebar-overlay" data-reff=""></div>
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.slimscroll.js"></script>
        <script src="js/select2.min.js"></script>
        <script src="js/jquery.dataTables.min.js"></script>
        <script src="js/dataTables.bootstrap4.min.js"></script>
        <script src="js/moment.min.js"></script>
        <script src="js/jquery-ui.min.html"></script>
        <script src="js/fullcalendar.min.js"></script>
        <script src="js/jquery.fullcalendar.js"></script>
        <script src="js/bootstrap-datetimepicker.min.js"></script>
        <script src="js/app.js"></script>  
    </body>
</html>
