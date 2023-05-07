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
import modeloVO.MascotaVO;
import util.ConexionBD;
import util.InterfaceCrud;

/**
 *
 * @author Usuario
 */
public class MascotaDAO extends ConexionBD implements InterfaceCrud {

    private Connection conection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    private String query = null;
    private boolean operacion = false;

    private String idMascota = "";
    private String nombreMascota = "";
    private String fechaNacimiento = "";
    private String fkUsuario = "";
    private String fkRaza = "";
    private String fkGenero = "";
    private String colorMascota = "";

    public MascotaDAO(MascotaVO mascotaVO) {
        super();

        try {
            conection = this.obtenerConexion();
            statement = conection.createStatement();

            idMascota = mascotaVO.getIdMascota();
            nombreMascota = mascotaVO.getNombreMascota();
            fechaNacimiento = mascotaVO.getFechaNacimiento();
            fkUsuario = mascotaVO.getFkUsuario();
            fkRaza = mascotaVO.getFkRaza();
            fkGenero = mascotaVO.getFkGenero();
            colorMascota = mascotaVO.getColorMascota();

        } catch (SQLException e) {
            out.println("Error" + e.toString());
        }

    }

    @Override
    public boolean agregarRegistro() {
        try {
            query = "insert into Mascota (NombreMascota, FechaNacimiento, fkUsuario, fkRaza, fkGenero, ColorMascota,estadoMascota)"
                    + "values('" + nombreMascota + "','" + fechaNacimiento + "','" + fkUsuario + "','" + fkRaza + "','" + fkGenero + "','" + colorMascota + "',1);";
            statement.executeUpdate(query);
            operacion = true;
        } catch (SQLException e) {
            out.println("Error" + e.toString());
        }
        return operacion;
    }

    @Override
    public ArrayList<MascotaVO> consultarRegistro() {
        ArrayList<MascotaVO> mascotArray = new ArrayList<>();
        try {
            query = "select * from mascotaUsuario where fkUsuario='" + fkUsuario + "';";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {

                MascotaVO mascotaTemp = new MascotaVO();

                mascotaTemp.setIdMascota(resultSet.getString(1));
                mascotaTemp.setNombreMascota(resultSet.getString(2));
                mascotaTemp.setFechaNacimiento(resultSet.getString(3));
                mascotaTemp.setFkUsuario(resultSet.getString(4));
                mascotaTemp.setFkRaza(resultSet.getString(5));
                mascotaTemp.setFkGenero(resultSet.getString(6));
                mascotaTemp.setColorMascota(resultSet.getString(7));
                mascotaTemp.setEstadoMascota(resultSet.getString(8));
                //System.out.println(mascotaTemp);
                mascotArray.add(mascotaTemp);
            }
        } catch (SQLException e) {
            out.println("Error" + e.toString());
        }
        return mascotArray;
    }

    public ArrayList<MascotaVO> consultarRegistroPorId() {
        ArrayList<MascotaVO> mascotArray = new ArrayList<>();
        try {
            query = "select * from mascotaUsuario where idMascota='" + idMascota + "';";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {

                MascotaVO mascotaTemp = new MascotaVO();

                mascotaTemp.setIdMascota(resultSet.getString(1));
                mascotaTemp.setNombreMascota(resultSet.getString(2));
                mascotaTemp.setFechaNacimiento(resultSet.getString(3));
                mascotaTemp.setFkUsuario(resultSet.getString(4));
                mascotaTemp.setFkRaza(resultSet.getString(5));
                mascotaTemp.setFkGenero(resultSet.getString(6));
                mascotaTemp.setColorMascota(resultSet.getString(7));
                mascotaTemp.setEstadoMascota(resultSet.getString(8));
                //System.out.println(mascotaTemp);
                mascotArray.add(mascotaTemp);
            }
        } catch (SQLException e) {
            out.println("Error" + e.toString());
        }
        return mascotArray;
    }

    //Este Metodo no se usa.
    @Override
    public boolean actualizarRegistro() {

        try {
            query = "update mascota set nombreMascota='" + nombreMascota + "',fechaNacimiento='" + fechaNacimiento + "',"
                    + "fkUsuario=´" + fkRaza + "',fkGenero='" + fkGenero + "',ColorMascota='" + colorMascota + "';";
            statement.executeUpdate(query);
            operacion = true;
        } catch (SQLException e) {
            out.println("Error" + e.toString());
        }

        return operacion;
    }

    @Override
    public boolean eliminarRegistro() {
        try {
            query = "UPDATE `Mascota` SET `estadoMascota` = '0' WHERE `Mascota`.`idMascota` = " + idMascota;
            statement.executeUpdate(query);
            operacion = true;
        } catch (SQLException e) {
            out.println("Error" + e.toString());
        }
        return operacion;
    }

    @Override
    public ArrayList consultarGeneral() {
        ArrayList<MascotaVO> mascotArray = new ArrayList<>();
        try {
            query = "select * from listarMascota;";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {

                MascotaVO mascotaTemp = new MascotaVO();

                mascotaTemp.setIdMascota(resultSet.getString(1));
                mascotaTemp.setNombreMascota(resultSet.getString(2));
                mascotaTemp.setFechaNacimiento(resultSet.getString(3));
                mascotaTemp.setFkUsuario(resultSet.getString(4));
                mascotaTemp.setFkRaza(resultSet.getString(5));
                mascotaTemp.setFkGenero(resultSet.getString(6));
                mascotaTemp.setColorMascota(resultSet.getString(7));
                mascotaTemp.setEstadoMascota(resultSet.getString(8));
                //System.out.println(mascotaTemp);
                mascotArray.add(mascotaTemp);
            }
        } catch (SQLException e) {
            out.println("Error" + e.toString());
        }
        return mascotArray;
    }

//    public static void main(String[] args) {
//        MascotaVO mascotaVO = new MascotaVO("1", "Max", "2020-02-11", "1", "1", "1", "Negro", null);
//        MascotaDAO mascotaDAO = new MascotaDAO(mascotaVO);
//        System.out.println(mascotaDAO.consultarGeneral());
//    }
}
