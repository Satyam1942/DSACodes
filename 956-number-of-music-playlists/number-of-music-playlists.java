class Solution {
    long mod = (long)(1e9+7);
    long calculateMusicPlaylist(int oldSongs, int goal, int n, int k, Long cache[][]) {
        if (goal == 0) {
            if (oldSongs == n)
                return 1;
            else
                return 0;
        }

        if(cache[oldSongs][goal]!=null)
            return cache[oldSongs][goal];

        long pickOldSong = 0;
        long pickNewSong = 0;

        if(oldSongs>=k)
            pickOldSong =  (oldSongs-k)*calculateMusicPlaylist(oldSongs, goal - 1, n, k,cache);
        if(oldSongs<n)
            pickNewSong =  (n-oldSongs)*calculateMusicPlaylist(oldSongs+1, goal - 1, n, k,cache);
        
        return cache[oldSongs][goal] = (pickOldSong%mod+pickNewSong%mod)%mod;
    }

    public int numMusicPlaylists(int n, int goal, int k) {
        Long cache[][] = new Long[n+1][goal+1];

        int noOfPlaylists =  (int)calculateMusicPlaylist(0,goal,n,k,cache);
        
        return noOfPlaylists;
    }
}