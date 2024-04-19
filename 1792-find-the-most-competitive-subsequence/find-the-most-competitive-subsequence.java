class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int mostCompetitveSubsequence[] = new int[k];
        int n = nums.length;
        ArrayDeque<Integer> adq = new ArrayDeque<>();

        for(int i=0;i<=n-k;i++){
            while(!adq.isEmpty() && adq.peekLast()>nums[i]){
                adq.pollLast();
            }
            adq.addLast(nums[i]);
        }

        int pointer = 0;
        for(int i=n-k+1;i<n;i++){
            mostCompetitveSubsequence[pointer++] = adq.pollFirst();
            while(!adq.isEmpty() && adq.peekLast()>nums[i])
                adq.pollLast();
            adq.addLast(nums[i]);
        }

        mostCompetitveSubsequence[pointer++] = adq.pollFirst();
        return  mostCompetitveSubsequence;
    }
}

/*
    2,3,3,4
   

   2,3,3,4

   0 to n-k add all numbers in monotonic form in array deque
   then poll element from bottom add to the answer 
   and then add one by one to array deque

   6
   4
   3
   3
   2
*/
