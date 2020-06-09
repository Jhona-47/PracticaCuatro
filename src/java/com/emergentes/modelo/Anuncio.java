
package com.emergentes.modelo;

public class Anuncio {
    private int id;
    private String fecha;
    private String titulo;
    private String anuncio;

    public Anuncio() {
         this.id = 0;
         this.fecha = "";
         this.titulo ="";
         this.anuncio="";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(String anuncio) {
        this.anuncio = anuncio;
    }
    
    
}
