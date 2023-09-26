class Solution {

    public String removeDuplicateLetters(String s) {
       boolean alphabetHash[] = new boolean[26];
       int lastIndex[] = new int[26];
       Stack<Integer> stack = new Stack<>();
        

    for(int i=0;i<s.length();i++) lastIndex[s.charAt(i)-97]=i;

    for(int i=0;i<s.length() ;i++)
       {
           char alphabet = s.charAt(i);
           int asciiAlphabet = alphabet - 97;
            if(alphabetHash[asciiAlphabet]) continue;

             while(!stack.isEmpty() && lastIndex[stack.peek()]>i && stack.peek()>asciiAlphabet )
            {
                alphabetHash[stack.peek()]=false;
                stack.pop();
            }
            
            stack.push(asciiAlphabet);
            alphabetHash[asciiAlphabet]=true;
       }
        
       StringBuilder sb = new StringBuilder();
       while(!stack.isEmpty()) 
       {
           sb.append((char)(stack.pop()+97));
        }

       return sb.reverse().toString();

    }
}