/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloVO;

public class GeneroVO {

    private String idGenero;
    private String tipoSexo;

    public GeneroVO() {
    }

    public GeneroVO(String idGenero, String tipoSexo) {
        this.idGenero = idGenero;
        this.tipoSexo = tipoSexo;
    }

    public String getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(String idGenero) {
        this.idGenero = idGenero;
    }

    public String getTipoSexo() {
        return tipoSexo;
    }

    public void setTipoSexo(String tipoSexo) {
        this.tipoSexo = tipoSexo;
    }

    @Override
    public String toString() {
        return "GeneroVO{" + "idGenero=" + idGenero + ", tipoSexo=" + tipoSexo + '}';
    }
    

}
