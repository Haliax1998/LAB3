/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.congresoft.model;

import java.util.Date;

/**
 *
 * @author: Karl Campos
 * @codigo: 20161008
 */
public class Congreso {
    private static int aux=1;
    private int id;
    private String nombre;
    private Date fechaIni;
    private Date fechaFin;
    private String pais;
    private boolean activo;
    
    public Congreso(){
        this.id=aux;
        aux++;
    }
    public Congreso(String nom,Date fechaI,Date fechaF,String pais,Boolean activo){
        this.id=aux;
        this.nombre=nom;
        this.fechaIni=fechaI;
        this.fechaFin=fechaF;
        this.pais=pais;
        this.activo=activo;
        aux++;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public String imprimirDatos(){
        return id+"  "+nombre+"  "+fechaIni+"  "+fechaFin+"  "+pais; 
    }  
}
