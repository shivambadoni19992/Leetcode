class Solution {

    class Node {
        Node []node = new Node[26];
        List<String> words = new ArrayList<>();
    }


    class Trie {

        Node head = new Node(); 

        void insert(String word) {

            Node itr = head;

            for(char ch : word.toCharArray()) {

                if(itr.node[ch - 'a'] == null) {
                    itr.node[ch - 'a'] = new Node();
                }
                // itr.words.add(word);
                itr = itr.node[ch - 'a'];
                if(itr.words.size() < 3) {
                    itr.words.add(word);
                }

            }


        }

         List<List<String>> find(String word) {
            Node itr = head;
            List<List<String>> ans = new ArrayList<>();

            for(char ch : word.toCharArray()) {
                if(itr == null || itr.node[ch - 'a'] == null) {
                    itr = null;
                    ans.add(new ArrayList<>());
                } else {
                    itr = itr.node[ch - 'a'];
                    ans.add(new ArrayList<>(itr.words));
                }
            }
            return ans;
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        Trie trie = new Trie();
        Arrays.sort(products);
        for(String product : products) {
            trie.insert(product);
        }

        return trie.find(searchWord);
    }
}