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
import modeloVO.RazaVO;
import util.ConexionBD;
import util.InterfaceCR;

/**
 *
 * @author Usuario
 */
public class RazaDAO extends ConexionBD implements InterfaceCR {

    private Connection conection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    private String query = null;
    private boolean operacion = false;

    private String idRaza = "";
    private String tipoRaza = "";
    private String fkEspecie = "";

    public RazaDAO() {
        try {
            conection = this.obtenerConexion();
            statement = conection.createStatement();

        } catch (SQLException e) {
            out.println("Error" + e.toString());
        }
    }

    public RazaDAO(RazaVO razaVO) {

        super();

        try {

            conection = this.obtenerConexion();
            statement = conection.createStatement();

            idRaza = razaVO.getIdRaza();
            tipoRaza = razaVO.getTipoRaza();
            fkEspecie = razaVO.getFkEspecie();

        } catch (SQLException e) {

            out.println("Error" + e.toString());

        }

    }

    @Override
    public boolean agregarRegistro() {

        try {

            query = "insert into raza (tipoRaza, fkEspecie) values ('" + tipoRaza + "', '" + fkEspecie + "');";
            statement.executeUpdate(query);
            operacion = true;

        } catch (SQLException e) {
            out.println("Error" + e.toString());
        }
        return operacion;
    }

    @Override
    public ArrayList<RazaVO> consultarRegistro() {
        ArrayList<RazaVO> razaArray = new ArrayList<>();
        try {
            query = "select * from raza where idRaza='" + idRaza + "';";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                RazaVO razaTmp = new RazaVO();

                razaTmp.setIdRaza(resultSet.getString(1));
                razaTmp.setTipoRaza(resultSet.getString(2));

                razaArray.add(razaTmp);
            }

        } catch (SQLException e) {
            out.println("Error" + e.toString());
        }
        return razaArray;
    }

    @Override
    public ArrayList consultarGeneral() {
        ArrayList<RazaVO> razaArray = new ArrayList<>();
        try {
            query = "select * from Raza;";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                RazaVO razaTmp = new RazaVO();

                razaTmp.setIdRaza(resultSet.getString(1));
                razaTmp.setTipoRaza(resultSet.getString(2));

                razaArray.add(razaTmp);
            }

        } catch (SQLException e) {
            out.println("Error" + e.toString());
        }
        return razaArray;
    }

}
