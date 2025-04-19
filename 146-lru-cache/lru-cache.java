class LRUCache {
    int cap;
    Queue<Integer> queue = new LinkedList<>();
    Map<Integer,Integer> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.cap = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            queue.remove(key);
            queue.add(key);
            return map.get(key);
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            queue.remove(key);
            queue.add(key);
            map.put(key,value);
        } else {
            if(queue.size() == cap){
                map.remove(queue.poll());
            }
            queue.add(key);
            map.put(key,value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */