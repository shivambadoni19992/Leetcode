class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        int level = 1;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) return level;
                char[] word = currentWord.toCharArray();
                for (int j = 0; j < currentWord.length(); j++) {
                    char originalChar = word[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        word[j] = c;
                        String checkString = new String(word);
                        if (set.contains(checkString)) {
                            queue.add(checkString);
                            set.remove(checkString);
                        }
                    }
                    word[j] = originalChar;
                }
            }
            level++;
        }
        return 0;
    }
}
