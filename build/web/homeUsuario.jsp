<%-- 
    Document   : homeUsuario
    Created on : 19-nov-2019, 13:16:44
    Author     : master
--%>

<%@page import="modeloDAO.EspecieDAO"%>
<%@page import="modeloVO.EspecieVO"%>
<%@page import="modeloDAO.MascotaDAO"%>
<%@page import="modeloVO.MascotaVO"%>
<%@page import="modeloDAO.RazaDAO"%>
<%@page import="modeloVO.RazaVO"%>
<%@page import="modeloDAO.GeneroDAO"%>
<%@page import="modeloVO.GeneroVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modeloVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    //response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    //response.setHeader("Pragma", "no-cache");
    //response.setHeader("Expires", "0");

    String nombreUsuario = "";
    String fkUsuario = "";
    ArrayList<UsuarioVO> usuarioVOSesion = (ArrayList<UsuarioVO>) session.getAttribute("usuariosArray");
    String redirectURL = "index.jsp";

    if (usuarioVOSesion != null) {
        nombreUsuario = usuarioVOSesion.get(0).getNombreUsuario();
        fkUsuario = usuarioVOSesion.get(0).getIdUsuario();
        if (Integer.parseInt(usuarioVOSesion.get(0).getFkRol()) != 2) {

            response.sendRedirect(redirectURL);
        }
    } else {
        response.sendRedirect(redirectURL);
    }
    GeneroVO generosVO = new GeneroVO();
    GeneroDAO generosDAO = new GeneroDAO();
    RazaVO razaVO = new RazaVO();
    RazaDAO razaDAO = new RazaDAO();
    EspecieVO especieVO = new EspecieVO();
    EspecieDAO especieDAO = new EspecieDAO();

    MascotaVO mascotaVO = new MascotaVO();
    mascotaVO.setFkUsuario(fkUsuario);
    MascotaDAO mascotaDAO = new MascotaDAO(mascotaVO);

    ArrayList<GeneroVO> arrayGeneros = generosDAO.consultarGeneral();
    ArrayList<EspecieVO> arrayEspecie = especieDAO.consultarGeneral();
    ArrayList<RazaVO> arrayRazas = razaDAO.consultarGeneral();
    ArrayList<MascotaVO> arrayMascotas = mascotaDAO.consultarRegistro();

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
        <!-- Inicio de Header -->
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
        <!--Fin Header-->
        <!--Inicio SideBar-->
        <div class="sidebar" id="sidebar">
            <div class="sidebar-inner slimscroll">
                <div id="sidebar-menu" class="sidebar-menu">
                    <ul>
                        <li class="menu-title">Menú</li>
                        <li>
                            <a href="homeUsuario.jsp"><i class="fa fa-paw"></i> <span>Mascotas</span></a>
                        </li>
                        <li>
                            <a href="actualizarUsuario.jsp"><i class="fa fa-address-card"></i> <span>Actualizar Datos</span></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!--Fin SideBar-->
        <div class="page-wrapper">
            <div class="content">
                <div class="row">
                    <div class="col-sm-8 col-4">
                        <h4 class="page-title"><%=nombreUsuario%> tu código de usuario es: <%=fkUsuario%></h4>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="card-box">
                            <form action="Mascota" method="POST" class="form-signin">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Nombre Mascota</label>
                                            <input type="text" name="textNombreMascota" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label>Fecha de Nacimiento</label>
                                            <input type="date" name="textFechaNacimiento" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label>Color Mascota</label>
                                            <input type="text" name="textcolorMascota" class="form-control">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div>
                                            <label>Especie</label>
                                            <select class="form-control" id="especie" name="" required>
                                                <%for (int i = 0; i < arrayEspecie.size(); i++) {
                                                        especieVO = arrayEspecie.get(i);%>
                                                <option value="<%=especieVO.getIdEspecie()%>"> <%=especieVO.getTipoEspecie()%></option>
                                                <%}%>        
                                            </select>

                                        </div>
                                        <div>
                                            <label>Raza</label>
                                            <select class="form-control" id="raza" name="textFkRaza" required>
                                                <%for (int i = 0; i < arrayRazas.size(); i++) {
                                                        razaVO = arrayRazas.get(i);%>
                                                <option value="<%=razaVO.getIdRaza()%>"> <%=razaVO.getTipoRaza()%></option>
                                                <%}%>      
                                            </select>
                                        </div>
                                        <div>
                                            <label>Genero</label>
                                            <select class="form-control" id="genero" name="textFkGenero">
                                                <%for (int i = 0; i < arrayGeneros.size() - 1; i++) {
                                                        generosVO = arrayGeneros.get(i);%>
                                                <option value="<%=generosVO.getIdGenero()%>"> <%=generosVO.getTipoSexo()%></option>
                                                <%}%>        
                                            </select>
                                            <input type="hidden" name="textFkUsuario" value="<%=fkUsuario%>">
                                        </div>    
                                    </div>
                                </div>
                                <div class="text-right">
                                    <button type="submit" name="opcion" value="1" class="btn btn-primary">Registrar Mascota</button>
                                </div>    
                            </form>
                        </div>
                    </div>
                </div>
                <% if (request.getAttribute("mensajeError") != null) {  %> 
                ${mensajeError}
                <% } else { %>
                ${mensajeExito}
                <% }%>
                <!--Listado Mascotas Usuario-->
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-responsive">
                            <table class="table table-border table-striped custom-table datatable mb-0">
                                <thead>
                                    <tr>
                                        <th>Mascota</th>
                                        <th>Nombre</th>
                                        <th>Fecha de Nacimiento</th>
                                        <th>Raza</th>
                                        <th>Genero</th>
                                        <th>Color</th>
                                        <th>Agendar Servicio</th>
                                    </tr>
                                </thead>
                                <%
                                    for (int i = 0; i < arrayMascotas.size(); i++) {
                                        if (Integer.parseInt(arrayMascotas.get(i).getEstadoMascota()) == 1) {
                                            mascotaVO = arrayMascotas.get(i);
                                %>
                                <tbody>
                                    <tr>
                                        <td><%=i + 1%></td>
                                        <td><%=mascotaVO.getNombreMascota()%></td>
                                        <td><%=mascotaVO.getFechaNacimiento()%></td>
                                        <td><%=mascotaVO.getFkRaza()%></td>
                                        <td><%=mascotaVO.getFkGenero()%></td>
                                        <td><%=mascotaVO.getColorMascota()%></td>
                                        <td><a href="Agenda?opcion=4&textFkMascota=<%=mascotaVO.getIdMascota()%>" class="btn-add"></a></td>
                                    </tr>
                                    <%}
                                        }%>
                                </tbody>
                            </table>
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
            <!--Fin listado Mascotas Usuario-->
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
