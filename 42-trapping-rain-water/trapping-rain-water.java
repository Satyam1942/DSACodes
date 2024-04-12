class Solution {
    public int trap(int[] height) {
        int width = height.length;
        int forward[] = new int[width];
        int backward[] = new int[width];

        int left = 0, right = 1;
        while(right<width){
            if(height[left]>height[right]){
                forward[right] = height[left]-height[right];
            }else{
                left = right;
            }
            right++;
        }   

        left = width-1;
        right = width-2;
        while(right>=0){
            if(height[left]>height[right]){
                backward[right] = height[left]-height[right];
            }else{
                left = right;
            }
            right--;
        }

        int totalRainWater = 0;
        for(int i=0;i<width;i++){
            totalRainWater+= Math.min(forward[i],backward[i]);
        }

        return totalRainWater;

    }
}