package aldovalzani.enetities.pubblChild;

import aldovalzani.enetities.Pubblicazione;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "libri")
public class Libro extends Pubblicazione {
    private String autore;
    @Enumerated(EnumType.STRING)
    private GenLibro genere;

    public Libro() {
    }

    public Libro(int numPagine, String titolo, LocalDate annoDiPubblicazione, String autore, GenLibro genere) {
        super(numPagine, titolo, annoDiPubblicazione);
        this.autore = autore;
        this.genere = genere;
    }
}
