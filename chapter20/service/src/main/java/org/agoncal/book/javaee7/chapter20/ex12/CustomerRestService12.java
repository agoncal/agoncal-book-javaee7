package org.agoncal.book.javaee7.chapter20.ex12;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Path("/12/customers")
public class CustomerRestService12 {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Inject
    private EntityManager em;

    // ======================================
    // =           Public Methods           =
    // ======================================

    @Path("{customerId}")
    public Customer12 getCustomer(@PathParam("customerId") Long customerId) {
        if (customerId < 1)
            throw new WebApplicationException(Response.status(400).entity("Id must be a positive integer!").build());

        Customer12 customer = em.find(Customer12.class, customerId);
        if (customer == null)
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        return customer;
    }
}