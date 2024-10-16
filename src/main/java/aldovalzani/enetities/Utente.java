package aldovalzani.enetities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue
    @Column(name = "num_tessera")
    private long numTessera;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cognome;
    @Column(nullable = false)
    private LocalDate dataDiNascita;
    @OneToMany(mappedBy = "utente")
    private List<Prestito> listaPrestiti;

    public Utente() {
    }

    public Utente(String cognome, String nome, LocalDate dataDiNascita) {
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public List<Prestito> getListaPrestiti() {
        return listaPrestiti;
    }

    public String getNome() {
        return nome;
    }

    public long getNumTessera() {
        return numTessera;
    }


}
