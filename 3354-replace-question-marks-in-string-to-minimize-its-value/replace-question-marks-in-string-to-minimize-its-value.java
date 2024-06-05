class Solution {
    public String minimizeStringValue(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->((a[1]==b[1])? a[0]-b[0] : a[1]-b[1]));
        int length = s.length();
        int questionMarkCount = 0;
        int freq[] = new int[26];

        for(int i=0;i<length;i++){
            char token =  s.charAt(i);
            if(token=='?'){
                questionMarkCount++;
            }else{
                freq[(int)token-97]++;
            }
        }

        for(int i=0;i<26;i++){
            pq.add(new int[]{i,freq[i]});
        }

        List<Character> replacedCharacterList = new ArrayList<>(); 
        while(questionMarkCount-->0){
            int ch = pq.peek()[0];
            int curFreq = pq.peek()[1];
            pq.poll();
            pq.add(new int[]{ch,curFreq+1});
            replacedCharacterList.add((char)(ch+97));
        }

        Collections.sort(replacedCharacterList);

        StringBuilder sb = new StringBuilder();
        int pointer = 0;
        for(int i=0;i<length;i++){
            char token = s.charAt(i);
            if(token=='?')
                sb.append(replacedCharacterList.get(pointer++));
            else    
                sb.append(token);
        }

        return sb.toString();
    }
}