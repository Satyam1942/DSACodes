class Solution {
    long mod = (long)(1e9+7);

    long rec(int n, int goal,int k,int oldSongs, Long dp[][])
    {
        if(goal==0) 
        {
            if(oldSongs==n) return  1; 
            else return 0;
        }
        if(dp[goal][oldSongs]!=null) return dp[goal][oldSongs];

        long playOld =0l, playNew = 0l;

       if(oldSongs>k)  playOld = (oldSongs-k)*rec(n,goal-1,k,oldSongs,dp);

       playNew = (n-oldSongs)*rec(n,goal-1,k,oldSongs+1,dp);

       return dp[goal][oldSongs] = (playOld+playNew)%mod;
    }

    public int numMusicPlaylists(int n, int goal, int k) {
        Long dp[][] = new Long[goal+1][goal+n];

        return (int)rec(n,goal,k,0,dp);
    }
}