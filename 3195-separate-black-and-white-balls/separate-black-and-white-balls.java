class Solution {
    public long minimumSteps(String s) {
        long count = 0l;
        int noOfZeroes = 0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='0')
            {
                noOfZeroes++;
                int finalIndex  =noOfZeroes-1;
                count+=(long)(i-finalIndex);
            }
        }
        
        return count;
    }
}