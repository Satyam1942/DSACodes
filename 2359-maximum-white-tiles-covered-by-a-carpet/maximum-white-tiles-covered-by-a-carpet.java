class Solution {
    int calculateNoOfTilesCovered(int[][] tiles,int st, int end, int prefixTileCount[] )
    {
        //floor of end
        int left = 0;
        int right = tiles.length-1;
        int floorEnd = left;
        while(left<=right)
        {
            int mid = (left+right)/2;
            if(tiles[mid][1]<end){left = mid+1; floorEnd = mid; }
            else if(end>=tiles[mid][0]) {floorEnd = mid; break;}
            else right = mid-1;
        }


        left =0;
        right = tiles.length-1;
        int ceilStart = right;
        //ceil of start

        while(left<=right)
        {
            int mid = (left+right)/2;
            if(tiles[mid][0]>st){right = mid-1; ceilStart = mid;}
            else if(tiles[mid][1]>=st){ceilStart = mid; break;}
            else left = mid+1;
        }

        //System.out.println(ceilStart+" "+floorEnd);
        if(ceilStart>floorEnd) return 0;
        if(ceilStart==floorEnd) return Math.min(tiles[floorEnd][1],end)-Math.max(tiles[ceilStart][0],st)+1;

        int noOfTiles = 0;
        if(end>=tiles[floorEnd][1]) noOfTiles+=prefixTileCount[floorEnd];
        else noOfTiles+= (floorEnd-1>=0)? (end-tiles[floorEnd][0]+1)+prefixTileCount[floorEnd-1]:
                        (end-tiles[floorEnd][0]);

        if(st<=tiles[ceilStart][0]) noOfTiles-= (ceilStart-1>=0)? prefixTileCount[ceilStart-1]:0;
        else noOfTiles-= (ceilStart-1>=0)? (st-tiles[ceilStart][0]+1)+ prefixTileCount[ceilStart-1]:
                        (st-tiles[ceilStart][0]);

        //System.out.println(noOfTiles);
        return noOfTiles;
    }

    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles,(a,b)->(a[0]-b[0]));

        int prefixTileCount [] = new int[tiles.length];
        int prefixCount = 0;
        for(int i=0;i<tiles.length;i++)
        {
            prefixCount += tiles[i][1]-tiles[i][0]+1;
            prefixTileCount[i] = prefixCount;
        }

        int maxTileCovered = 0;
        for(int i=0;i<tiles.length;i++)
        {
            int startCarpet = tiles[i][0];
            int endCarpet = startCarpet+carpetLen-1;
            int noOfTilesCovered = calculateNoOfTilesCovered(tiles,startCarpet,endCarpet,prefixTileCount);
            maxTileCovered= Math.max(maxTileCovered,noOfTilesCovered);
        }   

        return maxTileCovered;
  
    }
}
/*
    beginning = 1
    ending = 32
    2-12
    [[1,5],[10,11],[12,18],[20,25],[30,32]]
                   [1,11]
 */