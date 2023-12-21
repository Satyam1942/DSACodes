class Solution {
    public int maxArea(int[] lines) {
    int i=0,j= lines.length-1;
        int maxArea = 0;

        while(i<j)
        {
            maxArea = Math.max(maxArea,(j-i)*Math.min(lines[i],lines[j]));
            if(lines[i]>lines[j])j--;
            else i++;
        }
        return maxArea;
    }
}