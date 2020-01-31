/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.senpai.orcosWeb.beans;

import cl.senpai.orcosEjb.dao.GuerrerosDAOLocal;
import cl.senpai.orcosEjb.dao.RangosDAOLocal;
import cl.senpai.orcosEjb.dto.Guerrero;
import cl.senpai.orcosEjb.dto.Rango;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "registrarGuerreroManagedBean")
@ViewScoped
public class RegistrarGuerreroManagedBean implements Serializable{

    @Inject
    private RangosDAOLocal rangosDAO;
    @Inject
    private GuerrerosDAOLocal guerrerosDAO;
    
    private List<Rango> rangos;
    private String nombre;
    private String tipo;
    private int nivel;
    private long rangoSeleccionado;
    
    public RegistrarGuerreroManagedBean() {
    }

    @PostConstruct
    public void init(){
        this.rangos = this.rangosDAO.findAll();
    }
    
    public List<Rango> getRangos() {
        return rangos;
    }

    public void setRangos(List<Rango> rangos) {
        this.rangos = rangos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public long getRangoSeleccionado() {
        return rangoSeleccionado;
    }

    public void setRangoSeleccionado(long rangoSeleccionado) {
        this.rangoSeleccionado = rangoSeleccionado;
    }
    
    public void crearGuerrero(ActionEvent e){
        Guerrero g = new Guerrero();
        g.setNombre(nombre);
        g.setRango(rangosDAO.find(rangoSeleccionado));
        g.setTipo(tipo);
        g.setNivel(nivel);
        guerrerosDAO.add(g);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Guerrero registrado"));
    }
}
