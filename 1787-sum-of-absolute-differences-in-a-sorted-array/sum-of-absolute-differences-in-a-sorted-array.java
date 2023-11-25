class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {

        int differenceMaxVal  =  0;
        int length = nums.length;
        for(int i=0;i<length;i++) differenceMaxVal+= Math.abs(nums[length-1]-nums[i]);

        int ans[] = new int[length];
        ans[length-1] =  differenceMaxVal;

        for(int i=length-2;i>=0;i--)
        {
            int difNextNum = nums[i+1]-nums[i];
            ans[i] = differenceMaxVal + ((length-i-1)-(i+1))*difNextNum; 
            differenceMaxVal = ans[i];
        }

        return ans;
    }
}

/*
Explanation:
5-  
3,2,0 =5 
3-
2+
5-(2*1) = 3
5-(3*1) = 
if you know a-b ;
            a-c;
            b-c by just subtracting
            5-3
            5-2
            5= {3,2,0} = 5
                3 = 2 subtract all by 2 
                5 + (2*1) - (2*2) = 3

                2 = 1 
                5+ (no of index after 2*1)- (no of index  before 2)*1
                3+ (2*1) - 1*1

 */