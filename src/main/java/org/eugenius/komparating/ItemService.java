package org.eugenius.komparating;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

/**
 * @author Eugenius
 */
@Stateless
public class ItemService {

    @PersistenceContext
    private EntityManager em;


    public void add(Item item) {
        em.persist(item);
    }

    public Collection<Item> findAll() {
        return em.createNamedQuery(Item.findAll, Item.class).getResultList();
    }
}
