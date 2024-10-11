package aldovalzani.enetities.dao;

import aldovalzani.enetities.Prestito;
import aldovalzani.enetities.exceptions.NotFoundException;
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

    public Prestito findById(long idPrestito) {
        Prestito found = em2.find(Prestito.class, idPrestito);
        if (found == null) throw new NotFoundException(idPrestito);
        return found;
    }
}
