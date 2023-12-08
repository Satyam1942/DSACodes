class Solution {
    public int[] mostCompetitive(int[] nums, int k) {

        int n = nums.length;
        int res[] = new int[k];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && nums[i]<st.peek() && nums.length-i+st.size()>k) st.pop();
            if(st.size()<k) st.push(nums[i]); 
        }
        
        for(int i=k-1;i>=0;i--) res[i] = st.pop();

        return res;
    }
}


/*
Use monotonic stack with keyCondition: pop only if you can get array of size k in future 
 */