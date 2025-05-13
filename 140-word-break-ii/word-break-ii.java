class TrieNode {
    boolean isEnd;
    TrieNode[] children;

    TrieNode() {
        isEnd = false;
        children = new TrieNode[26];
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
}

class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String word : wordDict) {
            trie.insert(word);
        }
        Map<Integer, List<String>> dp = new HashMap<>();
        for (int startIdx = s.length(); startIdx >= 0; startIdx--) {
            List<String> validSentences = new ArrayList<>();
            TrieNode currentNode = trie.root;
            for (int endIdx = startIdx; endIdx < s.length(); endIdx++) {
                char c = s.charAt(endIdx);
                int index = c - 'a';

                if (currentNode.children[index] == null) {
                    break;
                }

                currentNode = currentNode.children[index];

                if (currentNode.isEnd) {
                    String currentWord = s.substring(startIdx, endIdx + 1);

                    if (endIdx == s.length() - 1) {
                        validSentences.add(currentWord);
                    } else {
                        List<String> sentencesFromNextIndex = dp.get(endIdx + 1);
                        for (String sentence : sentencesFromNextIndex) {
                            validSentences.add(currentWord + " " + sentence);
                        }
                    }
                }
            }
            dp.put(startIdx, validSentences);
        }
        return dp.getOrDefault(0, new ArrayList<>());
    }
}
