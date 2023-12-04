class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles,(a,b)->(a[0]-b[0]));

        int i =0 ,j =0;
        long maxCoverage = 0l,temp = 0l;

        while(i<tiles.length && j<tiles.length)
        {    
            long maxReachableIndex = (long)tiles[i][0]+(long)carpetLen-1l;
            if(maxReachableIndex>tiles[j][1])
            {
                temp+= (long)tiles[j][1]-(long)tiles[j][0]+1l;
                j++;
            }
            else
            {
                long partial = (long)Math.max(0l,(long)maxReachableIndex-(long)tiles[j][0]+1l);
                maxCoverage = Math.max(maxCoverage,temp+partial);
                temp-= (long)(tiles[i][1]-tiles[i][0]+1);
                i++;
                
            }
        }

         maxCoverage = Math.max(maxCoverage,temp);
         return (int)maxCoverage;
    }
}