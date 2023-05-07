/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modeloDAO.MascotaDAO;
import modeloVO.MascotaVO;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "MascotaControlador", urlPatterns = {"/Mascota"})
public class MascotaControlador extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int opcion = parseInt(request.getParameter("opcion"));
        String idMascota = request.getParameter("textIdMascota");
        String nombreMascota = request.getParameter("textNombreMascota");
        String fechaNacimiento = request.getParameter("textFechaNacimiento");
        String fkUsuario = request.getParameter("textFkUsuario");
        String fkRaza = request.getParameter("textFkRaza");
        String fkGenero = request.getParameter("textFkGenero");
        String colorMascota = request.getParameter("textcolorMascota");
        String estadoMascota = request.getParameter("textEstadoMascota");

        MascotaVO mascotaVO = new MascotaVO(idMascota, nombreMascota, fechaNacimiento, fkUsuario, fkRaza, fkGenero, colorMascota, estadoMascota);
        MascotaDAO mascotaDAO = new MascotaDAO(mascotaVO);
        ArrayList<MascotaVO> arrayMascotas;

        switch (opcion) {
            case 1://Agregar Registro                           
                if (mascotaDAO.agregarRegistro()) {
                    request.setAttribute("MensajeExito", "La mascota fue agregada correctamente!");
                } else {
                    request.setAttribute("MensajeError", "La mascota no pudo ser agregada!");
                }
                request.getRequestDispatcher("homeUsuario.jsp").forward(request, response);
                break;

            case 2:// Eliminar Registro
                if (mascotaDAO.eliminarRegistro()) {
                    request.setAttribute("MensajeExito", "Mascota Eliminada correctamente!");
                } else {
                    request.setAttribute("MensajeError", "El perfil de mascota no pudo ser eliminado!");
                }
                //request.getRequestDispatcher("eliminarMascota.jsp").forward(request, response);
                break;
            case 3://Buscar Mascota por Usuario
                arrayMascotas = mascotaDAO.consultarRegistro();

                if (!arrayMascotas.isEmpty()) {
                    request.setAttribute("mascotas", arrayMascotas);
                    request.getRequestDispatcher("listaMascotas.jsp").forward(request, response);
                } else {
                    request.setAttribute("MascotasError", "Id de usuario erroneo o no tiene Mascotas!");
                    request.getRequestDispatcher("listaMascotas.jsp").forward(request, response);
                }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
