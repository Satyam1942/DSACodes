class Solution {
    public int countHomogenous(String s) {
        int i=0,j=0;
        long count =0,mod = (long)(1e9+7);
        int length = s.length();
        while(j<length)
        {
            if(s.charAt(j)!=s.charAt(i))
            {
                i=j;
                continue;
            }
            else count= (count+(long)(j-i+1))%mod;
            j++;
        }

        return (int)count;
    }
}

