class Solution {

     static class Trie {
        
        static class Node {
            Node node[] = new Node[2];
            int number;
        }
        
        Node n = new Node();
        
        void insert(int num) {
            
            Node itr = n;
            
            for(int i = 31; i >= 0; i--) {
                int bit = ((1 << i) & num) > 0 ? 1 : 0;
                
                if(itr.node[bit] == null) {
                    itr.node[bit] = new Node();
                }
                itr = itr.node[bit];
            }
            itr.number = num;
        }
        
        int getMax(int num) {
            
            Node itr = n;
            
            for(int i = 31; i >= 0; i--) {
                int bit = ((1 << i) & num) > 0 ? 1 : 0;
                
                int find = bit == 1 ? 0 : 1;
                
                if(itr.node[find] != null) {
                    itr = itr.node[find];
                } else {
                    itr = itr.node[bit];
                }
                
            }
            return itr.number;
        }
        
    } 

    public int findMaximumXOR(int[] nums) {
        Trie t = new Trie();

        for(int num : nums) {
            t.insert(num);
        }
        int max = 0;

        for(int num : nums) {
            int xorNum = t.getMax(num);
            max = Math.max(max, num ^ xorNum);
        }

        return max;
    }
}