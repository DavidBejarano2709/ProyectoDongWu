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
import modeloVO.ProcedimientoQuirurgicoVO;
import util.ConexionBD;
import util.InterfaceCR;

/**
 *
 * @author Usuario
 */
public class ProcedimientoQuirurgicoDAO extends ConexionBD implements InterfaceCR{
    
    private Connection conection=null;
    private Statement statement=null;
    private ResultSet resultSet=null;
    
    private String query =null;
    private boolean operacion=false;
    
    private String idProcedimientoQuirurgico="";
    private String tipoProcedimientoQuirurgico="";

    public ProcedimientoQuirurgicoDAO(ProcedimientoQuirurgicoVO procedimientoQuirurgicoVO) {
        
        super();
        
        try {
            conection=this.obtenerConexion();
            statement=conection.createStatement();
            
            idProcedimientoQuirurgico=procedimientoQuirurgicoVO.getIdProcedimientoQuirurgico();
            tipoProcedimientoQuirurgico=procedimientoQuirurgicoVO.getTipoPorcedimientoQuirurgico();
            
        } catch (SQLException e) {
            
            out.println("Error"+e.toString());
        }
        
    }

    @Override
    public boolean agregarRegistro() {
        try {
            query="insert into procedimientoquirurgico (tipoProcedimientoQuirurgico)"
                    +"values '"+tipoProcedimientoQuirurgico+"';";
            statement.executeUpdate(query);
            operacion=true;
        } catch (SQLException e) {
            out.println("Error"+e.toString());
        }
        return operacion;
    }

    @Override
    public ArrayList<ProcedimientoQuirurgicoVO> consultarRegistro() {
        ArrayList<ProcedimientoQuirurgicoVO> proceArray=new ArrayList<>();
        
        try {
            query="select * from procedimientoQuirurgico where idProcedimientoQuirurgico='"+idProcedimientoQuirurgico+"';";
            resultSet=statement.executeQuery(query);
            
            ProcedimientoQuirurgicoVO proceTmp=new ProcedimientoQuirurgicoVO();
            
            proceTmp.setIdProcedimientoQuirurgico(resultSet.getString(1));
            proceTmp.setTipoPorcedimientoQuirurgico(resultSet.getString(2));
            proceArray.add(proceTmp);
            
            
        } catch (SQLException e) {
            out.println("Error"+e.toString());
        }
        return proceArray;
    }

    @Override
    public ArrayList consultarGeneral() {
        ArrayList<ProcedimientoQuirurgicoVO> proceArray=new ArrayList<>();
        
        try {
            query="select * from procedimientoQuirurgico;";
            resultSet=statement.executeQuery(query);
            
            ProcedimientoQuirurgicoVO proceTmp=new ProcedimientoQuirurgicoVO();
            
            proceTmp.setIdProcedimientoQuirurgico(resultSet.getString(1));
            proceTmp.setTipoPorcedimientoQuirurgico(resultSet.getString(2));
            proceArray.add(proceTmp);
            
            
        } catch (SQLException e) {
            out.println("Error"+e.toString());
        }
        return proceArray;
    }
    
}
