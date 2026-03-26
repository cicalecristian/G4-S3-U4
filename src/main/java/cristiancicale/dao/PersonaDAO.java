package cristiancicale.dao;

import cristiancicale.entities.Persona;
import cristiancicale.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PersonaDAO {
    private final EntityManager entityManager;

    public PersonaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Persona newPersona) {
        EntityTransaction transaction = this.entityManager.getTransaction();

        transaction.begin();

        entityManager.persist(newPersona);

        transaction.commit();

        System.out.println("La persona " + newPersona.getId() + " è stata salvata con successo!");
    }

    public Persona findById(long personaID) {
        Persona found = entityManager.find(Persona.class, personaID);
        if (found == null) throw new NotFoundException(personaID);
        return found;
    }
}