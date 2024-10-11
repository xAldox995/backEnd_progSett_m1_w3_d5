package aldovalzani.enetities.pubblChild;

import aldovalzani.enetities.Pubblicazione;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "riviste")
public class Rivista extends Pubblicazione {
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Rivista() {
    }

    public Rivista(int numPagine, String titolo, LocalDate annoDiPubblicazione, Periodicita periodicita) {
        super(numPagine, titolo, annoDiPubblicazione);
        this.periodicita = periodicita;
    }
}
