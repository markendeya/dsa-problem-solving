import java.util.HashMap;
import java.util.Map;
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class LRUCache {
    Node head,tail;
    int capacity;
    Map<Integer,Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Node node =   map.get(key);
        remove(node);
        addToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node newNode = new Node(key,value);
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
        }
        if(map.size() == capacity) {
            remove(tail.prev);
        }
        addToHead(newNode);
    }
    public void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void addToHead(Node node) {
        map.put(node.key,node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }
}

class Node {
    int key;
    int val;
    Node prev;
    Node next;
    public Node(int key,int val) {
        this.key = key;
        this.val = val;
    }
}