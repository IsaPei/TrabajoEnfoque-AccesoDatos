package data;

import java.time.LocalDateTime;

public class ContratosData {

    private String nif;
    private String adjudicatario;
    private String objetoGenerico;
    private String objeto;
    private LocalDateTime fechaAdjudicacion;
    private Double importe;
    private String tipoContrato;

    public ContratosData(String nif, String adjudicatario, String objetoGenerico, String objeto, LocalDateTime fechaAdjudicacion, Double importe, String tipoContrato) {
        this.nif = nif;
        this.adjudicatario = adjudicatario;
        this.objetoGenerico = objetoGenerico;
        this.objeto = objeto;
        this.fechaAdjudicacion = fechaAdjudicacion;
        this.importe = importe;
        this.tipoContrato = tipoContrato;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getAdjudicatario() {
        return adjudicatario;
    }

    public void setAdjudicatario(String adjudicatario) {
        this.adjudicatario = adjudicatario;
    }

    public String getObjetoGenerico() {
        return objetoGenerico;
    }

    public void setObjetoGenerico(String objetoGenerico) {
        this.objetoGenerico = objetoGenerico;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public LocalDateTime getFechaAdjudicacion() {
        return fechaAdjudicacion;
    }

    public void setFechaAdjudicacion(LocalDateTime fechaAdjudicacion) {
        this.fechaAdjudicacion = fechaAdjudicacion;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    @Override
    public String toString() {
        return "ContratosData{" + "nif=" + nif + ", adjudicatario=" + adjudicatario + ", objetoGenerico=" + objetoGenerico + ", objeto=" + objeto + ", fechaAdjudicacion=" + fechaAdjudicacion + ", importe=" + importe + ", tipoContrato=" + tipoContrato + '}';
    }

}
