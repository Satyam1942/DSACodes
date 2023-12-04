class Solution {
    public String largestGoodInteger(String num) {
        int i=0,j=0;
        int maxNum = Integer.MIN_VALUE;
        String goodStr = "";
        while(j<=num.length())
        {
            if(j<num.length() && num.charAt(i)==num.charAt(j) && (j-i)<=2) j++;
            else 
            {
                if((j-i)==3)
                {
                String temp = num.substring(i,j);
                if(maxNum<Integer.valueOf(temp))
                {
                    maxNum = Integer.valueOf(temp);
                    goodStr = temp;
                }
                }
                i=j;
                j++;
            }
        }

        return goodStr;
    }
}