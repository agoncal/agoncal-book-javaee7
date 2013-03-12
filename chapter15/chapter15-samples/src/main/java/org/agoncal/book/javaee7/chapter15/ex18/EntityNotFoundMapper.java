package org.agoncal.book.javaee7.chapter15.ex18;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Provider
public class EntityNotFoundMapper implements ExceptionMapper<EntityNotFoundException> {

  public Response toResponse(javax.persistence.EntityNotFoundException ex) {
    return Response.status(404).entity(ex.getMessage()).type(MediaType.TEXT_PLAIN).build();
  }
}
