class Solution {
    int[][] buildLcp(String str) {
        int length = str.length();
        int newLcp[][] = new int[length+1][length+1];
        for(int i=length-1; i>=0; i--) {
            for(int j=i; j>=0; j--) {
                char tokenA = str.charAt(i);
                char tokenB = str.charAt(j);
                if(tokenA==tokenB) {
                    newLcp[i][j] = newLcp[i+1][j+1]+1;
                } else {
                    newLcp[i][j] = 0;
                }
                newLcp[j][i] = newLcp[i][j];
            }
        }
        return newLcp;
    }

    boolean checkEqualLcp(int [][] newLcp, int [][] lcp) {
        int length = lcp.length;
        for(int i=0;i<length; i++) {
            for(int j=0; j<length; j++) {
                if(lcp[i][j]!=newLcp[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public String findTheString(int[][] lcp) {
        int length = lcp.length;
        char str[] = new char[length];
        char start = 'a';

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (i == j && str[j] == '\0') {
                    str[j] = start;
                    start++;
                    continue;
                }

                if (lcp[i][j] > 0 && str[j] == '\0') {
                    str[j] = str[i];
                }
            }
        }

        String newStr = new String(str);
        for (int i = 0; i < length; i++) {
            char token = newStr.charAt(i);
            if (token > 122 || token < 97) {
                return "";
            }
        }

        int newLcp[][] = buildLcp(newStr);
        boolean isEqual = checkEqualLcp(newLcp, lcp);
        if(!isEqual) {
            return "";
        }

        return newStr;
    }
}