package cristiancicale.dao;

import cristiancicale.entities.Location;
import cristiancicale.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LocationDAO {
    private final EntityManager entityManager;

    public LocationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Location newLocation) {
        EntityTransaction transaction = this.entityManager.getTransaction();

        transaction.begin();

        entityManager.persist(newLocation);

        transaction.commit();

        System.out.println("La location " + newLocation.getId() + " è stata salvata con successo!");
    }

    public Location findById(long locationID) {
        Location found = entityManager.find(Location.class, locationID);
        if (found == null) throw new NotFoundException(locationID);
        return found;
    }
}