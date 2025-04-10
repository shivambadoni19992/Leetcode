class Solution {

    public String getRange(int start, int last) {
        StringBuilder s = new StringBuilder();
        if (start == last) {
            s.append(start);
        } else {
            s.append(start);
            s.append("->");
            s.append(last);
        }
        return s.toString();
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0) return ans;
        int start = nums[0];
        int last = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - last == 1) {
                last = nums[i];
            } else {
                String s = getRange(start, last);
                ans.add(s.toString());
                start = nums[i];
                last = nums[i];
            }
        }
        String s = getRange(start, last);
        ans.add(s.toString());

        return ans;
    }
}
