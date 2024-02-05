class Solution {
    public int firstUniqChar(String s) {
        int freq[] = new int[26];
        int firstIndex[] = new int[26];
        Arrays.fill(firstIndex,-1);
        
     
        for(int i=0;i<s.length();i++){
            freq[(int)s.charAt(i)-97]++;
            if( firstIndex[(int)s.charAt(i)-97]==-1)
            firstIndex[(int)s.charAt(i)-97] = i;
        }

        int minIndex = s.length();
        for(int i=0;i<26;i++){
            if(freq[i]==1){
                minIndex = Math.min(minIndex,firstIndex[i]);
            }
        }

        if(minIndex == s.length())
            return -1;
        else return minIndex;
    }
}