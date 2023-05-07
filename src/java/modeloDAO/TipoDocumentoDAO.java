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
import modeloVO.TipoDocumentoVO;
import util.ConexionBD;
import util.InterfaceCR;

/**
 *
 * @author master
 */
public class TipoDocumentoDAO extends ConexionBD implements InterfaceCR {

    private Connection conection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    private String query = null;
    private boolean operacion = false;

    private String idTipoDocu = "", tipoDocu = "";

    public TipoDocumentoDAO() {
        super();
        try {
            conection = this.obtenerConexion();
            statement = conection.createStatement();

        } catch (SQLException e) {
            out.println("Error" + e.toString());
        }
    }

    public TipoDocumentoDAO(TipoDocumentoVO tipoDocVO) {
        super();
        try {
            conection = this.obtenerConexion();
            statement = conection.createStatement();

            idTipoDocu = tipoDocVO.getIdTipoDocu();
            tipoDocu = tipoDocVO.getTipoDocu();
        } catch (SQLException e) {
            out.println("Error" + e.toString());
        }
    }

    @Override
    public boolean agregarRegistro() {
        try {
            query = "INSERT INTO `TipoDocumento` (`idTipoDocu`, `tipoDocu`) VALUES (NULL, '" + tipoDocu + "')";
            statement.executeUpdate(query);
            operacion = true;
        } catch (SQLException e) {
            out.println("Error al agregar el tipo de documento  " + e.toString());
        }
        return operacion;
    }

    @Override
    public ArrayList consultarRegistro() {
        ArrayList<TipoDocumentoVO> tipoDocumentoArray = new ArrayList<>();
        try {

            query = "SELECT * FROM `TipoDocumento` WHERE idTipoDocu = " + idTipoDocu;

            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                TipoDocumentoVO tipoDocumentoTmp = new TipoDocumentoVO();

                tipoDocumentoTmp.setIdTipoDocu(resultSet.getString(1));
                tipoDocumentoTmp.setTipoDocu(resultSet.getString(2));

                tipoDocumentoArray.add(tipoDocumentoTmp);
            }
        } catch (SQLException e) {
            out.println("Error al consultar el tipo de documento  " + e.toString());
        }
        return tipoDocumentoArray;
    }

    @Override
    public ArrayList consultarGeneral() {
        ArrayList<TipoDocumentoVO> tiposDocumentosArray = new ArrayList<>();
        try {

            query = "SELECT * FROM `TipoDocumento`";

            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                TipoDocumentoVO tipoDocumentoTmp = new TipoDocumentoVO();

                tipoDocumentoTmp.setIdTipoDocu(resultSet.getString(1));
                tipoDocumentoTmp.setTipoDocu(resultSet.getString(2));

                tiposDocumentosArray.add(tipoDocumentoTmp);
            }
        } catch (SQLException e) {
            out.println("Error al consultar los tipos de documentos  " + e.toString());
        }
        return tiposDocumentosArray;
    }

}
