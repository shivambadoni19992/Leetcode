class Solution {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int nextSmaller[] = new int[n];
        int prevSmaller[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                nextSmaller[st.pop()] = i;
            }
            st.add(i);
        }
        while (!st.isEmpty()) nextSmaller[st.pop()] = n;
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                prevSmaller[st.pop()] = i;
            }
            st.add(i);
        }
        while (!st.isEmpty()) prevSmaller[st.pop()] = -1;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (nextSmaller[i] - prevSmaller[i] - 1));
        }
        return maxArea;
    }
}
