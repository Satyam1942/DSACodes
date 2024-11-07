class Solution {
      public int largestCombination(int[] A) {
        int res = 0, cur = 0;
        for (int i = 1; i <= 10000000; i <<= 1) {
            cur = 0;
            for (int a : A)
                if ((a & i) > 0)
                    cur++;
            res = Math.max(res, cur);
        }
        return res;
    }
}

/*
    84 =>   1010100
    40 =>   0101000
    66 =>   1000010

            1111122
 */