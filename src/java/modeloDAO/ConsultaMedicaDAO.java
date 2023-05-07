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
import modeloVO.ConsultaMedicaVO;
import util.ConexionBD;
import util.InterfaceCrud;

/**
 *
 * @author master
 */
public class ConsultaMedicaDAO extends ConexionBD implements InterfaceCrud {

    private Connection conection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    private String query = null;
    private boolean operacion = false;

    private String idConsulta="", motivoConsulta="", fechaConsulta="", descripcionConsulta="", peso="", estado="", fkHistoriaClinica="";

    public ConsultaMedicaDAO(ConsultaMedicaVO conMedicaVO) {
        super();
        try {
            conection = this.obtenerConexion();
            statement = conection.createStatement();

            idConsulta = conMedicaVO.getIdConsulta();
            motivoConsulta = conMedicaVO.getMotivoConsulta();
            fechaConsulta = conMedicaVO.getFechaConsulta();
            descripcionConsulta = conMedicaVO.getDescripcionConsulta();
            peso = conMedicaVO.getPeso();
            estado = conMedicaVO.getEstado();
            fkHistoriaClinica = conMedicaVO.getFkHistoriaClinica();
        } catch (SQLException e) {
            out.println("Error" + e.toString());
        }

    }

    @Override
    public boolean agregarRegistro() {
        try {
            query = "INSERT INTO `ConsultaMedica` (`idConsulta`, `motivoConsulta`, `descripcionConsulta`, `peso`, `estado`, `fkHistoriaClinica`) VALUES (NULL, '" + motivoConsulta + "', '" + descripcionConsulta + "', '" + peso + "', '1', '" + fkHistoriaClinica + "')";
            statement.executeUpdate(query);
            operacion = true;
        } catch (SQLException e) {
            out.println("Error al registrar Consulta Medica " + e.toString());
        }
        return operacion;
    }

    @Override
    public ArrayList consultarRegistro() {
        
        ArrayList<ConsultaMedicaVO> consultaArray = new ArrayList<>();
        try {
            query = "SELECT * FROM ConsultaMedica WHERE fkHistoriaClinica = " + fkHistoriaClinica;
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                ConsultaMedicaVO consultaTmp = new ConsultaMedicaVO();

                consultaTmp.setIdConsulta(resultSet.getString(1));
                consultaTmp.setMotivoConsulta(resultSet.getString(2));
                consultaTmp.setFechaConsulta(resultSet.getString(3));
                consultaTmp.setDescripcionConsulta(resultSet.getString(4));
                consultaTmp.setPeso(resultSet.getString(5));
                consultaTmp.setEstado(resultSet.getString(6));
                consultaTmp.setFkHistoriaClinica(resultSet.getString(7));

                consultaArray.add(consultaTmp);
            }

        } catch (SQLException e) {
            out.println("Error al consultar Consulta Medica " + e.toString());
        }
        return consultaArray;
    }

    @Override
    public ArrayList consultarGeneral() {
        ArrayList<ConsultaMedicaVO> consultaArray = new ArrayList<>();
        try {
            query = "SELECT * FROM ConsultaMedica";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                ConsultaMedicaVO consultaTmp = new ConsultaMedicaVO();

                consultaTmp.setIdConsulta(resultSet.getString(1));
                consultaTmp.setMotivoConsulta(resultSet.getString(2));
                consultaTmp.setFechaConsulta(resultSet.getString(3));
                consultaTmp.setDescripcionConsulta(resultSet.getString(4));
                consultaTmp.setPeso(resultSet.getString(5));
                consultaTmp.setEstado(resultSet.getString(6));
                consultaTmp.setFkHistoriaClinica(resultSet.getString(7));

                consultaArray.add(consultaTmp);
            }

        } catch (SQLException e) {
            out.println("Error al consultar Consultas Medicas " + e.toString());
        }
        return consultaArray;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            query = "UPDATE `ConsultaMedica` SET `motivoConsulta` = '" + motivoConsulta + "', `fechaConsulta` = '" + fechaConsulta + "', `descripcionConsulta` = '" + descripcionConsulta + "', `peso` = '" + peso + "' WHERE `ConsultaMedica`.`idConsulta` = " + idConsulta + "";
            statement.execute(query);
            operacion = true;
        } catch (SQLException e) {
            out.println("Error al actualizar Consulta Medica " + e.toString());
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro() {
        try {
            query = "UPDATE `ConsultaMedica` SET `estado` = '0' WHERE `ConsultaMedica`.`idConsulta` = " + idConsulta + "";
            statement.executeUpdate(query);
            operacion = true;
        } catch (SQLException e) {
            out.println("Error al eliminar Consulta Medica " + e.toString());
        }
        return operacion;
    }

}
