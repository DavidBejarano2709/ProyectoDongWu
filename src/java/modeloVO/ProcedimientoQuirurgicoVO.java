/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloVO;

/**
 *
 * @author Usuario
 */
public class ProcedimientoQuirurgicoVO {
    
    private String idProcedimientoQuirurgico;
    private String tipoPorcedimientoQuirurgico;

    public ProcedimientoQuirurgicoVO() {
    }

    public ProcedimientoQuirurgicoVO(String idProcedimientoQuirurgico, String tipoPorcedimientoQuirurgico) {
        this.idProcedimientoQuirurgico = idProcedimientoQuirurgico;
        this.tipoPorcedimientoQuirurgico = tipoPorcedimientoQuirurgico;
    }

    public String getIdProcedimientoQuirurgico() {
        return idProcedimientoQuirurgico;
    }

    public void setIdProcedimientoQuirurgico(String idProcedimientoQuirurgico) {
        this.idProcedimientoQuirurgico = idProcedimientoQuirurgico;
    }

    public String getTipoPorcedimientoQuirurgico() {
        return tipoPorcedimientoQuirurgico;
    }

    public void setTipoPorcedimientoQuirurgico(String tipoPorcedimientoQuirurgico) {
        this.tipoPorcedimientoQuirurgico = tipoPorcedimientoQuirurgico;
    }

    @Override
    public String toString() {
        return "ProcedimientoQuirurgicoVO{" + "idProcedimientoQuirurgico=" + idProcedimientoQuirurgico + ", tipoPorcedimientoQuirurgico=" + tipoPorcedimientoQuirurgico + '}';
    }
    
    
    
}
