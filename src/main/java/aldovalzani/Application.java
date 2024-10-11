package aldovalzani;

import aldovalzani.enetities.Utente;
import aldovalzani.enetities.dao.UtenteDao;
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


        UtenteDao utDao = new UtenteDao(em);

        utDao.save(u1);
        utDao.save(u2);
        utDao.save(u3);


    }
}
