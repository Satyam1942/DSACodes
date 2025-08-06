class Solution {
    int dfs(int roomNo, int vis[], List<List<Integer>> rooms) {
        vis[roomNo] = 1;
        int totalRoomCount = 0;
        for(int i=0;i<rooms.get(roomNo).size(); i++) {
            int adjRoomNo = rooms.get(roomNo).get(i);
            if(vis[adjRoomNo]==0) {
                totalRoomCount+=dfs(adjRoomNo, vis, rooms);
            }
        }

        return totalRoomCount+1;
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int numberOfRooms = rooms.size();
        int vis[] = new int[numberOfRooms];
        int noOfRoomsVisited = dfs(0, vis, rooms);
        if(numberOfRooms == noOfRoomsVisited) {
            return true;
        } else {
            return false;
        }
    }
}