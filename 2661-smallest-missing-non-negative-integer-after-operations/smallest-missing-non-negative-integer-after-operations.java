class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int length = nums.length;
        int modulusArr[] = new int[length];
        int mex = 0;
        List<Integer> newArr = new ArrayList<>();
        for(int i=0; i<length; i++) {
            if(nums[i]<0) {
                modulusArr[i] = (value - Math.abs(nums[i])%value)%value;
            } else { 
                modulusArr[i] = nums[i]%value; 
            } 
        }
        Arrays.sort(modulusArr);
        int multiple = 0;
        for(int i=0; i<length; i++) {
            if(i>0 && modulusArr[i]!=modulusArr[i-1]){
                multiple = 0;
            }
            newArr.add((modulusArr[i]+value*multiple));
            multiple++;
        }   
        Collections.sort(newArr);
        for(int i=0; i<length; i++) {
            if(mex!=newArr.get(i)) {
                break;
            }
            mex++;
        }
        return mex;

    }
}
/*
    [1, 3, 0, 1, 6, 1]
*/