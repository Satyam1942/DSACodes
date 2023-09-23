class Solution {
    
    boolean isSubsequence(String src , String find)
    {
        int left =0 ,right =0;
        while(left<src.length() && right<find.length())
        {
            if(src.charAt(left) == find.charAt(right)) right++;
            left++;
        }
        return right == find.length();
    }

    int giveLongestStringChain(String startWord ,HashMap<Integer,List<String>> map,HashMap<String,Integer> visited)
    {
        
        int nextLength = startWord.length()+1;
        if(!map.containsKey(nextLength)) return 0;
        if(visited.containsKey(startWord)) return visited.get(startWord);
        List<String> collection = map.get(nextLength);
        int maxi = 0;
        for(String str : collection)
        {
            if(isSubsequence(str,startWord)) 
            {
                int tempLength = 1+giveLongestStringChain(str,map,visited);
                maxi = Math.max(maxi,tempLength);
            }
        }    
        visited.put(startWord,maxi);
        return maxi;
    }

    public int longestStrChain(String[] words) {
        HashMap<Integer,List<String>> map = new HashMap<>();
        HashMap<String,Integer> visited = new HashMap<>();
        int lengthOfDictionary = words.length;
        for(int i =0; i<lengthOfDictionary;i++)
        {
            String word = words[i];
            if(!map.containsKey(word.length())) map.put(word.length(),new ArrayList<>());
            map.get(word.length()).add(word);
         }

        int maxLengthChain = 0;
         for(int i=0;i<lengthOfDictionary;i++)
         {
            String startWord = words[i];
            int length = 1+giveLongestStringChain(startWord,map,visited);
            maxLengthChain = Math.max(maxLengthChain,length);
         }

         return maxLengthChain;

    }
}