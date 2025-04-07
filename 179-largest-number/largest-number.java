class Solution {

    public String largestNumber(int[] nums) {
        Integer[] numArr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(
            numArr,
            new Comparator<Integer>() {

                @Override
                public int compare(Integer a, Integer b) {
                    String str1 = String.valueOf(a) + String.valueOf(b);
                    String str2 = String.valueOf(b) + String.valueOf(a);
                    return str2.compareTo(str1);
                }
            }
        );
        if (numArr[0] == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int num : numArr) {
            sb.append(num);
        }
        return sb.toString();
    }
}
