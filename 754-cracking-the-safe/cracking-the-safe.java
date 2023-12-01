class Solution {
   String ans = "";
    boolean dfs(String stringStream, HashSet<String> vis, int k,int n )
    {  
        String lastNCharacters = stringStream.substring(stringStream.length()-n);
        if(vis.contains(lastNCharacters)) return false ;
        vis.add(lastNCharacters);
        if(vis.size() == Math.pow(k,n)) return true;

        for(int i=0;i<k;i++)
        {
           boolean temp = dfs(stringStream+ String.valueOf(i),vis,k,n);
            if(temp){ans = (char)(i+48)+ans; return true;}
        }  

        vis.remove(lastNCharacters);
        return false;
    }

    public String crackSafe(int n, int k) {
        HashSet<String> vis = new HashSet<>();
        String str  = "";
        
        for(int i=0;i<n;i++) str+="0";

        dfs(str,vis,k,n);
        for(int i=0;i<n;i++) ans="0"+ans;
        return ans;
    }
}