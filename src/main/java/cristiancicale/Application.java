package cristiancicale;

import cristiancicale.dao.ConcertoDAO;
import cristiancicale.dao.EventoDAO;
import cristiancicale.dao.LocationDAO;
import cristiancicale.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestioneeventisecond");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EventoDAO eventsDAO = new EventoDAO(entityManager);
        ConcertoDAO concertoDao = new ConcertoDAO(entityManager);
        LocationDAO locationDAO = new LocationDAO(entityManager);

//        Location l1 = new Location("San Siro", "Milano");
//
//        Location l2 = new Location("Maradona", "Napoli");
//
//        Location l3 = new Location("Piazza San Giovanni", "Roma");

//        locationDAO.save(l1);
//        locationDAO.save(l2);
//        locationDAO.save(l3);

        Location l1FromDB = locationDAO.findById(1);
        Location l2FromDB = locationDAO.findById(2);
        Location l3FromDB = locationDAO.findById(3);

        Concerto c1 = new Concerto("Vasco Rossi",
                LocalDate.of(2026, 10, 15),
                "da non perdere",
                TipoEvento.PUBBLICO, 50000,
                l1FromDB, Genere.POP, InStreaming.TRUE);

        Concerto c2 = new Concerto(
                "Ligabue Live",
                LocalDate.of(2026, 11, 5),
                "rock e adrenalina",
                TipoEvento.PUBBLICO,
                40000,
                l2FromDB,
                Genere.ROCK,
                InStreaming.FALSE
        );

        Concerto c3 = new Concerto(
                "Laura Pausini",
                LocalDate.of(2026, 12, 1),
                "emozioni a tutto volume",
                TipoEvento.PUBBLICO,
                30000,
                l3FromDB,
                Genere.POP,
                InStreaming.TRUE
        );

//        concertoDao.save(c1);
//        concertoDao.save(c2);
//        concertoDao.save(c3);

//        PersonaDAO personaDAO = new PersonaDAO(entityManager);
//        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(entityManager);


//        Persona p1 = new Persona("Mario", "Rossi", "mariorossi@gmail.com", LocalDate.of(2000, 6, 14), Sesso.M);
//        personaDAO.save(p1);

//        Location l1FromDB = locationDAO.findById(1);
//        Evento e1 = new Evento("Matrimonio", LocalDate.of(2026, 10, 20), "vista sul mare", TipoEvento.PRIVATO, 100, l1FromDB);
//        eventsDAO.save(e1);

//        Persona p1FromDB = personaDAO.findById(1);
//        Evento e1FromDB = eventsDAO.findById(1);
//        Partecipazione part1 = new Partecipazione(p1FromDB, e1FromDB, Stato.DA_CONFERMARE);
//        partecipazioneDAO.save(part1);

//        Partecipazione part1FromDB = partecipazioneDAO.findById(1);
//        e1FromDB.getListaPartecipazioni().add(part1);
//        p1FromDB.getListaPartecipazioni().add(part1);

        entityManager.close();
        entityManagerFactory.close();
    }
}
