class WordDictionary {

    class Node {
        Node letter[] = new Node[26];
        boolean isWord;
    }

    Node trie;
    public WordDictionary() {
        trie = new Node();
    }
    
    public void addWord(String word) {
        
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
        return dfs(word, 0, trie);
    }

    boolean dfs(String word, int ind, Node trie) {
        
        if(trie == null) return false;
        if(ind == word.length()) return trie.isWord;
        char ch = word.charAt(ind);

        if(ch == '.') {
            for(Node t : trie.letter) {
                if(t != null && dfs(word, ind + 1, t)) {
                    return true;
                }
            }
            return false;
        } else {
            return dfs(word, ind + 1, trie.letter[ch - 'a']);
        }
    
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */