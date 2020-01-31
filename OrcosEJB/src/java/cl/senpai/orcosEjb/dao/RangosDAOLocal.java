package cl.senpai.orcosEjb.dao;

import cl.senpai.orcosEjb.dto.Rango;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RangosDAOLocal {
    
    public List<Rango> findAll();
    public void add(Rango r);
    public void delete(long id);
    public Rango find(long id);
    
}
