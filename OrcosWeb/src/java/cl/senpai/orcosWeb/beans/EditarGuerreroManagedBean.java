
package cl.senpai.orcosWeb.beans;

import cl.senpai.orcosEjb.dao.GuerrerosDAOLocal;
import cl.senpai.orcosEjb.dao.RangosDAOLocal;
import cl.senpai.orcosEjb.dto.Guerrero;
import cl.senpai.orcosEjb.dto.Rango;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "editarGuerreroManagedBean")
@SessionScoped
public class EditarGuerreroManagedBean implements Serializable {

    private Guerrero guerreroEditado;
    private long rangoSeleccionado;
    private List<Rango> rangos;
    @Inject
    private RangosDAOLocal rangosDAO;
    @Inject
    private GuerrerosDAOLocal guerrerosDAO;
    
    @PostConstruct
    public void init(){
        this.rangos = this.rangosDAO.findAll();
    }
    
    public EditarGuerreroManagedBean() {
    }

    public Guerrero getGuerreroEditado() {
        return guerreroEditado;
    }

    public void setGuerreroEditado(Guerrero guerreroEditado) {
        this.guerreroEditado = guerreroEditado;
    }

    public long getRangoSeleccionado() {
        return rangoSeleccionado;
    }

    public void setRangoSeleccionado(long rangoSeleccionado) {
        this.rangoSeleccionado = rangoSeleccionado;
    }

    public List<Rango> getRangos() {
        return rangos;
    }

    public void setRangos(List<Rango> rangos) {
        this.rangos = rangos;
    }
    
 
    public void actualizar(ActionEvent e) throws IOException{
        this.guerreroEditado.setRango(rangosDAO.find(rangoSeleccionado));
        this.guerrerosDAO.update(guerreroEditado);
        FacesContext.getCurrentInstance().getExternalContext().redirect("ver_tropas.xhtml");
    }
    
}
