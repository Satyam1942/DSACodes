class Solution {
    boolean doesIntersect(int [] rectangle1BottomLeft, int [] rectangle1TopRight, int[] rectangle2BottomLeft ,int [] rectangle2TopRight){
        int x1BL = rectangle1BottomLeft[0];
        int y1BL = rectangle1BottomLeft[1];
        int x1TR = rectangle1TopRight[0];
        int y1TR = rectangle1TopRight[1];
        
        int x2BL = rectangle2BottomLeft[0];
        int y2BL = rectangle2BottomLeft[1];
        int x2TR = rectangle2TopRight[0];
        int y2TR = rectangle2TopRight[1];
        
        return x1BL<=x2TR &&  x2BL<=x1TR && y1BL<=y2TR && y2BL<=y1TR;
    }
    
    long getSmallestArea(int [] rectangle1BottomLeft, int [] rectangle1TopRight, int[] rectangle2BottomLeft ,int [] rectangle2TopRight){
        int x1BL = rectangle1BottomLeft[0];
        int y1BL = rectangle1BottomLeft[1];
        int x1TR = rectangle1TopRight[0];
        int y1TR = rectangle1TopRight[1];
        
        int x2BL = rectangle2BottomLeft[0];
        int y2BL = rectangle2BottomLeft[1];
        int x2TR = rectangle2TopRight[0];
        int y2TR = rectangle2TopRight[1];

        int length = Math.min(x1TR,x2TR)-Math.max(x1BL,x2BL);
        int breadth = Math.min(y1TR,y2TR)-Math.max(y1BL,y2BL);;
        int side = Math.min(length,breadth);         
       return  (long)side*(long)side;
        
    }
    
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int noOfRectangles = bottomLeft.length;
        long area = 0l;
        for(int i=0;i<noOfRectangles;i++){
              for(int j=0;j<noOfRectangles;j++){
                  if(i==j)
                    continue;
                  if(doesIntersect(bottomLeft[i],topRight[i],bottomLeft[j],topRight[j])){
                      long tempArea = getSmallestArea(bottomLeft[i],topRight[i],bottomLeft[j],topRight[j]);
                      area = Math.max(area,tempArea);
                  }
                      
              }
        }
        
        return area;
    }
}