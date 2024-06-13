class Solution {
    long mod = (long)(1e9+7);
    long numberOfPlaylists(int oldSongs, int goal, int k, int totalSongs, Long cache[][]){
        if(goal==0){
            if(oldSongs==totalSongs)
                return 1l;
            else
                return 0l;
        }

        if(cache[oldSongs][goal]!=null)
            return cache[oldSongs][goal];

        long newSongs = totalSongs -oldSongs;
        long noOfOldSongsCanPlay = oldSongs-k;

        long chooseNewSong =0;
        long chooseOldSong = 0;
       
        if(newSongs>0) 
            chooseNewSong = (newSongs*numberOfPlaylists(oldSongs+1,goal-1,k,totalSongs,cache))%mod;
        
        if(noOfOldSongsCanPlay>0)
            chooseOldSong = ((noOfOldSongsCanPlay)*numberOfPlaylists(oldSongs,goal-1, k, totalSongs,cache))%mod;

        return cache[oldSongs][goal] = (chooseNewSong+chooseOldSong)%mod;
    }
    public int numMusicPlaylists(int n, int goal, int k) {
        Long cache[][] = new Long[n+1][goal+1];
        return (int)numberOfPlaylists(0,goal,k,n,cache);
    }
}
/*
    1,2
    1,2,1
    2,1,2

    int goal,
    either play a new song if available 
    oldSongs = totalSongs - newSongs
    (total-oldSongs)*f(oldSongs+1,goal-1,k)
    play an old 
    if(oldSongs>k)
        (oldSongs-k)*f(oldSongs,goal-1,k)
    123
 */