class Trie {
    Trie next[] = new Trie[256];
    String word;
}

class WordDictionary {

    Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }
    
    public void addWord(String word) {
        Trie t = trie;
        for(char c : word.toCharArray()) {
            if(t.next[c] == null) {
                t.next[c] = new Trie();
            }
            t = t.next[c];
        }
    
        t.word = word;
        
    }
    
    public boolean search(String word) {
        return dfs(word, 0, trie);
    }

    private boolean dfs(String word, int index, Trie node) {
        if (node == null) return false;
        if (index == word.length()) return node.word != null;

        char c = word.charAt(index);

        if (c == '.') {
            for (Trie child : node.next) {
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            return dfs(word, index + 1, node.next[c]);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */