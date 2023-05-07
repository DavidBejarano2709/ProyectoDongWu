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
import modeloVO.UsuarioVO;
import util.ConexionBD;
import util.InterfaceCrud;

/**
 *
 * @author master
 */
public class UsuarioDAO extends ConexionBD implements InterfaceCrud {

    private Connection conection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    private String query = null;
    private boolean operacion = false;

    private String idUsuario = "", cedula = "", nombreUsuario = "", apellidoUsuario = "", contraseñaUsuario = "", direccion = "", celular = "", telefonoFijo = "", correoUsuario = "", estadoUsuario = "", fkTipoDocu = "", fkRol = "", fkGenero = "";

    public UsuarioDAO() {
        super();
        try {
            conection = this.obtenerConexion();
            statement = conection.createStatement();
        } catch (SQLException e) {
            out.println("Error" + e.toString());
        }
    }

    public UsuarioDAO(UsuarioVO usuVO) {
        super();
        try {
            conection = this.obtenerConexion();
            statement = conection.createStatement();

            idUsuario = usuVO.getIdUsuario();
            cedula = usuVO.getCedula();
            nombreUsuario = usuVO.getNombreUsuario();
            apellidoUsuario = usuVO.getApellidoUsuario();
            contraseñaUsuario = usuVO.getContraseñaUsuario();
            direccion = usuVO.getDireccion();
            celular = usuVO.getCelular();
            telefonoFijo = usuVO.getTelefonoFijo();
            correoUsuario = usuVO.getCorreoUsuario();
            estadoUsuario = usuVO.getEstadoUsuario();
            fkTipoDocu = usuVO.getFkTipoDocu();
            fkRol = usuVO.getFkRol();
            fkGenero = usuVO.getFkGenero();

        } catch (SQLException e) {
            out.println("Error" + e.toString());
        }
    }

    @Override
    public boolean agregarRegistro() {
        try {
            query = "INSERT INTO `Usuario` (`idUsuario`, `cedula`, `nombreUsuario`, `apellidoUsuario`, `contraseñaUsuario`, `correoUsuario`, `estadoUsuario`, `fkTipoDocu`, `fkRol`,`direcciòn`,`celular`,`telefonoFijo`) VALUES (NULL, '" + cedula + "', '" + nombreUsuario + "', '" + apellidoUsuario + "', '" + contraseñaUsuario + "', '" + correoUsuario + "', '1', '" + fkTipoDocu + "', '2','Direcciòn','Celular','Telefono')";
            statement.executeUpdate(query);
            operacion = true;
        } catch (SQLException e) {
            out.println("Error al registrar Usuario " + e.toString());
        }
        return operacion;
    }

    @Override
    public ArrayList<UsuarioVO> consultarRegistro() {

        ArrayList<UsuarioVO> usuArray = new ArrayList<>();
        try {
            if (cedula != null) {
                query = "SELECT * FROM Usuario WHERE Cedula = '" + cedula + "'";
            } else {
                query = "SELECT * FROM Usuario WHERE correoUsuario = '" + correoUsuario + "'";
            }

            resultSet = statement.executeQuery(query);
            if (resultSet.first()) {
                UsuarioVO usuarioTmp = new UsuarioVO();

                usuarioTmp.setIdUsuario(resultSet.getString(1));
                usuarioTmp.setCedula(resultSet.getString(2));
                usuarioTmp.setNombreUsuario(resultSet.getString(3));
                usuarioTmp.setApellidoUsuario(resultSet.getString(4));
                usuarioTmp.setContraseñaUsuario(resultSet.getString(5));
                usuarioTmp.setDireccion(resultSet.getString(6));
                usuarioTmp.setCelular(resultSet.getString(7));
                usuarioTmp.setTelefonoFijo(resultSet.getString(8));
                usuarioTmp.setCorreoUsuario(resultSet.getString(9));
                usuarioTmp.setEstadoUsuario(resultSet.getString(10));
                usuarioTmp.setFkTipoDocu(resultSet.getString(11));
                usuarioTmp.setFkRol(resultSet.getString(12));
                usuarioTmp.setFkGenero(resultSet.getString(13));

                usuArray.add(usuarioTmp);

            }
            this.cerrarConexion();
        } catch (SQLException e) {
            out.println("Error al consultar Usuario " + e.toString());
        }
        return usuArray;
    }

