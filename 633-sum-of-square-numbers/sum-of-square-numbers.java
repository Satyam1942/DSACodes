class Solution {
    public boolean judgeSquareSum(int c) {
      long left = 0;
      long right = (long)Math.sqrt(c);
      while(left<=right){
        long ans = left*left+right*right;
        if(ans==(long)c)
            return true;
        else if(ans>(long)c)
            right--;
        else
            left++;
      }
      return false;
    }
}

/*
    101

 */