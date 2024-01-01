class Solution {
    public int findContentChildren(int[] greed, int[] sz) {
       Arrays.sort(greed);
    Arrays.sort(sz);
    int N = greed.length;
    int M = sz.length; 
  
    int count =0;
    int left=0,right=0;
    while(left<M && right<N)
    {
        if(sz[left]>=greed[right]) {
            count++;
            right++;
        }
        left++;
    }
    return count;
     
    }
}