package cristiancicale.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("concerto")
public class Concerto extends Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @Enumerated(EnumType.STRING)
    private Genere genere;
    @Enumerated(EnumType.STRING)
    private InStreaming inStreaming;

    protected Concerto() {
    }

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
                    int numeroMassimoPartecipanti, Location location, Genere genere, InStreaming inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    @Override
    public long getId() {
        return id;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public InStreaming getInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(InStreaming inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "id=" + id +
                ", genere=" + genere +
                ", inStreaming=" + inStreaming +
                '}';
    }
}
