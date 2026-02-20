class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int target = 0;
        Set<Integer> bob = new HashSet<>();
        int aSum = 0, bSum = 0;
        for(int candy : aliceSizes) {
            aSum += candy;    
        }


        for(int candy : bobSizes) {
            bSum += candy;
            bob.add(candy);
        }

        target = (aSum + bSum) / 2;

        for(int candy : aliceSizes) {
            int t = target - aSum + candy;

            if(bob.contains(t)) {
                return new int[]{candy, t};
            }
        }
        return new int[]{};


    }
}