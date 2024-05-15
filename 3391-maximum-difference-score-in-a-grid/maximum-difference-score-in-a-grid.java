class Solution {
    public int maxScore(List<List<Integer>> grid) {
        List<List<Integer>> maxVal = new ArrayList<>();
        int length = grid.size();
        int width = grid.get(0).size();

        for(int i=0;i<length;i++){
            maxVal.add(new ArrayList<>());
            for(int j=0;j<width;j++){
                maxVal.get(i).add(0);
            }
        }

        int max = grid.get(length-1).get(width-1);
        for(int i=length-1;i>=0;i--){
            max = grid.get(i).get(width-1);
            for(int j=width-2;j>=0;j--){
                maxVal.get(i).set(j,max);
                max = Math.max(max,grid.get(i).get(j));
            }
        }
       
        for(int i=width-1;i>=0;i--){
            max = Math.max(grid.get(length-1).get(i),maxVal.get(length-1).get(i));
            for(int j=length-2;j>=0;j--){
                maxVal.get(j).set(i,Math.max(max,maxVal.get(j).get(i)));
                max = Math.max(max,Math.max(grid.get(j).get(i),maxVal.get(j).get(i)));
            }
        }
        

        int maxDif = Integer.MIN_VALUE;
        for(int i=0;i<length;i++){
            for(int j=0;j<width;j++){
                if(i==length-1 && j==width-1)
                    continue;
                // System.out.print(maxVal.get(i).get(j)+" ");
                int dif = maxVal.get(i).get(j)-grid.get(i).get(j);
                maxDif = Math.max(maxDif,dif);
            }
            // System.out.println();
        }

        return maxDif;
    }
}
/*
    5,9
    max will always change
    new max - old min
    dif  = 4;


                         
        9   9    6   1   1
        14  14  14   3   1 
        5    3  1    1   0
*/