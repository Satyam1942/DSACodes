class Solution {
   boolean isPalindrome(String s)
    {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return s.equals(sb.toString());
    }

    void rec(String s , int i, int j, List<String> palindrome, List<List<String>> ans)
    {
        if(i>j)
        {
            ans.add(new ArrayList<>(palindrome));
            return;
        }

        for(int k=i;k<=j;k++)
        {
            String x = s.substring(i,k+1);
            if(isPalindrome(x))
            {
                palindrome.add(x);
                rec(s,k+1,j,palindrome,ans);
                palindrome.remove(palindrome.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
    List<List<String>> ans = new ArrayList<>();
    List<String> letter = new ArrayList<>();
  
    rec(s,0,s.length()-1,letter,ans);

        return ans;
    }
}