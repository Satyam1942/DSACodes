class Solution {
    public int maxScore(String s) {
        int  noOfOne = 0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1') noOfOne++;
        }

        int maxSum = 0;
        int tempZero =0,tempOne = 0;
        for(int i=0;i<s.length()-1;i++)
        {
            int sum = 0;
            if(s.charAt(i)=='0')tempZero++;
            else tempOne++;

            sum = tempZero + (noOfOne-tempOne); 
            maxSum = Math.max(maxSum,sum);
        }

        return maxSum;
    }
}