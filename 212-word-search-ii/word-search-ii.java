class Solution {
    

        class Node {
            Node letter[] = new Node[26];
            String word;
        }

        Node trie = new Node();

        void insert(String word) {
            Node itr = trie;

            for(char ch : word.toCharArray()) {
                int pos = ch - 'a';
                if(itr.letter[pos] == null) {
                    itr.letter[pos] = new Node();
                }
                itr = itr.letter[pos];
            }
            itr.word = word;
        }
    
    public List<String> findWords(char[][] board, String[] words) {
        Node itr = trie;
        for(String word : words) {
            insert(word);
        }
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, itr, ans);
            }
        }
        return ans;
    }

    void dfs(char [][]board, int row, int col, Node itr, List<String> ans) {
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '#' || itr.letter[board[row][col] - 'a'] == null) return;
       

        char ch = board[row][col];
        board[row][col] = '#';
        itr = itr.letter[ch - 'a'];
        if(itr.word != null) {
            ans.add(itr.word);
            itr.word = null;
        }
        dfs(board, row + 1, col, itr, ans);
        dfs(board, row, col + 1, itr, ans);
        dfs(board, row - 1, col, itr, ans);
        dfs(board, row, col - 1, itr, ans);
        board[row][col] = ch;
    }
}