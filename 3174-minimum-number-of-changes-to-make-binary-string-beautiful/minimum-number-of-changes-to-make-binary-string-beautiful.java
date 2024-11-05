class Solution {
    public int minChanges(String s) {
        int continuousCount = 0,changeCount = 0;
        
        char prev = s.charAt(0);
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==prev)
            {
                continuousCount++;
            }
            else
            {
                if(continuousCount%2!=0)
                {
                    changeCount++;
                    continuousCount++;
                }
                else 
                {
                continuousCount = 1;
                prev = s.charAt(i);
                }
                
            }
        }
        
        return changeCount;
        
    }
}