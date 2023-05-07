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
public class UsuarioVO {

    private String idUsuario, cedula, nombreUsuario, apellidoUsuario, contraseñaUsuario, direccion, celular, telefonoFijo, correoUsuario, estadoUsuario, fkTipoDocu, fkRol, fkGenero;

    public UsuarioVO() {
    }

    public UsuarioVO(String idUsuario, String cedula, String nombreUsuario, String apellidoUsuario, String contraseñaUsuario, String direccion, String celular, String telefonoFijo, String correoUsuario, String estadoUsuario, String fkTipoDocu, String fkRol, String fkGenero) {
        this.idUsuario = idUsuario;
        this.cedula = cedula;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.contraseñaUsuario = contraseñaUsuario;
        this.direccion = direccion;
        this.celular = celular;
        this.telefonoFijo = telefonoFijo;
        this.correoUsuario = correoUsuario;
        this.estadoUsuario = estadoUsuario;
        this.fkTipoDocu = fkTipoDocu;
        this.fkRol = fkRol;
        this.fkGenero = fkGenero;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getContraseñaUsuario() {
        return contraseñaUsuario;
    }

    public void setContraseñaUsuario(String contraseñaUsuario) {
        this.contraseñaUsuario = contraseñaUsuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getFkTipoDocu() {
        return fkTipoDocu;
    }

    public void setFkTipoDocu(String fkTipoDocu) {
        this.fkTipoDocu = fkTipoDocu;
    }

    public String getFkRol() {
        return fkRol;
    }

    public void setFkRol(String fkRol) {
        this.fkRol = fkRol;
    }

    public String getFkGenero() {
        return fkGenero;
    }

    public void setFkGenero(String fkGenero) {
        this.fkGenero = fkGenero;
    }

    @Override
    public String toString() {
        return "UsuarioVO{" + "idUsuario=" + idUsuario + ", cedula=" + cedula + ", nombreUsuario=" + nombreUsuario + ", apellidoUsuario=" + apellidoUsuario + ", contrase\u00f1aUsuario=" + contraseñaUsuario + ", direccion=" + direccion + ", celular=" + celular + ", telefonoFijo=" + telefonoFijo + ", correoUsuario=" + correoUsuario + ", estadoUsuario=" + estadoUsuario + ", fkTipoDocu=" + fkTipoDocu + ", fkRol=" + fkRol + ", fkGenero=" + fkGenero + '}';
    }
    
}
