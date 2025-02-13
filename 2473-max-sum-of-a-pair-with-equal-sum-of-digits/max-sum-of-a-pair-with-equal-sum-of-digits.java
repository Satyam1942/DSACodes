class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int length = nums.length;
        int maxVal = -1;

        for(int i=0; i<length; i++) {
            int number = nums[i];
            int sumOfDigits = 0;
            while(number>0) {
                int digit = number%10;
                sumOfDigits+=digit;
                number/=10;
            }
            if(map.containsKey(sumOfDigits)) {
                int prevMaxNum = map.get(sumOfDigits);
                maxVal = Math.max(maxVal, prevMaxNum+nums[i]);
                map.put(sumOfDigits, Math.max(nums[i], prevMaxNum));
            } else {
                map.put(sumOfDigits,nums[i]);
            }
        }       
        return maxVal;
    }
}