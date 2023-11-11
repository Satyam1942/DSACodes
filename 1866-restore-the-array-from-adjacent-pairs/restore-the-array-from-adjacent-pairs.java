class Solution {
    void dfs(int curNode,HashMap<Integer,List<Integer>> map,HashSet<Integer> vis,int[]ans,int pointer)
    {
        vis.add(curNode);
        ans[pointer]=curNode;
        List<Integer> adjList = map.get(curNode);
        for(int i: adjList)
        {
            if(!vis.contains(i))  dfs(i,map,vis,ans,pointer+1);
        }
    }

    public int[] restoreArray(int[][] adjecentPairs) {
        int n = adjecentPairs.length;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int ans[] = new int[n+1];
        int srcNode =0;

        for(int i=0;i<n;i++)
        {
            if(!map.containsKey(adjecentPairs[i][0])) map.put(adjecentPairs[i][0],new ArrayList<>());
            if(!map.containsKey(adjecentPairs[i][1])) map.put(adjecentPairs[i][1],new ArrayList<>());
            map.get(adjecentPairs[i][0]).add(adjecentPairs[i][1]);
            map.get(adjecentPairs[i][1]).add(adjecentPairs[i][0]);
        }

        for(Map.Entry<Integer,List<Integer>> i: map.entrySet())
        {
            if(i.getValue().size()==1) {srcNode = i.getKey(); break; }
        }

        HashSet<Integer> vis = new HashSet<>();
        dfs(srcNode,map, vis,ans,0);
        return ans;
    }
}