package org.agoncal.book.javaee7.chapter03.ex13;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Constraint(validatedBy = {URLValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
public @interface URL {

  String message() default "Malformed URL";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  /**
   * @return the protocol (scheme) the annotated string must match, eg ftp or http.
   *         Per default any protocol is allowed
   */
  String protocol() default "";

  /**
   * @return the host the annotated string must match, eg localhost. Per default any host is allowed
   */
  String host() default "";

  /**
   * @return the port the annotated string must match, eg 80. Per default any port is allowed
   */
  int port() default -1;
}
