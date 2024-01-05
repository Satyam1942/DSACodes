class Triplet {
    int start, end, len;

    Triplet(int start, int end, int len) {
        this.start = start;
        this.end = end;
        this.len = len;
    }
}

class Solution {
    Triplet minWindowSubsequence(int i, int j, int canCount, String s1, String s2, Triplet cache[][][]) {
        if (j == s2.length())
            return new Triplet(i, i, 0);
        if (i == s1.length())
            return new Triplet(i, i, Integer.MAX_VALUE);
        if (cache[i][j][canCount] != null)
            return cache[i][j][canCount];

        Triplet take = new Triplet(i, i, Integer.MAX_VALUE);
        if (s1.charAt(i) == s2.charAt(j))
            take = minWindowSubsequence(i + 1, j + 1, 1, s1, s2, cache);

        Triplet notTake = minWindowSubsequence(i + 1, j, canCount, s1, s2, cache);

        int res = Math.min(take.len, notTake.len);

        int startIndex = 0, endIndex = 0;

        if (take.len < notTake.len) {
            startIndex = take.start;
            endIndex = take.end;
        } else if(take.len>notTake.len){
            startIndex = notTake.start;
            endIndex = notTake.end;
        }else
        {
            if(take.start<notTake.start)
            {
                startIndex = take.start;
            endIndex = take.end;
            }else
            {
                  startIndex = notTake.start;
             endIndex = notTake.end;
            }
        }

        if (res != Integer.MAX_VALUE && canCount == 1)
            res += 1;

        if (canCount == 1)
            return cache[i][j][canCount] = new Triplet(i, endIndex, res);
        else
            return cache[i][j][canCount] = new Triplet(startIndex, endIndex, res);
    }

    public String minWindow(String s1, String s2) {
    Triplet cache[][][] = new Triplet[s1.length()][s2.length()][2];
 
	Triplet window = minWindowSubsequence(0,0,0,s1,s2,cache);
	if(window.len==Integer.MAX_VALUE) return "";


	int startIndex = window.start;
	int endIndex = window.end;
	
	return s1.substring(startIndex-1,endIndex);

    }
}