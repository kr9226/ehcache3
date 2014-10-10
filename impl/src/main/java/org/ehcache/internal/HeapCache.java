/*
 * Copyright Terracotta, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ehcache.internal;

import org.ehcache.Ehcache;
import org.ehcache.exceptions.CacheAccessException;
import org.ehcache.function.BiFunction;
import org.ehcache.function.Function;
import org.ehcache.spi.cache.Store;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cdennis
 */
@Deprecated
public class HeapCache<K, V> extends Ehcache<K, V> {

  private final Map<K, V> underlying = new ConcurrentHashMap<K, V>();

  public HeapCache() {
    this(new Store<K, V>() {
      @Override
      public ValueHolder<V> putIfAbsent(K key, V value)
          throws CacheAccessException {
        throw new UnsupportedOperationException("Implement me!");
      }

      @Override
      public boolean remove(K key, V value) throws CacheAccessException {
        throw new UnsupportedOperationException("Implement me!");
      }

      @Override
      public ValueHolder<V> replace(K key, V value)
          throws CacheAccessException {
        throw new UnsupportedOperationException("Implement me!");
      }

      @Override
      public boolean replace(K key, V oldValue, V newValue)
          throws CacheAccessException {
        throw new UnsupportedOperationException("Implement me!");
      }

      public ValueHolder<V> get(final K key) throws CacheAccessException {
        throw new UnsupportedOperationException("Implement me!");
      }

      @Override
      public boolean containsKey(final K key) throws CacheAccessException {
        throw new UnsupportedOperationException("Implement me!");
      }

      @Override
      public void put(final K key, final V value) throws CacheAccessException {
        throw new UnsupportedOperationException("Implement me!");
      }

      @Override
      public void remove(final K key) throws CacheAccessException {
        throw new UnsupportedOperationException("Implement me!");
      }

      @Override
      public void clear() throws CacheAccessException {
        throw new UnsupportedOperationException("Implement me!");
      }

      @Override
      public void destroy() throws CacheAccessException {
        throw new UnsupportedOperationException("Implement me!");
      }

      @Override
      public void create() throws CacheAccessException {
        throw new UnsupportedOperationException("Implement me!");
      }

      @Override
      public void close() {
        throw new UnsupportedOperationException("Implement me!");
      }

      @Override
      public void init() {
        // We don't care
      }

      @Override
      public void maintenance() {
        // We don't care
      }

      @Override
      public Iterator<Entry<K, ValueHolder<V>>> iterator() {
        throw new UnsupportedOperationException("Implement me!");
      }

      @Override
      public ValueHolder<V> compute(final K key, final BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        throw new UnsupportedOperationException("Implement me!");
      }

      @Override
      public ValueHolder<V> computeIfAbsent(final K key, final Function<? super K, ? extends V> mappingFunction) {
        throw new UnsupportedOperationException("Implement me!");
      }

      @Override
      public Map<K, ValueHolder<V>> bulkComputeIfAbsent(Iterable<? extends K> keys, Function<Iterable<? extends K>, Iterable<? extends Map.Entry<? extends K, ? extends V>>> mappingFunction) throws CacheAccessException {
        throw new UnsupportedOperationException("Implement me!");
      }

      @Override
      public Map<K, ValueHolder<V>> bulkCompute(Iterable<? extends K> keys, Function<Iterable<? extends Map.Entry<? extends K, ? extends V>>, Iterable<? extends Map.Entry<? extends K, ? extends V>>> remappingFunction) throws CacheAccessException {
        throw new UnsupportedOperationException("Implement me!");
      }

      @Override
      public ValueHolder<V> computeIfPresent(final K key, final BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        throw new UnsupportedOperationException("Implement me!");
      }
    });
  }

  public HeapCache(final Store<K, V> store) {
    super(store);
  }

  public V get(K key) {
    return underlying.get(key);
  }

  @Override
  public void put(K key, V value) {
    underlying.put(key, value);
  }

  @Override
  public boolean containsKey(K key) {
    return underlying.containsKey(key);
  }
}
