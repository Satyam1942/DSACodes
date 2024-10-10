class Pair {
    int num;
    int index;
    Pair(int num, int index) {
        this.num = num;
        this.index = index;
    } 
}

class Solution {
    int maxIndexDif = 0;
    void merge(int low, int mid, int high, Pair nums[]) {
        List<Pair> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        int minIndex = Integer.MAX_VALUE;

        while(left<=mid && right<=high) {
            if(nums[left].num<=nums[right].num) {
                temp.add(new Pair(nums[left].num, nums[left].index));
                minIndex = Math.min(minIndex, nums[left].index);
                left++;
            } else {
                maxIndexDif = Math.max(maxIndexDif, nums[right].index - minIndex);
                temp.add(new Pair(nums[right].num, nums[right].index));
                right++;
            }
        }

        while(left<=mid) {
            temp.add(new Pair(nums[left].num,nums[left].index));
            left++;
        }

        while(right<=high) {
            maxIndexDif = Math.max(maxIndexDif, nums[right].index - minIndex);
            temp.add(new Pair(nums[right].num, nums[right].index));
            right++;
        }

        for(int i = low;i<=high;i++){
            nums[i] = temp.get(i-low);
        }
    }

    void mergeSort(int left, int right, Pair nums[]) {
        if(left>=right) {
            return;
        }
        int mid = (left+right)/2;
        mergeSort(left,mid,nums);
        mergeSort(mid+1,right,nums);
        merge(left, mid, right, nums);
    }

    public int maxWidthRamp(int[] nums) {
        int length = nums.length;
        Pair num[] = new Pair[length];
        for(int i=0;i<length;i++) {
            num[i] = new Pair(nums[i],i);
        }
        mergeSort(0, length-1, num);
        return maxIndexDif;
    }
}

/*
    (9,0)   (8,1)    (1,2)       (0,3)  (1,4)         (9,5) (4,6)   (0,7)   (4,8)  (5,9)
    (1,2) (8,1) (9,0)   
*/