class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
         HashSet<Character> set = new HashSet<>();
         int countPairs = 0;
        for(int i=0;i<words.length;i++){
            for(int j = 0;j<words[i].length();j++){
                char ch = words[i].charAt(j);
                if(set.contains(ch)){
                    set.remove(ch);
                    countPairs++;
                }else 
                    set.add(ch);
            }
        }

        int count =0 ;
        int size[] = new int[words.length];
        for(int i=0;i<words.length;i++){
            size[i] = words[i].length();
        }

        Arrays.sort(size);
        for(int i=0;i<size.length;i++){
            int length = size[i];
            if(countPairs>=length/2){
                countPairs-=length/2;
                count++;
            }
        }

        return count;
    }
}