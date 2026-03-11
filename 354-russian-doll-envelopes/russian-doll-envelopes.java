class Solution {

    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int n = envelopes.length;

        int[] lis = new int[n];
        int size = 0;

        for (int[] e : envelopes) {

            int h = e[1];

            int pos = Arrays.binarySearch(lis, 0, size, h);

            if (pos < 0) pos = -(pos + 1);

            lis[pos] = h;

            if (pos == size) size++;
        }

        return size;
    }
}