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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modeloDAO.ConsultaMedicaDAO;
import modeloDAO.HistoriaClinicaDAO;
import modeloDAO.MascotaDAO;
import modeloVO.ConsultaMedicaVO;
import modeloVO.HistoriaClinicaVO;
import modeloVO.MascotaVO;

/**
 *
 * @author master
 */
@WebServlet(name = "historiaClinicaControlador", urlPatterns = {"/historiaClinica"})
public class historiaClinicaControlador extends HttpServlet {

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

        //Historia Clinica
        int opcion = parseInt(request.getParameter("opcion"));
        String idHistoriaClinica = request.getParameter("txtIdHistoriaClinica");
        String fechaApertura = request.getParameter("textFechaApertura");
        String fkMascota = request.getParameter("textFkMascota");

        HistoriaClinicaVO historiaClinicaVO = new HistoriaClinicaVO(idHistoriaClinica, fechaApertura, fkMascota);
        HistoriaClinicaDAO historiaClinicaDAO = new HistoriaClinicaDAO(historiaClinicaVO);
        ArrayList<HistoriaClinicaVO> arrayHistorias;
        //
        //Consulta Medica
        String idConsulta = request.getParameter("txtIdConsulta");
        String motivoConsulta = request.getParameter("txtMotivoConsulta");
        String fechaConsulta = request.getParameter("txtFechaConsulta");
        String descripcionConsulta = request.getParameter("txtDescripcionConsulta");
        String peso = request.getParameter("txtPeso");
        String estado = request.getParameter("txtEstado");
        String fkHistoriaClinica = request.getParameter("txtFkHistoriaClinica");

        ConsultaMedicaVO consultaMedicaVO = new ConsultaMedicaVO(idConsulta, motivoConsulta, fechaConsulta, descripcionConsulta, peso, estado, fkHistoriaClinica);

        ArrayList<ConsultaMedicaVO> arrayConsultasMedicas;

        //Mascotas
        MascotaVO mascotaVO = new MascotaVO();
        mascotaVO.setIdMascota(fkMascota);
        MascotaDAO mascotaDAO = new MascotaDAO(mascotaVO);
        ArrayList<MascotaVO> arrayMascotas;

        switch (opcion) {
            case 1://Validar si la historia clinica existe si no crearla

                arrayHistorias = historiaClinicaDAO.consultarRegistro();
                if (!arrayHistorias.isEmpty()) {
                    //Si hay historial medico

                    consultaMedicaVO.setFkHistoriaClinica(arrayHistorias.get(0).getIdHistoriaClinica());
                    ConsultaMedicaDAO consultaMedicaDAO = new ConsultaMedicaDAO(consultaMedicaVO);
                    arrayConsultasMedicas = consultaMedicaDAO.consultarRegistro();

                    arrayMascotas = mascotaDAO.consultarRegistroPorId();
                    request.setAttribute("mascota", arrayMascotas);
                    request.setAttribute("arrayConsultasMedicas", arrayConsultasMedicas);
                    request.setAttribute("fkMascota", fkMascota);
                    request.setAttribute("historialMedico", arrayHistorias);
                    request.getRequestDispatcher("historiaClinica.jsp").forward(request, response);
                } else {
                    //No hay historial medico

                    request.setAttribute("fkMascota", fkMascota);
                    request.setAttribute("historialMedico", arrayHistorias);
                    request.getRequestDispatcher("historiaClinica.jsp").forward(request, response);
                }
                break;
            case 2://Realiza Apertura Historial Medico
                if (historiaClinicaDAO.agregarRegistro()) {
                    arrayHistorias = historiaClinicaDAO.consultarRegistro();
                    request.setAttribute("fkMascota", fkMascota);
                    request.setAttribute("historialMedico", arrayHistorias);
                    request.getRequestDispatcher("historiaClinica.jsp").forward(request, response);
                    out.println("Registro agregado");
                } else {
                    out.println("No se pudo agregar registro");
                }
                break;
            case 3://Crear Consulta Medica
                ConsultaMedicaDAO consultaMedicaDAO = new ConsultaMedicaDAO(consultaMedicaVO);
                consultaMedicaDAO.agregarRegistro();

                arrayHistorias = historiaClinicaDAO.consultarRegistro();
                arrayConsultasMedicas = consultaMedicaDAO.consultarRegistro();

                arrayMascotas = mascotaDAO.consultarRegistroPorId();
                request.setAttribute("mascota", arrayMascotas);
                request.setAttribute("arrayConsultasMedicas", arrayConsultasMedicas);
                request.setAttribute("fkMascota", fkMascota);
                request.setAttribute("historialMedico", arrayHistorias);
                request.getRequestDispatcher("historiaClinica.jsp").forward(request, response);
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
