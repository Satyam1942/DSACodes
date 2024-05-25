class Solution {
    List<String> ans = new ArrayList<>();

    void partition(int index, String s, HashSet<String> dictionary, List<String> temp){
        if(index==s.length()){
            StringBuilder sb = new StringBuilder();
            sb.append(temp.get(0));
            for(int i=1;i<temp.size();i++)
                sb.append(" "+temp.get(i));
            ans.add(sb.toString());
            return;
        }

        for(int i=index;i<s.length();i++){
            String substring = s.substring(index,i+1);
            if(dictionary.contains(substring)){
                temp.add(substring);
                partition(i+1,s,dictionary,temp);
                temp.remove(temp.size()-1);
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> dictionary = new HashSet<>();
        List<String> temp = new ArrayList<>();
        for(int i=0;i<wordDict.size();i++){
            dictionary.add(wordDict.get(i));
        }
        partition(0,s,dictionary,temp);
        return ans;
    }
}