class Solution {
    int dfs(int curNode ,int curLabel,String label,int vis[] , int ans[], List<List<Integer>> adjList)
    {
        vis[curNode] = 1;
        
        int temp = 0;
        for(int i=0;i<adjList.get(curNode).size();i++)
        {
            int adjNode = adjList.get(curNode).get(i);
            if(vis[adjNode]==0)  temp +=  dfs(adjNode,curLabel,label,vis,ans,adjList);
        }
         
         if(label.charAt(curNode)==curLabel) return ans[curNode] = 1+temp;
         else return temp;
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> adjList = new ArrayList<>();
        int ans [] = new int[n];

        for(int i=0;i<n;i++) adjList.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++)
        {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<labels.length();i++)
        {
            set.add(labels.charAt(i));
        }

        for(Character ch : set)
        {
            int vis[] = new int[n];
            dfs(0,ch,labels,vis,ans,adjList);
        }

        return ans;
    }
}
/*
    a:0,2
    b:1
    c:5
    d:4
    e:3


    0->{1,2}
    1->{4,5}
    2->{3,6}

    set:
    
 */