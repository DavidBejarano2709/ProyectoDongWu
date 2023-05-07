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
public class RazaVO {
    
    private String idRaza;
    private String tipoRaza;
    private String fkEspecie;

    public RazaVO() {
    }

    public RazaVO(String idRaza, String tipoRaza, String fkEspecie) {
        this.idRaza = idRaza;
        this.tipoRaza = tipoRaza;
        this.fkEspecie = fkEspecie;
    }

    public String getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(String idRaza) {
        this.idRaza = idRaza;
    }

    public String getTipoRaza() {
        return tipoRaza;
    }

    public void setTipoRaza(String tipoRaza) {
        this.tipoRaza = tipoRaza;
    }

    public String getFkEspecie() {
        return fkEspecie;
    }

    public void setFkEspecie(String fkEspecie) {
        this.fkEspecie = fkEspecie;
    }

    @Override
    public String toString() {
        return "RazaVO{" + "idRaza=" + idRaza + ", tipoRaza=" + tipoRaza + ", fkEspecie=" + fkEspecie + '}';
    }
   
}
