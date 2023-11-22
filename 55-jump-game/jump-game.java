class Solution {

    public boolean canJump(int[] arr) {
       Boolean dp[] = new Boolean[arr.length];
        dp[arr.length-1] = true;
        int falseCount = 0;
        for(int i=arr.length-2;i>=0;i--)
        {
            if((!dp[i+1] && falseCount>=arr[i]) ||  arr[i]==0)
            {
                dp[i] = false;
                falseCount++;
            }
            else {dp[i] = true; falseCount=0; }

        }
            return dp[0];
    }
}