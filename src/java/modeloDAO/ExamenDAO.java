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
import modeloVO.ExamenVO;
import util.ConexionBD;
import util.InterfaceCR;

public class ExamenDAO extends ConexionBD implements InterfaceCR {

    private Connection conection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    private String query = null;
    private boolean operacion = false;

    private String idExamen = "";
    private String tipoExamen = "";

    public ExamenDAO(ExamenVO examenVO) {

        try {
            conection = this.obtenerConexion();
            statement = conection.createStatement();

            idExamen = examenVO.getIdExamen();
            tipoExamen = examenVO.getTipoExamen();

        } catch (SQLException e) {
            out.println("Error" + e.toString());
        }

    }

    @Override
    public boolean agregarRegistro() {
        try {
            query = "INSERT INTO examen (tipoExamen) VALUES ('" + tipoExamen + "');";
            statement.executeUpdate(query);
            operacion = true;
        } catch (SQLException e) {
            out.println("Error al ingresar el nuevo Examen" + e.toString());
        }
        return operacion;
    }

    @Override
    public ArrayList consultarRegistro() {

        ArrayList<ExamenVO> examenArray = new ArrayList<>();
        try {
            query = "SELECT * FROM examen where tipoExamen = '"+tipoExamen+"'";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                ExamenVO examenTmp = new ExamenVO();

                examenTmp.setIdExamen(resultSet.getString(1));
                examenTmp.setTipoExamen(resultSet.getString(2));
                out.println(examenTmp);
                examenArray.add(examenTmp);

            }
        } catch (SQLException e) {
            out.println("Error al consultar Agenda " + e.toString());
        }
        return examenArray;
    }

    @Override
    public ArrayList consultarGeneral() {
                ArrayList<ExamenVO> examenArray = new ArrayList<>();
        try {
            query = "SELECT * FROM examen";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                ExamenVO examenTmp = new ExamenVO();

                examenTmp.setIdExamen(resultSet.getString(1));
                examenTmp.setTipoExamen(resultSet.getString(2));
                out.println(examenTmp);
                examenArray.add(examenTmp);

            }
        } catch (SQLException e) {
            out.println("Error al consultar Agenda " + e.toString());
        }
        return examenArray;
    }

}
