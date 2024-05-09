class Solution {
    boolean isPossible(int length , String s,  HashMap<Character,List<Integer>> map){
        if(s.length()%length!=0)
            return false;
    
        String anagram = s.substring(0,length);
        int noOfAnagrams = s.length()/length;
        int freq[] = new int[26];

        for(int i=0;i<length;i++){
            char ch = anagram.charAt(i);
            freq[(int)ch-97]++;
        }
        
        for(int i=0;i<length;i++){
            char token = anagram.charAt(i);
            int f = freq[(int)token-97];
            List<Integer> indices = map.get(token);
            int sz = indices.size();
        
            if(noOfAnagrams*f!=sz)
                return false;
            // if(length==4){
            //     System.out.println(indices);
            //     System.out.println(noOfAnagrams+" "+f+" "+sz+" "+token);
            // }

            int leftBound = 0;  
            int rightBound = length-1;
            for(int j=0; j<indices.size() ; j+=f){
                int index = indices.get(j);
                if(index<leftBound || index>rightBound)
                    return false;
                leftBound+= length;
                rightBound+= length;
            }
        }
        return true;
    }

    public int minAnagramLength(String s) {
        int length = s.length();
        HashMap<Character,List<Integer>> map = new HashMap<>();
        for(int i=0;i<length;i++){
            if(!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),new ArrayList<>());
            map.get(s.charAt(i)).add(i);
        }

        int left = 1;
        int right = length;

        int minAnagramLength = right;
        while(left<=right){
            if(isPossible(left, s, map)){
                minAnagramLength = left;
                break;
            }
            left++;
        }

        return minAnagramLength;
    }
}
/*
   left = 1;
   right = 4;

   a-0,3
   b-1,2
   
   ab

 */