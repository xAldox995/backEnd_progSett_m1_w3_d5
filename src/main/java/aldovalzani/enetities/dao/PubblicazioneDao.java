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

    public void deleteByIsbn(long cod_isbn) {
        EntityTransaction transaction = em2.getTransaction();
        try {
            transaction.begin();
            Pubblicazione pubbTrovata = findByIsbn(cod_isbn);
            if (pubbTrovata != null) {
                em2.remove(pubbTrovata);
                transaction.commit();
                System.out.println("Pubblicazione con isbn " + cod_isbn + " è stato eliminato");
            } else {
                System.out.println("Nessuna pubblicazione con isbn " + cod_isbn);
            }
        } catch (Exception ex) {
            System.out.println("Oops c'è qualcosa che non va");
        }

    }
}
