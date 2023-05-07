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
public class ServicioVO {
    private String idServicio,descripcionServicio;

    public ServicioVO() {
    }

    public ServicioVO(String idServicio, String descripcionServicio) {
        this.idServicio = idServicio;
        this.descripcionServicio = descripcionServicio;
    }

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    @Override
    public String toString() {
        return "ServicioVO{" + "idServicio=" + idServicio + ", descripcionServicio=" + descripcionServicio + '}';
    }
    
    
    
}
