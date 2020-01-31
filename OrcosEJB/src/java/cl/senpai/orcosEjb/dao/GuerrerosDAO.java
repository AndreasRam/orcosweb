package cl.senpai.orcosEjb.dao;

import cl.senpai.orcosEjb.dto.Guerrero;
import cl.senpai.orcosEjb.dto.Rango;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


@Stateless
public class GuerrerosDAO implements GuerrerosDAOLocal {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("OrcosEJBPU");
    
    @Override
    public List<Guerrero> findAll() {
    
        EntityManager em = emf.createEntityManager();
        try{
           return em.createNamedQuery("Guerrero.findAll", Guerrero.class).getResultList();
        }catch(Exception e){
            System.out.println("Error" + e);
            return null;
        }finally{
            em.close();
        }        
    }

    @Override
    public Guerrero add(Guerrero g) {
        
        EntityManager em = emf.createEntityManager();
        try {
            g.setRango(em.merge(g.getRango()));
            em.persist(g);
            return g;
        } catch (Exception e) {
            return null;
        }finally{
            em.close();
        }      
    }

    @Override
    public void delete(long id) {
        
        EntityManager em = emf.createEntityManager();
        try {
            em.remove(em.find(Guerrero.class, id));
        } catch (Exception e) {
        
        }finally{
            em.close();
        }
        
    }

    
}
