class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        int length = grid.length;
        int width = grid[0].length;
        for(int i=0; i<length; i++) {
            for(int j=0; j<width; j++) {
                list.add(grid[i][j]);
            }
        }

        Collections.sort(list);
        int medianIndex = (list.size()/2);
        int median =  list.get(medianIndex);
        int noOfMoves = 0;
        for(int i=0; i<list.size(); i++) {
            int curNum = list.get(i);
            int delta = Math.abs(median-curNum);
            if(delta%x!=0) {
                return -1;
            }
            noOfMoves += delta/x;
        }
        return noOfMoves;
    }
}

/*
    2, 4, 6, 8, 10, 20, 30, 100
6-  2  1  0  1  2   7   12
8-  3  2  1  0  1   6   11  46 = 70
10- 4  3  2  1  0   5   10  45 = 70

*/