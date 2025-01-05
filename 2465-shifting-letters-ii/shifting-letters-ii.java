class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int length = shifts.length;
        int strLength = s.length();
        int difference[] = new int[strLength+1];
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<length;i++) {
            int left = shifts[i][0];
            int right = shifts[i][1];
            int delta = (shifts[i][2]==0)?-1:1;
            difference[left]+=delta;
            difference[right+1]-=delta;
        }

        for(int i=1;i<strLength;i++){
            difference[i] += difference[i-1];
        }

        for(int i=0;i<strLength;i++) {
            char token = s.charAt(i);
            int idx = (int)token-97;
            int delta = difference[i];
            int newIdx = (idx+delta)%26;
            if(newIdx<0) {
                newIdx+=26;
            }
            char newToken = (char)(newIdx+97);
            sb.append(newToken);
        }

        return sb.toString();
    }
}

/*

*/      