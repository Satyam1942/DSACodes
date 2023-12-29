class Pair {
    int index, val;

    Pair(int val, int index) {
        this.val = val;
        this.index = index;
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int length = nums.length;
        int maxWindow[] = new int[length - k + 1];

        ArrayDeque<Pair> deq = new ArrayDeque<>();

        int left = 0, right = left + k - 1;
        while (right < length) {
            if (left == 0) {
                for (int i = left; i <= right; i++) {
                    while (!deq.isEmpty() && nums[i] > deq.peekFirst().val)
                        deq.removeFirst();
                    deq.addFirst(new Pair(nums[i], i));
                }
            }

            // selecting max from deque
            maxWindow[left] = deq.peekLast().val;

            left++;
            right++;

            // removing from deque
            while (!deq.isEmpty() && deq.peekLast().index < left)
                deq.removeLast();

            // add into deque
            if (right < length) {
                while (!deq.isEmpty() && nums[right] > deq.peekFirst().val)
                    deq.removeFirst();
                deq.addFirst(new Pair(nums[right], right));
            }

        }

        return maxWindow;

    }
}