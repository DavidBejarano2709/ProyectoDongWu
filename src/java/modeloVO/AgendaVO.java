/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloVO;

public class AgendaVO {

    private String idAgenda;
    private String fechaAgenda;
    private String fkServicio;
    private String fkMascota;
    private String fkEstadoAgenda;

    public AgendaVO() {
    }

    public AgendaVO(String idAgenda, String fechaAgenda, String fkServicio, String fkMascota, String fkEstadoAgenda) {
        this.idAgenda = idAgenda;
        this.fechaAgenda = fechaAgenda;
        this.fkServicio = fkServicio;
        this.fkMascota = fkMascota;
        this.fkEstadoAgenda = fkEstadoAgenda;
    }

    public String getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(String idAgenda) {
        this.idAgenda = idAgenda;
    }

    public String getFechaAgenda() {
        return fechaAgenda;
    }

    public void setFechaAgenda(String fechaAgenda) {
        this.fechaAgenda = fechaAgenda;
    }

    public String getFkServicio() {
        return fkServicio;
    }

    public void setFkServicio(String fkServicio) {
        this.fkServicio = fkServicio;
    }

    public String getFkMascota() {
        return fkMascota;
    }

    public void setFkMascota(String fkMascota) {
        this.fkMascota = fkMascota;
    }

    public String getFkEstadoAgenda() {
        return fkEstadoAgenda;
    }

    public void setFkEstadoAgenda(String fkEstadoAgenda) {
        this.fkEstadoAgenda = fkEstadoAgenda;
    }

    @Override
    public String toString() {
        return "AgendaVO{" + "idAgenda=" + idAgenda + ", fechaAgenda=" + fechaAgenda + ", fkServicio=" + fkServicio + ", fkMascota=" + fkMascota + ", fkEstadoAgenda=" + fkEstadoAgenda + '}';
    }

}
