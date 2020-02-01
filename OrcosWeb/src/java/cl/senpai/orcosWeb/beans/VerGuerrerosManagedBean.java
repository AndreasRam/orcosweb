/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.senpai.orcosWeb.beans;

import cl.senpai.orcosEjb.dao.GuerrerosDAOLocal;
import cl.senpai.orcosEjb.dto.Guerrero;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

import javax.inject.Inject;


@Named(value = "verGuerrerosManagedBean")
@ViewScoped
public class VerGuerrerosManagedBean implements Serializable{

    @Inject
    private EditarGuerreroManagedBean editarGuerrero;
    
    @Inject
    private GuerrerosDAOLocal guerrerosDAO;
    private List<Guerrero> guerreros;

    @PostConstruct
    public void init(){
        this.guerreros = this.guerrerosDAO.findAll();
    }
    
    public VerGuerrerosManagedBean() {
    }

    public List<Guerrero> getGuerreros() {
        return guerreros;
    }

    public void setGuerreros(List<Guerrero> guerreros) {
        this.guerreros = guerreros;
    }
    
    public void eliminarGuerrero(Guerrero g){
        this.guerrerosDAO.delete(g.getId());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Guerrero eliminado"));
        this.guerreros = this.guerrerosDAO.findAll();
    }
    
    public void editarGuerrero(Guerrero g) throws IOException{
        this.editarGuerrero.setGuerreroEditado(g);
        this.editarGuerrero.setRangoSeleccionado(g.getRango().getId());
        FacesContext.getCurrentInstance().getExternalContext().redirect("editar_orco.xhtml");
    }
}
