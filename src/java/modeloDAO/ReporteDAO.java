/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modeloVO.ReporteVO;
import util.ConexionBD;

/**
 *
 * @author master
 */
public class ReporteDAO extends ConexionBD {

    private Connection conection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    private String query = null;

    public ReporteDAO() {
        super();
        try {
            conection = this.obtenerConexion();
            statement = conection.createStatement();
        } catch (SQLException e) {
            System.out.println("Error" + e.toString());
        }
    }

    public ArrayList consulta(int opcion) {
        ArrayList<ReporteVO> arrayReportes = new ArrayList<>();
        try {
            switch(opcion){
                case 1:
                    query = "SELECT * FROM `reporteCX`";
                    break;
                case 2:
                    query = "SELECT * FROM `reporteExamenes`";
                    break;
                case 3:
                    query = "SELECT * FROM `reporteVacunas`";
                    break;
            }
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {                
                ReporteVO reporteTmp = new ReporteVO();
                //private String idMascota,nombreMascota,nombreUsuario,tipoRaza,tipoSexo,idHistoriaClinica,idConsulta,fechaConsulta,procedimiento;
                reporteTmp.setIdMascota(resultSet.getString(1));
                reporteTmp.setNombreMascota(resultSet.getString(2));
                reporteTmp.setNombreUsuario(resultSet.getString(3));
                reporteTmp.setTipoRaza(resultSet.getString(4));
                reporteTmp.setTipoSexo(resultSet.getString(5));
                reporteTmp.setIdHistoriaClinica(resultSet.getString(6));
                reporteTmp.setIdConsulta(resultSet.getString(7));
                reporteTmp.setFechaConsulta(resultSet.getString(8));
                reporteTmp.setProcedimiento(resultSet.getString(9));
                
                arrayReportes.add(reporteTmp);
            }
            
            
            
        } catch (Exception e) {
            System.out.println("Error al consultar Reportes " + e.toString());
        }
        return arrayReportes;
    }

}
