package aldovalzani.enetities.dao;

import aldovalzani.enetities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UtenteDao {
    private final EntityManager em2;

    public UtenteDao(EntityManager em2) {
        this.em2 = em2;
    }

    public void save(Utente utente) {
        EntityTransaction transiction = em2.getTransaction();
        transiction.begin();
        em2.persist(utente);
        transiction.commit();
    }

}
