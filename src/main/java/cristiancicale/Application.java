package cristiancicale;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        EventoDAO eventsDAO = new EventoDAO(entityManager);
//        PersonaDAO personaDAO = new PersonaDAO(entityManager);
//        LocationDAO locationDAO = new LocationDAO(entityManager);
//        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(entityManager);

//        Location l1 = new Location("Il Gabbiano", "Napoli");
//        locationDAO.save(l1);

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
