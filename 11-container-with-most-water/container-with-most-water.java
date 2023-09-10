class Solution {
    public int maxArea(int[] height) {
    int right =0,left = height.length-1;
    int maxi =0;
        while(right<height.length)
        {
             int area = Math.min(height[right],height[left])*(left-right);
                maxi = Math.max(maxi,area);
            
            // if(right ==left){
            //     right++;
            //     left = height.length-1;
            //     continue;
            // }

            if(height[right] <=height[left]) {  right++;continue;}
            else{left--; continue;}
            
        }
        return maxi;
    }
}