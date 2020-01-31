/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.senpai.orcosWeb.beans;

import cl.senpai.orcosEjb.dao.RangosDAOLocal;
import cl.senpai.orcosEjb.dto.Rango;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "rangosManagedBean")
@ViewScoped
public class RangosManagedBean implements Serializable{
    
    @Inject
    private RangosDAOLocal rangoDAO;

    private String nombreRango;
    private List<Rango> rangos = new ArrayList<>();

    public RangosManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        rangos = rangoDAO.findAll();
    }

    public String getNombreRango() {
        return nombreRango;
    }

    public void setNombreRango(String nombreRango) {
        this.nombreRango = nombreRango;
    }

    public List<Rango> getRangos() {
        return rangos;
    }

    public void setRangos(List<Rango> rangos) {
        this.rangos = rangos;
    }
 
    public void registrar(ActionEvent e){
        Rango rango = new Rango();
        rango.setNombre(nombreRango);
        rangoDAO.add(rango);
        rangos = rangoDAO.findAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Rango Registrado"));
    }
    
    public void eliminar(Rango r){
        rangoDAO.delete(r.getId());
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Rango Eliminado"));
        this.rangos = this.rangoDAO.findAll();
    }
}
