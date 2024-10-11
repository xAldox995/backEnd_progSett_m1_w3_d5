package aldovalzani;

import aldovalzani.enetities.Prestito;
import aldovalzani.enetities.Pubblicazione;
import aldovalzani.enetities.Utente;
import aldovalzani.enetities.dao.PrestitoDao;
import aldovalzani.enetities.dao.PubblicazioneDao;
import aldovalzani.enetities.dao.UtenteDao;
import aldovalzani.enetities.pubblChild.GenLibro;
import aldovalzani.enetities.pubblChild.Libro;
import aldovalzani.enetities.pubblChild.Periodicita;
import aldovalzani.enetities.pubblChild.Rivista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogo_biblioteca");

    public static void main(String[] args) {
        System.out.println("Hello World!");

        EntityManager em = emf.createEntityManager();

        Utente u1 = new Utente("Rossi", "Mario", LocalDate.of(1995, 7, 1));
        Utente u2 = new Utente("Verdi", "Giuseppe", LocalDate.of(1998, 8, 10));
        Utente u3 = new Utente("Neri", "Michele", LocalDate.of(1968, 10, 31));

        Pubblicazione l1 = new Libro(120, "Lord of the rings", LocalDate.of(1954, 07, 29), "J.R.R. Tolkien", GenLibro.FANTASY);
        Pubblicazione l2 = new Libro(320, "Intro alla programmazione", LocalDate.of(2021, 01, 15), "Sconosciuto", GenLibro.SCYFY);
        Pubblicazione r1 = new Rivista(50, "Il mondo della matematica", LocalDate.of(2023, 7, 10), Periodicita.MENSILE);
        Pubblicazione r2 = new Rivista(130, "Scienza e tecnologia", LocalDate.of(2022, 3, 20), Periodicita.SEMESTRALE);


        UtenteDao utDao = new UtenteDao(em);
        PubblicazioneDao pubDao = new PubblicazioneDao(em);
        PrestitoDao prestDao = new PrestitoDao(em);

        Utente utTrovato = utDao.findByTessera(302);
        Pubblicazione pubTrovata = pubDao.findByIsbn(402);

        Prestito pre1 = new Prestito(pubTrovata, LocalDate.of(2024, 10, 20), utTrovato);

        //utDao.save(u1);
        //utDao.save(u2);
        //utDao.save(u3);

        //pubDao.save(l1);
        //pubDao.save(l2);
        //pubDao.save(r1);
        //pubDao.save(r2);

        //prestDao.save(pre1);

        pubDao.deleteByIsbn(502);
        em.close();
        emf.close();


    }
}
