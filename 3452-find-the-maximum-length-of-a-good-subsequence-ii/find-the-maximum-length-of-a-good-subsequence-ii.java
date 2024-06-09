class Solution {
    public int maximumLength(int[] nums, int k) {
        int length = nums.length;
        HashMap<Integer,Integer> lastSeen = new HashMap<>();
        int longestSubsequenceParticularK[] = new int[k+1];
        int cache[][] = new int[length][k+1];

        cache[0][0] = 1;
        lastSeen.put(nums[0],0);
        Arrays.fill(longestSubsequenceParticularK, 1);

        for(int i=1;i<length;i++){
            cache[i][0] = 1;
            // if number  already exists ; we can get prevSubsequenceLength+1 with same k
            if(lastSeen.containsKey(nums[i])){
                for(int j=0;j<=k;j++){
                    cache[i][j] = 1+cache[lastSeen.get(nums[i])][j]; 
                }
            }

            lastSeen.put(nums[i],i);

            //if we are picking up a different number or number doesnot exist then calculate max for k+1
            // for calculating this we have to maintain what is longest subsequence that we have got till k and  add 1 to it
            for(int j=0;j<k;j++){
                cache[i][j+1] = Math.max(cache[i][j+1], longestSubsequenceParticularK[j]+1);
            }

            for(int j=0;j<=k;j++){
                longestSubsequenceParticularK[j] = Math.max(cache[i][j], longestSubsequenceParticularK[j]);
            }
        }

        int maxLengthSubsequence = 1;
        for(int i=0;i<=k;i++){
            maxLengthSubsequence = Math.max(maxLengthSubsequence, longestSubsequenceParticularK[k]);
        }
        return maxLengthSubsequence;
    }
}