class Solution {
    public int minimumLength(String s) {
        int length = s.length();
        int i = 0, j = length - 1;
        char prevPrefix = '\0';
        char prevSuffix = '\0';

        while (i < j) {
            char curPrefix = s.charAt(i);
            char curSuffix = s.charAt(j);

            if (curPrefix == curSuffix) {
                i++;
                j--;
                prevPrefix = curPrefix;
                prevSuffix = curSuffix;
            } else {
                if (curPrefix == prevPrefix){
                    i++;
                    prevPrefix = curPrefix;
                }
                else if (curSuffix == prevSuffix){
                    j--;
                     prevSuffix = curSuffix;
                }
                else
                    break;
            }
        }
        
        if(s.charAt(i)==prevPrefix && i==j)
            return 0;

        return j - i + 1;

    }
}