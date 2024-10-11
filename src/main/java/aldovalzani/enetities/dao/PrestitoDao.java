package aldovalzani.enetities.dao;

import aldovalzani.enetities.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PrestitoDao {
    private final EntityManager em2;

    public PrestitoDao(EntityManager em2) {
        this.em2 = em2;
    }

    public void save(Prestito prestito) {
        EntityTransaction transiction = em2.getTransaction();
        
        transiction.begin();
        em2.persist(prestito);
        transiction.commit();
        em2.close();
        System.out.println("Il prestito con id " + prestito.getIdPrestito() + " è stato inserito");

    }
}
