class Solution {
    void dfs(int curNode,HashMap<Integer,List<Integer>> map,HashSet<Integer> vis,List<Integer> ans)
    {
        vis.add(curNode);
        ans.add(curNode);

        List<Integer> adjList = map.get(curNode);
        for(int i: adjList)
        {
            if(!vis.contains(i))  dfs(i,map,vis,ans);
        }
    }

    public int[] restoreArray(int[][] adjecentPairs) {
        int n = adjecentPairs.length;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
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
        dfs(srcNode,map, vis,ans);

        int arr[] = new int[n+1];
        for(int i=0;i<ans.size();i++)arr[i]= ans.get(i);

        return arr;
    }
}