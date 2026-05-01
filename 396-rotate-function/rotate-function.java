class Solution {
    public int maxRotateFunction(int[] nums) {
        int length  = nums.length;
        int sum = 0;
        int hash = 0;
        int maxHash = Integer.MIN_VALUE;
        int newNums[] = new int[2*length];

        for(int i=0;i<length; i++ ){
            sum+=nums[i];
        }

        for(int i=0;i<2*length;i++) {
            newNums[i] = nums[i%length]; 
        }

        for(int i=0; i<length;i++) {
            hash += i*nums[i];
        }

        maxHash = Math.max(maxHash, hash);

        for(int i=newNums.length-1; i>=length; i--) {
            hash = hash + sum- newNums[i]*length;
            maxHash = Math.max(maxHash, hash);
        }

        return maxHash;
    }
}

/*
25 + 9-18 = 16
16 + 13-6 = 23

4 3 2 6 4 3 2 6
    0 1 2 3
 */