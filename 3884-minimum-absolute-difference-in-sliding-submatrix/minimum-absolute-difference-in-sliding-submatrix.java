class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int length = grid.length;
        int width = grid[0].length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[][] minDifMatrix = new int[length - k + 1][width - k + 1];

        int rowStart = 0;
        int counter = 0;
        for (int i = k - 1; i < length; i++) {
            int colStart = 0;
            for (int j = k - 1; j < width; j++) {
                List<Integer> list = new ArrayList<>();
                for (int l = rowStart; l <= i; l++) {
                    for (int m = colStart; m <= j; m++) {
                        int element = grid[l][m];
                        list.add(element);
                    }
                }
                Collections.sort(list);
                int minDif = Integer.MAX_VALUE;
                if (list.size() > 1) {
                    for(int l =0;l<list.size()-1;l++) {
                        int ele = list.get(l);
                        int ele2 = list.get(l+1);
                        if(ele!=ele2) {
                            minDif = Math.min(minDif, Math.abs(ele-ele2));
                        }
                    }
                } 
                if(minDif == Integer.MAX_VALUE) {
                    minDif = 0;
                }
                minDifMatrix[rowStart][colStart] = minDif;
                colStart++;
            }
            rowStart++;
        }
        return minDifMatrix;
    }
}