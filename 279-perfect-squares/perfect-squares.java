class Solution {
    void getAllPerfectSquares(int n, List<Integer> perfectSquare) {

        for (int i = 1; i * i <= n; i++) {
            perfectSquare.add(i * i);
        }
    }

    int minimumSum(int n, int sum, int index, List<Integer> perfectSquare,
            Integer cache[][]) {

        if (index == perfectSquare.size()) {
            if (sum == n)
                return 0;
            else
                return Integer.MAX_VALUE;
        }

        if (cache[sum][index] != null)
            return cache[sum][index];

        int notTake = minimumSum(n, sum, index + 1, perfectSquare, cache);

        int take = Integer.MAX_VALUE;
        int add = perfectSquare.get(index);

        if (sum + add <= n){
            take = minimumSum(n, sum + add, index, perfectSquare, cache);
            if(take!=Integer.MAX_VALUE)
                take+=1;
        }

        return cache[sum][index] = Math.min(take, notTake);
    }

    public int numSquares(int n) {
        List<Integer> perfectSquare = new ArrayList<>();

        getAllPerfectSquares(n, perfectSquare);

        Integer cache[][] = new Integer[n + 1][perfectSquare.size()];

        return minimumSum(n, 0, 0, perfectSquare, cache);
    }
}