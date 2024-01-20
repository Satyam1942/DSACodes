class Solution {
    final long mod = (long) (1e9 + 7);

    void computeNextPrevious(int nums[], int nextPreviousElement[]) {
        int length = nums.length;
        Arrays.fill(nextPreviousElement, length);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!st.isEmpty() && nums[i] < nums[st.peek()]) {
                nextPreviousElement[st.pop()] = i;
            }
            st.push(i);
        }
    }

    public int sumSubarrayMins(int[] nums) {
        
        int length = nums.length;
	    int nextPreviousElement[] = new int[length];
	    computeNextPrevious(nums,nextPreviousElement);

	        long cache[] = new long[length];
	        for(int i =length-1;i>=0;i--)
            {
	        int nextPrevEle = nextPreviousElement[i];
	        long curVal = (long)(nextPrevEle-i)*(long)nums[i];

	        if(nextPrevEle==length) cache[i] = curVal;
	        else cache[i] = curVal+cache[nextPrevEle];
            }   

	        int sum = 0;
            for(int i=0;i<length;i++)
            {
	            sum=(int)((sum+cache[i])%mod);
            }

            return sum;

    }
}