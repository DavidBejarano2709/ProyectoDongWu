<%-- 
    Document   : historiaClinica
    Created on : 9/03/2020, 08:56:35 PM
    Author     : master
--%>

<%@page import="modeloVO.MascotaVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="modeloVO.HistoriaClinicaVO"%>
<%@page import="modeloVO.UsuarioVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    //response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    //response.setHeader("Pragma", "no-cache");
    //response.setHeader("Expires", "0");

    String nombreUsuario = "";
    String nombreMascota = "";
    String fechaNacimiento = "";
    String colorMascota = "";
    String razaMascota = "";

    ArrayList<UsuarioVO> usuarioVOSesion = (ArrayList<UsuarioVO>) session.getAttribute("usuariosArray");
    ArrayList<HistoriaClinicaVO> arrayHistoriaClinica = (ArrayList<HistoriaClinicaVO>) request.getAttribute("historialMedico");
    ArrayList<MascotaVO> arrayMascota = (ArrayList<MascotaVO>) request.getAttribute("mascota");

    String redirectURL = "index.jsp";

    if (usuarioVOSesion != null) {
        nombreUsuario = usuarioVOSesion.get(0).getNombreUsuario();
        if (Integer.parseInt(usuarioVOSesion.get(0).getFkRol()) != 1) {
            response.sendRedirect(redirectURL);
        }
    } else {

        response.sendRedirect(redirectURL);
    }
    if (!arrayMascota.isEmpty()) {
        nombreMascota = arrayMascota.get(0).getNombreMascota();
        fechaNacimiento = arrayMascota.get(0).getFechaNacimiento();
        colorMascota = arrayMascota.get(0).getColorMascota();
        razaMascota = arrayMascota.get(0).getFkRaza();
    }
%>
<html>
    <head>        
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">   
        <link rel="shortcut icon" type="image/x-icon" href="img/icono.png">
        <title>Biovet</title>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/select2.min.css">
        <link rel="stylesheet" type="text/css" href="css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
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
                            <a href="homeAdministrador.jsp"><i class="fa fa-calendar"></i> <span>Calendario</span></a>
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
                        <% if (arrayHistoriaClinica.isEmpty()) {%>
                        <h4>Esta mascota no tiene apertura del historial medico.</h4>
                        <a href="historiaClinica?opcion=2&textFkMascota=<%=request.getAttribute("fkMascota")%>">Abrir historial Medico</a>
                        <% } else {%><!--TODO CODIGO PARA REGISTRAR CONSULTAS DEBE IR DENTRO DE ESTE ELSE-->
                        <h4 class="page-title">Historial de Consultas</h4>
                    </div>
                    <div class="col-sm-8 col-4">
                        <h2 class="page-sub-title">Fecha y hora de apertura <%=arrayHistoriaClinica.get(0).getFechaApertura()%></h2>
                        <h2 class="page-sub-title">Fecha de Nacimiento: <%=fechaNacimiento%></h2>
                        <h2 class="page-sub-title">Raza: <%=razaMascota%></h2>
                    </div>
                    <div class="col-sm-4 col-4">
                        <h2 class="page-sub-title">Nombre: <%=nombreMascota%></h2>
                        <h2 class="page-sub-title">Color: <%=colorMascota%></h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="card-box">
                            <form action="historiaClinica" method="POST" class="form-signin">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Motivo Consulta</label>
                                            <input type="text" name="txtMotivoConsulta" class="form-control">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Peso</label>
                                            <input type="text" name="txtPeso" class="form-control">
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>Descripción consulta</label>
                                            <textarea type="text" name="txtDescripcionConsulta" class="form-control"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <div class="custom-file">
                                                <input type="file" class="custom-file-input" id="" lang="es">
                                                <label class="custom-file-label">Seleccionar Archivo</label>
                                            </div>
                                        </div>
                                        <input type="hidden" name="txtFkHistoriaClinica" value="<%=arrayHistoriaClinica.get(0).getIdHistoriaClinica()%>">
                                        <input type="hidden" name="textFkMascota" value="<%=request.getAttribute("fkMascota")%>">
                                    </div>
                                </div>
                                <div class="text-right">
                                    <button type="submit" name="opcion" value="3" class="btn btn-primary">Agregar Consulta Medica</button>
                                </div>
                            </form>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="table-responsive">
                                        <table class="table table-border table-striped custom-table datatable mb-0">
                                            <thead>
                                                <tr>
                                                    <th>Motivo Consulta</th>
                                                    <th>Fecha Consulta</th>
                                                    <th>Peso</th>
                                                    <th>Descripción de la Consulta</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="consultaMedica" items="${arrayConsultasMedicas}" >
                                                    <tr>
                                                        <td><c:out value="${consultaMedica.getMotivoConsulta()}"/></td>
                                                        <td><c:out value="${consultaMedica.getFechaConsulta()}"/></td>
                                                        <td><c:out value="${consultaMedica.getPeso()}"/></td>
                                                        <td><c:out value="${consultaMedica.getDescripcionConsulta()}"/></td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <%}%><!--FIN DEL ELSE-->
                            </div>
                        </div>
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
        </div>
        <!-- Fin Area Footer  --> 
        <div class="sidebar-overlay" data-reff=""></div>
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.slimscroll.js"></script>
        <script src="js/select2.min.js"></script>
        <script src="js/jquery.dataTables.min.js"></script>
        <script src="js/dataTables.bootstrap4.min.js"></script>
        <script src="js/moment.min.js"></script>
        <script src="js/bootstrap-datetimepicker.min.js"></script>
        <script src="js/app.js"></script>
    </body>
</html>
