class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int length = nums.length;
        int prefixAns[] = new int[length-1];
        boolean ans[] = new boolean[queries.length];
        boolean isEven = nums[0]%2==0;
        int j = 0;

        for(int i=1;i<length;i++)  {
            if(isEven) {
                if(nums[i]%2!=0) {
                    prefixAns[j] = (j==0)?1:prefixAns[j-1]+1;
                    isEven = !isEven;
                } else {
                    prefixAns[j] = 0;
                }
            } else {
                if(nums[i]%2==0) {
                    prefixAns[j] = (j==0)?1:prefixAns[j-1]+1;
                    isEven = !isEven;
                } else {
                    prefixAns[j] = 0;
                }
            }
            j++;
        }

        for(int i=0;i<queries.length;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            if(l==r) {
                ans[i] = true;
                continue;
            }
            int count = (l==0)? prefixAns[r-1]: prefixAns[r-1]-prefixAns[l-1];
           
            if(count!=(r-l)){
                ans[i] = false;
            } else
                ans[i] =true;
        }
        return ans;
    }
}

/*
    3, 4, 1, 2, 6
     1   2  3  0

     4,3,1,6
      1 0 1
*/