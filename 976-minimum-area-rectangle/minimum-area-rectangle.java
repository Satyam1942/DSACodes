class Solution {
    public int minAreaRect(int[][] points) {
        HashMap<Integer,HashSet<Integer>> mapX = new HashMap<>();
        HashMap<Integer,HashSet<Integer>> mapY = new HashMap<>();
        
        int noOfPoints = points.length;
        for(int i=0;i<noOfPoints;i++){
            int x = points[i][0];
            int y = points[i][1];
            if(!mapX.containsKey(x))
                mapX.put(x,new HashSet<>());
            mapX.get(x).add(y);
            if(!mapY.containsKey(y))
                mapY.put(y,new HashSet<>());
            mapY.get(y).add(x);
        }

        int minArea = Integer.MAX_VALUE;
        for(int i=0;i<noOfPoints;i++){
            for(int j= i+1;j<noOfPoints;j++){
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];

                if(y1==y2)
                    continue;
                if(x1==x2)
                    continue;

                if(mapX.get(x1).contains(y2) && mapX.get(x2).contains(y1)){
                    int area = Math.abs(y2-y1)*Math.abs(x2-x1);
                    minArea=  Math.min(minArea,area);
                }

            }
        }

        if(minArea==Integer.MAX_VALUE)
            return 0;
        else
            return minArea;

    }
}