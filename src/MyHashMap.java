public class MyHashMap<K,V> {
  private Node<K,V> [] buckets;
  int size;
  private static final int INITIAL_CAPACITY = 16;
  public MyHashMap(){
      this.buckets = new Node[INITIAL_CAPACITY];
  }
    private int getBucketIndex(K key){
      if(key == null){
          return 0;
      }
      int hash = key.hashCode();
      return (hash & 0x7fffffff) % buckets.length;
    }
    public void put(K key, V value){
      int index = getBucketIndex(key);
      Node<K,V>  current = buckets[index];
      while(current!=null) {
          if (isEqual(current.key, key)) {
              current.value = value;
              return;
          }
          current = current.next;
      }
          Node<K,V> newNode = new Node<>(key,value);
          newNode.next = buckets[index];
          buckets[index] = newNode;
          size++;
    }
    private boolean isEqual(K key1, K key2){
      if(key1 == null){
          return key2 == null;
      }
      return key1.equals(key2);
    }
    public V get(K key){
      int index = getBucketIndex(key);
      Node<K,V> current = buckets[index];
      while(current!=null){
          if(isEqual(current.key,key)){
              return current.value;
          }
          current = current.next;
      }
      return null;
    }
    public boolean containsKey(K key){
      int index = getBucketIndex(key);
      Node<K,V> current = buckets[index];
      while(current!=null){
          if(isEqual(current.key, key)){
              return true;
          }
          current = current.next;
      }
      return false;
    }
    public V remove(K key) {
        int index = getBucketIndex(key);

        Node<K,V> current = buckets[index];
        Node<K,V> previous = null;

        while (current != null) {

            if (isEqual(current.key, key)) {

                if (previous == null) {
                    buckets[index] = current.next;
                } else {
                    previous.next = current.next;
                }

                size--;
                return current.value;
            }

            previous = current;
            current = current.next;
        }

        return null;
    }
    public int size() {
        return size;
    }
}
 class Node<K,V>{
    K key;
    V value;
    Node<K,V> next;
    Node(K key, V value){
        this.key = key;
        this.value=value;
    }
}