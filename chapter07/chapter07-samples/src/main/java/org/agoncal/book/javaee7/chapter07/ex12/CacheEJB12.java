package org.agoncal.book.javaee7.chapter07.ex12;

import javax.ejb.AccessTimeout;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Singleton
public class CacheEJB12 {

  // ======================================
  // =             Attributes             =
  // ======================================

  private Map<Long, Object> cache = new HashMap<>();

  // ======================================
  // =           Public Methods           =
  // ======================================

  @AccessTimeout(0)
  public void addToCache(Long id, Object object) {
    if (!cache.containsKey(id))
      cache.put(id, object);
  }

  public void removeFromCache(Long id) {
    if (cache.containsKey(id))
      cache.remove(id);
  }

  @Lock(LockType.READ)
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