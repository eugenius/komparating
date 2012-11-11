
package org.eugenius.komparating;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.Collections;

/**
 * @author Eugenius
 */
@Path("item")
@Stateless
public class ItemService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Item> getList() {
        return Collections.emptyList();
    }
}
