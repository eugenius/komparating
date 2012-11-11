package org.eugenius.komparating;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * @author Eugenius
 */
@Entity
@NamedQuery(name= Item.findAll, query="select i from Item i")
public class Item {
    public final static String PREFIX = "org.eugenius.komparating.Item.";
    public final static String findAll = PREFIX + "findAll";

    @Id
    @GeneratedValue
    private long id;

    private String guid;

    public Item() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}
