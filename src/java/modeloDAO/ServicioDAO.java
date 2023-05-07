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
import modeloVO.ServicioVO;
import util.ConexionBD;
import util.InterfaceCR;

/**
 *
 * @author master
 */
public class ServicioDAO extends ConexionBD implements InterfaceCR {

    private Connection conection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    private String query = null;
    private boolean operacion = false;

    private String idServicio = "", descripcionServicio = "";

    public ServicioDAO() {
        super();
        try {
            conection = this.obtenerConexion();
            statement = conection.createStatement();

        } catch (SQLException e) {
            out.println("Error" + e.toString());
        }
    }

    public ServicioDAO(ServicioVO servicioVO) {
        super();
        try {
            conection = this.obtenerConexion();
            statement = conection.createStatement();

            idServicio = servicioVO.getIdServicio();
            descripcionServicio = servicioVO.getDescripcionServicio();

        } catch (SQLException e) {
            out.println("Error" + e.toString());
        }
    }

    @Override
    public boolean agregarRegistro() {
        try {
            query = "INSERT INTO `Servicio` (`idServicio`, `descripcionServicio`) VALUES (NULL, '" + descripcionServicio + "')";
            statement.executeUpdate(query);
            operacion = true;
        } catch (SQLException e) {
            out.println("Error al agregar un servicio " + e.toString());
        }
        return operacion;
    }

    @Override
    public ArrayList consultarRegistro() {
        ArrayList<ServicioVO> servicioArray = new ArrayList<>();
        try {

            query = "SELECT * FROM `Servicio` WHERE idServicio = " + idServicio;

            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                ServicioVO servicioTmp = new ServicioVO();

                servicioTmp.setIdServicio(resultSet.getString(1));
                servicioTmp.setDescripcionServicio(resultSet.getString(2));

                servicioArray.add(servicioTmp);
            }
        } catch (SQLException e) {
            out.println("Error al consultar servicio " + e.toString());
        }
        return servicioArray;
    }

    @Override
    public ArrayList consultarGeneral() {
        ArrayList<ServicioVO> serviciosArray = new ArrayList<>();
        try {

            query = "SELECT * FROM `Servicio`";

            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                ServicioVO servicioTmp = new ServicioVO();

                servicioTmp.setIdServicio(resultSet.getString(1));
                servicioTmp.setDescripcionServicio(resultSet.getString(2));

                serviciosArray.add(servicioTmp);
            }
        } catch (SQLException e) {
            out.println("Error al consultar servicios " + e.toString());
        }
        return serviciosArray;
    }

}
