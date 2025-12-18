class Trie {
    Trie letter[] = new Trie[26];
    String word;
}

class Solution {

    Trie buildTrie(String words[]) {
        Trie t = new Trie();

        for(String word : words) {
            Trie trie = t;
            for(char ch : word.toCharArray()) {
                if (trie.letter[ch - 'a'] == null) {
                    trie.letter[ch - 'a'] = new Trie();
                }
                trie = trie.letter[ch - 'a'];
            }
            trie.word = word;
        }
        return t;
    }

    void dfs(char [][]board, Trie dict, int i, int j, List<String> result) {
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#' || dict.letter[board[i][j] - 'a'] == null) return;

        char c = board[i][j];
    Trie next = dict.letter[c - 'a'];

    if (next == null) return;

    if (next.word != null) {
        result.add(next.word);
        next.word = null;
    }

    board[i][j] = '#';

    dfs(board, next, i + 1, j, result);
    dfs(board, next, i - 1, j, result);
    dfs(board, next, i, j + 1, result);
    dfs(board, next, i, j - 1, result);

    board[i][j] = c;


    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = buildTrie(words);
        List<String> result = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, trie, i, j, result);
            }
        }
        return result;
    }
}