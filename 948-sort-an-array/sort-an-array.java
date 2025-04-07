class Solution {

    public void mergeArray(int[] nums, int start, int mid, int end) {
        int leftSize = mid - start + 1;
        int rightSize = end - mid;
        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];
        for (int i = 0; i < leftSize; i++) {
            leftArr[i] = nums[i + start];
        }
        for (int i = 0; i < rightSize; i++) {
            rightArr[i] = nums[i + mid + 1];
        }
        int i = 0, j = 0, k = start;
        while (i < leftSize || j < rightSize) {
            if (j >= rightSize || i < leftSize && leftArr[i] < rightArr[j]) {
                nums[k++] = leftArr[i++];
            } else {
                nums[k++] = rightArr[j++];
            }
        }
    }

    public void mergeSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        mergeArray(nums, start, mid, end);
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
}
