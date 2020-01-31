package cl.senpai.orcosEjb.dao;

import cl.senpai.orcosEjb.dto.Guerrero;
import cl.senpai.orcosEjb.dto.Rango;
import java.util.List;
import javax.ejb.Local;


@Local
public interface GuerrerosDAOLocal {
    
    public List<Guerrero> findAll();
    public Guerrero add(Guerrero g);
    public void delete(long id);
    
}
