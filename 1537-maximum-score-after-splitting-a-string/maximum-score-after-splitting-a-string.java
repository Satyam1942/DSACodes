class Solution {
    public int maxScore(String s) {
        int maxSum = Integer.MIN_VALUE;
        int tempZero =0,tempOne = 0;

        for(int i=0;i<s.length()-1;i++)
        {
            int sum = 0;
            if(s.charAt(i)=='0')tempZero++;
            else tempOne++;

            sum = tempZero - tempOne; 
            maxSum = Math.max(maxSum,sum);
        }

        if(s.charAt(s.length()-1)=='1') tempOne++;

        return maxSum+tempOne;
    }
}
