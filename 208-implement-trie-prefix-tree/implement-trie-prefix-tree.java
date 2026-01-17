class Trie {

    class Node {
        Node letter[] = new Node[26];
        boolean isWord;
    }

    Node trie;
    public Trie() {
        trie = new Node();
    }
    
    public void insert(String word) {
        Node itr = trie;
        for(char ch : word.toCharArray()) {
            int pos = ch - 'a';
            if(itr.letter[pos] == null) {
                itr.letter[pos] = new Node();
            }
            itr = itr.letter[pos];
        }
        itr.isWord = true;
    }
    
    public boolean search(String word) {
        Node itr = trie;
        for(char ch : word.toCharArray()) {
            int pos = ch - 'a';
            if(itr.letter[pos] == null) return false;
            itr = itr.letter[pos];
        }

        return itr.isWord;
    }
    
    public boolean startsWith(String prefix) {
         Node itr = trie;
        for(char ch : prefix.toCharArray()) {
            int pos = ch - 'a';
            if(itr.letter[pos] == null) return false;
            itr = itr.letter[pos];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */