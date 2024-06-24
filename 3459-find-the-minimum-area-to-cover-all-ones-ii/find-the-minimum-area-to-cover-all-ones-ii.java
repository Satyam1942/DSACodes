class Solution {
    int minimumAreaOfOneRectangle(int grid[][], int left,int right, int top , int bottom){
    
        int maxLeft = 0 ,minRight = -1, minBottom = -1, maxTop = 0 ;
        
        for(int i=top;i<=bottom;i++){
            boolean flag = false;
            for(int j=left;j<=right;j++){
                if(grid[i][j]==1){
                    maxTop = i;
                    flag = true;
                }
            }
            if(flag)
                break;
        }
        
          for(int i=bottom;i>=top;i--){
            boolean flag = false;
            for(int j=right;j>=left;j--){
                if(grid[i][j]==1){
                    minBottom = i;
                    flag = true;
                }
            }
            if(flag)
                break;
        }
        
         for(int j=left;j<=right;j++){
                 boolean flag = false;
                 for(int i=bottom;i>=top;i--){
                    if(grid[i][j]==1){
                        maxLeft = j;
                        flag = true;
                    }
                }
                if(flag)
                    break;
        }
      
            for(int j=right;j>=left;j--){
                 boolean flag = false;
                 for(int i=bottom;i>=top;i--){
                    if(grid[i][j]==1){
                        minRight = j;
                        flag = true;
                    }
                }
                if(flag)
                    break;
            }
        
       
        int area = (minBottom-maxTop+1) * (minRight-maxLeft+1);
        return area;
    }

    public int minimumSum(int[][] grid) {
        int length = grid.length;
        int width = grid[0].length;

        int minArea = Integer.MAX_VALUE;
       
        /*
          Pattern 1:
            O O
            OOO
        */

        for(int v=0;v<width-1;v++){
            for(int h=0;h<length;h++){
                int area = minimumAreaOfOneRectangle(grid,0,v,0,h)
                           +minimumAreaOfOneRectangle(grid,v+1,width-1,0,h)
                           +minimumAreaOfOneRectangle(grid,0,width-1,h+1,length-1);
            
                minArea = Math.min(minArea,area);
            }
        }

        /*
            Pattern 2
            OO
             O
            OO
         */
        for(int v=0;v<length-1;v++){
            for(int h=0;h<width;h++){
                int area = minimumAreaOfOneRectangle(grid,0,h,0,v)
                           +minimumAreaOfOneRectangle(grid,0,h,v+1,length-1)
                           +minimumAreaOfOneRectangle(grid,h+1,width-1,0,length-1);
                minArea = Math.min(minArea,area);
            }
        }

         /*
            Pattern 3
            OO
            O
            OO
         */
        for(int v=0;v<length-1;v++){
            for(int h=0;h<width;h++){
                int area = minimumAreaOfOneRectangle(grid,0,h,0,length-1)
                           +minimumAreaOfOneRectangle(grid,h+1,width-1,0,v)
                           +minimumAreaOfOneRectangle(grid,h+1,width-1,v+1,length-1);
                minArea = Math.min(minArea,area);
            }
        }

         /*
          Pattern 4:
            OOO
            O O
        */    
        for(int v=0;v<width-1;v++){
            for(int h=0;h<length;h++){
                int area = minimumAreaOfOneRectangle(grid,0,width-1,0,h)
                           +minimumAreaOfOneRectangle(grid,0,v,h+1,length-1)
                           +minimumAreaOfOneRectangle(grid,v+1,width-1,h+1,length-1);
                minArea = Math.min(minArea,area);
            }
        }

        /* Pattern 5
            000

            000

            000
        */
        for(int h1=0;h1<length-2;h1++){
            for(int h2=h1+1;h2<length-1;h2++){
                int area = minimumAreaOfOneRectangle(grid,0,width-1,0,h1)
                           +minimumAreaOfOneRectangle(grid,0,width-1,h1+1,h2)
                           +minimumAreaOfOneRectangle(grid,0,width-1,h2+1,length-1);
                minArea = Math.min(minArea,area);
            }
        }

        /*
            Pattern 6
            0  0  0
            0  0  0
            0  0  0
         */
        for(int v1=0;v1<width-2;v1++){
            for(int v2=v1+1;v2<width-1;v2++){
                int area = minimumAreaOfOneRectangle(grid,0,v1,0,length-1)
                           +minimumAreaOfOneRectangle(grid,v1+1,v2,0,length-1)
                           +minimumAreaOfOneRectangle(grid,v2+1,width-1,0,length-1);
                minArea = Math.min(minArea,area);
            }
        }

        return minArea;

    }
}

/*
    VVH
    HHV
    VHV
    HVH
    VVV
    HHH
 */