/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modeloDAO.AgendaDAO;
import modeloDAO.ServicioDAO;
import modeloVO.AgendaVO;
import modeloVO.ServicioVO;
import util.Correo;

/**
 *
 * @author PC1
 */
@WebServlet(name = "AgendaControlador", urlPatterns = {"/Agenda"})
public class AgendaControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, MessagingException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int opcion = parseInt(request.getParameter("opcion"));
        String enviarCorreo = request.getParameter("enviarCorreo");
        String idAgenda = request.getParameter("textIdAgenda");
        String fechaAgenda = request.getParameter("textFechaAgenda");
        String fkServicio = request.getParameter("txtFkServicio");
        String fkMascota = request.getParameter("textFkMascota");
        String fkEstadoAgenda = request.getParameter("txtFkEstadoAgenda");
        String correoUsuario = request.getParameter("textCorreoUsuario");
        String servicio = "";

        AgendaVO agendaVO = new AgendaVO(idAgenda, fechaAgenda, fkServicio, fkMascota, fkEstadoAgenda);
        AgendaDAO agendaDAO = new AgendaDAO(agendaVO);
        ArrayList<AgendaVO> arrayAgendas;

        ServicioVO servicioVO = new ServicioVO();
        servicioVO.setIdServicio(fkServicio);
        ServicioDAO servicioDAO = new ServicioDAO(servicioVO);

        switch (opcion) {

            case 1: //agregar agenda

//                arrayAgendas=agendaDAO.consultarRegistro();
//                if (arrayAgendas.isEmpty()) {
//                    agendaDAO.agregarRegistro();
//                    if(enviarCorreo == "1"){
//                       ArrayList<ServicioVO> arrayServicios = servicioDAO.consultarRegistro();
//                        servicio = arrayServicios.get(0).getDescripcionServicio();
//                        Correo c = new Correo(correoUsuario, servicio, fechaAgenda);
//                    }
//                    request.setAttribute("mensajeExito", "¡ La agenda se realizo exitosamente!");
//
//                } else {
//
//                    request.setAttribute("mensajeError", "¡ No se pudo realizar la agenda correctamente !");
//                    out.println(fechaAgenda);
//
//                }
//                arrayAgendas=agendaDAO.consultarAgendaPorMascota();
//                request.setAttribute("arrayAgenda", arrayAgendas);
//                request.setAttribute("fkMascota", fkMascota);
//                request.getRequestDispatcher("registrarAgenda.jsp").forward(request, response);
                break;
            case 3://Cancelar Cita
                agendaDAO.eliminarRegistro();
                arrayAgendas = agendaDAO.consultarAgendaPorMascota();

                request.setAttribute("arrayAgendas", arrayAgendas);
                request.setAttribute("fkMascota", fkMascota);
                request.getRequestDispatcher("registrarAgenda.jsp").forward(request, response);
                break;
            case 4: //Consulta agenda por mascota
                arrayAgendas = agendaDAO.consultarAgendaPorMascota();

                request.setAttribute("arrayAgendas", arrayAgendas);
                request.setAttribute("fkMascota", fkMascota);
                request.getRequestDispatcher("registrarAgenda.jsp").forward(request, response);
                break;
            case 5: //Consulta Agenda General
                arrayAgendas = agendaDAO.consultarGeneral();

                request.setAttribute("arrayAgendas", arrayAgendas);
                request.getRequestDispatcher("homeAdministrador.jsp").forward(request, response);
                break;

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (MessagingException ex) {
            Logger.getLogger(AgendaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (MessagingException ex) {
            Logger.getLogger(AgendaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
