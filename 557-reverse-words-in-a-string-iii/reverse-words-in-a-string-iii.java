class Solution {
    public String reverseWords(String s) {
      String word="";
      s=" "+s;
      int f =0;
      Stack<String> stack = new Stack<>();
        for(int i =s.length()-1;i>=0;i--)
        { 
            if(s.charAt(i) == ' ')
            {
                f++;
                if(f!=1) word+=" ";
                stack.push(word);
                word="";
            }
            else{
                word+=s.charAt(i);
                
            }
        }
    String ans="";
        while(!stack.isEmpty())
        {
           ans += stack.peek();
            stack.pop();
        }

        return ans;
    }
}