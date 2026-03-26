package cristiancicale.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "partita_di_calcio")
@DiscriminatorValue("partita_di_calcio")
public class PartitaDiCalcio extends Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String squadraDiCasa;
    private String squadraOspite;
    private String squadraVincente;
    private int numeroGolSqudraDiCasa;
    private int numeroGolSqudraOspite;

    protected PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
                           int numeroMassimoPartecipanti, Location location, String squadraDiCasa, String squadraOspite,
                           String squadraVincente, int numeroGolSqudraDiCasa, int numeroGolSqudraOspite) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.numeroGolSqudraDiCasa = numeroGolSqudraDiCasa;
        this.numeroGolSqudraOspite = numeroGolSqudraOspite;
    }

    @Override
    public long getId() {
        return id;
    }

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public int getNumeroGolSqudraDiCasa() {
        return numeroGolSqudraDiCasa;
    }

    public int getNumeroGolSqudraOspite() {
        return numeroGolSqudraOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "id=" + id +
                ", squadraDiCasa='" + squadraDiCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", numeroGolSqudraDiCasa=" + numeroGolSqudraDiCasa +
                ", numeroGolSqudraOspite=" + numeroGolSqudraOspite +
                '}';
    }
}
