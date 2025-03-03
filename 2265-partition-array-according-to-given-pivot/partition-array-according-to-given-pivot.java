class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int length = nums.length;
        List<Integer> firstHalf = new ArrayList<>();
        List<Integer> secondHalf = new ArrayList<>();
        List<Integer> center = new ArrayList<>();
        boolean isFirstHalf = true;

        for(int i=0;i<length;i++) {
            if(nums[i]==pivot) {
                center.add(nums[i]);
                isFirstHalf = false;
                continue;
            }

            if(isFirstHalf) {
                if(nums[i]<pivot) {
                    firstHalf.add(nums[i]);
                } else {
                    secondHalf.add(nums[i]);
                }
            } else {
                if(nums[i]<pivot) {
                    firstHalf.add(nums[i]);
                } else {
                    secondHalf.add(nums[i]);
                }
            }
        }

        List<Integer> combinedList = new ArrayList<>();
        combinedList.addAll(firstHalf);
        combinedList.addAll(center);
        combinedList.addAll(secondHalf);

        int ans[] = new int[length];
        for(int i=0; i<length; i++) {
            ans[i] = combinedList.get(i);
        }
        return ans;
    }
}

/*
    
*/