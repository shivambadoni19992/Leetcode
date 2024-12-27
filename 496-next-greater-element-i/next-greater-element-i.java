class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack();
        HashMap<Integer, Integer> nextGreaterElement = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            nextGreaterElement.put(nums2[i],-1);
            while(!st.isEmpty() && st.peek() < nums2[i]){
                nextGreaterElement.put(st.pop(),nums2[i]);
            }
            st.add(nums2[i]);
        }
        for(int i=0;i<nums1.length;i++){
            nums1[i] = nextGreaterElement.get(nums1[i]);
        }
        return nums1;
    }
}
