class Solution {

    public int nextGreaterElement(int z) {
        if (z < 10) return -1;
        long n = z;
        List<Long> list = new ArrayList<>();
        list.add(n % 10);
        n = n / 10;
        long x = 0, y = 0;
        while (n != 0) {
            x = n % 10;
            n = n / 10;
            if (list.get(list.size() - 1) > x) {
                y = 1;
                break;
            }
            list.add(x);
        }
        if (y == 1) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > x) {
                    long t = list.get(i);
                    list.set(i, x);
                    x = t;
                    break;
                }
            }
            n = n * 10 + x;
            Collections.sort(list);
            for (long i : list) {
                n = n * 10 + i;
            }
            return (n > Integer.MAX_VALUE) ? -1 : (int) n;
        } else {
            return -1;
        }
    }
}
