class Solution {
    public String simplifyPath(String path) {
        Stack<Character> st = new Stack<>();

        int dotCount = 0;
        for(int i=0;i<path.length();i++)
        {
            if(!st.isEmpty() && st.peek()=='/' && path.charAt(i)=='/')
            { 
                if(dotCount==1) dotCount=0;
                else if(dotCount==2)
                {
                    if(st.size()>1 && st.peek()=='/') 
                    {
                    st.pop();
                    while(st.peek()!='/') st.pop();
                    }
                    dotCount = 0;
                }
                else if(dotCount>2)
                {
                     while(dotCount!=0){st.push('.'); dotCount--;}
                      st.push(path.charAt(i));
                }
                continue;
            }
            else if(path.charAt(i)=='.')dotCount++;
            else
            {
                while(dotCount!=0){st.push('.'); dotCount--;}
                st.push(path.charAt(i));
            }
        }

        if(dotCount>1)
        {
             if(dotCount==2)
                {
                    if(st.size()>1) 
                    {
                    if(st.peek()=='/') 
                    {
                    st.pop();
                    while(st.peek()!='/')st.pop();
                    }
                    else
                    {
                         while(dotCount!=0){st.push('.'); dotCount--;}
                    }
                    dotCount = 0;
                    }
                }
                else
                {
                    while(dotCount!=0){st.push('.'); dotCount--;}
                }
        }

        if(st.size()>1 && st.peek()=='/') st.pop();

        String canonicalPath = "";
        while(!st.isEmpty()) canonicalPath= st.pop()+canonicalPath;

        return canonicalPath;
    }
}

/*
    /a/b/c/d/..
 */