/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloVO;

public class HistoriaClinicaVO {

    private String idHistoriaClinica;
    private String fechaApertura;
    private String fkMascota;

    public HistoriaClinicaVO() {
    }

    public HistoriaClinicaVO(String idHistoriaClinica, String fechaApertura, String fkMascota) {
        this.idHistoriaClinica = idHistoriaClinica;
        this.fechaApertura = fechaApertura;
        this.fkMascota = fkMascota;
    }

    public String getIdHistoriaClinica() {
        return idHistoriaClinica;
    }

    public void setIdHistoriaClinica(String idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getFkMascota() {
        return fkMascota;
    }

    public void setFkMascota(String fkMascota) {
        this.fkMascota = fkMascota;
    }

    @Override
    public String toString() {
        return "HistoriaClinicaVO{" + "idHistoriaClinica=" + idHistoriaClinica + ", fechaApertura=" + fechaApertura + ", fkMascota=" + fkMascota + '}';
    }

}
