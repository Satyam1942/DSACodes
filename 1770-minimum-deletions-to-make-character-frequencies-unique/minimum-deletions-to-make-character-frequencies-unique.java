class Solution {
    public int minDeletions(String s) {
        int len = s.length();
        //We can also use List here
        List<Character>[] set = new ArrayList[len+1];
        char [] freq = new char[26];
        for(int i=0;i<=len;i++)set[i] = new ArrayList<>();

        for(int i=0;i<s.length();i++)
        {
            freq[s.charAt(i)-97]++;
        }

        for(int i=0;i<26;i++)
        {
            if(freq[i]==0) continue;
            int f = freq[i];
            set[f].add((char)(i+97));
        }

        int count=0,incrementor=0;
        for(int i=len-1;i>0;i--)
        {
            if(count==0 && set[i].isEmpty()) continue;

            if(set[i].size()>1)
            {
                count+=incrementor+(set[i].size()-1);
                incrementor+= (set[i].size()-1);
            }
            else if(set[i].size()==1)
            {
                count+=incrementor;
            }
            else if(set[i].isEmpty())
            {
                count+=  (incrementor>0)?(--incrementor):0;
                
            }
        }

        return count;
    }
}