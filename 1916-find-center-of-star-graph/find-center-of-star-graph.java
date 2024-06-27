class Solution {
    public int findCenter(int[][] edges) {
        int first = edges[0][0];
        int second = edges[0][1];
        int third = edges[1][0];
        int fourth = edges[1][1];

        if(first==third || first==fourth)
            return first;
        else
            return second;
    }
}