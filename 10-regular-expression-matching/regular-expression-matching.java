class Solution {
    boolean regexMatching(int i, int j , String s, String p){
        if(i==s.length() && j==p.length())
            return true;
        if(i<s.length() && j==p.length())
            return false;

        boolean matchCondition = i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
        if(j<p.length()-1 && p.charAt(j+1)=='*'){
            boolean pos1 = regexMatching(i,j+2,s,p);
            boolean pos2 = false;
            if(matchCondition)
                pos2 =  regexMatching(i+1,j,s,p);
            return pos2||pos1;
        } else if(matchCondition)
            return regexMatching(i+1,j+1,s,p);
   
        return false;
    }

    public boolean isMatch(String s, String p) {
        return regexMatching(0,0,s,p);
    }
}