
package org.eugenius.komparating;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * @author Eugenius
 */
@Path("item")
@Stateless
public class ItemRest {

    @EJB
    private ItemService itemService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Items getList() {
        Collection<Item> items = itemService.findAll();
        return new Items(items);
    }

    @PUT
    @Path("/{itemId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addItem(@PathParam("itemId") String itemId) {
        Item item = new Item();
        item.setGuid(itemId);
        itemService.add(item);
    }
}
