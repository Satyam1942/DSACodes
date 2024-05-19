class Solution {
    int rec(int jump, int stair , boolean canReduce, int k, HashMap<String,Integer> cache){
        if(stair>=k+2)
            return 0;
        String s= (jump+""+stair+""+canReduce);
        if(cache.containsKey(s))
            return cache.get(s);

        int decrease  =0, increase = 0;
        if(canReduce && stair!=0)
            decrease = rec(jump,stair-1,false,k,cache);
        increase = rec(jump+1,stair+(1<<jump), true,k,cache);

        int ans = 0;
        if(stair==k)
            ans++;
        ans += increase+decrease;

        cache.put(s,ans);
        return  ans;
    }

    public int waysToReachStair(int k) {
        HashMap<String,Integer> cache = new HashMap<>();
        return rec(0,1,true,k,cache);
    }
}