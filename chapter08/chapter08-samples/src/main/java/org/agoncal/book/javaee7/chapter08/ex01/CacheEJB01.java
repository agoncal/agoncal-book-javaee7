package org.agoncal.book.javaee7.chapter08.ex01;

import javax.annotation.PostConstruct;
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
public class CacheEJB01 {

  // ======================================
  // =             Attributes             =
  // ======================================

  private Map<Long, Object> cache = new HashMap<>();

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @PostConstruct
  private void initCache() {
    // Initializes the cache
    cache.put(1L, "First item in the cache");
    cache.put(2L, "Second item in the cache");
  }

  // ======================================
  // =           Public Methods           =
  // ======================================

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
