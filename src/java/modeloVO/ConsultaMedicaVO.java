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
public class ConsultaMedicaVO {

    private String idConsulta, motivoConsulta, fechaConsulta, descripcionConsulta, peso, estado, fkHistoriaClinica;

    public ConsultaMedicaVO() {
    }

    public ConsultaMedicaVO(String idConsulta, String motivoConsulta, String fechaConsulta, String descripcionConsulta, String peso, String estado, String fkHistoriaClinica) {
        this.idConsulta = idConsulta;
        this.motivoConsulta = motivoConsulta;
        this.fechaConsulta = fechaConsulta;
        this.descripcionConsulta = descripcionConsulta;
        this.peso = peso;
        this.estado = estado;
        this.fkHistoriaClinica = fkHistoriaClinica;
    }

    public String getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(String idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(String fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public String getDescripcionConsulta() {
        return descripcionConsulta;
    }

    public void setDescripcionConsulta(String descripcionConsulta) {
        this.descripcionConsulta = descripcionConsulta;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFkHistoriaClinica() {
        return fkHistoriaClinica;
    }

    public void setFkHistoriaClinica(String fkHistoriaClinica) {
        this.fkHistoriaClinica = fkHistoriaClinica;
    }

    @Override
    public String toString() {
        return "ConsultaMedicaVO{" + "idConsulta=" + idConsulta + ", motivoConsulta=" + motivoConsulta + ", fechaConsulta=" + fechaConsulta + ", descripcionConsulta=" + descripcionConsulta + ", peso=" + peso + ", estado=" + estado + ", fkHistoriaClinica=" + fkHistoriaClinica + '}';
    }

}
