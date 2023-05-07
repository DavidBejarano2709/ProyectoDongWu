/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloVO;

/**
 *
 * @author master
 */
public class VacunaVO {

    private String idVacuna, tipoVacuna;

    public VacunaVO() {
    }

    public VacunaVO(String idVacuna, String tipoVacuna) {
        this.idVacuna = idVacuna;
        this.tipoVacuna = tipoVacuna;
    }

    public String getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(String idVacuna) {
        this.idVacuna = idVacuna;
    }

    public String getTipoVacuna() {
        return tipoVacuna;
    }

    public void setTipoVacuna(String tipoVacuna) {
        this.tipoVacuna = tipoVacuna;
    }

    @Override
    public String toString() {
        return "VacunaVO{" + "idVacuna=" + idVacuna + ", tipoVacuna=" + tipoVacuna + '}';
    }

}
