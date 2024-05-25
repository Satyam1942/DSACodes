class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int length = nums.length;
        int maxSlidingWindow[] = new int[length-k+1];

        for(int i=0;i<k;i++){
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
        }


        for(int i=k;i<length;i++){
            maxSlidingWindow[i-k] = nums[deque.peekFirst()];
            if(deque.peekFirst()<=i-k)
                deque.removeFirst();
                
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
        
        }
        maxSlidingWindow[length-k] = nums[deque.peekFirst()];
        
        return maxSlidingWindow;
    }
}