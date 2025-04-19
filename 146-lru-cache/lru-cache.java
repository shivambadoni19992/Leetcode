class Node {
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int cap;
    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node newnode) {
        Node temp = head.next;
        newnode.next = temp;
        newnode.prev = head;
        head.next = newnode;
        temp.prev = newnode;
    }

    private void deleteNode(Node delnode) {
        Node prev = delnode.prev;
        Node next = delnode.next;
        prev.next = next;
        next.prev = prev;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node res = map.get(key);
            int ans = res.val;
            map.remove(key);
            deleteNode(res);
            addNode(res);
            map.put(key, head.next);
            return ans;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            map.remove(key);
            deleteNode(curr);
        }
        if (map.size() == cap) {
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        addNode(new Node(key, value));
        map.put(key, head.next);
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
