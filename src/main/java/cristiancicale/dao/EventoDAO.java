package cristiancicale.dao;

import cristiancicale.entities.Concerto;
import cristiancicale.entities.Evento;
import cristiancicale.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

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

    public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
        TypedQuery<Concerto> query = entityManager.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming", Concerto.class);
        query.setParameter("inStreaming", inStreaming);
        return query.getResultList();
    }

//    public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
//        String jpql = "SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming";
//        return entityManager.createQuery(jpql, Concerto.class)
//                .setParameter("inStreaming", inStreaming)
//                .getResultList();
//    }

    public List<Concerto> getConcertiPerGenere(String genere) {
        TypedQuery<Concerto> query = entityManager.createQuery("SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class);
        query.setParameter("genere", genere);
        return query.getResultList();
    }

//    public List<Concerto> getConcertiPerGenere(String genere) {
//        String jpql = "SELECT c FROM Concerto c WHERE c.genere = :genere";
//        return entityManager.createQuery(jpql, Concerto.class)
//                .setParameter("genere", genere)
//                .getResultList();
//    }
}
