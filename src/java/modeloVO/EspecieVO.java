/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloVO;

public class EspecieVO {

    private String idEspecie;
    private String tipoEspecie;

    public EspecieVO(String idEspecie, String tipoEspecie) {
        this.idEspecie = idEspecie;
        this.tipoEspecie = tipoEspecie;
    }

    public EspecieVO() {
    }

    public String getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(String idEspecie) {
        this.idEspecie = idEspecie;
    }

    public String getTipoEspecie() {
        return tipoEspecie;
    }

    public void setTipoEspecie(String tipoEspecie) {
        this.tipoEspecie = tipoEspecie;
    }

}
