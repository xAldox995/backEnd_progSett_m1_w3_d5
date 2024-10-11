package aldovalzani.enetities.dao;

import aldovalzani.enetities.Pubblicazione;
import aldovalzani.enetities.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PubblicazioneDao {
    private final EntityManager em2;

    public PubblicazioneDao(EntityManager em2) {
        this.em2 = em2;
    }

    public void save(Pubblicazione pubblicazione) {
        EntityTransaction transiction = em2.getTransaction();
        transiction.begin();
        em2.persist(pubblicazione);
        transiction.commit();
        em2.close();
        System.out.println("Pubblicazione " + pubblicazione.getTitolo() + " è stato inserito correttamente");

    }

    public Pubblicazione findByIsbn(long cod_isbn) {
        Pubblicazione found = em2.find(Pubblicazione.class, cod_isbn);
        if (found == null) throw new NotFoundException(cod_isbn);
        return found;
    }
}
