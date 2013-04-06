package org.agoncal.book.javaee7.chapter02.ex16;


import javax.inject.Inject;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@ThirteenDigits16
public class IsbnGenerator16 implements NumberGenerator16 {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Inject
    @ThirteenDigits16
    private String prefix;

    @Inject
    @Random16
    private Double postfix;

    // ======================================
    // =          Business methods          =
    // ======================================

    public String generateNumber() {
        return prefix + "84356-" + postfix;
    }
}