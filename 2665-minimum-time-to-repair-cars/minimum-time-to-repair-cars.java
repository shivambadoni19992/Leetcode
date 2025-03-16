class Solution {
    public long countELe(long time){
        long sqrt = (long)Math.sqrt(time);
        return sqrt;
    }
    public long repairCars(int[] ranks, int cars) {
        long low = 1,high = Long.MAX_VALUE;
        while(low<=high){
            long mid= low + (high-low)/2;
            long c= 0;
            for(int i = 0;i<ranks.length;i++){
                c+= countELe(mid/ranks[i]);
            }
            if(c>=cars){
                high = mid-1;
            }else{
                low= mid+1;
            }

        }
        return low;
    }
}