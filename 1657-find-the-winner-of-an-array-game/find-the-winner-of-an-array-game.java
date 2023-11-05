class Solution {
    public int getWinner(int[] arr, int k) {
        int length = arr.length;
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<length;i++) maxi = Math.max(maxi,arr[i]);
       
        int left =0, right =1;
        int  winnerCount = 0;
        while(right<length)
        {
            if(arr[left]>arr[right])
            {
                winnerCount++;
            }
            else
            {
                left = right;
                winnerCount=1; 
            }
            if(winnerCount==k) return arr[left];
            right++;
        }

        return maxi;
    }
}