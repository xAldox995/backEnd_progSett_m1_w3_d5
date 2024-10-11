package aldovalzani.enetities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prestiti")
public class Prestito {
    @Id
    @GeneratedValue
    @Column(name = "id_prestito")
    private long idPrestito;
    @ManyToOne
    @JoinColumn(name = "num_tessera")
    private Utente utente;
    @OneToOne
    @JoinColumn(name = "id_pubblicazione", nullable = false)
    private Pubblicazione pubbPrestato;
    @Column(name = "data_prestito", nullable = false)
    private LocalDate dataPrestito = LocalDate.now();
    @Column(name = "restituzione_prevista", nullable = false)
    private LocalDate restituzionePrevista = dataPrestito.plusDays(30);
    @Column(name = "restituzione_effetiva", nullable = false)
    private LocalDate restituzioneEffettiva;

    public Prestito() {
    }

    public Prestito(Pubblicazione pubbPrestato, LocalDate restituzioneEffettiva, Utente utente) {
        this.dataPrestito = LocalDate.now();
        this.pubbPrestato = pubbPrestato;
        this.restituzioneEffettiva = restituzioneEffettiva;
        this.utente = utente;
    }
}
