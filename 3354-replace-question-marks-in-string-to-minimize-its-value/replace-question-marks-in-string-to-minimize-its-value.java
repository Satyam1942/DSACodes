class Solution {
    public String minimizeStringValue(String s) {
        int questionMarkCount = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->((a[1]==b[1])?a[0]-b[0]:a[1]-b[1]));
        int freq[] = new int[26];
        for(int i=0;i<s.length();i++){
            char  ch = s.charAt(i);
            if(ch>='a' && ch<='z'){
                int index = (int)ch-97;
                freq[index]++;
            }else{
                questionMarkCount++;
            }
        }

        for(int i=0;i<26;i++){
            int ch = i;
            int freqOfCh = freq[i];
            int temp[] = new int[2];
            temp[0] = ch;
            temp[1] = freqOfCh;
            pq.add(temp);
        }

        List<Character> list = new ArrayList<>();
        while(questionMarkCount-->0){
            int ele = pq.peek()[0];
            char ch = (char)(ele+97);
            int curFreq = pq.peek()[1];
            pq.poll();
            int temp[] = new int[2];
            temp[0] = ele;
            temp[1] = curFreq+1;
            pq.add(temp);
            list.add(ch);
        }

        Collections.sort(list);
        int j = 0;
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char  ch = s.charAt(i);
            if(ch>='a' && ch<='z'){
                ans.append(ch);
            }else{
                ans.append(list.get(j));
                j++;
            }
        }

        return ans.toString();

    }
}