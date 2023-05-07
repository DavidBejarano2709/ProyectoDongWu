/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloVO;

public class ExamenVO {

    private String idExamen;
    private String tipoExamen;

    public ExamenVO() {
    }

    public ExamenVO(String idExamen, String tipoExamen) {
        this.idExamen = idExamen;
        this.tipoExamen = tipoExamen;
    }

    public String getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(String idExamen) {
        this.idExamen = idExamen;
    }

    public String getTipoExamen() {
        return tipoExamen;
    }

    public void setTipoExamen(String tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

}
