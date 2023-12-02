class Solution {
    public int countCharacters(String[] words, String chars) {
        int freq[] = new int[26];

        int countLength = 0;

        for(int i=0;i<words.length;i++)
        {
            boolean flag = true;
             for(int j=0;j<chars.length();j++)
             {
                 freq[chars.charAt(j)-97]++;
             }

             for(int j=0;j<words[i].length();j++)
             {
                 freq[words[i].charAt(j)-97]--;
                 if(freq[words[i].charAt(j)-97]==-1) {flag = false; break;}
             }

                if(flag) countLength+=words[i].length();
             Arrays.fill(freq,0);
        }

        return countLength;

    }
}