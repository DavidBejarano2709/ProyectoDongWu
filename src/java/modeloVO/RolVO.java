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
public class RolVO {
    
    private String idRol;
    private String tipoRol;

    public RolVO() {
    }

    public RolVO(String idRol, String tipoRol) {
        this.idRol = idRol;
        this.tipoRol = tipoRol;
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public String getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(String tipoRol) {
        this.tipoRol = tipoRol;
    }

    @Override
    public String toString() {
        return "RolVO{" + "idRol=" + idRol + ", tipoRol=" + tipoRol + '}';
    }
    
    
    
}
