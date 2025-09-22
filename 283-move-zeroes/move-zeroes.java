class Solution {
    void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void moveZeroes(int[] nums) {
       int length = nums.length;
       Queue<Integer> q = new LinkedList<>();
       for(int i=0; i<length; i++) {
         if(nums[i] == 0 ) {
            q.add(i);
         }
         if(nums[i]!=0 && !q.isEmpty()) {
            int moveIndex = q.poll();
            swap(nums, i, moveIndex);
            q.add(i);
         }
       } 
    }
}

/*     j 
    [1,0,0,3, 12]
       i 
*/