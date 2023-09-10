class Solution {
    public int maxArea(int[] height) {
    int right =0,left = height.length-1;
    int maxi =0;
        while(right<left)
        {
             int area = Math.min(height[right],height[left])*(left-right);
                maxi = Math.max(maxi,area);

            if(height[right] <=height[left]) {  right++;continue;}
            else{left--; continue;}
        }

        return maxi;
    }
}