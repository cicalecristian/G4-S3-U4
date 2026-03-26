package cristiancicale.dao;

import cristiancicale.entities.Concerto;
import cristiancicale.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ConcertoDAO {
    private final EntityManager entityManager;

    public ConcertoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Concerto newConcerto) {
        EntityTransaction transaction = this.entityManager.getTransaction();

        transaction.begin();

        entityManager.persist(newConcerto);

        transaction.commit();

        System.out.println("Il concerto " + newConcerto.getId() + " è stato salvato con successo!");
    }

    public Concerto findById(long concertoID) {
        Concerto found = entityManager.find(Concerto.class, concertoID);
        if (found == null) throw new NotFoundException(concertoID);
        return found;
    }
}