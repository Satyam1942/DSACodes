class Solution {
    public int minOperations(int[] nums) {
        int originalLength = nums.length;
        
        Arrays.sort(nums);

        List<Integer> numsWithoutDuplicates = new ArrayList<>();
        int prev = nums[0];
        numsWithoutDuplicates.add(prev);

        //creating new array by removing duplicates
        for(int i=1;i<originalLength;i++){
            if(nums[i]==prev)
                continue;
            else{
                numsWithoutDuplicates.add(nums[i]);
                prev = nums[i];
            }
        }

        int leftPointer=0,rightPointer=0;
        int minimumReplacements = originalLength;

        int maxNumber = numsWithoutDuplicates.get(leftPointer)+nums.length-1;
     
        while(leftPointer<=rightPointer && rightPointer<numsWithoutDuplicates.size()) {
            if(numsWithoutDuplicates.get(rightPointer)>maxNumber){
                int windowLength = rightPointer-leftPointer;
                minimumReplacements = Math.min(minimumReplacements, originalLength-windowLength);
                leftPointer++;
                maxNumber = numsWithoutDuplicates.get(leftPointer)+nums.length-1;
                continue;
            }
            rightPointer++;
        }

        int windowLength = rightPointer-leftPointer;
        minimumReplacements = Math.min(minimumReplacements, originalLength-windowLength);
        
        return minimumReplacements;
    }
}

/*
    Couple of Hints:
    Try to use sliding window for your advantage
    Create a new array without duplicates to avoid duplicates
 */