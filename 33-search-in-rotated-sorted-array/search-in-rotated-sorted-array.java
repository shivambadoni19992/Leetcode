class Solution {
    public int search(int[] arr, int target) {
        int start = 0, end = arr.length -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == target) {
                return mid;
            }
            if(arr[start] <= arr[mid]) {
                if(arr[start] <= target && target < arr[mid]) {
                    end = mid -1;
                } else{
                    start = mid + 1;
                }
            } else{
                if(arr[mid] < target && target <= arr[end]) {
                    start = mid +1;
                }else{
                    end = mid - 1;
                }
            }
            
        }
        return -1;
    }
}

//  4 5 6 7 0 1 2

//  mid = 7
//  4 < 7 ? left is sofrted 
//  target between 4 and 7  then end mid -1
//  else start = mid +1;
//  else
//  right is sorted 
//  same as above
