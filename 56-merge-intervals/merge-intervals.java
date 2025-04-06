class Solution {

    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> merge = new ArrayList<>();
        Arrays.sort(
            intervals,
            new Comparator<int[]>() {

                @Override
                public int compare(int a[], int b[]) {
                    return a[0] - b[0];
                }
            }
        );
        int i = 0;
        for (int a[] : intervals) {
            if (merge.size() == 0 || merge.get(i - 1)[1] < a[0]) {
                merge.add(a);
                i++;
            } else {
                merge.get(i - 1)[1] = Math.max(merge.get(i - 1)[1], a[1]);
            }
        }
        return merge.toArray(new int[merge.size()][]);
    }
}
