class Solution {
    public boolean backspaceCompare(String s, String t) {
        int backSpaceCountS = 0, backSpaceCountT = 0;
        int i=s.length()-1, j = t.length()-1;
        while(i>=0 && j>=0)
        {
            if(backSpaceCountS==0 && backSpaceCountT==0)
            {
                if(s.charAt(i)!='#' && t.charAt(j)!='#')
                {
                    if(s.charAt(i)!=t.charAt(j)) return false;
                    i--;
                    j--;
                }
                
            }
            if(i<0 || j<0) break;

            if(s.charAt(i)=='#')
            {
                backSpaceCountS++;
                i--;
            }
            else if(backSpaceCountS!=0)
            {
                backSpaceCountS--;
                i--;
            }
            

            if(t.charAt(j)=='#')
            {
                backSpaceCountT++;
                j--;
            }
            else if(backSpaceCountT!=0)
            {
                backSpaceCountT--;
                 j--;
            }

        }

        while(j>=0)
        {
             if(t.charAt(j)=='#')
            {
                backSpaceCountT++;
                j--;
            }
            else if(backSpaceCountT!=0)
            {
                backSpaceCountT--;
                 j--;
            }
            else return false;
        }

        while(i>=0)
        {
             if(s.charAt(i)=='#')
            {
                backSpaceCountS++;
                i--;
            }
            else if(backSpaceCountS!=0)
            {
                backSpaceCountS--;
                i--;
            }else return false;
        }
        
        return true;        
    }
}