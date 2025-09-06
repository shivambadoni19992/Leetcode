class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        int []finishing = new int[friends.length];
        Map<Integer, Integer> ord = new HashMap<>();

        for(int i = 0; i < friends.length; i++) {
            ord.put(friends[i], i);
        }
        int c = 0;
        for(int i = 0; i < order.length; i++) {
            if(ord.containsKey(order[i])) {

                finishing[c++] = order[i];
            }
        }
        return finishing;
    }
}