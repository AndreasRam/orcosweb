package cl.senpai.orcosEjb.dto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rangos")
@NamedQueries({
    @NamedQuery(name = "Rango.findAll()",query = "SELECT r FROM Rango r")
})
public class Rango implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rango")
    private List<Guerrero> guerreros;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Guerrero> getGuerreros() {
        return guerreros;
    }

    public void setGuerreros(List<Guerrero> guerreros) {
        this.guerreros = guerreros;
    }
        
}
