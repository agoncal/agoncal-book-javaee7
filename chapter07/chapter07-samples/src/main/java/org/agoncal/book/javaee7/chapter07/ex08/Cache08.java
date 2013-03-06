/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
package org.agoncal.book.javaee7.chapter07.ex08;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Cache08 {

  // ======================================
  // =             Attributes             =
  // ======================================

  private static Cache08 instance = new Cache08();
  private Map<Long, Object> cache = new HashMap<>();

  // ======================================
  // =            Constructors            =
  // ======================================

  private Cache08() {
  }

  // ======================================
  // =           Public Methods           =
  // ======================================

  public static synchronized Cache08 getInstance() {
    return instance;
  }

  public void addToCache(Long id, Object object) {
    if (!cache.containsKey(id))
      cache.put(id, object);
  }

  public void removeFromCache(Long id) {
    if (cache.containsKey(id))
      cache.remove(id);
  }

  public Object getFromCache(Long id) {
    if (cache.containsKey(id))
      return cache.get(id);
    else
      return null;
  }

  public Integer getNumberOfItems() {
    if (cache == null || cache.isEmpty())
      return 0;
    return cache.size();
  }
}
