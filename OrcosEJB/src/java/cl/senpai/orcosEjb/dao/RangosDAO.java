package cl.senpai.orcosEjb.dao;

import cl.senpai.orcosEjb.dto.Rango;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Stateless
public class RangosDAO implements RangosDAOLocal {    

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("OrcosEJBPU");
    
    @Override
    public List<Rango> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Rango.findAll()", Rango.class).getResultList();
        } catch (Exception e) {
            return null;
        }finally{
            em.close();
        }
    }

    @Override
    public void add(Rango r) {
        EntityManager em = emf.createEntityManager();
        try{
            em.persist(r);
        }catch(Exception e){
            
        }finally{
            em.close();
        }
    }

    @Override
    public void delete(long id) {
    
       EntityManager em = emf.createEntityManager();
       try{
           em.remove(em.find(Rango.class, id));
       }catch(Exception e){
           
       }finally{
           em.close();
       }
    }
    
    @Override
    public Rango find(long id) {
        
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Rango.class, id);
        } catch (Exception e) {
            return null;
        }finally{
            em.close();
        }
        
    }
}
