class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> freqCharInT = new HashMap<>();
        HashMap<Character,Integer> freqCharInWindow = new HashMap<>();

        Queue<Integer> lastIndexQueue = new LinkedList<>(); 

        for(int i=0;i<t.length();i++)
        {
            char curCharacter = t.charAt(i);
            int val = freqCharInT.getOrDefault(curCharacter,0);
            freqCharInT.put(curCharacter,val+1);
        }

        int length = s.length();
        int left=0, right=0;
        int count =0, lowerBound =-1 , upperBound =-1,lengthOfSubstring=Integer.MAX_VALUE;

        while(left<length)
        {
            if(count == freqCharInT.size() || right==length)
            {
                if(lastIndexQueue.isEmpty()) return "";
                lastIndexQueue.poll();
                if(count == freqCharInT.size() && lengthOfSubstring>right-left)
                {
                    lengthOfSubstring = right-left;
                    lowerBound = left;
                    upperBound = right;
                }
                char deleted = s.charAt(left);
                int val =  freqCharInWindow.get(deleted);
                if(val==1)
                {
                    count--;
                    freqCharInWindow.remove(deleted);
                }
                else
                {
                    freqCharInWindow.put(deleted,val-1);
                    if(freqCharInT.get(deleted)>val-1)count--;
                }
                left = (!lastIndexQueue.isEmpty())? lastIndexQueue.peek():length;
                continue;
            }

            char curChar = s.charAt(right);
            if(freqCharInT.containsKey(curChar))
            {
                int val = freqCharInWindow.getOrDefault(curChar,0);
                freqCharInWindow.put(curChar,val+1);
                lastIndexQueue.add(right);
                if(val+1 == freqCharInT.get(curChar)) count++;
            }
            else
            {
               if(freqCharInWindow.size()==0) left++;
            }
            right++;
        }

        if(lowerBound ==-1 ) return "";
        return s.substring(lowerBound,upperBound);
    }
}