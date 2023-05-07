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
import modeloVO.RolVO;
import util.ConexionBD;
import util.InterfaceCR;

/**
 *
 * @author Usuario
 */
public class RolDAO extends ConexionBD implements InterfaceCR {

    private Connection conection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    private String query = null;
    private boolean operacion = false;

    private String idRol = "";
    private String tipoRol = "";

    public RolDAO(RolVO rolVO) {

        super();

        try {
            conection = this.obtenerConexion();
            statement = conection.createStatement();

            idRol = rolVO.getIdRol();
            tipoRol = rolVO.getTipoRol();

        } catch (SQLException e) {
            out.println("Error" + e.toString());
        }
    }

    @Override
    public boolean agregarRegistro() {
        try {
            query = "select into rol (tipoRol) values('" + tipoRol + "')";
            statement.executeLargeUpdate(query);
            operacion = true;
        } catch (SQLException e) {
            out.println("Error" + e.toString());
        }
        return operacion;
    }

    @Override
    public ArrayList<RolVO> consultarRegistro() {
        ArrayList<RolVO> rolArray = new ArrayList<>();

        try {
            query = "select * from rol where idRol='" + idRol + "';";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                RolVO roltmp=new RolVO();
                
                roltmp.setIdRol(resultSet.getString(1));
                roltmp.setTipoRol(resultSet.getString(2));
                
                rolArray.add(roltmp);

            }
        } catch (SQLException e) {
            out.println("Error"+e.toString());
        }
        return rolArray;
    }

    @Override
    public ArrayList consultarGeneral() {
        ArrayList<RolVO> rolArray = new ArrayList<>();

        try {
            query = "select * from rol;";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                RolVO roltmp=new RolVO();
                
                roltmp.setIdRol(resultSet.getString(1));
                roltmp.setTipoRol(resultSet.getString(2));
                
                rolArray.add(roltmp);

            }
        } catch (SQLException e) {
            out.println("Error"+e.toString());
        }
        return rolArray;
    }

}
