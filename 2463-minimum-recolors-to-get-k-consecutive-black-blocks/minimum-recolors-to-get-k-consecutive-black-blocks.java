class Solution {
    int recolor(int index, int streak,String blocks, int k, Integer cache[][]) {
        if(blocks.length()==index) {
            if(streak==k) {
                return 0;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        if(cache[index][streak]!=null) {
            return cache[index][streak];
        }

        char token = blocks.charAt(index);

        if(token=='W') {
            int change = Integer.MAX_VALUE;
            int notChange = Integer.MAX_VALUE;
            if(streak<k) {
                change = recolor(index+1, streak+1, blocks, k, cache);
                notChange = recolor(index+1, 0, blocks, k, cache);
            } else {
                notChange = recolor(index+1, streak, blocks, k, cache);
            }

            if(change!=Integer.MAX_VALUE) {
                change++;
            }
            return cache[index][streak] = Math.min(change, notChange);
        } else {
            if(streak<k) {
                return cache[index][streak] = recolor(index+1, streak+1, blocks, k, cache);
            } else {
                return cache[index][streak] = recolor(index+1, streak, blocks, k, cache);
            }
        }
    }

    public int minimumRecolors(String blocks, int k) {
        int length = blocks.length();
        Integer cache[][] = new Integer[length+1][k+1];
        int ans = recolor(0, 0, blocks, k, cache);    
        return ans;
    }
}

/*
    2 2 1
*/