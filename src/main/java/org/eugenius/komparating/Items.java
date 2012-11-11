package org.eugenius.komparating;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Eugenius
 */
public class Items {
    private final Collection<Item> items = new ArrayList<Item>();

    public Items(Collection<Item> items) {
        this.items.addAll(items);
    }

    public Collection<Item> getItems() {
        return items;
    }
}
