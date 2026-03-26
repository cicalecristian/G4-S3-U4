package cristiancicale.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@DiscriminatorValue("gara_di_atletica")
public class GaraDiAtletica extends Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @ManyToMany
    private Set<Persona> atleti;

    @ManyToOne
    private Persona vincitore;

    protected GaraDiAtletica() {
    }

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
                          int numeroMassimoPartecipanti, Location location, Set<Persona> atleti, Persona vincitore) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    @Override
    public long getId() {
        return id;
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "id=" + id +
                ", atleti=" + atleti +
                ", vincitore=" + vincitore +
                '}';
    }
}
