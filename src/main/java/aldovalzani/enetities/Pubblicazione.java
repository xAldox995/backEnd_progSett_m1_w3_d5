package aldovalzani.enetities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pubblicazioni")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pubblicazione {
    @Id
    @GeneratedValue
    private long cod_isbn;
    @Column(nullable = false)
    private String titolo;
    @Column(name = "anno_di_pubblicazione", nullable = false)
    private LocalDate annoDiPubblicazione;
    @Column(name = "num_pagine", nullable = false)
    private int numPagine;

    public Pubblicazione() {
    }

    public Pubblicazione(int numPagine, String titolo, LocalDate annoDiPubblicazione) {
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.numPagine = numPagine;
        this.titolo = titolo;
    }


    public LocalDate getAnnoDiPubblicazione() {
        return annoDiPubblicazione;
    }

    public void setAnnoDiPubblicazione(LocalDate annoDiPubblicazione) {
        this.annoDiPubblicazione = annoDiPubblicazione;
    }

    public int getNumPagine() {
        return numPagine;
    }

    public void setNumPagine(int numPagine) {
        this.numPagine = numPagine;
    }


    public void setCod_isbn(long cod_isbn) {
        this.cod_isbn = cod_isbn;
    }
}
