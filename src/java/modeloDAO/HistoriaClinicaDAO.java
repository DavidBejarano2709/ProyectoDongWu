/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modeloVO.HistoriaClinicaVO;
import util.ConexionBD;
import util.InterfaceCR;

public class HistoriaClinicaDAO extends ConexionBD implements InterfaceCR {

    private Connection conection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    private String query = null;
    private boolean operacion = false;

    private String idHistoriaClinica = "";
    private String fechaApertura = "";
    private String fkMascota = "";

    public HistoriaClinicaDAO(HistoriaClinicaVO historiaClinicaVO) {

        try {

            conection = this.obtenerConexion();
            statement = conection.createStatement();

            idHistoriaClinica = historiaClinicaVO.getIdHistoriaClinica();
            fechaApertura = historiaClinicaVO.getFechaApertura();
            fkMascota = historiaClinicaVO.getFkMascota();

        } catch (SQLException e) {
            out.println("Error" + e.toString());
        }

    }

    @Override
    public boolean agregarRegistro() {
        try {
            query = "INSERT INTO HistoriaClinica (fkMascota) VALUES ('" + fkMascota + "');";
            statement.executeUpdate(query);
            operacion = true;
        } catch (SQLException e) {
            out.println("Error al registrar la nueva historia clinica");
        }
        return operacion;
    }

    @Override
    public ArrayList<HistoriaClinicaVO> consultarRegistro() {

        ArrayList<HistoriaClinicaVO> historiaArray = new ArrayList<>();
        try {
            query = "SELECT * FROM HistoriaClinica WHERE fkMascota = '" + fkMascota + "'";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                HistoriaClinicaVO historiaTmp = new HistoriaClinicaVO();

                historiaTmp.setIdHistoriaClinica(resultSet.getString(1));
                historiaTmp.setFechaApertura(resultSet.getString(2));
                historiaTmp.setFkMascota(resultSet.getString(3));
                
                historiaArray.add(historiaTmp);

            }
        } catch (SQLException e) {
            out.println("Error al consultar Agenda " + e.toString());
        }
        return historiaArray;
    }

    @Override
    public ArrayList consultarGeneral() {
        ArrayList<HistoriaClinicaVO> historiaArray = new ArrayList<>();
        try {
            query = "SELECT * FROM HistoriaClinica";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                HistoriaClinicaVO historiaTmp = new HistoriaClinicaVO();

                historiaTmp.setIdHistoriaClinica(resultSet.getString(1));
                historiaTmp.setFechaApertura(resultSet.getString(2));
                historiaTmp.setFkMascota(resultSet.getString(3));
                out.println(historiaTmp);
                historiaArray.add(historiaTmp);

            }
        } catch (SQLException e) {
            out.println("Error al consultar Agenda " + e.toString());
        }
        return historiaArray;
    }

}
