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
public class TipoDocumentoVO {

    private String idTipoDocu, tipoDocu;

    public TipoDocumentoVO() {
    }

    public TipoDocumentoVO(String idTipoDocu, String tipoDocu) {
        this.idTipoDocu = idTipoDocu;
        this.tipoDocu = tipoDocu;
    }

    public String getIdTipoDocu() {
        return idTipoDocu;
    }

    public void setIdTipoDocu(String idTipoDocu) {
        this.idTipoDocu = idTipoDocu;
    }

    public String getTipoDocu() {
        return tipoDocu;
    }

    public void setTipoDocu(String tipoDocu) {
        this.tipoDocu = tipoDocu;
    }

    @Override
    public String toString() {
        return "TipoDocumentoVO{" + "idTipoDocu=" + idTipoDocu + ", tipoDocu=" + tipoDocu + '}';
    }

}
