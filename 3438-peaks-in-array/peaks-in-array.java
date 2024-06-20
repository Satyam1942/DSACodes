class SegmentTree{
    int nums[];
    int sgTree[];
    int length;

    SegmentTree(int nums[]){
        this.nums = nums;
        this.length = nums.length;
        sgTree = new int[4*length];
    }

    void buildTree(int index, int left, int right){
        if(left==right){
            if(left==0 || left==length-1){
                sgTree[index] = 0;
            }else{
                if(nums[left]>nums[left+1] && nums[left]>nums[left-1])
                    sgTree[index] = 1;
                else
                    sgTree[index] = 0;
            }
            return;
        }

        int mid = (left+right)/2;
        buildTree(2*index+1,left,mid);
        buildTree(2*index+2,mid+1,right);

        sgTree[index] = sgTree[2*index+1]+sgTree[2*index+2];
    }

    int query(int index, int left, int right, int queryLeft, int queryRight){
        if(queryRight<left || queryLeft>right){
            return 0;
        }
        if(left>=queryLeft && right<=queryRight){

            return sgTree[index];
        }
        int mid = (left+right)/2;
        int leftCount = query(2*index+1,left,mid,queryLeft,queryRight);
        int rightCount = query(2*index+2,mid+1,right,queryLeft,queryRight);

        return leftCount+rightCount;
    }
    
    void updateArray(int index, int newVal){
        nums[index] = newVal;
    }

    void updateSegmentTree(int index, int left, int right, int changeIndex){
        if(left==right && left==changeIndex){
            if(nums[left]>nums[left+1] && nums[left]>nums[left-1]){
                sgTree[index] = 1;
            }else
                sgTree[index] = 0;
            return;
        }
        
        int mid = (left+right)/2;

        if(changeIndex<=mid)
            updateSegmentTree(2*index+1,left,mid,changeIndex);
        else
            updateSegmentTree(2*index+2,mid+1,right,changeIndex);

        sgTree[index] = sgTree[2*index+1]+sgTree[2*index+2];
    }
}

class Solution {
    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        SegmentTree sg = new SegmentTree(nums);
        sg.buildTree(0,0,nums.length-1);
        // System.out.println(Arrays.toString(sg.sgTree));
        List<Integer> ans = new ArrayList<>();
        int q = queries.length;
        int length = nums.length;
        for(int i=0;i<q;i++){
            int type = queries[i][0];
            if(type==1){
                int left = queries[i][1];
                int right = queries[i][2];
                if(left+1>right-1)
                    ans.add(0);
                else{
                    int count = sg.query(0,0,length-1,left+1,right-1);
                    ans.add(count);
                }
            }else{
                int newIndex = queries[i][1];
                int newVal = queries[i][2];
                sg.updateArray(newIndex,newVal);
                if(newIndex==0){
                    sg.updateSegmentTree(0,0,length-1,newIndex+1);
                }else if(newIndex == length-1){
                    sg.updateSegmentTree(0,0,length-1,newIndex-1);
                }else{
           
                    sg.updateSegmentTree(0,0,length-1,newIndex);
                    if(newIndex+1!=length-1)
                        sg.updateSegmentTree(0,0,length-1,newIndex+1);
                    if(newIndex-1!=0)
                        sg.updateSegmentTree(0,0,length-1,newIndex-1);
                }
                // System.out.println(Arrays.toString(sg.sgTree));
            }
        }

        return ans;
    }
}