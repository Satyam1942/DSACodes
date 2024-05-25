class Solution {
    String ans = "";
    boolean dfs(String s, int n, int k, HashSet<String> vis){
        String lastNCharacter = s.substring(s.length()-n,s.length());
     
        //path has added redundancy so dont take it
        if(vis.contains(lastNCharacter))
            return false;

        vis.add(lastNCharacter);
        if(vis.size()==(int)Math.pow(k,n))
            return true;

        for(int i=0;i<k;i++){
            String nstr =  s+String.valueOf(i);
          
            boolean temp = dfs(nstr,n,k,vis);
            if(temp){
                ans = String.valueOf(i)+ans;
                return true;
            }
        }

        vis.remove(lastNCharacter);
        return false;
    }
    public String crackSafe(int n, int k) {
        StringBuilder init = new StringBuilder();
        for(int i=0;i<n;i++)
            init.append("0");
        HashSet<String> vis = new HashSet<>();

        dfs(init.toString(),n,k,vis);
        for(int i=0;i<n;i++)
            ans="0"+ans;
            
        return ans;
    }
}