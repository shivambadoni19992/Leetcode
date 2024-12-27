class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack();
        HashMap<Integer, Integer> nextGreaterElement = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            int a = nums2[i];
            nextGreaterElement.put(a,-1);
            while(!st.isEmpty() && st.peek() < a){
                nextGreaterElement.put(st.pop(),a);
            }
            st.add(a);
        }
        for(int i=0;i<nums1.length;i++){
            nums1[i] = nextGreaterElement.get(nums1[i]);
        }
        return nums1;
    }
}
