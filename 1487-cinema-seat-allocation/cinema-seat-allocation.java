class Solution {

    void buildOccupied(int n ,int reservedSeats[][], 
                HashMap<Integer, HashSet<Integer>> occupied) {

        int possibilities[][] = {{ 2, 5 }, { 6, 9 }, { 4, 7 } };
        for (int i = 0; i < reservedSeats.length; i++) {
            int row = reservedSeats[i][0];
            int col = reservedSeats[i][1];
            for(int j=0;j<3;j++){
                if(col<=possibilities[j][1] && col>=possibilities[j][0]){
                    if(!occupied.containsKey(row))
                        occupied.put(row,new HashSet<>());
                    occupied.get(row).add(j);
                }
            }
        }
    }

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, HashSet<Integer>> occupied = new HashMap<>();
        buildOccupied(n,reservedSeats, occupied);

        int groupCount = 2*n;

        for (Map.Entry<Integer, HashSet<Integer>> i : occupied.entrySet()) {
           if(i.getValue().size()==3)
                groupCount-=2;
            else 
                groupCount-=1; 
        }

        return groupCount;

    }
}