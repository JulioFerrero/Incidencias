package com.example.recuperar;

public class DatosVO {

    private String ID;
    private String title;
    private String incidencia;

    public DatosVO() {

    }

    public DatosVO(String ID, String title, String incidencia) {
        this.ID = ID;
        this.title = title;
        this.incidencia = incidencia;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(String incidencia) {
        this.incidencia = incidencia;
    }
}