    @Override
    public ArrayList consultarGeneral() {
        ArrayList<UsuarioVO> usuArray = new ArrayList<>();
        try {
            query = "SELECT * FROM Usuario";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                UsuarioVO usuarioTmp = new UsuarioVO();

                usuarioTmp.setIdUsuario(resultSet.getString(1));
                usuarioTmp.setCedula(resultSet.getString(2));
                usuarioTmp.setNombreUsuario(resultSet.getString(3));
                usuarioTmp.setApellidoUsuario(resultSet.getString(4));
                usuarioTmp.setContraseñaUsuario(resultSet.getString(5));
                usuarioTmp.setDireccion(resultSet.getString(6));
                usuarioTmp.setCelular(resultSet.getString(7));
                usuarioTmp.setTelefonoFijo(resultSet.getString(8));
                usuarioTmp.setCorreoUsuario(resultSet.getString(9));
                usuarioTmp.setEstadoUsuario(resultSet.getString(10));
                usuarioTmp.setFkTipoDocu(resultSet.getString(11));
                usuarioTmp.setFkRol(resultSet.getString(12));
                usuarioTmp.setFkGenero(resultSet.getString(13));

                usuArray.add(usuarioTmp);

            }
        } catch (SQLException e) {
            out.println("Error al consultar Usuario " + e.toString());
        }
        return usuArray;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            query = "UPDATE `Usuario` SET `contraseñaUsuario` = '" + contraseñaUsuario + "', `direcciòn` = '" + direccion + "', `celular` = '" + celular + "', `telefonoFijo` = '" + telefonoFijo + "', `correoUsuario` = '" + correoUsuario + "', `fkGenero` = '" + fkGenero + "' WHERE `Usuario`.`idUsuario` = " + idUsuario + "";
            statement.executeUpdate(query);
            operacion = true;
        } catch (SQLException e) {
            out.println("Error al actualizar Usuario " + e.toString());
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro() {
        try {
            query = "UPDATE `Usuario` SET `estadoUsuario` = '0' WHERE `Usuario`.`idUsuario` = " + idUsuario;
            statement.executeUpdate(query);
            operacion = true;
        } catch (SQLException e) {
            out.println("Error al registrar Usuario " + e.toString());
        }
        return operacion;
    }

    public boolean iniciarSesion() {
        try {

            query = "select * from Usuario where cedula = '" + cedula + "' and contraseñaUsuario= '" + contraseñaUsuario + "'";
            resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                operacion = true;

            }

        } catch (SQLException e) {
            out.println("Error" + e.toString());
        }

        return operacion;
    }

   // public static void main(String[] args) {
//        UsuarioVO usuarioVO = new UsuarioVO();
//        //ArrayList<UsuarioVO> usuArray = new ArrayList<>();

//        usuarioVO.setCedula("1032412490");
////        usuarioVO.setNombreUsuario("Alex");
////        usuarioVO.setApellidoUsuario("Silva");
////        usuarioVO.setCorreoUsuario("aaa@gmail.com");
//        usuarioVO.setIdUsuario("3");
//        usuarioVO.setContraseñaUsuario("1234");
//        usuarioVO.setDireccion("calle");
//        usuarioVO.setCelular("305");
//        usuarioVO.setTelefonoFijo("5395914");
//        usuarioVO.setCorreoUsuario("update@gmail.com");
//        usuarioVO.setFkGenero("1");
//        usuarioVO.setFkTipoDocu("1");
//        usuarioVO.setFkRol("1");
//        UsuarioDAO usuarioDAO = new UsuarioDAO();
//        System.out.println(usuarioDAO.consultarGeneral());
//        usuarioDAO.eliminarRegistro();
   // }
}
