class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int length = nums.length;
        Integer cache[][] = new Integer[length][length + 2];
        Arrays.sort(nums);

        cache[0][length+1] = 1;
        for (int i = 0; i < length; i++) 
            cache[i][0] = 1;

        int maxOfEachRow[] = new int[length];
        Arrays.fill(maxOfEachRow,-1);

        for (int index = 1; index < length; index++) {
            int maxi = 1, maxIndex = -1;

            for (int prevIndex = 0; prevIndex < index; prevIndex++) {
                if (nums[index] % nums[prevIndex] == 0) 
                    cache[index][prevIndex + 1] = cache[prevIndex][length + 1] + 1;
                else 
                    cache[index][prevIndex + 1] = cache[index][prevIndex];
        
                if (maxi < cache[index][prevIndex+1]) {
                    maxi = cache[index][prevIndex+1];
                    maxIndex = prevIndex;
                }
            }
            cache[index][length + 1] = maxi;
            maxOfEachRow[index] = maxIndex;
        }

        int maxCount = 0, maxRow = 0;
        for(int i=0;i<length;i++){
            if(cache[i][length+1]>maxCount){
                maxCount = cache[i][length+1];
                maxRow = i;
            }
        }
        
        Stack<Integer> st = new Stack<>();
        int i = maxRow;
        
        while (i != -1) {
            st.push(nums[i]);
            i = maxOfEachRow[i];
        }

        List<Integer> subset = new ArrayList<>();
        while (!st.isEmpty())
            subset.add(st.pop());
        return subset;

    }
}