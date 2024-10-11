package aldovalzani.enetities.dao;

import aldovalzani.enetities.Utente;
import aldovalzani.enetities.exceptions.NotFoundException;
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
        em2.close();
        System.out.println("Utente " + utente.getCognome() + " è stato inserito correttamente");
    }

    public Utente findByTessera(long numTessera) {
        Utente found = em2.find(Utente.class, numTessera);
        if (found == null) throw new NotFoundException(numTessera);
        return found;
    }

}
