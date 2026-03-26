package cristiancicale.dao;

import cristiancicale.entities.Partecipazione;
import cristiancicale.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PartecipazioneDAO {
    private final EntityManager entityManager;

    public PartecipazioneDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Partecipazione newPartecipazione) {
        EntityTransaction transaction = this.entityManager.getTransaction();

        transaction.begin();

        entityManager.persist(newPartecipazione);

        transaction.commit();

        System.out.println("La partecipazione " + newPartecipazione.getId() + " è stata salvata con successo!");
    }

    public Partecipazione findById(long locationID) {
        Partecipazione found = entityManager.find(Partecipazione.class, locationID);
        if (found == null) throw new NotFoundException(locationID);
        return found;
    }
}