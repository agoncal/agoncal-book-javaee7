package org.agoncal.book.javaee7.chapter22.ex10;

import org.codehaus.jettison.json.JSONArray;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Path("/10/customers")
public class CustomerRestService10 {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Context
    UriInfo uriInfo;
    @EJB
    CustomerEJB10 customerEJB;

    // ======================================
    // =           Public Methods           =
    // ======================================

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JSONArray getListOfCustomers() {
        JSONArray uriArray = new JSONArray();
        for (Customer10 customer : customerEJB.findAll()) {
            UriBuilder ub = uriInfo.getAbsolutePathBuilder();
            URI userUri = ub.path(customer.getId().toString()).build();
            uriArray.put(userUri.toASCIIString());
        }
        return uriArray;
    }
}
