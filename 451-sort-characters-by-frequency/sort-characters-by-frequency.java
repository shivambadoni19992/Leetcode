class Pair {
    int count;
    char charater;

    Pair(int count, char charater) {
        this.count = count;
        this.charater = charater;
    }
}

class Solution {

    public String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        PriorityQueue<Pair> queue = new PriorityQueue<>(
            new Comparator<>() {

                @Override
                public int compare(Pair a, Pair b) {
                    return b.count - a.count;
                }
            }
        );
        StringBuilder ans = new StringBuilder();
        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }
        for (char ch : frequencyMap.keySet()) {
            queue.add(new Pair(frequencyMap.get(ch), ch));
        }
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int freq = pair.count;
            char ch = pair.charater;
            while (freq > 0) {
                ans.append(ch);
                freq--;
            }
        }
        return ans.toString();
    }
}
