<%-- 
    Document   : index
    Created on : 19-nov-2019, 12:53:32
    Author     : master
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modeloDAO.TipoDocumentoDAO"%>
<%@page import="modeloVO.TipoDocumentoVO"%>
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
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/themify-icons.css">
        <link rel="stylesheet" href="css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <!-- Inicio Area Cabecera -->    
        <header>
            <div class="header-area">
                <div id="sticky-header" class="main-header-area">
                    <div class="container">
                        <div class="row align-items-center">
                            <div class="col-xl-3 col-lg-3">
                                <div class="logo">
                                    <a href="index.jsp">
                                        <img src="img/logo.png" alt="">
                                    </a>
                                </div>
                            </div>
                            <div class="col-xl-7 col-lg-7">
                                <div class="main-menu  d-none d-lg-block">
                                    <nav>
                                        <ul id="navigation">
                                            <li><a  href="index.jsp">Inicio</a></li>
                                            <li><a href="#nosotros">Nosotros</a></li>
                                            <li><a href="#servicios">Servicios</a></li>
                                            <li><a href="#contact">Contáctenos</a></li>
                                        </ul>
                                    </nav>
                                </div>  
                            </div>
                            <div class="col-xl-2 col-lg-2">
                                <a href="login.jsp" class="boxed-btn3">Ingresar</a>
                            </div>
                            <div class="col-12">
                                <div class="mobile_menu d-block d-lg-none"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- Fin Area Cabecera -->
        <!-- Inicio Area Slider -->
        <div class="slider_area">
            <div class="single_slider slider_bg_1 d-flex align-items-center">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-5 col-md-6">
                            <div class="slider_text">
                                <h3>Conéctate fácil y rápido con <br> <span>BIOVET</span></h3>
                                <p>Biovet te conecta a tu veterinaria de confianza y te ayuda a <br> 
                                    gestionar tus citas y servicios.</p>
                                <a href="#contact" class="boxed-btn4">Contáctenos</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="dog_thumb d-none d-lg-block">
                    <img src="img/banner/dog.png" alt="">
                </div>
            </div>
        </div>
        <!-- Fin Area Slider -->
        <!-- Inicio Area Servicios -->  
        <div id="servicios" class="service_area">
            <div class="container">
                <div class="row justify-content-center ">
                    <div class="col-lg-7 col-md-10">
                        <div class="section_title text-center mb-95">
                            <h3>Servicios para tu comodidad</h3>
                            <p>Pensando en el bienestar de tu mascota, ofrecemos diferentes servicios para cumplir 
                                con todas sus necesidades.</p>
                        </div>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-lg-4 col-md-6">
                        <div class="single_service active">
                            <div class="service_thumb service_icon_bg_1 d-flex align-items-center justify-content-center">
                                <div class="service_icon">
                                    <img src="img/service/service_icon_1.png" alt="">
                                </div>
                            </div>
                            <div class="service_content text-center">
                                <h3>Agendamiento de Servicios Veterinarios</h3>
                                <p>Realizar el agendamiento de todos los servicios para tus mascotas desde un buen baño, 
                                    hasta una consulta médica.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="single_service">
                            <div class="service_thumb service_icon_bg_1 d-flex align-items-center justify-content-center">
                                <div class="service_icon">
                                    <img src="img/service/service_icon_2.png" alt="">
                                </div>
                            </div>
                            <div class="service_content text-center">
                                <h3>Reporte de Historias Clínicas</h3>
                                <p>Llevar un control del estado de salud de tus mascotas y sus controles, 
                                    y estar más atento a ellas.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fin Area Servicios -->

        <!-- Inicio Area Nosotros  -->
        <div id="nosotros" class="pet_care_area">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-5 col-md-6">
                        <div class="pet_thumb">
                            <img src="img/about/pet_care.png" alt="">
                        </div>
                    </div>
                    <div class="col-lg-6 offset-lg-1 col-md-6">
                        <div class="pet_info">
                            <div class="section_title">
                                <h3><span>Nos preocupamos por tú mascota </span> <br>
                                    Como tú lo harias</h3>
                                <p>Un contacto vía Web entre tu veterinario de confianza y tú, para agilizar los trámites que estén relacionados con tus mascotas; 
                                    agenda citas médicas, servicios de baño, peluquería y de guardería, sin moverte de la comodidad de tu casa 
                                    y dándole la importancia a tu mascota que merece como un miembro más de la familia que es.</p>
                                <a href="#contact" class="boxed-btn2">Contáctenos</a>                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fin Area Nosotros  -->

        <!-- Inicio Area Equipo  -->
        <div class="team_area">
            <div class="container">
                <div class="row justify-content-center ">
                    <div class="col-lg-6 col-md-10">
                        <div class="section_title text-center mb-95">
                            <h3>Nuestro Equipo</h3>
                            <p>Biovet tiene un equipo de trabajo que no solo piensa 
                                en tú comodidad, sino que tiene como principio el bienestar de tú mascota y como ayudarte a agilizar 
                                el adquirir todos los servicios para satisfacer sus necesidades</p>
                        </div>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-lg-4 col-md-6">
                        <div class="single_team">
                            <div class="thumb">
                                <img src="img/team/1.png" alt="">
                            </div>
                            <div class="member_name text-center">
                                <div class="mamber_inner">
                                    <h4>David Bejarano</h4>
                                    <p>Director de Diseño</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="single_team">
                            <div class="thumb">
                                <img src="img/team/2.png" alt="">
                            </div>
                            <div class="member_name text-center">
                                <div class="mamber_inner">
                                    <h4>Alex Silva</h4>
                                    <p>Director de Desarrollo</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="single_team">
                            <div class="thumb">
                                <img src="img/team/3.png" alt="">
                            </div>
                            <div class="member_name text-center">
                                <div class="mamber_inner">
                                    <h4>Andrea Jimenez</h4>
                                    <p>Directora Comercial</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fin Area Equipo  -->

        <!-- Inicio Area Contactenos -->
        <section id="contact" class="contact-section">
            <div class="container">
                <div class="section_title">
                    <h2 class="contact-title">Contáctenos</h2>
                </div>
            </div>
            <div class ="row justify-content-center">
                <div class="col-lg-6 col-md-6">
                    <form class="form-contact contact_form" action="contact_process.php" method="post" id="contactForm" novalidate="novalidate">
                        <div class="row">
                            <div class="col-12">
                                <div class="form-group">
                                    <textarea class="form-control w-100" name="message" id="message" cols="30" rows="9" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Mensaje'" placeholder="Mensaje"></textarea>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <input class="form-control valid" name="name" id="name" type="text" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Ingrese su nombre'" placeholder="Ingrese su nombre">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <input class="form-control valid" name="phone" id="phone" type="text" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Telefono'" placeholder="Telefono">
                                </div>
                            </div>
                            <div class="col-sm-6 col-lg-12">
                                <div class="form-group">
                                    <input class="form-control valid" name="email" id="email" type="email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Correo Electrónico'" placeholder="Correo">
                                </div>
                            </div>
                        </div>
                        <div class="form-group mt-3">
                            <button type="submit" class="button button-contactForm boxed-btn2">Enviar</button>
                        </div>
                    </form>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="media contact-info">
                        <span class="contact-info__icon"><i class="ti-home"></i></span>
                        <div class="media-body">
                            <h3>Mosquera, Cundinamarca.</h3>
                        </div>
                    </div>
                    <div class="media contact-info">
                        <span class="contact-info__icon"><i class="ti-email"></i></span>
                        <div class="media-body">
                            <h3>biovetweb@gmail.com</h3>
                        </div>
                    </div>
                </div>
            </div>
        </section>


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
        <!-- JS here -->
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

        <!--contact js-->
        <script src="js/contact.js"></script>
        <script src="js/jquery.ajaxchimp.min.js"></script>
        <script src="js/jquery.form.js"></script>
        <script src="js/jquery.validate.min.js"></script>
        <script src="js/mail-script.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
