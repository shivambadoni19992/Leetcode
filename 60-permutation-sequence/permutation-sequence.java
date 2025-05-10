class Solution {

    List<Integer> list = new ArrayList<>();

    public int fact(int n){
        if(n == 0 || n == 1) return 1;
        return n * fact(n - 1);
    }

    public String helper(String str, int n, int k){
        if (n == 0) {
            return str;
        }

        int f = fact(n - 1);
        int group = (k - 1) / f;
        k = (k - 1) % f + 1;

        str += list.get(group);
        list.remove(group);

        return helper(str, n - 1, k);
    }

    public String getPermutation(int n, int k) {
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        return helper("", n, k);
    }
}
