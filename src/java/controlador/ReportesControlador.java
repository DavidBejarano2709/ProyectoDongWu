/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modeloDAO.ReporteDAO;
import modeloVO.ReporteVO;

/**
 *
 * @author master
 */
@WebServlet(name = "ReportesControlador", urlPatterns = {"/Reportes"})
public class ReportesControlador extends HttpServlet {

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

        response.setContentType("application/pdf");

        try (OutputStream out = response.getOutputStream()) {

            try {
                Document documento = new Document();
                PdfWriter.getInstance(documento, out);
                int opcion = Integer.parseInt(request.getParameter("opcion"));
                String tipoReporte = "";

                ReporteDAO reporteDAO = new ReporteDAO();
                ArrayList<ReporteVO> arrayReportes = reporteDAO.consulta(opcion);

                documento.open();

                switch (opcion) {
                    case 1:
                        tipoReporte = "CX";
                        break;
                    case 2:
                        tipoReporte = "Examenes";
                        break;
                    case 3:
                        tipoReporte = "Vacunas";
                        break;
                }
                //Logo
                /*
                Image logo = Image.getInstance("/home/master/Documentos/Dev/Java/Biovet/build/web/img/logo.png");
                logo.setAlignment(Element.ALIGN_CENTER);
                documento.add(logo);
                 */
                //titulo
                Paragraph par1 = new Paragraph();
                Font fonTitulo = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLACK);
                par1.add(new Phrase("Reporte "+tipoReporte, fonTitulo));
                par1.setAlignment(Element.ALIGN_CENTER);
                par1.add(new Phrase(Chunk.NEWLINE));
                par1.add(new Phrase(Chunk.NEWLINE));
                documento.add(par1);

                //Tabla
                PdfPTable tabla = new PdfPTable(10);
                //Cabecera Tabla
                PdfPCell celda1 = new PdfPCell(new Paragraph("#", FontFactory.getFont("Arial", 7, Font.BOLD, BaseColor.BLACK)));
                PdfPCell celda2 = new PdfPCell(new Paragraph("Id", FontFactory.getFont("Arial", 7, Font.BOLD, BaseColor.BLACK)));
                PdfPCell celda3 = new PdfPCell(new Paragraph("Mascota", FontFactory.getFont("Arial", 7, Font.BOLD, BaseColor.BLACK)));
                PdfPCell celda4 = new PdfPCell(new Paragraph("Dueño", FontFactory.getFont("Arial", 7, Font.BOLD, BaseColor.BLACK)));
                PdfPCell celda5 = new PdfPCell(new Paragraph("Raza", FontFactory.getFont("Arial", 7, Font.BOLD, BaseColor.BLACK)));
                PdfPCell celda6 = new PdfPCell(new Paragraph("Genero", FontFactory.getFont("Arial", 7, Font.BOLD, BaseColor.BLACK)));
                PdfPCell celda7 = new PdfPCell(new Paragraph("Historia", FontFactory.getFont("Arial", 7, Font.BOLD, BaseColor.BLACK)));
                PdfPCell celda8 = new PdfPCell(new Paragraph("Consulta", FontFactory.getFont("Arial", 7, Font.BOLD, BaseColor.BLACK)));
                PdfPCell celda9 = new PdfPCell(new Paragraph("Fecha", FontFactory.getFont("Arial", 7, Font.BOLD, BaseColor.BLACK)));
                PdfPCell celda10 = new PdfPCell(new Paragraph("Procedimiento", FontFactory.getFont("Arial", 7, Font.BOLD, BaseColor.BLACK)));

                tabla.addCell(celda1);
                tabla.addCell(celda2);
                tabla.addCell(celda3);
                tabla.addCell(celda4);
                tabla.addCell(celda5);
                tabla.addCell(celda6);
                tabla.addCell(celda7);
                tabla.addCell(celda8);
                tabla.addCell(celda9);
                tabla.addCell(celda10);

                //Cuerpo Tabla
                for (int i = 0; i < arrayReportes.size(); i++) {
                    String j = Integer.toString(i + 1);
                    tabla.addCell(j);
                    tabla.addCell(arrayReportes.get(i).getIdMascota());
                    tabla.addCell(arrayReportes.get(i).getNombreMascota());
                    tabla.addCell(arrayReportes.get(i).getNombreUsuario());
                    tabla.addCell(arrayReportes.get(i).getTipoRaza());
                    tabla.addCell(arrayReportes.get(i).getTipoSexo());
                    tabla.addCell(arrayReportes.get(i).getIdHistoriaClinica());
                    tabla.addCell(arrayReportes.get(i).getIdConsulta());
                    tabla.addCell(arrayReportes.get(i).getFechaConsulta());
                    tabla.addCell(arrayReportes.get(i).getProcedimiento());

                }

                documento.add(tabla);

                documento.close();
            } catch (DocumentException e) {
                e.getMessage();
            }

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
