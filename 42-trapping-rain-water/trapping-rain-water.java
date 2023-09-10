class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int left=0,right=1;
        int count=0;
        int forward[] = new int[len];
        int backward[] = new int[len];

        while(right<len)
        {
            if(height[right]<height[left])
            {
                forward[right]=height[left]-height[right];
            }
            else
            {
                left = right;
            }
            right++;
        }

        right = len-2;
        left =len-1;
        while(right>=0)
        {
            if(height[right]<height[left])
            {
                backward[right]=height[left]-height[right];
            }
            else
            {
                left = right;
            }
            right--;
        }

        for(int i=0;i<len;i++)
        {
            count+= Math.min(forward[i],backward[i]);
        }
        return count;
    }
}