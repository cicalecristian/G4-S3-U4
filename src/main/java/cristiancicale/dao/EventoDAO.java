package cristiancicale.dao;

import cristiancicale.entities.Evento;
import cristiancicale.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDAO {
    private final EntityManager entityManager;

    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Evento newEvento) {
        EntityTransaction transaction = this.entityManager.getTransaction();

        transaction.begin();

        entityManager.persist(newEvento);

        transaction.commit();

        System.out.println("L'evento " + newEvento.getTitolo() + " è stato salvato con successo!");
    }

    public Evento findById(long eventoID) {
        Evento found = entityManager.find(Evento.class, eventoID);
        if (found == null) throw new NotFoundException(eventoID);
        return found;
    }

    public void findByIdAndDelete(long eventoID) {

        Evento found = this.findById(eventoID);

        EntityTransaction transaction = this.entityManager.getTransaction();

        transaction.begin();

        entityManager.remove(found);

        transaction.commit();

        System.out.println("L'evento " + found.getId() + " è stato eliminato con successo!");
    }
}
