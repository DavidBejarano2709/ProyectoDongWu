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
public class MascotaVO {

    private String idMascota;
    private String nombreMascota;
    private String fechaNacimiento;
    private String fkUsuario;
    private String fkRaza;
    private String fkGenero;
    private String colorMascota;
    private String estadoMascota;

    public MascotaVO() {
    }

    public MascotaVO(String idMascota, String nombreMascota, String fechaNacimiento, String fkIdUsuario, String fkIdRaza, String fkIdGenero, String colorMascota, String estadoMascota) {
        this.idMascota = idMascota;
        this.nombreMascota = nombreMascota;
        this.fechaNacimiento = fechaNacimiento;
        this.fkUsuario = fkIdUsuario;
        this.fkRaza = fkIdRaza;
        this.fkGenero = fkIdGenero;
        this.colorMascota = colorMascota;
        this.estadoMascota = estadoMascota;
    }

    public String getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(String idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(String fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public String getFkRaza() {
        return fkRaza;
    }

    public void setFkRaza(String fkRaza) {
        this.fkRaza = fkRaza;
    }

    public String getFkGenero() {
        return fkGenero;
    }

    public void setFkGenero(String fkGenero) {
        this.fkGenero = fkGenero;
    }

    public String getColorMascota() {
        return colorMascota;
    }

    public void setColorMascota(String colorMascota) {
        this.colorMascota = colorMascota;
    }

    public String getEstadoMascota() {
        return estadoMascota;
    }

    public void setEstadoMascota(String estadoMascota) {
        this.estadoMascota = estadoMascota;
    }

    @Override
    public String toString() {
        return "MascotaVO{" + "idMascota=" + idMascota + ", nombreMascota=" + nombreMascota + ", fechaNacimiento=" + fechaNacimiento + ", fkUsuario=" + fkUsuario + ", fkRaza=" + fkRaza + ", fkGenero=" + fkGenero + ", colorMascota=" + colorMascota + ", estadoMascota=" + estadoMascota + '}';
    }

}
