class Solution {
    public boolean closeStrings(String word1, String word2) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        
        int freq1[] = new int[26];
        for(int i=0;i<word1.length();i++){
           freq1[(int)word1.charAt(i)-97]++;
        }

        int freq2[] = new int[26];
        for(int i=0;i<word2.length();i++){
           freq2[(int)word2.charAt(i)-97]++;
        }
        for(int i=0;i<26;i++){
            if(freq1[i]>0 && freq2[i]==0) return false;
            if(freq2[i]>0 && freq1[i]==0) return false;
        }
        for(int i=0;i<26;i++){
            if(freq1[i]==0) continue;
            map1.put(freq1[i],map1.getOrDefault(freq1[i],0)+1);
        }

        for(int i=0;i<26;i++){
            if(freq2[i]==0) continue;
            map2.put(freq2[i],map2.getOrDefault(freq2[i],0)+1);
        }

        for(Map.Entry<Integer,Integer> i:map1.entrySet()){
            if(!map2.containsKey(i.getKey())) return false;
            else if(map2.get(i.getKey())!=i.getValue()) return false;
        }

        return true;
    }
}

/*
 cabbba
 abbccc

 a-2
 b-3
 c-1

 a-1
 b-2
 c-3
*/