class Pair implements Comparator<Pair>{
    char token;
    int freq;
    
    Pair(){

    }

    Pair(char token ,int freq){
        this.token = token;
        this.freq =  freq;
    }

    @Override
    public int compare(Pair a, Pair b){
        if(a.freq==b.freq)
            return (int)a.token-(int)b.token;
        else
            return a.freq - b.freq;
    }
}

class Solution {
    public String minimizeStringValue(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Pair());
        int length = s.length();
        int freq[] = new int[26];
        int noOfQuestionMarks = 0;

        for(int i=0;i<length;i++){
            char token = s.charAt(i);
            if(token!='?'){
                freq[(int)token-97]++;
            }else
                noOfQuestionMarks++;
        }

        for(int i=0;i<26;i++){
            pq.add(new Pair((char)(i+97),freq[i]));
        }

        StringBuilder sb = new StringBuilder();
        while(noOfQuestionMarks-->0){
            char optimalCharacter = pq.peek().token;
            int freqChar = pq.peek().freq;
            pq.poll();
            pq.add(new Pair(optimalCharacter,freqChar+1));
            sb.append(optimalCharacter);
        }

        int pointer = 0;
        char questionMark[] = sb.toString().toCharArray();
        Arrays.sort(questionMark);
        String fillString = new String(questionMark);
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<length;i++){
            char token = s.charAt(i);
            if(token=='?'){
                ans.append(fillString.charAt(pointer));
                pointer++;
            }else
                ans.append(token);
        }

        return ans.toString();
    }
}

/*
    c-1
    b-1
    a-2

*/