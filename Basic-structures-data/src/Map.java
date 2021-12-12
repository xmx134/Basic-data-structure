public interface Map<K, V> {
    public void add(K key, V value);
    public V remove(K key);
    public boolean contains(K key);
    public V get(K key);
    public void set(K key, V value);
    public int getSize();
    public boolean isEmpty();
}
